package com.praca.zespolowa.controller;

import com.praca.zespolowa.config.Config;
import com.praca.zespolowa.exception.DataCreationException;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import com.praca.zespolowa.view.View;

public class CreateExpresso implements Command {

    View view;
    CoffeeStatisticRepository coffeeStatisticRepository;

    public CreateExpresso(View view, CoffeeStatisticRepository coffeeStatisticRepository) {
        this.view = view;
        this.coffeeStatisticRepository = coffeeStatisticRepository;
    }

    @Override
    public void execute() {
        String kawusia = view.readString("Duza? (t/n)").toLowerCase();

        boolean debil = true;
        do {
            switch (kawusia) {
                case ("t"):
                    try {
                        coffeeStatisticRepository.increamentCoffe(String.valueOf(Config.COFFE.EGZPREZZO));
                        coffeeStatisticRepository.increamentCoffe(String.valueOf(Config.COFFE.EGZPREZZO));
                    } catch (DataCreationException e) {
                        e.printStackTrace();
                    }
                    finally {
                        debil = false;
                    }
                    break;
                case ("n"):
                    try {
                        coffeeStatisticRepository.increamentCoffe(String.valueOf(Config.COFFE.EGZPREZZO));
                    } catch (DataCreationException e) {
                        e.printStackTrace();
                    }
                    finally {
                        debil = false;
                    }
                    break;
                default:
                    break;
            }
        } while (debil);

    }

    @Override
    public String getLabel() {
        return "Zrob expresso";
    }

}
