package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Prize;
import lotto.dto.LottoDTO;

public class PrizeManager {
    private List<Integer> prizes = new ArrayList<>();
    private List<LottoDTO> tickets;
    private List<Integer> winningNumbers;
    private final int BONUS_INDEX = 6;
    private int matches = 0;

    public PrizeManager(List<LottoDTO> tickets, List<Integer> winningNumbers) {
        this.tickets = tickets;
        this.winningNumbers = winningNumbers;
    }


    public void calculateTotalPrize() {
        checkLottoTicket();
        System.out.println("\ntest: 상금 목록 출력");
        System.out.println(prizes);
    }


    private void checkLottoTicket() {
        for (LottoDTO ticket : tickets) {
            matches = 0;
            List<Integer> numbers = ticket.getNumbers();
            compareWithWinningNumber(numbers);
            compareWithBonusNumber(numbers);
            int prize = getPrizeByMatches(matches);
            prizes.add(prize);
        }
    }

    private void compareWithWinningNumber(List<Integer> numbers) {
        for (int i = 0; i < BONUS_INDEX; i++) {
            int winningNumber = winningNumbers.get(i);
            if (numbers.contains(winningNumber)) {
                matches++;
            }
        }
        if (matches == 6) {
            matches = 7;
        }
    }

    private void compareWithBonusNumber(List<Integer> numbers) {
        int bonusNumber = winningNumbers.get(BONUS_INDEX);
        if (numbers.contains(bonusNumber)) {
            if (matches != 7) {
                matches++;
            }
        }
    }

    private int getPrizeByMatches(int matches) {
        if (matches == 7) {
            return Prize.FIRST.getPrize();
        }
        if (matches == 6) {
            return Prize.SECOND.getPrize();
        }
        if (matches == 5) {
            return Prize.THIRD.getPrize();
        }
        if (matches == 4) {
            return Prize.FOURTH.getPrize();
        }
        if (matches == 3) {
            return Prize.FIFTH.getPrize();
        }
        return 0;
    }

}
