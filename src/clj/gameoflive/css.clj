(ns gameoflive.css
  (:require [garden.def :refer [defstyles]]))

(def cell-size 30)

(defstyles screen
           [:* {:padding 0
                :margin  0}]
           [:body {:color "gray"}]
           [:div.line {:height (str (+ cell-size 4) "px")}]
           [:div.cell {:display          "inline-block"
                       :background-color "blue"
                       :width            (str cell-size "px")
                       :height           (str cell-size "px")
                       :margin           "0 1px"
                       :border           "1px solid #ddd"
                       :border-radius    "10px"}
            [:&.dead {:background-color "#eee"}]]
           [:button {:margin  "5px"
                     :padding "4px 20px"}]
           )

