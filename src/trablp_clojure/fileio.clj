(ns trablp-clojure.fileio  
  (:require [trablp-clojure.retangulo :as retangulo])
  (:require [trablp-clojure.triangulo :as triangulo])
  (:require [trablp-clojure.trapezio :as trapezio])  
  (:require [trablp-clojure.apartamento :as apartamento])  
  (:require [trablp-clojure.casa :as casa])
  (:require [trablp-clojure.imovel :as imovel])
  (:require [clojure.string :as string])
)

(defn le-linhas  [caminho]
    "Le o arquivo mapeando linhas até \n\n como uma lista de strings"
    (def conteudo (string/replace (slurp caminho) #"\r" ""))
    (if (string/blank? conteudo) ()
        (vec (map #(string/split % #"\n") (string/split conteudo #"\n\n")))
    )  
)

(defn inicia-imovel [line]
    "Inicia um imovel a partir de uma lista de strings"
    (case (line 0)
        "casa" (def imovel (casa/new-casa (line 1) (line 2) (line 3) (line 4) (line 5) (line 6) (line 7) (line 8) (line 9)))
        "apto" (def imovel(apartamento/new-apartamento (line 1) (line 2) (line 3) (line 4) (line 5) (line 6) (line 7) (line 8) (line 9)))
        "triang" (def imovel(triangulo/new-triangulo (line 1) (line 2) (line 3) (line 4) (line 5) (line 6)))
        "retang" (def imovel(retangulo/new-retangulo (line 1) (line 2) (line 3) (line 4) (line 5) (line 6)))
        "trapez" (def imovel(trapezio/new-trapezio (line 1) (line 2) (line 3) (line 4) (line 5) (line 6) (line 7)))
    )    
    imovel
)

(defn le-catalogo [caminho] 
    (def imoveis-str (le-linhas caminho))
    (def imoveis (map #(inicia-imovel %) imoveis-str))
    (zipmap (map :id imoveis) imoveis)
)


(defn atualiza-catalogo [caminho imoveis]
    (def imoveis-str (le-linhas caminho))
    (def imoveis-local imoveis)
    (doseq [item imoveis-str]
        (case (item 0)
            "i" (def imoveis-local (conj imoveis-local (assoc {} (Integer/parseInt (item 2))  (inicia-imovel (into [] (rest item))))))
            "e" (def imoveis-local (dissoc imoveis-local (Integer/parseInt (item 1)) ))
            "a" (def imoveis-local (assoc imoveis-local (Integer/parseInt (item 2)) (inicia-imovel (into [] (rest item)))))
            :no-match
        )
    )
    (map second imoveis-local)
)

(defn le-espec [caminho]
    (def conteudo (string/replace (slurp caminho) #"\r" ""))
    (def espec-vec (vec (string/split conteudo #"\n")))   
    {
        :perc_imoveis_caros  (Integer/parseInt (espec-vec 0)) ,
        :perc_menores_arg (Integer/parseInt (espec-vec 1)) ,
        :area_limite (Float/parseFloat (espec-vec 2)) ,
        :preco_limite (Float/parseFloat (espec-vec 3)) ,
        :i (Integer/parseInt (espec-vec 4)),
        :j (Integer/parseInt (espec-vec 5)),
        :k (Integer/parseInt (espec-vec 6))
    }    
)

(use 'clojure.java.io)

(defn esc-string [caminho str]    
    (spit caminho str)
)

(defn compare-files [entrada saida]
    (def entrada-c (slurp entrada))
    (def saida-c (slurp saida))
    
    (= entrada-c saida-c)
    
)

