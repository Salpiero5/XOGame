package com.salman.main;

import java.util.Scanner;

class Game {

    private char[] board = new char[9];
    private int player = 1;
    private int tie = 0;
    Player p = new Player();

    /**
     * This <b>constructor</b> initials the board of XO Game!
     */
    Game() {
        int counter = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[counter - 1] = Character.forDigit(counter, 10);
                counter++;
            }
        }
        draw();
    }

    void play() {

        boolean b = true;
        char tempMark = p.getMarkP1();
        player = 1;

        for (int i = 0; i < 9; i++) {
            System.out.println("It's Player " + player + " Turn :");
            while (b) {
                try {
                    Scanner sc = new Scanner(System.in);
                    int field = sc.nextInt();

                    tie++;

                    if (board[field - 1] == p.getMarkP1() || board[field - 1] == p.getMarkP2()) {

                        System.out.println("This Field Is Full! Enter Another Field");
                        continue;
                    }
                    if (field > 0 && field < 10) {

                        board[field - 1] = tempMark;
                        int fieldTemp = field - 1;
                        fill(tempMark, fieldTemp);

                        boolean winner = checkRules(); //Check the game rules (Which on is winner)
                        if (winner) {
                            return;
                        }

                        if(tie == 9){
                            System.out.println("The game is tie");
                            draw();
                            return;
                        }

                        if (tempMark == p.getMarkP1() && player == 1) {
                            tempMark = p.getMarkP2();
                            player = 2;
                            break;
                        }
                        if (tempMark == p.getMarkP2() && player == 2) {
                            tempMark = p.getMarkP1();
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

        if ((board[0] == p.getMarkP1() && board[0] == board[1] && board[1] == board[2]) //For player 1
                || (board[3] == p.getMarkP1() && board[3] == board[4] && board[4] == board[5])
                || (board[6] == p.getMarkP1() && board[6] == board[7] && board[7] == board[8]) //Top 3 lines check the rows
                || (board[0] == p.getMarkP1() && board[0] == board[3] && board[3] == board[6])
                || (board[1] == p.getMarkP1() && board[1] == board[4] && board[4] == board[7])
                || (board[2] == p.getMarkP1() && board[2] == board[5] && board[5] == board[8]) //Top 3 lines check the columns
                || (board[0] == p.getMarkP1() && board[0] == board[4] && board[4] == board[8])
                || (board[2] == p.getMarkP1() && board[2] == board[4] && board[4] == board[6]) //Top 2 lines check diagonals
        ) {
            System.out.println("Player " + player + "(" + p.getMarkP1() + ") is Winner Hooora!");
            draw();
            return true;
        }

        if ((board[0] == p.getMarkP2() && board[0] == board[1] && board[1] == board[2]) //For player 2
                || (board[3] == p.getMarkP2() && board[3] == board[4] && board[4] == board[5])
                || (board[6] == p.getMarkP2() && board[6] == board[7] && board[7] == board[8]) //Top 3 lines check the rows
                || (board[0] == p.getMarkP2() && board[0] == board[3] && board[3] == board[6])
                || (board[1] == p.getMarkP2() && board[1] == board[4] && board[4] == board[7])
                || (board[2] == p.getMarkP2() && board[2] == board[5] && board[5] == board[8]) //Top 3 lines check the columns
                || (board[0] == p.getMarkP2() && board[0] == board[4] && board[4] == board[8])
                || (board[2] == p.getMarkP2() && board[2] == board[4] && board[4] == board[6]) //Top 2 lines check diagonals
        ) {
            System.out.println("Player " + player + "(" + p.getMarkP2() + ") is Winner Hooora!");
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
                System.out.print("[" + board[counter] + "]");
                counter++;
            }
            System.out.println();
        }
    }

    /**
     * This <B>fill</B> method places user mark into board
     */
    private void fill(char mark, int x) {
        board[x] = mark;
    }

}
