package com.codermonkeys.springbootstarter.lessons;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codermonkeys.springbootstarter.course.Course;
import com.codermonkeys.springbootstarter.topics.Topic;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	

	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllLesson(@PathVariable String courseId) {
		return lessonService.getAllLessons(courseId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public Optional<Lesson> getLesson(@PathVariable String id) {
		return lessonService.getLesson(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addCourse(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
		lesson.setTopic(new Topic(topicId, "", ""));
		lesson.setCourse(new Course(courseId, "", "", topicId));
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void updateCourse(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId, @PathVariable String lessonId) {
		lesson.setTopic(new Topic(topicId, "", ""));
		lesson.setCourse(new Course(courseId, "", "", topicId));
		lessonService.updateLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void deleteTopic( @PathVariable String id) {
		lessonService.deleteLesson(id);
	}
}
