package com.praca.zespolowa.controller;

public interface Command {
    void execute();

    String getLabel();
}
