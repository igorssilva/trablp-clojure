(ns trablp-clojure.core
  (:require [trablp-clojure.fileio :as io])
  (:require [trablp-clojure.imovel :as imovel])
  (:require [trablp-clojure.retangulo :as retangulo])
  (:require [trablp-clojure.triangulo :as triangulo])
  (:gen-class))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;(io/le_catalogo "resources/1/catalogo.txt")
  (def retang (retangulo/newRetangulo "Igor" "1" "A" "210" "2" "2"))
  (println (instance? trablp_clojure.retangulo.Retangulo retang )) 
  (println (imovel/preco retang )) 
  (def triang (triangulo/newTriangulo "Igor" "1" "A" "210" "2" "2"))
  (println (instance? trablp_clojure.triangulo.Triangulo triang )) 
  (println (imovel/preco triang )) 
)
