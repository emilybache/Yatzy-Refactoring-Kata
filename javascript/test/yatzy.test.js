const { beforeAll, describe, it } = require("@jest/globals");

const { verifyAll } = require("approvals/lib/Providers/Jest/JestApprovals");
const { configure } = require("approvals/lib/config");
const { JestReporter } = require("approvals/lib/Providers/Jest/JestReporter");

const Yatzy = require("../lib/Yatzy");

describe("Yatzy", () => {
    beforeAll(() => {
        configure({
            reporters: [new JestReporter()],
        });
    });

    const dice = [1, 2, 3, 4, 5, 6];

    function checkAll(compute) {
        const throws = dice.flatMap(d1 =>
            dice.flatMap(d2 =>
                dice.flatMap(d3 =>
                    dice.flatMap(d4 => dice.map(d5 => ({ d1, d2, d3, d4, d5 })))
                )
            )
        );
        verifyAll("throws", throws, t =>
            JSON.stringify({ throw: t, result: compute(t) })
        );
    }

    describe("Chance", () => {
        it("scores sum of all dice", function () {
            checkAll(t => Yatzy.chance(t.d1, t.d2, t.d3, t.d4, t.d5));
        });
    });

    describe("Yatzy", () => {
        it("scores 50", () => {
            checkAll(t => Yatzy.yatzy(t.d1, t.d2, t.d3, t.d4, t.d5));
        });
    });

    describe("Ones", () => {
        it("score the sum of 1s", () => {
            checkAll(t => Yatzy.ones(t.d1, t.d2, t.d3, t.d4, t.d5));
        });
    });

    describe("Twos", () => {
        it("score the sum of 2s", () => {
            checkAll(t => Yatzy.twos(t.d1, t.d2, t.d3, t.d4, t.d5));
        });
    });

    describe("Threes", () => {
        it("score the sum of 3s", () => {
            checkAll(t => Yatzy.threes(t.d1, t.d2, t.d3, t.d4, t.d5));
        });
    });

    describe("Fours", () => {
        it("score the sum of 4s", () => {
            checkAll(t => new Yatzy(t.d1, t.d2, t.d3, t.d4, t.d5).fours());
        });
    });

    describe("Fives", () => {
        it("score the sum of fives", () => {
            checkAll(t => new Yatzy(t.d1, t.d2, t.d3, t.d4, t.d5).fives());
        });
    });

    describe("Sixes", () => {
        it("score the sum of sixes", () => {
            checkAll(t => new Yatzy(t.d1, t.d2, t.d3, t.d4, t.d5).sixes());
        });
    });

    describe("One pair", () => {
        it("scores the sum of the highest pair", () => {
            checkAll(t => Yatzy.score_pair(t.d1, t.d2, t.d3, t.d4, t.d5));
        });
    });

    describe("Two pair", () => {
        it("scores the sum of the two pairs", () => {
            checkAll(t => Yatzy.two_pair(t.d1, t.d2, t.d3, t.d4, t.d5));
        });
    });

    describe("Three of a kind", () => {
        it("scores the sum of the three of the kind", () => {
            checkAll(t => Yatzy.three_of_a_kind(t.d1, t.d2, t.d3, t.d4, t.d5));
        });
    });

    describe("Four of a kind", () => {
        it("scores the sum of the four of the kind", () => {
            checkAll(t => Yatzy.four_of_a_kind(t.d1, t.d2, t.d3, t.d4, t.d5));
        });
    });

    describe("Small straight", () => {
        it("scores 15", () => {
            checkAll(t => Yatzy.smallStraight(t.d1, t.d2, t.d3, t.d4, t.d5));
        });
    });

    describe("Large straight", () => {
        it("scores 20", () => {
            checkAll(t => Yatzy.largeStraight(t.d1, t.d2, t.d3, t.d4, t.d5));
        });
    });

    describe("Full house", () => {
        it("scores the sum of the full house", () => {
            checkAll(t => Yatzy.fullHouse(t.d1, t.d2, t.d3, t.d4, t.d5));
        });
    });
});
