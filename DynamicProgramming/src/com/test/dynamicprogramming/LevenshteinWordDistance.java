package com.test.dynamicprogramming;

public class LevenshteinWordDistance {

    private static final int SUBSTITUTION_COST = 1;
    private static final int DELETION_COST = 1;
    private static final int INSERTION_COST = 1;

    public static int calculateLavenshteinDistance(String source, String target) {
        assert source != null : "source can't be null";
        assert target != null : "target can't be null";

        int sourceLength = source.length();
        int targetLength = target.length();
        int[][] F = new int[sourceLength + 1][targetLength + 1];
        F[0][0] = 0;

        for (int row = 1; row <= sourceLength; ++row) {
            F[row][0] = row;
        }
        for (int col = 1; col <= targetLength; ++col) {
            F[0][col] = col;
        }

        for (int row = 1; row <= sourceLength; ++row) {
            for (int col = 1; col <= targetLength; ++col) {
                F[row][col] = min(substitutionCost(source, target, F, row, col), deleteCost(F, row, col), insertCost(F, row, col));
            }
        }
        return F[sourceLength][targetLength];
    }

    private static int substitutionCost(String source, String target, int[][] F, int row, int col) {
        int cost = 0;
        if (source.charAt(row - 1) != target.charAt(col - 1)) {
            cost = SUBSTITUTION_COST;
        }
        return F[row - 1][col - 1] + cost;
    }

    private static int deleteCost(int[][] F, int row, int col) {

        return F[row - 1][col] + DELETION_COST;
    }

    private static int insertCost(int[][] F, int row, int col) {

        return F[row][col - 1] + INSERTION_COST;
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {

        String source = "dynamic";
        String target = "dnamsic";
        System.out.println("LevenshteinWordDistance:: " + calculateLavenshteinDistance(source, target));
    }

}
