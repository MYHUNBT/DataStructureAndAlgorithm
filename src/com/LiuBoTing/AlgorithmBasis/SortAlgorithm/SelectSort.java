package com.LiuBoTing.AlgorithmBasis.SortAlgorithm;

import java.util.Arrays;

/**
 * @author liuboting
 * @date 2021/9/19 7:37
 * 选择排序
 *  O(n2)
 */

public class SelectSort {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            Arrays.sort(arr1);
            selectSort(arr2);
            if(!isEqual(arr1,arr2)){
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed == true ? "nice" : "failed");

    }

    public static void selectSort(int[] arr){
        if(arr == null || arr.length == 1) return;
        int min;
        for (int i = 0; i < arr.length -1 ; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]) min = j;
            }
            swap(arr,i,min);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int)(Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr){
        if(arr == null) return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    public static boolean isEqual(int[] arr1,int[] arr2){
        if(arr1 == null && arr2 == null) return true;
        if(arr1 == null || arr2 == null) return false;
        if(arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
    public static void printArray(int[] arr){
        Arrays.toString(arr);
    }
}
