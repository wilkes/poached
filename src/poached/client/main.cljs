(ns poached.client.main
  (:require [jayq.core :refer [$] :as j]
            [dommy.template :refer [node]]))

(def jumbotron
  (node [:div.jumbotron
         [:div.container-fluid.hero-unit
          [:h1 "Poached"]
          [:p
           [:blockquote
            [:p.lead "Seriously, that's like eggs 101."]
            [:small "Archer"]]]]]))

(defn ^:export main []
  (-> ($ :#main)
      (j/append jumbotron)))
