package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import model.Students;
import repo.StudentsRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentsRepo sRepo;

    @PostMapping("/addStudent")
    public ResponseEntity<Students> addStudent(@RequestBody Students students){
    Students  Sobj=  sRepo.save(students);
    return new ResponseEntity<>(Sobj,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Students>> getAllStudents(){
        try{
           List<Students> bookList=new ArrayList<>();
           sRepo.findAll().forEach(bookList::add);
           if(bookList.isEmpty()){
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }

           return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
