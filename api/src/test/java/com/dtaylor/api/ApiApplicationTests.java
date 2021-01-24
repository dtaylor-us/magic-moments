package com.dtaylor.api;

import com.dtaylor.api.domain.Account;
import com.dtaylor.api.repository.AccountRepository;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration"})
public class ApiApplicationTests {

    @Autowired
    AccountRepository repository;

    @Autowired
    ReactiveMongoTemplate template;

    final static String TEST_OWNER = "test";

    @Test
    void contextLoads() {
    }

    @After
    public void cleanup() {
        template.dropCollection("account");
    }

    @Test
    public void givenOwner_whenFindFirstByOwner_thenFindAccount() {
        template.dropCollection("account");

        repository.save(new Account(null, TEST_OWNER, 12.3)).block();
        Mono<Account> accountMono = repository
                .findFirstByOwner(Mono.just(TEST_OWNER));

        StepVerifier
                .create(accountMono)
                .assertNext(account -> {
                    assertEquals(TEST_OWNER, account.getOwner());
                    assertEquals(Double.valueOf(12.3), account.getValue());
                    assertNotNull(account.getId());
                })
                .expectComplete()
                .verify();
    }

    @Test
    public void givenAccount_whenSave_thenSaveAccount() {
        Mono<Account> accountMono = repository.save(new Account(null, TEST_OWNER, 12.3));

        StepVerifier
                .create(accountMono)
                .assertNext(account -> assertNotNull(account.getId()))
                .expectComplete()
                .verify();
    }
}
