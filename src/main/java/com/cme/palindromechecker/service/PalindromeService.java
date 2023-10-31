package com.cme.palindromechecker.service;

import com.cme.palindromechecker.dto.PalindromeDto;

import java.util.List;

public interface PalindromeService {

    String palindromeProcessing(PalindromeDto palindromeDto);

    List<String> getAllPalindromeRecords();
}
