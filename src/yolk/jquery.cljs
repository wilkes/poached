(ns yolk.jquery)

(defn ->stream [$elem event]
  (.asEventStream $elem event))

(defn mousemove [$elem]
  (.asEventStream $elem "mousemove"))