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

    public static final String delimeter1 = ",";
    public static final String delimeter2 = ":";

    public static int splitAndSum(String text) throws RuntimeException{
        if(text == null | "".equals(text)) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            String customDelimeter = m.group(1);
            String content = m.group(2);

            return seperateAndCalculate(content, customDelimeter);
        }
        return seperateAndCalculate(text, delimeter1 + "|" + delimeter2);
    }

    public static int seperateAndCalculate(String text, String delimeter) throws RuntimeException{
        String[] numbers = text.split(delimeter);
        int[] intArr = new int[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            intArr[i] = Integer.parseInt(numbers[i]);
        }

        Arrays.stream(intArr).forEach(StringCalculator::negativeCheck);

        return Arrays.stream(intArr).sum();
    }

    public static void negativeCheck(int input) throws RuntimeException{
        if(input < 0) {
            throw new RuntimeException();
        }
    }
}
