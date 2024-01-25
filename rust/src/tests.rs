mod category_chance {
    use crate::category::chance;

    #[test]
    fn score_sum_of_the_roll() {
        assert_eq!(14, chance([1, 1, 3, 3, 6]));
        assert_eq!(21, chance([4, 5, 5, 6, 1]));
    }
}

mod category_yatzy {
    use crate::category::yatzy;

    #[test]
    fn score_50_when_all_the_same() {
        assert_eq!(50, yatzy([1, 1, 1, 1, 1]));
        assert_eq!(50, yatzy([5, 5, 5, 5, 5]));
    }

    #[test]
    fn score_0_when_not_all_the_same() {
        assert_eq!(0, yatzy([1, 1, 1, 2, 1]));
        assert_eq!(0, yatzy([1, 2, 2, 5, 5]));
        assert_eq!(0, yatzy([6, 6, 6, 6, 3]));
    }
}

mod category_ones {
    use crate::category::ones;

    #[test]
    fn score_0_when_zero_ones() {
        assert_eq!(0, ones([2, 3, 5, 4, 6]));
    }

    #[test]
    fn score_1_when_one_one() {
        assert_eq!(1, ones([6, 1, 2, 4, 4]));
    }

    #[test]
    fn score_sum_of_ones() {
        assert_eq!(2, ones([1, 1, 2, 4, 4]));
    }
}

mod category_twos {
    use crate::category::twos;

    #[test]
    fn score_0_when_zero_twos() {
        assert_eq!(0, twos([1, 3, 5, 4, 6]));
    }

    #[test]
    fn score_2_when_one_two() {
        assert_eq!(2, twos([6, 1, 2, 4, 4]));
    }

    #[test]
    fn score_sum_of_twos() {
        assert_eq!(6, twos([2, 1, 2, 4, 2]));
    }
}

mod category_threes {
    use crate::category::threes;

    #[test]
    fn score_0_when_zero_threes() {
        assert_eq!(0, threes([1, 6, 5, 4, 6]));
    }

    #[test]
    fn score_3_when_one_three() {
        assert_eq!(3, threes([6, 1, 2, 3, 4]));
    }

    #[test]
    fn score_sum_of_threes() {
        assert_eq!(12, threes([3, 1, 3, 3, 3]));
    }
}

mod category_fours {
    use crate::category::fours;

    #[test]
    fn score_0_when_zero_fours() {
        assert_eq!(0, fours([1, 6, 5, 2, 6]));
    }

    #[test]
    fn score_4_when_one_four() {
        assert_eq!(4, fours([6, 1, 2, 3, 4]));
    }

    #[test]
    fn score_sum_of_fours() {
        assert_eq!(8, fours([3, 1, 4, 3, 4]));
    }
}

mod category_fives {
    use crate::category::fives;

    #[test]
    fn score_0_when_zero_fives() {
        assert_eq!(0, fives([1, 6, 3, 2, 6]));
    }

    #[test]
    fn score_5_when_one_five() {
        assert_eq!(5, fives([6, 1, 5, 3, 4]));
    }

    #[test]
    fn score_sum_of_fives() {
        assert_eq!(15, fives([5, 1, 5, 3, 5]));
    }
}

mod category_sixes {
    use crate::category::sixes;

    #[test]
    fn score_0_when_zero_sixes() {
        assert_eq!(0, sixes([1, 5, 3, 2, 1]));
    }

    #[test]
    fn score_6_when_one_six() {
        assert_eq!(6, sixes([6, 1, 5, 3, 4]));
    }

    #[test]
    fn score_sum_of_sixes() {
        assert_eq!(30, sixes([6, 6, 6, 6, 6]));
    }
}

mod category_pair {
    use crate::category::pair;

    #[test]
    fn score_0_when_no_pairs() {
        assert_eq!(0, pair([1, 2, 3, 4, 5]));
    }

    #[test]
    fn score_12_when_pair_of_six() {
        assert_eq!(12, pair([1, 2, 6, 3, 6]));
    }

