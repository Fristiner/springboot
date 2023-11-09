package com.ma.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;

}
