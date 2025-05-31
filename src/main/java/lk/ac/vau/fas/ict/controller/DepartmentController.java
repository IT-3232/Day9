package lk.ac.vau.fas.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Department;
import lk.ac.vau.fas.ict.repo.DepartmentRepo;
import lk.ac.vau.fas.ict.service.DepartmentService;


@RestController
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

   

   @GetMapping
   public ResponseEntity<List<Department>>getDepts(){
        return new ResponseEntity<List<Department>>
        (service.getDept(),HttpStatus.OK);
   }


   @GetMapping("/{id}")
	public ResponseEntity<Department> getDept(@PathVariable("id") int id) {
		return new ResponseEntity<Department>(service.getDept(id),HttpStatus.OK);
	}
   
    @PostMapping("/save")
    public ResponseEntity<String> addDept(@RequestBody Department department) {
    service.saveDept(department);
    return new ResponseEntity<>("New department added", HttpStatus.CREATED);
   }

  @PutMapping("/{id}")
public ResponseEntity<String> updateDept(@PathVariable("id") int id, @RequestBody Department department) {
    // Check if department with given id exists
    if (service.getDepts(id) == null) {
        return new ResponseEntity<>("Couldn't find the department", HttpStatus.NOT_FOUND);
    }
    department.setId(id);
    
    service.saveDept(department);
    
    return new ResponseEntity<>("The department updated", HttpStatus.OK);
}


   
}
