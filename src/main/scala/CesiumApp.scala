
import cesium.{CzmlDataSource, Viewer}
import org.scalajs.dom._
import org.scalajs.dom
import dom.document
import dom.window
import scala.scalajs.js.{JSON, JSApp}


/**
  * a basic Scala.js app using CesiumScala.
  *
  * to compile and generate the CesiumApp, type sbt fastOptJS.
  * This will generate a cesiumscala-fastopt.js in the ./js directory.
  * Put the CesiumScala.html and the cesiumscala-fastopt.js files in the Cesium/Apps directory and
  * launch Cesium, e.g. using node server.js, then point your browser to
  * http://localhost:8080/Apps/CesiumScala.html
  *
  */
object CesiumApp extends JSApp {
  def main(): Unit = {
    println("---> hello from scala CesiumApp")

    // launch the Cesium viewer
    val viewer = new Viewer("cesiumContainer")

    // setup the czml data source
    var czmlStream = new CzmlDataSource()

    // link the viewer to the data source
    viewer.dataSources.add(czmlStream)

    // fly to Tokyo
//    viewer.camera.flyTo( {destination: Cesium.Cartesian3.fromDegrees(139.75, 35.68, 300000) })

    // open a web socket
    val ws = new WebSocket("ws://localhost:3210/")

    // when the websocket is connected, send a request to the CZML server
    ws.onopen = {
      (e: Event) =>
        console.log("-------> client request was sent...")
        ws.send("client ready")
    }

    // receiving data from the CZML server
    ws.onmessage = {
      (msg: MessageEvent) =>
        val msgData = msg.data.toString
        console.log("-------> message received: " + msgData)
        // process/display the czml
        czmlStream.process(JSON.parse(msgData))
    }

    // websocket is closed
    ws.onclose = {
      (msg: CloseEvent) => console.log("-------> Connection is closed...")
    }

    // schedule sending a request to the CZML server for more data every 2 secs
  //  dom.window.setInterval(() => ws.onopen, 2000)

  }
}

