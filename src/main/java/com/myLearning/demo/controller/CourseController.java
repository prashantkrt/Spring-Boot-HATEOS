package com.myLearning.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myLearning.demo.pojo.Course;

@RestController
@RequestMapping("/course")
public class CourseController {

	@GetMapping("/getCourse/{id}")
	public Course getCourse(@PathVariable("id") Integer id) {
		Course course = new Course(1, "Java", 1299.00, "Hyderabad", "Online");
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class)
				.getAllCourse()).withRel("getAllCourse");
		course.add(link);
		return course;
	}

	@GetMapping("/getAllCourse")
	public ResponseEntity<List<Course>> getAllCourse() {

		Course course1 = new Course(1, "Java", 1299.00, "Hyderabad", "Online");
		Link link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class)
				.getCourse(1)).withRel("getCourse");
		course1.add(link1);
		Course course2 = new Course(2, "Devops", 2299.00, "Hyderabad", "Online");
		Link link2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class)
				.getCourse(2)).withRel("getCourse");
		course2.add(link2);
		Course course3 = new Course(3, "C#", 1399.00, "Bangaluru", "offline");
		Link link3 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class)
				.getCourse(3)).withRel("getCourse");
		course3.add(link3);
		Course course4 = new Course(4, "Python", 1299.00, "Hyderabad", "Online");
		Link link4 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class)
				.getCourse(4)).withRel("getCourse");
		course4.add(link4);
		Course course5 = new Course(5, "ReactJS", 1299.00, "Hyderabad", "offline");
		Link link5 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class)
				.getCourse(5)).withRel("getCourse");
		course5.add(link5);

		List<Course> list = new ArrayList<>();

		list.add(course1);
		list.add(course2);
		list.add(course3);
		list.add(course4);
		list.add(course5);

		return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
	}

}
