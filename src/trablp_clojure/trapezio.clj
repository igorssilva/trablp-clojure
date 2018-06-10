(ns trablp-clojure.trapezio
    (:require [trablp-clojure.imovel :as imovel])
    (:require [trablp-clojure.terreno :as terreno]))

(defrecord Trapezio [id nome solo preco-mq base1 base2 altura] 
    imovel/Imovel
    terreno/Terreno
    (area [this] (/ (* (+ base1 base2) altura) 2))
    (preco [this] (* preco-mq (imovel/area this) (terreno/fator-terreno solo)))
    (get-solo [this] (:solo this))
)

(defn new-trapezio [id nome solo preco-mq base1 base2 altura] "Inicializa um novo trapezio"
    (Trapezio. 
        (Integer/parseInt id) 
        nome 
        solo 
        (Integer/parseInt preco-mq) 
        (Float/parseFloat base1) 
        (Float/parseFloat base2) 
        (Float/parseFloat altura)
    )
)