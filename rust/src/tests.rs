mod category_chance {
    use crate::Yatzy;

    #[test]
    fn score_sum_of_the_roll() {
        assert_eq!(14, Yatzy::chance(1, 1, 3, 3, 6));
        assert_eq!(21, Yatzy::chance(4, 5, 5, 6, 1));
    }
}

mod category_yatzy {
    use crate::Yatzy;

    #[test]
    fn score_50_when_all_the_same() {
        assert_eq!(50, Yatzy::yatzy(1, 1, 1, 1, 1));
        assert_eq!(50, Yatzy::yatzy(5, 5, 5, 5, 5));
    }

    #[test]
    fn score_0_when_not_all_the_same() {
        assert_eq!(0, Yatzy::yatzy(1, 1, 1, 2, 1));
        assert_eq!(0, Yatzy::yatzy(1, 2, 2, 5, 5));
        assert_eq!(0, Yatzy::yatzy(6, 6, 6, 6, 3));
    }
}

mod category_ones {
    use crate::Yatzy;

    #[test]
    fn score_0_when_zero_ones() {
        assert_eq!(0, Yatzy::ones(2, 3, 5, 4, 6));
    }

    #[test]
    fn score_1_when_one_one() {
        assert_eq!(1, Yatzy::ones(6, 1, 2, 4, 4));
    }

    #[test]
    fn score_sum_of_ones() {
        assert_eq!(2, Yatzy::ones(1, 1, 2, 4, 4));
    }
}

mod category_twos {
    use crate::Yatzy;

    #[test]
    fn score_0_when_zero_twos() {
        assert_eq!(0, Yatzy::twos(1, 3, 5, 4, 6));
    }

    #[test]
    fn score_2_when_one_two() {
        assert_eq!(2, Yatzy::twos(6, 1, 2, 4, 4));
    }

    #[test]
    fn score_sum_of_twos() {
        assert_eq!(6, Yatzy::twos(2, 1, 2, 4, 2));
    }
}

mod category_threes {
    use crate::Yatzy;

    #[test]
    fn score_0_when_zero_threes() {
        assert_eq!(0, Yatzy::threes(1, 6, 5, 4, 6));
    }

    #[test]
    fn score_3_when_one_three() {
        assert_eq!(3, Yatzy::threes(6, 1, 2, 3, 4));
    }

    #[test]
    fn score_sum_of_threes() {
        assert_eq!(12, Yatzy::threes(3, 1, 3, 3, 3));
    }
}

mod category_fours {
    use crate::Yatzy;

    #[test]
    fn score_0_when_zero_fours() {
        assert_eq!(0, Yatzy::new(1, 6, 5, 2, 6).fours());
    }

    #[test]
    fn score_4_when_one_four() {
        assert_eq!(4, Yatzy::new(6, 1, 2, 3, 4).fours());
    }

    #[test]
    fn score_sum_of_fours() {
        assert_eq!(8, Yatzy::new(3, 1, 4, 3, 4).fours());
    }
}

mod category_fives {
    use crate::Yatzy;

    #[test]
    fn score_0_when_zero_fives() {
        assert_eq!(0, Yatzy::new(1, 6, 3, 2, 6).fives());
    }

    #[test]
    fn score_5_when_one_five() {
        assert_eq!(5, Yatzy::new(6, 1, 5, 3, 4).fives());
    }

    #[test]
    fn score_sum_of_fives() {
        assert_eq!(15, Yatzy::new(5, 1, 5, 3, 5).fives());
    }
}

mod category_sixes {
    use crate::Yatzy;

    #[test]
    fn score_0_when_zero_sixes() {
        assert_eq!(0, Yatzy::new(1, 5, 3, 2, 1).sixes());
    }

    #[test]
    fn score_6_when_one_six() {
        assert_eq!(6, Yatzy::new(6, 1, 5, 3, 4).sixes());
    }

    #[test]
    fn score_sum_of_sixes() {
        assert_eq!(30, Yatzy::new(6, 6, 6, 6, 6).sixes());
    }
}

mod category_pair {
    use crate::Yatzy;

    #[test]
    fn score_0_when_no_pairs() {
        assert_eq!(0, Yatzy::score_pair(1, 2, 3, 4, 5));
    }

    #[test]
    fn score_12_when_pair_of_six() {
        assert_eq!(12, Yatzy::score_pair(1, 2, 6, 3, 6));
    }

