(ns trablp-clojure.fileio  
  (:require [trablp-clojure.retangulo :as retangulo])
  (:require [trablp-clojure.triangulo :as triangulo])
  (:require [trablp-clojure.trapezio :as trapezio])  
  (:require [trablp-clojure.apartamento :as apartamento])  
  (:require [trablp-clojure.casa :as casa])  
)
(use '[clojure.string :only [blank? split join]])

(defn le-linhas  [caminho]
    "Le o arquivo mapeando linhas até \n\n como uma lista de strings"
    (def conteudo (slurp caminho))
    (if (blank? conteudo) ()
        (vec (map #(split % #"\n") (split conteudo #"\n\n")))
    )  
)

(defn inicia-imovel [line]
    "Inicia um imovel a partir de uma lista de strings"
    (case (line 0)
        "casa" (casa/new-casa (line 1) (line 2) (line 3) (line 4) (line 5) (line 6) (line 7) (line 8) (line 9))
        "apto" (apartamento/new-apartamento (line 1) (line 2) (line 3) (line 4) (line 5) (line 6) (line 7) (line 8) (line 9))
        "triang" (triangulo/new-triangulo (line 1) (line 2) (line 3) (line 4) (line 5) (line 6))
        "retang" (retangulo/new-retangulo (line 1) (line 2) (line 3) (line 4) (line 5) (line 6))
        "trapez" (trapezio/new-trapezio (line 1) (line 2) (line 3) (line 4) (line 5) (line 6) (line 7)))
)

(defn printando [linhas]
  (doseq [item linhas]
    (print item)
  )
)


(defn le-catalogo [caminho] 
    (def lista-imoveis-txt (le-linhas caminho))
    (def imoveis [])
    (println caminho)
    (println (lista-imoveis-txt))
    (doseq [imovel-txt lista-imoveis-txt]
        (printando imovel-txt)
        ;(conj imoveis (inicia-imovel imovel-txt))
    )

)