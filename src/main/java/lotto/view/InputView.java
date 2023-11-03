package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final String askAmountMessage = "구입금액을 입력해 주세요.";
    private final String askWinningNumberMessage = "당첨 번호를 입력해 주세요.";
    private final String askBonusNumberMessage = "보너스 번호를 입력해 주세요.";
    private List<Integer> winningNumbers = new ArrayList<>();


    public int getUserInputMoney() {
        System.out.println(askAmountMessage);

        String moneyInput = Console.readLine();
        int money = Integer.parseInt(moneyInput);

        return money;
    }

    public List<Integer> getPrizingNumbers() {
        getWinningNumber();
        getBonusNumber();

        return winningNumbers;
    }

    private void getWinningNumber() {
        System.out.println(askWinningNumberMessage);

        String numberString = Console.readLine();
        List<Integer> numbers = parseWinningNumber(numberString);

        winningNumbers = numbers;
    }

    private void getBonusNumber() {
        System.out.println(askBonusNumberMessage);

        String bonus = Console.readLine();
        int bonusNumber = Integer.parseInt(bonus);

        winningNumbers.add(bonusNumber);
    }

    private List<Integer> parseWinningNumber(String numbers) {
        List<Integer> winningNumber = new ArrayList<>();
        String[] numberStrings = numbers.split(",");

        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString);

            winningNumber.add(number);
        }
        return winningNumber;
    }

}
