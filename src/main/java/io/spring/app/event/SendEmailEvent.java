package io.spring.app.event;

import org.springframework.context.ApplicationEvent;

public class SendEmailEvent extends ApplicationEvent {
  private final String email;
  private final String content;

  public SendEmailEvent(Object source, String email, String content) {
    super(source);
    this.email = email;
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public String getEmail() {
    return email;
  }
}
