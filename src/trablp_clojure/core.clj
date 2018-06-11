(ns trablp-clojure.core
    (:require [trablp-clojure.fileio :as io])
    (:require [trablp-clojure.imovel :as imovel])
    (:require [trablp-clojure.terreno :as terreno])
    (:require [trablp-clojure.casa :as casa])
    (:gen-class))



(defn -main  
    [& args]
    "Classe principal"

    ;le o catalogo
    (def imoveis (io/le-catalogo "catalogo.txt"))  
    ;atualiza o catalogo
    (def imoveis (io/atualiza-catalogo "atual.txt" imoveis))
    ;le especificacoes para o relatorio  
    (def espec (io/le-espec "espec.txt"))

    ;set contendo a lista de imoveis caros em ordem crescente e o id na posicao i desta lista
    (def imoveis-caros-set (imovel/imoveis-caros imoveis (:perc_imoveis_caros espec) (- (:i espec) 1)))
    
    ;set contendo a lista de menores terrenos argiloso em ordem decrescente e o id na posicao j desta lista
    (def menores-arg-set (terreno/menores-argilosos imoveis (:perc_menores_arg espec) (- (:j espec) 1)))

    ;set contendo a lista de casas com area maior que area_limite e preco menor que preco_limite em ordem decrescente e o id na posicao k desta lista
    (def casas-area-preco-set (casa/casas-area-preco imoveis (:area_limite espec) (:preco_limite espec) (- (:k espec) 1)))

    ;escreve a soma dos ids nas posições no arquivo result
    (io/esc-string "result.txt" (str (+ (:id imoveis-caros-set) (:id menores-arg-set) (:id casas-area-preco-set))))
    
    ;escreve as listas de ids no arquivo saida
    (io/esc-string "saida.txt" (str (imovel/list-id-comma (:lista imoveis-caros-set)) (imovel/list-id-comma (:lista menores-arg-set)) (imovel/list-id-comma (:lista casas-area-preco-set ))))
    
    
)
