package lesson09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayListInteger {
    public static void main(String[] args) {
    List<Integer> integers = new ArrayList<>();
        integers.add(4);
        integers.add(5);
        integers.add(-6);
        integers.add(4);
        integers.add(5);
        integers.add(4);
        integers.add(3);
        integers.add(2);
        integers.add(4);
        integers.add(5);
        integers.add(7);
        integers.add(5);
    Map<Integer, Integer> count = new HashMap<>();

        for (Integer i : integers) {
            if (count.containsKey(i)){
                count.put(i, count.get(i)+1);
            }
            count.put(i, 1);
        }
        System.out.println(count);
    }
}
