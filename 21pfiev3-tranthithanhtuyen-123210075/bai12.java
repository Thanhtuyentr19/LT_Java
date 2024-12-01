import java.util.Scanner;

public class bai12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên dương m: ");
        int m = scanner.nextInt();

        int sum = calculateSumOfDigits(m);
        int product = calculateProductOfDigits(m);

        System.out.println("Tổng các chữ số của " + m + " là: " + sum);
        System.out.println("Tích các chữ số của " + m + " là: " + product);
        scanner.close();

    }

    public static int calculateSumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        return sum;
    }

    public static int calculateProductOfDigits(int number) {
        int product = 1;
        while (number != 0) {
            int digit = number % 10;
            product *= digit;
            number /= 10;
        }
        return product;
    }
}