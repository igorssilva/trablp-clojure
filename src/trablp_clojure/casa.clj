(ns trablp-clojure.casa
    (:require [trablp-clojure.imovel :as imovel])
)

(defrecord Casa [id nome quartos vagas pavimentos area-pavimento preco-mq-construido area-livre preco-mq-livre] 
    imovel/Imovel
    (area [this] (* pavimentos area-pavimento))
    (preco [this] (+ (* preco-mq-construido area-pavimento pavimentos) (* preco-mq-livre area-livre))))

(defn new-casa [id nome quartos vagas pavimentos area-pavimento preco-mq-construido area-livre preco-mq-livre] 
    "Inicializa uma Casa"
    (Casa.
        (Integer/parseInt id) 
        nome
        (Integer/parseInt quartos)
        (Integer/parseInt vagas)
        (Integer/parseInt pavimentos)
        (Float/parseFloat area-pavimento)
        (Integer/parseInt preco-mq-construido)
        (Float/parseFloat area-livre)
        (Integer/parseInt preco-mq-livre)
    )
)