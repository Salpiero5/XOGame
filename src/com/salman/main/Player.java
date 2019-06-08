package com.salman.main;

import java.util.Scanner;

class Player {

    private char markP1 = ' ';
    private char markP2 = ' ';


    Player() {

        setMarkP1();
        setMarkP2();
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

    private void setMarkP1() {
        markP1 = mark(1);
    }

    char getMarkP1() { return markP1; }

    private void setMarkP2() {
        markP2 = mark(2);
    }

    char getMarkP2() {
        return markP2;
    }

}
