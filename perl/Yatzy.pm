package Yatzy;

use strict;
use warnings;

sub chance {
    my ( $d1, $d2, $d3, $d4, $d5 ) = @_;
    my $total = 0;
    $total += $d1;
    $total += $d2;
    $total += $d3;
    $total += $d4;
    $total += $d5;
    return $total;
}

sub yatzy {
    my (@dice) = @_;
    my @counts = (0) x 6;
    for my $die (@dice) {
        $counts[ $die - 1 ] += 1;
    }
    for my $i ( 0 .. 5 ) {
        if ( $counts[$i] == 5 ) {
            return 50;
        }
    }
    return 0;
}

sub ones {
    my ( $d1, $d2, $d3, $d4, $d5 ) = @_;
    my $sum = 0;
    if ( $d1 == 1 ) {
        $sum++;
    }
    if ( $d2 == 1 ) {
        $sum++;
    }
    if ( $d3 == 1 ) {
        $sum++;
    }
    if ( $d4 == 1 ) {
        $sum++;
    }
    if ( $d5 == 1 ) {
        $sum++;
    }
    return $sum;
}

sub twos {
    my ( $d1, $d2, $d3, $d4, $d5 ) = @_;
    my $sum = 0;
    if ( $d1 == 2 ) {
        $sum += 2;
    }
    if ( $d2 == 2 ) {
        $sum += 2;
    }
    if ( $d3 == 2 ) {
        $sum += 2;
    }
    if ( $d4 == 2 ) {
        $sum += 2;
    }
    if ( $d5 == 2 ) {
        $sum += 2;
    }
    return $sum;
}

sub threes {
    my ( $d1, $d2, $d3, $d4, $d5 ) = @_;
    my $s = 0;
    if ( $d1 == 3 ) {
        $s += 3;
    }
    if ( $d2 == 3 ) {
        $s += 3;
    }
    if ( $d3 == 3 ) {
        $s += 3;
    }
    if ( $d4 == 3 ) {
        $s += 3;
    }
    if ( $d5 == 3 ) {
        $s += 3;
    }
    return $s;
}

sub new {
    my ( $class, $d1, $d2, $d3, $d4, $_5 ) = @_;
    my @dice = (0) x 5;
    $dice[0] = $d1;
    $dice[1] = $d2;
    $dice[2] = $d3;
    $dice[3] = $d4;
    $dice[4] = $_5;
    my $self = { dice => \@dice };
    return bless $self, $class;
}

sub fours {
    my ($self) = @_;
    my $sum;
    $sum = 0;
    for my $at ( 0 .. 4 ) {
        if ( $self->{dice}->[$at] == 4 ) {
            $sum += 4;
        }
    }
    return $sum;
}

sub fives {
    my ($self) = @_;
    my $s = 0;
    my $i;
    for ( $i = 0; $i < @{ $self->{dice} }; $i++ ) {
        if ( $self->{dice}->[$i] == 5 ) {
            $s = $s + 5;
        }
    }
    return $s;
}

sub sixes {
    my ($self) = @_;
    my $sum = 0;
    for my $at ( 0 .. $#{ $self->{dice} } ) {
        if ( $self->{dice}->[$at] == 6 ) {
            $sum = $sum + 6;
        }
    }
    return $sum;
}

sub score_pair {
    my ( $d1, $d2, $d3, $d4, $d5 ) = @_;
    my @counts = (0) x 6;
    $counts[ $d1 - 1 ]++;
    $counts[ $d2 - 1 ]++;
    $counts[ $d3 - 1 ]++;
    $counts[ $d4 - 1 ]++;
    $counts[ $d5 - 1 ]++;
    my $at;

    for $at ( 0 .. 5 ) {
        if ( $counts[ 6 - $at - 1 ] >= 2 ) {
            return ( 6 - $at ) * 2;
        }
    }
    return 0;
}

