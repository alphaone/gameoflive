(ns gameoflive.db)

(def initial-x 60)
(def initial-y 30)

(def default-db
  {:count 0
   :to    nil
   :board (->> (repeat initial-x false)
               vec
               (repeat initial-y)
               vec)})
