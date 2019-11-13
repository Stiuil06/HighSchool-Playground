package com.praca.zespolowa.controller;

public class ExitCommand implements Command {

    public static final int SUCCESSFUL = 0;

    @Override
    public void execute() {
        System.exit(SUCCESSFUL);
    }

    @Override
    public String getLabel() {
        return "Exit";
    }
}
