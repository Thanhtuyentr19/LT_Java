import java.util.Arrays;
import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số a: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số b: ");
        int b = scanner.nextInt();

        System.out.print("Nhập số c: ");
        int c = scanner.nextInt();

        int intermediateNumber = find(a, b, c);

        System.out.println("Số trung gian là: " + intermediateNumber);
        scanner.close();

    }

    public static int find(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        return arr[1];
    }
}