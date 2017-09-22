package online.smartcompute.kafkamanagementui.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class KafkaProperties {

	private String zookeeperconnectionstring;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "KafkaProperties [zookeeperconnectionstring=" + zookeeperconnectionstring + "]";
	}

}