package com.praca.zespolowa.controller;

import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import com.praca.zespolowa.view.View;

public class ResetStatisticForCoffeeCommand implements Command {
    private View view;
    private CoffeeStatisticRepository coffeeStatisticRepository;


    public ResetStatisticForCoffeeCommand(View view, CoffeeStatisticRepository coffeeStatisticRepository) {
        this.view = view;
        this.coffeeStatisticRepository = coffeeStatisticRepository;
    }

    @Override
    public void execute() {
        String coffeeName = view.readString("Enter name of kawa");

        if (coffeeStatisticRepository.resetStatisticFor(coffeeName)) {
            view.info("Statistic for " + coffeeName + " set 0");
        } else
            view.error("No coffee with this name");
    }

    @Override
    public String getLabel() {
        return "Reset single coffee statistic";
    }
}