var assert = require("assert");
var Yatzy = require("../lib/yatzy2");


describe('Yatzy', function() {
    it('Chance scores sum of all dice', function(){
        const expected = 15;
        const actual = new Yatzy().score([2, 3, 4, 5, 1], "CHANCE");
        assert.equal(expected, actual);
        assert.equal(16, new Yatzy().score([3, 3, 4, 5, 1], "CHANCE"));
    });

    
    it('yatzy_scores_50', function()
    {
        assert.equal(50, new Yatzy().score([ 4, 4, 4, 4, 4 ], "YATZY"));
        assert.equal(50, new Yatzy().score([ 6, 6, 6, 6, 6 ], "YATZY"));
        assert.equal(0, new Yatzy().score([ 6, 6, 6, 6, 3 ], "YATZY"));
    })

    
    it('test_1s', function()
    {
        assert.equal(1, new Yatzy().score([ 1, 2, 3, 4, 5 ], "ONES"));
        assert.equal(2, new Yatzy().score([ 1, 2, 1, 4, 5 ], "ONES"));
        assert.equal(0, new Yatzy().score([ 6, 2, 2, 4, 5 ], "ONES"));
        assert.equal(4, new Yatzy().score([ 1, 2, 1, 1, 1 ], "ONES"));
    })

    
    it('twos', function()
    {
        assert.equal(4, new Yatzy().score([ 1, 2, 3, 2, 6 ], "TWOS"));
        assert.equal(10, new Yatzy().score([ 2, 2, 2, 2, 2 ], "TWOS"));
    })

    
    it('threes', function()
    {
        assert.equal(6, new Yatzy().score([ 1, 2, 3, 2, 3 ], "THREES"));
        assert.equal(12, new Yatzy().score([ 2, 3, 3, 3, 3 ], "THREES"));
    })

    
    it('fours', function()
    {
        assert.equal(12, new Yatzy().score([ 4, 4, 4, 5, 5 ], "FOURS"));
        assert.equal(8, new Yatzy().score([ 4, 4, 5, 5, 5 ], "FOURS"));
        assert.equal(4, new Yatzy().score([ 4, 5, 5, 5, 5 ], "FOURS"));
    })

    
    it('fives', function()
    {
        assert.equal(10, new Yatzy().score([ 4, 4, 4, 5, 5 ], "FIVES"));
        assert.equal(15, new Yatzy().score([ 4, 4, 5, 5, 5 ], "FIVES"));
        assert.equal(20, new Yatzy().score([ 4, 5, 5, 5, 5 ], "FIVES"));
    })

    
    it('sixes', function()
    {
        assert.equal(0, new Yatzy().score([ 4, 4, 4, 5, 5 ], "SIXES"));
        assert.equal(6, new Yatzy().score([ 4, 4, 6, 5, 5 ], "SIXES"));
        assert.equal(18, new Yatzy().score([ 6, 5, 6, 6, 5 ], "SIXES"));
    })

    
    it('pair', function()
    {
        assert.equal(6, new Yatzy().score([ 3, 4, 3, 5, 6 ], "PAIR"));
        assert.equal(10, new Yatzy().score([ 5, 3, 3, 3, 5 ], "PAIR"));
        assert.equal(12, new Yatzy().score([ 5, 3, 6, 6, 5 ], "PAIR"));
    })

    
    it('two_pair', function()
    {
        assert.equal(16, new Yatzy().score([ 3, 3, 5, 4, 5 ], "TWO_PAIRS"));
        assert.equal(16, new Yatzy().score([ 3, 3, 5, 5, 5 ], "TWO_PAIRS"));
    })

    
    it('three_of_a_kind', function()
    {
        assert.equal(9, new Yatzy().score([ 3, 3, 3, 4, 5 ], "THREE_OF_A_KIND"));
        assert.equal(15, new Yatzy().score([ 5, 3, 5, 4, 5 ], "THREE_OF_A_KIND"));
        assert.equal(9, new Yatzy().score([ 3, 3, 3, 3, 5 ], "THREE_OF_A_KIND"));
    })

    
    it('four_of_a_knd', function()
    {
        assert.equal(12, new Yatzy().score([ 3, 3, 3, 3, 5 ], "FOUR_OF_A_KIND"));
        assert.equal(20, new Yatzy().score([ 5, 5, 5, 4, 5 ], "FOUR_OF_A_KIND"));
        assert.equal(12, new Yatzy().score([ 3, 3, 3, 3, 3 ], "FOUR_OF_A_KIND"));
    })

    
    it('smallStraight', function()
    {
        assert.equal(15, new Yatzy().score([ 1, 2, 3, 4, 5 ], "SMALL_STRAIGHT"));
        assert.equal(15, new Yatzy().score([ 2, 3, 4, 5, 1 ], "SMALL_STRAIGHT"));
        assert.equal(0, new Yatzy().score([ 1, 2, 2, 4, 5 ], "SMALL_STRAIGHT"));
    })

    
    it('largeStraight', function()
    {
        assert.equal(20, new Yatzy().score([ 6, 2, 3, 4, 5 ], "LARGE_STRAIGHT"));
        assert.equal(20, new Yatzy().score([ 2, 3, 4, 5, 6 ], "LARGE_STRAIGHT"));
        assert.equal(0, new Yatzy().score([ 1, 2, 2, 4, 5 ], "LARGE_STRAIGHT"));
    })

    
    it('fullHouse', function()
    {
        assert.equal(18, new Yatzy().score([ 6, 2, 2, 2, 6 ], "FULL_HOUSE"));
        assert.equal(0, new Yatzy().score([ 2, 3, 4, 5, 6 ], "FULL_HOUSE"));
    })
});

