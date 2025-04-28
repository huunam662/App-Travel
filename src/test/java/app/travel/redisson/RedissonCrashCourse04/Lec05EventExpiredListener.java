package app.travel.redisson.RedissonCrashCourse04;

import app.travel.redisson.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.redisson.api.ExpiredObjectListener;
import org.redisson.api.RBucketReactive;
import org.redisson.client.codec.StringCodec;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Lec05EventExpiredListener extends BaseTest {
    
    @Test
    public void eventListener() throws InterruptedException {

        RBucketReactive<String> bucket = this.redissonClient.getBucket("user:1:name", StringCodec.INSTANCE);

        Mono<Void> mono = bucket.set("Nam", Duration.ofSeconds(10))
                .then(
                        bucket.get()
                                .doOnNext(System.out::println)
                                .then()
                );

        Mono<Void> event = mono.then(
                bucket.addListener(new ExpiredObjectListener() {
                    @Override
                    public void onExpired(String s) {
                        System.out.println("Expired object: " + s);
                    }
                }).then()
        );

        StepVerifier.create(event)
                .verifyComplete();

        Thread.sleep(15000);
    }
    
}
