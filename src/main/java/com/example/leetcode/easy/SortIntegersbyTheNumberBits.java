package com.example.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an integer array arr. You have to sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
 *
 * Return the sorted array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [0,1,2,3,4,5,6,7,8]
 * Output: [0,1,2,4,8,3,5,6,7]
 * Explantion: [0] is the only integer with 0 bits.
 * [1,2,4,8] all have 1 bit.
 * [3,5,6] have 2 bits.
 * [7] has 3 bits.
 * The sorted array by bits is [0,1,2,4,8,3,5,6,7]
 * Example 2:
 *
 * Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * Output: [1,2,4,8,16,32,64,128,256,512,1024]
 * Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.
 * Example 3:
 *
 * Input: arr = [10000,10000]
 * Output: [10000,10000]
 * Example 4:
 *
 * Input: arr = [2,3,5,7,11,13,17,19]
 * Output: [2,3,5,17,7,11,13,19]
 * Example 5:
 *
 * Input: arr = [10,100,1000,10000]
 * Output: [10,100,10000,1000]
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 */
public class SortIntegersbyTheNumberBits {
    public static void main(String[] args) {
        int[] arr = new int[]{1024,512,256,128,64,32,16,8,4,2,1};
        SortIntegersbyTheNumberBits sortIntegersbyTheNumberBits = new SortIntegersbyTheNumberBits();
        int[] result = sortIntegersbyTheNumberBits.sortByBitsV2(arr);
        System.out.println(result);
    }

    public int[] sortByBits(int[] arr) {
        return  Arrays.stream(arr).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Integer.bitCount(o1) == Integer.bitCount(o2))
                    return o1 - o2;
                else
                    return Integer.bitCount(o1) - Integer.bitCount(o2);
            }
        }).mapToInt(e-> e).toArray();
    }


    public int[] sortByBitsV2(int[] arr) {
        quickSort(arr,0,arr.length-1);
        return arr;
    }

    public void quickSort(int[] arr, int p, int q){
        if(p>=q) return;
        int pivotCount = Integer.bitCount(arr[q]);
        int i = p-1;
        int temp;
        for(int j=p;j<q;j++){
            int count = Integer.bitCount(arr[j]);
            if(count<pivotCount || (count==pivotCount && arr[j]<arr[q])){
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        temp = arr[q];
        arr[q] = arr[i];
        arr[i] = temp;

        quickSort(arr,p,i-1);
        quickSort(arr,i+1,q);
    }
}
