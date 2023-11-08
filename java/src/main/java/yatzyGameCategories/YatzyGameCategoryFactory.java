package yatzyGameCategories;

import yatzyGameCategories.Impl.upletFamilyCategories.*;
import yatzyGameCategories.Impl.simpleCategories.*;
import yatzyGameCategories.Impl.specialCategories.*;

import java.util.List;

public class YatzyGameCategoryFactory {
    public static YatzyGameCategory getYatzyGame(YatzyCategoryEnum yatzyCategoryEnum) {
        YatzyGameCategory yatzyGameCategory = null;
        switch (yatzyCategoryEnum)  {
            case CHANCE:
                yatzyGameCategory = new ChanceGameCategory();
                break;
            case YATZY:
                yatzyGameCategory = new YatzyCategoryCategory();
                break;
            case ONES:
                yatzyGameCategory = new OnesGameCategory();
                break;
            case TWOS:
                yatzyGameCategory = new TwosGameCategory();
                break;
            case THREES:
                yatzyGameCategory = new ThreesGameCategory();
                break;
            case FOURS:
                yatzyGameCategory = new FoursGameCategory();
                break;
            case FIVES:
                yatzyGameCategory = new FivesGameCategory();
                break;
            case SIXES:
                yatzyGameCategory = new SixesGameCategory();
                break;
            case PAIR:
                yatzyGameCategory = new PairGameCategory();
                break;
            case TOW_PAIR:
                yatzyGameCategory = new TwoPairsGameCategory();
                break;
            case THREE_OF_KIND:
                yatzyGameCategory = new ThreeOfKindGameCategory();
                break;
            case FOUR_OF_KIND:
                yatzyGameCategory = new FourOfKingGameCategory();
                break;
            case SMALL_STRAIGHT:
                yatzyGameCategory = new SmallStraightGameCategory();
                break;
            case LARGE_STRAIGHT:
                yatzyGameCategory = new LargeStraightGameCategory();
                break;
            case FULL_HOUSE:
                yatzyGameCategory = new FullHouseGameCategory();
                break;
        }
        return yatzyGameCategory;
    }
}
