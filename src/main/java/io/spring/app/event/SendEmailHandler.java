package io.spring.app.event;

import io.spring.app.utils.SendEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendEmailHandler implements ApplicationListener<SendEmailEvent> {
  private final SendEmail sendEmail;

  @Override
  public void onApplicationEvent(SendEmailEvent event) {
    sendEmail.send(event.getEmail(), event.getContent());
  }
}
