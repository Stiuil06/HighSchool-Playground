package com.praca.zespolowa.controller;

import com.praca.zespolowa.config.Config;
import com.praca.zespolowa.exception.DataCreationException;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import com.praca.zespolowa.view.View;

public class CreateCafeLatte implements Command {
    private View view;
    private CoffeeStatisticRepository coffeeStatisticRepository;

    public CreateCafeLatte(View view, CoffeeStatisticRepository coffeeStatisticRepository) {
        this.view = view;
        this.coffeeStatisticRepository = coffeeStatisticRepository;
    }

    @Override
    public void execute() {
        view.info("Order is being processed...");
        view.info("Give me size: ");
        int a = view.readInt("1. Small; 2. Medium; 3. Big");

        String ourString;
        if(a == 1) {
            ourString = Config.COFFEE.SMALL_LATE.toString();
        }

        else if(a == 2) {
            ourString = Config.COFFEE.MEDIUM_LATE.toString();
        }

        else if(a == 3) {
            ourString = Config.COFFEE.BIG_LATE.toString();
        }

        else {
            view.info("There is no such size :(");
            return ;
        }

        try {
            coffeeStatisticRepository.incrementCoffe(ourString);
        } catch (DataCreationException e) {
            e.printStackTrace();
        }
        view.info("Here goes your coffee. Enjoy IT ;)");
    }

    @Override
    public String getLabel() {
        return "CreateCafeLatte" ;
    }

}
