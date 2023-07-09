package bitmanipulation;

public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            xor = xor & (xor - 1);
            count++;
        }
        return count;
    }

    public static int hammindDistance1(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            if ((xor & 1) == 1)
                count++;
            xor >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.println(hammingDistance(x, y));
        System.out.println(hammindDistance1(x, y));
    }
}
