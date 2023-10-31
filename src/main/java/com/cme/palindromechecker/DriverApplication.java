package com.cme.palindromechecker;

import com.cme.palindromechecker.dto.PalindromeDto;
import com.cme.palindromechecker.repsoitory.PalindromeRepository;
import com.cme.palindromechecker.repsoitory.PalindromeRepositoryImpl;
import com.cme.palindromechecker.service.PalindromeService;
import com.cme.palindromechecker.service.PalindromeServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverApplication {
    public static void main(String[] args) {

        // Initialize PalindromeRepository
        PalindromeRepository palindromeRepository = new PalindromeRepositoryImpl();

        // Initialize PalindromeService
        PalindromeService palindromeService = new PalindromeServiceImpl(palindromeRepository);

        // Test cases
        PalindromeDto validDto = new PalindromeDto("user", "kayak");
        PalindromeDto invalidDto = new PalindromeDto("user", "hello world");
        PalindromeDto invalidDtoWithNumber = new PalindromeDto("user", "hello123");

        // Test valid palindrome - Output: "madam is Palindrome."
        System.out.println(palindromeService.palindromeProcessing(validDto));

        // Test invalid input with space - Output: Invalid input
        System.out.println(palindromeService.palindromeProcessing(invalidDto));

        // Test invalid input with number - Output: Invalid input
        System.out.println(palindromeService.palindromeProcessing(invalidDtoWithNumber));

        // Test reading data from storage
        System.out.println("Palindromes stored in storage:");
        List<String> storedPalindromes = palindromeService.getAllPalindromeRecords();
        storedPalindromes.forEach(System.out::println);

        // Test writing data to storage
        Map<String, String> dataToStore = new HashMap<>();
        dataToStore.put("john", "Doe");
        dataToStore.put("James", "Bond");
        palindromeRepository.writeDataToStorage(dataToStore);

        // Test reading data from storage after writing
        System.out.println("Palindromes stored in storage after writing new data:");
        storedPalindromes = palindromeService.getAllPalindromeRecords();
        storedPalindromes.forEach(System.out::println);
    }
}
