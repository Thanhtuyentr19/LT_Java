import java.util.Scanner;

public class bai10 {

    int n;

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap n: ");
        n = scanner.nextInt();
        scanner.close();


    }

    public int giaithua(int m) {
        if (m == 0)
            return 1;
        else
            return m * giaithua(m - 1);
    }

    public void tinh() {
        float s = 0.0f;
        for (int i = 1; i < 2 * n; i += 2)
            s += 1.0f / giaithua(i);
        System.out.println("S = " + s);
    }

    public static void main(String[] args) {
        bai10 b = new bai10();
        b.nhap();
        b.tinh();
    }
}