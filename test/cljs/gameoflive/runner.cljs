(ns gameoflive.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [gameoflive.core-test]
              [gameoflive.game-test]))

(doo-tests 'gameoflive.core-test)
(doo-tests 'gameoflive.game-test)
