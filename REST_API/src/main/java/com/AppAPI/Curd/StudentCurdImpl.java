package com.AppAPI.Curd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.AppAPI.Curd.StudentCurd;
import com.AppAPI.model.StudentModel;
import com.AppAPI.repository.StudentRepo;

@Service
public class StudentCurdImpl implements StudentCurd{
	
	@Autowired
	StudentRepo studentRepository;
	
	/*to save an student*/
	
	public StudentModel save(StudentModel std) {
		return studentRepository.save(std);
	}
	
	
	/* search all student*/
	@Override
	public List<StudentModel> findAll(){
		return studentRepository.findAll();
	}
	
	
	/*get an student by id*/
	@Override
	public StudentModel findOne(Long stdid) {
		return studentRepository.findById(stdid).orElse(new StudentModel());
	}
	
	
	/*delete an student*/
	@Override
	public void delete(StudentModel std) {
		studentRepository.delete(std);
	}


	@Override
	public StudentModel findById(Long stdid) {
		// TODO Auto-generated method stub
		return studentRepository.findById(stdid).orElse(new StudentModel());
	}
	

}

