(ns gameoflive.css
  (:require [garden.def :refer [defstyles]]))

(def cell-size 15)

(defstyles screen
           [:* {:padding 0
                :margin  0}]
           [:body {:color "#8e44ad"}]
           [:div.line {:height (str (+ cell-size 4) "px")}]
           [:div.cell {:display "inline-block"
                       :width   (str cell-size "px")
                       :height  (str cell-size "px")
                       :margin  "0 1px"}
            [:div
             [:&.alive {:background-color "#3498db"
                        :width            "100%"
                        :height           "100%"
                        :border           "1px solid #2980b9"
                        :border-radius    (str (quot cell-size 3) "px")}]
             [:&.dead {:border           "1px solid #eee"
                       :height           "50%"
                       :width            "50%"
                       :margin           "25%"
                       :transition       "all 0.25s cubic-bezier(.87,-.41,.19,1.44)" ;
                       :background-color "#f0f0f0"}]]]
           [:button {:margin  "5px"
                     :padding "4px 20px"}]
           )

