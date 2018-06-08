(ns trablp-clojure.core
  (:require [trablp-clojure.fileio :as io])
  (:gen-class))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (io/le_catalogo "test.txt")
)
