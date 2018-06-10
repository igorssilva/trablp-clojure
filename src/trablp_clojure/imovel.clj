(ns trablp-clojure.imovel
    (:gen-class))
(use '[clojure.string :only (join)])

(defprotocol Imovel
    "Protocolo para implementação de métodos os imoveis"
    (area [this] "Retorna a área do imovel")
    (preco [this] "Retorna o preço do imovel")
)

(defn get-id [item]
    (:id item)
)

(defn order-by-preco [item outro]
    "Funcao para ordenar em ordem crescente de preco com id como desempate"
    (def item-preco (preco item))
    (def outro-preco (preco outro))
    (if (= item-preco outro-preco)
        (< (get-id item) (get-id outro))
        (< item-preco outro-preco)))

(defn get-id-pos [imoveis pos]
    "Retorna o id na posicao passada"
    (get-id (get imoveis pos {:id 0}))
)

(defn imoveis-caros [imoveis perc_imoveis_caros p]
    "retorna um set contendo a lista de imoveis mais caros em ordem crescente"
    "e o id do imovel na p-esima posição ou 0 caso não exista"
    ;Ordena o vetor em ordem crescente de precos
    (def lista (vec (sort order-by-preco imoveis)))
 
    (def tam (count lista))

    ;retorna um subvetor baseado na porcentagem passada 
    (def start (- tam (int (* perc_imoveis_caros (double (/ tam 100))))))
    (def lista (vec(subvec lista start)))

    {
        :lista lista,
        :id (get-id-pos lista p) 
    }
)


(defn list-id-comma [imoveis]
    (if (empty? imoveis) (str "\r\n")
        (str (join ", " (map :id imoveis)) "\r\n")
    )
)