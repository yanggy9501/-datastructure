package com.app.datastruct.algorithm.dynamic;

import java.util.Arrays;
import java.util.Objects;

/**
 * 背包问题
 * 要求：物品不可重复，在指定容量的情况下，背包装的物品价值最高
 *
 * @author yanggy
 */
public class KnapsackPromblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3}; // 物品的重量
        int[] val = {1500, 3000, 2000}; // 物品的价值
        int m = 4; // 背包的容量
        int n = val.length; // 物品的个数

        // 创建二维数组
        // v[i][j] 表示在前i个物品中能够装入容量为j的背包的最大价值
        int[][] v = new int[n + 1][m + 1];
        // 记录存放组合
        String[][] path = new String[n + 1][m + 1];
        // 初始化path
        for (String[] strings : path) {
            Arrays.fill(strings, "");
        }

        // 初始化第一行和第一列（默认是0，这里不处理）

        // 动态规划
        for (int i = 1; i < v.length; i++) { // 不处理第一行，i 第i个物品
            for (int j = 1; j < v[0].length; j++) { // 不处理第一列，j容量
                if (w[i - 1] > j) { // 因为 i 从1开始
                    v[i][j] = v[i - 1][j];
                    path[i][j] = path[i - 1][j];
                } else {
                    // v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] =  val[i - 1] + v[i - 1][j - w[i - 1]];
                        // i - l是当前的，path[i - 1][j - w[i - 1]]是v[i - 1][j - w[i - 1]]的
                        if (path[i - 1][j - w[i - 1]] != null && !Objects.equals(path[i - 1][j - w[i - 1]], "")) {
                            path[i][j] = String.join(",", path[i - 1][j - w[i - 1]], "" + (i - 1));
                        } else {
                            path[i][j] = "" + (i - 1);
                        }
                    } else {
                        v[i][j] = v[i - 1][j];
                        path[i][j] = path[i - 1][j];
                    }
                }
            }
        }

        // 输出
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }
}
