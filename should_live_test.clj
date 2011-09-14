(ns life
  (:use clojure.test))

(load "life")

(deftest any-live-cell-with-fewer-than-two-live-neighbors-dies--as-if-caused-by-underpopulation
  (is (= :dead 
    (should-live? :alive (repeat 8 :dead)) ))

  (is (= :dead 
    (should-live? :alive (conj [:alive] (repeat 7 :dead))) )) )
    
(deftest any-live-cell-with-two-or-three-live-neighbors-lives-on-to-the-next-generation
  (is (= :alive
    (should-live? :alive (conj [:alive :alive] (repeat 6 :dead))) ))

  (is (= :alive 
    (should-live? :alive (conj [:alive :alive :alive] (repeat 5 :dead))) )) )
    
(deftest any-live-cell-with-more-than-three-live-neighbours-dies--as-if-by-overcrowding
  (is (= :dead 
    (should-live? :alive (conj [:alive :alive :alive :alive] (repeat 4 :dead))) ))
    
  (is (= :dead 
    (should-live? :alive (conj [:alive :alive :alive :alive :alive] (repeat 3 :dead))) )) )
    
(deftest any-dead-cell-with-exactly-three-live-neighbours-becomes-a-live-cell--as-if-by-reproduction
  (is (= :dead
    (should-live? :dead (conj [:alive :alive] (repeat 6 :dead))) ))

  (is (= :alive
    (should-live? :dead (conj [:alive :alive :alive] (repeat 5 :dead))) ))
    
  (is (= :dead
    (should-live? :dead (conj [:alive :alive :alive :alive] (repeat 4 :dead))) )))
  
(run-tests 'life)
