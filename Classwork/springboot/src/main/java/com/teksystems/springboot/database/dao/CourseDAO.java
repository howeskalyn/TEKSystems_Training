package com.teksystems.springboot.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teksystems.springboot.database.entity.Course;

@Repository
public interface CourseDAO extends JpaRepository<Course, Long> {
	
	@Query("select c from Course c where c.name = :name")
	public List<Course> findByCourseName(String name);
	
	public List<Course> findByNameContainingIgnoreCaseOrderByNameDesc(String name);
	
	public Course findByNameAndId(String name, Integer Id);
	
	public List<Course> findByInstructorContainingIgnoreCase(String name);
	
//	@Query("select c from Course c where c.name like %:name% or c.instructor like %:instructor")
//	public List<Course> findByNameOrInstructor(String name, String instructor);
	
	// Eric's
	public List<Course> findByNameOrInstructor(String name, String instructor);
	

}