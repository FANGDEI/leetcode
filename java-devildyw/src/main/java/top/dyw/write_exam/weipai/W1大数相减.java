package top.dyw.write_exam.weipai;


public class W1大数相减 {

    public static void main(String[] args) {
        String A = "123456789123456789";
        String B = "3213198765432198765432";


        if (compare(A, B) < 0) {
            String temp = A;
            A = B;
            B = temp;
        }
        // 这里需要分情况讨论
        String result = subtract(A, B);
        System.out.println(result); // 输出 24691356924691357
    }

    public static String subtract(String A, String B) {
        // 假设 A >= B 且都是非负整数

        int n = A.length();
        int m = B.length();

        StringBuilder sb = new StringBuilder();
        int i = n-1;
        int j = m-1;
        int borrow = 0;
        while (i>=0) {
            int digitA = A.charAt(i) - '0';
            int digitB = j>=0 ? B.charAt(j) - '0' : 0;

            int diff = digitA - digitB - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            sb.insert(0,diff);

            i--;
            j--;
        }

        //去掉前导0
        while(sb.length()>0 && sb.charAt(sb.length()-1) == '0') {
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }

    private static int compare(String A, String B) {
        if (A.length() != B.length()) {
            return A.length() - B.length();
        }
        return A.compareTo(B); // 字典序比较
    }
}
