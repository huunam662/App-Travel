package app.travel.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.config.Config;

public class RedissonConfig {

    RedissonClient redissonClient;

    public RedissonClient getRedissonClient() {

        if(this.redissonClient == null){

            Config config = new Config();
            config.useSingleServer()
                    .setAddress("redis://127.0.0.1:6379");

            this.redissonClient = Redisson.create(config);
        }

        return this.redissonClient;
    }

    public RedissonReactiveClient getRedissonReactiveClient() {

        return getRedissonClient().reactive();
    }

    public void shutdown(){

        if(!this.redissonClient.isShutdown())
            this.redissonClient.shutdown();
    }

}
