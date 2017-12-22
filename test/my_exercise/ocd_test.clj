(ns my-exercise.ocd-test
  (:require [my-exercise.ocd :as ocd]
            [clojure.test :refer :all]))

(deftest ocd-all-ids-test
  (testing "basic example"
    (is (= ["ocd-division/country:us"
            "ocd-division/country:us/state:al"
            "ocd-division/country:us/state:al/county:jefferson"
            "ocd-division/country:us/state:al/place:birmingham"]
           (ocd/all-ids {:country "us" :state "al" :county "jefferson" :place "birmingham"}))))
  (testing "sparse example"
    (is (= ["ocd-division/country:us"
            "ocd-division/country:us/state:al"
            "ocd-division/country:us/state:al/place:birmingham"]
           (ocd/all-ids {:country "us" :state "al" :place "birmingham"}))))
  (testing "formatting example"
    (is (= ["ocd-division/country:us"
            "ocd-division/country:us/state:al"
            "ocd-division/country:us/state:al/place:pleasant_hill"]
           (ocd/all-ids {:country "US" :state "AL" :place " Pleasant Hill "}))))
  (testing "default to US"
    (is (= ["ocd-division/country:us"
            "ocd-division/country:us/state:al"]
           (ocd/all-ids {:state "AL"}))))
  )
