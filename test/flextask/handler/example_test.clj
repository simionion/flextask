(ns flextask.handler.example-test
    (:require [clojure.test :refer :all]
      [integrant.core :as ig]
      [ring.mock.request :as mock]
      [flextask.handler.index :as index]
      [flextask.handler.api.scramble :as scramble]
      ))

(deftest index-test
         (testing "Index page exists"
                  (let [handler (ig/init-key :flextask.handler/index {})
                        response (handler (mock/request :get "/"))]
                       (is (= :ataraxy.response/ok (first response)) "response ok"))))

(deftest scramble1-test
         (testing "Scramble Api Test 1"
                  (is (= true (scramble/scrambled? "rekqodlw" "world")) "rekqodlw VS world")))

(deftest scramble2-test
         (testing "Scramble Api Test 2"
                  (is (= true (scramble/scrambled? "cedewaraaossoqqyt" "codewars")) "cedewaraaossoqqyt VS codewars")))

(deftest scramble3-test
         (testing "Scramble Api Test 3"
                  (is (= false (scramble/scrambled? "katas" "steak")) "katas VS steak")))

(deftest scramble4-test
         (testing "Scramble Api Test 4"
                  (is (= true (scramble/scrambled? "stressed" "desserts")) "stressed VS desserts")))

