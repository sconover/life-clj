(ns life
  (:use clojure.test))

(defn should-live? [cell, neighbors]
  (let [alive-neighbor-count (count (filter true? neighbors))]
    (cond
      (and (true? cell) (or (= alive-neighbor-count 2) (= alive-neighbor-count 3))) true
      (and (false? cell) (= alive-neighbor-count 3)) true
      :else false) ))
