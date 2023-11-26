import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


class RandomizedSet {
    private Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        final int size = set.size();
        int i = (int) (Math.random() * size) + 1;
        Iterator iterator = set.iterator();
        int ans = 0;
        while (i != 0) {
            ans = (Integer) iterator.next();
            i--;
        }
        return ans;
    }
}
