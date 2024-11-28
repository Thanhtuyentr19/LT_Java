import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Io_SoNguyen {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Nhập số nguyên dương m: ");
        int m = Integer.parseInt(br.readLine());

        System.out.println("Tổng các chữ số của m là: " + tinhTongChuSo(m));
        System.out.println("Số đảo ngược của m là: " + daoNguoc(m));
        System.out.println("Số m có thuộc dãy Fibonacci không? " + kiemTraFibonacci(m));
        System.out.println("Số đảo ngược của m có phải là số đối xứng không? " + kiemTraSoDoiXung(m));
    }

    private static int tinhTongChuSo(int m) {
        int sum = 0;
        while (m > 0) {
            sum += m % 10;
            m /= 10;
        }
        return sum;
    }

    private static int daoNguoc(int m) {
        int reverse = 0;
        while (m > 0) {
            reverse *= 10;
            reverse += m % 10;
            m /= 10;
        }
        return reverse;
    }

    private static boolean kiemTraFibonacci(int m) {
        if (m == 0 || m == 1) {
            return true;
        }

        int a = 0, b = 1, c = 0;
        while (c < m) {
            c = a + b;
            if (c == m) {
                return true;
            }
            a = b;
            b = c;
        }

        return false;
    }

    private static boolean kiemTraSoDoiXung(int m) {
        int temp = m;
        int reverse = 0;
        while (temp > 0) {
            reverse *= 10;
            reverse += temp % 10;
            temp /= 10;
        }

        return m == reverse;
    }
}