    #[test]
    fn score_8_when_pair_of_four_over_pair_of_three() {
        assert_eq!(8, Yatzy::score_pair(2, 3, 3, 4, 4));
    }

    #[test]
    fn score_6_when_more_than_a_pair_of_three() {
        assert_eq!(6, Yatzy::score_pair(3, 3, 3, 3, 1));
    }
}

mod category_two_pairs {
    use crate::Yatzy;

    #[test]
    fn score_0_when_no_pairs() {
        assert_eq!(0, Yatzy::two_pair(1, 2, 3, 4, 5));
    }

    #[test]
    fn score_0_when_one_pair() {
        assert_eq!(0, Yatzy::two_pair(1, 1, 3, 4, 5));
    }

    #[test]
    fn score_8_when_pair_of_one_and_pair_of_three() {
        assert_eq!(8, Yatzy::two_pair(1, 1, 2, 3, 3));
    }

    #[test]
    fn score_6_when_pair_of_one_and_more_than_a_pair_of_two() {
        assert_eq!(6, Yatzy::two_pair(1, 1, 2, 2, 2));
    }

    #[test]
    fn score_0_when_two_pairs_are_same() {
        assert_eq!(0, Yatzy::two_pair(3, 3, 3, 3, 1));
    }
}

mod category_three_of_a_kind {
    use crate::Yatzy;

    #[test]
    fn score_0_when_no_three_of_a_kind() {
        assert_eq!(0, Yatzy::three_of_a_kind(3, 3, 4, 5, 6));
    }

    #[test]
    fn score_12_when_three_fours() {
        assert_eq!(12, Yatzy::three_of_a_kind(3, 4, 1, 4, 4));
    }

    #[test]
    fn score_9_when_four_threes() {
        assert_eq!(9, Yatzy::three_of_a_kind(3, 3, 1, 3, 3));
    }
}

mod category_four_of_a_kind {
    use crate::Yatzy;

    #[test]
    fn score_0_when_no_four_of_a_kind() {
        assert_eq!(0, Yatzy::four_of_a_kind(1, 2, 3, 4, 5));
    }

    #[test]
    fn score_8_when_four_twos() {
        assert_eq!(8, Yatzy::four_of_a_kind(2, 2, 2, 2, 5));
    }

    #[test]
    fn score_12_when_four_threes() {
        assert_eq!(12, Yatzy::four_of_a_kind(1, 3, 3, 3, 3));
    }

    #[test]
    fn score_9_when_all_twos() {
        assert_eq!(8, Yatzy::four_of_a_kind(2, 2, 2, 2, 2))
    }
}

mod category_small_straight {
    use crate::Yatzy;

    #[test]
    fn score_0() {
        assert_eq!(0, Yatzy::smallStraight(1, 2, 3, 4, 6));
    }

    #[test]
    fn score_15() {
        assert_eq!(15, Yatzy::smallStraight(3, 4, 1, 2, 5));
    }
}

mod category_large_straight {
    use crate::Yatzy;

    #[test]
    fn score_0() {
        assert_eq!(0, Yatzy::largeStraight(1, 3, 4, 5, 6));
    }

    #[test]
    fn score_20() {
        assert_eq!(20, Yatzy::largeStraight(6, 5, 4, 2, 3));
    }
}

mod category_full_house {
    use crate::Yatzy;

    #[test]
    fn score_0_when_all_the_same() {
        assert_eq!(0, Yatzy::fullHouse(2, 2, 2, 2, 2));
    }

    #[test]
    fn score_0_when_only_two_of_a_kind() {
        assert_eq!(0, Yatzy::fullHouse(2, 1, 3, 4, 2));
    }

    #[test]
    fn score_0_when_only_three_of_a_kind() {
        assert_eq!(0, Yatzy::fullHouse(1, 2, 3, 1, 1));
    }

    #[test]
    fn score_0_when_four_of_a_kind() {
        assert_eq!(0, Yatzy::fullHouse(1, 2, 2, 2, 2));
    }

    #[test]
    fn score_14_when_2_ones_and_3_fours() {
        assert_eq!(14, Yatzy::fullHouse(1, 4, 1, 4, 4));
    }

    #[test]
    fn score_28_when_2_fives_and_3_sixes() {
        assert_eq!(28, Yatzy::fullHouse(5, 6, 6, 6, 5));
    }
}
