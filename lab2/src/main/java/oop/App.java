package oop;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class App {
    public static void main(String[] args) {
        String[] testStrings = {
                "e02fd0e4-00fd-090A-ca30-0d00a0038ba0",
                "{e02fd0e4-00fd-090A-ca30-0d00a0038ba0}",
                "e02fd0e400fd090Aca300d00a0038ba0",
                "invalid-guid"
        };

        String guidRegex = "\\{?[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}\\}?";

        Pattern pattern = Pattern.compile(guidRegex);

        for (String testString : testStrings) {
            Matcher matcher = pattern.matcher(testString);
            if (matcher.matches()) {
                System.out.println(testString + " -> true");
            } else {
                System.out.println(testString + " -> false");
            }
        }
    }
}
