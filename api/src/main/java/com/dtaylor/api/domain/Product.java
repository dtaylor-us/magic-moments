package com.dtaylor.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Document
public class Product {

    @Id
    private String id;

    private String name;

    private Double price;

}
