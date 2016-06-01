
import cesium.{ModelGraphics,  _}
import cesiumOptions._

import scala.scalajs.js.JSApp
import scala.scalajs.js
import scala.language.implicitConversions


/**
  * a basic example using CesiumScala.
  *
  * to compile and generate CesiumScala, type "sbt fastOptJS".
  * This will generate "cesiumscala-fastopt.js" in the "./js directory".
  * Put "CesiumScala.html" and "cesiumscala-fastopt.js" files in the "Cesium/Apps" directory and
  * launch Cesium (node server.js).
  * Then point your browser to http://localhost:8080/Apps/CesiumScala.html
  *
  * P.S
  * you should get a key for Bing Map, see: https://www.bingmapsportal.com/
  * and put it in the CesiumScala.html.
  */
object CesiumApp extends JSApp {

  implicit def Cartesian3ToConstPosProp(value: Cartesian3): ConstantPositionProperty = new ConstantPositionProperty(value)

  implicit def ValueToConstProp(value: Any): ConstantProperty = new ConstantProperty(value.asInstanceOf[js.Any])


  def main(): Unit = {
    Console.println("---> hello from CesiumApp")

    // launch the Cesium viewer
    val viewer = new Viewer("cesiumContainer")

    // see Sandcastle example: https://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=3D%20Models.html&label=Showcases
    def createModel(url: String, height: Double) = {
      val position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, height)
      val entity = viewer.entities.add(new Entity(
        EntityOptions.
          name(url).
          position(position).
          orientation(Transforms.headingPitchRollQuaternion(position, Math.toRadians(135), 0, 0)).
          model(new ModelGraphics(ModelGraphicsOptions.
            uri(url).
            minimumPixelSize(128).
            maximumScale(20000))))
      )
      viewer.trackedEntity = entity
    }

    def addBillboard() = {
      viewer.entities.add(new Entity(EntityOptions.
        position(Cartesian3.fromDegrees(-75.59777, 40.03883)).
        billboard(new BillboardGraphics(
          BillboardGraphicsOptions.
            image("./SampleData/models/CesiumMan/Cesium_Man.jpg").
            show(true).
            scale(2.0).
            color(Color.LIME).
            rotation(Math.PI / 4.0).
            horizontalOrigin(HorizontalOrigin.CENTER).
            pixelOffset(new Cartesian2(0, -50)).
            verticalOrigin(VerticalOrigin.BOTTOM).
            alignedAxis(Cartesian3.ZERO).
            width(50.0).
            height(25.0)))))
    }

  //  addBillboard()

    createModel("./SampleData/models/CesiumAir/Cesium_Air.glb", 5000.0)
  }
}

