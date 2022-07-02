package com.app.tree.test;

import com.app.tree.utils.SortUtil;

import java.util.Arrays;

/**
 * @author yanggy
 */
public class HeapSortTest {
    public static void main(String[] args) {
        Integer[] arr = {4, 6, 8, 5, 9, -2, 55, 23, 0, -65, 1000};
        SortUtil.heapSort(arr, Integer::compareTo);
        System.out.println(Arrays.toString(arr));
    }
}
