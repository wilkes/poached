(defproject poached "0.1.0-SNAPSHOT"
  :description "Eggs 101"
  :url "https://github.com/wilkes/poached"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.0-RC1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.2"]]
  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler poached.server/app})
