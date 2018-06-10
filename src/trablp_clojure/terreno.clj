(ns trablp-clojure.terreno
    (:require [trablp-clojure.imovel :as imovel])
    (:gen-class))

(defprotocol Terreno
    "Protocolo para implementação de métodos os terreno"
    (get-solo [this] "retorna o tipo de solo do terreno")
)

(defn fator-terreno [solo]
    "Retorna o fator multiplicativo de preço do terreno"
    (case solo
        "A" 0.9
        "G" 1.3
        "R" 1.1))


(defn is-argiloso [terreno]
    "Retorna se é um terreno e se é argiloso"
    (and (satisfies? Terreno terreno) (= (get-solo terreno) "G"))
)

(defn order-by-area [item outro]
    "Funcao para ordenar em ordem decrescente de area com id como desempate"
    (def item-area (imovel/area item))
    (def outro-area (imovel/area outro))
    (if (= item-area outro-area)
        (> (imovel/get-id item) (imovel/get-id outro))
        (> item-area outro-area))
)

(defn menores-argilosos [imoveis perc_menores_arg p]    
    "retorna um set contendo a lista de menores imoveis argilosos em ordem decrescente"
    "e o id do imovel na p-esima posição ou 0 caso não exista"

    (def lista (vec (sort order-by-area (filter is-argiloso imoveis))));Filtra e ordena a lista de terrenos argilosos
    (def tam (count lista))

    ;retorna um subvetor baseado na porcentagem passada 
    (def start (- tam (int (* perc_menores_arg (double (/ tam 100))))))
    (def lista (subvec lista start))    

    {
        :lista lista,
        :id (imovel/get-id-pos lista p) 
    }
)
