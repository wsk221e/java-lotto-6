package lotto.controller;

import java.util.List;
import lotto.dto.LottoDTO;
import lotto.model.LottoManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private InputView input = new InputView();
    private OutputView output = new OutputView();
    private LottoManager lotto = new LottoManager();

    public void buyLotto() {
        int money = input.getUserInputMoney();
        lotto.generateLottoTickets(money);
    }

    public void displayLottoNumbers(){
        List<LottoDTO> tickets = lotto.getLottoTickets();
        output.displayLottoNumbers(tickets);
    }

}
