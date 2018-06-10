(ns trablp-clojure.core
    (:require [trablp-clojure.fileio :as io])
    (:require [trablp-clojure.imovel :as imovel])
    (:require [trablp-clojure.terreno :as terreno])
    (:require [trablp-clojure.casa :as casa])
    (:gen-class))



(defn -main  
    [& args]
    "Classe principal"
    (doseq [x [1,2,3,4,5,6,7,8,9,10]]
    (def imoveis (io/le-catalogo (str "resources/" (str x) "/catalogo.txt")) )  
    (def imoveis (io/atualiza-catalogo (str "resources/" (str x) "/atual.txt") imoveis))   
    (def espec (io/le-espec (str "resources/" (str x) "/espec.txt")))

    (def imoveis-caros-set (imovel/imoveis-caros imoveis (:perc_imoveis_caros espec) (- (:i espec) 1)))
    
    (def menores-arg-set (terreno/menores-argilosos imoveis (:perc_menores_arg espec) (- (:j espec) 1)))

    (def casas-area-preco-set (casa/casas-area-preco imoveis (:area_limite espec) (:preco_limite espec) (- (:k espec) 1)))


    (io/esc-string "result.txt" (str (+ (:id imoveis-caros-set) (:id menores-arg-set) (:id casas-area-preco-set))))

    (io/esc-string "saida.txt" (str (imovel/list-id-comma (:lista imoveis-caros-set)) (imovel/list-id-comma (:lista menores-arg-set)) (imovel/list-id-comma (:lista casas-area-preco-set ))))
    

    (println "result" (io/compare-files "result.txt" (str "resources/" (str x) "/result.txt")))
    (println "saida" (io/compare-files "saida.txt" (str "resources/" (str x) "/saida.txt")))
    )
)
