package com.example.Practice.Service;

import com.example.Practice.Dto.ImageDto;
import com.example.Practice.Dto.ShortProductDto;
import com.example.Practice.Entity.Image;
import com.example.Practice.Entity.Product;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ConvertProductEntityToDto {

    public static List<ShortProductDto> convert(List<Product> products)
    {
        ModelMapper mapper = new ModelMapper();
        List<ShortProductDto> productDto = new ArrayList<>();
        for(Product product : products )
        {
            ShortProductDto productToSave = mapper.map(product, ShortProductDto.class);
            for (Image image : product.getImages())
            {
                productToSave.addImage(mapper.map(image, ImageDto.class));
            }
            productDto.add(productToSave);
        }
        return productDto;
    }

}
