package com.teksystems.springboot.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teksystems.springboot.database.entity.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Long> {
	
	@Query("select s from Student s where s.first_name like %:name%")
	public List<Student> findByFirst_name(String name);

}