package com.myLearning.demo.pojo;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course extends RepresentationModel {
	private Integer id;
	private String name;
	private Double price;
	private String instituteName;
	private String modeOfLearning;
}
