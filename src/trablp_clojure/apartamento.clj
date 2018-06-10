(ns trablp-clojure.apartamento
    (:require [trablp-clojure.imovel :as imovel])
)

(defn fator-lazer [lazer] "Retorna o multiplicador de lazer do apartamento"
    (if lazer 1.15 1.0))

(defrecord Apartamento [id nome quartos vagas andar area-construida preco-mq lazer andares]
    imovel/Imovel
    (area [this] area-construida)
    (preco [this] (* preco-mq area-construida (fator-lazer lazer) (+ 0.9 (/ andar andares))))
)

(defn new-apartamento [id nome quartos vagas andar area-construida preco-mq lazer andares] "Inicializa um novo apartamento"
    (Apartamento.  
        (Integer/parseInt id) 
        nome 
        (Integer/parseInt quartos) 
        (Integer/parseInt vagas)
        (Integer/parseInt andar) 
        (Float/parseFloat area-construida) 
        (Integer/parseInt preco-mq)
        (= lazer "S")
        (Integer/parseInt andares)
    )
)
