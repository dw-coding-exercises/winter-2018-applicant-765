(ns my-exercise.turbovote
  (:require [org.httpkit.client :as http]
            [clojure.string :as st]))

(defn upcoming-elections
  "Query the elections api for the given divisions.
  divisions - a collection of OCD-ids
  returns - seq of maps containing election data"
  [divisions]
  (let [options {:query-params {:district-divisions (st/join "," divisions)}}
        request (http/get "https://api.turbovote.org/elections/upcoming" options)
        {:keys [body error]} @request]
    (clojure.edn/read-string body)))
