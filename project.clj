(defproject poached "0.1.0-SNAPSHOT"
  :description "Eggs 101"
  :url "https://github.com/wilkes/poached"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.0-RC1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.2"]
                 [jayq "2.0.0"]
                 [prismatic/dommy "0.0.1"]
                 [ring/ring-jetty-adapter "1.1.8"]]
  :plugins [[lein-ring "0.8.2"]
            [lein-cljsbuild "0.3.0"]]
  :ring {:handler poached.server/app}
  :cljsbuild {:builds
              {:debug {:source-paths ["src/poached/client"]
                       :compiler {:output-to "resources/public/js/main-debug.js"
                                  :optimizations :whitespace
                                  :pretty-print true}}
               :main {:source-paths ["src/poached/client"]
                      :compiler {:output-to "resources/public/js/main.js"
                                 :externs ["externs/jquery-1.8.js"
                                           "externs/bootstrap.js"]
                                 :optimizations :advanced
                                 :pretty-print false}}}})
