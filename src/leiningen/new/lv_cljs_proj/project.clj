(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "describe me"
  :url "url me"
  :license {:name "license me"
            :url ""}
  :plugins [[com.keminglabs/cljx "0.4.0"]
            [lein-cljsbuild "1.0.3"]]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2227"]]
  :hooks [cljx.hooks leiningen.cljsbuild]
  :resource-paths []
  :source-paths ["src/clj"
                 "src/cljs"
                 "target/cljx/clj"
                 "target/cljx/cljs"]
  :test-paths ["test/clj"
               "test/cljs"
               "target/cljx-test/clj"
               "target/cljx-test/cljs"]
  :main {{name}}
  :cljx {:builds [{:source-paths ["src/cljx"]
                   :output-path "target/cljx/clj"
                   :rules :clj}
                  {:source-paths ["src/cljx"]
                   :output-path "target/cljx/cljs"
                   :rules :cljs}
                  {:source-paths ["test/cljx"]
                   :output-path "target/cljx-test/clj"
                   :rules :clj}
                  {:source-paths ["test/cljx"]
                   :output-path "target/cljx-test/cljs"
                   :rules :cljs}]}
  :cljsbuild    {:builds {:dev {:source-paths  ["src/cljs" "target/cljx/cljs"]
                                :compiler      {:output-to "resources/public/dev/gen/deps.js"
                                                :output-dir "resources/public/dev/gen/"
                                                :optimizations :none
                                                :source-map true
                                                :pretty-print true}}
                          :prod {:source-paths  ["src/cljs" "target/cljx/cljs"]
                                 :compiler      {:output-to "resources/public/gen/{{name}}.js"
                                                 :optimizations :advanced
                                                 :pretty-print false}}}}
  :profiles
  {:dev {:plugins      [[com.cemerick/clojurescript.test "0.3.1"]]
         :dependencies [[com.cemerick/double-check "0.5.7"]]
         :jvm-opts     ["-Dclojure.test.check.scale=10.5"]
         :cljsbuild    {:builds {:test-whitespace {:source-paths  ["test/cljs" "target/cljx-test/cljs"]
                                                   :compiler      {:output-to "target/cljsbuild/whitespace/{{name}}.js"
                                                                   :optimizations :whitespace
                                                                   :pretty-print true}}
                                 :test-advanced {:source-paths ["test/cljs" "target/cljx-test/cljs"]
                                                 :compiler     {:output-to     "target/cljsbuild/advanced/{{name}}.js"
                                                                :pretty-print  false
                                                                :optimizations :advanced}}}
                        :test-commands {"test-whitespace" ["phantomjs" :runner
                                                           "this['clojure.test.check.scale']=10.5"
                                                           "target/cljsbuild/whitespace/{{name}}.js"]
                                        "test-advanced" ["phantomjs" :runner
                                                         "this['clojure.test.check.scale']=100"
                                                         "target/cljsbuild/advanced/{{name}}.js"]}}}})