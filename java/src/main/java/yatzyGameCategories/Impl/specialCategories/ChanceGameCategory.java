package yatzyGameCategories.Impl.specialCategories;

import yatzyGameCategories.YatzyGameCategory;

import java.util.List;

public class ChanceGameCategory implements YatzyGameCategory {
    @Override
    public int calculateScore(List<Integer> dices) {
        return dices.stream().mapToInt(i -> i).sum();
    }
}
