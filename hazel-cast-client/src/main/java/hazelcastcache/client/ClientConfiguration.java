package hazelcastcache.client;




import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ClientConfiguration {

    @Bean("hzClient")
    HazelcastInstance hzClient() {

        ClientConfig config = new ClientConfig();
        List addresses = new ArrayList();
        addresses.add("127.0.0.1:5900");
        config.getNetworkConfig().setAddresses(addresses);
        config.getGroupConfig().setName("cache").setPassword("research-cache");
        HazelcastInstance hzClient
                = HazelcastClient.newHazelcastClient(config);
        return hzClient;
    }
}
