package app.travel.redisson.RedissonCrashCourse04;

import app.travel.redisson.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.redisson.api.DeletedObjectListener;
import org.redisson.api.RBucketReactive;
import org.redisson.client.codec.StringCodec;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Lec06EventDeletedListener extends BaseTest {

    @Test
    public void eventDeletedTest() throws InterruptedException {

        RBucketReactive<String> bucket = this.redissonClient.getBucket("user:1:name", StringCodec.INSTANCE);

        Mono<Void> mono = bucket.set("Nam")
                .then(
                        bucket.get()
                                .doOnNext(System.out::println)
                                .then()
                );

        Mono<Void> event = mono.then(
                bucket.addListener(new DeletedObjectListener() {
                    @Override
                    public void onDeleted(String s) {
                        System.out.println("Deleted Object: " + s);
                    }
                }).then()
        );

        StepVerifier.create(event)
                .verifyComplete();

        Thread.sleep(10000);

    }

}
