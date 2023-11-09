package yatzyGameCategories.Impl.upletFamilyCategories;

import yatzyGameCategories.famillyCategories.DoublonsFamilyCategory;

import java.util.List;

public class FourOfKingGameCategory extends DoublonsFamilyCategory {
    @Override
    public int calculateScore(List<Integer> dices) {
        List<Integer> allQuadruplet = getDuplicatesList(dices, 4);
        return allQuadruplet.isEmpty() ? 0:  allQuadruplet.stream().mapToInt(i->i).sum();
    }
}

