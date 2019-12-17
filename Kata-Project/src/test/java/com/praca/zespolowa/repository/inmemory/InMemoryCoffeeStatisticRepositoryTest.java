package com.praca.zespolowa.repository.inmemory;

import com.praca.zespolowa.config.Config;
import com.praca.zespolowa.exception.DataCreationException;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryCoffeeStatisticRepositoryTest {

    private static final String ESPRESSO = Config.COFFE.EGZPREZZO.toString();
    private static final String MEDUIM_LATE = Config.COFFE.ŚREDNIA_LATE.toString();

    @Test
    void shouldReturnThreeWhenAddThreeCoffees() throws DataCreationException {
        // given
        CoffeeStatisticRepository repo = new InMemoryCoffeeStatisticRepository();
        repo.incrementCoffe(ESPRESSO);
        repo.incrementCoffe(MEDUIM_LATE);
        repo.incrementCoffe(ESPRESSO);
        // when
        Integer result = repo.getCountOfAllCoffees();
        // then
        assertThat(result).isEqualTo(3);
    }
}
