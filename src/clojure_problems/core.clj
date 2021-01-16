(ns clojure-problems.core)






;;57
;;A recursive function is a function which calls itself. This is one of the fundamental techniques used in functional programming.
(def simple-recursion '(5 4 3 2 1))

;;71
;;The -> macro threads an expression x through a variable number of forms. First, x is inserted as the second item in the first form, making a list of it if it is not a list already. Then the first form is inserted as the second item in the second form, making a list of that form if necessary. This process continues for all the forms. Using -> can sometimes make your code more readable.
(def thread-first last)

;;68
;;Clojure only has one non-stack-consuming looping construct: recur. Either a function or a loop can be used as the recursion point. Either way, recur rebinds the bindings of the recursion point to the values it is passed. Recur must be called from the tail-position, and calling it elsewhere will result in an error.
(def recurring-theme [7 6 5 4 3])

;;72
;;The ->> macro threads an expression x through a variable number of forms. First, x is inserted as the last item in the first form, making a list of it if it is not a list already. Then the first form is inserted as the last item in the second form, making a list of that form if necessary. This process continues for all the forms. Using ->> can sometimes make your code more readable.
(defn thread-last [x] 
  (reduce + x))

;;19
;;Write a function which returns the last element in a sequence.
(defn last-element [xs]
  (nth xs (- (count xs) 1)))

;;134
;;Write a function which, given a key and map, returns true iff the map contains an entry with that key and its value is nil.
(defn nil-key? [k m]
  (let [ks (keys m)
        contains-k? (seq (filter (partial = k) ks))]
    (if (and contains-k? (not (k m)))
      true
      false)))
;;22
;;Write a function which returns the total number of elements in a sequence.
(defn number-of-elements [xs] 
  (if (empty? xs)
    0
    (+ 1 (number-of-elements (rest xs))
       )))
