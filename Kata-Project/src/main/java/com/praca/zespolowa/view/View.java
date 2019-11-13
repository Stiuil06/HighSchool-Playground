package com.praca.zespolowa.view;

public interface View {
    String readString(String label);
    int readInt(String label);
    void info(String message);
    void error(String message);
}
