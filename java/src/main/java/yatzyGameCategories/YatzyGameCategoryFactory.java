package yatzyGameCategories;

import yatzyGameCategories.Impl.upletFamilyCategories.*;
import yatzyGameCategories.Impl.simpleCategories.*;
import yatzyGameCategories.Impl.specialCategories.*;

public class YatzyGameCategoryFactory {
    public static YatzyCategory getYatzyGame(YatzyCategoryEnum yatzyCategoryEnum) {
        YatzyCategory yatzyCategory = null;
        switch (yatzyCategoryEnum)  {
            case CHANCE:
                yatzyCategory = new ChanceGameCategory();
                break;
            case YATZY:
                yatzyCategory = new YatzyGameCategory();
                break;
            case ONES:
                yatzyCategory = new OnesGameCategory();
                break;
            case TWOS:
                yatzyCategory = new TwosGameCategory();
                break;
            case THREES:
                yatzyCategory = new ThreesGameCategory();
                break;
            case FOURS:
                yatzyCategory = new FoursGameCategory();
                break;
            case FIVES:
                yatzyCategory = new FivesGameCategory();
                break;
            case SIXES:
                yatzyCategory = new SixesGameCategory();
                break;
            case PAIR:
                yatzyCategory = new PairGameCategory();
                break;
            case TOW_PAIR:
                yatzyCategory = new TwoPairsGameCategory();
                break;
            case THREE_OF_KIND:
                yatzyCategory = new ThreeOfKindGameCategory();
                break;
            case FOUR_OF_KIND:
                yatzyCategory = new FourOfKingGameCategory();
                break;
            case SMALL_STRAIGHT:
                yatzyCategory = new SmallStraightGameCategory();
                break;
            case LARGE_STRAIGHT:
                yatzyCategory = new LargeStraightGameCategory();
                break;
            case FULL_HOUSE:
                yatzyCategory = new FullHouseGameCategory();
                break;
        }
        return yatzyCategory;
    }
}
