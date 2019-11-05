package com.praca.zespolowa.controller;

import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import com.praca.zespolowa.view.View;

public class DisplayCoffeeStatistics implements Command {
    private CoffeeStatisticRepository coffeeStatisticRepository;
    private View view;

    public DisplayCoffeeStatistics(CoffeeStatisticRepository coffeeStatisticRepository, View view) {
        this.coffeeStatisticRepository = coffeeStatisticRepository;
        this.view = view;
    }

    @Override
    public void execute() {
        view.info(coffeeStatisticRepository.findAll().toString());
    }

    @Override
    public String getLabel() {
        return "Staty kaw";
    }
}
