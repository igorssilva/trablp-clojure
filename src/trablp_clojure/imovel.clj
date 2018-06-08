(ns trablp-clojure.imovel
    (:gen-class))

(def ^:const ARGILOSO "G")
(def ^:const ARENOSO "A")
(def ^:const ROCHOSO "R")

(defprotocol Imovel
    (area [this])
    (preco [this]))

(defn fator-lazer [lazer]
    (if lazer 1.15 1.0))


(defn fator-terreno [solo]
    (case solo
        "A" 0.9
        "G" 1.3
        "R" 1.1))


(defrecord Retangulo [nome id solo preco-mq lado1 lado2]
    Imovel
    (area [this] (* lado1 lado2))
    (preco [this] (* preco-mq (area this) (fator-terreno solo)))
    )

(defn newRetangular [nome id solo preco-mq lado1 lado2] 
    (Retangulo. nome (Integer/parseInt id) solo (Integer/parseInt preco-mq) (Float/parseFloat lado1) (Float/parseFloat lado2)))