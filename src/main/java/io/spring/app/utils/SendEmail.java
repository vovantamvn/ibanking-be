package io.spring.app.utils;

public interface SendEmail {
    void send(String email, String title, String content);

    void send(String email, String content);
}
