import java.util.Arrays;

public class Solution {
    private final static int MODULO = 1_000_000_007;

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private void test() {
        System.out.println(numberOfWays("SSPPSPSSSSS"));
    }

    private void test1() {
        String s = "PPSPSP";
        System.out.println(numberOfWays(s) + " " + s);
    }

    private void test2() {
        String s = "S";
        System.out.println(numberOfWays(s) + " " + s);
    }

    private void test3() {
        String s = "SSPPSPSPPPSPPPPS";
        System.out.println(numberOfWays(s) + " " + s);
    }

    private void test4() {
        String s = "SSPPSPSPPPSPPPPPPPPPPPPPPPPPPPPPPS";
        System.out.println(numberOfWays(s) + " " + s);
    }

    private void test5() {
        String s = "PPPPPSPPSPPSPPPSPPPPSPPPPSPPPPSPPSPPPSPSPPPSPSPPPSPSPPPSPSPPPPSPPPPSPPPSPPSPPPPSPSPPPPSPSPPPPSPSPPPSPPSPPPPSPSPSS";
        System.out.println(numberOfWays(s) + "ожидается   " + 919999993 + "  " + s);
    }

    private void test6() {
        String s = "PPPPPPPSPPPSPPPPSPPPSPPPPPSPPPSPPSPPSPPPPPSPSPPPPPSPPSPPPPPSPPSPPSPPPSPPPPSPPPPSPPPPPSPSPPPPSPSPPPSPPPPSPPPPPSPSPPSPPPPSPPSPPSPPSPPPSPPSPSPPSSSS";
        System.out.println(numberOfWays(s) + "ожидается   " + 18335643 + "  " + s);
    }

    public int numberOfWays(String corridor) {
        final int seatQuantity = getPairsQuantity(corridor);
        if (seatQuantity <= 1 || seatQuantity % 2 != 0) {
            return 0;
        }
        if (seatQuantity == 2) {
            return 1;
        }
        final int pairsQuantity = seatQuantity / 2;
        final int[] plantsBetweenSeatQuantities = getPlantsBetweenSeatQuanties(pairsQuantity, corridor);
        System.out.println(Arrays.toString(plantsBetweenSeatQuantities));
        long result = 1;
        for (int plantsBetweenSeatQuantity : plantsBetweenSeatQuantities) {
            result = (result * (plantsBetweenSeatQuantity + 1)) % MODULO;
            result %= MODULO;
        }
        return (int) result;
    }

    private int getPairsQuantity(String corridor) {
        int pairsQuantity = 0;
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                pairsQuantity++;
            }
        }
        return pairsQuantity;
    }

    private int[] getPlantsBetweenSeatQuanties(int pairsQuantity, String corridor) {
        final int[] plantsBetweenSeatQuantities = new int[pairsQuantity - 1];
        int index = 0;
        for (int i = 0; i < pairsQuantity - 1; i++) {
            int seatQuntity = 0;
            int plantsBetweenSeatQuantity = 0;
            while (seatQuntity != 2) {
                if (corridor.charAt(index++) == 'S') {
                    seatQuntity++;
                }
            }
            while (corridor.charAt(index) == 'P') {
                plantsBetweenSeatQuantity++;
                index++;
            }
            plantsBetweenSeatQuantities[i] = plantsBetweenSeatQuantity;
        }
        return plantsBetweenSeatQuantities;
    }
}