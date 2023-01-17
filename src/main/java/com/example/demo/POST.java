package com.example.demo;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class POST {
    @PostMapping("/NewEmploy")
    public ResponseEntity<String> postEmploy(@RequestBody String name,
                                             String surname, String data){

        Table.getInstance().add_employ(new Employ(name,surname,data));
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
