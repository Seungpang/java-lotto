package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    @DisplayName("로또 티켓들이 정상적으로 생성되는지 확인")
    void createLottoTickets() {
        // given
        Money money = new Money(3000);
        RandomNumberGenerator generator = new RandomNumberGenerator(LottoNumber.MIN,
            LottoNumber.MAX);
        // when
        LottoTickets lottoTickets = LottoTickets.buy(generator, money);
        List<LottoTicket> tickets = lottoTickets.getTickets();
        // then
        assertThat(tickets.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 티켓 당첨자들의 통계가 정상적인지 확인")
    void findLottoWinners() {
        // given
        List<LottoNumber> numbers = new ArrayList<>(
            List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
        );
        List<LottoNumber> otherNumbers = new ArrayList<>(
            List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(10), new LottoNumber(11), new LottoNumber(12))
        );
        LottoTickets tickets = new LottoTickets(
            List.of(new LottoTicket(numbers), new LottoTicket(otherNumbers)));
        // when
        LottoStatistics lottoStatistics = tickets.findLottoWinners(
            new WinningTicket(new LottoTicket(numbers), new LottoNumber(7)));

        // then
        assertThat(lottoStatistics).isEqualTo(new LottoStatistics(
            List.of(LottoRank.FIRST, LottoRank.FIFTH)));
    }
}
