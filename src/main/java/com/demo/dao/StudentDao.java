package com.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

	public Optional<Student> findByName(String name);

}
