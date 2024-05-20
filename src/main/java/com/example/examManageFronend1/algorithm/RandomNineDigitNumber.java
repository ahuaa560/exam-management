package com.example.examManageFronend1.algorithm;

import java.util.Random;

public class RandomNineDigitNumber {

    // Method to generate a random 9-digit number as a String
    public static String generateRandomNineDigitNumber() {
        Random random = new Random();

        // Ensure the first digit is non-zero (1-9)
        int firstDigit = random.nextInt(9) + 1;

        // Generate the remaining 8 digits (0-9)
        StringBuilder nineDigitNumber = new StringBuilder();
        nineDigitNumber.append(firstDigit);

        for (int i = 0; i < 8; i++) {
            int digit = random.nextInt(10);
            nineDigitNumber.append(digit);
        }

        return nineDigitNumber.toString();
    }
}