    #[test]
    fn score_8_when_pair_of_four_over_pair_of_three() {
        assert_eq!(8, pair([2, 3, 3, 4, 4]));
    }

    #[test]
    fn score_6_when_more_than_a_pair_of_three() {
        assert_eq!(6, pair([3, 3, 3, 3, 1]));
    }
}

mod category_two_pairs {
    use crate::category::two_pairs;

    #[test]
    fn score_0_when_no_pairs() {
        assert_eq!(0, two_pairs([1, 2, 3, 4, 5]));
    }

    #[test]
    fn score_0_when_one_pair() {
        assert_eq!(0, two_pairs([1, 1, 3, 4, 5]));
    }

    #[test]
    fn score_8_when_pair_of_one_and_pair_of_three() {
        assert_eq!(8, two_pairs([1, 1, 2, 3, 3]));
    }

    #[test]
    fn score_6_when_pair_of_one_and_more_than_a_pair_of_two() {
        assert_eq!(6, two_pairs([1, 1, 2, 2, 2]));
    }

    #[test]
    fn score_0_when_two_pairs_are_same() {
        assert_eq!(0, two_pairs([3, 3, 3, 3, 1]));
    }
}

mod category_three_of_a_kind {
    use crate::category::three_of_a_kind;

    #[test]
    fn score_0_when_no_three_of_a_kind() {
        assert_eq!(0, three_of_a_kind([3, 3, 4, 5, 6]));
    }

    #[test]
    fn score_12_when_three_fours() {
        assert_eq!(12, three_of_a_kind([3, 4, 1, 4, 4]));
    }

    #[test]
    fn score_9_when_four_threes() {
        assert_eq!(9, three_of_a_kind([3, 3, 1, 3, 3]));
    }
}

mod category_four_of_a_kind {
    use crate::category::four_of_a_kind;

    #[test]
    fn score_0_when_no_four_of_a_kind() {
        assert_eq!(0, four_of_a_kind([1, 2, 3, 4, 5]));
    }

    #[test]
    fn score_8_when_four_twos() {
        assert_eq!(8, four_of_a_kind([2, 2, 2, 2, 5]));
    }

    #[test]
    fn score_12_when_four_threes() {
        assert_eq!(12, four_of_a_kind([1, 3, 3, 3, 3]));
    }

    #[test]
    fn score_9_when_all_twos() {
        assert_eq!(8, four_of_a_kind([2, 2, 2, 2, 2]))
    }
}

mod category_small_straight {
    use crate::category::small_straight;

    #[test]
    fn score_0() {
        assert_eq!(0, small_straight([1, 2, 3, 4, 6]));
    }

    #[test]
    fn score_15() {
        assert_eq!(15, small_straight([3, 4, 1, 2, 5]));
    }
}

mod category_large_straight {
    use crate::category::large_straight;

    #[test]
    fn score_0() {
        assert_eq!(0, large_straight([1, 3, 4, 5, 6]));
    }

    #[test]
    fn score_20() {
        assert_eq!(20, large_straight([6, 5, 4, 2, 3]));
    }
}

mod category_full_house {
    use crate::category::full_house;

    #[test]
    fn score_0_when_all_the_same() {
        assert_eq!(0, full_house([2, 2, 2, 2, 2]));
    }

    #[test]
    fn score_0_when_only_two_of_a_kind() {
        assert_eq!(0, full_house([2, 1, 3, 4, 2]));
    }

    #[test]
    fn score_0_when_only_three_of_a_kind() {
        assert_eq!(0, full_house([1, 2, 3, 1, 1]));
    }

    #[test]
    fn score_0_when_four_of_a_kind() {
        assert_eq!(0, full_house([1, 2, 2, 2, 2]));
    }

    #[test]
    fn score_14_when_2_ones_and_3_fours() {
        assert_eq!(14, full_house([1, 4, 1, 4, 4]));
    }

    #[test]
    fn score_28_when_2_fives_and_3_sixes() {
        assert_eq!(28, full_house([5, 6, 6, 6, 5]));
    }
}
