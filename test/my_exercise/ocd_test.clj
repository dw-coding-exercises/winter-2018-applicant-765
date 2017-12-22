(ns my-exercise.ocd-test
  (:require [my-exercise.ocd :as ocd]
            [clojure.test :refer :all]))

(deftest ocd-all-ids-test
  (testing "basic example"
    (is (= ["ocd-division/country:us"
            "ocd-division/country:us/state:al"
            "ocd-division/country:us/state:al/county:jefferson"
            "ocd-division/country:us/state:al/place:birmingham"]
           (ocd/all-ids {:country "us" :state "al" :county "jefferson" :place "birmingham"})))))
