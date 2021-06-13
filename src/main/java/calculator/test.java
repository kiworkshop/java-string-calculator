package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String input = "//;\n1;2;3";
        System.out.println(input);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()) {
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
    }
}
