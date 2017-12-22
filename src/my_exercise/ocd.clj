(ns my-exercise.ocd
  (:require [clojure.string :as st]))

(def present?
  "Return true if input not nil and not empty string"
  (complement st/blank?))

(defn id
  "Return the longest possible OCD identifier given the input map"
  [{:keys [country county state place]}]
  (cond-> "ocd-division"
    (present? country) (str "/country:" country)
    (present? state) (str "/state:" state)
    (present? county) (str "/county:" county)
    (present? place) (str "/place:" place)))

(defn all-ids
  "Return a collection of all OCD identifier strings that can be generated from the input.
  TODO: normalize address info (e.g. zip => county, city => place)"
  [address]
  [(id (select-keys address [:country]))
   (id (select-keys address [:country :state]))
   (id (select-keys address [:country :state :county]))
   (id (select-keys address [:country :state :place]))])
