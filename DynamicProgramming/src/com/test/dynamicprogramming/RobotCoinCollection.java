package com.test.dynamicprogramming;

/*
 Several coins are placed in cells of an
 n × m board, no more than one coin per cell.A robot, located in the upper left cell
 of the board, needs to collect as many of the coins as possible and bring them to
 the bottom right cell. On each step, the robot can move either one cell to the right
 or one cell down from its current location.When the robot visits a cell with a coin,
 it always picks up that coin. Design an algorithm to find the maximum number of
 coins the robot can collect and a path it needs to follow to do this.
 Its space efficiency is,obviously, also (nm).
 */
public class RobotCoinCollection {

    public static int collectCoins(int[][] coinBoard) {

        int rowLen = coinBoard.length;
        int columnLen = coinBoard[0].length;
        
        int[][] F = new int[rowLen][columnLen];

        F[0][0] = coinBoard[0][0];
        
        for (int column = 1; column < columnLen; column++) {
            F[0][column] = F[0][column - 1] + coinBoard[0][column];
        }

        for (int row = 1; row < rowLen; row++) {
            F[row][0] = F[row - 1][0] + coinBoard[row][0];
            for (int column = 1; column < columnLen; column++) {
                F[row][column] = max(F[row - 1][column], F[row][column - 1]) + coinBoard[row][column];
            }
        }

        // Just to understand
        System.out.println("F[][]");
        System.out.println("-------------");
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                System.out.print(F[row][column] + "  ");
            }
            System.out.println();
        }

        return F[rowLen - 1][columnLen - 1];
    }

    private static int max(int i, int j) {
        return i > j ? i : j;
    }

    public static void main(String[] args) {
        int[][] coinBoard = new int[5][5];

        coinBoard[0][0] = 1;
        coinBoard[1][1] = 1;
        coinBoard[1][3] = 1;
        coinBoard[2][2] = 1;
        coinBoard[4][2] = 1;
        coinBoard[4][4] = 1;

        System.out.println("coinBoard[][]");
        System.out.println("-------------");
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                System.out.print(coinBoard[row][column] + "  ");
            }
            System.out.println();
        }
        System.out.println("Maximum Coins : "+collectCoins(coinBoard));
    }
}
