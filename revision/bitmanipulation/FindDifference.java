package bitmanipulation;

// https://leetcode.com/problems/find-the-difference/description/

public class FindDifference {
    public static void main(String[] args) {
        String s = "abcd", t = "abcde";
        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {
        int xor = 0;
        for (char c : s.toCharArray())
            xor ^= c;
        for (char c : t.toCharArray())
            xor ^= c;
        return (char) xor;
    }
}
