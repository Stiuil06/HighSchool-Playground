package com.praca.zespolowa.repository.mysql;

import com.praca.zespolowa.exception.DataCreationException;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;

import java.util.Map;

/**
 * Created By wegrzyna on 26.11.2019
 */
public class MysqlCoffeeStatisticRepository implements CoffeeStatisticRepository {
    public MysqlCoffeeStatisticRepository() {
        //TODO ZADANE 1 Jeśli jakaś kawa nie istnieje w tabeli coffee_statistic w bazie coffee_machine to zainicjalizuj rekord z poprawną nazwą oraz zerowym stanem
        // jeśli taki typ kawy istnieje nic nie rób
        throw new RuntimeException("constructor not implemented");
    }

    @Override
    public boolean increamentCoffe(String coffeName) throws DataCreationException {
        //TODO ZADANE 2 Zainkrementuj ilosć zrobionych kaw o podanej nazwie o jeden. Możesz pobrać liczbę dodać jeden i zaaktualizować rekord, lub zrobioć update na bazie
        throw new RuntimeException("method not implemented");
    }

    @Override
    public Map<String, Integer> findAll() {
        //TODO ZADANE 3 Pobierz wszystkie satystyki zrobionych kaw, załaduj do mapy i zwróc
        throw new RuntimeException("method not implemented");
    }

    @Override
    public boolean resetAllStatistics() {
        //TODO ZADANE 4 Wyzeruj pole amount dla wszystkich rekordów w tabeli coffe_statistic
        throw new RuntimeException("method not implemented");
    }

    @Override
    public boolean resetStatisticFor(String coffeName) {
        throw new RuntimeException("method not implemented");
        //TODO ZADANIE 5 Wyzeruj pole amount dla wybranego rodzaju kawy w tabeli coffe_statistic
    }
}
