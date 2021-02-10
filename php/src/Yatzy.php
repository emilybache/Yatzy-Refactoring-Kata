<?php
declare(strict_types=1);

namespace Yatzy;

class Yatzy
{
    public static function chance($d1, $d2, $d3, $d4, $d5)
    {
        $total = 0;
        $total += $d1;
        $total += $d2;
        $total += $d3;
        $total += $d4;
        $total += $d5;
        return $total;
    }

    public static function yatzyScore($dice)
    {
        $counts = array_fill(0, count($dice) + 1, 0);
        foreach ($dice as $die) {
            $counts[$die - 1] += 1;
        }
        foreach (range(0, count($counts) - 1) as $i) {
            if ($counts[$i] == 5)
                return 50;
        }
        return 0;
    }

    public static function ones($d1, $d2, $d3, $d4, $d5)
    {
        $sum = 0;
        if ($d1 == 1)
            $sum += 1;
        if ($d2 == 1)
            $sum += 1;
        if ($d3 == 1)
            $sum += 1;
        if ($d4 == 1)
            $sum += 1;
        if ($d5 == 1)
            $sum += 1;

        return $sum;
    }

    public static function twos($d1, $d2, $d3, $d4, $d5)
    {
        $sum = 0;
        if ($d1 == 2)
            $sum += 2;
        if ($d2 == 2)
            $sum += 2;
        if ($d3 == 2)
            $sum += 2;
        if ($d4 == 2)
            $sum += 2;
        if ($d5 == 2)
            $sum += 2;

        return $sum;
    }

    public static function threes($d1, $d2, $d3, $d4, $d5)
    {
        $s = 0;
        if ($d1 == 3)
            $s += 3;
        if ($d2 == 3)
            $s += 3;
        if ($d3 == 3)
            $s += 3;
        if ($d4 == 3)
            $s += 3;
        if ($d5 == 3)
            $s += 3;

        return $s;
    }

    public function __construct($d1, $d2, $d3, $d4, $_5)
    {
        $this->dice = array_fill(0, 6, 0);
        $this->dice[0] = $d1;
        $this->dice[1] = $d2;
        $this->dice[2] = $d3;
        $this->dice[3] = $d4;
        $this->dice[4] = $_5;
    }

    public function fours()
    {
        $sum = 0;
        for ($at = 0; $at != 5; $at++) {
            if ($this->dice[$at] == 4) {
                $sum += 4;
            }
        }
        return $sum;
    }

    public function Fives()
    {
        $s = 0;
        $i = 0;
        for ($i = 0; $i < 5; $i++)
            if ($this->dice[$i] == 5)
                $s = $s + 5;
        return $s;
    }

    public function sixes()
    {
        $sum = 0;
        for ($at = 0; $at < 5; $at++)
            if ($this->dice[$at] == 6)
                $sum = $sum + 6;
        return $sum;
    }

    public static function score_pair($d1, $d2, $d3, $d4, $d5)
    {
        $counts = array_fill(0, 6, 0);
        $counts[$d1 - 1] += 1;
        $counts[$d2 - 1] += 1;
        $counts[$d3 - 1] += 1;
        $counts[$d4 - 1] += 1;
        $counts[$d5 - 1] += 1;
        for ($at = 0; $at != 6; $at++)
            if ($counts[6 - $at - 1] == 2)
                return (6 - $at) * 2;
        return 0;
    }

    public static function two_pair($d1, $d2, $d3, $d4, $d5)
    {
        $counts = array_fill(0, 6, 0);
        $counts[$d1 - 1] += 1;
        $counts[$d2 - 1] += 1;
        $counts[$d3 - 1] += 1;
        $counts[$d4 - 1] += 1;
        $counts[$d5 - 1] += 1;
        $n = 0;
        $score = 0;
        for ($i = 0; $i != 6; $i++)
            if ($counts[6 - $i - 1] >= 2) {
                $n = $n + 1;
                $score += (6 - $i);
            }

        if ($n == 2)
            return $score * 2;
        else
            return 0;
    }

    public static function three_of_a_kind($d1, $d2, $d3, $d4, $d5)
    {
        $t = array_fill(0, 6, 0);
        $t[$d1 - 1] += 1;
        $t[$d2 - 1] += 1;
        $t[$d3 - 1] += 1;
        $t[$d4 - 1] += 1;
        $t[$d5 - 1] += 1;
        for ($i = 0; $i != 6; $i++)
            if ($t[$i] >= 3)
                return ($i + 1) * 3;
        return 0;
    }

    public static function smallStraight($d1, $d2, $d3, $d4, $d5)
    {
        $tallies = array_fill(0, 6, 0);
        $tallies[$d1 - 1] += 1;
        $tallies[$d2 - 1] += 1;
        $tallies[$d3 - 1] += 1;
        $tallies[$d4 - 1] += 1;
        $tallies[$d5 - 1] += 1;
        if ($tallies[0] == 1 &&
            $tallies[1] == 1 &&
            $tallies[2] == 1 &&
            $tallies[3] == 1 &&
            $tallies[4] == 1)
            return 15;
        return 0;
    }

    public static function largeStraight($d1, $d2, $d3, $d4, $d5)
    {
        $tallies = array_fill(0, 6, 0);
        $tallies[$d1 - 1] += 1;
        $tallies[$d2 - 1] += 1;
        $tallies[$d3 - 1] += 1;
        $tallies[$d4 - 1] += 1;
        $tallies[$d5 - 1] += 1;
        if ($tallies[1] == 1 &&
            $tallies[2] == 1 &&
            $tallies[3] == 1 &&
            $tallies[4] == 1 &&
            $tallies[5] == 1)
            return 20;
        return 0;
    }

    public static function fullHouse($d1, $d2, $d3, $d4, $d5)
    {
        $tallies = [];
        $_2 = false;
        $i = 0;
        $_2_at = 0;
        $_3 = False;
        $_3_at = 0;

        $tallies = array_fill(0, 6, 0);
        $tallies[$d1 - 1] += 1;
        $tallies[$d2 - 1] += 1;
        $tallies[$d3 - 1] += 1;
        $tallies[$d4 - 1] += 1;
        $tallies[$d5 - 1] += 1;

        foreach (range(0, 5) as $i) {
            if ($tallies[$i] == 2) {
                $_2 = True;
                $_2_at = $i + 1;
            }
        }

        foreach (range(0, 5) as $i) {
            if ($tallies[$i] == 3) {
                $_3 = True;
                $_3_at = $i + 1;
            }
        }

        if ($_2 && $_3)
            return $_2_at * 2 + $_3_at * 3;
        else
            return 0;
    }
}
