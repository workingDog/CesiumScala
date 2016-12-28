import cesium.{ModelGraphics, _}
import cesiumOptions._
import CesiumImplicits._

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

  def main(): Unit = {
    Console.println("---> hello from CesiumApp")

    // launch the Cesium viewer
    val viewer = new Viewer("cesiumContainer", ViewerOptions.
      infoBox(false).
      selectionIndicator(false).
      terrainShadows(ShadowMode.ENABLED))

    def createModel(url: String, height: Double) = {
      val headPitchRol = new HeadingPitchRoll(Math.toRadians(135), 0, 0)
      val position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, height)
      val entity = viewer.entities.add(new Entity(
        EntityOptions.
          name(url).
          position(position).
          orientation(Transforms.headingPitchRollQuaternion(position, headPitchRol)).
          model(new ModelGraphics(ModelGraphicsOptions.
            uri(url).
            minimumPixelSize(128).
            maximumScale(20000))))
      )
  //    viewer.trackedEntity = entity
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

    def addShapes() = {

      val stripeMaterial = new StripeMaterialProperty(StripeMaterialPropertyOptions.
        evenColor(Color.WHITE.withAlpha(0.5)).
        oddColor(Color.BLUE.withAlpha(0.5)).
        repeat(5.0))

      viewer.entities.add(new Entity(EntityOptions.
        rectangle(new RectangleGraphics(RectangleGraphicsOptions.
          coordinates(Rectangle.fromDegrees(-92.0, 20.0, -86.0, 27.0)).
          outline(true).
          outlineColor(Color.WHITE).
          outlineWidth(4).
          stRotation(Math.toRadians(45)).
          material(stripeMaterial)))))

      viewer.entities.add(new Entity(EntityOptions.
        polygon(new PolygonGraphics(PolygonGraphicsOptions.
          hierarchy(new PolygonHierarchy(Cartesian3.fromDegreesArray(js.Array(-107.0, 27.0, -107.0, 22.0, -102.0, 23.0, -97.0, 21.0, -97.0, 25.0)))).
          outline(true).
          outlineColor(Color.WHITE).
          outlineWidth(4).
          stRotation(Math.toRadians(45)).
          material(stripeMaterial)))))

      viewer.entities.add(new Entity(EntityOptions.
        position(Cartesian3.fromDegrees(-80.0, 25.0)).
        ellipse(new EllipseGraphics(EllipseGraphicsOptions.
          semiMinorAxis(300000.0).
          semiMajorAxis(500000.0).
          outline(true).
          outlineColor(Color.WHITE).
          outlineWidth(4).
          material(stripeMaterial)))))

    }

    addShapes()

    addBillboard()

    createModel("./SampleData/models/CesiumAir/Cesium_Air.glb", 5000.0)

    val theImage = new PinBuilder().fromColor(Color.ROYALBLUE, 48).toDataURL("PNG", 1.0)

    viewer.entities.add(new Entity(EntityOptions.
      name("Blank blue pin").
      position(Cartesian3.fromDegrees(151.2093, -33.8688)).
      billboard(new BillboardGraphics(BillboardGraphicsOptions.
        image(theImage).
        verticalOrigin(VerticalOrigin.BOTTOM).
        show(true)))))
  }

}