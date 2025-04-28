package app.travel.redisson.base;

import app.travel.redisson.config.RedissonConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.redisson.api.RedissonReactiveClient;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    private final RedissonConfig redissonConfig = new RedissonConfig();

    protected ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    protected RedissonReactiveClient redissonClient;

    @BeforeAll
    public void setClient(){

        this.redissonClient = this.redissonConfig.getRedissonReactiveClient();
    }

    @AfterAll
    public void shutdownClient(){
        this.redissonConfig.shutdown();
    }

}
