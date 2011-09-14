(ns life
  (:use clojure.test))

(defn should-live? [cell, neighbors]
  (let [alive-neighbor-count (count (filter #(= % :alive) neighbors))]
    (cond
      (and (= cell :alive) (or (= alive-neighbor-count 2) (= alive-neighbor-count 3))) :alive
      (and (= cell :dead) (= alive-neighbor-count 3)) :alive
      :else :dead) ))

(defn create-grid [n, m]
  (vec (repeat m (vec (repeat n :dead))) ))

(defn beget-cell [grid, x, y]
  (assoc-in grid [y x] :alive) )

(defn kill-cell [grid, x, y]
  (assoc-in grid [y x] :dead) )

(defn cell-at [grid, x, y]
  (get (get grid y) x) )
