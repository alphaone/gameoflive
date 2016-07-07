(ns gameoflive.game-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [gameoflive.game :as game]))

(def d false)
(def a true)

(def empty-board [[d d d]
                  [d d d]
                  [d d d]])

(deftest advance-test
  (testing "it advances the board by a single step"
    (is (= empty-board
           (game/advance-board empty-board)))
    (is (= [[d d d d]
            [d a a d]
            [d a a d]
            [d d d d]]
           (game/advance-board [[d d d d]
                          [d a a d]
                          [d a a d]
                          [d d d d]])))
    (is (= [[d d d d]
            [a a a d]
            [d d d d]
            [d d d d]]
           (game/advance-board [[d a d d]
                          [d a d d]
                          [d a d d]
                          [d d d d]])))))

(deftest neighbors-test
  (testing "it finds neighbors of a cell"
    (let [board [[0 0 0 0 0]
                 [0 1 2 3 0]
                 [0 4 5 6 0]
                 [0 7 8 9 0]
                 [0 0 0 0 0]]]
      (is (= [1 2 3 4 6 7 8 9]
             (game/neighbors board [2 2])))
      (is (= [0 0 1]
             (game/neighbors board [0 0])))
      (is (= [9 0 0]
             (game/neighbors board [4 4])))
      (is (= [7 8 9 0 0]
             (game/neighbors board [2 4]))))))

(deftest dead-or-alive-test
  (testing "it determines the next state of a cell"
    (testing "under population"
      (is (= d
             (game/will-live? [d d d
                                   d d
                                   d d a] a))))
    (testing "over crowded"
      (is (= d
             (game/will-live? [a d a
                                   d d
                                   a d a] a))))
    (testing "survival"
      (is (= a
             (game/will-live? [a d d
                                   d d
                                   d d a] a)))
      (is (= a
             (game/will-live? [a d a
                                   d d
                                   d d a] a))))
    (testing "reproduction"
      (is (= a
             (game/will-live? [d d d
                                   d d
                                   a a a] d))))))