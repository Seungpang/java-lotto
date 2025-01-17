package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {

    @Test
    @DisplayName("로또 순위로 통계를 정상적으로 만드는지 확인.")
    void createStatisticsWithLottoRanks() {
        // given
        List<LottoRank> ranks = List.of(LottoRank.values());
        LottoStatistics expected = new LottoStatistics(
            List.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH,
                LottoRank.FIFTH));
        // when
        LottoStatistics statistics = new LottoStatistics(ranks);
        // then
        assertThat(statistics).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 순위 별 개수를 센다.")
    void countPerRanks() {
        // given
        List<LottoRank> ranks = List.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.SECOND);
        // when
        LottoStatistics statistics = new LottoStatistics(ranks);
        // then
        assertThat(statistics.count(LottoRank.SECOND)).isEqualTo(2L);
    }

    @Test
    @DisplayName("수익률을 계산할 수 있다.")
    void calculateEarningRates() {
        // given
        Money money = new Money(3000);
        List<LottoRank> ranks = List.of(LottoRank.FIFTH, LottoRank.SIXTH, LottoRank.SIXTH);
        // when
        LottoStatistics statistics = new LottoStatistics(ranks);
        // then
        assertThat(statistics.calculateEarningRates(money)).isEqualTo(money.divideByAmount(5000L));
    }
}
