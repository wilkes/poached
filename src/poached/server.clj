(ns poached.server
  (:require [poached.pages :refer [layout]]
            [compojure.core :refer [defroutes GET]]
            [compojure.handler :refer [site]]
            [compojure.route :refer [resources]]
            [ring.util.response :refer [redirect]]))

(defroutes app-routes
  (GET "/" [] (redirect "/development"))
  (GET "/development" [] (layout :development))
  (GET "/production" [] (layout :production))
  (resources "/"))

(def app (site app-routes))
