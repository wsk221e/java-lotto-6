package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String askAmountMessage = "구입금액을 입력해 주세요.";



    public int getUserInputMoney() {
        System.out.println(askAmountMessage);
        String moneyInput = Console.readLine();
        int money = Integer.parseInt(moneyInput);

        return money;
    }

}
