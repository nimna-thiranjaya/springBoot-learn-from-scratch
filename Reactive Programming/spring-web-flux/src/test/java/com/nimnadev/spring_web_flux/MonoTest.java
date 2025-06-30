package com.nimnadev.spring_web_flux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoTest {
    @Test
    public void MonoTest(){
        Mono <?> monoString = Mono.just("Nimna Thiranjaya")
                .then(Mono.error(new RuntimeException("Error")))
                .log();
        monoString.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }

    @Test
    public void TestFlux(){
        Flux<String> fluxString = Flux.just("Nimna", "Thiranjaya", "Welivita")
                .concatWithValues("Hello", "World")
                .concatWith(Flux.error(new RuntimeException("Error")))
                .concatWithValues("Arimac")
                .log();
        fluxString.subscribe(System.out::println,(e) -> System.out.println(e.getMessage()));
    }
}
