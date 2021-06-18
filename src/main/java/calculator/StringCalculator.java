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

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String DESIGNATED_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String text) throws RuntimeException {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        Matcher m = Pattern.compile(DESIGNATED_PATTERN).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String content = m.group(2);
            return separateAndCalculate(content, customDelimiter);
        }
        return separateAndCalculate(text, DEFAULT_DELIMITERS);
    }

    public static int separateAndCalculate(String text, String delimeter) throws RuntimeException {
        String[] numbers = text.split(delimeter);
        int[] intArr = new int[numbers.length];
        int sum = 0;

        try {
            for (int i = 0; i < numbers.length; i++) {
                intArr[i] = Integer.parseInt(numbers[i]);
            }
        } catch (NumberFormatException ne) {
            System.out.println("숫자만 입력해주세요.");
            return 0;
        }

        for(int element : intArr) {
            negativeCheck(element);
            sum += element;
        }

        return sum;
    }

    public static void negativeCheck(int input) throws RuntimeException {
        if (input < 0) {
            throw new RuntimeException("음수는 처리할 수 없습니다. 0 이상의 수를 입력해주세요.");
        }
    }
}
