package yatzy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestHelper {

    public static List<Dice> getDices(int... dices){
        return Arrays.stream(dices).mapToObj(Dice::of).collect(Collectors.toList());
    }
}
