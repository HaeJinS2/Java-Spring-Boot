package com.fastcampus.admin.repository;

import com.fastcampus.admin.entity.ApplyCourse;
import com.fastcampus.admin.entity.ApplyCourseDetail;
import com.fastcampus.admin.entity.Student;
import com.fastcampus.admin.model.enumclass.StudentStatus;
import com.fastcampus.admin.respository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisplayName("학생 repository 테스트")
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    // TODO Student Entity, Repository 테스트 코드를 작성 하세요
    @Test
//    @Transactional
    public void create(){
        //학생 등록
        String account = "test02";
        String password =  "1234";
        StudentStatus status= StudentStatus.REGISTERED;
        String email= "test@facam.com";
        String phoneNumber= "010-1111-1111";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime unregisteredAt =  LocalDateTime.now();
        LocalDateTime createdAt =  LocalDateTime.now();
        String createdBy= "admin";
        LocalDateTime updatedAt =  LocalDateTime.now();
        String updatedBy = "admin";

        Student student =  new Student();

        student.setAccount(account);
        student.setPassword(password);
        student.setStatus(status);
        student.setEmail(email);
        student.setPhoneNumber(phoneNumber);
        student.setRegisteredAt(registeredAt);
        student.setUnregisteredAt(unregisteredAt);
        student.setCreatedAt(createdAt);
        student.setCreatedBy(createdBy);
        student.setUpdatedAt(updatedAt);
        student.setUpdatedBy(updatedBy);

        Student newStudent = studentRepository.save(student);
        System.out.println(newStudent.getAccount() + "계정 등록 완료");

    }

    @Test
//    @Transactional
    public void read(){
        Optional<Student> student = studentRepository.findById(2L);

        student.ifPresent(selectStudent->{
            System.out.println(" 학생 ID : " + selectStudent.getAccount());
            System.out.println(" 학생 Email : " + selectStudent.getEmail());
        });






    }

    @Test
    @Transactional
    public void update(){
        Optional<Student> student = studentRepository.findById(2L);
        student.ifPresent(selectStudent->{
            selectStudent.setAccount("updateID");
            selectStudent.setUpdatedAt(LocalDateTime.now());
            selectStudent.setUpdatedBy("update method");

            studentRepository.save(selectStudent);

        });
    }

    @Test
    @Transactional
    public void delete(){
        Optional<Student> student = studentRepository.findById(3L);
        student.ifPresent((selectStudent->{
            studentRepository.delete(selectStudent);
        }));

        Optional<Student> deleteStudent = studentRepository.findById(2L);
        if(deleteStudent.isPresent()){
            System.out.println("데이터 존재 : " + deleteStudent.get());
        }else{
            System.out.println("데이터 삭제");
        }

    }

}
