(ns life
  (:use clojure.test))

(load "life")

(deftest any-live-cell-with-fewer-than-two-live-neighbors-dies--as-if-caused-by-underpopulation
  (is (= false 
    (should-live? true (repeat 8 false)) ))

  (is (= false 
    (should-live? true (conj [true] (repeat 7 false))) )) )
    
(deftest any-live-cell-with-two-or-three-live-neighbors-lives-on-to-the-next-generation
  (is (= true
    (should-live? true (conj [true true] (repeat 6 false))) ))

  (is (= true 
    (should-live? true (conj [true true true] (repeat 5 false))) )) )
    
(deftest any-live-cell-with-more-than-three-live-neighbours-dies--as-if-by-overcrowding
  (is (= false 
    (should-live? true (conj [true true true true] (repeat 4 false))) ))
    
  (is (= false 
    (should-live? true (conj [true true true true true] (repeat 3 false))) )) )
    
(deftest any-dead-cell-with-exactly-three-live-neighbours-becomes-a-live-cell--as-if-by-reproduction
  (is (= false
    (should-live? false (conj [true true] (repeat 6 false))) ))

  (is (= true
    (should-live? false (conj [true true true] (repeat 5 false))) ))
    
  (is (= false
    (should-live? false (conj [true true true true] (repeat 4 false))) )))
  
(run-tests 'life)
