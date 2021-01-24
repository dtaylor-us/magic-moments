package com.dtaylor.api.repository;

import com.dtaylor.api.domain.Photo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PhotoRepo extends ReactiveMongoRepository<Photo, String> {
}
