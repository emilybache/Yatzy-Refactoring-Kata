package yatzyGameCategories.Impl.specialCategories;

import yatzyGameCategories.YatzyGameCategory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LargeStraightGameCategory implements YatzyGameCategory {
    @Override
    public int calculateScore(List<Integer> dices) {
        Set<Integer> unique_dice = new HashSet<>(dices);
        return (unique_dice.size() == 5 && dices.contains(2) && unique_dice.contains(6)) ? 20 : 0;
    }
}
