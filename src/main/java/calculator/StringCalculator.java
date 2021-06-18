package calculator;

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

    public static int separateAndCalculate(String text, String delimiter) throws RuntimeException {
        String[] numbers = text.split(delimiter);
        int[] intArr = new int[numbers.length];
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            intArr[i] = numericCheckAndParse(numbers[i]);
            sum += intArr[i];
        }

        return sum;
    }

    public static boolean isNumeric(String str) {
         return Pattern.matches("^[0-9]*$", str);
    }

    public static int numericCheckAndParse (String str) throws RuntimeException{
        if(!isNumeric(str)) {
            throw new RuntimeException("0이상의 숫자만 입력해주세요.");
        }
        return Integer.parseInt(str);
    }

}
