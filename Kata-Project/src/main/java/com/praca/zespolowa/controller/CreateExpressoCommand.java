package com.praca.zespolowa.controller;

import com.praca.zespolowa.config.AppConfig;
import com.praca.zespolowa.exception.DataCreationException;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import com.praca.zespolowa.view.View;

public class CreateExpressoCommand implements Command {

    View view;
    CoffeeStatisticRepository coffeeStatisticRepository;

    public CreateExpressoCommand(View view, CoffeeStatisticRepository coffeeStatisticRepository) {
        this.view = view;
        this.coffeeStatisticRepository = coffeeStatisticRepository;
    }

    @Override
    public void execute() {
        view.info("Trwa składanie zamówienia...");
        view.info("Podaj rozmiar: ");
        int a = view.readInt("1. MAŁE; 2. ŚREDNIE; 3. DUŻA");

        String ourString = AppConfig.COFFE.EGZPREZZO.toString();

        try {
            for(int i = 0; i<a; i++)
                coffeeStatisticRepository.incrementCoffe(ourString);
        } catch (DataCreationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getLabel() {
        return "Create Expresso";
    }

}
