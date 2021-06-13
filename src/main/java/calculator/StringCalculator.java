package calculator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class StringCalculator {
    public static void main(String[] args) {
        System.out.println("입력해주세요.");

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        System.out.println(splitAndSum(text));

    }

    public static int splitAndSum(String text) throws RuntimeException{
        // 유효성검사
        if(text == null | "".equals(text)) {
            return 0;
        }

        String[] numbers = text.split(",|:");
        int[] intArr = new int[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            intArr[i] = Integer.parseInt(numbers[i]);
            if(intArr[i] < 0) {
                throw new RuntimeException();
            }
        }

        IntStream str = Arrays.stream(intArr);
        return str.sum();
    }
}
