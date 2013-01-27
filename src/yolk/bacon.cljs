(ns yolk.bacon
  (:refer-clojure :exclude [map]))

(defn on-value [es f]
  (.onValue es f))

(defn map [es f]
  (.map es f))

(defn delay [es ms]
  (.delay es ms))