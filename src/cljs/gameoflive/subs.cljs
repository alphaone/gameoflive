(ns gameoflive.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/register-sub
  :name
  (fn [db]
    (reaction (:name @db))))

(re-frame/register-sub
  :counter
  (fn [db]
    (reaction (:count @db))))

(re-frame/register-sub
 :board
 (fn [db]
   (reaction (:board @db))))
