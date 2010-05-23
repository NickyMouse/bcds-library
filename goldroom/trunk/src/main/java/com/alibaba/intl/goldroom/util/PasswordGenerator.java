package com.alibaba.intl.goldroom.util;


public class PasswordGenerator {

    public static String getRandomPassword() {
        int c1 = (int) (Math.random() * 100);
        int c2 = (int) (Math.random() * 100);
        int c3 = (int) (Math.random() * 100);
        return "" + c1 + "" + c2 + "" + c3;
    }

    public static void main(String[] argv) {
        System.out.println(PasswordGenerator.getRandomPassword());
    }
}
