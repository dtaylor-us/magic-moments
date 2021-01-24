package com.dtaylor.api.repository;

import com.dtaylor.api.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepo extends ReactiveMongoRepository<User, Long> {

}
