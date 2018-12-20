package com.wangyn.test.stream.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/6/28
 * @time: 下午1:10
 * Copyright (C) 2018 mine
 * All rights reserved
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 43; i++) {
            list.add(i);
        }
        System.out.println(list);
        int total = list.size();
        int curr = 3;
        int size = 20;

        int totalPage = total % size == 0 ? total / size : total / size + 1;


        int start = (curr - 1) * size;
        int end = curr * size > total ? total : curr * size;
        System.out.println(list.subList(start, end));


    }

    public static void findByYear(List<Transaction> transactions) {
        List<Transaction> list = transactions.stream()
                .filter(a -> a.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    public static void findCitys(List<Transaction> transactions) {
        List<String> citynames = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(citynames);
    }

    public static void findCambridgeTrade(List<Transaction> transactions) {
        List<String> tradeNames = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(tradeNames);
    }

    public static void findAllTradeName(List<Transaction> transactions) {
        List<String> tradeNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(tradeNames);
    }

    public static void hasMilanTrader(List<Transaction> transactions) {
        boolean bl = transactions.stream().anyMatch(a -> a.getTrader().getCity().equals("Milan"));
        if (bl) {
            System.out.println("有米兰的交易员");
        }
    }

    public static void sumMilanTraderTotalVal(List<Transaction> transactions) {
        int sum = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Milan"))
                .map(Transaction::getValue)
                .reduce(0, (a, b) -> a + b);
        System.out.println("sum trader value :" + sum);
    }

    public static void maxVal(List<Transaction> transactions) {
        Optional<Integer> optional = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        if (optional.isPresent()) {
            System.out.println("max value :" + optional.get());
        }
    }

    public static void minValTransaction(List<Transaction> transactions) {
        Optional optional = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .findFirst();
        if (optional.isPresent()) {
            System.out.println("min transaction :" + optional.get());
        }
    }

    public static void minValTransaction2(List<Transaction> transactions) {
        Optional optional = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        if (optional.isPresent()) {
            System.out.println("min transaction :" + optional.get());
        }
    }

}
