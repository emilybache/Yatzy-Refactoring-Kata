import assert from 'assert';

import Yatzy from '../src/Yatzy';

describe('Chance', () => {
  it('scores sum of all dice', () => {
    assert.strictEqual(15, Yatzy.chance(2, 3, 4, 5, 1));
    assert.strictEqual(16, Yatzy.chance(3, 3, 4, 5, 1));
  });
});

describe('Yatzy', () => {
  it('scores 50', () => {
    assert.strictEqual(50, Yatzy.yatzy(4, 4, 4, 4, 4));
    assert.strictEqual(50, Yatzy.yatzy(6, 6, 6, 6, 6));
    assert.strictEqual(0, Yatzy.yatzy(6, 6, 6, 6, 3));
  });
});

describe('Ones', () => {
  it('score the sum of 1s', () => {
    assert.strictEqual(1, Yatzy.ones(1, 2, 3, 4, 5));
    assert.strictEqual(2, Yatzy.ones(1, 2, 1, 4, 5));
    assert.strictEqual(0, Yatzy.ones(6, 2, 2, 4, 5));
    assert.strictEqual(4, Yatzy.ones(1, 2, 1, 1, 1));
  });
});

describe('Twos', () => {
  it('score the sum of 2s', () => {
    assert.strictEqual(4, Yatzy.twos(1, 2, 3, 2, 6));
    assert.strictEqual(10, Yatzy.twos(2, 2, 2, 2, 2));
  });
});

describe('Threes', () => {
  it('score the sum of 3s', () => {
    assert.strictEqual(6, Yatzy.threes(1, 2, 3, 2, 3));
    assert.strictEqual(12, Yatzy.threes(2, 3, 3, 3, 3));
  });
});

describe('Fours', () => {
  it('score the sum of 4s', () => {
    assert.strictEqual(12, new Yatzy(4, 4, 4, 5, 5).fours());
    assert.strictEqual(8, new Yatzy(4, 4, 5, 5, 5).fours());
    assert.strictEqual(4, new Yatzy(4, 5, 5, 5, 5).fours());
  });
});

describe('Fives', () => {
  it('score the sum of fives', () => {
    assert.strictEqual(10, new Yatzy(4, 4, 4, 5, 5).fives());
    assert.strictEqual(15, new Yatzy(4, 4, 5, 5, 5).fives());
    assert.strictEqual(20, new Yatzy(4, 5, 5, 5, 5).fives());
  });
});

describe('Sixes', () => {
  it('score the sum of sixes', () => {
    assert.strictEqual(0, new Yatzy(4, 4, 4, 5, 5).sixes());
    assert.strictEqual(6, new Yatzy(4, 4, 6, 5, 5).sixes());
    assert.strictEqual(18, new Yatzy(6, 5, 6, 6, 5).sixes());
  });
});

describe('One pair', () => {
  it('scores the sum of the highest pair', () => {
    assert.strictEqual(6, Yatzy.score_pair(3, 4, 3, 5, 6));
    assert.strictEqual(10, Yatzy.score_pair(5, 3, 3, 3, 5));
    assert.strictEqual(12, Yatzy.score_pair(5, 3, 6, 6, 5));
  });
});

describe('Two pair', () => {
  it('scores the sum of the two pairs', () => {
    assert.strictEqual(16, Yatzy.two_pair(3, 3, 5, 4, 5));
    assert.strictEqual(16, Yatzy.two_pair(3, 3, 5, 5, 5));
  });
});

describe('Three of a kind', () => {
  it('scores the sum of the three of the kind', () => {
    assert.strictEqual(9, Yatzy.three_of_a_kind(3, 3, 3, 4, 5));
    assert.strictEqual(15, Yatzy.three_of_a_kind(5, 3, 5, 4, 5));
    assert.strictEqual(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 5));
  });
});

describe('Four of a kind', () => {
  it('scores the sum of the four of the kind', () => {
    assert.strictEqual(12, Yatzy.four_of_a_kind(3, 3, 3, 3, 5));
    assert.strictEqual(20, Yatzy.four_of_a_kind(5, 5, 5, 4, 5));
    assert.strictEqual(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 3));
  });
});

describe('Small straight', () => {
  it('scores 15', () => {
    assert.strictEqual(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
    assert.strictEqual(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
    assert.strictEqual(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
  });
});

describe('Large straight', () => {
  it('scores 20', () => {
    assert.strictEqual(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
    assert.strictEqual(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
    assert.strictEqual(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
  });
});

describe('Full house', () => {
  it('scores the sum of the full house', () => {
    assert.strictEqual(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
    assert.strictEqual(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
  });
});
