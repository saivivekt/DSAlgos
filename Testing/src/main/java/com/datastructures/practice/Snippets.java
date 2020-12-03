package com.datastructures.practice;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.io.Resources;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class Snippets {


    public static void main(String[] args) {
        //int[] nums = {0,0,1,1,1,2,2,3,3,4};
        //System.out.println(removeDuplicates(nums));
        String[] thisIs = new String[1];

        //getPairsCount(5,6);

        int[] num = {17, 18, 5, 4, 6, 1};
        int[] nums = {5, 4, 3, 0, 1};
        int[] nums1 = {-7, -3, 2, 3, 11};

        System.out.println(containsLetter(new String("767Ab-f989-22f"), true));
        System.out.println(containsLetter(new String("767-989-22f"), true));
        System.out.println(containsLetter(new String("767-989-22"), false));

        num = replaceElements(num);
        // System.out.println(replaceElements(num));
        for (int i :
                num) {
            System.out.println(i);

        }
        moveZeroes(nums);

        sortedSquares(nums1);

        int[] A = {1, 0, 3};
        sortArrayByParity(A);
    }

    private static boolean containsLetter(String ndcCode, final boolean isNdcCodeEndsWithCharacter) {
        if (isNdcCodeEndsWithCharacter) {
            ndcCode = ndcCode.substring(0, ndcCode.length() - 1);
        }
        return ndcCode.chars().anyMatch(Character::isAlphabetic);
    }

    public static int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int i = 0, j = A.length - 1;

        for (int k = A.length - 1; k >= 0; k--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                res[k] = A[i] * A[i];
                i++;
            } else if (Math.abs(A[i]) < Math.abs(A[j])) {
                res[k] = A[j] * A[j];
                j--;
            }
        }
        return res;
    }


    public static int[] replaceElements(int[] arr) {
        int max = -1, temp, len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            temp = arr[i];
            arr[i] = max;
            if (max < temp)
                max = temp;
        }
        return arr;
    }

    public static int[] sortArrayByParity(int[] A) {
        int current = 0;
        int j = A.length - 1;
        while (current < j) {

            if (A[current] % 2 != 0 && A[j] % 2 == 0) {
                int temp = A[current];
                A[current] = A[j];
                A[j] = temp;


            }

            if (A[current] % 2 == 0) current++;
            if (A[j] % 2 != 0) j--;
        }

        return A;
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }
    }

    private static boolean validMountainArray(int[] A) {
        int peak = 0;

        for (int i = 0; i + 1 < A.length; i++) {
            if (A[i] < A[i + 1]) {
                peak = i + 1;
            } else if (A[i] > A[i + 1]) {
                break;
            } else return false;
        }

        if (peak == 0 || peak == A.length - 1)
            return false;

        for (int i = peak; i + 1 < A.length; i++) {
            if (A[i] <= A[i + 1])
                return false;
        }

        if (peak == A.length - 1)
            return false;

        return true;
    }

    private static boolean checkHalves(int[] arr) {
        Set<Integer> hs = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && hs.contains(arr[i] * 2)) {
                return true;
            }
        }

        return false;

    }
}


