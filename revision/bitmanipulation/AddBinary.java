package bitmanipulation;

// https://leetcode.com/problems/add-binary/
public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int n = a.length() - 1;
        int m = b.length() - 1;
        while (n >= 0 || m >= 0) {
            int sum = carry;
            if (n >= 0) {
                sum += a.charAt(n) - '0';
                n--;
            }
            if (m >= 0) {
                sum += b.charAt(m) - '0';
                m--;
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0)
            sb.append(carry);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(addBinary(a, b));
    }

}
