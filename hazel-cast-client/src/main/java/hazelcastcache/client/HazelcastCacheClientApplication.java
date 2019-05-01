package hazelcastcache.client;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

@SpringBootApplication
public class HazelcastCacheClientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(HazelcastCacheClientApplication.class, args);

		long index=20;
		while(true) {
			HazelcastInstance hzClient = applicationContext.getBean("hzClient", HazelcastInstance.class);

			IMap<Long, String> customer = hzClient.getMap("data");
			System.out.println("========customer === : " + customer.size());
			for (long i = 20; i < 40; i++) {
				customer.put(index++, "message" + i);
			}
			System.out.println("=========20 documents store in hz");


			IMap<Long, String> map = hzClient.getMap("data");
			System.out.println("=========map size  :" + map.size());
			{
				for (Map.Entry<Long, String> entry : map.entrySet()) {
					System.out.println("key :" + entry.getKey() + "  value = " + entry.getValue());
				}
			}

			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
