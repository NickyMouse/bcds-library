package com.alibaba.intl.bcds.goldroom.util;

import java.util.Random;

public class PasswordGenerator {

    public static String getRandomPassword() {
        Random r = new Random();
        int c1 = r.nextInt() % 1000;
        int c2 = r.nextInt() % 1000;
        return "" + c1 + "" + c2;
    }

    public static void main(String[] argv) {
        System.out.println(PasswordGenerator.getRandomPassword());
    }
}
