package online.smartcompute.kafkamanagementui.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import online.smartcompute.kafkamanagementui.model.TopicData;
import online.smartcompute.kafkamanagementui.service.TopicService;

@RestController
@RequestMapping("/rest")
class KafkaTopicRestController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(value = "/topics", method = RequestMethod.GET, produces = "application/json")
	public List<TopicData> getTopicList() {
		return topicService.getListTopics();
	}

}
