package com.spring.boot.rocks.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.boot.rocks.model.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
  Mono<UserDetails> findByUsername(String username);
}
