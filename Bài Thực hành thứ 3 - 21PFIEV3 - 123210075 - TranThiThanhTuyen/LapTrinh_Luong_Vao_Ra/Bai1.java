import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Bai1 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Nhập vào một chuỗi ký tự:");

        // a. In ra chuỗi đảo ngược
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("Chuỗi đảo ngược: " + reversed);

        // b. Đổi sang chữ hoa
        String upperCase = input.toUpperCase();
        System.out.println("Chữ hoa: " + upperCase);

        // c. Đổi sang chữ thường
        String lowerCase = input.toLowerCase();
        System.out.println("Chữ thường: " + lowerCase);

        // d. Đổi vừa chữ hoa vừa chữ thường
        StringBuilder mixedCase = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                mixedCase.append(Character.toLowerCase(c));
            } else {
                mixedCase.append(Character.toUpperCase(c));
            }
        }
        System.out.println("Chữ hoa và chữ thường: " + mixedCase);

        // e. Đếm số từ
        String[] words = input.split("\\s+");
        System.out.println("Số từ: " + words.length);

        // f. Bảng tần số xuất hiện của các từ
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("Bảng tần số xuất hiện:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
