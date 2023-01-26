package com.project._2023_01_26.mockito.code.reactor;

import lombok.Setter;

public class Sensor {
    @Setter
    private boolean blocked;

    public boolean isBlocked() {
        return blocked;
    }
}