(ns trablp-clojure.fileio)
(use 'clojure.java.io)

(defn le_catalogo [path] 
    (with-open [rdr (reader path)]
    (doseq [line (line-seq rdr)]
      (println line))))