package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static
    public static void oneMonthCalendar(int days, int first) {
        int rows;
        if ((days + first) % 7 != 0)
            rows = (days / 7) + 1;
        else
            rows = days / 7;

        for (int i = 1; i < first; i++) {
            System.out.print("   ");
        }

        int count = 1;
        int column = first;

        for (int a = 0; a < rows; a++) {
            while (column <= 7) {
                System.out.printf("%2d ", count);
                if (count == days) {
                    System.out.println();
                    return;
                }
                column++;
                count++;
            }
            column = 1;
            System.out.println();
        }
    }


    public static long[] lcg(long seed) {

        long x = ((long) Math.pow(2, 31));
        long y = 1103515245;
        long z = 12345;

        long[] arr1 = new long[11];
        arr1[0] = seed;

        for (int i = 1; i < 11; i++) {
            arr1[i] = ((y * arr1[i - 1]) + z) % x;
        }

        return Arrays.copyOfRange(arr1, 1, arr1.length);
    }

    public static void guessingGame(int guessnumber) {
        Scanner x = new Scanner(System.in);
        int guess;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Guess number " + i + ": ");
            guess = x.nextInt();

            if (guess == guessnumber) {
                System.out.println("You won wisenheimer!");
                break;
            }

            if (i == 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }

            if (guess > guessnumber)
                System.out.println("The number AI picked is lower than your guess.");
            if (guess < guessnumber)
                System.out.println("The number AI picked is higher than your guess.");
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random zufall = new Random();
        return zufall.nextInt(100) + 1;
    }

    public static boolean swapArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] - arr2[i];
            arr2[i] = arr2[i] + arr1[i];
            arr1[i] = arr2[i] - arr1[i];
        }
        return true;
    }

    public static String camelCase(String sentence) {
        char[] se = sentence.toCharArray();
        if (se[0] >= 97 && se[0] <= 122)
            se[0] -= 32;

        for (int i = 0; i < se.length; i++) {
            if (i >= 1 && se[i - 1] == ' ' && se[i] >= 97 && se[i] <= 122) {
                se[i] -= 32;
            }
            if (i >= 1 && se[i - 1] != ' ' && se[i] >= 65 && se[i] <= 90) {
                se[i] += 32;
            }
        }

        for (int i = 0; i < se.length; i++) {
            if ((se[i] > 0 && se[i] <= 64) || (se[i] >= 91 && se[i] <= 96) || (se[i] >= 123 && se[i] <= 127)) {
                se[i] = 32;
            }
        }
        String loe = String.valueOf(se).replaceAll(" ", "");
        return loe;
    }

    public static int checkDigit(int[] arr1) {
        int gewichtung = 2;
        int summe = 0;
        int modulo;

        for (int i = 0; i < arr1.length; i++) {
            summe += arr1[i] * (gewichtung + i);
        }
        modulo = summe % 11;

        if (11 - modulo == 10)
            return 0;
        if (11 - modulo == 11)
            return 5;

        return 11 - modulo;
    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        System.out.println("---- Number 1 ----");
        oneMonthCalendar(30,3);
        System.out.println();

        System.out.println("---- Number 2 ----");
        lcg(12345);
        System.out.println();

        System.out.println("---- Number 3 ----");
        guessingGame(1);
        System.out.println();

        System.out.println("---- Number 4 ----");
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] array2 = new int[]{100, 202, 30, 14, 15, 16};
        swapArrays(array1,array2);
        System.out.println();

        System.out.println("---- Number 5 ----");
        camelCase("abc abc abc aBc");
        System.out.println();

        System.out.println("---- Number 6 ----");
        checkDigit(array1);
        System.out.println();
    }
}