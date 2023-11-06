


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


class SeatManager {
    private final List<Integer> seats;
    private final int size;

    public SeatManager(int n) {
        seats = new ArrayList<>();
        size = n;
        for (int i = 0; i < n; i++) {
            seats.add(i + 1);
        }
    }

    public int reserve() {
        int reservedSeat = seats.get(0);
        seats.remove(0);
        return reservedSeat;
    }

    public void unreserve(int seatNumber) {
        int indexInsert = seats.size() == 0 ? 0 : getIndexInsert(0, seats.size() - 1, seatNumber);
        seats.add(indexInsert, seatNumber);
    }

    private int getIndexInsert(int left, int right, int seatNumber) {
        if (left == right) {
            if (seats.get(left) < seatNumber && seats.get(right) > seatNumber) {
                return left;
            } else {
                return right;
            }
        }
        int mid = left + (right - left) / 2;
        if (seats.get(mid) < seatNumber) {
            return getIndexInsert(mid + 1, right, seatNumber);
        } else {
            return getIndexInsert(left, mid , seatNumber);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        solution.test();
        solution.test1();
    }

    private void test() {
        final SeatManager seatManager = new SeatManager(5);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(5);
        //
//        System.out.println(seatManager.reserve());
//        System.out.println(seatManager.reserve());

    }

    private void test1() {
        final SeatManager seatManager = new SeatManager(3);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(1);
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
        seatManager.unreserve(1);
        System.out.println(seatManager.reserve());
        seatManager.unreserve(1);
    }

}