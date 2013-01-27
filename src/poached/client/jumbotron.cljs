(ns poached.client.jumbotron
  (:require [jayq.core :refer [$] :as j]
            [dommy.template :refer [node]]
            [yolk.bacon :as b]
            [yolk.jquery :as y]
            [poached.client.fly :as fly]))

(def jumbotron
  (node [:div.jumbotron
         [:div.container-fluid.hero-unit
          [:h1 "Poached"]
          [:p
           [:blockquote
            [:p.lead "Seriously, that's like eggs 101, Woodhouse."]
            [:small "Archer"]]]]]))

(defn initialze [$parent]
  (j/append $parent jumbotron))
