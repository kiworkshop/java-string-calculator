package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherStudyTest {
    public static void main(String[] args) {
        String input = "//;\n1;2;3";
        System.out.println("input: " + input);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()) {
            // 분리된 문자열 확인
            System.out.println("m.group(1): " + m.group(1));
            System.out.println("m.group(2): " + m.group(2));
        }
    }
}
