(ns poached.client.main
  (:require [jayq.core :refer [$] :as j]
            [dommy.template :refer [node]]
            [yolk.bacon :as b]
            [yolk.jquery :as y]
            [poached.client.jumbotron :as jumbotron]
            [poached.client.fly :as fly]))

(def $main ($ :#main))
(def $demo-list ($ :#demo-list))

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

(defn ^:export main []
  (add-demo "jumbotron" "Jumbotron" jumbotron/initialze)
  (add-demo "fly" "Fly" fly/initialize)
  (jumbotron/initialze $main))
