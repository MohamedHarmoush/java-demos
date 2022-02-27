package com.harmoush.demo;

import java.util.Scanner;

public class SearchingExamples {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 9, 17, 30, 32};
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int key = scanner.nextInt();
            int index = binarySearch(arr, key);
            System.out.println("index = " + index);
        }
    }

    private static int binarySearch(int[] arr, int key) {
//        return binarySearchRecursively(arr, key, 0, arr.length - 1);
        return binarySearchIteratively(arr, key);
    }

    private static int binarySearchIteratively(int[] arr, int key) {
        int mid, start = 0, end = arr.length - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursively(int[] arr, int key, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            return binarySearchRecursively(arr, key, mid + 1, end);
        } else {
            return binarySearchRecursively(arr, key, start, mid - 1);
        }
    }
}
