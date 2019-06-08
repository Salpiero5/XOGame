package com.salman.main;

import java.util.Scanner;

class Game {

    private char[] c = new char[9];
    private int player = 1;
    Player p = new Player();

    /**
     * This <b>constructor</b> initials the board of XO Game!
     */
    Game() {
        int counter = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c[counter - 1] = Character.forDigit(counter, 10);
                counter++;
            }
        }
        draw();
    }

    void play() {

        boolean b = true;
        char tempMark = p.getC1();
        player = 1;

        for (int i = 0; i < 9; i++) {
            System.out.println("It's Player " + player + " Turn :");
            while (b) {
                try {
                    Scanner sc = new Scanner(System.in);
                    int field = sc.nextInt();

                    if (c[field - 1] == p.getC1() || c[field - 1] == p.getC2()) {

                        System.out.println("This Field Is Full! Enter Another Field");
                        continue;
                    }
                    if (field > 0 && field < 10) {

                        c[field - 1] = tempMark;
                        int fieldTemp = field - 1;
                        fill(tempMark, fieldTemp);

                        boolean winner = checkRules(); //Check the game rules (Which on is winner)
                        if (winner) {
                            return;
                        }

                        if (tempMark == p.getC1() && player == 1) {
                            tempMark = p.getC2();
                            player = 2;
                            break;
                        }
                        if (tempMark == p.getC2() && player == 2) {
                            tempMark = p.getC1();
                            player = 1;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.print("Pls Enter a Numeric Value ");
                }
                System.out.println("Between 1 to 9 !");
            }
            draw();
        }
    }

    private boolean checkRules() {

        if ((c[0] == p.getC1() && c[0] == c[1] && c[1] == c[2]) //For player 1
                || (c[3] == p.getC1() && c[3] == c[4] && c[4] == c[5])
                || (c[6] == p.getC1() && c[6] == c[7] && c[7] == c[8]) //Top 3 lines check the rows
                || (c[0] == p.getC1() && c[0] == c[3] && c[3] == c[6])
                || (c[1] == p.getC1() && c[1] == c[4] && c[4] == c[7])
                || (c[2] == p.getC1() && c[2] == c[5] && c[5] == c[8]) //Top 3 lines check the columns
                || (c[0] == p.getC1() && c[0] == c[4] && c[4] == c[8])
                || (c[2] == p.getC1() && c[2] == c[4] && c[4] == c[6]) //Top 2 lines check diagonals
        ) {
            System.out.println("Player " + player + "(" + p.getC1() + ") is Winner!");
            draw();
            return true;
        }

        if ((c[0] == p.getC2() && c[0] == c[1] && c[1] == c[2]) //For player 2
                || (c[3] == p.getC2() && c[3] == c[4] && c[4] == c[5])
                || (c[6] == p.getC2() && c[6] == c[7] && c[7] == c[8]) //Top 3 lines check the rows
                || (c[0] == p.getC2() && c[0] == c[3] && c[3] == c[6])
                || (c[1] == p.getC2() && c[1] == c[4] && c[4] == c[7])
                || (c[2] == p.getC2() && c[2] == c[5] && c[5] == c[8]) //Top 3 lines check the columns
                || (c[0] == p.getC2() && c[0] == c[4] && c[4] == c[8])
                || (c[2] == p.getC2() && c[2] == c[4] && c[4] == c[6]) //Top 2 lines check diagonals
        ) {
            System.out.println("Player " + player + "(" + p.getC2() + ") is Winner!");
            draw();
            return true;
        }
        return false;
    }

    /**
     * This <b>draw</b> method prints the board
     */
    private void draw() {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + c[counter] + "]");
                counter++;
            }
            System.out.println();
        }
    }

    /**
     * This <B>fill</B> method places user mark into board
     */
    private void fill(char mark, int x) {
        c[x] = mark;
    }

}
