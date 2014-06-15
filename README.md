# print-let

## project info

`[print-let "0.1.0"]`

## usage

Require:

```
(ns your-ns
  (:require [print-let :refer [print-let]]))
```

Simply use `print-let` instead of `let`.

```clojure
(print-let [x "a"
            y (str x "b")
            z (str y y)]
  z)
```

becomes:

```clojure
(let [x "a"
      _ (println "x:" x)
      y (str x "b")
      _ (println "y:" y)
      z (str y y)
      _ (println "z:" z)]
  z)
```
