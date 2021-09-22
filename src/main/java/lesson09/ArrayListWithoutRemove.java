package lesson09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class ArrayListWithoutRemove extends ArrayList{
    @Override
    public Object remove(int index) {
        System.out.println("Don`t remove " + index + "!!!");
        return (index);
    }

    @Override
    public boolean remove(Object o) {
        System.out.println("Don`t remove " + o + "!!!");
        return false;
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        System.out.println("Don`t remove!");
    }

    @Override
    public boolean removeAll(Collection c) {
        System.out.println("Don`t remove collection " + c + "!!!");
        return false;
    }

    @Override
    public void clear() {
        System.out.println("Don`t remove!");
    }

    @Override
    public boolean removeIf(Predicate filter) {
        System.out.println("Don`t remove " + filter + "!!!");
        return false;
    }

    public static void main(String[] args) {
    }
}