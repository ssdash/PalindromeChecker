package com.cme.palindromechecker.controller;

import com.cme.palindromechecker.dto.PalindromeDto;
import com.cme.palindromechecker.service.PalindromeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@RestController
@RequestMapping("/api")

public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;

    // Build Palindrome Checker REST API
    @PostMapping("/checkpalindrome")
    public ResponseEntity<String> checkPalindrome(@RequestBody PalindromeDto palindromeDto) {
        String result = palindromeService.palindromeProcessing(palindromeDto);
        return ResponseEntity.ok(result);
    }

    // Build Get All UserName REST API
    @GetMapping("/records")
    public ResponseEntity<List<String>> getAllPalindromeRecords() {

        System.out.println("Gell all records called");
        List<String> list = palindromeService.getAllPalindromeRecords();
        return ResponseEntity.ok(list);
    }
}
