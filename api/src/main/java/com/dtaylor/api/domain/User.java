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
@Document(collection = "users")
public class User {

    @Id
    private long id;

    private String firstName;

    private String lastName;

    private String email;

}
