package yatzyGameCategories.Impl.upletFamilyCategories;

import yatzyGameCategories.famillyCategories.DoublonsFamilyCategory;

import java.util.List;

public class TwoPairsGameCategory extends DoublonsFamilyCategory {
    @Override
    public int calculateScore(List<Integer> dices) {
        List<Integer> allDoublons = getDuplicatesList(dices, 2);
        return allDoublons.size() > 1 ? allDoublons.stream().mapToInt(i->i).sum() : 0;
    }
}

