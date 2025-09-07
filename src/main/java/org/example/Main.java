package org.example;

import java.util.*;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String bitNumberInput;
        if (args.length > 0) {
            // Gunakan argumen dari command line jika ada
            bitNumberInput = args[0];
        } else {
            // Jika tidak ada argumen, minta input dari user (untuk testing lokal)
            Scanner input = new Scanner(System.in);
            System.out.print("Please enter bits to convert: ");
            bitNumberInput = input.nextLine();
            input.close();
        }

        List<ISO8583DataElements> isoElements = new ArrayList<>();
        isoElements.add(new ISO8583DataElements("bit_0", "mti"));
        isoElements.add(new ISO8583DataElements("bit_2", "Primary Account Number"));
        isoElements.add(new ISO8583DataElements("bit_3", "Processing Code"));
        isoElements.add(new ISO8583DataElements("bit_4", "Amount, Transaction"));
        isoElements.add(new ISO8583DataElements("bit_5", "Amount, Reconciliation"));
        isoElements.add(new ISO8583DataElements("bit_6", "Amount, Cardholder Billing"));
        isoElements.add(new ISO8583DataElements("bit_7", "Date & time, Transmission"));
        isoElements.add(new ISO8583DataElements("bit_8", "Amount, Cardholder Billing Fee"));
        isoElements.add(new ISO8583DataElements("bit_9", "Conversion Rate, Reconciliation"));
        isoElements.add(new ISO8583DataElements("bit_10", "Conversion Rate, Cardholder Billing"));
        isoElements.add(new ISO8583DataElements("bit_11", "System Trace Audit Number (STAN)"));
        isoElements.add(new ISO8583DataElements("bit_12", "Time, Local Transaction"));
        isoElements.add(new ISO8583DataElements("bit_13", "Date, Local Transaction"));
        isoElements.add(new ISO8583DataElements("bit_14", "Date, Expiration"));
        isoElements.add(new ISO8583DataElements("bit_15", "Date, Settlement"));
        isoElements.add(new ISO8583DataElements("bit_16", "Date, Conversion"));
        isoElements.add(new ISO8583DataElements("bit_17", "Date, Capture"));
        isoElements.add(new ISO8583DataElements("bit_18", "Merchant Type"));
        isoElements.add(new ISO8583DataElements("bit_19", "Acquiring Institution Country Code"));
        isoElements.add(new ISO8583DataElements("bit_20", "Primary Account Number Extended, Country Code"));
        isoElements.add(new ISO8583DataElements("bit_21", "Forwarding Institution Extended, Country Code"));
        isoElements.add(new ISO8583DataElements("bit_22", "Point of Service Entry Mode"));
        isoElements.add(new ISO8583DataElements("bit_23", "Primary Account Number (PAN) Sequence Number"));
        isoElements.add(new ISO8583DataElements("bit_24", "Network International Identifier (NII)"));
        isoElements.add(new ISO8583DataElements("bit_25", "Point of Service Condition Code"));
        isoElements.add(new ISO8583DataElements("bit_26", "Point of Service PIN Capture Code"));
        isoElements.add(new ISO8583DataElements("bit_27", "Authorization Identification Response Length"));
        isoElements.add(new ISO8583DataElements("bit_28", "Amount, Transaction Fee"));
        isoElements.add(new ISO8583DataElements("bit_29", "Amount, Reconciliation Fee"));
        isoElements.add(new ISO8583DataElements("bit_30", "Amount, Transaction Processing Fee"));
        isoElements.add(new ISO8583DataElements("bit_31", "Amount, Reconciliation Processing Fee"));
        isoElements.add(new ISO8583DataElements("bit_32", "Acquiring Institution ID Code"));
        isoElements.add(new ISO8583DataElements("bit_33", "Forwarding Institution ID Code"));
        isoElements.add(new ISO8583DataElements("bit_34", "Primary Account Number (PAN) Extended"));
        isoElements.add(new ISO8583DataElements("bit_35", "Track 2 Data"));
        isoElements.add(new ISO8583DataElements("bit_36", "Track 3 Data"));
        isoElements.add(new ISO8583DataElements("bit_37", "Retrieval Reference Number"));
        isoElements.add(new ISO8583DataElements("bit_38", "Authorization Identification Response"));
        isoElements.add(new ISO8583DataElements("bit_39", "Response Code"));
        isoElements.add(new ISO8583DataElements("bit_40", "Service Restriction Code"));
        isoElements.add(new ISO8583DataElements("bit_41", "Card Acceptor Terminal ID"));
        isoElements.add(new ISO8583DataElements("bit_42", "Card Acceptor ID Code"));
        isoElements.add(new ISO8583DataElements("bit_43", "Card Acceptor Name/Location"));
        isoElements.add(new ISO8583DataElements("bit_44", "Additional Response Data"));
        isoElements.add(new ISO8583DataElements("bit_45", "Track 1 Data"));
        isoElements.add(new ISO8583DataElements("bit_46", "Additional Data - ISO"));
        isoElements.add(new ISO8583DataElements("bit_47", "Additional Data - National"));
        isoElements.add(new ISO8583DataElements("bit_48", "Additional Data - Private"));
        isoElements.add(new ISO8583DataElements("bit_49", "Currency Code, Transaction"));
        isoElements.add(new ISO8583DataElements("bit_50", "Currency Code, Reconciliation"));
        isoElements.add(new ISO8583DataElements("bit_51", "Currency Code, Cardholder Billing"));
        isoElements.add(new ISO8583DataElements("bit_52", "PIN Block"));
        isoElements.add(new ISO8583DataElements("bit_53", "Security-Related Control Information"));
        isoElements.add(new ISO8583DataElements("bit_54", "Additional Amounts"));
        isoElements.add(new ISO8583DataElements("bit_55", "Reserved ISO"));
        isoElements.add(new ISO8583DataElements("bit_56", "Reserved ISO"));
        isoElements.add(new ISO8583DataElements("bit_57", "Reserved National"));
        isoElements.add(new ISO8583DataElements("bit_58", "Reserved National"));
        isoElements.add(new ISO8583DataElements("bit_59", "Reserved National"));
        isoElements.add(new ISO8583DataElements("bit_60", "Reserved National"));
        isoElements.add(new ISO8583DataElements("bit_61", "Reserved Private"));
        isoElements.add(new ISO8583DataElements("bit_62", "Reserved Private"));
        isoElements.add(new ISO8583DataElements("bit_63", "Reserved Private"));
        isoElements.add(new ISO8583DataElements("bit_64", "Message Authentication Code (MAC)"));
        isoElements.add(new ISO8583DataElements("bit_65", "Reserved ISO"));
        isoElements.add(new ISO8583DataElements("bit_66", "Original Data Elements"));
        isoElements.add(new ISO8583DataElements("bit_67", "Extended Payment Code"));
        isoElements.add(new ISO8583DataElements("bit_68", "Receiving Institution Country Code"));
        isoElements.add(new ISO8583DataElements("bit_69", "Settlement Institution Country Code"));
        isoElements.add(new ISO8583DataElements("bit_70", "Network Management Information Code"));
        isoElements.add(new ISO8583DataElements("bit_71", "Message Number"));
        isoElements.add(new ISO8583DataElements("bit_72", "Message Number, Last"));
        isoElements.add(new ISO8583DataElements("bit_73", "Date, Action"));
        isoElements.add(new ISO8583DataElements("bit_74", "Number of Credits"));
        isoElements.add(new ISO8583DataElements("bit_75", "Number of Credits, Reversal"));
        isoElements.add(new ISO8583DataElements("bit_76", "Number of Debits"));
        isoElements.add(new ISO8583DataElements("bit_77", "Number of Debits, Reversal"));
        isoElements.add(new ISO8583DataElements("bit_78", "Number of Transfers"));
        isoElements.add(new ISO8583DataElements("bit_79", "Number of Transfers, Reversal"));
        isoElements.add(new ISO8583DataElements("bit_80", "Number of Enquiries"));
        isoElements.add(new ISO8583DataElements("bit_81", "Number of Authorizations"));
        isoElements.add(new ISO8583DataElements("bit_82", "Amount, Credits, Processing Fee"));
        isoElements.add(new ISO8583DataElements("bit_83", "Amount, Credits, Transaction Fee"));
        isoElements.add(new ISO8583DataElements("bit_84", "Amount, Debits, Processing Fee"));
        isoElements.add(new ISO8583DataElements("bit_85", "Amount, Debits, Transaction Fee"));
        isoElements.add(new ISO8583DataElements("bit_86", "Amount, Credits"));
        isoElements.add(new ISO8583DataElements("bit_87", "Amount, Credits, Reversal"));
        isoElements.add(new ISO8583DataElements("bit_88", "Amount, Debits"));
        isoElements.add(new ISO8583DataElements("bit_89", "Amount, Debits, Reversal"));
        isoElements.add(new ISO8583DataElements("bit_90", "Original Data Elements"));
        isoElements.add(new ISO8583DataElements("bit_91", "File Update Code"));
        isoElements.add(new ISO8583DataElements("bit_92", "File Security Code"));
        isoElements.add(new ISO8583DataElements("bit_93", "Response Indicator"));
        isoElements.add(new ISO8583DataElements("bit_94", "Service Indicator"));
        isoElements.add(new ISO8583DataElements("bit_95", "Replacement Amount"));
        isoElements.add(new ISO8583DataElements("bit_96", "Message Security Code"));
        isoElements.add(new ISO8583DataElements("bit_97", "Amount, Net Settlement"));
        isoElements.add(new ISO8583DataElements("bit_98", "Payee"));
        isoElements.add(new ISO8583DataElements("bit_99", "Settlement Institution ID Code"));
        isoElements.add(new ISO8583DataElements("bit_100", "Receiving Institution ID Code"));
        isoElements.add(new ISO8583DataElements("bit_101", "File Name"));
        isoElements.add(new ISO8583DataElements("bit_102", "Account ID 1"));
        isoElements.add(new ISO8583DataElements("bit_103", "Account ID 2"));
        isoElements.add(new ISO8583DataElements("bit_104", "Transaction Description"));
        isoElements.add(new ISO8583DataElements("bit_105", "Reserved for ISO use"));
        isoElements.add(new ISO8583DataElements("bit_106", "Reserved for ISO use"));
        isoElements.add(new ISO8583DataElements("bit_107", "Reserved for ISO use"));
        isoElements.add(new ISO8583DataElements("bit_108", "Reserved for ISO use"));
        isoElements.add(new ISO8583DataElements("bit_109", "Reserved for ISO use"));
        isoElements.add(new ISO8583DataElements("bit_110", "Reserved for ISO use"));
        isoElements.add(new ISO8583DataElements("bit_111", "Reserved for ISO use"));
        isoElements.add(new ISO8583DataElements("bit_112", "Reserved for National use"));
        isoElements.add(new ISO8583DataElements("bit_113", "Reserved for National use"));
        isoElements.add(new ISO8583DataElements("bit_114", "Reserved for National use"));
        isoElements.add(new ISO8583DataElements("bit_115", "Reserved for National use"));
        isoElements.add(new ISO8583DataElements("bit_116", "Reserved for National use"));
        isoElements.add(new ISO8583DataElements("bit_117", "Reserved for National use"));
        isoElements.add(new ISO8583DataElements("bit_118", "Reserved for National use"));
        isoElements.add(new ISO8583DataElements("bit_119", "Reserved for National use"));
        isoElements.add(new ISO8583DataElements("bit_120", "Reserved for Private use"));
        isoElements.add(new ISO8583DataElements("bit_121", "Reserved for Private use"));
        isoElements.add(new ISO8583DataElements("bit_122", "Reserved for Private use"));
        isoElements.add(new ISO8583DataElements("bit_123", "Reserved for Private use"));
        isoElements.add(new ISO8583DataElements("bit_124", "Reserved for Private use"));
        isoElements.add(new ISO8583DataElements("bit_125", "Reserved for Private use"));
        isoElements.add(new ISO8583DataElements("bit_126", "additionalData"));
        isoElements.add(new ISO8583DataElements("bit_127", "Reserved for Private use"));
        isoElements.add(new ISO8583DataElements("bit_128", "Message Authentication Code (MAC)"));

        List<String> rawBitNumbers = Arrays.asList(bitNumberInput.split(","));

        List<String> errorMessages = new ArrayList<>();

        Pattern pattern = Pattern.compile("^bit_\\d+$", Pattern.CASE_INSENSITIVE);

        for (String bit : rawBitNumbers) {
            String trimmedBit = bit.trim();
            if (!pattern.matcher(trimmedBit).matches()) {
                errorMessages.add("Your pattern is incorrect: " + trimmedBit);
            } else if (!isoElements.stream().anyMatch(e -> e.getBitNumber().equalsIgnoreCase(trimmedBit))) {
                errorMessages.add(trimmedBit + " not registered");
            }
        }

        if (!errorMessages.isEmpty()) {
            errorMessages.forEach(System.out::println);
            return;
        }

        Map<String, String> jsonOutput = new LinkedHashMap<>();

        List<String> lowercaseInputBits = rawBitNumbers.stream()
                .map(String::trim)
                .map(String::toLowerCase)
                .toList();

        for (ISO8583DataElements element : isoElements) {
            if (lowercaseInputBits.contains(element.getBitNumber())) {
                String key = element.getDescription().replaceAll("[^a-zA-Z0-9]+", " ").trim();
                String camelCaseKey = key.substring(0, 1).toLowerCase() + key.substring(1).replaceAll("\\s(.)", "$1".toUpperCase());
                jsonOutput.put(camelCaseKey, "");
            }
        }

        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");

        List<String> entries = new ArrayList<>();
        for (Map.Entry<String, String> entry : jsonOutput.entrySet()) {
            entries.add("    \"" + entry.getKey() + "\": \"" + entry.getValue() + "\"");
        }

        jsonBuilder.append(String.join(",\n", entries));
        jsonBuilder.append("\n}");

        System.out.println(jsonBuilder.toString());
    }
}
