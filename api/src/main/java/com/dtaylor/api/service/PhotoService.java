package com.dtaylor.api.service;

import com.dtaylor.api.domain.Photo;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
public class PhotoService {
    final
    ReactiveMongoTemplate template;

    public PhotoService(ReactiveMongoTemplate template) {
        this.template = template;
    }

    public Mono<Photo> getPhoto(String id) {
        return template.findById(id, Photo.class);
    }

    public Flux<Photo> findAll() {
        return template.findAll(Photo.class);
    }

    private Mono<Photo> save(Mono<Photo> account) {
        return template.save(account);
    }

    public String addPhoto(String title, MultipartFile file) throws IOException {
        Photo photo = new Photo(title);
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        template.save(photo);
        return photo.getId();
    }
}
