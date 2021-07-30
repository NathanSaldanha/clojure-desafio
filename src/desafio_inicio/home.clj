(ns desafio-inicio.home)

(def cliente-dados {:nome "Nathan", :cpf "07452325853", :email "nmariano85@gmail.com"})
(def cartao-dados {:numero "1202554846", :cvv 123, :validade "15/05/2020", :limite 125})
(def compra-dados
  [{:data            "2021-07-18 0:00"
    :valor           50.00
    :estabelecimento "Burcaneiros"
    :categoria       "Alimentação"}
   {:data            "2021-07-19 8:00"
    :valor           730.00
    :estabelecimento "Burcaneiros"
    :categoria       "Alimentação"}
   {:data            "2021-07-29 8:00"
    :valor           150.00
    :estabelecimento "Agenda Edu"
    :categoria       "Educação"}
   {:data            "2021-06-29 8:00"
    :valor           1205.00
    :estabelecimento "Khan academy"
    :categoria       "Educação"}
   {:data            "2021-06-15 9:00"
    :valor           250.00
    :estabelecimento "Sirio"
    :categoria       "Saúde"}
   {:data            "2021-05-29 8:00"
    :valor           150.99
    :estabelecimento "Libanes"
    :categoria       "Saúde"}])

(def compra-finalizada (assoc cliente-dados :cartao (assoc cartao-dados :compras compra-dados)))

(defn agrupa-categoria
  [compra]
  (->> compra
       :cartao
       :compras
       (group-by :categoria)))

(defn preco-compra [compra]
  (:valor compra) )

(defn total-compras
  [compras]
  (reduce + (map preco-compra compras)))

(defn valor-total-categoria
  [[categoria compras]]
  [categoria (total-compras compras)])

(println "Listagem de compras realizadas")
(println (-> compra-finalizada
             :cartao
             :compras))
(println)

(println "Valor dos gastos agrupados por categoria")
(println (map valor-total-categoria (agrupa-categoria compra-finalizada)))