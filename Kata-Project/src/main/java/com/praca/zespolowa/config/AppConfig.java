package com.praca.zespolowa.config;

import com.praca.zespolowa.controller.*;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import com.praca.zespolowa.repository.inmemory.InMemoryCoffeeStatisticRepository;
import com.praca.zespolowa.view.View;
import com.praca.zespolowa.view.console.ConsoleView;
import com.praca.zespolowa.view.console.Menu;

import java.util.ArrayList;
import java.util.List;

public class AppConfig {

    private View view;
    private CoffeeStatisticRepository coffeeStatisticRepository;

    public AppConfig() {
        this.view = new ConsoleView();
        this.coffeeStatisticRepository = new InMemoryCoffeeStatisticRepository();
//        this.coffeeStatisticRepository = new MysqlCoffeeStatisticRepository();
    }

    public AppConfig(View view, CoffeeStatisticRepository coffeeStatisticRepository) {
        this.view = view;
        this.coffeeStatisticRepository = coffeeStatisticRepository;
    }

    public List<Command> initializeCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new CreateCafeLatteCommand(view, coffeeStatisticRepository));
        commands.add(new CreateExpressoCommand(view, coffeeStatisticRepository));
        commands.add(new DisplayCoffeeStatisticsCommand(coffeeStatisticRepository, view));
        commands.add(new ResetAllCoffeeStatisticCommand(view, coffeeStatisticRepository));
        commands.add(new ResetStatisticForCoffeeCommand(view, coffeeStatisticRepository));
        return commands;
    }

    public Menu initializeMenu() {
        return new Menu(view);
    }

    public enum COFFEE {
        ESPRESSO, SMALL_LATE, MEDIUM_LATE, BIG_LATE
    }
}
