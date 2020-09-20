package com.codermonkeys.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//This CrudRepository class provides basic methods like getAllTopics(), getParticularTopic()
//It's generic takes the entity class and the dataType of Id annotated field in @Entity class.
@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

	public List<Course> findByTopicId(String topicId);
}
