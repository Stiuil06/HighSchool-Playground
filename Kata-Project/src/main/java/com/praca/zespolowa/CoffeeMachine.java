package com.praca.zespolowa;

import com.praca.zespolowa.config.Config;
import com.praca.zespolowa.controller.Command;
import com.praca.zespolowa.view.console.Menu;

import java.util.List;

public class CoffeeMachine {
    public static void main(String[] args) {
        Config config = new Config();
        List<Command> commands = config.initializeCommands();
        Menu menu = config.initializeMenu();

        while (true) {
            menu.show(commands);
            Command command = menu.getChoice(commands);
            command.execute();
        }
    }
}
