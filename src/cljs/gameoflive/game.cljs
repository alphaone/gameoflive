(ns gameoflive.game)

(defn neighbors [board [x y]]
  (filter some? (for [cy (range (dec y) (+ y 2))
                      cx (range (dec x) (+ x 2))
                      :when (not= [x y] [cx cy])]
                  (-> board
                      (nth cy nil)
                      (nth cx nil)))))

(defn will-live? [neighbors current]
  (let [alive-neighbors (count (filter true? neighbors))]
    (cond
      (< 3 alive-neighbors) false
      (= 3 alive-neighbors) true
      (> 2 alive-neighbors) false
      :else current)))

(defn advance-cell [board [x y]]
  (will-live? (neighbors board [x y]) (-> board (nth y) (nth x))))

(defn advance-line [board y line]
  (vec (map-indexed #(advance-cell board [% y]) line)))

(defn advance-board [board]
  (vec (map-indexed (partial advance-line board) board)))