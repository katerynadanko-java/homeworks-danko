package lesson09;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayListWithoutRemove();
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        System.out.println(integers);

        integers.remove(2);
        integers.removeAll(integers);
        integers.remove(5);
        System.out.println(integers);

    }
}
