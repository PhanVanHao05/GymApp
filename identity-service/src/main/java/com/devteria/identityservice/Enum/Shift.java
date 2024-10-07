package com.devteria.identityservice.Enum;

import lombok.Getter;

@Getter
public enum Shift {
    MORNING("Ca sáng"),
    NIGHT("Ca tối"),
    FULL_DAY("Cả ngày");

    private final String displayName;

    Shift(String displayName) {
        this.displayName = displayName;
    }
}
