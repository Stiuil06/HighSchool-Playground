package com.praca.zespolowa;

import com.praca.zespolowa.config.AppConfig;
import com.praca.zespolowa.controller.Command;
import com.praca.zespolowa.view.console.Menu;

import java.util.List;

public class CoffeeMachine {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        List<Command> commands = appConfig.initializeCommands();
        Menu menu = appConfig.initializeMenu();

        while (true) {
            menu.show(commands);
            Command command = menu.getChoice(commands);
            command.execute();
        }
    }
}
