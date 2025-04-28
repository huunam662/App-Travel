package app.travel.redisson.RedissonCrashCourse04;

import app.travel.redisson.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBucketReactive;
import org.redisson.client.codec.StringCodec;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Lec01KeyValueTest extends BaseTest {

    @Test
    public void keyValueAccessTest(){

        RBucketReactive<String> bucket = this.redissonClient.getBucket("user:1:name", StringCodec.INSTANCE);

        Mono<Void> testFlow = bucket.set("Nam", Duration.ofSeconds(10))
                        .then(
                                bucket.get()
                                        .doOnNext(System.out::println)
                                        .then()
                        );

        StepVerifier.create(testFlow)
                .verifyComplete();
    }

}
