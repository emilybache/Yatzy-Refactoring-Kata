package yatzyGameCategories.Impl.upletFamilyCategories;

import yatzyGameCategories.famillyCategories.DoublonsFamilyCategory;

import java.util.List;

public class ThreeOfKindGameCategory extends DoublonsFamilyCategory {
    @Override
    public int calculateScore(List<Integer> dices) {
        List<Integer> allTriplets = getDuplicatesList(dices, 3);
        return allTriplets.size() >= 1 ? allTriplets.stream().mapToInt(i->i).sum() : 0;
    }
}
