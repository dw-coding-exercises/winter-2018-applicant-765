(ns my-exercise.ocd
  (:require [clojure.string :as st]))

(def present?
  "Return true if input not nil and not empty string"
  (complement st/blank?))

(defn format
  "strip leading/trailing spaces, downcase, and underscore words
  TODO: might be able to consolidate leading/trailing string replace"
  [s]
  (-> s
      (st/replace #"^\s+" "")
      (st/replace #"\s+$" "")
      (st/replace #"\s+" "_")
      st/lower-case))

(defn id
  "Return the longest possible OCD identifier given the input map"
  [{:keys [country county state place] :or {country "us"}}]
  (cond-> "ocd-division"
    (present? country) (str "/country:" (format country))
    (present? state) (str "/state:" (format state))
    (present? county) (str "/county:" (format county))
    (present? place) (str "/place:" (format place))))

(defn all-ids
  "Return a collection of all OCD identifier strings that can be generated from the input.
  TODO: normalize address info (e.g. zip => county, city => place)"
  [address]
  (distinct [(id (select-keys address [:country]))
             (id (select-keys address [:country :state]))
             (id (select-keys address [:country :state :county]))
             (id (select-keys address [:country :state :place]))]))
