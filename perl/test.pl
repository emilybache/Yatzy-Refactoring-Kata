#!/usr/bin/env perl

use strict;
use warnings;

use Test::More 0.96;

use_ok 'Yatzy';

subtest 'chance_scores_sum_of_all_dice' => sub {
    my $expected = 15;
    my $actual = Yatzy::chance( 2, 3, 4, 5, 1 );
    is( $actual, $expected );
    is( Yatzy::chance( 3, 3, 4, 5, 1 ), 16 );
};

subtest 'yatzy_scores_50' => sub {
    my $expected = 50;
    my $actual = Yatzy::yatzy( 4, 4, 4, 4, 4 );
    is( $actual, $expected );
    is( Yatzy::yatzy( 6, 6, 6, 6, 6 ), 50 );
    is( Yatzy::yatzy( 6, 6, 6, 6, 3 ), 0 );
};

subtest 'test_1s' => sub {
    ok( Yatzy::ones( 1, 2, 3, 4, 5 ) == 1 );
    is( Yatzy::ones( 1, 2, 1, 4, 5 ), 2 );
    is( Yatzy::ones( 6, 2, 2, 4, 5 ), 0 );
    is( Yatzy::ones( 1, 2, 1, 1, 1 ), 4 );
};

subtest 'test_2s' => sub {
    is( Yatzy::twos( 1, 2, 3, 2, 6 ), 4 );
    is( Yatzy::twos( 2, 2, 2, 2, 2 ), 10 );
};

subtest 'test_threes' => sub {
    is( Yatzy::threes( 1, 2, 3, 2, 3 ), 6 );
    is( Yatzy::threes( 2, 3, 3, 3, 3 ), 12 );
};

subtest 'fours_test' => sub {
    is( Yatzy->new( 4, 4, 4, 5, 5 )->fours(), 12 );
    is( Yatzy->new( 4, 4, 5, 5, 5 )->fours(), 8 );
    is( Yatzy->new( 4, 5, 5, 5, 5 )->fours(), 4 );
};

subtest 'fives' => sub {
    is( Yatzy->new( 4, 4, 4, 5, 5 )->fives(), 10 );
    is( Yatzy->new( 4, 4, 5, 5, 5 )->fives(), 15 );
    is( Yatzy->new( 4, 5, 5, 5, 5 )->fives(), 20 );
};

subtest 'sixes_test' => sub {
    is( Yatzy->new( 4, 4, 4, 5, 5 )->sixes(), 0 );
    is( Yatzy->new( 4, 4, 6, 5, 5 )->sixes(), 6 );
    is( Yatzy->new( 6, 5, 6, 6, 5 )->sixes(), 18 );
};

subtest 'one_pair' => sub {
    is( Yatzy::score_pair( 3, 4, 3, 5, 6 ), 6 );
    is( Yatzy::score_pair( 5, 3, 3, 3, 5 ), 10 );
    is( Yatzy::score_pair( 5, 3, 6, 6, 5 ), 12 );
};

subtest 'two_Pair' => sub {
    is( Yatzy::two_pair( 3, 3, 5, 4, 5 ), 16 );
    is( Yatzy::two_pair( 3, 3, 5, 5, 5 ), 16 );
};

subtest 'three_of_a_kind' => sub {
    is( Yatzy::three_of_a_kind( 3, 3, 3, 4, 5 ), 9 );
    is( Yatzy::three_of_a_kind( 5, 3, 5, 4, 5 ), 15 );
    is( Yatzy::three_of_a_kind( 3, 3, 3, 3, 5 ), 9 );
};

subtest 'four_of_a_knd' => sub {
    is( Yatzy::four_of_a_kind( 3, 3, 3, 3, 5 ), 12 );
    is( Yatzy::four_of_a_kind( 5, 5, 5, 4, 5 ), 20 );
    is( Yatzy::four_of_a_kind( 3, 3, 3, 3, 3 ), 12 );
};

subtest 'smallStraight' => sub {
    is( Yatzy::smallStraight( 1, 2, 3, 4, 5 ), 15 );
    is( Yatzy::smallStraight( 2, 3, 4, 5, 1 ), 15 );
    is( Yatzy::smallStraight( 1, 2, 2, 4, 5 ), 0 );
};

subtest 'largeStraight' => sub {
    is( Yatzy::largeStraight( 6, 2, 3, 4, 5 ), 20 );
    is( Yatzy::largeStraight( 2, 3, 4, 5, 6 ), 20 );
    is( Yatzy::largeStraight( 1, 2, 2, 4, 5 ), 0 );
};

subtest 'fullHouse' => sub {
    is( Yatzy::fullHouse( 6, 2, 2, 2, 6 ), 18 );
    is( Yatzy::fullHouse( 2, 3, 4, 5, 6 ), 0 );
};

done_testing();
