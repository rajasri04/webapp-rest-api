package com.AppAPI.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.AppAPI.model.StudentModel;

public interface StudentRepo extends JpaRepository<StudentModel, Long> {

}
