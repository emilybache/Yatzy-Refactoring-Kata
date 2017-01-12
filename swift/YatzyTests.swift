import XCTest
@testable import Yatzy_Refactoring_Kata

class YatzyTests: XCTestCase {
    
    func testChanceScoresSumOfAllDice() {
        let expected = 15
        let actual = Yatzy.chance(d1: 2, d2: 3, d3: 4, d4: 5, d5: 1)
        XCTAssertEqual(expected, actual)
        XCTAssertEqual(16, Yatzy.chance(d1: 3, d2: 3, d3: 4, d4: 5, d5: 1))
    }
    
    func testYatzyScores50() {
        let expected = 50
        let actual = Yatzy.yatzy(dice: 4, 4, 4, 4, 4)
        XCTAssertEqual(expected, actual)
        XCTAssertEqual(50, Yatzy.yatzy(dice: 6, 6, 6, 6, 6))
        XCTAssertEqual(0, Yatzy.yatzy(dice: 6, 6, 6, 6, 3))
    }
    
    func test1s() {
        XCTAssertTrue(Yatzy.ones(d1: 1, d2: 2, d3: 3, d4: 4, d5: 5) == 1)
        XCTAssertEqual(2, Yatzy.ones(d1: 1, d2: 2, d3: 1, d4: 4, d5: 5))
        XCTAssertEqual(0, Yatzy.ones(d1: 6, d2: 2, d3: 2, d4: 4, d5: 5))
        XCTAssertEqual(4, Yatzy.ones(d1: 1, d2: 2, d3: 1, d4: 1, d5: 1))
    }
    
    func test2s() {
        XCTAssertEqual(4, Yatzy.twos(d1: 1, d2: 2, d3: 3, d4: 2, d5: 6))
        XCTAssertEqual(10, Yatzy.twos(d1: 2, d2: 2, d3: 2, d4: 2, d5: 2))
    }

    func test3s() {
        XCTAssertEqual(6, Yatzy.threes(d1: 1, d2: 2, d3: 3, d4: 2, d5: 3))
        XCTAssertEqual(12, Yatzy.threes(d1: 2, d2: 3, d3: 3, d4: 3, d5: 3))
    }
    
    func test4s() {
        XCTAssertEqual(12, Yatzy(d1: 4, d2: 4, d3: 4, d4: 5, _5: 5).fours())
        XCTAssertEqual(8, Yatzy(d1: 4, d2: 4, d3: 5, d4: 5, _5: 5).fours())
        XCTAssertEqual(4, Yatzy(d1: 4, d2: 5, d3: 5, d4: 5, _5: 5).fours())
    }

    func test5s() {
        XCTAssertEqual(10, Yatzy(d1: 4, d2: 4, d3: 4, d4: 5, _5: 5).fives())
        XCTAssertEqual(15, Yatzy(d1: 4, d2: 4, d3: 5, d4: 5, _5: 5).fives())
        XCTAssertEqual(20, Yatzy(d1: 4, d2: 5, d3: 5, d4: 5, _5: 5).fives())
    }
    
    func test6s() {
        XCTAssertEqual(0, Yatzy(d1: 4, d2: 4, d3: 4, d4: 5, _5: 5).sixes())
        XCTAssertEqual(6, Yatzy(d1: 4, d2: 4, d3: 6, d4: 5, _5: 5).sixes())
        XCTAssertEqual(18, Yatzy(d1: 6, d2: 5, d3: 6, d4: 6, _5: 5).sixes())
    }
    
    func testOnePair() {
        XCTAssertEqual(6, Yatzy.scorePair(d1: 3, d2: 4, d3: 3, d4: 5, d5: 6))
        XCTAssertEqual(10, Yatzy.scorePair(d1: 5, d2: 3, d3: 3, d4: 3, d5: 5))
        XCTAssertEqual(12, Yatzy.scorePair(d1: 5, d2: 3, d3: 6, d4: 6, d5: 5))
    }
    
    func testTwoPairs() {
        XCTAssertEqual(16, Yatzy.twoPairs(d1: 3, d2: 3, d3: 5, d4: 4, d5: 5))
        XCTAssertEqual(16, Yatzy.twoPairs(d1: 3, d2: 3, d3: 5, d4: 5, d5: 5))
    }
    
    func testThreeOfAKind() {
        XCTAssertEqual(9, Yatzy.threeOfAKind(d1: 3, d2: 3, d3: 3, d4: 4, d5: 5))
        XCTAssertEqual(15, Yatzy.threeOfAKind(d1: 5, d2: 3, d3: 5, d4: 4, d5: 5))
        XCTAssertEqual(9, Yatzy.threeOfAKind(d1: 3, d2: 3, d3: 3, d4: 3, d5: 5))
    }
    
    func testFourOfAKind() {
        XCTAssertEqual(12, Yatzy.fourOfAKind(_1: 3, _2: 3, d3: 3, d4: 3, d5: 5))
        XCTAssertEqual(20, Yatzy.fourOfAKind(_1: 5, _2: 5, d3: 5, d4: 4, d5: 5))
        XCTAssertEqual(9, Yatzy.threeOfAKind(d1: 3, d2: 3, d3: 3, d4: 3, d5: 3))
    }
    
    func testSmallStraight() {
        XCTAssertEqual(15, Yatzy.smallStraight(d1: 1, d2: 2, d3: 3, d4: 4, d5: 5))
        XCTAssertEqual(15, Yatzy.smallStraight(d1: 2, d2: 3, d3: 4, d4: 5, d5: 1))
        XCTAssertEqual(0, Yatzy.smallStraight(d1: 1, d2: 2, d3: 2, d4: 4, d5: 5))
    }
    
    func testLargeStraight() {
        XCTAssertEqual(20, Yatzy.largeStraight(d1: 6, d2: 2, d3: 3, d4: 4, d5: 5))
        XCTAssertEqual(20, Yatzy.largeStraight(d1: 2, d2: 3, d3: 4, d4: 5, d5: 6))
        XCTAssertEqual(0, Yatzy.largeStraight(d1: 1, d2: 2, d3: 3, d4: 4, d5: 5))
    }
    
    func testFullHouse() {
        XCTAssertEqual(18, Yatzy.fullHouse(d1: 6, d2: 2, d3: 2, d4: 2, d5: 6))
        XCTAssertEqual(0, Yatzy.fullHouse(d1: 2, d2: 3, d3: 4, d4: 5, d5: 6))
    }
}
