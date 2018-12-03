<?php

use PHPUnit\Framework\TestCase;

include "yatzy.php";

class YatzyTest extends TestCase
{

    public function test_chance_scores_sum_of_all_dice()
    {
        $expected = 15;
        $actual = Yatzy::chance(2, 3, 4, 5, 1);
        $this->assertEquals($expected, $actual);
        $this->assertEquals(16, Yatzy::chance(3, 3, 4, 5, 1));
    }

    public function test_yatzy_scores_50()
    {
        $expected = 50;
        $actual = Yatzy::yatzyScore([4, 4, 4, 4, 4]);
        $this->assertEquals($expected, $actual);
        $this->assertEquals(50, Yatzy::yatzyScore([6, 6, 6, 6, 6]));
        $this->assertEquals(0, Yatzy::yatzyScore([6, 6, 6, 6, 3]));
    }

    public function test_1s()
    {
        $this->assertEquals(1, Yatzy::ones(1, 2, 3, 4, 5));
        $this->assertEquals(2, Yatzy::ones(1, 2, 1, 4, 5));
        $this->assertEquals(0, Yatzy::ones(6, 2, 2, 4, 5));
        $this->assertEquals(4, Yatzy::ones(1, 2, 1, 1, 1));
    }

    public function test_2s()
    {
        $this->assertEquals(4, Yatzy::twos(1, 2, 3, 2, 6));
        $this->assertEquals(10, Yatzy::twos(2, 2, 2, 2, 2));
    }

    public function test_threes()
    {
        $this->assertEquals(6, Yatzy::threes(1, 2, 3, 2, 3));
        $this->assertEquals(12, Yatzy::threes(2, 3, 3, 3, 3));
    }

    public function test_fours_test()
    {
        $this->assertEquals(12, (new Yatzy(4, 4, 4, 5, 5))->fours());
        $this->assertEquals(8, (new Yatzy(4, 4, 5, 5, 5))->fours());
        $this->assertEquals(4, (new Yatzy(4, 5, 5, 5, 5))->fours());
    }

    public function test_fives()
    {
        $this->assertEquals(10, (new Yatzy(4, 4, 4, 5, 5))->Fives());
        $this->assertEquals(15, (new Yatzy(4, 4, 5, 5, 5))->Fives());
        $this->assertEquals(20, (new Yatzy(4, 5, 5, 5, 5))->Fives());
    }

    public function sixes_test()
    {
        $this->assertEquals(0, (new Yatzy(4, 4, 4, 5, 5))->sixes());
        $this->assertEquals(6, (new Yatzy(4, 4, 6, 5, 5))->sixes());
        $this->assertEquals(18, (new Yatzy(6, 5, 6, 6, 5))->sixes());
    }

    public function test_one_pair()
    {
        $this->assertEquals(6, Yatzy::score_pair(3, 4, 3, 5, 6));
        $this->assertEquals(10, Yatzy::score_pair(5, 3, 3, 3, 5));
        $this->assertEquals(12, Yatzy::score_pair(5, 3, 6, 6, 5));
    }

    public function test_two_Pair()
    {
        $this->assertEquals(16, Yatzy::two_pair(3, 3, 5, 4, 5));
        $this->assertEquals(18, Yatzy::two_pair(3, 3, 6, 6, 6));
        $this->assertEquals(0, Yatzy::two_pair(3, 3, 6, 5, 4));
    }

    public function test_three_of_a_kind()
    {
        $this->assertEquals(9, Yatzy::three_of_a_kind(3, 3, 3, 4, 5));
        $this->assertEquals(15, Yatzy::three_of_a_kind(5, 3, 5, 4, 5));
        $this->assertEquals(9, Yatzy::three_of_a_kind(3, 3, 3, 2, 1));
    }

    public function test_smallStraight()
    {
        $this->assertEquals(15, Yatzy::smallStraight(1, 2, 3, 4, 5));
        $this->assertEquals(15, Yatzy::smallStraight(2, 3, 4, 5, 1));
        $this->assertEquals(0, Yatzy::smallStraight(1, 2, 2, 4, 5));
    }

    public function test_largeStraight()
    {
        $this->assertEquals(20, Yatzy::largeStraight(6, 2, 3, 4, 5));
        $this->assertEquals(20, Yatzy::largeStraight(2, 3, 4, 5, 6));
        $this->assertEquals(0, Yatzy::largeStraight(1, 2, 2, 4, 5));
    }

    public function test_fullHouse()
    {
        $this->assertEquals(18, Yatzy::fullHouse(6, 2, 2, 2, 6));
        $this->assertEquals(0, Yatzy::fullHouse(2, 3, 4, 5, 6));
    }
}
