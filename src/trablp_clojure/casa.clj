(ns trablp-clojure.casa
    (:require [trablp-clojure.imovel :as imovel])
)

(defrecord Casa [id nome quartos vagas pavimentos area-pavimento preco-mq-construido area-livre preco-mq-livre] 
    imovel/Imovel
    (area [this] (* pavimentos area-pavimento))
    (preco [this] (+ (* preco-mq-construido area-pavimento pavimentos) (* preco-mq-livre area-livre)))    
)

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


(defn order-by-quartos [item, outro]
    "Ordena por quartos em ordem decrescente"
    (if (= (:quartos item) (:quartos outro))
        (> (imovel/get-id item) (imovel/get-id outro))
        (> (:quartos item) (:quartos outro)))
)


(defn is-casa-area-preco [area preco]
    "Retorna se é um terreno e se é argiloso"
    (fn [item] (and (instance? Casa item) (> (imovel/area item) area) (< (imovel/preco item) preco)))
)

(defn casas-area-preco [imoveis area preco p]
    "retorna um set contendo a lista de casas com area maior que a area passada "
    " e preco menor que o preco passado em ordem decrescente"
    "e o id do imovel na p-esima posição ou 0 caso não exista"        

    (def lista (vec (sort order-by-quartos (filter (is-casa-area-preco area preco) imoveis))));Filtra e ordena a lista de casas em ordem decrescente
        
    {
        :lista lista,
        :id (imovel/get-id-pos lista p) 
    }
)