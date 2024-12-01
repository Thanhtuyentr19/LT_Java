public class bai16 {
    public static void main(String[] args) {
        int M = 12321;

        boolean isPalindrome = checkPalindrome(M);

        if (isPalindrome) {
            System.out.println(M + " là số đối xứng.");
        } else {
            System.out.println(M + " không phải là số đối xứng.");
        }
    }

    public static boolean checkPalindrome(int M) {
        int reversed = 0;
        int original = M;

        while (M != 0) {
            int digit = M % 10;
            reversed = reversed * 10 + digit;
            M /= 10;
        }

        return original == reversed;
    }
}