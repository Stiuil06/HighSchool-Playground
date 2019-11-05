package com.praca.zespolowa.config;

import com.praca.zespolowa.controller.Command;
import com.praca.zespolowa.controller.CreateCafeLatte;
import com.praca.zespolowa.controller.DisplayCoffeeStatistics;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import com.praca.zespolowa.repository.inmemory.InMemoryCoffeeStatisticRepository;
import com.praca.zespolowa.view.View;
import com.praca.zespolowa.view.console.ConsoleView;
import com.praca.zespolowa.view.console.Menu;

import java.util.ArrayList;
import java.util.List;

public class Config {
    private View view = new ConsoleView();
    private CoffeeStatisticRepository coffeeStatisticRepository = new InMemoryCoffeeStatisticRepository();
    public List<Command> initializeCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new CreateCafeLatte(view, coffeeStatisticRepository));
        commands.add(new DisplayCoffeeStatistics(coffeeStatisticRepository,view));
        return commands;
    }

    public Menu initializeMenu() {
        return new Menu(view);
    }

    public enum COFFE{
        EGZPREZZO, MAŁA_LATE, ŚREDNIA_LATE, DUŻA_LATE
    }
}
