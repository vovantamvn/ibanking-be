package io.spring.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeeData {
    private long cost;

    private int term;

    private boolean isPaid;
}
