(ns {{name}}
  (:gen-class)
  (:require [{{name}}.sample :as sample]))

(defn lib
  "Entry point for Clojure library"
  [& args]
  (println (sample/hello "World")))

(defn -main
  "Entry point for server-side web application"
  [& args]
  (apply lib args))
