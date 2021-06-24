import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

    private static final String DEFAULT_NUMBERS = "^[0-9]*$";
    private static final String DEFAULT_DELIMITERS = "[,:]";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] tokens = split(text);
        int[] numbers = switchToNumbers(tokens);
        checkPositiveNumbers(numbers);

        return IntStream.of(numbers).sum();
    }

    private static String[] split(String text) {    // 커스텀, 지정 구분자로 split
        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITERS);
    }

    private static int[] switchToNumbers(String[] tokens) {
        return Stream.of(tokens)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void checkPositiveNumbers(int[] numbers) {
        boolean isNegativeNumber = IntStream.of(numbers)
                .anyMatch(number -> number < 0);

        if (isNegativeNumber) {
            throw new RuntimeException();
        }
    }
}
