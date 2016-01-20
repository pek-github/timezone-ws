(defproject timezones "0.1.0-SNAPSHOT"
  :description "A tiny WS that returns the current date and time for a given timezone"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [javax.ws.rs/javax.ws.rs-api "2.0.1"]
                 [org.glassfish.jersey.core/jersey-server "2.17"]
                 [com.sun.jersey/jersey-grizzly "1.9.1"]
                 [com.sun.jersey/jersey-json "1.9.1"]
                 [com.sun.grizzly/grizzly-framework-http "1.0.52"]
                 [com.sun.grizzly.samples/grizzly-multiple-adapter "1.9.36"]
                 [org.clojure/data.json "0.2.6"]
                 [org.codehaus.jettison/jettison "1.3.7"]
                 ]
  :main timezones.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
