package bitmanipulation;

public class BitWiseUtility {
    public static void main(String[] args) {
        System.out.println("BitWiseUtility");

        System.out.println("checkIthBit(5, 2) = " + checkIthBit(5, 2));
        System.out.println("checkIthBit(5, 1) = " + checkIthBit(5, 1));


        System.out.println("firstSetBit(5) = " + firstSetBit(5));
        System.out.println("firstSetBit(5) = " + firstSetBit1(5));

        System.out.println("setIthBit(5, 1) = " + setIthBit(5, 1));
        System.out.println("setIthBit(4, 2) = " + setIthBit(4, 1));


    }


    public static int firstSetBit(int n) {
        int firstSetBit = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                firstSetBit = (i + 1);
                break;
            }
        }
        return firstSetBit;
    }

    public static int firstSetBit1(int n) {
        return n & (~n - 1);
    }

    public static int setIthBit(int n, int i) {
        return n | (1 << i);
    }

    public static int clearIthBit(int n, int i) {
        return n & (~(1 << i));
    }

    public static int toggleIthBit(int n, int i) {
        return n ^ (1 << i);
    }

    public static boolean checkIthBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }


}
