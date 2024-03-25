package com.example.Practice.Service;

import com.example.Practice.Dto.ApiProductDto;
import com.example.Practice.Dto.TransactionReportDto;
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

    public void addImageToProduct(TransactionReportDto report, Long productId, List<String> newImages)
    {
        List<Image> oldImagesEntity = imageRepository.findAllByProductId(productId);
        List<String> oldImages = new ArrayList<String>();
        for(int i = 0; i < oldImagesEntity.size(); i++){oldImages.add(oldImagesEntity.get(i).getImageUrl());}
        List<String> general = new ArrayList<String>(oldImages);
        general.retainAll(newImages);
        oldImages.removeAll(newImages);
        newImages.removeAll(general);
        for(int i = 0; i < newImages.size(); i++){
            imageRepository.addImage(newImages.get(i), productId);
            report.setNumberOfAdded(report.getNumberOfAdded() + 1);
        }
        for(int i = 0; i < oldImages.size(); i++)
        {
            imageRepository.deleteImageByUrl(oldImages.get(i));
            report.setNumberOfDeleted(report.getNumberOfDeleted() + 1);
        }
        report.setNumberOfChecked( report.getNumberOfChecked() + general.size() + oldImages.size() + newImages.size());
    }

    public Boolean needToBeUpdated(ApiProductDto apiProductDto, Product entityProduct)
    {
        if(
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

    public TransactionReportDto saveDataInDatabase() throws JsonProcessingException
    {
        TransactionReportDto report = new TransactionReportDto();
        List<ApiProductDto> productsDto = getDataFromApi.getDataFromApi();
        productRepository.setNotAvailable();
        for (ApiProductDto product : productsDto)
        {
            Product thisProductIsFromTheDatabase = productRepository.getProductByOriginalId(product.getId());
            if(thisProductIsFromTheDatabase == null)
            {
                productRepository.addProduct(product.getBrand(), product.getCategory(), product.getDescription(),
                        product.getDiscountPercentage(), product.getId(), product.getPrice(), product.getRating(),
                        product.getStock(), product.getThumbnail(), product.getTitle(), "available");

                report.setNumberOfAdded( report.getNumberOfAdded() + 1 );
                report.setNumberOfChecked( report.getNumberOfChecked() + 1 );
                addImageToProduct(report, product.getId(), product.getImages());
            }
            else
            {
                if(needToBeUpdated(product, thisProductIsFromTheDatabase))
                {
                    productRepository.updateProduct(product.getBrand(), product.getCategory(), product.getDescription(),
                            product.getDiscountPercentage(), product.getId(), product.getPrice(), product.getRating(),
                            product.getStock(), product.getThumbnail(), product.getTitle(), "available");
                    report.setNumberOfChanges( report.getNumberOfChanges() + 1 );
                }
                else
                {
                    productRepository.setAvaliableByOriginalId(product.getId());
                }
                report.setNumberOfChecked( report.getNumberOfChecked() + 1 );

                addImageToProduct(report, product.getId(), product.getImages());
            }

        }
        report.setTransactionStatus(true);
        return report;
    }
}
