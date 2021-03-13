package io.spring.app.utils;

import java.util.Random;
import org.springframework.stereotype.Component;

/** OTP has 6 numbers */
@Component
public class GenerateOptImpl implements GenerateOpt {
  private static final int LENGTH = 6;
  private final Random random = new Random(System.currentTimeMillis());

  @Override
  public String newOpt() {
    StringBuffer buffer = new StringBuffer();

    for (int i = 0; i < LENGTH; i++) {
      buffer.append(random.nextInt(10));
    }

    return buffer.toString();
  }
}
