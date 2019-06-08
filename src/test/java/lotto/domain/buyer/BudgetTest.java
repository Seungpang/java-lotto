package lotto.domain.buyer;

import lotto.domain.InputNegativeException;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BudgetTest {
    @Test
    void 음수를_입력했을경우() {
        assertThrows(InputNegativeException.class, () -> new Budget(-1));
    }

    @Test
    void 로또_금액보다_적은_금액을_입력했을경우() {
        assertThrows(NoMoneyException.class, () -> new Budget(Lotto.LOTTO_PRICE - 1));
    }
}