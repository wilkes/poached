(ns poached.server
  (:require [poached.pages :refer [layout]]
            [compojure.core :refer [defroutes GET]]
            [compojure.handler :refer [site]]
            [compojure.route :refer [resources]]
            [ring.util.response :refer [redirect]]
            [ring.adapter.jetty :refer [run-jetty]]))

(defroutes app-routes
  (GET "/" [] (redirect "/development"))
  (GET "/development" [] (layout :development))
  (GET "/production" [] (layout :production))
  (resources "/"))

(def app (site app-routes))

(defn -main [port]
  (run-jetty (var app) {:port (Integer. port)}))
