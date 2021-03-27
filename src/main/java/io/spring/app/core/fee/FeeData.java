package io.spring.app.core.fee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeeData {
    private long cost;

    private int term;

    private boolean isPaid;
}
