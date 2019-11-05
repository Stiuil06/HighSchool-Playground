package com.praca.zespolowa.view;

public interface View {
    String readString(String label);
    int readInt(String label);
    void info(String message);
    //TODO ZADANIE 4 dodaj funkcje wyświetlącą ostrzeżenie i zaimplementuj w konkretnych klasach
}
