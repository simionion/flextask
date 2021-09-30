(ns flextask.handler.example-test
  (:require [clojure.test :refer :all]
            [integrant.core :as ig]
            [ring.mock.request :as mock]
            [flextask.handler.example :as example]))

(deftest smoke-test
  (testing "example page exists"
    (let [handler  (ig/init-key :flextask.handler/example {})
          response (handler (mock/request :get "/"))]
      (is (= :ataraxy.response/ok (first response)) "response ok"))))
