(ns gameoflive.db)

(def a true)
(def d false)

(def default-db
  {:name  "re-frame"
   :to    nil
   :board (vec (repeat 10 (vec (repeat 10 false))))})
