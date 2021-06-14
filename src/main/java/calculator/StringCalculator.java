package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

    public static int splitAndSum(String stringNumber) {
        if(stringNumber == null || stringNumber.isEmpty())  return 0;
        int[] numbers = switchToNumbers(stringNumber);
        checkValication(numbers);

        return IntStream.of(numbers).sum();
    }

    public static int[] switchToNumbers(String stringNumber){
        String customDelimiter = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(stringNumber);

        if (m.find()) {
            customDelimiter = m.group(1);
            stringNumber = m.group(2);
        }

        return Stream.of(stringNumber.split(customDelimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void checkValication(int[] numbers) {
        long countNegative = IntStream.of(numbers).filter(x -> x<0 ).count();
        if(countNegative>0) throw new RuntimeException();
    }
}
