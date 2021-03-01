package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.utils.ParseUtils;
import lotto.utils.RandomUtils;

public class LottoTickets {

    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String REGEX = ", ";
    private static final List<Integer> ALL_LOTTO_NUMBERS = IntStream
        .range(START_LOTTO_NUMBER, END_LOTTO_NUMBER + 1)
        .boxed()
        .collect(Collectors.toList());

    private final List<Lotto> lottoTickets;

    public LottoTickets(final int buyLottoSize) {
        lottoTickets = new ArrayList<>();
        createLottoTickets(buyLottoSize);
    }

    public LottoTickets(final List<String> lottoNumbers) {
        lottoTickets = new ArrayList<>();
        for (String lottoNumber : lottoNumbers) {
            lottoTickets.add(new Lotto(ParseUtils.parseIntegerList(lottoNumber, REGEX)));
        }
    }

    public LottoTickets(final int buyLottoSize, final LottoTickets selfLottoTickets) {
        lottoTickets = new ArrayList<>(selfLottoTickets.getLottoTickets());
        createLottoTickets(buyLottoSize);
    }

    private void createLottoTickets(final int buyLottoSize) {
        for (int i = 0; i < buyLottoSize; i++) {
            lottoTickets.add(
                new Lotto(RandomUtils.generateRandomNumbers(ALL_LOTTO_NUMBERS, LOTTO_SIZE))
            );
        }
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public Rewards getResult(final WinningLotto winningLotto) {
        List<Reward> rewards = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            rewards.add(winningLotto.match(lotto));
        }
        return new Rewards(rewards);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }
}