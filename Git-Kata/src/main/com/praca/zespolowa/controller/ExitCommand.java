package com.praca.zespolowa.controller;

public class ExitCommand implements Command {

    public static final int SUCCESSFUL = 0;

    @Override
    public void execute() {
        //TODO ZADANIE 1 Zaimplementuj komendę tak aby bezpiecznie kończyła działanie programu
        System.exit(SUCCESSFUL);
    }

    @Override
    public String getLabel() {
        //TODO ZADANIE 1 Zaimplementuj metodę tak aby zwracała nazwę komendy
        return "Exit";
    }
}
