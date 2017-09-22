package online.smartcompute.kafkamanagementui.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.smartcompute.kafkamanagementui.config.KafkaProperties;
import online.smartcompute.kafkamanagementui.model.TopicData;

/**
 * 
 * @author masud
 *
 */
@Service
public class TopicService {

	@Autowired
	private KafkaProperties kafkaProperties;

	/**
	 * 
	 * @param zookeeperConnectString
	 * @return
	 */
	public List<TopicData> getListTopics() {
		String zookeeperConnectString = "localhost:2181";
		if (zookeeperConnectString == null || zookeeperConnectString.trim().length() == 0) {
			return Arrays.asList();
		}
		ZooKeeper zk = null;
		try {
			zk = new ZooKeeper(zookeeperConnectString, 10000, null);
			List<String> topics = zk.getChildren("/brokers/topics", false);
			List<TopicData> topicList = topics.stream().map(e -> {
				TopicData t1 = new TopicData();
				t1.setName(e);
				return t1;
			}).collect(Collectors.toList());
			topicList.sort((t1, t2) -> t1.getName().compareTo(t2.getName()));
			return topicList;
		} catch (IOException | KeeperException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Arrays.asList();
	}

}
