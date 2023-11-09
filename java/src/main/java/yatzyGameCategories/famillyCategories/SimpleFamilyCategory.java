package yatzyGameCategories.famillyCategories;

import yatzyGameCategories.YatzyCategory;

import java.util.List;

public abstract class SimpleFamilyCategory implements YatzyCategory {
    protected int scoreCalcultation(List<Integer> dices, int gameNumber) {
        return dices.stream().filter(num -> num.equals(gameNumber)).mapToInt(i -> i).sum();
    }
}
