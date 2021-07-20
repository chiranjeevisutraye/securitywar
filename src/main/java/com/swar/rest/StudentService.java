package com.swar.rest;


import javax.xml.ws.Response;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.swar.model.Student;
import com.swar.services.StudentResourceService;

@RestController
@RequestMapping("/students")
public class StudentService {

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Student getStudent(@PathVariable String id) {
        StudentResourceService ss = StudentResourceService.getStudentInstance();
        int sid = Integer.parseInt(id);
        return ss.getStudentById(sid);
    }
    
    @RequestMapping(value="/add", method = RequestMethod.POST, consumes="application/json")
    public void addStudent(@RequestBody Student student) {
    	StudentResourceService ss = StudentResourceService.getStudentInstance();
    	ss.addStudent(student);
    }
}
