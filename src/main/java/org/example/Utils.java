package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Utils {
    public static String toCamelCase(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        // Ganti karakter non-alfanumerik dengan spasi, lalu pecah string
        String[] parts = s.replaceAll("[^a-zA-Z0-9\\s]", " ").split("\\s+");

        // Ambil bagian pertama dan ubah ke huruf kecil
        String firstPart = parts[0].toLowerCase();

        // Proses bagian-bagian selanjutnya dan gabungkan
        String remainingParts = Arrays.stream(parts, 1, parts.length)
                .map(p -> p.substring(0, 1).toUpperCase() + p.substring(1).toLowerCase())
                .collect(Collectors.joining());

        return firstPart + remainingParts;
    }
}