sub two_pair {
    my ( $d1, $d2, $d3, $d4, $d5 ) = @_;
    my @counts = (0) x 6;
    $counts[ $d1 - 1 ]++;
    $counts[ $d2 - 1 ]++;
    $counts[ $d3 - 1 ]++;
    $counts[ $d4 - 1 ]++;
    $counts[ $d5 - 1 ]++;
    my $n     = 0;
    my $score = 0;

    for my $i ( 0 .. 5 ) {
        if ( $counts[ 6 - $i - 1 ] >= 2 ) {
            $n++;
            $score += ( 6 - $i );
        }
    }
    if ( $n == 2 ) {
        return $score * 2;
    }
    else {
        return 0;
    }
}

sub four_of_a_kind {
    my ( $_1, $_2, $d3, $d4, $d5 ) = @_;
    my @tallies;
    @tallies = (0) x 6;
    $tallies[ $_1 - 1 ]++;
    $tallies[ $_2 - 1 ]++;
    $tallies[ $d3 - 1 ]++;
    $tallies[ $d4 - 1 ]++;
    $tallies[ $d5 - 1 ]++;

    for my $i ( 0 .. 5 ) {
        if ( $tallies[$i] >= 4 ) {
            return ( $i + 1 ) * 4;
        }
    }
    return 0;
}

sub three_of_a_kind {
    my ( $d1, $d2, $d3, $d4, $d5 ) = @_;
    my @t;
    @t = (0) x 6;
    $t[ $d1 - 1 ]++;
    $t[ $d2 - 1 ]++;
    $t[ $d3 - 1 ]++;
    $t[ $d4 - 1 ]++;
    $t[ $d5 - 1 ]++;

    for my $i ( ( 0, 1, 2, 3, 4, 5 ) ) {
        if ( $t[$i] >= 3 ) {
            return ( $i + 1 ) * 3;
        }
    }
    return 0;
}

sub smallStraight {
    my ( $d1, $d2, $d3, $d4, $d5 ) = @_;
    my @tallies;
    @tallies = (0) x 6;
    $tallies[ $d1 - 1 ]++;
    $tallies[ $d2 - 1 ]++;
    $tallies[ $d3 - 1 ]++;
    $tallies[ $d4 - 1 ]++;
    $tallies[ $d5 - 1 ]++;

    if (   $tallies[0] == 1
        && $tallies[1] == 1
        && $tallies[2] == 1
        && $tallies[3] == 1
        && $tallies[4] == 1 )
    {
        return 15;
    }
    return 0;
}

sub largeStraight {
    my ( $d1, $d2, $d3, $d4, $d5 ) = @_;
    my @tallies;
    @tallies = (0) x 6;
    $tallies[ $d1 - 1 ]++;
    $tallies[ $d2 - 1 ]++;
    $tallies[ $d3 - 1 ]++;
    $tallies[ $d4 - 1 ]++;
    $tallies[ $d5 - 1 ]++;

    if (   $tallies[1] == 1
        && $tallies[2] == 1
        && $tallies[3] == 1
        && $tallies[4] == 1
        && $tallies[5] == 1 )
    {
        return 20;
    }
    return 0;
}

sub fullHouse {
    my ( $d1, $d2, $d3, $d4, $d5 ) = @_;
    my @tallies;
    my $i;
    my $_2    = 0;
    my $_2_at = 0;
    my $_3    = 0;
    my $_3_at = 0;

    @tallies = (0) x 6;
    $tallies[ $d1 - 1 ] += 1;
    $tallies[ $d2 - 1 ] += 1;
    $tallies[ $d3 - 1 ] += 1;
    $tallies[ $d4 - 1 ] += 1;
    $tallies[ $d5 - 1 ] += 1;

    for $i ( 0 .. 5 ) {
        if ( $tallies[$i] == 2 ) {
            $_2    = 1;
            $_2_at = $i + 1;
        }
    }

    for $i ( 0 .. 5 ) {
        if ( $tallies[$i] == 3 ) {
            $_3    = 1;
            $_3_at = $i + 1;
        }
    }

    if ( $_2 && $_3 ) {
        return $_2_at * 2 + $_3_at * 3;
    }
    else {
        return 0;
    }
}

1;
