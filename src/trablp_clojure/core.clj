(ns trablp-clojure.core
  (:require [trablp-clojure.fileio :as io])
  (:require [trablp-clojure.imovel :as imovel])
  (:require [trablp-clojure.retangulo :as retangulo])
  (:require [trablp-clojure.triangulo :as triangulo])
  (:require [trablp-clojure.apartamento :as apartamento])
  (:require [trablp-clojure.terreno :as terreno])
  (:gen-class))



(defn -main  
    [& args]
    "Classe principal"
    (def imoveis (io/le-catalogo "resources/1/catalogo.txt"))
    (def imoveis (io/atualiza-catalogo "resources/1/atual.txt" imoveis))
    (def espec (io/le-espec "resources/1/espec.txt"))
    
)
