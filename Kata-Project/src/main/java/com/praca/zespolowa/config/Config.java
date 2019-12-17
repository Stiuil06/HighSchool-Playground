package com.praca.zespolowa.config;

import com.praca.zespolowa.controller.*;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import com.praca.zespolowa.repository.inmemory.InMemoryCoffeeStatisticRepository;
import com.praca.zespolowa.repository.mysql.MysqlCoffeeStatisticRepository;
import com.praca.zespolowa.view.View;
import com.praca.zespolowa.view.console.ConsoleView;
import com.praca.zespolowa.view.console.Menu;

import java.util.ArrayList;
import java.util.List;

public class Config {

    private View view;
    private CoffeeStatisticRepository coffeeStatisticRepository;
    public Config() {
        this.view = new ConsoleView();
        //this.coffeeStatisticRepository = new InMemoryCoffeeStatisticRepository();
        this.coffeeStatisticRepository = new MysqlCoffeeStatisticRepository();
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
        commands.add(new ResetAllCoffeeStatistic(view, coffeeStatisticRepository));
        commands.add(new ResetStatisticForCoffee(view, coffeeStatisticRepository));
        return commands;
    }

    public Menu initializeMenu() {
        return new Menu(view);
    }

    public enum COFFE {
        EGZPREZZO, MAŁA_LATE, ŚREDNIA_LATE, DUŻA_LATE
        //TODO ZADANIE DODATKOWE (wykonać na osobnym branchu) ujednolicić nazwy zmiennych, metod itp w CAłYM systemie -> język angielski
        // poprawić literówki  coffe -> coffee
        // usunąć ewentualne znaki specjalne łśżć itp
    }
}
