package com.spring2.librarymanagementsystem.Service;

import com.spring2.librarymanagementsystem.DTO.StudentUpdateEmailRequestDto;
import com.spring2.librarymanagementsystem.DTO.StudentResponseDto;
import com.spring2.librarymanagementsystem.Entity.LibraryCard;
import com.spring2.librarymanagementsystem.Entity.Student;
import com.spring2.librarymanagementsystem.Enum.CardStatus;
import com.spring2.librarymanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        //set the value of card
        LibraryCard card = new LibraryCard();
        card.setStatus(CardStatus.ACTIVATED);
        card.setValidTill("03/2025");
        card.setStudent(student);
        student.setCard(card);
    }

    public String findByEmail(String email){
        Student student = studentRepository.findByEmail(email);
        return student.getName();
    }

    public StudentResponseDto updateEmail(StudentUpdateEmailRequestDto studentUpdateMobRequestDto){
        Student student = studentRepository.findById(studentUpdateMobRequestDto.getId()).get();

        student.setEmail(studentUpdateMobRequestDto.getEmail());

        Student updatedStudent = studentRepository.save(student);

        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(updatedStudent.getId());
        studentResponseDto.setName(updatedStudent.getName());
        studentResponseDto.setEmail(updatedStudent.getEmail());

        return studentResponseDto;
    }
}
