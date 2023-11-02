package lotto.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

    @DisplayName("입력한 액수에 해당하는 티켓 생성")
    @Test
    void generateLottoTicketsTest() {
        int MONEY = 10000;
        int TICKET_PRICE = 1000;

        LottoManager lotto = new LottoManager();

        // 원하는 티켓 갯수
        int tickets = MONEY/TICKET_PRICE;

        // 티켓 생성
        lotto.generateLottoTickets(MONEY);

        // 기대했던 갯수와 비교
        int newSize = lotto.getTicketsSize();
        assertTrue(tickets == newSize);
    }

}
