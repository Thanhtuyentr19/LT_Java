
public class bai18 {
    public static boolean isPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        System.out.print("Cac so hoan hao nho hon 1000 la: ");
        for (int i = 2; i < 1000; i++) {
            if (isPerfectNumber(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

    }


}