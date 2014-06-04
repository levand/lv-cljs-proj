(ns {{name}}.test-helper)

#+cljs (def ^:dynamic *testcheck-scale*
         (or (this-as this (aget this "clojure.test.check.scale")) 1.0))

#+clj (def ^:dynamic *testcheck-scale*
        (or (if-let [scale (System/getProperty "clojure.test.check.scale")]
              (Double/parseDouble scale))
            1.0))

(defn scale
  "Scale a test check count"
  [n]
  (int (* n *testcheck-scale*)))