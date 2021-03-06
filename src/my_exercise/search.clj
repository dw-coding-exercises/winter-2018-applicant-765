(ns my-exercise.search
  (:require [hiccup.page :refer [html5]]
            [my-exercise.ocd :as ocd]
            [my-exercise.turbovote :as turbovote]
            [clj-time.format :as f]
            [clj-time.coerce :as coerce]))

(defn header
  "TODO: move me to shared ns and update home.clj"
  [title]
  [:head
   [:meta {:charset "UTF-8"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1.0, maximum-scale=1.0"}]
   [:title title]
   [:link {:rel "stylesheet" :href "default.css"}]])

(defn extract-address
  "Perform translation between form and what OCD expects"
  [params]
  (assoc params :place (:city params)))

(def date-display-format
  (f/formatter "M/d/yyyy"))

(defn format-date
  "US date format"
  [d]
  (f/unparse date-display-format
             (coerce/from-date d)))

(defn render-election
  [election]
  [:div.election
   [:span.date (format-date (:date election))]
   [:span.description (:description election)]])

(defn render-response
  [elections]
  (html5
   (header "Upcoming Elections")
   [:body
    [:section#summary (str (count elections) " results found")]
    [:section#results (map render-election elections)]]))

(defn search
  "Handler for election search. Expects address params"
  [{:keys [params] :as request}]
  (-> params
      extract-address
      ocd/all-ids
      turbovote/upcoming-elections
      render-response))
