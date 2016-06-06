/**
  * A Scala.js facade for Cesium.js "An open-source JavaScript library for world-class 3D globes and maps"
  *
  * Reference:  http://cesiumjs.org/ and https://cesiumjs.org/refdoc.html
  * Specifically Cesium-1.21 documentation/code (May 2016)
  * Updated to Cesium-1.22 (June 2016)
  *
  * This package implements the Cesium.Options objects using JSOptionBuilder
  * see: [[https://github.com/jducoeur/jsext]]
  *
  * @author Ringo Wathelet
  *         Date: 22/05/16
  *         Version: 1.1
  */
package cesiumOptions {

  import cesium._

  import cesium.Cesium.RenderState
  import org.querki.jsext.{JSOptionBuilder, OptMap, noOpts}
  import org.scalajs.dom.html.Canvas
  import scala.scalajs.js
  import scala.scalajs.js.annotation._
  import scala.scalajs.js.{Promise => _, _}
  import org.scalajs.dom.{Blob, Document, Element}
  import org.scalajs.dom.raw.{HTMLCanvasElement, HTMLImageElement, HTMLVideoElement}
  import scala.scalajs.js.typedarray.{ArrayBuffer, Float32Array, Float64Array, Int16Array, Int8Array, TypedArray, Uint16Array, Uint32Array, Uint8Array}


  @JSName("Cesium.Options")
  @js.native
  trait ArcGisImageServerTerrainProviderOptions extends js.Object

  object ArcGisImageServerTerrainProviderOptions extends ArcGisImageServerTerrainProviderOptionsBuilder(noOpts)

  class ArcGisImageServerTerrainProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ArcGisImageServerTerrainProviderOptions, ArcGisImageServerTerrainProviderOptionsBuilder](new ArcGisImageServerTerrainProviderOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def token(v: String) = jsOpt("token", v)

    def proxy(v: Object) = jsOpt("proxy", v)

    def tilingScheme(v: TilingScheme) = jsOpt("tilingScheme", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def credit(v: Credit | String) = jsOpt("credit", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait BoxGeometryOptions extends js.Object

  object BoxGeometryOptions extends BoxGeometryOptionsBuilder(noOpts)

  class BoxGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[BoxGeometryOptions, BoxGeometryOptionsBuilder](new BoxGeometryOptionsBuilder(_)) {
    def minimum(v: Cartesian3) = jsOpt("minimum", v)

    def maximum(v: Cartesian3) = jsOpt("maximum", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait BoxOutlineGeometryOptions extends js.Object

  object BoxOutlineGeometryOptions extends BoxOutlineGeometryOptionsBuilder(noOpts)

  class BoxOutlineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[BoxOutlineGeometryOptions, BoxOutlineGeometryOptionsBuilder](new BoxOutlineGeometryOptionsBuilder(_)) {
    def minimum(v: Cartesian3) = jsOpt("minimum", v)

    def maximum(v: Cartesian3) = jsOpt("maximum", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait CatmullRomSplineOptions extends js.Object

  object CatmullRomSplineOptions extends CatmullRomSplineOptionsBuilder(noOpts)

  class CatmullRomSplineOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CatmullRomSplineOptions, CatmullRomSplineOptionsBuilder](new CatmullRomSplineOptionsBuilder(_)) {
    def times(v: Array[Double]) = jsOpt("times", v)

    def points(v: Array[Cartesian3]) = jsOpt("points", v)

    def firstTangent(v: Cartesian3) = jsOpt("firstTangent", v)

    def lastTangent(v: Cartesian3) = jsOpt("lastTangent", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait CesiumTerrainProviderOptions extends js.Object

  object CesiumTerrainProviderOptions extends CesiumTerrainProviderOptionsBuilder(noOpts)

  class CesiumTerrainProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CesiumTerrainProviderOptions, CesiumTerrainProviderOptionsBuilder](new CesiumTerrainProviderOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def proxy(v: Proxy) = jsOpt("proxy", v)

    def requestVertexNormals(v: Boolean) = jsOpt("requestVertexNormals", v)

    def requestWaterMask(v: Boolean) = jsOpt("requestWaterMask", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def credit(v: Credit | String) = jsOpt("credit", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait CircleGeometryOptions extends js.Object

  object CircleGeometryOptions extends CircleGeometryOptionsBuilder(noOpts)

  class CircleGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CircleGeometryOptions, CircleGeometryOptionsBuilder](new CircleGeometryOptionsBuilder(_)) {
    def center(v: Cartesian3) = jsOpt("center", v)

    def radius(v: Double) = jsOpt("radius", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def height(v: Double) = jsOpt("height", v)

    def granularity(v: Double) = jsOpt("granularity", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)

    def extrudedHeight(v: Double) = jsOpt("extrudedHeight", v)

    def stRotation(v: Double) = jsOpt("stRotation", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait CircleOutlineGeometryOptions extends js.Object

  object CircleOutlineGeometryOptions extends CircleOutlineGeometryOptionsBuilder(noOpts)

  class CircleOutlineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CircleOutlineGeometryOptions, CircleOutlineGeometryOptionsBuilder](new CircleOutlineGeometryOptionsBuilder(_)) {
    def center(v: Cartesian3) = jsOpt("center", v)

    def radius(v: Double) = jsOpt("radius", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def height(v: Double) = jsOpt("height", v)

    def granularity(v: Double) = jsOpt("granularity", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)

    def extrudedHeight(v: Double) = jsOpt("extrudedHeight", v)

    def numberOfVerticalLines(v: Double) = jsOpt("numberOfVerticalLines", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait ClockOptions extends js.Object

  object ClockOptions extends ClockOptionsBuilder(noOpts)

  class ClockOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ClockOptions, ClockOptionsBuilder](new ClockOptionsBuilder(_)) {
    def startTime(v: JulianDate) = jsOpt("startTime", v)

    def stopTime(v: JulianDate) = jsOpt("stopTime", v)

    def currentTime(v: JulianDate) = jsOpt("currentTime", v)

    def multiplier(v: Double) = jsOpt("multiplier", v)

    def clockStep(v: ClockStep) = jsOpt("clockStep", v)

    def clockRange(v: ClockRange) = jsOpt("clockRange", v)

    def canAnimate(v: Boolean) = jsOpt("canAnimate", v)

    def shouldAnimate(v: Boolean) = jsOpt("shouldAnimate", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait RandomColorOptions extends js.Object

  object RandomColorOptions extends RandomColorOptionsBuilder(noOpts)

  class RandomColorOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[RandomColorOptions, RandomColorOptionsBuilder](new RandomColorOptionsBuilder(_)) {
    def red(v: Double) = jsOpt("red", v)

    def minimumRed(v: Double) = jsOpt("minimumRed", v)

    def maximumRed(v: Double) = jsOpt("maximumRed", v)

    def green(v: Double) = jsOpt("green", v)

    def minimumGreen(v: Double) = jsOpt("minimumGreen", v)

    def maximumGreen(v: Double) = jsOpt("maximumGreen", v)

    def blue(v: Double) = jsOpt("blue", v)

    def minimumBlue(v: Double) = jsOpt("minimumBlue", v)

    def maximumBlue(v: Double) = jsOpt("maximumBlue", v)

    def alpha(v: Double) = jsOpt("alpha", v)

    def minimumAlpha(v: Double) = jsOpt("minimumAlpha", v)

    def maximumAlpha(v: Double) = jsOpt("maximumAlpha", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait CorridorGeometryOptions extends js.Object

  object CorridorGeometryOptions extends CorridorGeometryOptionsBuilder(noOpts)

  class CorridorGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CorridorGeometryOptions, CorridorGeometryOptionsBuilder](new CorridorGeometryOptionsBuilder(_)) {
    def positions(v: Array[Cartesian3]) = jsOpt("positions", v)

    def width(v: Double) = jsOpt("width", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def granularity(v: Double) = jsOpt("granularity", v)

    def height(v: Double) = jsOpt("height", v)

    def extrudedHeight(v: Double) = jsOpt("extrudedHeight", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)

    def cornerType(v: CornerType) = jsOpt("cornerType", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait CorridorOutlineGeometryOptions extends js.Object

  object CorridorOutlineGeometryOptions extends CorridorOutlineGeometryOptionsBuilder(noOpts)

  class CorridorOutlineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CorridorOutlineGeometryOptions, CorridorOutlineGeometryOptionsBuilder](new CorridorOutlineGeometryOptionsBuilder(_)) {
    def positions(v: Array[Cartesian3]) = jsOpt("positions", v)

    def width(v: Double) = jsOpt("width", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def granularity(v: Double) = jsOpt("granularity", v)

    def height(v: Double) = jsOpt("height", v)

    def extrudedHeight(v: Double) = jsOpt("extrudedHeight", v)

    def cornerType(v: CornerType) = jsOpt("cornerType", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait CylinderGeometryOptions extends js.Object

  object CylinderGeometryOptions extends CylinderGeometryOptionsBuilder(noOpts)

  class CylinderGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CylinderGeometryOptions, CylinderGeometryOptionsBuilder](new CylinderGeometryOptionsBuilder(_)) {
    def length(v: Double) = jsOpt("length", v)

    def topRadius(v: Double) = jsOpt("topRadius", v)

    def bottomRadius(v: Double) = jsOpt("bottomRadius", v)

    def slices(v: Int) = jsOpt("slices", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait CylinderOutlineGeometryOptions extends js.Object

  object CylinderOutlineGeometryOptions extends CylinderOutlineGeometryOptionsBuilder(noOpts)

  class CylinderOutlineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CylinderOutlineGeometryOptions, CylinderOutlineGeometryOptionsBuilder](new CylinderOutlineGeometryOptionsBuilder(_)) {
    def length(v: Double) = jsOpt("length", v)

    def topRadius(v: Double) = jsOpt("topRadius", v)

    def bottomRadius(v: Double) = jsOpt("bottomRadius", v)

    def slices(v: Int) = jsOpt("slices", v)

    def numberOfVerticalLines(v: Int) = jsOpt("numberOfVerticalLines", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait EllipseGeometryOptions extends js.Object

  object EllipseGeometryOptions extends EllipseGeometryOptionsBuilder(noOpts)

  class EllipseGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EllipseGeometryOptions, EllipseGeometryOptionsBuilder](new EllipseGeometryOptionsBuilder(_)) {
    def center(v: Cartesian3) = jsOpt("center", v)
    def semiMajorAxis(v: Double) = jsOpt("semiMajorAxis", v)
    def semiMinorAxis(v: Double) = jsOpt("semiMinorAxis", v)
    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)
    def height(v: Double) = jsOpt("height", v)
    def extrudedHeight(v: Double) = jsOpt("extrudedHeight", v)
    def rotation(v: Double) = jsOpt("rotation", v)
    def stRotation(v: Double) = jsOpt("stRotation", v)
    def granularity(v: Double) = jsOpt("granularity", v)
    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait EllipseOutlineGeometryOptions extends js.Object

  object EllipseOutlineGeometryOptions extends EllipseOutlineGeometryOptionsBuilder(noOpts)

  class EllipseOutlineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EllipseOutlineGeometryOptions, EllipseOutlineGeometryOptionsBuilder](new EllipseOutlineGeometryOptionsBuilder(_)) {
    def center(v: Cartesian3) = jsOpt("center", v)
    def semiMajorAxis(v: Double) = jsOpt("semiMajorAxis", v)
    def semiMinorAxis(v: Double) = jsOpt("semiMinorAxis", v)
    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)
    def height(v: Double) = jsOpt("height", v)
    def extrudedHeight(v: Double) = jsOpt("extrudedHeight", v)
    def rotation(v: Double) = jsOpt("rotation", v)
    def stRotation(v: Double) = jsOpt("stRotation", v)
    def granularity(v: Double) = jsOpt("granularity", v)
    def numberOfVerticalLines(v: Int) = jsOpt("numberOfVerticalLines", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait EllipsoidGeometryOptions extends js.Object

  object EllipsoidGeometryOptions extends EllipsoidGeometryOptionsBuilder(noOpts)

  class EllipsoidGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EllipsoidGeometryOptions, EllipsoidGeometryOptionsBuilder](new EllipsoidGeometryOptionsBuilder(_)) {
    def radii(v: Cartesian3) = jsOpt("radii", v)

    def stackPartitions(v: Int) = jsOpt("stackPartitions", v)

    def slicePartitions(v: Int) = jsOpt("slicePartitions", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait EllipsoidOutlineGeometryOptions extends js.Object

  object EllipsoidOutlineGeometryOptions extends EllipsoidOutlineGeometryOptionsBuilder(noOpts)

  class EllipsoidOutlineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EllipsoidOutlineGeometryOptions, EllipsoidOutlineGeometryOptionsBuilder](new EllipsoidOutlineGeometryOptionsBuilder(_)) {
    def radii(v: Cartesian3) = jsOpt("radii", v)

    def stackPartitions(v: Int) = jsOpt("stackPartitions", v)

    def slicePartitions(v: Int) = jsOpt("slicePartitions", v)

    def subdivisions(v: Int) = jsOpt("subdivisions", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait EllipsoidTerrainProviderOptions extends js.Object

  object EllipsoidTerrainProviderOptions extends EllipsoidTerrainProviderOptionsBuilder(noOpts)

  class EllipsoidTerrainProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EllipsoidTerrainProviderOptions, EllipsoidTerrainProviderOptionsBuilder](new EllipsoidTerrainProviderOptionsBuilder(_)) {
    def tilingScheme(v: TilingScheme) = jsOpt("tilingScheme", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait GeographicTilingSchemeOptions extends js.Object

  object GeographicTilingSchemeOptions extends GeographicTilingSchemeOptionsBuilder(noOpts)

  class GeographicTilingSchemeOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GeographicTilingSchemeOptions, GeographicTilingSchemeOptionsBuilder](new GeographicTilingSchemeOptionsBuilder(_)) {
    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def rectangle(v: Rectangle) = jsOpt("rectangle", v)

    def numberOfLevelZeroTilesX(v: Int) = jsOpt("numberOfLevelZeroTilesX", v)

    def numberOfLevelZeroTilesY(v: Int) = jsOpt("numberOfLevelZeroTilesY", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait GeometryOptions extends js.Object

  object GeometryOptions extends GeometryOptionsBuilder(noOpts)

  class GeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GeometryOptions, GeometryOptionsBuilder](new GeometryOptionsBuilder(_)) {
    def attributes(v: GeometryAttributes) = jsOpt("attributes", v)

    def primitiveType(v: PrimitiveType) = jsOpt("primitiveType", v)

    def indices(v: Uint16Array | Uint32Array) = jsOpt("indices", v)

    def boundingSphere(v: BoundingSphere) = jsOpt("boundingSphere", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait GeometryAttributeOptions extends js.Object

  object GeometryAttributeOptions extends GeometryAttributeOptionsBuilder(noOpts)

  class GeometryAttributeOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GeometryAttributeOptions, GeometryAttributeOptionsBuilder](new GeometryAttributeOptionsBuilder(_)) {
    def componentDatatype(v: ComponentDatatype) = jsOpt("componentDatatype", v)

    def componentsPerAttribute(v: Int) = jsOpt("componentsPerAttribute", v)

    def normalize(v: Boolean) = jsOpt("normalize", v)

    def values(v: Cesium.TypedArray) = jsOpt("values", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait GeometryInstanceOptions extends js.Object

  object GeometryInstanceOptions extends GeometryInstanceOptionsBuilder(noOpts)

  class GeometryInstanceOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GeometryInstanceOptions, GeometryInstanceOptionsBuilder](new GeometryInstanceOptionsBuilder(_)) {
    def geometry(v: Geometry) = jsOpt("geometry", v)

    def modelMatrix(v: Matrix4) = jsOpt("modelMatrix", v)

    def id(v: Object) = jsOpt("id", v)

    def attributes(v: Object) = jsOpt("attributes", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait GeometryInstanceAttributeOptions extends js.Object

  object GeometryInstanceAttributeOptions extends GeometryInstanceAttributeOptionsBuilder(noOpts)

  class GeometryInstanceAttributeOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GeometryInstanceAttributeOptions, GeometryInstanceAttributeOptionsBuilder](new GeometryInstanceAttributeOptionsBuilder(_)) {
    def componentDatatype(v: ComponentDatatype) = jsOpt("componentDatatype", v)

    def componentsPerAttribute(v: Int) = jsOpt("componentsPerAttribute", v)

    def normalize(v: Boolean) = jsOpt("normalize", v)

    def value(v: Array[Double]) = jsOpt("value", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait HeightmapTerrainDataOptions extends js.Object

  object HeightmapTerrainDataOptions extends HeightmapTerrainDataOptionsBuilder(noOpts)

  class HeightmapTerrainDataOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[HeightmapTerrainDataOptions, HeightmapTerrainDataOptionsBuilder](new HeightmapTerrainDataOptionsBuilder(_)) {
    def buffer(v: Boolean) = jsOpt("buffer", v)

    def vertexShaderSource(v: Cesium.TypedArray) = jsOpt("vertexShaderSource", v)

    def width(v: Double) = jsOpt("width", v)

    def height(v: Double) = jsOpt("height", v)

    def childTileMask(v: Int) = jsOpt("childTileMask", v)

    def structure(v: HeightmapTerrainDataStructureOptions) = jsOpt("structure", v)

    def createdByUpsampling(v: Boolean) = jsOpt("createdByUpsampling", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait HeightmapTerrainDataStructureOptions extends js.Object

  object HeightmapTerrainDataStructureOptions extends HeightmapTerrainDataStructureOptionsBuilder(noOpts)

  class HeightmapTerrainDataStructureOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[HeightmapTerrainDataStructureOptions, HeightmapTerrainDataStructureOptionsBuilder](new HeightmapTerrainDataStructureOptionsBuilder(_)) {
    def heightScale(v: Double) = jsOpt("heightScale", v)

    def heightOffset(v: Double) = jsOpt("heightOffset", v)

    def elementsPerHeight(v: Int) = jsOpt("elementsPerHeight", v)

    def stride(v: Double) = jsOpt("stride", v)

    def elementMultiplier(v: Double) = jsOpt("elementMultiplier", v)

    def isBigEndian(v: Boolean) = jsOpt("isBigEndian", v)

  }

  @JSName("Cesium.Options")
  @js.native
  trait HermiteSplineOptions extends js.Object

  object HermiteSplineOptions extends HermiteSplineOptionsBuilder(noOpts)

  class HermiteSplineOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[HermiteSplineOptions, HermiteSplineOptionsBuilder](new HermiteSplineOptionsBuilder(_)) {
    def times(v: Array[Double]) = jsOpt("times", v)

    def points(v: Array[Cartesian3]) = jsOpt("points", v)

    def inTangents(v: Array[Cartesian3]) = jsOpt("inTangents", v)

    def outTangents(v: Array[Cartesian3]) = jsOpt("outTangents", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait LinearSplineOptions extends js.Object

  object LinearSplineOptions extends LinearSplineOptionsBuilder(noOpts)

  class LinearSplineOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LinearSplineOptions, LinearSplineOptionsBuilder](new LinearSplineOptionsBuilder(_)) {
    def times(v: Array[Double]) = jsOpt("times", v)

    def points(v: Array[Cartesian3]) = jsOpt("points", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolygonGeometryOptions extends js.Object

  object PolygonGeometryOptions extends PolygonGeometryOptionsBuilder(noOpts)

  class PolygonGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolygonGeometryOptions, PolygonGeometryOptionsBuilder](new PolygonGeometryOptionsBuilder(_)) {
    def polygonHierarchy(v: PolygonHierarchy) = jsOpt("polygonHierarchy", v)

    def height(v: Double) = jsOpt("height", v)

    def extrudedHeight(v: Double) = jsOpt("extrudedHeight", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)

    def stRotation(v: Double) = jsOpt("stRotation", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def granularity(v: Double) = jsOpt("granularity", v)

    def perPositionHeight(v: Boolean) = jsOpt("perPositionHeight", v)

    def closeTop(v: Boolean) = jsOpt("closeTop", v)

    def closeBottom(v: Boolean) = jsOpt("closeBottom", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolygonOutlineGeometryOptions extends js.Object

  object PolygonOutlineGeometryOptions extends PolygonOutlineGeometryOptionsBuilder(noOpts)

  class PolygonOutlineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolygonOutlineGeometryOptions, PolygonOutlineGeometryOptionsBuilder](new PolygonOutlineGeometryOptionsBuilder(_)) {
    def polygonHierarchy(v: PolygonHierarchy) = jsOpt("polygonHierarchy", v)

    def height(v: Double) = jsOpt("height", v)

    def extrudedHeight(v: Double) = jsOpt("extrudedHeight", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def granularity(v: Double) = jsOpt("granularity", v)

    def perPositionHeight(v: Boolean) = jsOpt("perPositionHeight", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolylineGeometryOptions extends js.Object

  object PolylineGeometryOptions extends PolylineGeometryOptionsBuilder(noOpts)

  class PolylineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineGeometryOptions, PolylineGeometryOptionsBuilder](new PolylineGeometryOptionsBuilder(_)) {
    def positions(v: Array[Cartesian3]) = jsOpt("positions", v)

    def width(v: Double) = jsOpt("width", v)

    def colors(v: Array[Color]) = jsOpt("colors", v)

    def colorsPerVertex(v: Boolean) = jsOpt("colorsPerVertex", v)

    def followSurface(v: Boolean) = jsOpt("followSurface", v)

    def granularity(v: Double) = jsOpt("granularity", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolylineVolumeGeometryOptions extends js.Object

  object PolylineVolumeGeometryOptions extends PolylineVolumeGeometryOptionsBuilder(noOpts)

  class PolylineVolumeGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineVolumeGeometryOptions, PolylineVolumeGeometryOptionsBuilder](new PolylineVolumeGeometryOptionsBuilder(_)) {
    def polylinePositions(v: Array[Cartesian3]) = jsOpt("polylinePositions", v)

    def shapePositions(v: Array[Cartesian3]) = jsOpt("shapePositions", v)

    def cornerType(v: CornerType) = jsOpt("cornerType", v)

    def granularity(v: Double) = jsOpt("granularity", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolylineVolumeOutlineGeometryOptions extends js.Object

  object PolylineVolumeOutlineGeometryOptions extends PolylineVolumeOutlineGeometryOptionsBuilder(noOpts)

  class PolylineVolumeOutlineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineVolumeOutlineGeometryOptions, PolylineVolumeOutlineGeometryOptionsBuilder](new PolylineVolumeOutlineGeometryOptionsBuilder(_)) {
    def polylinePositions(v: Array[Cartesian3]) = jsOpt("polylinePositions", v)

    def shapePositions(v: Array[Cartesian3]) = jsOpt("shapePositions", v)

    def cornerType(v: CornerType) = jsOpt("cornerType", v)

    def granularity(v: Double) = jsOpt("granularity", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait QuantizedMeshTerrainDataOptions extends js.Object

  object QuantizedMeshTerrainDataOptions extends QuantizedMeshTerrainDataOptionsBuilder(noOpts)

  class QuantizedMeshTerrainDataOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[QuantizedMeshTerrainDataOptions, QuantizedMeshTerrainDataOptionsBuilder](new QuantizedMeshTerrainDataOptionsBuilder(_)) {
    def quantizedVertices(v: Uint16Array) = jsOpt("quantizedVertices", v)

    def indices(v: Uint16Array | Uint32Array) = jsOpt("indices", v)

    def minimumHeight(v: Double) = jsOpt("minimumHeight", v)

    def maximumHeight(v: Double) = jsOpt("maximumHeight", v)

    def boundingSphere(v: BoundingSphere) = jsOpt("boundingSphere", v)

    def orientedBoundingBox(v: OrientedBoundingBox) = jsOpt("orientedBoundingBox", v)

    def horizonOcclusionPoint(v: Cartesian3) = jsOpt("horizonOcclusionPoint", v)

    def westIndices(v: Array[Int]) = jsOpt("westIndices", v)

    def southIndices(v: Array[Int]) = jsOpt("southIndices", v)

    def eastIndices(v: Array[Int]) = jsOpt("eastIndices", v)

    def northIndices(v: Array[Int]) = jsOpt("northIndices", v)

    def westSkirtHeight(v: Int) = jsOpt("westSkirtHeight", v)

    def southSkirtHeight(v: Int) = jsOpt("southSkirtHeight", v)

    def eastSkirtHeight(v: Int) = jsOpt("eastSkirtHeight", v)

    def northSkirtHeight(v: Int) = jsOpt("northSkirtHeight", v)

    def childTileMask(v: Int) = jsOpt("childTileMask", v)

    def createdByUpsampling(v: Boolean) = jsOpt("createdByUpsampling", v)

    def encodedNormals(v: Uint8Array) = jsOpt("encodedNormals", v)

    def waterMask(v: Uint8Array) = jsOpt("waterMask", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait QuaternionSplineOptions extends js.Object

  object QuaternionSplineOptions extends QuaternionSplineOptionsBuilder(noOpts)

  class QuaternionSplineOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[QuaternionSplineOptions, QuaternionSplineOptionsBuilder](new QuaternionSplineOptionsBuilder(_)) {
    def times(v: Array[Double]) = jsOpt("times", v)

    def points(v: Array[Quaternion]) = jsOpt("points", v)

    def firstInnerQuadrangle(v: Quaternion) = jsOpt("firstInnerQuadrangle", v)

    def lastInnerQuadrangle(v: Quaternion) = jsOpt("lastInnerQuadrangle", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait RectangleGeometryOptions extends js.Object

  object RectangleGeometryOptions extends RectangleGeometryOptionsBuilder(noOpts)

  class RectangleGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[RectangleGeometryOptions, RectangleGeometryOptionsBuilder](new RectangleGeometryOptionsBuilder(_)) {
    def rectangle(v: Rectangle) = jsOpt("rectangle", v)

    def height(v: Double) = jsOpt("height", v)

    def extrudedHeight(v: Double) = jsOpt("extrudedHeight", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)

    def rotation(v: Double) = jsOpt("rotation", v)

    def stRotation(v: Double) = jsOpt("stRotation", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def granularity(v: Double) = jsOpt("granularity", v)

    def closeTop(v: Boolean) = jsOpt("closeTop", v)

    def closeBottom(v: Boolean) = jsOpt("closeBottom", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait RectangleOutlineGeometryOptions extends js.Object

  object RectangleOutlineGeometryOptions extends RectangleOutlineGeometryOptionsBuilder(noOpts)

  class RectangleOutlineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[RectangleOutlineGeometryOptions, RectangleOutlineGeometryOptionsBuilder](new RectangleOutlineGeometryOptionsBuilder(_)) {
    def rectangle(v: Rectangle) = jsOpt("rectangle", v)

    def height(v: Double) = jsOpt("height", v)

    def extrudedHeight(v: Double) = jsOpt("extrudedHeight", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)

    def rotation(v: Double) = jsOpt("rotation", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def granularity(v: Double) = jsOpt("granularity", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait SimplePolylineGeometryOptions extends js.Object

  object SimplePolylineGeometryOptions extends SimplePolylineGeometryOptionsBuilder(noOpts)

  class SimplePolylineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[SimplePolylineGeometryOptions, SimplePolylineGeometryOptionsBuilder](new SimplePolylineGeometryOptionsBuilder(_)) {
    def positions(v: Array[Cartesian3]) = jsOpt("positions", v)

    def colors(v: Array[Color]) = jsOpt("colors", v)

    def colorsPerVertex(v: Boolean) = jsOpt("colorsPerVertex", v)

    def followSurface(v: Boolean) = jsOpt("followSurface", v)

    def granularity(v: Double) = jsOpt("granularity", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait SphereGeometryOptions extends js.Object

  object SphereGeometryOptions extends SphereGeometryOptionsBuilder(noOpts)

  class SphereGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[SphereGeometryOptions, SphereGeometryOptionsBuilder](new SphereGeometryOptionsBuilder(_)) {
    def radius(v: Double) = jsOpt("radius", v)

    def stackPartitions(v: Int) = jsOpt("stackPartitions", v)

    def slicePartitions(v: Int) = jsOpt("slicePartitions", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait SphereOutlineGeometryOptions extends js.Object

  object SphereOutlineGeometryOptions extends SphereOutlineGeometryOptionsBuilder(noOpts)

  class SphereOutlineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[SphereOutlineGeometryOptions, SphereOutlineGeometryOptionsBuilder](new SphereOutlineGeometryOptionsBuilder(_)) {
    def radius(v: Double) = jsOpt("radius", v)

    def stackPartitions(v: Int) = jsOpt("stackPartitions", v)

    def slicePartitions(v: Int) = jsOpt("slicePartitions", v)

    def subdivisions(v: Int) = jsOpt("subdivisions", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait TimeIntervalOptions extends js.Object

  object TimeIntervalOptions extends TimeIntervalOptionsBuilder(noOpts)

  class TimeIntervalOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[TimeIntervalOptions, TimeIntervalOptionsBuilder](new TimeIntervalOptionsBuilder(_)) {
    def start(v: JulianDate) = jsOpt("start", v)

    def stop(v: JulianDate) = jsOpt("stop", v)

    def isStartIncluded(v: Boolean) = jsOpt("isStartIncluded", v)

    def isStopIncluded(v: Boolean) = jsOpt("isStopIncluded", v)

    // todo
    def data(v: Object) = jsOpt("data", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait Iso8601Options extends js.Object

  object Iso8601Options extends Iso8601OptionsBuilder(noOpts)

  class Iso8601OptionsBuilder(val dict: OptMap) extends JSOptionBuilder[Iso8601Options, Iso8601OptionsBuilder](new Iso8601OptionsBuilder(_)) {
    def iso8601(v: String) = jsOpt("iso8601", v)

    def isStartIncluded(v: Boolean) = jsOpt("isStartIncluded", v)

    def isStopIncluded(v: Boolean) = jsOpt("isStopIncluded", v)

    def data(v: Object) = jsOpt("data", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait FindIntervalOptions extends js.Object

  object FindIntervalOptions extends TimeIntervalOptionsBuilder(noOpts)

  class FindIntervalOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[FindIntervalOptions, FindIntervalOptionsBuilder](new FindIntervalOptionsBuilder(_)) {
    def start(v: JulianDate) = jsOpt("start", v)

    def stop(v: JulianDate) = jsOpt("stop", v)

    def isStartIncluded(v: Boolean) = jsOpt("isStartIncluded", v)

    def isStopIncluded(v: Boolean) = jsOpt("isStopIncluded", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait VRTheWorldTerrainProviderOptions extends js.Object

  object VRTheWorldTerrainProviderOptions extends VRTheWorldTerrainProviderOptionsBuilder(noOpts)

  class VRTheWorldTerrainProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[VRTheWorldTerrainProviderOptions, VRTheWorldTerrainProviderOptionsBuilder](new VRTheWorldTerrainProviderOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def proxy(v: Object) = jsOpt("proxy", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def credit(v: Credit | String) = jsOpt("credit", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait VideoSynchronizerOptions extends js.Object

  object VideoSynchronizerOptions extends VideoSynchronizerOptionsBuilder(noOpts)

  class VideoSynchronizerOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[VideoSynchronizerOptions, VideoSynchronizerOptionsBuilder](new VideoSynchronizerOptionsBuilder(_)) {
    def clock(v: Clock) = jsOpt("clock", v)

    def element(v: HTMLVideoElement) = jsOpt("element", v)

    def epoch(v: JulianDate) = jsOpt("epoch", v)

    def tolerance(v: Double) = jsOpt("tolerance", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait WallGeometryOptions extends js.Object

  object WallGeometryOptions extends WallGeometryOptionsBuilder(noOpts)

  class WallGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[WallGeometryOptions, WallGeometryOptionsBuilder](new WallGeometryOptionsBuilder(_)) {
    def positions(v: Array[Cartesian3]) = jsOpt("positions", v)

    def maximumHeights(v: Array[Double]) = jsOpt("maximumHeights", v)

    def minimumHeights(v: Array[Double]) = jsOpt("minimumHeights", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)

    def granularity(v: Double) = jsOpt("granularity", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait ConstantHeightsOptions extends js.Object

  object ConstantHeightsOptions extends ConstantHeightsOptionsBuilder(noOpts)

  class ConstantHeightsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ConstantHeightsOptions, ConstantHeightsOptionsBuilder](new ConstantHeightsOptionsBuilder(_)) {
    def positions(v: Array[Cartesian3]) = jsOpt("positions", v)

    def maximumHeights(v: Array[Double]) = jsOpt("maximumHeights", v)

    def minimumHeights(v: Array[Double]) = jsOpt("minimumHeights", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait WallOutlineGeometryOptions extends js.Object

  object WallOutlineGeometryOptions extends WallOutlineGeometryOptionsBuilder(noOpts)

  class WallOutlineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[WallOutlineGeometryOptions, WallOutlineGeometryOptionsBuilder](new WallOutlineGeometryOptionsBuilder(_)) {
    def positions(v: Array[Cartesian3]) = jsOpt("positions", v)

    def maximumHeights(v: Array[Double]) = jsOpt("maximumHeights", v)

    def minimumHeights(v: Array[Double]) = jsOpt("minimumHeights", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def granularity(v: Double) = jsOpt("granularity", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait WebMercatorTilingSchemeOptions extends js.Object

  object WebMercatorTilingSchemeOptions extends WebMercatorTilingSchemeOptionsBuilder(noOpts)

  class WebMercatorTilingSchemeOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[WebMercatorTilingSchemeOptions, WebMercatorTilingSchemeOptionsBuilder](new WebMercatorTilingSchemeOptionsBuilder(_)) {
    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def numberOfLevelZeroTilesX(v: Int) = jsOpt("numberOfLevelZeroTilesX", v)

    def numberOfLevelZeroTilesY(v: Int) = jsOpt("numberOfLevelZeroTilesY", v)

    def rectangleSouthwestInMeters(v: Cartesian2) = jsOpt("rectangleSouthwestInMeters", v)

    def rectangleNortheastInMeters(v: Cartesian2) = jsOpt("rectangleNortheastInMeters", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait BillboardGraphicsOptions extends js.Object

  object BillboardGraphicsOptions extends BillboardGraphicsOptionsBuilder(noOpts)

  class BillboardGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[BillboardGraphicsOptions, BillboardGraphicsOptionsBuilder](new BillboardGraphicsOptionsBuilder(_)) {
    def image(v: Property) = jsOpt("image", v)

    def show(v: Property) = jsOpt("show", v)

    def scale(v: Property) = jsOpt("scale", v)

    def horizontalOrigin(v: Property) = jsOpt("horizontalOrigin", v)

    def verticalOrigin(v: Property) = jsOpt("verticalOrigin", v)

    def eyeOffset(v: Property) = jsOpt("eyeOffset", v)

    def pixelOffset(v: Property) = jsOpt("pixelOffset", v)

    def rotation(v: Property) = jsOpt("rotation", v)

    def alignedAxis(v: Property) = jsOpt("alignedAxis", v)

    def width(v: Property) = jsOpt("width", v)

    def height(v: Property) = jsOpt("height", v)

    def color(v: Property) = jsOpt("color", v)

    def scaleByDistance(v: Property) = jsOpt("scaleByDistance", v)

    def translucencyByDistance(v: Property) = jsOpt("translucencyByDistance", v)

    def pixelOffsetScaleByDistance(v: Property) = jsOpt("pixelOffsetScaleByDistance", v)

    def imageSubRegion(v: Property) = jsOpt("imageSubRegion", v)

    def sizeInMeters(v: Property) = jsOpt("sizeInMeters", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait BoxGraphicsOptions extends js.Object

  object BoxGraphicsOptions extends BoxGraphicsOptionsBuilder(noOpts)

  class BoxGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[BoxGraphicsOptions, BoxGraphicsOptionsBuilder](new BoxGraphicsOptionsBuilder(_)) {
    def dimensions(v: Property) = jsOpt("dimensions", v)

    def show(v: Property) = jsOpt("show", v)

    def fill(v: Property) = jsOpt("fill", v)

    def material(v: MaterialProperty) = jsOpt("material", v)

    def outline(v: Property) = jsOpt("outline", v)

    def outlineColor(v: Property) = jsOpt("outlineColor", v)

    def outlineWidth(v: Property) = jsOpt("outlineWidth", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait CheckerboardMaterialPropertyOptions extends js.Object

  object CheckerboardMaterialPropertyOptions extends CheckerboardMaterialPropertyOptionsBuilder(noOpts)

  class CheckerboardMaterialPropertyOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CheckerboardMaterialPropertyOptions, CheckerboardMaterialPropertyOptionsBuilder](new CheckerboardMaterialPropertyOptionsBuilder(_)) {
    def evenColor(v: Property) = jsOpt("evenColor", v)

    def oddColor(v: Property) = jsOpt("oddColor", v)

    def repeat(v: Property) = jsOpt("repeat", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait CorridorGraphicsOptions extends js.Object

  object CorridorGraphicsOptions extends CorridorGraphicsOptionsBuilder(noOpts)

  class CorridorGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CorridorGraphicsOptions, CorridorGraphicsOptionsBuilder](new CorridorGraphicsOptionsBuilder(_)) {
    def positions(v: Property) = jsOpt("positions", v)

    def width(v: Property) = jsOpt("width", v)

    def cornerType(v: Property) = jsOpt("cornerType", v)

    def height(v: Property) = jsOpt("height", v)

    def extrudedHeight(v: Property) = jsOpt("extrudedHeight", v)

    def show(v: Property) = jsOpt("show", v)

    def fill(v: Property) = jsOpt("fill", v)

    def material(v: MaterialProperty) = jsOpt("material", v)

    def outline(v: Property) = jsOpt("outline", v)

    def outlineColor(v: Property) = jsOpt("outlineColor", v)

    def outlineWidth(v: Property) = jsOpt("outlineWidth", v)

    def granularity(v: Property) = jsOpt("granularity", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait CylinderGraphicsOptions extends js.Object

  object CylinderGraphicsOptions extends CylinderGraphicsOptionsBuilder(noOpts)

  class CylinderGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CylinderGraphicsOptions, CylinderGraphicsOptionsBuilder](new CylinderGraphicsOptionsBuilder(_)) {
    def length(v: Property) = jsOpt("length", v)

    def topRadius(v: Property) = jsOpt("topRadius", v)

    def bottomRadius(v: Property) = jsOpt("bottomRadius", v)

    def show(v: Property) = jsOpt("show", v)

    def fill(v: Property) = jsOpt("fill", v)

    def material(v: MaterialProperty) = jsOpt("material", v)

    def outline(v: Property) = jsOpt("outline", v)

    def outlineColor(v: Property) = jsOpt("outlineColor", v)

    def outlineWidth(v: Property) = jsOpt("outlineWidth", v)

    def numberOfVerticalLines(v: Property) = jsOpt("numberOfVerticalLines", v)

    def slices(v: Property) = jsOpt("slices", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait DataSourceDisplayOptions extends js.Object

  object DataSourceDisplayOptions extends DataSourceDisplayOptionsBuilder(noOpts)

  class DataSourceDisplayOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[DataSourceDisplayOptions, DataSourceDisplayOptionsBuilder](new DataSourceDisplayOptionsBuilder(_)) {
    def scene(v: Scene) = jsOpt("scene", v)

    def dataSourceCollection(v: DataSourceCollection) = jsOpt("dataSourceCollection", v)

    def visualizersCallback(v: DataSourceDisplay | DataSourceDisplay.VisualizersCallback) = jsOpt("visualizersCallback", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait EllipseGraphicsOptions extends js.Object

  object EllipseGraphicsOptions extends EllipseGraphicsOptionsBuilder(noOpts)

  class EllipseGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EllipseGraphicsOptions, EllipseGraphicsOptionsBuilder](new EllipseGraphicsOptionsBuilder(_)) {

    def semiMajorAxis(v: Property) = jsOpt("semiMajorAxis", v)
    def semiMinorAxis(v: Property) = jsOpt("semiMinorAxis", v)
    def height(v: Property) = jsOpt("height", v)
    def extrudedHeight(v: Property) = jsOpt("extrudedHeight", v)
    def show(v: Property) = jsOpt("show", v)
    def fill(v: Property) = jsOpt("fill", v)
    def material(v: MaterialProperty) = jsOpt("material", v)
    def outline(v: Property) = jsOpt("outline", v)
    def outlineColor(v: Property) = jsOpt("outlineColor", v)
    def outlineWidth(v: Property) = jsOpt("outlineWidth", v)
    def rotation(v: Property) = jsOpt("rotation", v)
    def stRotation(v: Property) = jsOpt("stRotation", v)
    def granularity(v: Property) = jsOpt("granularity", v)
    def numberOfVerticalLines(v: Property) = jsOpt("numberOfVerticalLines", v)

  }

  @JSName("Cesium.Options")
  @js.native
  trait EllipsoidGraphicsOptions extends js.Object

  object EllipsoidGraphicsOptions extends EllipsoidGraphicsOptionsBuilder(noOpts)

  class EllipsoidGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EllipsoidGraphicsOptions, EllipsoidGraphicsOptionsBuilder](new EllipsoidGraphicsOptionsBuilder(_)) {
    def radii(v: Property) = jsOpt("radii", v)

    def subdivisions(v: Property) = jsOpt("subdivisions", v)

    def stackPartitions(v: Property) = jsOpt("stackPartitions", v)

    def show(v: Property) = jsOpt("show", v)

    def fill(v: Property) = jsOpt("fill", v)

    def material(v: MaterialProperty) = jsOpt("material", v)

    def outline(v: Property) = jsOpt("outline", v)

    def outlineColor(v: Property) = jsOpt("outlineColor", v)

    def outlineWidth(v: Property) = jsOpt("outlineWidth", v)

    def slicePartitions(v: Property) = jsOpt("slicePartitions", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait EntityOptions extends js.Object

  object EntityOptions extends EntityOptionsBuilder(noOpts)

  class EntityOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EntityOptions, EntityOptionsBuilder](new EntityOptionsBuilder(_)) {
    def id(v: String) = jsOpt("id", v)

    def name(v: String) = jsOpt("name", v)

    def availability(v: TimeIntervalCollection) = jsOpt("availability", v)

    def show(v: Boolean) = jsOpt("show", v)

    def description(v: Property) = jsOpt("description", v)

    def position(v: PositionProperty) = jsOpt("position", v)

    def orientation(v: Property) = jsOpt("orientation", v)

    def viewFrom(v: Property) = jsOpt("viewFrom", v)

    def parent(v: Entity) = jsOpt("parent", v)

    def billboard(v: BillboardGraphics) = jsOpt("billboard", v)

    def box(v: BoxGraphics) = jsOpt("box", v)

    def corridor(v: CorridorGraphics) = jsOpt("corridor", v)

    def cylinder(v: CylinderGraphics) = jsOpt("cylinder", v)

    def ellipse(v: EllipseGraphics) = jsOpt("ellipse", v)

    def ellipsoid(v: EllipsoidGraphics) = jsOpt("ellipsoid", v)

    def label(v: LabelGraphics) = jsOpt("label", v)

    def model(v: ModelGraphics) = jsOpt("model", v)

    def path(v: PathGraphics) = jsOpt("path", v)

    def point(v: PointGraphics) = jsOpt("point", v)

    def polygon(v: PolygonGraphics) = jsOpt("polygon", v)

    def polyline(v: PolylineGraphics) = jsOpt("polyline", v)

    def polylineVolume(v: PolylineVolumeGraphics) = jsOpt("polylineVolume", v)

    def rectangle(v: RectangleGraphics) = jsOpt("rectangle", v)

    def wall(v: WallGraphics) = jsOpt("wall", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait GridMaterialPropertyOptions extends js.Object

  object GridMaterialPropertyOptions extends GridMaterialPropertyOptionsBuilder(noOpts)

  class GridMaterialPropertyOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GridMaterialPropertyOptions, GridMaterialPropertyOptionsBuilder](new GridMaterialPropertyOptionsBuilder(_)) {
    def color(v: Property) = jsOpt("color", v)

    def cellAlpha(v: Property) = jsOpt("cellAlpha", v)

    def lineCount(v: Property) = jsOpt("lineCount", v)

    def lineThickness(v: Property) = jsOpt("lineThickness", v)

    def lineOffset(v: Property) = jsOpt("lineOffset", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait ImageMaterialPropertyOptions extends js.Object

  object ImageMaterialPropertyOptions extends ImageMaterialPropertyOptionsBuilder(noOpts)

  class ImageMaterialPropertyOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ImageMaterialPropertyOptions, ImageMaterialPropertyOptionsBuilder](new ImageMaterialPropertyOptionsBuilder(_)) {
    def image(v: Property) = jsOpt("image", v)

    def repeat(v: Property) = jsOpt("repeat", v)

    def color(v: Property) = jsOpt("color", v)

    def transparent(v: Property) = jsOpt("transparent", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait LabelGraphicsOptions extends js.Object

  object LabelGraphicsOptions extends LabelGraphicsOptionsBuilder(noOpts)

  class LabelGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LabelGraphicsOptions, LabelGraphicsOptionsBuilder](new LabelGraphicsOptionsBuilder(_)) {
    def text(v: Property) = jsOpt("text", v)

    def font(v: Property) = jsOpt("font", v)

    def style(v: Property) = jsOpt("style", v)

    def fillColor(v: Property) = jsOpt("fillColor", v)

    def outlineColor(v: Property) = jsOpt("outlineColor", v)

    def outlineWidth(v: Property) = jsOpt("outlineWidth", v)

    def show(v: Property) = jsOpt("show", v)

    def horizontalOrigin(v: Property) = jsOpt("horizontalOrigin", v)

    def verticalOrigin(v: Property) = jsOpt("verticalOrigin", v)

    def eyeOffset(v: Property) = jsOpt("eyeOffset", v)

    def pixelOffset(v: Property) = jsOpt("pixelOffset", v)

    def translucencyByDistance(v: Property) = jsOpt("translucencyByDistance", v)

    def pixelOffsetScaleByDistance(v: Property) = jsOpt("pixelOffsetScaleByDistance", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait ModelGraphicsOptions extends js.Object

  object ModelGraphicsOptions extends ModelGraphicsOptionsBuilder(noOpts)

  class ModelGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ModelGraphicsOptions, ModelGraphicsOptionsBuilder](new ModelGraphicsOptionsBuilder(_)) {
    def uri(v: Property) = jsOpt("uri", v)

    def show(v: Property) = jsOpt("show", v)

    def scale(v: Property) = jsOpt("scale", v)

    def minimumPixelSize(v: Property) = jsOpt("minimumPixelSize", v)

    def maximumScale(v: Property) = jsOpt("maximumScale", v)

    def incrementallyLoadTextures(v: Property) = jsOpt("incrementallyLoadTextures", v)

    def runAnimations(v: Property) = jsOpt("runAnimations", v)

    def nodeTransformations(v: Property) = jsOpt("nodeTransformations", v)

    def castShadows(v: Property) = jsOpt("castShadows", v)
    def receiveShadows(v: Property) = jsOpt("receiveShadows", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait NodeTransformationPropertyOptions extends js.Object

  object NodeTransformationPropertyOptions extends NodeTransformationPropertyOptionsBuilder(noOpts)

  class NodeTransformationPropertyOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[NodeTransformationPropertyOptions, NodeTransformationPropertyOptionsBuilder](new NodeTransformationPropertyOptionsBuilder(_)) {
    def translation(v: Property) = jsOpt("translation", v)

    def rotation(v: Property) = jsOpt("rotation", v)

    def scale(v: Property) = jsOpt("scale", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PathGraphicsOptions extends js.Object

  object PathGraphicsOptions extends PathGraphicsOptionsBuilder(noOpts)

  class PathGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PathGraphicsOptions, PathGraphicsOptionsBuilder](new PathGraphicsOptionsBuilder(_)) {
    def leadTime(v: Property) = jsOpt("leadTime", v)

    def trailTime(v: Property) = jsOpt("trailTime", v)

    def show(v: Property) = jsOpt("show", v)

    def width(v: Property) = jsOpt("width", v)

    def material(v: MaterialProperty) = jsOpt("material", v)

    def resolution(v: Property) = jsOpt("resolution", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PointGraphicsOptions extends js.Object

  object PointGraphicsOptions extends PointGraphicsOptionsBuilder(noOpts)

  class PointGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PointGraphicsOptions, PointGraphicsOptionsBuilder](new PointGraphicsOptionsBuilder(_)) {
    def color(v: Property) = jsOpt("color", v)

    def pixelSize(v: Property) = jsOpt("pixelSize", v)

    def outlineColor(v: Property) = jsOpt("outlineColor", v)

    def outlineWidth(v: Property) = jsOpt("outlineWidth", v)

    def show(v: Property) = jsOpt("show", v)

    def scaleByDistance(v: Property) = jsOpt("scaleByDistance", v)

    def translucencyByDistance(v: Property) = jsOpt("translucencyByDistance", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolygonGraphicsOptions extends js.Object

  object PolygonGraphicsOptions extends PolygonGraphicsOptionsBuilder(noOpts)

  class PolygonGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolygonGraphicsOptions, PolygonGraphicsOptionsBuilder](new PolygonGraphicsOptionsBuilder(_)) {
    def hierarchy(v: Property) = jsOpt("hierarchy", v)

    def height(v: Property) = jsOpt("height", v)

    def extrudedHeight(v: Property) = jsOpt("extrudedHeight", v)

    def show(v: Property) = jsOpt("show", v)

    def fill(v: Property) = jsOpt("fill", v)

    def material(v: MaterialProperty) = jsOpt("material", v)

    def outline(v: Property) = jsOpt("outline", v)

    def outlineColor(v: Property) = jsOpt("outlineColor", v)

    def outlineWidth(v: Property) = jsOpt("outlineWidth", v)

    def granularity(v: Property) = jsOpt("granularity", v)

    def stRotation(v: Property) = jsOpt("stRotation", v)

    def perPositionHeight(v: Property) = jsOpt("perPositionHeight", v)

    def closeTop(v: Boolean) = jsOpt("closeTop", v)

    def closeBottom(v: Boolean) = jsOpt("closeBottom", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolylineGlowMaterialPropertyOptions extends js.Object

  object PolylineGlowMaterialPropertyOptions extends PolylineGlowMaterialPropertyOptionsBuilder(noOpts)

  class PolylineGlowMaterialPropertyOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineGlowMaterialPropertyOptions, PolylineGlowMaterialPropertyOptionsBuilder](new PolylineGlowMaterialPropertyOptionsBuilder(_)) {
    def color(v: Property) = jsOpt("color", v)

    def glowPower(v: Property) = jsOpt("glowPower", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolylineGraphicsOptions extends js.Object

  object PolylineGraphicsOptions extends PolylineGraphicsOptionsBuilder(noOpts)

  class PolylineGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineGraphicsOptions, PolylineGraphicsOptionsBuilder](new PolylineGraphicsOptionsBuilder(_)) {
    def positions(v: Property) = jsOpt("positions", v)

    def width(v: Property) = jsOpt("width", v)

    def followSurface(v: Property) = jsOpt("followSurface", v)

    def show(v: Property) = jsOpt("show", v)

    def material(v: MaterialProperty) = jsOpt("material", v)

    def granularity(v: Property) = jsOpt("granularity", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolylineOutlineMaterialPropertyOptions extends js.Object

  object PolylineOutlineMaterialPropertyOptions extends PolylineOutlineMaterialPropertyOptionsBuilder(noOpts)

  class PolylineOutlineMaterialPropertyOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineOutlineMaterialPropertyOptions, PolylineOutlineMaterialPropertyOptionsBuilder](new PolylineOutlineMaterialPropertyOptionsBuilder(_)) {
    def color(v: Property) = jsOpt("color", v)

    def outlineColor(v: Property) = jsOpt("outlineColor", v)

    def outlineWidth(v: Property) = jsOpt("outlineWidth", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolylineVolumeGraphicsOptions extends js.Object

  object PolylineVolumeGraphicsOptions extends PolylineVolumeGraphicsOptionsBuilder(noOpts)

  class PolylineVolumeGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineVolumeGraphicsOptions, PolylineVolumeGraphicsOptionsBuilder](new PolylineVolumeGraphicsOptionsBuilder(_)) {
    def positions(v: Property) = jsOpt("positions", v)

    def cornerType(v: Property) = jsOpt("cornerType", v)

    def shape(v: Property) = jsOpt("shape", v)

    def show(v: Property) = jsOpt("show", v)

    def fill(v: Property) = jsOpt("fill", v)

    def material(v: MaterialProperty) = jsOpt("material", v)

    def outline(v: Property) = jsOpt("outline", v)

    def outlineColor(v: Property) = jsOpt("outlineColor", v)

    def outlineWidth(v: Property) = jsOpt("outlineWidth", v)

    def granularity(v: Property) = jsOpt("granularity", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait RectangleGraphicsOptions extends js.Object

  object RectangleGraphicsOptions extends RectangleGraphicsOptionsBuilder(noOpts)

  class RectangleGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[RectangleGraphicsOptions, RectangleGraphicsOptionsBuilder](new RectangleGraphicsOptionsBuilder(_)) {
    def coordinates(v: Property) = jsOpt("coordinates", v)

    def height(v: Property) = jsOpt("height", v)

    def extrudedHeight(v: Property) = jsOpt("extrudedHeight", v)

    def show(v: Property) = jsOpt("show", v)

    def fill(v: Property) = jsOpt("fill", v)

    def material(v: MaterialProperty) = jsOpt("material", v)

    def outline(v: Property) = jsOpt("outline", v)

    def outlineColor(v: Property) = jsOpt("outlineColor", v)

    def outlineWidth(v: Property) = jsOpt("outlineWidth", v)

    def granularity(v: Property) = jsOpt("granularity", v)

    def closeTop(v: Property) = jsOpt("closeTop", v)

    def closeBottom(v: Property) = jsOpt("closeBottom", v)

    def rotation(v: Property) = jsOpt("rotation", v)

    def stRotation(v: Property) = jsOpt("stRotation", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait StripeMaterialPropertyOptions extends js.Object

  object StripeMaterialPropertyOptions extends StripeMaterialPropertyOptionsBuilder(noOpts)

  class StripeMaterialPropertyOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[StripeMaterialPropertyOptions, StripeMaterialPropertyOptionsBuilder](new StripeMaterialPropertyOptionsBuilder(_)) {
    def evenColor(v: Property) = jsOpt("evenColor", v)

    def oddColor(v: Property) = jsOpt("oddColor", v)

    def repeat(v: Property) = jsOpt("repeat", v)

    def offset(v: Property) = jsOpt("offset", v)

    def orientation(v: Property) = jsOpt("orientation", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait WallGraphicsOptions extends js.Object

  object WallGraphicsOptions extends WallGraphicsOptionsBuilder(noOpts)

  class WallGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[WallGraphicsOptions, WallGraphicsOptionsBuilder](new WallGraphicsOptionsBuilder(_)) {
    def positions(v: Property) = jsOpt("positions", v)

    def maximumHeights(v: Property) = jsOpt("maximumHeights", v)

    def minimumHeights(v: Property) = jsOpt("minimumHeights", v)

    def show(v: Property) = jsOpt("show", v)

    def fill(v: Property) = jsOpt("fill", v)

    def material(v: MaterialProperty) = jsOpt("material", v)

    def outline(v: Property) = jsOpt("outline", v)

    def outlineColor(v: Property) = jsOpt("outlineColor", v)

    def outlineWidth(v: Property) = jsOpt("outlineWidth", v)

    def granularity(v: Property) = jsOpt("granularity", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait AppearanceOptions extends js.Object

  object AppearanceOptions extends AppearanceOptionsBuilder(noOpts)

  class AppearanceOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[AppearanceOptions, AppearanceOptionsBuilder](new AppearanceOptionsBuilder(_)) {
    def translucent(v: Boolean) = jsOpt("translucent", v)

    def closed(v: Boolean) = jsOpt("closed", v)

    def material(v: Material) = jsOpt("material", v)

    def vertexShaderSource(v: String) = jsOpt("vertexShaderSource", v)

    def fragmentShaderSource(v: String) = jsOpt("fragmentShaderSource", v)

    def renderState(v: RenderState) = jsOpt("renderState", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait ArcGisMapServerImageryProviderOptions extends js.Object

  object ArcGisMapServerImageryProviderOptions extends ArcGisMapServerImageryProviderOptionsBuilder(noOpts)

  class ArcGisMapServerImageryProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ArcGisMapServerImageryProviderOptions, ArcGisMapServerImageryProviderOptionsBuilder](new ArcGisMapServerImageryProviderOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def token(v: String) = jsOpt("token", v)

    def tileDiscardPolicy(v: TileDiscardPolicy) = jsOpt("tileDiscardPolicy", v)

    def proxy(v: Proxy) = jsOpt("proxy", v)

    def usePreCachedTilesIfAvailable(v: Boolean) = jsOpt("usePreCachedTilesIfAvailable", v)

    def layers(v: String) = jsOpt("layers", v)

    def enablePickFeatures(v: Boolean) = jsOpt("enablePickFeatures", v)

    def rectangle(v: Rectangle) = jsOpt("rectangle", v)

    def tilingScheme(v: TilingScheme) = jsOpt("tilingScheme", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def tileWidth(v: Int) = jsOpt("tileWidth", v)

    def tileHeight(v: Int) = jsOpt("tileHeight", v)

    def maximumLevel(v: Int) = jsOpt("maximumLevel", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait BillboardCollectionOptions extends js.Object

  object BillboardCollectionOptions extends BillboardCollectionOptionsBuilder(noOpts)

  class BillboardCollectionOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[BillboardCollectionOptions, BillboardCollectionOptionsBuilder](new BillboardCollectionOptionsBuilder(_)) {
    def modelMatrix(v: Matrix4) = jsOpt("modelMatrix", v)

    def debugShowBoundingVolume(v: Boolean) = jsOpt("debugShowBoundingVolume", v)

    def scene(v: Scene) = jsOpt("scene", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait BingMapsImageryProviderOptions extends js.Object

  object BingMapsImageryProviderOptions extends BingMapsImageryProviderOptionsBuilder(noOpts)

  class BingMapsImageryProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[BingMapsImageryProviderOptions, BingMapsImageryProviderOptionsBuilder](new BingMapsImageryProviderOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def key(v: String) = jsOpt("key", v)

    def tileProtocol(v: String) = jsOpt("tileProtocol", v)

    def mapStyle(v: String) = jsOpt("mapStyle", v)

    def culture(v: String) = jsOpt("culture", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def tileDiscardPolicy(v: TileDiscardPolicy) = jsOpt("tileDiscardPolicy", v)

    def proxy(v: Proxy) = jsOpt("proxy", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait DebugAppearanceOptions extends js.Object

  object DebugAppearanceOptions extends DebugAppearanceOptionsBuilder(noOpts)

  class DebugAppearanceOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[DebugAppearanceOptions, DebugAppearanceOptionsBuilder](new DebugAppearanceOptionsBuilder(_)) {
    def attributeName(v: String) = jsOpt("attributeName", v)

    def glslDatatype(v: String) = jsOpt("glslDatatype", v)

    def vertexShaderSource(v: String) = jsOpt("vertexShaderSource", v)

    def fragmentShaderSource(v: String) = jsOpt("fragmentShaderSource", v)

    def renderState(v: RenderState) = jsOpt("renderState", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait DebugModelMatrixPrimitiveOptions extends js.Object

  object DebugModelMatrixPrimitiveOptions extends DebugModelMatrixPrimitiveOptionsBuilder(noOpts)

  class DebugModelMatrixPrimitiveOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[DebugModelMatrixPrimitiveOptions, DebugModelMatrixPrimitiveOptionsBuilder](new DebugModelMatrixPrimitiveOptionsBuilder(_)) {
    def length(v: Double) = jsOpt("length", v)

    def width(v: Double) = jsOpt("width", v)

    def modelMatrix(v: Matrix4) = jsOpt("modelMatrix", v)

    def show(v: Boolean) = jsOpt("show", v)

    def id(v: Object) = jsOpt("id", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait DiscardMissingTileImagePolicyOptions extends js.Object

  object DiscardMissingTileImagePolicyOptions extends DiscardMissingTileImagePolicyOptionsBuilder(noOpts)

  class DiscardMissingTileImagePolicyOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[DiscardMissingTileImagePolicyOptions, DiscardMissingTileImagePolicyOptionsBuilder](new DiscardMissingTileImagePolicyOptionsBuilder(_)) {
    def missingImageUrl(v: String) = jsOpt("missingImageUrl", v)

    def pixelsToCheck(v: Array[Cartesian2]) = jsOpt("pixelsToCheck", v)

    def disableCheckIfAllPixelsAreTransparent(v: Boolean) = jsOpt("disableCheckIfAllPixelsAreTransparent", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait EllipsoidSurfaceAppearanceOptions extends js.Object

  object EllipsoidSurfaceAppearanceOptions extends EllipsoidSurfaceAppearanceOptionsBuilder(noOpts)

  class EllipsoidSurfaceAppearanceOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EllipsoidSurfaceAppearanceOptions, EllipsoidSurfaceAppearanceOptionsBuilder](new EllipsoidSurfaceAppearanceOptionsBuilder(_)) {
    def flat(v: Boolean) = jsOpt("flat", v)

    def faceForward(v: Boolean) = jsOpt("faceForward", v)

    def translucent(v: Boolean) = jsOpt("translucent", v)

    def aboveGround(v: Boolean) = jsOpt("aboveGround", v)

    def material(v: Material) = jsOpt("material", v)

    def vertexShaderSource(v: String) = jsOpt("vertexShaderSource", v)

    def fragmentShaderSource(v: String) = jsOpt("fragmentShaderSource", v)

    def renderState(v: RenderState) = jsOpt("renderState", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait FrameRateMonitorOptions extends js.Object

  object FrameRateMonitorOptions extends FrameRateMonitorOptionsBuilder(noOpts)

  class FrameRateMonitorOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[FrameRateMonitorOptions, FrameRateMonitorOptionsBuilder](new FrameRateMonitorOptionsBuilder(_)) {
    def scene(v: Scene) = jsOpt("scene", v)

    def samplingWindow(v: Double) = jsOpt("samplingWindow", v)

    def quietPeriod(v: Double) = jsOpt("quietPeriod", v)

    def warmupPeriod(v: Double) = jsOpt("warmupPeriod", v)

    def minimumFrameRateDuringWarmup(v: Int) = jsOpt("minimumFrameRateDuringWarmup", v)

    def minimumFrameRateAfterWarmup(v: Int) = jsOpt("minimumFrameRateAfterWarmup", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait GoogleEarthImageryProviderOptions extends js.Object

  object GoogleEarthImageryProviderOptions extends GoogleEarthImageryProviderOptionsBuilder(noOpts)

  class GoogleEarthImageryProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GoogleEarthImageryProviderOptions, GoogleEarthImageryProviderOptionsBuilder](new GoogleEarthImageryProviderOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def channel(v: Int) = jsOpt("channel", v)

    def path(v: String) = jsOpt("path", v)

    def maximumLevel(v: Int) = jsOpt("maximumLevel", v)

    def tileDiscardPolicy(v: TileDiscardPolicy) = jsOpt("tileDiscardPolicy", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def proxy(v: Proxy) = jsOpt("proxy", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait GridImageryProviderOptions extends js.Object

  object GridImageryProviderOptions extends GridImageryProviderOptionsBuilder(noOpts)

  class GridImageryProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GridImageryProviderOptions, GridImageryProviderOptionsBuilder](new GridImageryProviderOptionsBuilder(_)) {
    def tilingScheme(v: TilingScheme) = jsOpt("tilingScheme", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def cells(v: Int) = jsOpt("cells", v)

    def color(v: Color) = jsOpt("color", v)

    def glowColor(v: Color) = jsOpt("glowColor", v)

    def glowWidth(v: Int) = jsOpt("glowWidth", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait GroundPrimitiveOptions extends js.Object

  object GroundPrimitiveOptions extends GroundPrimitiveOptionsBuilder(noOpts)

  class GroundPrimitiveOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GroundPrimitiveOptions, GroundPrimitiveOptionsBuilder](new GroundPrimitiveOptionsBuilder(_)) {
    def geometryInstances(v: Array[GeometryInstance] | GeometryInstance) = jsOpt("geometryInstances", v)

    def show(v: Boolean) = jsOpt("show", v)

    def vertexCacheOptimize(v: Boolean) = jsOpt("vertexCacheOptimize", v)

    def interleave(v: Boolean) = jsOpt("interleave", v)

    def compressVertices(v: Boolean) = jsOpt("compressVertices", v)

    def releaseGeometryInstances(v: Boolean) = jsOpt("releaseGeometryInstances", v)

    def allowPicking(v: Boolean) = jsOpt("allowPicking", v)

    def asynchronous(v: Boolean) = jsOpt("asynchronous", v)

    def debugShowBoundingVolume(v: Boolean) = jsOpt("debugShowBoundingVolume", v)

    def debugShowShadowVolume(v: Boolean) = jsOpt("debugShowShadowVolume", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait LabelCollectionOptions extends js.Object

  object LabelCollectionOptions extends LabelCollectionOptionsBuilder(noOpts)

  class LabelCollectionOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LabelCollectionOptions, LabelCollectionOptionsBuilder](new LabelCollectionOptionsBuilder(_)) {
    def modelMatrix(v: Matrix4) = jsOpt("modelMatrix", v)

    def debugShowBoundingVolume(v: Boolean) = jsOpt("debugShowBoundingVolume", v)

    def scene(v: Scene) = jsOpt("scene", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait MapboxImageryProviderOptions extends js.Object

  object MapboxImageryProviderOptions extends MapboxImageryProviderOptionsBuilder(noOpts)

  class MapboxImageryProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[MapboxImageryProviderOptions, MapboxImageryProviderOptionsBuilder](new MapboxImageryProviderOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def mapId(v: String) = jsOpt("mapId", v)

    def accessToken(v: String) = jsOpt("accessToken", v)

    def format(v: String) = jsOpt("format", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def proxy(v: Object) = jsOpt("proxy", v)

    def minimumLevel(v: Int) = jsOpt("minimumLevel", v)

    def maximumLevel(v: Int) = jsOpt("maximumLevel", v)

    def rectangle(v: Rectangle) = jsOpt("rectangle", v)

    def credit(v: Credit | String) = jsOpt("credit", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait MaterialOptions extends js.Object

  object MaterialOptions extends MaterialOptionsBuilder(noOpts)

  class MaterialOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[MaterialOptions, MaterialOptionsBuilder](new MaterialOptionsBuilder(_)) {
    def strict(v: Boolean) = jsOpt("strict", v)

    def translucent(v: Boolean | Function) = jsOpt("translucent", v)

    def fabric(v: Object) = jsOpt("fabric", v)

  }


  @JSName("Cesium.Options")
  @js.native
  trait MaterialAppearanceOptions extends js.Object

  object MaterialAppearanceOptions extends MaterialAppearanceOptionsBuilder(noOpts)

  class MaterialAppearanceOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[MaterialAppearanceOptions, MaterialAppearanceOptionsBuilder](new MaterialAppearanceOptionsBuilder(_)) {
    def flat(v: Boolean) = jsOpt("flat", v)

    def faceForward(v: Boolean) = jsOpt("faceForward", v)

    def translucent(v: Boolean) = jsOpt("translucent", v)

    def closed(v: Boolean) = jsOpt("closed", v)

    def materialSupport(v: MaterialAppearanceMaterialSupport) = jsOpt("materialSupport", v)

    def material(v: Material) = jsOpt("material", v)

    def vertexShaderSource(v: String) = jsOpt("vertexShaderSource", v)

    def fragmentShaderSource(v: String) = jsOpt("fragmentShaderSource", v)

    def renderState(v: RenderState) = jsOpt("renderState", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait ModelOptions extends js.Object

  object ModelOptions extends ModelOptionsBuilder(noOpts)

  class ModelOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ModelOptions, ModelOptionsBuilder](new ModelOptionsBuilder(_)) {
    def gltf(v: Object | ArrayBuffer | Uint8Array) = jsOpt("gltf", v)

    def basePath(v: String) = jsOpt("basePath", v)

    def show(v: Boolean) = jsOpt("show", v)

    def modelMatrix(v: Matrix4) = jsOpt("modelMatrix", v)

    def scale(v: Double) = jsOpt("scale", v)

    def minimumPixelSize(v: Double) = jsOpt("minimumPixelSize", v)

    def maximumScale(v: Double) = jsOpt("maximumScale", v)

    def id(v: Object) = jsOpt("id", v)

    def allowPicking(v: Boolean) = jsOpt("allowPicking", v)

    def incrementallyLoadTextures(v: Boolean) = jsOpt("incrementallyLoadTextures", v)

    def asynchronous(v: Boolean) = jsOpt("asynchronous", v)

    def debugShowBoundingVolume(v: Boolean) = jsOpt("debugShowBoundingVolume", v)

    def debugWireframe(v: Boolean) = jsOpt("debugWireframe", v)

    def heightReference(v: HeightReference) = jsOpt("heightReference", v)
    def scene(v: Scene) = jsOpt("scene", v)
    def castShadows(v: Boolean) = jsOpt("castShadows", v)
    def receiveShadows(v: Boolean) = jsOpt("receiveShadows", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait ModelFromGltfOptions extends js.Object

  object ModelFromGltfOptions extends ModelFromGltfOptionsBuilder(noOpts)

  class ModelFromGltfOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ModelFromGltfOptions, ModelFromGltfOptionsBuilder](new ModelFromGltfOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def headers(v: Object) = jsOpt("headers", v)

    def show(v: Boolean) = jsOpt("show", v)

    def modelMatrix(v: Matrix4) = jsOpt("modelMatrix", v)

    def scale(v: Double) = jsOpt("scale", v)

    def minimumPixelSize(v: Double) = jsOpt("minimumPixelSize", v)

    def maximumScale(v: Double) = jsOpt("maximumScale", v)

    def id(v: Object) = jsOpt("id", v)

    def allowPicking(v: Boolean) = jsOpt("allowPicking", v)

    def incrementallyLoadTextures(v: Boolean) = jsOpt("incrementallyLoadTextures", v)

    def asynchronous(v: Boolean) = jsOpt("asynchronous", v)

    def debugShowBoundingVolume(v: Boolean) = jsOpt("debugShowBoundingVolume", v)

    def debugWireframe(v: Boolean) = jsOpt("debugWireframe", v)

    def castShadows(v: Boolean) = jsOpt("castShadows", v)
    def receiveShadows(v: Boolean) = jsOpt("receiveShadows", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait MoonOptions extends js.Object

  object MoonOptions extends MoonOptionsBuilder(noOpts)

  class MoonOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[MoonOptions, MoonOptionsBuilder](new MoonOptionsBuilder(_)) {
    def show(v: Boolean) = jsOpt("show", v)

    def textureUrl(v: String) = jsOpt("textureUrl", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def onlySunLighting(v: Boolean) = jsOpt("onlySunLighting", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PerInstanceColorAppearanceOptions extends js.Object

  object PerInstanceColorAppearanceOptions extends PerInstanceColorAppearanceOptionsBuilder(noOpts)

  class PerInstanceColorAppearanceOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PerInstanceColorAppearanceOptions, PerInstanceColorAppearanceOptionsBuilder](new PerInstanceColorAppearanceOptionsBuilder(_)) {
    def flat(v: Boolean) = jsOpt("flat", v)

    def faceForward(v: Boolean) = jsOpt("faceForward", v)

    def translucent(v: Boolean) = jsOpt("translucent", v)

    def closed(v: Boolean) = jsOpt("closed", v)

    def vertexShaderSource(v: String) = jsOpt("vertexShaderSource", v)

    def fragmentShaderSource(v: String) = jsOpt("fragmentShaderSource", v)

    def renderState(v: RenderState) = jsOpt("renderState", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PointPrimitiveCollectionOptions extends js.Object

  object PointPrimitiveCollectionOptions extends PointPrimitiveCollectionOptionsBuilder(noOpts)

  class PointPrimitiveCollectionOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PointPrimitiveCollectionOptions, PointPrimitiveCollectionOptionsBuilder](new PointPrimitiveCollectionOptionsBuilder(_)) {
    def modelMatrix(v: Matrix4) = jsOpt("modelMatrix", v)

    def debugShowBoundingVolume(v: Boolean) = jsOpt("debugShowBoundingVolume", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolylineOptions extends js.Object

  object PolylineOptions extends PolylineOptionsBuilder(noOpts)

  class PolylineOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineOptions, PolylineOptionsBuilder](new PolylineOptionsBuilder(_)) {
    def show(v: Boolean) = jsOpt("show", v)

    def width(v: Double) = jsOpt("width", v)

    def loop(v: Boolean) = jsOpt("loop", v)

    def material(v: Material) = jsOpt("material", v)

    def positions(v: Array[Cartesian3]) = jsOpt("positions", v)

    def id(v: Object) = jsOpt("id", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolylineCollectionOptions extends js.Object

  object PolylineCollectionOptions extends PolylineCollectionOptionsBuilder(noOpts)

  class PolylineCollectionOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineCollectionOptions, PolylineCollectionOptionsBuilder](new PolylineCollectionOptionsBuilder(_)) {
    def modelMatrix(v: Matrix4) = jsOpt("modelMatrix", v)

    def debugShowBoundingVolume(v: Boolean) = jsOpt("debugShowBoundingVolume", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolylineColorAppearanceOptions extends js.Object

  object PolylineColorAppearanceOptions extends PolylineColorAppearanceOptionsBuilder(noOpts)

  class PolylineColorAppearanceOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineColorAppearanceOptions, PolylineColorAppearanceOptionsBuilder](new PolylineColorAppearanceOptionsBuilder(_)) {
    def translucent(v: Boolean) = jsOpt("translucent", v)

    def vertexShaderSource(v: String) = jsOpt("vertexShaderSource", v)

    def fragmentShaderSource(v: String) = jsOpt("fragmentShaderSource", v)

    def renderState(v: RenderState) = jsOpt("renderState", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolylineMaterialAppearanceOptions extends js.Object

  object PolylineMaterialAppearanceOptions extends PolylineMaterialAppearanceOptionsBuilder(noOpts)

  class PolylineMaterialAppearanceOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineMaterialAppearanceOptions, PolylineMaterialAppearanceOptionsBuilder](new PolylineMaterialAppearanceOptionsBuilder(_)) {
    def translucent(v: Boolean) = jsOpt("translucent", v)

    def vertexShaderSource(v: String) = jsOpt("vertexShaderSource", v)

    def fragmentShaderSource(v: String) = jsOpt("fragmentShaderSource", v)

    def renderState(v: RenderState) = jsOpt("renderState", v)

    def material(v: Material) = jsOpt("material", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PrimitiveOptions extends js.Object

  object PrimitiveOptions extends PrimitiveOptionsBuilder(noOpts)

  class PrimitiveOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PrimitiveOptions, PrimitiveOptionsBuilder](new PrimitiveOptionsBuilder(_)) {
    def geometryInstances(v: Array[GeometryInstance] | GeometryInstance) = jsOpt("geometryInstances", v)

    def appearance(v: Appearance) = jsOpt("appearance", v)

    def show(v: Boolean) = jsOpt("show", v)

    def modelMatrix(v: Matrix4) = jsOpt("modelMatrix", v)

    def vertexCacheOptimize(v: Boolean) = jsOpt("vertexCacheOptimize", v)

    def interleave(v: Boolean) = jsOpt("interleave", v)

    def compressVertices(v: Boolean) = jsOpt("compressVertices", v)

    def releaseGeometryInstances(v: Boolean) = jsOpt("releaseGeometryInstances", v)

    def allowPicking(v: Boolean) = jsOpt("allowPicking", v)

    def cull(v: Boolean) = jsOpt("cull", v)

    def asynchronous(v: Boolean) = jsOpt("asynchronous", v)

    def debugShowBoundingVolume(v: Boolean) = jsOpt("debugShowBoundingVolume", v)

    def castShadows(v: Boolean) = jsOpt("castShadows", v)
    def receiveShadows(v: Boolean) = jsOpt("receiveShadows", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PrimitiveCollectionOptions extends js.Object

  object PrimitiveCollectionOptions extends PrimitiveCollectionOptionsBuilder(noOpts)

  class PrimitiveCollectionOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PrimitiveCollectionOptions, PrimitiveCollectionOptionsBuilder](new PrimitiveCollectionOptionsBuilder(_)) {
    def show(v: Boolean) = jsOpt("show", v)

    def destroyPrimitives(v: Boolean) = jsOpt("destroyPrimitives", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait SceneOptions extends js.Object

  object SceneOptions extends SceneOptionsBuilder(noOpts)

  class SceneOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[SceneOptions, SceneOptionsBuilder](new SceneOptionsBuilder(_)) {
    def canvas(v: Canvas) = jsOpt("canvas", v)

    def contextOptions(v: Object) = jsOpt("contextOptions", v)

    def creditContainer(v: Element) = jsOpt("creditContainer", v)

    def mapProjection(v: MapProjection) = jsOpt("mapProjection", v)

    def orderIndependentTranslucency(v: Boolean) = jsOpt("orderIndependentTranslucency", v)

    def scene3DOnly(v: Boolean) = jsOpt("scene3DOnly", v)

    def terrainExaggeration(v: Double) = jsOpt("terrainExaggeration", v)

    def shadows(v: Boolean) = jsOpt("shadows", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait SingleTileImageryProviderOptions extends js.Object

  object SingleTileImageryProviderOptions extends SingleTileImageryProviderOptionsBuilder(noOpts)

  class SingleTileImageryProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[SingleTileImageryProviderOptions, SingleTileImageryProviderOptionsBuilder](new SingleTileImageryProviderOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def rectangle(v: Rectangle) = jsOpt("rectangle", v)

    def credit(v: Credit | String) = jsOpt("credit", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def proxy(v: Object) = jsOpt("proxy", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait SkyBoxOptions extends js.Object

  object SkyBoxOptions extends SkyBoxOptionsBuilder(noOpts)

  class SkyBoxOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[SkyBoxOptions, SkyBoxOptionsBuilder](new SkyBoxOptionsBuilder(_)) {
    def sources(v: Object) = jsOpt("sources", v)

    def show(v: Boolean) = jsOpt("show", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait TileCoordinatesImageryProviderOptions extends js.Object

  object TileCoordinatesImageryProviderOptions extends TileCoordinatesImageryProviderOptionsBuilder(noOpts)

  class TileCoordinatesImageryProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[TileCoordinatesImageryProviderOptions, TileCoordinatesImageryProviderOptionsBuilder](new TileCoordinatesImageryProviderOptionsBuilder(_)) {
    def tilingScheme(v: TilingScheme) = jsOpt("tilingScheme", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def color(v: Color) = jsOpt("color", v)

    def tileWidth(v: Int) = jsOpt("tileWidth", v)

    def tileHeight(v: Int) = jsOpt("tileHeight", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait UrlTemplateImageryProviderOptions extends js.Object

  object UrlTemplateImageryProviderOptions extends UrlTemplateImageryProviderOptionsBuilder(noOpts)

  class UrlTemplateImageryProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[UrlTemplateImageryProviderOptions, UrlTemplateImageryProviderOptionsBuilder](new UrlTemplateImageryProviderOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def pickFeaturesUrl(v: String) = jsOpt("pickFeaturesUrl", v)

    def subdomains(v: String | Array[String]) = jsOpt("subdomains", v)

    def proxy(v: Object) = jsOpt("proxy", v)

    def credit(v: Credit | String) = jsOpt("credit", v)

    def minimumLevel(v: Int) = jsOpt("minimumLevel", v)

    def maximumLevel(v: Int) = jsOpt("maximumLevel", v)

    def rectangle(v: Rectangle) = jsOpt("rectangle", v)

    def tilingScheme(v: TilingScheme) = jsOpt("tilingScheme", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def tileWidth(v: Int) = jsOpt("tileWidth", v)

    def tileHeight(v: Int) = jsOpt("tileHeight", v)

    def hasAlphaChannel(v: Boolean) = jsOpt("hasAlphaChannel", v)

    def getFeatureInfoFormats(v: Array[GetFeatureInfoFormat]) = jsOpt("getFeatureInfoFormats", v)

    def enablePickFeatures(v: Boolean) = jsOpt("enablePickFeatures", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait WebMapServiceImageryProviderOptions extends js.Object

  object WebMapServiceImageryProviderOptions extends WebMapServiceImageryProviderOptionsBuilder(noOpts)

  class WebMapServiceImageryProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[WebMapServiceImageryProviderOptions, WebMapServiceImageryProviderOptionsBuilder](new WebMapServiceImageryProviderOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def layers(v: String) = jsOpt("layers", v)

    def parameters(v: Object) = jsOpt("parameters", v)

    def getFeatureInfoParameters(v: Object) = jsOpt("getFeatureInfoParameters", v)

    def enablePickFeatures(v: Boolean) = jsOpt("enablePickFeatures", v)

    def getFeatureInfoFormats(v: Array[GetFeatureInfoFormat]) = jsOpt("getFeatureInfoFormats", v)

    def rectangle(v: Rectangle) = jsOpt("rectangle", v)

    def tilingScheme(v: TilingScheme) = jsOpt("tilingScheme", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def tileWidth(v: Int) = jsOpt("tileWidth", v)

    def tileHeight(v: Int) = jsOpt("tileHeight", v)

    def minimumLevel(v: Int) = jsOpt("minimumLevel", v)

    def maximumLevel(v: Int) = jsOpt("maximumLevel", v)

    def credit(v: Credit | String) = jsOpt("credit", v)

    def proxy(v: Object) = jsOpt("proxy", v)

    def subdomains(v: String | Array[String]) = jsOpt("subdomains", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait WebMapTileServiceImageryProviderOptions extends js.Object

  object WebMapTileServiceImageryProviderOptions extends WebMapTileServiceImageryProviderOptionsBuilder(noOpts)

  class WebMapTileServiceImageryProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[WebMapTileServiceImageryProviderOptions, WebMapTileServiceImageryProviderOptionsBuilder](new WebMapTileServiceImageryProviderOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def format(v: String) = jsOpt("format", v)

    def layer(v: String) = jsOpt("layer", v)

    def style(v: String) = jsOpt("style", v)

    def rectangle(v: Rectangle) = jsOpt("rectangle", v)

    def tilingScheme(v: TilingScheme) = jsOpt("tilingScheme", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def tileWidth(v: Int) = jsOpt("tileWidth", v)

    def tileHeight(v: Int) = jsOpt("tileHeight", v)

    def minimumLevel(v: Int) = jsOpt("minimumLevel", v)

    def maximumLevel(v: Int) = jsOpt("maximumLevel", v)

    def credit(v: Credit | String) = jsOpt("credit", v)

    def proxy(v: Object) = jsOpt("proxy", v)

    def tileMatrixLabels(v: Array[String]) = jsOpt("tileMatrixLabels", v)

    def tileMatrixSetID(v: String) = jsOpt("tileMatrixSetID", v)

    def subdomains(v: String | Array[String]) = jsOpt("subdomains", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait BaseLayerPickerViewModelOptions extends js.Object

  object BaseLayerPickerViewModelOptions extends BaseLayerPickerViewModelOptionsBuilder(noOpts)

  class BaseLayerPickerViewModelOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[BaseLayerPickerViewModelOptions, BaseLayerPickerViewModelOptionsBuilder](new BaseLayerPickerViewModelOptionsBuilder(_)) {
    def globe(v: Globe) = jsOpt("globe", v)

    def imageryProviderViewModels(v: Array[ProviderViewModel]) = jsOpt("imageryProviderViewModels", v)

    def selectedImageryProviderViewModel(v: ProviderViewModel) = jsOpt("selectedImageryProviderViewModel", v)

    def terrainProviderViewModels(v: Array[ProviderViewModel]) = jsOpt("terrainProviderViewModels", v)

    def selectedTerrainProviderViewModel(v: ProviderViewModel) = jsOpt("selectedTerrainProviderViewModel", v)

  }


  @JSName("Cesium.Options")
  @js.native
  trait ProviderViewModelOptions extends js.Object

  object ProviderViewModelOptions extends ProviderViewModelOptionsBuilder(noOpts)

  class ProviderViewModelOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ProviderViewModelOptions, ProviderViewModelOptionsBuilder](new ProviderViewModelOptionsBuilder(_)) {
    def name(v: String) = jsOpt("name", v)

    def tooltip(v: String) = jsOpt("tooltip", v)

    def iconUrl(v: String) = jsOpt("iconUrl", v)

    def creationFunction(v: ProviderViewModel.CreationFunction | Command) = jsOpt("creationFunction", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait GeocoderOptions extends js.Object

  object GeocoderOptions extends GeocoderOptionsBuilder(noOpts)

  class GeocoderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GeocoderOptions, GeocoderOptionsBuilder](new GeocoderOptionsBuilder(_)) {
    def container(v: Element | String) = jsOpt("container", v)

    def scene(v: Scene) = jsOpt("scene", v)

    def url(v: String) = jsOpt("url", v)

    def key(v: String) = jsOpt("key", v)

    def flightDuration(v: Double) = jsOpt("flightDuration", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait GeocoderViewModelOptions extends js.Object

  object GeocoderViewModelOptions extends GeocoderViewModelOptionsBuilder(noOpts)

  class GeocoderViewModelOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GeocoderViewModelOptions, GeocoderViewModelOptionsBuilder](new GeocoderViewModelOptionsBuilder(_)) {
    def flightDuration(v: Double) = jsOpt("flightDuration", v)

    def scene(v: Scene) = jsOpt("scene", v)

    def url(v: String) = jsOpt("url", v)

    def key(v: String) = jsOpt("key", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait NavigationHelpButtonOptions extends js.Object

  object NavigationHelpButtonOptions extends NavigationHelpButtonOptionsBuilder(noOpts)

  class NavigationHelpButtonOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[NavigationHelpButtonOptions, NavigationHelpButtonOptionsBuilder](new NavigationHelpButtonOptionsBuilder(_)) {
    def container(v: Element | String) = jsOpt("container", v)

    def instructionsInitiallyVisible(v: Boolean) = jsOpt("instructionsInitiallyVisible", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PerformanceWatchdogOptions extends js.Object

  object PerformanceWatchdogOptions extends PerformanceWatchdogOptionsBuilder(noOpts)

  class PerformanceWatchdogOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PerformanceWatchdogOptions, PerformanceWatchdogOptionsBuilder](new PerformanceWatchdogOptionsBuilder(_)) {
    def container(v: Element | String) = jsOpt("container", v)

    def scene(v: Scene) = jsOpt("scene", v)

    def lowFrameRateMessage(v: String) = jsOpt("lowFrameRateMessage", v)
  }


  @JSName("Cesium.Options")
  @js.native
  trait PerformanceWatchdogViewModelOptions extends js.Object

  object PerformanceWatchdogViewModelOptions extends PerformanceWatchdogViewModelOptionsBuilder(noOpts)

  class PerformanceWatchdogViewModelOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PerformanceWatchdogViewModelOptions, PerformanceWatchdogViewModelOptionsBuilder](new PerformanceWatchdogViewModelOptionsBuilder(_)) {
    def scene(v: Scene) = jsOpt("scene", v)

    def lowFrameRateMessage(v: String) = jsOpt("lowFrameRateMessage", v)
  }

  //------------------------------------------------------------------------
  //------------------------------------------------------------------------
  //------------------------------------------------------------------------

  /**
    * {String|Promise.<String>} options.url The URL of the data, or a promise for the URL.
    * {String} [options.responseType] The type of response.  This controls the type of item returned.
    * {String} [options.method='GET'] The HTTP method to use.
    * {String} [options.data] The data to send with the request, if any.
    * {Object} [options.headers] HTTP headers to send with the request, if any.
    * {String} [options.overrideMimeType] Overrides the MIME type returned by the server.
    */
  @JSName("Cesium.Options")
  @js.native
  trait WithXhrOptions extends js.Object

  object WithXhrOptions extends WithXhrOptionsBuilder(noOpts)

  class WithXhrOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[WithXhrOptions, WithXhrOptionsBuilder](new WithXhrOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def responseType(v: String) = jsOpt("responseType", v)

    def method(v: String) = jsOpt("method", v)

    def data(v: String) = jsOpt("data", v)

    def headers(v: Object) = jsOpt("headers", v)

    def overrideMimeType(v: String) = jsOpt("overrideMimeType", v)
  }

  /**
    * {Object} [options.parameters] Any extra query parameters to append to the URL.
    * {String} [options.callbackParameterName='callback'] The callback parameter name that the server expects.
    * {Proxy} [options.proxy] A proxy to use for the request. This object is expected to have a getURL function which returns the proxied URL, if needed.
    */
  @JSName("Cesium.Options")
  @js.native
  trait JsonpOptions extends js.Object

  object JsonpOptions extends JsonpOptionsBuilder(noOpts)

  class JsonpOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[JsonpOptions, JsonpOptionsBuilder](new JsonpOptionsBuilder(_)) {
    def parameters(v: Object) = jsOpt("parameters", v)

    def callbackParameterName(v: String) = jsOpt("callbackParameterName", v)

    def proxy(v: Proxy) = jsOpt("proxy", v)

  }

  @JSName("Cesium.Options")
  @js.native
  trait OpenStreetMapImageryProviderOptions extends js.Object

  object OpenStreetMapImageryProviderOptions extends OpenStreetMapImageryProviderOptionsBuilder(noOpts)

  class OpenStreetMapImageryProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[OpenStreetMapImageryProviderOptions, OpenStreetMapImageryProviderOptionsBuilder](new OpenStreetMapImageryProviderOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def fileExtension(v: String) = jsOpt("fileExtension", v)

    def proxy(v: Proxy) = jsOpt("proxy", v)

    def rectangle(v: Rectangle) = jsOpt("rectangle", v)

    def minimumLevel(v: Int) = jsOpt("minimumLevel", v)

    def maximumLevel(v: Int) = jsOpt("maximumLevel", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def credit(v: Credit | String) = jsOpt("credit", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait TangentSpaceDebugPrimitiveOptions extends js.Object

  object TangentSpaceDebugPrimitiveOptions extends TangentSpaceDebugPrimitiveOptionsBuilder(noOpts)

  class TangentSpaceDebugPrimitiveOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[TangentSpaceDebugPrimitiveOptions, TangentSpaceDebugPrimitiveOptionsBuilder](new TangentSpaceDebugPrimitiveOptionsBuilder(_)) {
    def geometry(v: Geometry) = jsOpt("geometry", v)

    def length(v: Double) = jsOpt("length", v)

    def modelMatrix(v: Matrix4) = jsOpt("modelMatrix", v)

  }

  @JSName("Cesium.Options")
  @js.native
  trait TileMapServiceImageryProviderOptions extends js.Object

  object TileMapServiceImageryProviderOptions extends TileMapServiceImageryProviderOptionsBuilder(noOpts)

  class TileMapServiceImageryProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[TileMapServiceImageryProviderOptions, TileMapServiceImageryProviderOptionsBuilder](new TileMapServiceImageryProviderOptionsBuilder(_)) {

    def url(v: String) = jsOpt("url", v)

    def fileExtension(v: String) = jsOpt("fileExtension", v)

    def proxy(v: Proxy) = jsOpt("proxy", v)

    def rectangle(v: Rectangle) = jsOpt("rectangle", v)

    def minimumLevel(v: Int) = jsOpt("minimumLevel", v)

    def maximumLevel(v: Int) = jsOpt("maximumLevel", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def credit(v: Credit | String) = jsOpt("credit", v)

    def tilingScheme(v: TilingScheme) = jsOpt("tilingScheme", v)

    def tileWidth(v: Int) = jsOpt("tileWidth", v)

    def tileHeight(v: Int) = jsOpt("tileHeight", v)

    def flipXY(v: Boolean) = jsOpt("flipXY", v)

  }

  @JSName("Cesium.Options")
  @js.native
  trait DragDropMixinOptions extends js.Object

  object DragDropMixinOptions extends DragDropMixinOptionsBuilder(noOpts)

  class DragDropMixinOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[DragDropMixinOptions, DragDropMixinOptionsBuilder](new DragDropMixinOptionsBuilder(_)) {
    def dropTarget(v: Element | String) = jsOpt("dropTarget", v)

    def clearOnDrop(v: Boolean) = jsOpt("clearOnDrop", v)

    def flyToOnDrop(v: Boolean) = jsOpt("flyToOnDrop", v)

    def proxy(v: Proxy) = jsOpt("proxy", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait DimensionsOptions extends js.Object

  object DimensionsOptions extends DimensionsOptionsBuilder(noOpts)

  class DimensionsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[DimensionsOptions, DimensionsOptionsBuilder](new DimensionsOptionsBuilder(_)) {
    def dimensions(v: Cartesian3) = jsOpt("dimensions", v)

    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)

  }

  @JSName("Cesium.Options")
  @js.native
  trait PositionsOptions extends js.Object

  object PositionsOptions extends PositionsOptionsBuilder(noOpts)

  class PositionsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PositionsOptions, PositionsOptionsBuilder](new PositionsOptionsBuilder(_)) {
    def positions(v: Array[Cartesian3]) = jsOpt("positions", v)

    def height(v: Double) = jsOpt("height", v)

    def extrudedHeight(v: Double) = jsOpt("extrudedHeight", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def granularity(v: Double) = jsOpt("granularity", v)

    def perPositionHeight(v: Boolean) = jsOpt("perPositionHeight", v)

  }

  @JSName("Cesium.Options")
  @js.native
  trait GeoJsonDataSourceOptions extends js.Object

  object GeoJsonDataSourceOptions extends GeoJsonDataSourceOptionsBuilder(noOpts)

  class GeoJsonDataSourceOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GeoJsonDataSourceOptions, GeoJsonDataSourceOptionsBuilder](new GeoJsonDataSourceOptionsBuilder(_)) {
    def sourceUri(v: String) = jsOpt("sourceUri", v)

    def markerSize(v: Int) = jsOpt("markerSize", v)

    def markerSymbol(v: String) = jsOpt("markerSymbol", v)

    def markerColor(v: Color) = jsOpt("markerColor", v)

    def stroke(v: Color) = jsOpt("stroke", v)

    def strokeWidth(v: Double) = jsOpt("strokeWidth", v)

    def fill(v: Color) = jsOpt("fill", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait KmlDataSourceOptions extends js.Object

  object KmlDataSourceOptions extends KmlDataSourceOptionsBuilder(noOpts)

  class KmlDataSourceOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[KmlDataSourceOptions, KmlDataSourceOptionsBuilder](new KmlDataSourceOptionsBuilder(_)) {
    def camera(v: Camera) = jsOpt("camera", v)

    def canvas(v: Canvas) = jsOpt("canvas", v)

    def proxy(v: Proxy) = jsOpt("proxy", v)

    def sourceUri(v: String) = jsOpt("sourceUri", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait CameraFlyToOptions extends js.Object

  object CameraFlyToOptions extends CameraFlyToOptionsBuilder(noOpts)

  class CameraFlyToOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CameraFlyToOptions, CameraFlyToOptionsBuilder](new CameraFlyToOptionsBuilder(_)) {
    def destination(v: Cartesian3 | Rectangle) = jsOpt("destination", v)

    def orientation(v: Object) = jsOpt("orientation", v)

    def duration(v: Double) = jsOpt("duration", v)

    def complete(v: Camera.FlightCompleteCallback) = jsOpt("complete", v)

    def cancel(v: Camera.FlightCancelledCallback) = jsOpt("cancel", v)

    def endTransform(v: Matrix4) = jsOpt("endTransform", v)

    def maximumHeight(v: Double) = jsOpt("maximumHeight", v)

    def easingFunction(v:	EasingFunction | EasingFunction.Callback) = jsOpt("easingFunction", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait CameraSetViewOptions extends js.Object

  object CameraSetViewOptions extends CameraSetViewOptionsBuilder(noOpts)

  class CameraSetViewOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CameraSetViewOptions, CameraSetViewOptionsBuilder](new CameraSetViewOptionsBuilder(_)) {
    def destination(v: Cartesian3 | Rectangle) = jsOpt("destination", v)

    def orientation(v: Object) = jsOpt("orientation", v)

    def duration(v: Double) = jsOpt("duration", v)

    def endTransform(v: Matrix4) = jsOpt("endTransform", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait CameraFlyToBoundingSphereOptions extends js.Object

  object CameraFlyToBoundingSphereOptions extends CameraFlyToBoundingSphereOptionsBuilder(noOpts)

  class CameraFlyToBoundingSphereOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CameraFlyToBoundingSphereOptions, CameraFlyToBoundingSphereOptionsBuilder](new CameraFlyToBoundingSphereOptionsBuilder(_)) {
    def duration(v: Double) = jsOpt("duration", v)

    def offset(v: HeadingPitchRange) = jsOpt("offset", v)

    def complete(v: Camera.FlightCompleteCallback) = jsOpt("complete", v)

    def cancel(v: Camera.FlightCancelledCallback) = jsOpt("cancel", v)

    def endTransform(v: Matrix4) = jsOpt("endTransform", v)

    def maximumHeight(v: Double) = jsOpt("maximumHeight", v)

    def easingFunction(v:	EasingFunction | EasingFunction.Callback) = jsOpt("easingFunction", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait ViewerOptions extends js.Object

  object ViewerOptions extends ViewerOptionsBuilder(noOpts)

  class ViewerOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ViewerOptions, ViewerOptionsBuilder](new ViewerOptionsBuilder(_)) {
    def animation(v: Boolean) = jsOpt("animation", v)

    def baseLayerPicker(v: Boolean) = jsOpt("baseLayerPicker", v)

    def fullscreenButton(v: Boolean) = jsOpt("fullscreenButton", v)

    def vrButton(v: Boolean) = jsOpt("vrButton", v)

    def geocoder(v: Boolean) = jsOpt("geocoder", v)

    def homeButton(v: Boolean) = jsOpt("homeButton", v)

    def infoBox(v: Boolean) = jsOpt("infoBox", v)

    def sceneModePicker(v: Boolean) = jsOpt("sceneModePicker", v)

    def selectionIndicator(v: Boolean) = jsOpt("selectionIndicator", v)

    def timeline(v: Boolean) = jsOpt("timeline", v)

    def navigationHelpButton(v: Boolean) = jsOpt("navigationHelpButton", v)

    def navigationInstructionsInitiallyVisible(v: Boolean) = jsOpt("navigationInstructionsInitiallyVisible", v)

    def scene3DOnly(v: Boolean) = jsOpt("scene3DOnly", v)

    def clock(v: Clock) = jsOpt("clock", v)

    def selectedImageryProviderViewModel(v: ProviderViewModel) = jsOpt("selectedImageryProviderViewModel", v)

    def imageryProviderViewModels(v: Array[ProviderViewModel]) = jsOpt("imageryProviderViewModels", v)

    def selectedTerrainProviderViewModel(v: ProviderViewModel) = jsOpt("selectedTerrainProviderViewModel", v)

    def terrainProviderViewModels(v: Array[ProviderViewModel]) = jsOpt("terrainProviderViewModels", v)

    def imageryProvider(v: ImageryProvider) = jsOpt("imageryProvider", v)

    def terrainProvider(v: TerrainProvider) = jsOpt("terrainProvider", v)

    def skyBox(v: SkyBox) = jsOpt("skyBox", v)

    def skyAtmosphere(v: SkyAtmosphere) = jsOpt("skyAtmosphere", v)

    def fullscreenElement(v: Element | String) = jsOpt("fullscreenElement", v)

    def useDefaultRenderLoop(v: Boolean) = jsOpt("useDefaultRenderLoop", v)

    def targetFrameRate(v: Int) = jsOpt("targetFrameRate", v)

    def showRenderLoopErrors(v: Boolean) = jsOpt("showRenderLoopErrors", v)

    def automaticallyTrackDataSourceClocks(v: Boolean) = jsOpt("automaticallyTrackDataSourceClocks", v)

    def contextOptions(v: Object) = jsOpt("contextOptions", v)

    def sceneMode(v: SceneMode) = jsOpt("sceneMode", v)

    def mapProjection(v: MapProjection) = jsOpt("mapProjection", v)

    def globe(v: Globe) = jsOpt("globe", v)

    def orderIndependentTranslucency(v: Boolean) = jsOpt("orderIndependentTranslucency", v)

    def creditContainer(v: Element | String) = jsOpt("creditContainer", v)

    def dataSources(v: DataSourceCollection) = jsOpt("dataSources", v)

    def terrainExaggeration(v: Double) = jsOpt("terrainExaggeration", v)

    def shadows(v: Boolean) = jsOpt("shadows", v)

    def terrainShadows(v: Boolean) = jsOpt("terrainShadows", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait ViewerFlyToOptions extends js.Object

  object ViewerFlyToOptions extends ViewerFlyToOptionsBuilder(noOpts)

  class ViewerFlyToOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ViewerFlyToOptions, ViewerFlyToOptionsBuilder](new ViewerFlyToOptionsBuilder(_)) {
    def duration(v: Double) = jsOpt("duration", v)

    def maximumHeight(v: Double) = jsOpt("maximumHeight", v)

    def offset(v: HeadingPitchRange) = jsOpt("offset", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait ImageryLayerOptions extends js.Object

  object ImageryLayerOptions extends ImageryLayerOptionsBuilder(noOpts)

  class ImageryLayerOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ImageryLayerOptions, ImageryLayerOptionsBuilder](new ImageryLayerOptionsBuilder(_)) {
    def rectangle(v: Rectangle) = jsOpt("rectangle", v)

    def alpha(v: Double | Function) = jsOpt("alpha", v)

    def brightness(v: Double | Function) = jsOpt("brightness", v)

    def contrast(v: Double | Function) = jsOpt("contrast", v)

    def hue(v: Double | Function) = jsOpt("hue", v)

    def saturation(v: Double | Function) = jsOpt("saturation", v)

    def gamma(v: Double | Function) = jsOpt("gamma", v)

    def show(v: Boolean) = jsOpt("show", v)

    def maximumAnisotropy(v: Double) = jsOpt("maximumAnisotropy", v)

    def minimumTerrainLevel(v: Double) = jsOpt("minimumTerrainLevel", v)

    def maximumTerrainLevel(v: Double) = jsOpt("maximumTerrainLevel", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait ModelAnimationCollectionAddOptions extends js.Object

  object ModelAnimationCollectionAddOptions extends ModelAnimationCollectionAddOptionsBuilder(noOpts)

  class ModelAnimationCollectionAddOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ModelAnimationCollectionAddOptions, ModelAnimationCollectionAddOptionsBuilder](new ModelAnimationCollectionAddOptionsBuilder(_)) {
    def name(v: String) = jsOpt("name", v)

    def startTime(v: JulianDate) = jsOpt("startTime", v)

    def delay(v: Double) = jsOpt("delay", v)

    def stopTime(v: JulianDate) = jsOpt("stopTime", v)

    def removeOnStop(v: Boolean) = jsOpt("removeOnStop", v)

    def speedup(v: Double) = jsOpt("speedup", v)

    def reverse(v: Boolean) = jsOpt("reverse", v)

    def show(v: Boolean) = jsOpt("show", v)

    def loop(v: ModelAnimationLoop) = jsOpt("loop", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait ModelAnimationCollectionAddAllOptions extends js.Object

  object ModelAnimationCollectionAddAllOptions extends ModelAnimationCollectionAddAllOptionsBuilder(noOpts)

  class ModelAnimationCollectionAddAllOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ModelAnimationCollectionAddAllOptions, ModelAnimationCollectionAddAllOptionsBuilder](new ModelAnimationCollectionAddAllOptionsBuilder(_)) {
    def startTime(v: JulianDate) = jsOpt("startTime", v)

    def delay(v: Double) = jsOpt("delay", v)

    def stopTime(v: JulianDate) = jsOpt("stopTime", v)

    def removeOnStop(v: Boolean) = jsOpt("removeOnStop", v)

    def speedup(v: Double) = jsOpt("speedup", v)

    def reverse(v: Boolean) = jsOpt("reverse", v)

    def show(v: Boolean) = jsOpt("show", v)

    def loop(v: ModelAnimationLoop) = jsOpt("loop", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait BaseLayerPickerOptions extends js.Object

  object BaseLayerPickerOptions extends BaseLayerPickerOptionsBuilder(noOpts)

  class BaseLayerPickerOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[BaseLayerPickerOptions, BaseLayerPickerOptionsBuilder](new BaseLayerPickerOptionsBuilder(_)) {
    def globe(v: Globe) = jsOpt("globe", v)

    def imageryProviderViewModels(v: Array[ProviderViewModel]) = jsOpt("imageryProviderViewModels", v)

    def selectedImageryProviderViewModel(v: ProviderViewModel) = jsOpt("selectedImageryProviderViewModel", v)

    def terrainProviderViewModels(v: Array[ProviderViewModel]) = jsOpt("terrainProviderViewModels", v)

    def selectedTerrainProviderViewModel(v: ProviderViewModel) = jsOpt("selectedTerrainProviderViewModel", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait LabelOptions extends js.Object

  object LabelOptions extends LabelOptionsBuilder(noOpts)

  class LabelOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LabelOptions, LabelOptionsBuilder](new LabelOptionsBuilder(_)) {

    def position(v: Cartesian3) = jsOpt("position", v)

    def text(v: Property) = jsOpt("text", v)

    def font(v: Property) = jsOpt("font", v)

    def style(v: Property) = jsOpt("style", v)

    def fillColor(v: Property) = jsOpt("fillColor", v)

    def outlineColor(v: Property) = jsOpt("outlineColor", v)

    def show(v: Property) = jsOpt("show", v)

    def horizontalOrigin(v: Property) = jsOpt("horizontalOrigin", v)

    def verticalOrigin(v: Property) = jsOpt("verticalOrigin", v)

    def eyeOffset(v: Property) = jsOpt("eyeOffset", v)

    def pixelOffset(v: Property) = jsOpt("pixelOffset", v)

  }

  @JSName("Cesium.Options")
  @js.native
  trait ToggleButtonViewModelOptions extends js.Object

  object ToggleButtonViewModelOptions extends ToggleButtonViewModelOptionsBuilder(noOpts)

  class ToggleButtonViewModelOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ToggleButtonViewModelOptions, ToggleButtonViewModelOptionsBuilder](new ToggleButtonViewModelOptionsBuilder(_)) {
    def toggled(v: Boolean) = jsOpt("toggled", v)

    def tooltip(v: String) = jsOpt("tooltip", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait VertexFormatOptions extends js.Object

  object VertexFormatOptions extends VertexFormatOptionsBuilder(noOpts)

  class VertexFormatOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[VertexFormatOptions, VertexFormatOptionsBuilder](new VertexFormatOptionsBuilder(_)) {
    def position(v: Cartesian3) = jsOpt("position", v)

    def st(v: Boolean) = jsOpt("st", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait CesiumWidgetOptions extends js.Object

  object CesiumWidgetOptions extends CesiumWidgetOptionsBuilder(noOpts)

  class CesiumWidgetOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CesiumWidgetOptions, CesiumWidgetOptionsBuilder](new CesiumWidgetOptionsBuilder(_)) {
    def clock(v: Clock) = jsOpt("clock", v)

    def imageryProvider(v: ImageryProvider) = jsOpt("imageryProvider", v)

    def terrainProvider(v: TerrainProvider) = jsOpt("terrainProvider", v)

    def skyBox(v: SkyBox) = jsOpt("skyBox", v)

    def skyAtmosphere(v: SkyAtmosphere) = jsOpt("skyAtmosphere", v)

    def sceneMode(v: SceneMode) = jsOpt("sceneMode", v)

    def scene3DOnly(v: Boolean) = jsOpt("scene3DOnly", v)

    def orderIndependentTranslucency(v: Boolean) = jsOpt("orderIndependentTranslucency", v)

    def mapProjection(v: MapProjection) = jsOpt("mapProjection", v)

    def globe(v: Globe) = jsOpt("globe", v)

    def useDefaultRenderLoop(v: Boolean) = jsOpt("useDefaultRenderLoop", v)

    def targetFrameRate(v: Int) = jsOpt("targetFrameRate", v)

    def showRenderLoopErrors(v: Boolean) = jsOpt("showRenderLoopErrors", v)

    def contextOptions(v: Object) = jsOpt("contextOptions", v)

    def creditContainer(v: Element | String) = jsOpt("creditContainer", v)

    def terrainExaggeration(v: Double) = jsOpt("terrainExaggeration", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait CzmlDataSourceOptions extends js.Object

  object CzmlDataSourceOptions extends CzmlDataSourceOptionsBuilder(noOpts)

  class CzmlDataSourceOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CzmlDataSourceOptions, CzmlDataSourceOptionsBuilder](new CzmlDataSourceOptionsBuilder(_)) {
    def sourceUri(v: String) = jsOpt("sourceUri", v)
  }

  @JSName("Cesium.Options")
  @js.native
  trait ShadowMapOptions extends js.Object

  object ShadowMapOptions extends ShadowMapOptionsBuilder(noOpts)

  class ShadowMapOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ShadowMapOptions, ShadowMapOptionsBuilder](new ShadowMapOptionsBuilder(_)) {
    // todo replace js.Any with Context
    def context(v: js.Any) = jsOpt("context", v)

    def lightCamera(v: Camera) = jsOpt("lightCamera", v)

    def enabled(v: Boolean) = jsOpt("enabled", v)

    def isPointLight(v: Boolean) = jsOpt("isPointLight", v)

    def pointLightRadius(v: Boolean) = jsOpt("pointLightRadius", v)

    def cascadesEnabled(v: Boolean) = jsOpt("cascadesEnabled", v)

    def numberOfCascades(v: Int) = jsOpt("numberOfCascades", v)

    def maximumDistance(v: Double) = jsOpt("maximumDistance", v)

    def size(v: Int) = jsOpt("size", v)

    def softShadows(v: Boolean) = jsOpt("softShadows", v)

    def darkness(v: Double) = jsOpt("darkness", v)

  }

  @JSName("Cesium.Options")
  @js.native
  trait InterpolationOptions extends js.Object

  object InterpolationOptions extends InterpolationOptionsBuilder(noOpts)

  class InterpolationOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[InterpolationOptions, InterpolationOptionsBuilder](new InterpolationOptionsBuilder(_)) {
    def interpolationAlgorithm(v: InterpolationAlgorithm) = jsOpt("interpolationAlgorithm", v)
    def interpolationDegree(v: Int) = jsOpt("interpolationDegree", v)
  }

}
