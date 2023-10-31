package com.cme.palindromechecker.dto;

import lombok.*;

// This DTO class is created for data conversion FROM and TO repository and Controller Layer
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PalindromeDto {
    private String userName;
    private String palindromeToken;
}