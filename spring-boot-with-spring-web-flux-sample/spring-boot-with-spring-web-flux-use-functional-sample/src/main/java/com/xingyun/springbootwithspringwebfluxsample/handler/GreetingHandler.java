package com.xingyun.springbootwithspringwebfluxsample.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author qing-feng.zhao
 */
@Component
public class GreetingHandler {

    public static final String ECHO_HELLO_MESSAGE="Hello World, Spring!";

    public Mono<ServerResponse> hello(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue(ECHO_HELLO_MESSAGE));
    }
}
