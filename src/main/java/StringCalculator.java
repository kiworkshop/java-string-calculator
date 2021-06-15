import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String numbers = "^[0-9]*$";
    private static final String delimiter = "[,:]";

    public static int splitAndSum(String text){
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] tokens= text.split(delimiter);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }

        return validateAndSum(tokens);
    }

    private static int validateAndSum(String[] tokens) {
        int sum = 0;
        for (String token : tokens){
            if (!Pattern.matches(numbers, token)) {
                throw new RuntimeException();
            }

            int number = Integer.parseInt(token);
            if (number < 0){
                throw new RuntimeException();
            }
            sum += number;
        }
        return sum;
    }
}
