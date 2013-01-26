(ns poached.pages
  (:require [hiccup.page :refer [html5
                                 include-css
                                 include-js]]
            [hiccup.element :refer [javascript-tag]]
            [hiccup.def :refer [defhtml]]))

(defn dev? [mode]
  (= :development mode))

(defhtml app-js [js-file]
  (javascript-tag "var CLOSURE_NO_DEPS = true;")
  (include-js (str "js/" js-file ".js"))
  (javascript-tag "poached.client.main.main();"))

(defhtml layout [mode]
  (html5
   [:head
    [:title "Poached: Eggs 101"]
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "Content-Type" :content "text/html; charset=UTF-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=7;IE=8;IE=edge"}]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
    "<!--[if lt IE 9]>
        <script src=\"http://html5shiv.googlecode.com/svn/trunk/html5.js\"></script>
     <![endif]-->"
    (javascript-tag "if (typeof console === \"undefined\") {
        console = {}; // define it if it doesn't exist already
        console.log = function() {};
        console.dir = function() {};}")
    (include-css "/css/bootstrap.min.css"
                 "/css/bootstrap-responsive.min.css")]
   [:body {:style "padding-top: 60px;"}
    [:div.navbar.navbar-inverse.navbar-fixed-top
     [:div.navbar-inner
      [:div.container-fluid
       [:a.brand {:href "/"} "Poached"]
       (if (dev? mode)
         [:ul.nav.pull-right
          [:li.divider]
          [:li.active [:a {:href "/development"} "Development"]]
          [:li [:a {:href "/production"} "Production"]]])]]]
    [:div#main.container-fluid]
    (include-js "/js/jquery-1.8.1.min.js")
    (include-js "/js/bootstrap.min.js")
    (app-js (str "main" (if (dev? mode) "-debug" "")))]))
