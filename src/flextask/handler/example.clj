(ns flextask.handler.example
  (:require [ataraxy.core :as ataraxy]
            [ataraxy.response :as response] 
            [clojure.java.io :as io]
            [integrant.core :as ig]))



(defn scramble? [str1 str2]
      "Function (scramble str1 str2) that
    returns true if a portion of str1 characters can be
    rearranged to match str2, otherwise returns false\n"
      (let [freq1 (frequencies str1)
            freq2 (frequencies str2)]
           (every? #(<= (val %) (freq1 (key %) 0)) freq2)
           )
      )


(defmethod ig/init-key :flextask.handler/example [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok (io/resource "flextask/handler/example/example.html")]))
