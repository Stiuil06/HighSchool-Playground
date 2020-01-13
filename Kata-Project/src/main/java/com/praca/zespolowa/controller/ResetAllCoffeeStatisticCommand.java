package com.praca.zespolowa.controller;

import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import com.praca.zespolowa.view.View;

public class ResetAllCoffeeStatisticCommand implements Command {

    private final View view;
    private final CoffeeStatisticRepository coffeeStatisticRepository;

    public ResetAllCoffeeStatisticCommand(View view, CoffeeStatisticRepository coffeeStatisticRepository) {
        this.view = view;
        this.coffeeStatisticRepository = coffeeStatisticRepository;
    }

    @Override
    public void execute() {
        if (coffeeStatisticRepository.resetAllStatistics()) {
            view.info("Wyzerowano pomyślnie");
        } else {
            view.error("Błąd");
        }
    }

    @Override
    public String getLabel() {
        return "Reset All Coffee Statistics";
    }
}
