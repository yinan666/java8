package com.wangyn.test.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @description:
 * @author: wangyinan02
 * @date: 2018/6/14
 * @time: 上午11:59
 * Copyright (C) 2018 mine
 * All rights reserved
 */
public class TestStream {
    public static void main(String[] args) {
        List<Dish> dishList = new ArrayList<>();
        dishList.add(new Dish("牛肉", 375, DishType.MEET));
        dishList.add(new Dish("猪肉", 575, DishType.MEET));
        dishList.add(new Dish("白菜", 125, DishType.VAGTABLE));
        dishList.add(new Dish("黄油", 1233, DishType.OTHER));
        dishList.add(new Dish("黄瓜", 45, DishType.VAGTABLE));
        dishList.add(new Dish("白糖", 777, DishType.OTHER));
        testToMap2(dishList);
    }



    public static void testGroupn(List<Dish> dishList) {
        LinkedHashMap map = dishList.stream().collect(Collectors.groupingBy(Dish::getDishType, LinkedHashMap::new,
                Collectors.toList()));
    }

    public static void testToMap2(List<Dish> dishList) {
        Map<String, Dish> map = dishList.stream().collect(Collectors.toMap(Dish::getName, Function.identity()));
        System.out.println(map);
    }

    public static void testToMap(List<Dish> dishList) {
        Map<String, Integer> map = dishList.stream().collect(Collectors.toMap(Dish::getName, Dish::getCalories));
        System.out.println(map);
    }

