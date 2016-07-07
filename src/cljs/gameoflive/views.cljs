(ns gameoflive.views
  (:require [re-frame.core :as re-frame]))

(defn cell [y x alive?]
  [:div {:key      [x y]
         :class    (str "cell " (if alive? "alive" "dead"))
         :on-click #(re-frame/dispatch [:toggle x y])}])

(defn line [y l]
  [:div {:key   y
         :class "line"}
   (map-indexed (partial cell y) l)])

(defn board []
  (let [b (re-frame/subscribe [:board])]
    (fn []
      [:div {:class "board"}
       (map-indexed line @b)])))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div
       [:div
        [:button {:on-click #(re-frame/dispatch [:bigger])} "+"]]

       [board]

       [:div
        [:button {:on-click #(re-frame/dispatch [:step])} "|>"]
        [:button {:on-click #(re-frame/dispatch [:play])} ">"]
        [:button {:on-click #(re-frame/dispatch [:stop])} "||"]]])))