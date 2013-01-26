(ns poached.pages
  (:require [hiccup.page :refer [html5
                                 include-css
                                 include-js]]
            [hiccup.element :refer [javascript-tag]]
            [hiccup.def :refer [defhtml]]))

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
    (include-css "/css/bootstrap.css"
                 "/css/bootstrap-responsive.css")]
   [:body {:style "padding-top: 60px;"}
    [:div.navbar.navbar-inverse.navbar-fixed-top
     [:div.navbar-inner
      [:div.container-fluid
       [:a.brand {:href "#"} "Poached"]]]]
    [:div.container-fluid
     [:div.jumbotron
      [:div.container.hero-unit
       [:h1 "Poached"]
       [:p
        [:blockquote
         [:p.lead "Seriously, that's like eggs 101."]
         [:small "Archer"]]]]]]]))
