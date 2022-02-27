package com.harmoush.demo;

import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {
//        stringsArrayWithoutOptional(); // throws NullPointerException
        stringsArrayWithOptional();
    }

    private static void stringsArrayWithOptional() {
        String[] str = new String[10];
        str[0] = "Java test optional";
        Optional<String> op1 = Optional.of(str[0]);
//        System.out.println("stringOptional.get() = " + stringOptional.orElse("no value"));

        op1.ifPresentOrElse((s) -> {
            String lowerCaseString = s.toLowerCase();
            System.out.println(lowerCaseString);
        }, () -> {
            String s = "string value is not present";
            System.out.println(s);
        });

        String s0 = op1.orElse("test");
        String s1 = op1.orElseGet(OptionalExamples::getDefaultValue);
        System.out.println("s1 = " + s1);

        Optional<String> op2 = Optional.ofNullable(str[1]);
//        System.out.println("op2.orElseThrow() = " + op2.orElseThrow());
//        System.out.println("op2.orElseThrow() = " + op2.orElseThrow(()-> new RuntimeException("tt")));


    }

    private static String getDefaultValue() {
        System.out.println("getDefaultValue() called.");
        return "default value";
    }

    private static void stringsArrayWithoutOptional() {
        String[] str = new String[10];
        String lowercaseString = str[5].toLowerCase();
        System.out.print(lowercaseString);
    }
}
