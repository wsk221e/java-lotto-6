package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> set = new HashSet<>();
        for (int number: numbers) {
            if (!set.add(number)){
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
    // testcode
}
