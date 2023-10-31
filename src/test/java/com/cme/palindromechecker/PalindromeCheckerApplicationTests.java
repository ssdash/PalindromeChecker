package com.cme.palindromechecker;

import com.cme.palindromechecker.controller.PalindromeController;
import com.cme.palindromechecker.dto.PalindromeDto;
import com.cme.palindromechecker.repsoitory.PalindromeRepository;
import com.cme.palindromechecker.service.PalindromeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PalindromeCheckerApplicationTests {

    @Mock
    private PalindromeRepository palindromeRepository;

    @InjectMocks
    private PalindromeServiceImpl palindromeService;

    @InjectMocks
    private PalindromeController palindromeController;

    @Test
    void testValidPalindrome() {
        PalindromeDto palindromeDto = new PalindromeDto("user", "kayak");
        when(palindromeRepository.readDataFromStorage()).thenReturn(Collections.emptyList());

        // Create the expected map
        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("user", "kayak");

        // Stub method
        doNothing().when(palindromeRepository).writeDataToStorage(expectedMap);

        String result = palindromeService.palindromeProcessing(palindromeDto);

        assertEquals("kayak is Palindrome.", result);

        // verify that the expected map is passed to writeDataToStorage
        // verify(palindromeRepository, times(1)).writeDataToStorage(expectedMap);
    }
}
