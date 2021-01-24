package com.dtaylor.api.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.InputStream;

@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Document
@NoArgsConstructor
public class Video {
    @Id
    private String id;
    private String title;
    private InputStream stream;
}
