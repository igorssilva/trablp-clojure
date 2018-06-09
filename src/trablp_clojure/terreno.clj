(ns trablp-clojure.terreno)


(defn fator-terreno [solo]
    (case solo
        "A" 0.9
        "G" 1.3
        "R" 1.1))