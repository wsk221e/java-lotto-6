package lotto.controller;

import lotto.model.LottoManager;
import lotto.view.InputView;

public class Controller {
    private InputView input = new InputView();
    private LottoManager lotto = new LottoManager();

    public void buyLotto() {
        int money = input.getUserInputMoney();
        lotto.generateLottoTickets(money);
    }


}
