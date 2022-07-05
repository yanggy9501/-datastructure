package com.app.tools.datamoudle.test;

import com.app.tools.datamoudle.utils.HeapSortUtil;

import java.util.Arrays;

/**
 * @author yanggy
 */
public class HeapSortTest {
    public static void main(String[] args) {
        Integer[] arr = {4, 6, 8, 5, 9, -2, 55, 23, 0, -65, 1000};
        HeapSortUtil.heapSort(arr, Integer::compareTo);
        System.out.println(Arrays.toString(arr));
    }
}
