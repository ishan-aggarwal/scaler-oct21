//Problem Description
//
//Given two binary strings, return their sum (also a binary string).
//Example: ``` a = "100"
//
//b = "11" Return a + b = "111". ```
//

package day5.Homework;

public class AddBinaryStrings {

    public static String addBinarySimple(String a, String b) {
        StringBuilder result = new StringBuilder();
        //[0 , n - 1]
        int n = a.length() - 1;
        int m = b.length() - 1;
        int carry = 0;

        while (n >= 0 || m >= 0) {
            int sum = 0;
            if (n >= 0) { // till the time string a is not exhausted
                sum += (a.charAt(n) - '0');
                n--;
            }
            if (m >= 0) {
                sum += (b.charAt(m) - '0');
                m--;
            }
            sum += carry;
            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry == 1) {
            result.append(1);
        }

        return result.reverse().toString();
    }

    public static String addBinary(String A, String B) {
        int i = A.length() - 1;
        int j = B.length() - 1;

        String res = "";
        int sum = 0;
        while (i >= 0 || j >= 0 || sum == 1) {

            if (i >= 0) {
                sum = sum + (A.charAt(i) - '0');
            }

            if (j >= 0) {
                sum = sum + (B.charAt(j) - '0');
            }

            res = (char) (sum % 2 + '0') + res;
            sum = sum / 2;

            i--;
            j--;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(addBinary("100", "11"));
        System.out.println(addBinarySimple("110", "11"));
    }
}
