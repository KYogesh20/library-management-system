package com.spring2.librarymanagementsystem.Controller;

import com.spring2.librarymanagementsystem.DTO.StudentUpdateEmailRequestDto;
import com.spring2.librarymanagementsystem.DTO.StudentResponseDto;
import com.spring2.librarymanagementsystem.Entity.Student;
import com.spring2.librarymanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "Student has been added";
    }

    @GetMapping("/find_by_email")
    public String findByEmail(@RequestParam("email") String email){
        return studentService.findByEmail(email);
    }

    @PutMapping("/update_email")
    public StudentResponseDto updateEmail(@RequestBody StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
        return studentService.updateEmail(studentUpdateEmailRequestDto);
    }
}
