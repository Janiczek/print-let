(ns print-let)
;; https://www.youtube.com/watch?v=3eqW7rghDew

;; ============================================
;; "exported" fns:
;;    print-let (used the same way as `let`)
;; ============================================

#_ ;; usage:
(print-let [x "a"
            y (str x "b")
            z (str y y)]
           z)
#_ ;; =>
(let [x "a"
      _ (println "x:" x)
      y (str x "b")
      _ (println "y:" y)
      z (str y y)
      _ (println "z:" z)]
  z)

;; ===================================================

(defn- print-form [[id form :as pair]]
  `(~id ~form _# (println ~(str id ":") ~id)))

(defmacro print-let [bindings & body]
  (let [binding-pairs (partition 2 bindings)
        bindings-with-prints (apply concat (map print-form binding-pairs))]
    `(let [~@bindings-with-prints]
       ~@body)))
