import javax.swing.JOptionPane;

public class Bai2 {
    public static void main(String[] args) {
        int m = Integer.parseInt(JOptionPane.showInputDialog("Nhập vào một số nguyên dương m:"));

        // a. Tính tổng các chữ số của m
        int sumOfDigits = 0;
        int temp = m;
        
        while (temp > 0) {
            sumOfDigits += temp % 10;
            temp /= 10;
        }
        
        System.out.println("Tổng các chữ số của m: " + sumOfDigits);

        // b. In ra số đảo ngược của m
        int reversedNumber = 0;
        temp = m;

        while (temp > 0) {
            reversedNumber = reversedNumber * 10 + temp % 10;
            temp /= 10;
        }

        System.out.println("Số đảo ngược của m: " + reversedNumber);

        // c. Kiểm tra có thuộc dãy Fibonacci không
        boolean isFibonacci = isFibonacci(m);
        System.out.println("m có thuộc dãy Fibonacci không? " + isFibonacci);

        // d. Kiểm tra đảo ngược có phải số đối xứng không
        boolean isPalindrome = (m == reversedNumber);
        System.out.println("Đảo ngược của m có phải là số đối xứng không? " + isPalindrome);
    }

    private static boolean isFibonacci(int n) {
        int a = 0, b = 1, c;
        
        if (n == a || n == b) return true;

        while (b < n) {
            c = a + b;
            a = b;
            b = c;
            if (b == n) return true;
        }
        
        return false;
    }
}