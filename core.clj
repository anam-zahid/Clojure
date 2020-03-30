(ns clojuredemo.core
  (:gen-class)
  (:import [smile.classification NaiveBayes$Trainer NaiveBayes$Model])
  )

;; training data
(def X (into-array (map double-array [[0 0 1]
                                      [0 1 1]
                                      [1 1 0]])))
;; training labels
(def y (int-array [0 0 1]))
;; testing data
(def X2 (into-array [(double-array [1 0 0])]))
(def X3 (into-array [(double-array [1 1 1])]))
(def X4 (into-array [(double-array [0 0 1])]))


(let [temp-model (smile.classification.NaiveBayes$Trainer.
                  smile.classification.NaiveBayes$Model/BERNOULLI 2 3)]
  (def model (.train temp-model X y)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; Individually
  (doseq [x [X2 X3 X4]]
    (println (seq (.predict model x)))))
  ;; All at once
(println (seq (.predict model X)))
