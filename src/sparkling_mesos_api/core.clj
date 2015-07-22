(ns sparkling-mesos-api.core
  (:require [clojure.string :as string]
            [sparkling.conf :as conf]
            [sparkling.core :as spark]
            [sparkling.destructuring :as s-de]
            [sparkling.deserialization])
  (:import [org.apache.spark SparkConf])
  (:gen-class))


(defn make-spark-context []
  (let [sconfig (config/spark)
        c (->
           (SparkConf.)
           (conf/master (:master sconfig))
           (conf/app-name (:app-name sconfig))
           (conf/set "spark.executor.uri" (:executor-uri sconfig))
           (conf/set "spark.ui.port" (:webui-port sconfig))
           (conf/set "spark.home" (:home sconfig)))]
    (spark/spark-context c)))