    public static void sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        System.out.println(accumulator.total);
    }

    public static class Accumulator {

        public long total = 0;

        public void add(long value) {
            total += value;
        }
    }
    /// 79826082,74647702,78715268
    //87635823,87186426,89115338

    public static void testParallelStream1() {
        long times = System.nanoTime();
//        Optional s = Stream.iterate(1,i->i+1)
//                .limit(10000)
//                .parallel()
//                .reduce((i,j)->i+j);
        OptionalLong s = LongStream.rangeClosed(1, 10000)
                .parallel()
                .reduce((i, j) -> i + j);
        times = System.nanoTime() - times;
        System.out.println("cost:" + times + ",result:" + s.getAsLong());
    }


    public static void testPartitionBy4() {
        Map<Boolean, List<Integer>> map = IntStream.rangeClosed(0, 100).boxed().collect(Collectors.partitioningBy(a
                -> a % 2 == 0));
        System.out.println(map);
    }

    public static void testPartitionBy3(List<Dish> dishList) {
//        Map<Boolean,Optional<Dish>> map = dishList.stream().collect(Collectors.partitioningBy(a -> a.getDishType()
// == DishType.MEET,Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
        Map<Boolean, String> map = dishList.stream().collect(Collectors.partitioningBy(a -> a.getDishType() ==
                DishType.MEET, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Dish::getCalories))
                , opt -> opt.get().getName())));
        System.out.println(map);
    }

    public static void testPartitionBy2(List<Dish> dishList) {
        Map<Boolean, Map<String, List<Dish>>> map = dishList.stream().collect(Collectors.partitioningBy(a -> a
                        .getDishType() == DishType.MEET,
                Collectors.groupingBy(a -> {
                    if (a.getCalories() > 400) {
                        return "high";
                    } else {
                        return "low";
                    }
                })
        ));
        System.out.println(map);
    }

    public static void testPartitionBy1(List<Dish> dishList) {
        Map<Boolean, List<Dish>> map = dishList.stream().collect(Collectors.partitioningBy(a -> a.getDishType() ==
                DishType.MEET));
        System.out.println(map);
    }

    public static void testGroup8(List<Dish> dishList) {
        Map<DishType, List<Dish>> map = dishList.stream().collect(Collectors.groupingBy(Dish::getDishType, Collectors
                .toCollection(LinkedList::new)));
        System.out.println(map);
    }

    public static void testGroup7(List<Dish> dishList) {
        Map<DishType, List<String>> map = dishList.stream().collect(Collectors.groupingBy(Dish::getDishType,
                Collectors.mapping(Dish::getName, Collectors.toCollection(LinkedList::new))));
        System.out.println(map);
    }

    public static void testGroup6(List<Dish> dishList) {
        Map<DishType, List<String>> map = dishList.stream().collect(Collectors.groupingBy(Dish::getDishType,
                Collectors.mapping(a -> {
            if (a.getCalories() > 400) {
                return "high";
            } else {
                return "low";
            }
        }, Collectors.toList())));
        System.out.println(map);
    }

    public static void testGroup5(List<Dish> dishList) {
        Map<DishType, Dish> map2 = dishList.stream().collect(Collectors.groupingBy(Dish::getDishType,
                Collectors.collectingAndThen(
                        Collectors.maxBy(
                                Comparator.comparing(Dish::getCalories)
                        ),
                        Optional::get
                )));
        System.out.println(map2);
    }

    public static void testGroup4(List<Dish> dishList) {
        Map<DishType, Integer> map2 = dishList.stream().collect(Collectors.groupingBy(Dish::getDishType, Collectors
                .summingInt(Dish::getCalories)));
        System.out.println(map2);
    }

    public static void testGroup3(List<Dish> dishList) {
        Map<DishType, Map<String, List<Dish>>> map = dishList.stream().collect(Collectors.groupingBy
                (Dish::getDishType, Collectors.groupingBy(a -> {
                    if (a.getCalories() > 400) {
                        return "high";
                    } else {
                        return "low";
                    }
                })));
        System.out.println(map);
    }

    public static void testGroup2(List<Dish> dishList) {
        Map<String, List<Dish>> map = dishList.stream().collect(Collectors.groupingBy(a -> {
            if (a.getCalories() > 400) {
                return "high";
            } else {
                return "low";
            }
        }));
        System.out.println(map);
    }

    public static void testGroup(List<Dish> dishList) {
        Map<DishType, List<Dish>> map = dishList.stream().collect(Collectors.groupingBy(Dish::getDishType));
        System.out.println(map);
    }

    public static void testReducing4(List<Dish> dishList) {
//        String str = dishList.stream().collect(Collectors.reducing("",Dish::getName,(i,j) -> i+","+j));
        String str = dishList.stream().map(Dish::getName).collect(Collectors.reducing((i, j) -> i + "," + j)).get();

        System.out.println(str);
    }

    public static void testReducing3(List<Dish> dishList) {
        int count = dishList.stream().collect(Collectors.reducing(0, a -> 1, Integer::sum));
        dishList.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(count);
    }

    public static void testReducing2(List<Dish> dishList) {
        Optional<Dish> optional = dishList.stream().collect(Collectors.reducing((a, b) -> a.getCalories() > b
                .getCalories() ? a : b));
        System.out.println(optional.get().getName());
    }

    public static void testReducing(List<Dish> dishList) {
        int totalCalories = dishList.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(totalCalories);
    }

    public static void testJoining(List<Dish> dishList) {
        String names = dishList.stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(names);
    }

    public static void testSummarizing(List<Dish> dishList) {
        IntSummaryStatistics statistics = dishList.stream()
                .collect(Collectors.summarizingInt(Dish::getCalories));
        double avg = statistics.getAverage();
        long count = statistics.getCount();
        int max = statistics.getMax();
        int min = statistics.getMin();
        long sum = statistics.getSum();
    }

    public static void testAvg(List<Dish> dishList) {
        double avgval = dishList.stream()
                .collect(Collectors.averagingInt(Dish::getCalories));
    }

    public static void testSumming(List<Dish> dishList) {
        int total = dishList.stream()
                .collect(Collectors.summingInt(Dish::getCalories));
    }

    public static void testMax(List<Dish> dishList) {
        Comparator<Dish> comparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> optional = dishList.stream()
                .collect(Collectors.maxBy(comparator));
    }

    public static void testCounting(List<Dish> dishList) {
        long count = dishList.stream().collect(Collectors.counting());
    }

    public static void testGroupBy(List<Dish> dishList) {
        dishList = new ArrayList<>();

        Map<DishType, List<Dish>> map = dishList.stream()
                .collect(Collectors.groupingBy(Dish::getDishType));
        System.out.println(map);
    }

    public static void testStreamTo() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
    }

    public static void testGougu() {
        List list = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                )
                .collect(Collectors.toList());
        System.out.println(list);
    }

    public static void testRanage() {
        long count = IntStream.range(1, 100).filter(a -> a % 2 == 0).count();
        System.out.println(count);
    }

    public static void testRanageClosed() {
        long count = IntStream.rangeClosed(1, 100).filter(a -> a % 2 == 0).count();
        System.out.println(count);
    }

    public static void testReduce_total(List<Dish> dishList) {
//        int total = dishList.stream().map(a -> 1).reduce(0,(a,b) -> a+b);
        long total = dishList.stream().count();
        System.out.println("total count : " + total);
    }

    public static void testReduce_min() {
        int[] ary = new int[]{2, 40, 23, 10, 50, 5, 8};
//        OptionalInt optional = Arrays.stream(ary).reduce((a, b)-> a<b?a:b);
//        OptionalInt optional = Arrays.stream(ary).reduce(Integer::min);
        OptionalInt optional = Arrays.stream(ary).min();
        if (optional.isPresent()) {
            System.out.println("min value : " + optional.getAsInt());
        }
    }

    public static void testReduce_max() {
        int[] ary = new int[]{2, 40, 23, 10, 50, 5, 8};
//        OptionalInt optional = Arrays.stream(ary).reduce((a, b)-> a>b?a:b);
//        OptionalInt optional = Arrays.stream(ary).reduce(Integer::max);
        OptionalInt optional = Arrays.stream(ary).max();
        if (optional.isPresent()) {
            System.out.println("max value : " + optional.getAsInt());
        }
    }

    public static void maxCarlories(List<Dish> dishList) {
        OptionalInt optionalInt = dishList.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println(optionalInt.getAsInt());
    }

    public static void testReduce_sum() {
        int[] ary = new int[]{2, 40, 23, 10, 50, 5, 8};
        int sum = Arrays.stream(ary).sum();
        System.out.println(sum);
        List<Integer> valList = new ArrayList<>();
    }

    public static void sumCarlories(List<Dish> dishList) {
        int calories = dishList.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(calories);
    }

    public static void sumCarlories2(List<Dish> dishList) {
        IntStream intStream = dishList.stream()
                .mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
    }


    public static void testFindFirst(List<Dish> dishList) {
        Optional<Dish> optional = dishList.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .findFirst();
        if (optional.isPresent()) {
            Dish dish = optional.get();
            System.out.println(dish.getName());
        }
    }

    public static void testFindAny(List<Dish> dishList) {
        Optional<Dish> optional = dishList.stream()
                .filter(dish -> dish.getCalories() < 400)
                .findAny();
        if (optional.isPresent()) {
            Dish dish = optional.get();
            System.out.println(dish.getName());
        }
    }

    public static void testAllMatch(List<Dish> dishList) {
        if (dishList.stream().allMatch(d -> d.getCalories() < 400)) {
            System.out.println("这是一份素菜菜单");
        } else {
            System.out.println("不是一份素菜菜单");
        }
    }

    public static void testAnyMatch(List<Dish> dishList) {
        if (dishList.stream().anyMatch(d -> d.getCalories() > 1000)) {
            System.out.println("有高热量的菜品");
        } else {
            System.out.println("无高热量的菜品");
        }
    }

    public static void testFlatMap4() {
        Integer[] ary1 = new Integer[]{1, 2, 3};
        Integer[] ary2 = new Integer[]{3, 4};
        List<Integer[]> aryList = Arrays.stream(ary1)
                .flatMap(a -> Arrays.stream(ary2)
                        .filter(b -> (a + b) % 3 == 0)
                        .map(b -> new Integer[]{a, b})
                )
                .collect(Collectors.toList());
        System.out.println(aryList);
    }

    public static void testFlatMap3() {
        Integer[] ary1 = new Integer[]{1, 2, 3};
        Integer[] ary2 = new Integer[]{3, 4};
        List<Integer[]> aryList = Arrays.stream(ary1)
                .flatMap(a -> Arrays.stream(ary2)
                        .map(b -> new Integer[]{a, b})
                )
                .distinct()
                .collect(Collectors.toList());
        System.out.println(aryList);
    }

    public static void testFlatMap2() {
        String[] words = new String[]{"name", "age", "success", "good", "float"};
        List<String> letters = Arrays.stream(words)
                .map(a -> a.split(""))
                .flatMap(ary -> Arrays.stream(ary))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(letters);
    }


    public static void testMap4() {
        Integer[] ary = new Integer[]{1, 2, 3, 4, 5};
        List<Integer> intlist = Arrays.stream(ary)
                .map(a -> a * a)
                .collect(Collectors.toList());
        System.out.println(intlist);
    }

    public static void testMap3() {
        String[] words = new String[]{"name", "age", "success", "good", "float"};
        Object obj = Arrays.stream(words)
                .map(a -> a.split(""))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(obj);
    }

    public static void testMap2() {
        String[] words = new String[]{"name", "age", "success", "good", "float"};
        List<Integer> lens = Arrays.stream(words)
                .map(a -> a.length())
                .collect(Collectors.toList());
        System.out.println(lens);
    }

    public static void testMap(List<Dish> dishList) {
        List<String> names = dishList.stream()
                .map(d -> d.getName())
                .collect(Collectors.toList());
    }

    public static void testFilter(List<Dish> dishList) {
        List<String> names = dishList.stream()
                .filter(d -> d.getCalories() < 400)
                .map(d -> d.getName())
                .collect(Collectors.toList());
        System.out.println(names);
    }

    public static void testDistinct(List<Dish> dishList) {
        List<String> names = dishList.stream()
                .filter(d -> d.getCalories() > 100)
                .map(d -> d.getName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(names);
    }

    public static void testLimit(List<Dish> dishList) {
        List<String> names = dishList.stream()
                .filter(d -> d.getCalories() > 100)
                .map(d -> d.getName())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(names);
    }

    public static void testSkip(List<Dish> dishList) {
        List<String> names = dishList.stream()
                .filter(d -> d.getCalories() > 100)
                .skip(2)
                .map(d -> d.getName())
                .collect(Collectors.toList());
        System.out.println(names);
    }


    public static void test2(List<Dish> dishListall) {
        List<String> names = dishListall.stream()
                .filter(d -> d.getCalories() > 10)
                .map(d -> d.getName())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(names);

    }

    public static void testFlatMap() {
        List<List<Dish>> dishListall = new ArrayList<>();
        List<Dish> dishList = new ArrayList<>();
        dishList.add(new Dish("牛肉", 375, DishType.MEET));
        dishList.add(new Dish("猪肉", 575, DishType.MEET));
        dishList.add(new Dish("白菜", 125, DishType.VAGTABLE));
        dishListall.add(dishList);
        List<Dish> dishList2 = new ArrayList<>();
        dishList2.add(new Dish("黄油", 1233, DishType.OTHER));
        dishList2.add(new Dish("黄瓜", 45, DishType.VAGTABLE));
        dishList2.add(new Dish("白糖", 777, DishType.OTHER));
        dishListall.add(dishList2);
        List<Integer> clist = new ArrayList<>();
//        dishListall.stream().forEach(dl -> dl.forEach(d -> { clist.add(d.getCalories());}));
//       Object obj = dishListall.stream().flatMap((List<Dish> dl) -> Arrays.stream(dl.toArray()));
        clist = dishListall.stream().flatMap(dl -> dl.stream().map(d -> d.getCalories())).collect(Collectors.toList());
        System.out.println(clist);
    }

    public static void testFileStream() {
        long wordCount = 0;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            wordCount = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testItearte() {
        Stream.iterate(new int[]{0, 1}, ary -> new int[]{ary[1], ary[0] + ary[1]})
                .limit(30)
                .forEach(a -> System.out.println(a[0] + "," + a[1]));
    }

    public static void testGenerate() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
