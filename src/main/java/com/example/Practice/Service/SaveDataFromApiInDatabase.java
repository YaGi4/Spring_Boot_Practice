package com.example.Practice.Service;

import com.example.Practice.Dto.ApiProductDto;
import com.example.Practice.Entity.Image;
import com.example.Practice.Entity.Product;
import com.example.Practice.Repository.ImageRepository;
import com.example.Practice.Repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class SaveDataFromApiInDatabase {

    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;
    private final GetDataFromApi getDataFromApi;

    public Boolean needToBeUpdated(ApiProductDto apiProductDto, Product entityProduct) {
        if (
                Objects.equals(apiProductDto.getBrand(), entityProduct.getBrand()) &&
                        Objects.equals(apiProductDto.getCategory(), entityProduct.getCategory()) &&
                        Objects.equals(apiProductDto.getDescription(), entityProduct.getDescription()) &&
                        Objects.equals(apiProductDto.getDiscountPercentage(), entityProduct.getDiscountPercentage()) &&
                        Objects.equals(apiProductDto.getId(), entityProduct.getOriginalId()) &&
                        Objects.equals(apiProductDto.getPrice(), entityProduct.getPrice()) &&
                        Objects.equals(apiProductDto.getRating(), entityProduct.getRating()) &&
                        Objects.equals(apiProductDto.getStock(), entityProduct.getStock()) &&
                        Objects.equals(apiProductDto.getThumbnail(), entityProduct.getThumbnail()) &&
                        Objects.equals(apiProductDto.getTitle(), entityProduct.getTitle()))
            return false;
        else return true;
    }

    public Product findEntityProductByOriginalId(Long id, List<Product> products) {
        for(Product product : products) {
            if(product.getOriginalId().equals(id)){
                return product;
            }
        }
        return null;
    }

    public ApiProductDto findApiProductByOriginalId(Long id, List<ApiProductDto> products){
        for(ApiProductDto product : products){
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }
    public boolean doesTheImageExistInApiList(Long productId, String image, List<Image> imagesEntity){
        for (Image imageEntity : imagesEntity){
            if(imageEntity.getImageUrl().equals(image) && imageEntity.getProductId().getOriginalId().equals(productId)){
                return true;
            }
        }
        return false;
    }
    public boolean doesTheImageExistInEntityList(Image image, List<Image> imagesApi){
        for (Image imageApi : imagesApi){
            if(imageApi.getImageUrl().equals(image.getImageUrl()) &&
                    imageApi.getProductId().getOriginalId().equals(image.getProductId().getOriginalId())){
                return true;
            }
        }
        return false;
    }

    public void saveDataInDatabase() throws JsonProcessingException {
        List<ApiProductDto> productsDto = getDataFromApi.getDataFromApi();
        List<Product> productsEntityList =  productRepository.getAll();
        List<Image> ImagesEntity = imageRepository.findAll();

        List<Product> listOfProductsToAdd = new ArrayList<>();
        List<Image> listOfImagesToDelete = new ArrayList<>();
        List<Image> listOfImagesToAdd = new ArrayList<>();
        List<Image> allImages = new ArrayList<>();

        for(ApiProductDto productDto : productsDto) {
            Product entityProduct = findEntityProductByOriginalId(productDto.getId(), productsEntityList);
            Product product = new Product(null, productDto.getId(), productDto.getTitle(),
                    productDto.getDescription(), productDto.getPrice(), productDto.getDiscountPercentage(),
                    productDto.getRating(), productDto.getStock(), productDto.getBrand(), productDto.getCategory(),
                    productDto.getThumbnail(), "available", null);
            if(entityProduct != null){
                product.setId(entityProduct.getId());
                if(needToBeUpdated(productDto, entityProduct)){
                    listOfProductsToAdd.add(product);
                }
            }
            else listOfProductsToAdd.add(product);
            for (String image : productDto.getImages()){
                if(!doesTheImageExistInApiList(productDto.getId(), image, ImagesEntity)){
                    listOfImagesToAdd.add(new Image(null, product, image));
                }
            allImages.add(new Image(null, product, image));
            }
        }

        for(Product productEntity : productsEntityList){
            ApiProductDto ApiProduct = findApiProductByOriginalId(productEntity.getOriginalId(), productsDto);
            if(ApiProduct == null){
                productEntity.setStatus("not Available");
                listOfProductsToAdd.add(productEntity);
            }
        }

        for(Image ImageEntity : ImagesEntity){
            if(!doesTheImageExistInEntityList(ImageEntity, allImages)){
                listOfImagesToDelete.add(ImageEntity);
            }
        }

        productRepository.saveAll(listOfProductsToAdd);
        imageRepository.saveAll(listOfImagesToAdd);
        imageRepository.deleteAll(listOfImagesToDelete);
    }
}
