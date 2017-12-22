(ns my-exercise.search
  (:require [hiccup.page :refer [html5]]))

(defn search
  "Handler for election search. Expects address params"
  [{:keys [params] :as request}]
  (html5
   [:body
    [:section.summary "No results found"]
    [:section.results (pr-str params)]]))
