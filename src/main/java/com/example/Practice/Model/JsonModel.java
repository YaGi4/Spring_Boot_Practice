package com.example.Practice.Model;

import com.example.Practice.Dto.ProductDto;
import lombok.Data;

import java.util.List;
@Data
public class JsonModel
{
    private List<ProductDto> products;
    private Integer total;
    private Integer skip;
    private Integer limit;
}
