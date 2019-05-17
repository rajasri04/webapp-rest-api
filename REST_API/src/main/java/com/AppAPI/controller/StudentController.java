package com.AppAPI.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppAPI.Curd.StudentCurd;
import com.AppAPI.model.StudentModel;

@ComponentScan
@RestController
@RequestMapping("/collage")
@EnableAutoConfiguration
public class StudentController {
	
	@Autowired
	StudentCurd studentCurd;
	
	/* to save an Student*/
	@PostMapping("/students")
	public StudentModel createStudent(@Valid @RequestBody StudentModel std) {
		return studentCurd.save(std);
	}
	
	/*get all Students*/
	@GetMapping("/students")
	public List<StudentModel> getAllStudents(){
		return studentCurd.findAll();
	}
	
	/*get Student by stdid*/
	@GetMapping("/students/{id}")
	public ResponseEntity<StudentModel> getStudentById(@PathVariable(value="id") Long stdid){
		
		StudentModel std=studentCurd.findOne(stdid);
		
		if(std==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(std);
		
	}
	
	
	/*update an Student by stdid*/
	@PutMapping("/students/{id}")
	public ResponseEntity<StudentModel> updateStudent(@PathVariable(value="id") Long stdid,@Valid @RequestBody StudentModel stdDetails){
		
		StudentModel std=studentCurd.findOne(stdid);
		if(std==null) {
			return ResponseEntity.notFound().build();
		}
		
		std.setName(stdDetails.getName());
		std.setDepartment(stdDetails.getDepartment());
		std.setTechnology(stdDetails.getTechnology());
		
		StudentModel updateStudent=studentCurd.save(std);
		return ResponseEntity.ok().body(updateStudent);
		
		
		
	}
	
	/*Delete an Student*/
	@DeleteMapping("/students/{id}")
	public ResponseEntity<StudentModel> deleteStudent(@PathVariable(value="id") Long stdid){
		
		StudentModel emp=studentCurd.findOne(stdid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		studentCurd.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}