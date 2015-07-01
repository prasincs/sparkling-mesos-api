(defproject sparkling-mesos-api "0.1.0-SNAPSHOT"
  :description "Example API using Spark, Clojure and Mesos"

  :url "http://example.com/FIXME"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.6.0"]
		 [org.apache.hadoop/hadoop-client "2.4.0"]
		 [org.apache.hadoop/hadoop-hdfs "2.4.0"]
                 ; You want the spark deps to be before sparkling
                 [org.apache.spark/spark-core_2.10 "1.3.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.clojure/tools.nrepl "0.2.10"]
                 [ring "1.3.2"]
                 [ring/ring-defaults "0.1.4"]
                 [cheshire "5.4.0"]
                 [gorillalabs/sparkling "1.2.1"]
                 [leiningen "2.5.1"]]

  :min-lein-version "2.5.1"

  :aot [clojure.tools.logging.impl  #".*" sparkling.function
        sparkling.core sparkling.serialization sparkling.destructuring]

  :main ^:skip-aot sparkling-mesos-api.main

  :target-path "target/%s"

  :repl-options {
                 ;; If nREPL takes too long to load it may timeout,
                 ;; increase this to wait longer before timing out.
                 ;; Defaults to 30000 (30 seconds)
                 ;; Spark steps take too long
                 :timeout 120000
                 }

  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[org.clojure/tools.namespace "0.2.7"]
                                  [spyscope "0.1.5"]]
                   :source-paths ["dev"]
                   :injections [(require 'spyscope.core)]}})
