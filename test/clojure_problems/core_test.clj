(ns clojure-problems.core-test
  (:require [clojure.test :refer :all]
            [clojure-problems.core :refer :all]))

(deftest simple-recursion-test
  (is (= simple-recursion 
         ((fn foo [x] 
             (when (> x 0) 
               (conj (foo (dec x)) x))) 5 ))))

(deftest thread-first-test
  (is (= 5 (thread-first (sort (rest (reverse [2 5 4 1 3 6]))))))
  (is (= 5 (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (thread-first)))))

(deftest recurring-theme-test
  (is (= recurring-theme (loop [x 5
                                result []]
                           (if (> x 0)
                             (recur (dec x) (conj result (+ 2 x)))
                             result)))))

(deftest thread-last-test
  (is (= 11 (thread-last (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))))
  (is (= 11 (thread-last (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc))))))

(deftest last-element-test
  (is (= 5 (last-element [1 2 3 4 5])))
  (is (= 3 (last-element '(5 4 3))))
  (is (= "d" (last-element ["b" "c" "d"]))))

(deftest nil-key-test
  (is (true?  (nil-key? :a {:a nil :b 2})))
  (is (false?  (nil-key? :b {:a nil :b 2})))
  (is (false?  (nil-key? :c {:a nil :b 2}))))

(deftest number-of-elements-test
  (is (= 5 (number-of-elements '(1 2 3 3 1))))
  (is (= 11 (number-of-elements "Hello World")))
  (is (= 3 (number-of-elements [[1 2] [3 4] [5 6]])))
  (is (= 1 (number-of-elements '(13))))
  (is (= 3 (number-of-elements '(:a :b :c)))))



