package com.praca.zespolowa.repository.inmemory;


import com.praca.zespolowa.exception.DataCreationException;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;

import java.util.Map;

public class InMemoryCoffeeStatisticRepository implements CoffeeStatisticRepository {

    //TODO ZADANIE 2 stwórz sposób przechowywania statystyk (nazwaKawy -> iloscZrobionychKaw)

    @Override
    public boolean increamentCoffe(String coffeName) throws DataCreationException {
        //TODO ZADANIE 2 napisz implementację metody która będzie inkrementowała ilość zrobionych kaw w naszej bazie
        return false;
    }

    @Override
    public Map<String,Integer> findAll() {
        //TODO ZADANIE 2 napisz implementację metody która będzie zwracała statystyki zrobionych kaw
        return null;
    }

    @Override
    public boolean resetAllStatistics() {
        //TODO ZADANIE 2 napisz implementację metody zresetuje wszystkie statystyki zrobionych kaw
        return false;
    }

    @Override
    public boolean resetStatisticFor(String coffeName) {
        //TODO ZADANIE 2 napisz implementację metody zresetuje  statystyki wybranej kawy
        return false;
    }
}
