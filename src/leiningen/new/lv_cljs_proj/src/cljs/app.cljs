(ns {{name}}
  (:require [{{name}}.sample :as sample]))

(defn ^:export lib
  "Entry point for ClojureScript lib"
  [name]
  (.log js/console (sample/hello name)))

(defn ^:export main
  "Entry point for ClojureScript application"
  []
  (lib "world"))