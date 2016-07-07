(ns gameoflive.handlers
  (:require [re-frame.core :as re-frame]
            [gameoflive.db :as db]
            [gameoflive.game :as game]))

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/register-handler
  :bigger
  (re-frame/path :board)
  (fn  [board _]
    (let [width (count (first board))]
      (conj (vec (map #(conj % false) board))
            (vec (repeat (inc width) false))))))

(re-frame/register-handler
  :toggle
  [(re-frame/path :board) re-frame/trim-v]
  (fn  [board [x y]]
    (update-in board [y x] not)))

(re-frame/register-handler
  :step
  (re-frame/path :board)
  (fn  [board _]
    (game/advance-board board)))

(re-frame/register-handler
  :play
  (re-frame/path :to)
  (fn  [old-to _]
    (js/clearInterval old-to)
    (js/setInterval #(re-frame/dispatch [:step]) 200)))

(re-frame/register-handler
  :stop
  (re-frame/path :to)
  (fn  [old-to _]
    (js/clearInterval old-to)))