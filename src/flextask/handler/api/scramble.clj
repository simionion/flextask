(ns flextask.handler.api.scramble
    (:require [ataraxy.core :as ataraxy]
      [ataraxy.response :as response]
      [clojure.java.io :as io]
      [integrant.core :as ig]))

(defn scrambled? [str1 str2]
      "Function (scramble str1 str2) that
    returns true if a portion of str1 characters can be
    rearranged to match str2, otherwise returns false\n"
      (let [freq1 (frequencies str1)
            freq2 (frequencies str2)]
           (every? #(<= (val %) (freq1 (key %) 0)) freq2)
           )
      )

(defmethod ig/init-key :flextask.handler.api/scramble [_ options]
           (fn [{[_ str1 str2] :ataraxy/result}]
               [::response/ok (str (scrambled? str1 str2))]))


