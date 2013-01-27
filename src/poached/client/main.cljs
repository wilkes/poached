(ns poached.client.main
  (:require [jayq.core :refer [$] :as j]
            [dommy.template :refer [node]]
            [yolk.bacon :as b]
            [yolk.jquery :as y]
            [poached.client.fly :as fly]))

(def $main ($ :#main))
(def $demo-list ($ :#demo-list))

(def jumbotron
  (node [:div.jumbotron
         [:div.container-fluid.hero-unit
          [:h1 "Poached"]
          [:p
           [:blockquote
            [:p.lead "Seriously, that's like eggs 101, Woodhouse."]
            [:small "Archer"]]]]]))

(defn demo-link [id label]
  (node [:li {:id id}
         [:a {:href "#"} label]]))

(defn add-demo [id label display-fn]
  (let [$link ($ (demo-link id label))]
    (j/append $demo-list $link)
    (-> (y/click ($ "a" $link))
        (b/on-value (fn [_]
                      (j/empty $main)
                      (display-fn $main))))))

(defn initialze [$parent]
  (j/append $parent jumbotron))

(defn ^:export main []
  (add-demo "home" "Home" initialze)
  (add-demo "fly" "Fly" fly/initialize)
  (initialze $main))
