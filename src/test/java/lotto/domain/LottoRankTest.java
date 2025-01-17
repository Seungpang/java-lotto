package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

    @DisplayName("규칙에따라 로또 순위를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {
        "6,false,FIRST",
        "5,true,SECOND",
        "5,false,THIRD",
        "4,false,FOURTH",
        "3,false,FIFTH",
        "0,false,SIXTH"
    })
    void findRank(int matchCount, boolean isBonusBall, LottoRank expected) {
        LottoRank rank = LottoRank.find(matchCount, isBonusBall);
        assertThat(rank).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0,false",
        "1,false",
        "2,false",
        "0,true",
        "1,true",
        "2,true",
    })
    @DisplayName("맞은 갯수가 3개 미만이면 6위이다.")
    void findRAnkWhenOneMatch(int matchCount, boolean isBonusBall) {
        // when
        LottoRank rank = LottoRank.find(matchCount, isBonusBall);
        // then
        assertThat(rank).isEqualTo(LottoRank.SIXTH);
    }
}
