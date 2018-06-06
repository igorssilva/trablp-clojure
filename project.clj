(defproject trablp-clojure "0.1.0"
  :description "Trabalho de LP"
  :url "https://github.com/igorssilva/trablp-clojure"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot trablp-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
