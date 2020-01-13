package com.praca.zespolowa.view.console;

import com.praca.zespolowa.controller.Command;
import com.praca.zespolowa.view.View;

import java.util.List;

public class Menu {

    public static final String OPTION_FORMAT = "[%d] %s";
    private List<Command> commands;
    private View view;

    public Menu(View view) {
        this.view = view;
    }

    public void show(List<Command> commands) {
        if (commands.isEmpty()) {
            view.error("List of commends is empty");
        }
        for (Command command : commands) {
            String message = String.format(OPTION_FORMAT, commands.indexOf(command), command.getLabel());
            view.info(message);
        }
    }

    public Command getChoice(List<Command> commands) {
        int choice = view.readInt("Choose");
        return commands.get(choice);
    }
}