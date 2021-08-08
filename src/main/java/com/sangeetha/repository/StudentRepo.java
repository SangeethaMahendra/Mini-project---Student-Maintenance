package com.sangeetha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sangeetha.entity.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
