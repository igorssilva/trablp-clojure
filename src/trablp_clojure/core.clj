(ns trablp-clojure.core
  (:require [trablp-clojure.fileio :as io])
  (:require [trablp-clojure.imovel :as imovel])
  (:gen-class))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;(io/le_catalogo "resources/1/catalogo.txt")
  (def retang (imovel/newRetangular "Igor" "1" "A" "210" "2" "2"))
  (println (:solo retang )) 
  (println (imovel/preco retang )) 
)
