import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Calculator1 {


    public static void main(String[] args) {
        //String stringNumber = "//;\n1;2;3";
        String stringNumber = "1111";
        //String stringNumber = "//;\n1;2;3";
        int sum = splitAndSum(stringNumber);
        System.out.println(sum);
    }

    public static int splitAndSum(String stringNumber) {
        if(stringNumber == null || stringNumber.isEmpty()) {
            return 0;
        }
        int[] numbers = switchToNumbers(stringNumber);
        int sum = IntStream.of(numbers).sum();
        return sum;
    }

    public static int[] switchToNumbers(String stringNumber){
        String customDelimiter = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(stringNumber);
        if (m.find()) {
            customDelimiter = m.group(1);
            stringNumber = m.group(2);
        }
        int[] numbers = Stream.of(stringNumber.split(customDelimiter)).mapToInt(Integer::parseInt).toArray();
        checkValication(numbers);
        return numbers;
    }

    public static void checkValication(int[] numbers) {
        for (int i = 0; i< numbers.length; i++){
            if(numbers[i]<0) {
                throw new RuntimeException();
            }
        }
    }
}
