package hazelcastcache.server;


import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;


@SpringBootApplication
public class HazelcastCacheServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(HazelcastCacheServerApplication.class, args);


		HazelcastInstance hzInstance1 = applicationContext.getBean("hzInstance1", HazelcastInstance.class);

		IMap<Long, String> customer = hzInstance1.getMap("data");
		for (long i = 0; i < 20; i++) {
			customer.put(i, "message" + i);
		}
		System.out.println("=========20 documents store in hz");





	}

}
