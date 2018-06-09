(ns trablp-clojure.retangulo
    (:require [trablp-clojure.imovel :as imovel])
    (:require [trablp-clojure.terreno :as terreno]))


(defrecord Retangulo [nome id solo preco-mq lado1 lado2]
    imovel/Imovel
    (imovel/area [this] (* lado1 lado2))
    (imovel/preco [this] (* preco-mq (imovel/area this) (terreno/fator-terreno solo)))
    )

(defn newRetangulo [nome id solo preco-mq lado1 lado2] 
    (Retangulo. nome (Integer/parseInt id) solo (Integer/parseInt preco-mq) (Float/parseFloat lado1) (Float/parseFloat lado2)))
