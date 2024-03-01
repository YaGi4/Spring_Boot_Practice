package com.example.Practice.Model;

import lombok.Data;

import java.util.List;
@Data
public class JsonModel
{
    private List<Product> products;
    private Integer total;
    private Integer skip;
    private Integer limit;
}
