(ns yatzy-clj.yatzy
  (:gen-class))

(defn chance [d1 d2 d3 d4 d5]
  (+ d1 d2 d3 d4 d5))

(defn sum-dice [dice value]
  (reduce + (filter (fn [die] (= value die)) dice)))

(defn ones [d1 d2 d3 d4 d5]
  (+ (if (= d1 1) 1 0)
     (if (= d2 1) 1 0)
     (if (= d3 1) 1 0)
     (if (= d4 1) 1 0)
     (if (= d5 1) 1 0))
  )

(defn twos [d1 d2 d3 d4 d5]
  (+ (if (= d1 2) 2 0)
     (if (= d2 2) 2 0)
     (if (= d3 2) 2 0)
     (if (= d4 2) 2 0)
     (if (= d5 2) 2 0))
  )

(defn threes [d1 d2 d3 d4 d5]
  (+ (if (= d1 3) 3 0)
     (if (= d2 3) 3 0)
     (if (= d3 3) 3 0)
     (if (= d4 3) 3 0)
     (if (= d5 3) 3 0))
  )

(defn fours [d1 d2 d3 d4 _5]
  (let [dice [d1 d2 d3 d4 _5]]
    (apply +
           (for [at (range 0 5)]
             (if (= 4 (nth dice at)) 4 0)
             )
           )
    )
  )

(defn fives_ [d1 d2 d3 d4 _5]
  (let [dice [d1 d2 d3 d4 _5]]
    (apply +
           (for [i (range 0 (count dice))]
             (if (= 5 (nth dice i)) 5 0)
             )
           )
    )
  )

(defn sixes [d1 d2 d3 d4 _5]
  (let [dice [d1 d2 d3 d4 _5]]
    (apply +
           (for [at (range 0 (count dice))]
             (if (= 6 (nth dice at)) 6 0)
             )
           )
    )
  )

(defn count-value [dice value]
  (->> (filter (fn [die] (= value die)) dice)
       (count)))

(defn tally-die [dice]
  (map (fn [x] (count-value dice x)) (range 1 7)))

(defn get-first-tally [tallies value]
  (->> (range 0 6)
       (filter #(= value (nth tallies %)))
       (first)))

(defn yatzy [dice]
  (let [tallies (tally-die dice)]
    (if (= nil (get-first-tally tallies 5))
      0
      50)))

(defn pair [dice]
  (let [tallies (tally-die dice)
        result (->> (range 0 5)
                    (map (fn [i] (- 5 i)))
                    (filter #(> (nth tallies %) 1))
                    (map #(* (+ % 1) 2))
                    (first))]
    (if (= nil result) 0 result)))

(defn two-pair [dice]
  (let [tallies (tally-die dice)
        result (->> (range 0 6)
                    (filter #(>= (nth tallies (- 6 % 1)) 2))
                    (map #(- 6 %))
                    (reduce +)
                    (* 2))]
    (if (= nil result) 0 result)))

(defn x-of-a-kind [dice x]
  (let [tallies (tally-die dice)
        result (->> (range 0 6)
                    (filter #(>= (nth tallies %) x))
                    (map (fn [i] (* (+ i 1) x)))
                    (first))]
    (if (= nil result) 0 result)))

(defn three-of-a-kind [dice]
  (x-of-a-kind dice 3))

(defn four-of-a-kind [dice]
  (x-of-a-kind dice 4))

(defn straight [dice start end]
  (->> (range start end)
       (filter #(not= (nth (tally-die dice) %) 1))
       (map (fn [x] 0))
       (first)))

(defn small-straight [dice]
  (if (= nil (straight dice 0 5)) 15 0))

(defn large-straight [dice]
  (if (= nil (straight dice 1 6)) 20 0))

(defn full-house [dice]
  (+ (pair dice) (three-of-a-kind dice)))