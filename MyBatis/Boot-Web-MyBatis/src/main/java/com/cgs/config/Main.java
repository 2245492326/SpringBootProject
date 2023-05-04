package com.cgs.config;
import java.util.HashSet;
import java.util.Random;

/**
 * @Create 2023-03-02 21:35
 * @Author cgs
 * @Version 1.0
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        // 创建一个HashSet集合，用来存储不重复的随机数
        HashSet<Integer> set = new HashSet<>();
        // 创建一个Random对象，用来生成随机数
        Random random = new Random();
        // 循环生成并添加随机数，直到集合的大小达到10
        while (set.size() < 10) {
            // 生成一个1到20之间的随机整数
            int num = random.nextInt(20) + 1;
            // 将随机数添加到集合中，如果已经存在则不会添加
            set.add(num);
        }
        // 创建一个Iterator对象，用来遍历集合中的元素
        // 循环遍历并打印集合中的元素
        for (Integer integer : set) {
            // 获取并打印下一个元素
            System.out.println(integer);
        }
    }
}
