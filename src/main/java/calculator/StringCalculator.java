package calculator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static void main(String[] args) {
        System.out.println("덧셈을 수행할 문자열을 입력해주세요.");

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        System.out.println(splitAndSum(text));

    }

    public static int splitAndSum(String text) throws RuntimeException{
        if(text == null | "".equals(text)) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            return seperateAndCalculate(m.group(2), m.group(1));
        }
        return seperateAndCalculate(text, ",|:");
    }

    public static int seperateAndCalculate(String text, String delimeter) throws RuntimeException{
        String[] numbers = text.split(delimeter);
        int[] intArr = new int[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            intArr[i] = Integer.parseInt(numbers[i]);
            if(intArr[i] < 0) {
                throw new RuntimeException();
            }
        }
        return Arrays.stream(intArr).sum();
    }
}
