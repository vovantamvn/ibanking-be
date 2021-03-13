package io.spring.app.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SendEmailImpl implements SendEmail {

  @Override
  public void send(String email, String title, String content) {
    String logInfo = String.format("Email: %s, title: %s, content: %s", email, title, content);
    log.info(logInfo);
  }

  @Override
  public void send(String email, String content) {
    String title = "[Hệ thống đóng học phí]";
    this.send(email, title, content);
  }
}
