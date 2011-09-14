(ns life
  (:use clojure.test))

(load "life")

(deftest cells-are-dead-by-default
  (let [grid (create-grid 3 5)]
    (is (= :dead
      (cell-at grid 0 0)))
    (is (= :dead
      (cell-at grid 1 2))) ))
    
(deftest beget-cells
  (let [grid (create-grid 3 5)]
    (let [changed-grid (beget-cell grid 1 2)]    
      (is (= :dead
        (cell-at changed-grid 0 0)))
      (is (= :alive
        (cell-at changed-grid 1 2))) )))
    
(run-tests 'life)
