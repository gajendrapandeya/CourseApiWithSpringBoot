package com.codermonkeys.springbootstarter.lessons;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//This CrudRepository class provides basic methods like getAllTopics(), getParticularTopic()
//It's generic takes the entity class and the dataType of Id annotated field in @Entity class.
@Repository
public interface LessonRepository extends CrudRepository<Lesson, String> {

	public List<Lesson> findByCourseId(String courseId);
}
