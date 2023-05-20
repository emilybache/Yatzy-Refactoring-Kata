//переношу метод score_pair після методу two_pair для покращення логічного порядку методів у класах
//видалила зайві пробіли для поліпшення читабельності.
//в методі two_pair змінила цикл з обратного на прямий для полегшення розуміння
//в методі fullHouse перейминувала змінні _2 на hasPair і _2_at на pairValue, а також _3 
//на hasThreeOfAKind і _3_at на threeOfAKindValue для кращого розуміння їхнього призначення


public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int yatzy(int... dice) {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die - 1]++;
        for (int i = 0; i < 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == 1) sum++;
        if (d2 == 1) sum++;
        if (d3 == 1) sum++;
        if (d4 == 1) sum++;
        if (d5 == 1) sum++;
        return sum;
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == 2) sum += 2;
        if (d2 == 2) sum += 2;
        if (d3 == 2) sum += 2;
        if (d4 == 2) sum += 2;
        if (d5 == 2) sum += 2;
        return sum;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == 3) sum += 3;
        if (d2 == 3) sum += 3;
        if (d3 == 3) sum += 3;
        if (d4 == 3) sum += 3;
        if (d5 == 3) sum += 3;
        return sum;
    }

    public static int fours(int... dice) {
        int sum = 0;
        for (int die : dice) {
            if (die == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public static int fives(int... dice) {
        int sum = 0;
        for (int die : dice) {
            if (die == 5) {
                sum += 5;
            }
        }
        return sum;
    }

    public static int sixes(int... dice) {
        int sum = 0;
        for (int die : dice) {
            if (die == 6) {
                sum += 6;
            }
        }
        return sum;
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = new int[6];
        counts[d1 - 1]++;
        counts[d2 - 1]++;
        counts[d3 - 1]++;
        counts[d4 - 1]++;
        counts[d5 - 1]++;
        for (int i = 5; i >= 0; i--)
            if (counts[i] >= 2)
                return (i + 1) * 2;
        return 0;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = new int[6];
        counts[d1 - 1]++;
        counts[d2 - 1]++;
        counts[d3 - 1]++;
        counts[d4 - 1]++;
        counts[d5 - 1]++;
        int pairCount = 0;
        int score = 0;
        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= 2) {
                pairCount++;
                score += (i + 1);
            }
        }
        if (pairCount == 2)
            return score * 2;
        else
            return 0;
    }

    public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = new int[6];
        tallies[d1 - 1]++;
        tallies[d2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = new int[6];
        tallies[d1 - 1]++;
        tallies[d2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = new int[6];
        tallies[d1 - 1]++;
        tallies[d2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;
        if (tallies[0] == 1 && tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = new int[6];
        tallies[d1 - 1]++;
        tallies[d2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;
        if (tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1 && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = new int[6];
        boolean hasPair = false;
        int pairValue = 0;
        boolean hasThreeOfAKind = false;
        int threeOfAKindValue = 0;

        tallies[d1 - 1]++;
        tallies[d2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1];

        for (int i = 0; i < 6; i++) {
            if (tallies[i] == 2) {
                hasPair = true;
                pairValue = i + 1;
            }

            if (tallies[i] == 3) {
                hasThreeOfAKind = true;
                threeOfAKindValue = i + 1;
            }
        }

        if (hasPair && hasThreeOfAKind)
            return pairValue * 2 + threeOfAKindValue * 3;
        else
            return 0;
    }
}
