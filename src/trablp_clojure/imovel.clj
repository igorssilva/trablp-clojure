(ns trablp-clojure.imovel
    (:gen-class))

(defprotocol Imovel
    "Protocolo para implementação de métodos os imoveis"
    (area [this] "Retorna a área do imovel")
    (preco [this] "Retorna o preço do imovel"))

