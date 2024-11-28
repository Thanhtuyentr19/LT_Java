import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Io_matrix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Nhập số dòng của ma trận: ");
        int m = Integer.parseInt(br.readLine());
        System.out.print("Nhập số cột của ma trận: ");
        int n = Integer.parseInt(br.readLine());

        int[][] a = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Nhập phần tử a[" + i + "][" + j + "]: ");
                a[i][j] = Integer.parseInt(br.readLine());
            }
        }

        System.out.println("Tích các số bội 3 nằm trên dòng đầu tiên của ma trận a là: " + TichSoBoiBa(a));
        System.out.println("Mảng một chiều X[i] là các giá trị lớn nhất trên dòng i của ma trận: ");
        int[] x = taoMangX(a);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
        System.out.println("Mảng X[i] sau khi xoá phần tử đầu tiên: ");
        xoaPhanTuDauMangX(x);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }




    private static int TichSoBoiBa(int[][] a) {
        int sum = 1;
        for (int i = 0; i < a[0].length; i++) {
            if (a[0][i] % 3 == 0) {
                sum *= a[0][i];
            }
        }
        return sum;
    }

    private static int[] taoMangX(int[][] a) {
        int[] x = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            x[i] = a[i][0];
            for (int j = 1; j < a[i].length; j++) {
                if (a[i][j] > x[i]) {
                    x[i] = a[i][j];
                }
            }
        }
        return x;
    }
    private static void xoaPhanTuDauMangX(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            x[i] = x[i + 1];
        }
        x[x.length - 1] = 0;
    }
}
