package yatzyGameCategories.Impl.specialCategories;

import yatzyGameCategories.YatzyCategory;

import java.util.List;

public class ChanceGameCategory implements YatzyCategory {
    @Override
    public int calculateScore(List<Integer> dices) {
        return dices.stream().mapToInt(i -> i).sum();
    }
}
