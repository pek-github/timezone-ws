(ns timezones.core
  (:import (javax.ws.rs Path Consumes Produces POST )
           (javax.ws.rs.core Response)
           (org.codehaus.jettison.json JSONObject)
           )
  (:require [clojure.data.json :as json])
  (:gen-class))

; -------
; REST Endpoint:
; POST http://localhost:4444/time/
;   having at Header:
;     Content-Type: application/json
;   and carrying a Payload of:
;     { "timezone" : "UTC" }
; -------

(defn- convert-time
  "A helper function that implements the application logic of time conversion"
  [zone-id]
  (-> zone-id java.time.ZoneId/of java.time.ZonedDateTime/now str))

; The interface to be implemented
(definterface clock
  (now [^org.codehaus.jettison.json.JSONObject jso]))

; Implementation of the REST time conversion WS
(deftype
  ^{ Path "/time" } clockResource []
  clock
    ( ^{POST true
        Consumes ["application/json"]
        Produces ["application/json"] }
      now [ this ^org.codehaus.jettison.json.JSONObject jso ]
        (let [request-timezone (.getString jso "timezone" )]
          (json/write-str
             { :your-timezone request-timezone
               :your-time (convert-time request-timezone) })
        )
    )
)
