package com.praca.zespolowa.config;

import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import com.praca.zespolowa.repository.inmemory.InMemoryCoffeeStatisticRepository;
import com.praca.zespolowa.view.View;
import com.praca.zespolowa.view.console.ConsoleView;
import com.praca.zespolowa.view.console.Menu;
import com.praca.zespolowa.controller.Command;
import com.praca.zespolowa.controller.CreateCafeLatte;
import com.praca.zespolowa.controller.CreateExpresso;
import com.praca.zespolowa.controller.DisplayCoffeeStatistics;

import java.util.ArrayList;
import java.util.List;

public class Config {

    private View view;
    private CoffeeStatisticRepository coffeeStatisticRepository;

    public Config() {
        view = new ConsoleView();
        CoffeeStatisticRepository coffeeStatisticRepository = new InMemoryCoffeeStatisticRepository();
    }

    public Config(View view, CoffeeStatisticRepository coffeeStatisticRepository) {
        this.view = view;
        this.coffeeStatisticRepository = coffeeStatisticRepository;
    }

    public List<Command> initializeCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new CreateCafeLatte(view, coffeeStatisticRepository));
        commands.add(new CreateExpresso(view, coffeeStatisticRepository));
        commands.add(new DisplayCoffeeStatistics(coffeeStatisticRepository, view));
        return commands;
    }

    public Menu initializeMenu() {
        return new Menu(view);
    }

    public enum COFFE {
        EGZPREZZO, MAŁA_LATE, ŚREDNIA_LATE, DUŻA_LATE
    }
}
