(ns user
  "Tools for interactive development with the REPL.
  This file should not be included in a production build of the application."
  (:require [clojure.java.io :as io]
            [leiningen.core.project :as p]))

(defn load-project
  []
  (p/read (str (io/file (System/getProperty "user.dir") "./project.clj"))))

(defn compile-uberjar
  []
  (let [project (load-project)]
    (try (uberjar project 'sparkling-mesos-api.main)
         (catch Exception e
           (.printStackTrace e)))))
