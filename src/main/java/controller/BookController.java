package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repo.BookRepo;
import model.Books;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepo bRepo;

    @PostMapping("/addBooks")
    public ResponseEntity<Books> addStudent(@RequestBody Books books){
        Books  Sobj=  bRepo.save(books);
        return new ResponseEntity<>(Sobj, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Books>> getAllStudents(){
        try{
            List<Books> bookList=new ArrayList<>();
            bRepo.findAll().forEach(bookList::add);
            if(bookList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
