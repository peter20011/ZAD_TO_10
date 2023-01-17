package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
public class GET {

    @GetMapping("/ListEmploy")
    public ResponseEntity<String> getEmployees() {
        List<Employ> table = Table.getInstance().get_employ();
        String response = "";
        for (Employ employ : table) {
            response += employ.getName();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
