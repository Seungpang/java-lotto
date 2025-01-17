package lotto.dto;

import java.util.Collections;
import java.util.Map;
import lotto.domain.LottoRank;

public class StatisticsResult {

    private final Map<LottoRank, Long> statisticsByRank;
    private final double earningRate;

    public StatisticsResult(Map<LottoRank, Long> statisticsByRank, double earningRate) {
        this.statisticsByRank = statisticsByRank;
        this.earningRate = earningRate;
    }

    public Map<LottoRank, Long> getStatisticsByRank() {
        return Collections.unmodifiableMap(statisticsByRank);
    }

    public double getEarningRate() {
        return earningRate;
    }
}
