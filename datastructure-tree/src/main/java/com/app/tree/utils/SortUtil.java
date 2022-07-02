package com.app.tree.utils;

import java.util.Comparator;

/**
 * 排序工具类
 *
 * @author yanggy
 */
public class SortUtil {

    /**
     * 堆排序 array
     *
     * @param array 待排序数组
     * @param comparator 比较器
     * @param <T> 泛型
     */
    public static <T> void heapSort(T[] array, Comparator<T> comparator) {
        if (array == null || array.length == 0) {
            return;
        }
        buildMaxHeap(array, comparator);
        // 排序，每次堆顶与最后一位待排位置进行交换
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i, comparator);
        }
    }

    /**
     * 大顶堆调整
     * 实现：保存当前子树 root 节点，孩子节点上移，root放到最终位置。
     *
     * @param array 待调整数组
     * @param index 待调整子树root 的下标
     * @param length 待调整数组的剩余长度
     * @param comparator 比较器
     * @param <T> 泛型
     */
    private static <T> void adjustHeap(T[] array, int index, int length, Comparator<T> comparator) {
        T temp = array[index];
        // left + 1 = 2 * (current + 1) --> left = 2 * current +1
        for (int i = (index << 1) + 1; i < length; i++) {
            if (i + 1 < length && comparator.compare(array[i], array[i + 1]) < 0) {
                // go right
                i++;
            }
            if (comparator.compare(array[i], temp) > 0) {
                array[index] = array[i];
                index = i;
            } else {
                // big heap finished
                break;
            }
        }
        array[index] = temp;
    }

    /**
     * 构建大顶堆
     *
     * @param array 待调整数组
     * @param comparator 比较器
     * @param <T> 泛型
     */
    private static <T> void buildMaxHeap(T[] array, Comparator<T> comparator) {
        // 从第一个非叶子节点开始
        for (int i = (array.length >> 1) - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length, comparator);
        }
    }

    /**
     * 交换数组两个下标位置
     *
     * @param array 数组
     * @param index1 数组下标
     * @param index2 数组下标
     * @param <T> 泛型
     */
    private static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
