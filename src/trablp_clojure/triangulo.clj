(ns trablp-clojure.triangulo
    (:require [trablp-clojure.imovel :as imovel])
    (:require [trablp-clojure.terreno :as terreno]))

;classe do terreno triangular
(defrecord Triangulo 
    [id nome solo preco-mq base altura] 
    imovel/Imovel
    terreno/Terreno
    (area [this] (/ (* base altura) 2))
    (preco [this] (* preco-mq (imovel/area this) (terreno/fator-terreno solo)))
    (get-solo [this] (:solo this))
    )

(defn new-triangulo
    [id nome solo preco-mq base altura]
    "Inicializa um novo Triangulo"
    (Triangulo. 
        (Integer/parseInt id)
        nome 
        solo
        (Integer/parseInt preco-mq)
        (Float/parseFloat base)
        (Float/parseFloat altura)
    )
)