package com.codermonkeys.springbootstarter.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	private List<Topic> topicList = new ArrayList<>(
			Arrays.asList(new Topic("1", "Spring Boot Application", "Awseome Tutorial by JavaBrains"),
					new Topic("2", "Android App Development", "Phillip Lackner is awesome"),
					new Topic("3", "Web Development", "Travesy Media is god"),
					new Topic("4", "Js", "Clever Quazi have some good skills")));

	public List<Topic> getAllTopics() {
		// return topicList;

		List<Topic> topics = new ArrayList<>();

		// findAll() returns an Iterable. So looping through it and
		// for each topic adding it to topics
		topicRepository.findAll().forEach(topics::add);

		return topics;
	}

	public Optional<Topic> getTopic(String id) {
		//return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
		
	}

	public void addTopic(Topic topic) {
		// topicList.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {

//		for (int i = 0; i < topicList.size(); i++) {
//			if (topicList.get(i).getId().equals(id)) {
//				topicList.set(i, topic);
//				return;
//			}
//		}
		
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
//		for (int i = 0; i < topicList.size(); i++) {
//			if (topicList.get(i).getId().equals(id)) {
//				topicList.remove(i);
//				return;
//			}
//		}
		
		topicRepository.deleteById(id);
	}
}
