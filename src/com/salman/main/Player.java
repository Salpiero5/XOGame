package com.salman.main;

import java.util.Scanner;

class Player {

    private char c1 = ' ';
    private char c2 = ' ';


    Player() {

        setC1();
        setC2();
    }

    private char mark(int player) {

        System.out.println("Enter Your Mark Player " + player + ":");
        char h = ' ';
        boolean b = true;
        while (b) {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            h = s.toCharArray()[0];
            if (s.length() == 1 && Character.isLetter(h)) {
                System.out.println(h);
                break;
            }
            System.out.println("Enter a Character!");
        }
        return h;
    }

    private void setC1() {
        c1 = mark(1);
    }

    char getC1() { return c1; }

    private void setC2() {
        c2 = mark(2);
    }

    char getC2() {
        return c2;
    }

}
