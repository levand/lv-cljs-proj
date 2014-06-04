(ns {{name}}-test
    (:require [clojure.test :refer :all]
              [clojure.test.check.properties :as prop]
              [clojure.test.check.generators :as gen]
              [clojure.test.check.clojure-test :refer [defspec]]
              [{{name}}.test-helper :as helper]
              [{{name}} :as app]))

(deftest tests-work
  (is (nil? (app/lib "World"))))

(defspec property-tests-work
  (helper/scale 100)
  (prop/for-all [s gen/string-ascii]
    (= (* 2 (.length s)) (.length (str s s)))))
