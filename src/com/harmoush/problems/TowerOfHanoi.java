package com.harmoush.problems;

public class TowerOfHanoi {

    public static int stepsCount = 0;

    public static void solveRecursively(int n, int src, int dest, int aux) {
        if (n == 0) {
            return;
        }
        solveRecursively(n - 1, src, aux, dest);
        System.out.printf("Move disk %d from %d to %d%n", n, src, dest);
        stepsCount++;
        solveRecursively(n - 1, aux, dest, src);
    }

    public static void solveIteratively(int n, int src, int dest, int aux) {
        int swap;
        while (n > 0) {
            solveIteratively(n - 1, src, aux, dest);
            System.out.printf("Move disk %d from %d to %d%n", n, src, dest);
            stepsCount++;
            swap = src;
            src = aux;
            aux = swap;
            n--;
        }


    }

    public static void resetStepsCount() {
        stepsCount = 0;
    }
}
