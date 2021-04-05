package com.xingyun.springbootwithspringwebfluxsample.router;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.xingyun.springbootwithspringwebfluxsample.handler.GreetingHandler.ECHO_HELLO_MESSAGE;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingRouterTest {

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testHello() {
        webTestClient.get().uri("/hello").accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class).isEqualTo(ECHO_HELLO_MESSAGE);
    }
}