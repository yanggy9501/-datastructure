package com.app.datastruct.algorithm.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪心算法
 * 思想：每次最优--结果最优
 *
 * @author yanggy
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        // 创建广播电台
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();

        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");

        HashSet<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");

        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("深圳");

        HashSet<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");

        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");
        // 加入到map
        broadcasts.put("k1", set1);
        broadcasts.put("k2", set2);
        broadcasts.put("k3", set3);
        broadcasts.put("k4", set4);
        broadcasts.put("k5", set5);

        // 所有地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.addAll(set1);
        allAreas.addAll(set2);
        allAreas.addAll(set3);
        allAreas.addAll(set4);
        allAreas.addAll(set5);

        // 存放已经选择的电台集合
        ArrayList<String> select = new ArrayList<>();

        // 临时遍历，存放遍历过程中电台覆盖地区和当前还没有覆盖地区的交集
        HashSet<String> tempSet = new HashSet<>();
        while (allAreas.size() != 0) {
            String maxKey = null;
            // 遍历每个电台
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                // 该电台覆盖地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                // 求交集，该电台覆盖了多少个还没有选择的地区
                tempSet.retainAll(allAreas);
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                select.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println(select);
    }
}
