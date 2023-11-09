import java.util.PriorityQueue;


class SeatManager {
    private final PriorityQueue<Integer> seats;
    private final int size;

    public SeatManager(int n) {
        seats = new PriorityQueue<>();
        size = n;
        for (int i = 0; i < n; i++) {
            seats.add(i + 1);
        }
    }

    public int reserve() {
        int reservedSeat = seats.remove();
        return reservedSeat;
    }

    public void unreserve(int seatNumber) {
        seats.add(seatNumber);
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
        System.out.println(seatManager.reserve());

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