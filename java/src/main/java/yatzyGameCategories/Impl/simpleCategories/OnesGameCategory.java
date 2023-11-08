package yatzyGameCategories.Impl.simpleCategories;

import yatzyGameCategories.famillyCategories.SimpleFamilyCategory;

import java.util.List;

public class OnesGameCategory extends SimpleFamilyCategory {
    @Override
    public int calculateScore(List<Integer> dices) {
        return scoreCalcultation(dices, 1);
    }
}

