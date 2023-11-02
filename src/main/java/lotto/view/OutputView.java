package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoDTO;

public class OutputView {
    private StringBuilder Cache = new StringBuilder();
    private String buyMessage = "\n%d개를 구매했습니다.\n";
    private int buyAmount = 0;


    public void displayLottoNumbers(List<LottoDTO> tickets) {
        initializeCache();
        parseTicketAndCaching(tickets);

        System.out.printf(buyMessage, buyAmount);
        System.out.println(Cache);
    }


    private void initializeCache(){
        Cache.setLength(0);
    }

    private void parseTicketAndCaching(List<LottoDTO> tickets){
        for (LottoDTO ticket : tickets){
            List<Integer> numbers = ticket.getNumbers();
            String string = numbers.toString();

            Cache.append(string);
            Cache.append("\n");
            buyAmount++;
        }
    }
}
