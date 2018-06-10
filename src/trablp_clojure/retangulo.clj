(ns trablp-clojure.retangulo
    (:require [trablp-clojure.imovel :as imovel])
    (:require [trablp-clojure.terreno :as terreno])
    (:gen-class))


(defrecord Retangulo [id nome solo preco-mq lado1 lado2] 
    imovel/Imovel
    terreno/Terreno
    (area [this] (* lado1 lado2))
    (preco [this] (* preco-mq (imovel/area this) (terreno/fator-terreno solo)))
    (get-solo [this] (:solo this))
)

(defn new-retangulo [id nome solo preco-mq lado1 lado2] "Inicializa um retangulo"
    (Retangulo. 
        (Integer/parseInt id) 
        nome 
        solo 
        (Integer/parseInt preco-mq) 
        (Float/parseFloat lado1)
        (Float/parseFloat lado2)
    )
)
