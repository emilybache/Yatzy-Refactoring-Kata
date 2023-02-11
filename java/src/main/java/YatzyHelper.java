@Deprecated
public class YatzyHelper {


    public static int chance(int d1, int d2, int d3, int d4, int d5)
    {
        return new Yatzy(d1, d2, d3, d4, d5).chance();
    }

    public static int yatzy(int... dice)
    {
        return new Yatzy(dice[0], dice[1], dice[2], dice[3], dice[4]).yatzy();
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy(d1, d2, d3, d4, d5).ones();
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy(d1, d2, d3, d4, d5).twos();
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy(d1, d2, d3, d4, d5).threes();
    }
}
