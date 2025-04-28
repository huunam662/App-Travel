package app.travel.redisson.RedissonCrashCourse04;

import app.travel.redisson.base.BaseTest;
import app.travel.redisson.payload.Student;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBucketReactive;
import org.redisson.codec.TypedJsonJacksonCodec;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

public class Lec02KeyValueTest extends BaseTest {

    @Test
    public void lec02KeyValueTest(){

        RBucketReactive<Student> bucket = this.redissonClient.getBucket("student:1", new TypedJsonJacksonCodec(Student.class, this.mapper));

        Student student = new Student("Nam", 10, "TP.HCM", OffsetDateTime.now(ZoneId.systemDefault()), List.of(1, 2, 3));

        Mono<Void> testFlow = bucket.set(student)
                .then(
                    bucket.get()
                            .doOnNext(System.out::println)
                            .then()
                );

        StepVerifier.create(testFlow)
                .verifyComplete();
    }

}
