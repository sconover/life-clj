(ns steve
  (:use clojure.test))

(defn lives? [cell, neighbors]
  (let [alive-neighbor-count (count (filter true? neighbors))]
    (cond
      (and (true? cell) (or (= alive-neighbor-count 2) (= alive-neighbor-count 3))) true
      (and (false? cell) (= alive-neighbor-count 3)) true
      :else false) ))

(deftest any-live-cell-with-fewer-than-two-live-neighbors-dies--as-if-caused-by-underpopulation
  (is (= false 
    (lives? true (repeat 8 false)) ))

  (is (= false 
    (lives? true (conj [true] (repeat 7 false))) )) )
    
(deftest any-live-cell-with-two-or-three-live-neighbors-lives-on-to-the-next-generation
  (is (= true
    (lives? true (conj [true true] (repeat 6 false))) ))

  (is (= true 
    (lives? true (conj [true true true] (repeat 5 false))) )) )
    
(deftest any-live-cell-with-more-than-three-live-neighbours-dies--as-if-by-overcrowding
  (is (= false 
    (lives? true (conj [true true true true] (repeat 4 false))) ))
    
  (is (= false 
    (lives? true (conj [true true true true true] (repeat 3 false))) )) )
    
(deftest any-dead-cell-with-exactly-three-live-neighbours-becomes-a-live-cell--as-if-by-reproduction
  (is (= false
    (lives? false (conj [true true] (repeat 6 false))) ))

  (is (= true
    (lives? false (conj [true true true] (repeat 5 false))) ))
    
  (is (= false
    (lives? false (conj [true true true true] (repeat 4 false))) )))
    

; (defn world []
;   "world")  
; 
; (deftest test-defn
;   (is (= "worldz" world)))

;(count (filter true? (take-while not(overcrowded?) (take 8 neighbors))))
;(reductions (fn [a b] (if b (+ a 1) a)) (cons 0 [true false true false true true])  )
  
(run-tests 'steve)


