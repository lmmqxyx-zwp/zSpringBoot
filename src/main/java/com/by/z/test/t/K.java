package com.by.z.test.t;

import java.util.*;

/**
 * 17、list中元素去重
 */
public class K {

    public static void main(String[] args) throws Exception{
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(8);
        list.add(1);
        list.add(2);
        list.add(9);
        list.add(0);

        outputList(list);

        Set<Integer> set = new HashSet<>(list);

        list.clear();
        outputList(list);

        list.addAll(set);
        outputList(list);

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 < o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

//        list.sort(c);

        Collections.sort(list, c);
        outputList(list);
    }

    /**
     * 输出List
     *
     * @param l
     */
    public static void outputList(List<?> l) {
        int count = 0;
        for (Object o: l
             ) {
            System.out.println(o);
            count ++;
        }

        System.out.println("===");
        System.out.println(" :" + count);
    }

}
