package yatzyGameCategories.Impl.specialCategories;

import yatzyGameCategories.famillyCategories.SpecialFamilyCategory;

import java.util.HashSet;
import java.util.List;

public class YatzyCategoryCategory extends SpecialFamilyCategory {
    @Override
    public int calculateScore(List<Integer> dices) {
        return new HashSet<Integer>(dices).size() == 1 ? 50 : 0;
    }
}
