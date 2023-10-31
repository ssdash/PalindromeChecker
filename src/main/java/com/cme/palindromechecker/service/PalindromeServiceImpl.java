package com.cme.palindromechecker.service;

import com.cme.palindromechecker.dto.PalindromeDto;
import com.cme.palindromechecker.exception.InvalidInputException;
import com.cme.palindromechecker.repsoitory.PalindromeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class PalindromeServiceImpl implements PalindromeService {
    private static final Logger LOGGER = Logger.getLogger(PalindromeServiceImpl.class.getName());
    @Autowired
    private final PalindromeRepository palindromeRepository;

    // Process user input string for palindrome checking
    @Override
    public String palindromeProcessing(PalindromeDto palindromeDto) {
        // Validate input and reject if invalid
        String userName = palindromeDto.getUserName();
        String validToken = palindromeDto.getPalindromeToken();
        Map<String, String> cachedMapDataToStorage = new HashMap<>();
        try {
            if (isValid(palindromeDto)) {
                LOGGER.log(Level.INFO, "Invalid input...");
                throw new InvalidInputException("Invalid input...");
            }
            // Check if input is palindrome
            boolean validPalindrome = isPalindrome(validToken);

            if (validPalindrome) {
                cachedMapDataToStorage.put(userName, validToken);
                palindromeRepository.writeDataToStorage(cachedMapDataToStorage);
                return validToken + " is Palindrome.";
            } else {
                return validToken + " is not a Palindrome.";
            }
        } catch (InvalidInputException invalidInputException) {
            invalidInputException.printStackTrace();
            return "Invalid input...";
        }
    }

    // Validate for any invalid input
    boolean isValid(PalindromeDto palindromeDto) {
        String userName = palindromeDto.getUserName();
        String token = palindromeDto.getPalindromeToken();
        System.out.println(userName + " " + token);

        return (userName == null || userName.contains(" ")
                || token == null || token.contains(" ")
                || token.length() == 1
                // Checks for the presence of digits in the token
                // "Hello123" - TRUE
                // "Hello 113 World" - TRUE
                || token.matches(".*\\d.*"));
    }

    // Check for palindrome
    boolean isPalindrome(String token) {
        String cleanedData = token.replaceAll("\\s", "").toLowerCase();
        int left = 0, right = cleanedData.length() - 1;
        while (left < right) {
            if (cleanedData.charAt(left) != cleanedData.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        LOGGER.log(Level.INFO, token + " is a palindrome.");
        return true;
    }

    @Override
    public List<String> getAllPalindromeRecords() {
        return palindromeRepository.readDataFromStorage();
    }
}
