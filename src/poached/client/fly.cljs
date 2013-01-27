(ns poached.client.fly
  (:require [jayq.core :refer [$] :as j]
            [dommy.template :refer [node]]
            [yolk.bacon :as b]
            [yolk.jquery :refer [mousemove]]))

(def mm (mousemove ($ js/document)))

(defn letter-span [letter]
  (node
   [:span {:style {:position "absolute"
                   :font-family "\"Lucida Console\", Monaco, monospace"}}
    letter]))

(defn bind-letter [$content letter i]
  (let [s ($ (letter-span letter))
        stream (b/delay mm (* i 50))]
    (j/append $content s)
    (-> stream
        (b/map #(+ (.-clientX %) (* i 10) 15))
        (b/on-value #(j/css s {:left (str % "px")})))
    (-> stream
        (b/map #(.-clientY %))
        (b/on-value #(j/css s {:top (str % "px")})))))

(defn initialize [$parent]
  (let [
        text "YOLK FLIES LIKE BACON"]
    (doseq [i (range 0 (count text))]
      (bind-letter $parent (get text i) i))))
