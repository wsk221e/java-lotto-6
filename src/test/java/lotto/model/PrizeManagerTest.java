package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.LottoDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeManagerTest {

    @DisplayName("정해진 규칙에 따라 상금이 올바르게 계산되어야 한다.")
    @Test
    void calculateTotalPrize() {
        PrizeManager prize;

        // 당첨번호 생성(6개 + 보너스 1개)
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));

        // 1~5등 구입 번호 생성
        int[][] numbersList = {
                {1, 2, 3, 4, 5, 6},      // 6개 일치
                {1, 2, 3, 4, 5, 7},      // 5개 + 보너스 일치
                {1, 2, 3, 4, 5, 45},     // 5개 일치
                {1, 2, 3, 4, 43, 44},    // 4개 일치
                {1, 2, 3, 40, 41, 42}    // 3개 일치
        };

        // 구입 번호 티켓 생성
        List<LottoDTO> tickets = new ArrayList<>();
        for (int[] numbers : numbersList) {
            Lotto lotto = new Lotto(List.of(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5]));
            tickets.add(lotto.toDTO());
        }

        // 상금 계산한 후 결과 저장
        prize = new PrizeManager(tickets, winningNumbers);
        prize.calculateTotalPrize();
        List<Integer> prizes = prize.getPrizes();

        // 미리 생각한 상금 목록과 일치하는지 확인
        List<Integer> expectedPrizes = List.of(2000000000, 30000000, 1500000, 50000, 5000);
        assertEquals(prizes, expectedPrizes);
    }

}
