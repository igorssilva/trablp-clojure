(ns trablp-clojure.terreno
    (:gen-class))


(defn fator-terreno [solo]
    "Retorna o fator multiplicativo de preço do terreno"
    (case solo
        "A" 0.9
        "G" 1.3
        "R" 1.1))


(defn is-argiloso [imovel]
    (and (contains? imovel :solo) (= (:solo imovel) "G"))
)


