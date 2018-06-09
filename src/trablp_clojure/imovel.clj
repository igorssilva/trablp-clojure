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