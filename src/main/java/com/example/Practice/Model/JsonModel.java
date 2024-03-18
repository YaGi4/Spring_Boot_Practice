package com.example.Practice.Model;

import com.example.Practice.Dto.ApiProductDto;
import lombok.Data;

import java.util.List;
@Data
public class JsonModel
{
    private List<ApiProductDto> products;
    private Integer total;
    private Integer skip;
    private Integer limit;
}
