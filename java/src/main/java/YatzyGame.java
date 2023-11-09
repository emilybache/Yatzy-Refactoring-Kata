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
        slf4jLogger.error("Start the Game");
        dices = new ArrayList<>();
        dices.add(d1);
        dices.add(d2);
        dices.add(d3);
        dices.add(d4);
        dices.add(d5);
        yatzyCategory = YatzyGameCategoryFactory.getYatzyGame(yatzyCategoryEnum);

    }

    public int calculateScore()
    {
        return yatzyCategory.calculateScore(dices);
    }
}



