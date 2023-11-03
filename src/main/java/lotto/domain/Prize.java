package lotto.domain;

public enum Prize {
    FIRST(7, 2000000000),  // 2,000,000,000
    SECOND(6, 30000000),   // 30,000,000
    THIRD(5, 1500000),     // 1,500,000
    FOURTH(4, 50000),      // 50,000
    FIFTH(3, 5000);        // 5,000

    private final int matches;
    private final int prize;


    Prize(int matches, int prize) {
        this.matches = matches;
        this.prize = prize;
    }


    public int getPrize() {
        return prize;
    }

}
