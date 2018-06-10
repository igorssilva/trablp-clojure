(defproject trablp-clojure "1.0"
  :description "Programa para ler e manipular arquivos sobre imoveis"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :plugins [[lein-codox "0.10.3"]]
  :main trablp-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
