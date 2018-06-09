(ns trablp-clojure.triangulo
    (:require [trablp-clojure.imovel :as imovel])
    (:require [trablp-clojure.terreno :as terreno]))

(defrecord Triangulo [nome id solo preco-mq base altura]
    imovel/Imovel
    (imovel/area [this] (/ (* base altura) 2))
    (imovel/preco [this] (* preco-mq (imovel/area this) (terreno/fator-terreno solo)))
    )

(defn newTriangulo [nome id solo preco-mq base altura] 
    (Triangulo. nome (Integer/parseInt id) solo (Integer/parseInt preco-mq) (Float/parseFloat base) (Float/parseFloat altura)))