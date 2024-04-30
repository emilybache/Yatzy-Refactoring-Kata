var assert = require("assert");
var Yatzy = require("../lib/yatzy2");


describe('Yatzy', function() {
    it('Chance scores sum of all dice', function(){
        assert.equal(15, new Yatzy().score("CHANCE", 2, 3, 4, 5, 1));
    });
});

