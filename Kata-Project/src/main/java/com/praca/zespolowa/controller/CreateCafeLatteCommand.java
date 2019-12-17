package com.praca.zespolowa.controller;

import com.praca.zespolowa.config.AppConfig;
import com.praca.zespolowa.exception.DataCreationException;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import com.praca.zespolowa.view.View;

public class CreateCafeLatteCommand implements Command {
    private View view;
    private CoffeeStatisticRepository coffeeStatisticRepository;

    public CreateCafeLatteCommand(View view, CoffeeStatisticRepository coffeeStatisticRepository) {
        this.view = view;
        this.coffeeStatisticRepository = coffeeStatisticRepository;
    }

    @Override
    public void execute() {
        view.info("Trwa składanie zamówienia...");
        view.info("Podaj rozmiar: ");
        int a = view.readInt("1. MAŁA; 2. ŚREDNIA; 3. DUŻA");

        String ourString;
        if(a == 1) {
            ourString = AppConfig.COFFE.MAŁA_LATE.toString();
        }

        else if(a == 2) {
            ourString = AppConfig.COFFE.ŚREDNIA_LATE.toString();
        }

        else if(a == 3) {
            ourString = AppConfig.COFFE.DUŻA_LATE.toString();
        }

        else {
            view.info("Brak takowego rozmiaru :(");
            return ;
        }

        try {
            coffeeStatisticRepository.incrementCoffe(ourString);
        } catch (DataCreationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getLabel() {
        return "Create Latte" ;
    }

}
