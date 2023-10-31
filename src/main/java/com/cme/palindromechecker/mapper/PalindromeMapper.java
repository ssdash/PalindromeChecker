package com.cme.palindromechecker.mapper;

import com.cme.palindromechecker.dto.PalindromeDto;
import com.cme.palindromechecker.entity.Palindrome;

public class PalindromeMapper {
    // This Mapper is being created for Domain entity to User type.
    public static PalindromeDto mapToPalindromeDto(Palindrome palindrome) {
        String userName = palindrome.getUserName();
        String token = palindrome.getPalindromeToken();
        System.out.println("mapToPalindromeDto() called " + userName + " " + token);
        return new PalindromeDto(
                palindrome.getUserName(),
                palindrome.getPalindromeToken()
        );
    }
    // This Mapper is being created for DTO to Domain entity type to User type
    public static Palindrome mapToPalindrome(PalindromeDto palindromeDto) {
        String userName = palindromeDto.getUserName();
        String token = palindromeDto.getPalindromeToken();
        System.out.println("mapToPalindrome() called " + userName + " " + token);
        return new Palindrome(
                palindromeDto.getUserName(),
                palindromeDto.getPalindromeToken()
        );
    }
}
