package com.praca.zespolowa.repository.mysql;

import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;


class MysqlCoffeeStatisticRepositoryTest {

    @Test
    void shouldThrowExceptionWithCauseSqlStatementException() {
        // given
        CoffeeStatisticRepository repo = new MysqlCoffeeStatisticRepository();
        // when
        Throwable exception = Assertions.catchThrowable(repo::resetAllStatistics);
        // then
        assertThat(exception).isNotExactlyInstanceOf(RuntimeException.class)
                .hasCauseExactlyInstanceOf(SQLException.class);
    }
}
