(ns trablp-clojure.triangulo
    (:require [trablp-clojure.imovel :as imovel])
    (:require [trablp-clojure.terreno :as terreno]))

(defrecord Triangulo [id nome solo preco-mq base altura] 
    imovel/Imovel
    (imovel/area [this] (/ (* base altura) 2))
    (imovel/preco [this] (* preco-mq (imovel/area this) (terreno/fator-terreno solo)))
    )

(defn new-triangulo [id nome solo preco-mq base altura] "Inicializa um novo Triangulo"
    (Triangulo. 
        (Integer/parseInt id)
        nome 
        solo
        (Integer/parseInt preco-mq)
        (Float/parseFloat base)
        (Float/parseFloat altura)
    )
)