package com.AppAPI.Curd;
import java.util.List;

import com.AppAPI.model.StudentModel;



public interface StudentCurd {
	public abstract StudentModel save(StudentModel std);
	
	
	/* search all student*/
	
	public abstract List<StudentModel> findAll();
	
	
	/*get an student by id*/
	public abstract StudentModel findById(Long stdid);
	public abstract StudentModel findOne(Long stdid);
	
	/*delete an student*/
	
	public abstract void delete(StudentModel std);
	
	
}
