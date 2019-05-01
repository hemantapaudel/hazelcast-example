package hazelcastcache.server;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfiguration {

    @Bean
    public Config config(){
        Config config = new Config();
        config.getNetworkConfig().setPort( 5900 )
                .setPortAutoIncrement( true ).setPortCount(20);
        config.getGroupConfig().setName("cache").setPassword("research-cache");

        return config;
    }

    @Bean
    public HazelcastInstance hzInstance1(Config config){
        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public HazelcastInstance hzInstance2(Config config){
        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public HazelcastInstance hzInstance3(Config config){
        return Hazelcast.newHazelcastInstance(config);
    }
}
