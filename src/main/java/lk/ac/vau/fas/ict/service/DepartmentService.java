package lk.ac.vau.fas.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.persistence.EntityNotFoundException;
import lk.ac.vau.fas.ict.model.Department;
import lk.ac.vau.fas.ict.repo.DepartmentRepo;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo repo;
	
	public List<Department> getDept()
	{
		return repo.findAll();
	}
    
	public Department getDept(@PathVariable("id") int id) {
		if(repo.findById(id).isEmpty())
		{
			throw new EntityNotFoundException("Department Not Found");
		}
		return repo.findById(id).get();
	}

	public Department saveDept(Department dept) {
    return repo.save(dept);
    }


}
