package com.koyote.gather.util;

public class StringUtil {
    public static String extractSubstring(String input, int periodIndex) {
        if (input == null || periodIndex < 1) {
            return null; // Handle invalid input or periodIndex
        }

        String[] parts = input.split("\\.");
        if (parts.length < periodIndex + 1) {
            return null; // Handle insufficient periods
        }

        return parts[periodIndex];
    }
}
