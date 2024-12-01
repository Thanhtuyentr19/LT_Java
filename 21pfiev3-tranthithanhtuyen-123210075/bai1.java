public class bai1 {
    public static void main(String[] args) {
        int a = 5;
        int b = 2;
        int c = 8;

        int max = findMax(a, b, c);

        System.out.println("Giá trị lớn nhất là: " + max);
    }

    public static int findMax(int a, int b, int c) {
        int max = a;

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        return max;
    }
}