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


    public static int score_pair(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy(d1, d2, d3, d4, d5).score_pair();
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy(d1, d2, d3, d4, d5).two_pair();
    }

    public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy(d1, d2, d3, d4, d5).four_of_a_kind();
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy(d1, d2, d3, d4, d5).three_of_a_kind();
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy(d1, d2, d3, d4, d5).smallStraight();
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy(d1, d2, d3, d4, d5).largeStraight();
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy(d1, d2, d3, d4, d5).fullHouse();
    }
}
