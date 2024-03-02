package core;

import java.util.Comparator;

/**
 * A comparator for integers that sorts them in descending order.
 */
public class DescendingIntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
