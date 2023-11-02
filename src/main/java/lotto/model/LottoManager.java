package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.LottoDTO;

public class LottoManager {
    private final List<Lotto> tickets = new ArrayList<>();


    public void generateLottoTickets(int money) {
        int amount = calculateTicketAmount(money);

        for (int i = 0; i< amount; i++){
            List<Integer> numbers = generateRandomNumbers();

            tickets.add(new Lotto(numbers));
        }

    }

    public List<LottoDTO> getLottoTickets() {
        List<LottoDTO> ticketsDTO = new ArrayList<>();

        for (Lotto ticket : tickets){
            LottoDTO ticketDTO = ticket.toDTO();

            ticketsDTO.add(ticketDTO);
        }
        return ticketsDTO;
    }


    private int calculateTicketAmount(int money){
        int amount = money/1000;

        return amount;
    }

    private List<Integer> generateRandomNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }


    // testcode
    protected int getTicketsSize() {
        return this.tickets.size();
    }
    protected void addTickets(Lotto testTicket){
        tickets.add(testTicket);
    }

}
