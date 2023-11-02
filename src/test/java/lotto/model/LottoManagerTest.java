package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.LottoDTO;
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

    @DisplayName("보유하고 있는 티켓 목록을 DTO로 반환")
    @Test
    void getLottoTickets() {
        Lotto TICKET_TEST_1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto TICKET_TEST_2 = new Lotto(List.of(40, 41, 42, 43, 44, 45));
        LottoManager lotto = new LottoManager();

        // 보유하고 있는 티켓 목록 추가
        lotto.addTickets(TICKET_TEST_1);
        lotto.addTickets(TICKET_TEST_2);

        // 보유하고 있는 티켓 목록 반환
        List<LottoDTO> tickets = lotto.getLottoTickets();

        // 기대 결과와 검증
        assertThat(tickets).hasSize(2);
        assertThat(tickets.get(0).getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(tickets.get(1).getNumbers()).containsExactly(40, 41, 42, 43, 44, 45);
    }

}
