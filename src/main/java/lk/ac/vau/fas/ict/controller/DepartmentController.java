package lk.ac.vau.fas.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    private DepartmentRepo repo;

    @GetMapping
    public List getDeptsl(){
        return repo.findAll();
    }
    @GetMapping("/{id}")
    public Department getDept(@PathVariable("id") int id){
        return repo.findById(id).get();
    }

    @PostMapping
    public String addDept(@RequestBody Department department){
        repo.save(department);
        return "New Department Added";
    }

    @PutMapping("/{id}")
    public String updateDept(@PathVariable("id") int id,@RequestBody Department department){
        if(repo.findById(id).isEmpty()){
            return "Couldn't find the department";
        }
        repo.save(department);
        return "Department Details Updated";
    }


	/*@GetMapping("/{id}")
    public ResponseEntity<List<Department>>getDepts(){
		return new ResponseEntity<List<Department>>(service.getDeptsl(),httpsStatus.Ok)
	}*/
}
