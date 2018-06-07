(ns trablp-clojure.fileio)
(use 'clojure.java.io)

(defn tes [] 
    (with-open [rdr (reader "test.txt")]
    (doseq [line (line-seq rdr)]
      (println line))))