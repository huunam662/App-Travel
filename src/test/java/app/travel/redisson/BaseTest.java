package app.travel.redisson;

import app.travel.redisson.config.RedissonConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.redisson.api.RedissonReactiveClient;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    private final RedissonConfig redissonConfig = new RedissonConfig();

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
