package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MatcherStudyTest {
    String input = "//;\n1;2;3";
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
    String str1 = "";
    String str2 = "";

    @Test
    public void checkSeperatedStrings() {
        if(m.find()) {
            str1 = m.group(1);
            str2 = m.group(2);
        }

        assertThat(";").isEqualTo(str1);
        assertThat("1;2;3").isEqualTo(str2);

    }
}
