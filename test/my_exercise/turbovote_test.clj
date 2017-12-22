(ns my-exercise.turbovote-test
  (:require  [clojure.test :refer :all]
             [org.httpkit.fake :refer (with-fake-http)]
             [my-exercise.turbovote :as turbovote]
             [fixtures.turbovote :as fixture]))

(deftest upcoming-elections-test
  (testing "happy path - response with EDN data"
    (with-fake-http [#"https://api.turbovote.org/elections/upcoming" fixture/oregon]
      (is (= 1 (count (turbovote/upcoming-elections []))))))

  (testing "expected query parameters"
    (with-fake-http [{:query-params {:district-divisions "ocd-division/country:us/state:or,ocd-division/country:us/state:or/place:portland"}
                      :url "https://api.turbovote.org/elections/upcoming"}
                     fixture/oregon]
      (is (= 1 (count (turbovote/upcoming-elections ["ocd-division/country:us/state:or" "ocd-division/country:us/state:or/place:portland"]))))))

  (testing "error response"
    ;; TODO
    ))
