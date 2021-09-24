package lesson10.streamAPI;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;

public class IntStream {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 0, 3, 0};

        OptionalDouble average = Arrays.stream(array)
                .mapToDouble(Integer::intValue).average();


        Integer min = Arrays.stream(array)
                .map(i -> new AbstractMap.SimpleEntry<Integer, Integer>(array[i], i))
                .min(comparingInt(AbstractMap.SimpleEntry::getValue))
                .map(AbstractMap.SimpleEntry::getKey)
                .orElse(-1);


        Long nullCount = Arrays.stream(array)
                .filter(x -> x == 0)
                .count();

        Long aboveNull = Arrays.stream(array)
                .filter(x -> x > 0)
                .count();

        Arrays.stream(array)
                .map((s)->s*4)
                .forEach(System.out::println);

        System.out.println("average " + average);
        System.out.println("min " + min);
        System.out.println("nullCount " + nullCount);
        System.out.println("aboveNull " + aboveNull);
    }

}
//Задание 1 Stream.
//
//        Сделать массив int. Из него получить IntStream. Для него
//
//        1. Найти среднее значение элементов массива
//
//        2. Найти минимальный элемент, значение и индекс
//
//        3. Посчитать количество элементов равных нулю
//
//        4. Посчитать количество элементов больше нуля
//
//        5. Помножить элементы массива на число