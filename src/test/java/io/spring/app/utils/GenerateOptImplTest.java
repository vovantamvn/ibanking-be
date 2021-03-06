package io.spring.app.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class GenerateOptImplTest {

  private final GenerateOpt generateOpt = new GenerateOptImpl();

  @Test
  void testGenerateOpt() {
    // OTP has 6 number
    String regex = "^[0-9]{6}$";
    String opt = generateOpt.newOpt();

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(opt);

    assertTrue(matcher.find());
  }
}
