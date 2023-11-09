import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yatzyGameCategories.YatzyCategoryEnum;
import yatzyGameCategories.YatzyCategory;
import yatzyGameCategories.YatzyGameCategoryFactory;

import java.util.*;

public class YatzyGame {
    private static final Logger slf4jLogger = LoggerFactory.getLogger(YatzyGame.class);
    private List<Integer> dices;
    private YatzyCategory yatzyCategory;

    public YatzyGame(int d1, int d2, int d3, int d4, int d5, YatzyCategoryEnum yatzyCategoryEnum)
    {
        dices = new ArrayList<>();
        dices.add(d1);
        dices.add(d2);
        dices.add(d3);
        dices.add(d4);
        dices.add(d5);
        try {
            yatzyCategory = YatzyGameCategoryFactory.getYatzyGame(yatzyCategoryEnum);
        } catch (NullPointerException e) {
            slf4jLogger.error("There is a problem when retrieving YatzyGame Strategy {0}", yatzyCategory);
        }
    }

    public int calculateScore()
    {
        return yatzyCategory.calculateScore(dices);
    }
}



