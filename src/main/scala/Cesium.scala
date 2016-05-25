/**
  * A Scala.js facade for Cesium.js "An open-source JavaScript library for world-class 3D globes and maps"
  *
  * Reference:  http://cesiumjs.org/ and https://cesiumjs.org/refdoc.html
  * Specifically Cesium-1.21 documentation/code (May 2016)
  *
  *
  * @author Ringo Wathelet
  *         Date: 22/05/16
  *         Version: 1
  */

package cesium {

  import cesium.Cesium.RenderState
  import org.querki.jsext.{JSOptionBuilder, OptMap, noOpts}
  import org.scalajs.dom.html.Canvas

  import scala.concurrent._
  import scala.scalajs.js
  import scala.scalajs.js.annotation._
  import scala.scalajs.js.{UndefOr, undefined, |}
  import org.scalajs.dom.{Blob, Document, Element}
  import org.scalajs.dom.raw.{HTMLCanvasElement, HTMLImageElement, HTMLVideoElement}
  import org.w3c.dom.html.{HTMLElement, HTMLIFrameElement}

  import scala.scalajs.js.Date
  import scala.scalajs.js.typedarray.{ArrayBuffer, Float32Array, Float64Array, Int16Array, Int8Array, TypedArray, Uint16Array, Uint32Array, Uint8Array}


  // -------------------------------------------------------------------------------------
  // -------------------------------------------------------------------------------------
  // -------------------------------------------------------------------------------------

  @js.native
  sealed trait CornerType extends js.Object

  @JSName("Cesium.CornerType")
  @js.native
  object CornerType extends js.Object {
    val BEVELED: Int = js.native
    val MITERED: Int = js.native
    val ROUNDED: Int = js.native

    @JSBracketAccess
    def apply(value: CornerType): Int = js.native
  }

  @js.native
  sealed trait Intersect extends js.Object

  @JSName("Cesium.Intersect")
  @js.native
  object Intersect extends js.Object {
    val INSIDE: Int = js.native // 1
    val INTERSECTING: Int = js.native // 0
    val OUTSIDE: Int = js.native // -1

    @JSBracketAccess
    def apply(value: Intersect): Int = js.native
  }

  @js.native
  sealed trait ClockStep extends js.Object

  @JSName("Cesium.ClockStep")
  @js.native
  object ClockStep extends js.Object {
    val SYSTEM_CLOCK: Int = js.native // 2
    val SYSTEM_CLOCK_MULTIPLIER: Int = js.native // 1
    val TICK_DEPENDENT: Int = js.native // 0

    @JSBracketAccess
    def apply(value: ClockStep): Int = js.native
  }

  @js.native
  sealed trait ClockRange extends js.Object

  @JSName("Cesium.ClockRange")
  @js.native
  object ClockRange extends js.Object {
    val CLAMPED: Int = js.native // 1
    val LOOP_STOP: Int = js.native // 2
    val UNBOUNDED: Int = js.native // 0

    @JSBracketAccess
    def apply(value: ClockRange): Int = js.native
  }

  @js.native
  sealed trait ComponentDatatype extends js.Object

  @JSName("Cesium.ComponentDatatype")
  @js.native
  object ComponentDatatype extends js.Object {
    val DOUBLE: Int = js.native
    val BYTE: Int = js.native
    val FLOAT: Int = js.native
    val SHORT: Int = js.native
    val UNSIGNED_BYTE: Int = js.native
    val UNSIGNED_SHORT: Int = js.native

    @JSBracketAccess
    def apply(value: ComponentDatatype): Int = js.native

    def createArrayBufferView(componentDatatype: ComponentDatatype,
                              buffer: ArrayBuffer, byteOffset: Int,
                              length: Int): Cesium.TypedArray = js.native

    def createTypedArray(componentDatatype: ComponentDatatype,
                         valuesOrLength: Int | Cesium.TypedArray): Cesium.TypedArray = js.native

    def fromTypedArray(array: Cesium.TypedArray): ComponentDatatype = js.native

    def getSizeInBytes(componentDatatype: ComponentDatatype): Int = js.native

    def validate(componentDatatype: ComponentDatatype): Boolean = js.native

  }

  @js.native
  sealed trait PrimitiveType extends js.Object

  @JSName("Cesium.PrimitiveType")
  @js.native
  object PrimitiveType extends js.Object {
    val LINE_LOOP: Int = js.native
    val LINE_STRIP: Int = js.native
    val LINES: Int = js.native
    val POINTS: Int = js.native
    val TRIANGLE_FAN: Int = js.native
    val TRIANGLE_STRIP: Int = js.native
    val TRIANGLE: Int = js.native

    @JSBracketAccess
    def apply(value: PrimitiveType): Int = js.native
  }

  @js.native
  sealed trait TimeStandard extends js.Object

  @JSName("Cesium.TimeStandard")
  @js.native
  object TimeStandard extends js.Object {
    val UTC: Int = js.native // 0
    val TAI: Int = js.native // 1

    @JSBracketAccess
    def apply(value: TimeStandard): Int = js.native
  }

  @js.native
  sealed trait ReferenceFrame extends js.Object

  @JSName("Cesium.ReferenceFrame")
  @js.native
  object ReferenceFrame extends js.Object {
    val FIXED: Int = js.native // 0
    val INERTIAL: Int = js.native // 1

    @JSBracketAccess
    def apply(value: ReferenceFrame): Int = js.native
  }

  @js.native
  sealed trait ExtrapolationType extends js.Object

  @JSName("Cesium.ExtrapolationType")
  @js.native
  object ExtrapolationType extends js.Object {
    val EXTRAPOLATE: Int = js.native
    val HOLD: Int = js.native
    val NONE: Int = js.native

    @JSBracketAccess
    def apply(value: ExtrapolationType): Int = js.native
  }

  // todo verify
  @js.native
  sealed trait InterpolationAlgorithm extends js.Object
  @JSName("Cesium.InterpolationAlgorithm")
  @js.native
  object InterpolationAlgorithm extends js.Object {
    val `type`: String = js.native
    val HOLD: Int = js.native
    val NONE: Int = js.native

    def apply(value: InterpolationAlgorithm): Int = js.native

    def getRequiredDataPoints(degree: Int): Int = js.native

    def interpolate(x: Double, xTable: Array[Double], yTable: Array[Double], yStride: Array[Int], inputOrder: Int, outputOrder: Int, result: Array[Double]): Array[Double] = js.native

    def interpolateOrderZero(x: Double, xTable: Array[Double], yTable: Array[Double], yStride: Array[Int], result: Array[Double]): Array[Double] = js.native
  }

  // todo not yet implemented in Cesium.js
  //@js.native
  @ScalaJSDefined
  sealed trait Frustum extends js.Object


  @js.native
  sealed trait Packable extends js.Object

  @JSName("Cesium.Packable")
  @js.native
  object Packable extends js.Object {
    val packedLength: Int = js.native

    def pack(value: js.Object, array: Array[Int], startingIndex: Int): Unit = js.native

    def unpack(array: Array[Int], startingIndex: Int, result: js.Object): Int = js.native
  }

  @js.native
  sealed trait HeightReference extends js.Object

  @JSName("Cesium.HeightReference")
  @js.native
  object HeightReference extends js.Object {
    val CLAMP_TO_GROUND: Int = js.native
    val NONE: Int = js.native
    val RELATIVE_TO_GROUND: Int = js.native

    @JSBracketAccess
    def apply(value: HeightReference): Int = js.native
  }

  @js.native
  sealed trait VerticalOrigin extends js.Object

  @JSName("Cesium.VerticalOrigin")
  @js.native
  object VerticalOrigin extends js.Object {
    val BOTTOM: Int = js.native
    val CENTER: Int = js.native
    val TOP: Int = js.native

    @JSBracketAccess
    def apply(value: VerticalOrigin): Int = js.native
  }

  @js.native
  sealed trait HorizontalOrigin extends js.Object

  @JSName("Cesium.HorizontalOrigin")
  @js.native
  object HorizontalOrigin extends js.Object {
    val CENTER: Int = js.native
    val LEFT: Int = js.native
    val RIGHT: Int = js.native

    @JSBracketAccess
    def apply(value: HorizontalOrigin): Int = js.native
  }

  @js.native
  sealed trait BingMapsStyle extends js.Object

  @JSName("Cesium.BingMapsStyle")
  @js.native
  object BingMapsStyle extends js.Object {
    val AERIAL: String = js.native
    val AERIAL_WITH_LABELS: String = js.native
    val COLLINS_BART: String = js.native
    val ORDNANCE_SURVEY: String = js.native
    val ROAD: String = js.native

    def apply(value: BingMapsStyle): String = js.native
  }

  @js.native
  sealed trait CameraEventType extends js.Object

  @JSName("Cesium.CameraEventType")
  @js.native
  object CameraEventType extends js.Object {
    val LEFT_DRAG: Int = js.native
    val MIDDLE_DRAG: Int = js.native
    val PINCH: Int = js.native
    val RIGHT_DRAG: Int = js.native
    val WHEEL: Int = js.native

    @JSBracketAccess
    def apply(value: CameraEventType): Int = js.native
  }

  @js.native
  sealed trait KeyboardEventModifier extends js.Object

  @JSName("Cesium.KeyboardEventModifier")
  @js.native
  object KeyboardEventModifier extends js.Object {
    val ALT: Int = js.native
    val CTRL: Int = js.native
    val SHIFT: Int = js.native

    @JSBracketAccess
    def apply(value: KeyboardEventModifier): Int = js.native
  }

  @js.native
  sealed trait LabelStyle extends js.Object

  @JSName("Cesium.LabelStyle")
  @js.native
  object LabelStyle extends js.Object {
    val FILL: Int = js.native
    val FILL_AND_OUTLINE: Int = js.native
    val OUTLINE: Int = js.native

    @JSBracketAccess
    def apply(value: LabelStyle): Int = js.native
  }

  @js.native
  sealed trait MaterialAppearanceMaterialSupport extends js.Object

  // todo
  @JSName("MaterialAppearance.MaterialSupport")
  @js.native
  object MaterialAppearanceMaterialSupport extends js.Object {
    val BASIC: js.Object = js.native
    val TEXTURED: js.Object = js.native
    val ALL: js.Object = js.native

    def apply(value: MaterialAppearanceMaterialSupport): js.Object = js.native
  }

  @js.native
  sealed trait ModelAnimationLoop extends js.Object

  @JSName("Cesium.ModelAnimationLoop")
  @js.native
  object ModelAnimationLoop extends js.Object {
    val MIRRORED_REPEAT: Int = js.native
    val NONE: Int = js.native
    val REPEAT: Int = js.native

    @JSBracketAccess
    def apply(value: ModelAnimationLoop): Int = js.native
  }

  @js.native
  sealed trait SceneMode extends js.Object

  @JSName("Cesium.SceneMode")
  @js.native
  object SceneMode extends js.Object {
    val COLUMBUS_VIEW: Int = js.native
    val MORPHING: Int = js.native
    val SCENE2D: Int = js.native
    val SCENE3D: Int = js.native

    @JSBracketAccess
    def apply(value: SceneMode): Int = js.native

    def getMorphTime(value: SceneMode): Int = js.native
  }

  // -------------------------------------------------------------------------------------
  // -------------------------------------------------------------------------------------
  // -------------------------------------------------------------------------------------

  @js.native
  trait Proxy extends js.Object {
    def getURL(resource: String): String = js.native
  }

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

  @js.native
  @JSName("Cesium.ArcGisImageServerTerrainProvider")
  class ArcGisImageServerTerrainProvider protected() extends js.Object {
    def this(options: ArcGisImageServerTerrainProviderOptions) = this()

    var errorEvent: Event = js.native
    var credit: Credit = js.native
    var tilingScheme: GeographicTilingScheme = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var hasWaterMask: Boolean = js.native
    var hasVertexNormals: Boolean = js.native

    def requestTileGeometry(x: Double, y: Double, level: Double): Promise[TerrainData] | Unit = js.native

    def getLevelMaximumGeometricError(level: Double): Double = js.native

    def getTileDataAvailable(x: Double, y: Double, level: Double): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.AssociativeArray")
  class AssociativeArray extends js.Object {
    var length: Double = js.native
    var values: js.Array[js.Any] = js.native

    def contains(key: String | Double): Boolean = js.native

    def set(key: String | Double, value: js.Any): js.Dynamic = js.native

    def get(key: String | Double): js.Dynamic = js.native

    def remove(key: String | Double): Boolean = js.native

    def removeAll(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.AxisAlignedBoundingBox")
  class AxisAlignedBoundingBox protected() extends js.Object {
    def this(minimum: Cartesian3 = ???, maximum: Cartesian3 = ???, center: Cartesian3 = ???) = this()

    var minimum: Cartesian3 = js.native
    var maximum: Cartesian3 = js.native
    var center: Cartesian3 = js.native

    def clone(result: AxisAlignedBoundingBox = ???): AxisAlignedBoundingBox = js.native

    def intersectPlane(plane: Plane): Intersect = js.native

    def equals(right: AxisAlignedBoundingBox = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.AxisAlignedBoundingBox")
  object AxisAlignedBoundingBox extends js.Object {
    def fromPoints(positions: js.Array[Cartesian3], result: AxisAlignedBoundingBox = ???): AxisAlignedBoundingBox = js.native

    def clone(box: AxisAlignedBoundingBox, result: AxisAlignedBoundingBox = ???): AxisAlignedBoundingBox = js.native

    def equals(left: AxisAlignedBoundingBox = ???, right: AxisAlignedBoundingBox = ???): Boolean = js.native

    def intersectPlane(box: AxisAlignedBoundingBox, plane: Plane): Intersect = js.native
  }

  @js.native
  @JSName("Cesium.BoundingRectangle")
  class BoundingRectangle protected() extends js.Object {
    def this(x: Double = ???, y: Double = ???, width: Double = ???, height: Double = ???) = this()

    var x: Double = js.native
    var y: Double = js.native
    var width: Double = js.native
    var height: Double = js.native

    def clone(result: BoundingRectangle = ???): BoundingRectangle = js.native

    def intersect(right: BoundingRectangle): Intersect = js.native

    def equals(right: BoundingRectangle = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.BoundingRectangle")
  object BoundingRectangle extends js.Object {
    def fromPoints(positions: js.Array[Cartesian2], result: BoundingRectangle = ???): BoundingRectangle = js.native

    def fromRectangle(rectangle: Rectangle, projection: js.Any = ???, result: BoundingRectangle = ???): BoundingRectangle = js.native

    def clone(rectangle: BoundingRectangle, result: BoundingRectangle = ???): BoundingRectangle = js.native

    def union(left: BoundingRectangle, right: BoundingRectangle, result: BoundingRectangle = ???): BoundingRectangle = js.native

    def expand(rectangle: BoundingRectangle, point: Cartesian2, result: BoundingRectangle = ???): BoundingRectangle = js.native

    def intersect(left: BoundingRectangle, right: BoundingRectangle): Intersect = js.native

    def equals(left: BoundingRectangle = ???, right: BoundingRectangle = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.BoundingSphere")
  class BoundingSphere protected() extends js.Object {
    def this(center: Cartesian3 = ???, radius: Double = ???) = this()

    var center: Cartesian3 = js.native
    var radius: Double = js.native

    def intersectPlane(plane: Plane): Intersect = js.native

    def distanceSquaredTo(cartesian: Cartesian3): Double = js.native

    def computePlaneDistances(position: Cartesian3, direction: Cartesian3, result: Interval = ???): Interval = js.native

    def isOccluded(occluder: Occluder): Boolean = js.native

    def equals(right: BoundingSphere = ???): Boolean = js.native

    def clone(result: BoundingSphere = ???): BoundingSphere = js.native
  }

  @js.native
  @JSName("Cesium.BoundingSphere")
  object BoundingSphere extends js.Object {
    var packedLength: Double = js.native

    def fromPoints(positions: js.Array[Cartesian3], result: BoundingSphere = ???): BoundingSphere = js.native

    def fromRectangle2D(rectangle: Rectangle, projection: js.Any = ???, result: BoundingSphere = ???): BoundingSphere = js.native

    def fromRectangleWithHeights2D(rectangle: Rectangle, projection: js.Any = ???, minimumHeight: Double = ???, maximumHeight: Double = ???, result: BoundingSphere = ???): BoundingSphere = js.native

    def fromRectangle3D(rectangle: Rectangle, ellipsoid: Ellipsoid = ???, surfaceHeight: Double = ???, result: BoundingSphere = ???): BoundingSphere = js.native

    def fromVertices(positions: js.Array[Double], center: Cartesian3 = ???, stride: Double = ???, result: BoundingSphere = ???): BoundingSphere = js.native

    def fromEncodedCartesianVertices(positionsHigh: js.Array[Double], positionsLow: js.Array[Double], result: BoundingSphere = ???): BoundingSphere = js.native

    def fromCornerPoints(corner: Cartesian3 = ???, oppositeCorner: Cartesian3 = ???, result: BoundingSphere = ???): BoundingSphere = js.native

    def fromEllipsoid(ellipsoid: Ellipsoid, result: BoundingSphere = ???): BoundingSphere = js.native

    def fromBoundingSpheres(boundingSpheres: js.Array[BoundingSphere], result: BoundingSphere = ???): BoundingSphere = js.native

    def fromOrientedBoundingBox(orientedBoundingBox: OrientedBoundingBox, result: BoundingSphere = ???): BoundingSphere = js.native

    def clone(sphere: BoundingSphere, result: BoundingSphere = ???): BoundingSphere = js.native

    def pack(value: BoundingSphere, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: BoundingSphere = ???): BoundingSphere = js.native

    def union(left: BoundingSphere, right: BoundingSphere, result: BoundingSphere = ???): BoundingSphere = js.native

    def expand(sphere: BoundingSphere, point: Cartesian3, result: BoundingSphere = ???): BoundingSphere = js.native

    def intersectPlane(sphere: BoundingSphere, plane: Plane): Intersect = js.native

    def transform(sphere: BoundingSphere, transform: Matrix4, result: BoundingSphere = ???): BoundingSphere = js.native

    def distanceSquaredTo(sphere: BoundingSphere, cartesian: Cartesian3): Double = js.native

    def transformWithoutScale(sphere: BoundingSphere, transform: Matrix4, result: BoundingSphere = ???): BoundingSphere = js.native

    def computePlaneDistances(sphere: BoundingSphere, position: Cartesian3, direction: Cartesian3, result: Interval = ???): Interval = js.native

    def projectTo2D(sphere: BoundingSphere, projection: js.Any = ???, result: BoundingSphere = ???): BoundingSphere = js.native

    def isOccluded(sphere: BoundingSphere, occluder: Occluder): Boolean = js.native

    def equals(left: BoundingSphere = ???, right: BoundingSphere = ???): Boolean = js.native
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

  @js.native
  @JSName("Cesium.BoxGeometry")
  class BoxGeometry protected() extends js.Object {
    def this(options: BoxGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.BoxGeometry")
  object BoxGeometry extends js.Object {
    var packedLength: Double = js.native

    def fromDimensions(options: js.Any): BoxGeometry = js.native

    def fromAxisAlignedBoundingBox(boundingBox: AxisAlignedBoundingBox): BoxGeometry = js.native

    def pack(value: BoxGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: BoxGeometry = ???): BoxGeometry = js.native

    def createGeometry(boxGeometry: BoxGeometry): Geometry | Unit = js.native
  }
  @JSName("Cesium.Options")
  @js.native
  trait BoxOutlineGeometryOptions extends js.Object

  object BoxOutlineGeometryOptions extends BoxOutlineGeometryOptionsBuilder(noOpts)

  class BoxOutlineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[BoxOutlineGeometryOptions, BoxOutlineGeometryOptionsBuilder](new BoxOutlineGeometryOptionsBuilder(_)) {

    def minimum(v: Cartesian3) = jsOpt("minimum", v)
    def maximum(v: Cartesian3) = jsOpt("maximum", v)

  }
  @js.native
  @JSName("Cesium.BoxOutlineGeometry")
  class BoxOutlineGeometry protected() extends js.Object {
    def this(options: BoxOutlineGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.BoxOutlineGeometry")
  object BoxOutlineGeometry extends js.Object {
    var packedLength: Double = js.native

    def fromDimensions(dimensions: Option[Cartesian3]): BoxOutlineGeometry = js.native

    def fromAxisAlignedBoundingBox(boundingBox: AxisAlignedBoundingBox): BoxOutlineGeometry = js.native

    def pack(value: BoxOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: BoxOutlineGeometry = ???): BoxOutlineGeometry = js.native

    def createGeometry(boxGeometry: BoxOutlineGeometry): Geometry | Unit = js.native
  }

  @js.native
  @JSName("Cesium.Cartesian2")
  class Cartesian2 protected() extends js.Object {
    def this(x: Double = ???, y: Double = ???) = this()

    var x: Double = js.native
    var y: Double = js.native

    def clone(result: Cartesian2 = ???): Cartesian2 = js.native

    def equals(right: Cartesian2 = ???): Boolean = js.native

    def equalsEpsilon(right: Cartesian2, relativeEpsilon: Double, absoluteEpsilon: Double = ???): Boolean = js.native

    override def toString(): String = js.native
  }

  @js.native
  @JSName("Cesium.Cartesian2")
  object Cartesian2 extends js.Object {
    var packedLength: Double = js.native
    var ZERO: Cartesian2 = js.native
    var UNIT_X: Cartesian2 = js.native
    var UNIT_Y: Cartesian2 = js.native

    def fromElements(x: Double, y: Double, result: Cartesian2 = ???): Cartesian2 = js.native

    def clone(cartesian: Cartesian2, result: Cartesian2 = ???): Cartesian2 = js.native

    def fromCartesian3(cartesian: Cartesian3, result: Cartesian2 = ???): Cartesian2 = js.native

    def fromCartesian4(cartesian: Cartesian4, result: Cartesian2 = ???): Cartesian2 = js.native

    def pack(value: Cartesian2, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: Cartesian2 = ???): Cartesian2 = js.native

    def fromArray(array: js.Array[Double], startingIndex: Double = ???, result: Cartesian2 = ???): Cartesian2 = js.native

    def maximumComponent(cartesian: Cartesian2): Double = js.native

    def minimumComponent(cartesian: Cartesian2): Double = js.native

    def minimumByComponent(first: Cartesian2, second: Cartesian2, result: Cartesian2): Cartesian2 = js.native

    def maximumByComponent(first: Cartesian2, second: Cartesian2, result: Cartesian2): Cartesian2 = js.native

    def magnitudeSquared(cartesian: Cartesian2): Double = js.native

    def magnitude(cartesian: Cartesian2): Double = js.native

    def distance(left: Cartesian2, right: Cartesian2): Double = js.native

    def distanceSquared(left: Cartesian2, right: Cartesian2): Double = js.native

    def normalize(cartesian: Cartesian2, result: Cartesian2): Cartesian2 = js.native

    def dot(left: Cartesian2, right: Cartesian2): Double = js.native

    def multiplyComponents(left: Cartesian2, right: Cartesian2, result: Cartesian2): Cartesian2 = js.native

    def add(left: Cartesian2, right: Cartesian2, result: Cartesian2): Cartesian2 = js.native

    def subtract(left: Cartesian2, right: Cartesian2, result: Cartesian2): Cartesian2 = js.native

    def multiplyByScalar(cartesian: Cartesian2, scalar: Double, result: Cartesian2): Cartesian2 = js.native

    def divideByScalar(cartesian: Cartesian2, scalar: Double, result: Cartesian2): Cartesian2 = js.native

    def negate(cartesian: Cartesian2, result: Cartesian2): Cartesian2 = js.native

    def abs(cartesian: Cartesian2, result: Cartesian2): Cartesian2 = js.native

    def lerp(start: Cartesian2, end: Cartesian2, t: Double, result: Cartesian2): Cartesian2 = js.native

    def angleBetween(left: Cartesian2, right: Cartesian2): Double = js.native

    def mostOrthogonalAxis(cartesian: Cartesian2, result: Cartesian2): Cartesian2 = js.native

    def equals(left: Cartesian2 = ???, right: Cartesian2 = ???): Boolean = js.native

    def equalsEpsilon(left: Cartesian2, right: Cartesian2, relativeEpsilon: Double, absoluteEpsilon: Double = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.Cartesian3")
  class Cartesian3 protected() extends js.Object {
    def this(x: Double = ???, y: Double = ???, z: Double = ???) = this()

    var x: Double = js.native
    var y: Double = js.native
    var z: Double = js.native

    def clone(result: Cartesian3 = ???): Cartesian3 = js.native

    def equals(right: Cartesian3 = ???): Boolean = js.native

    def equalsEpsilon(right: Cartesian3, relativeEpsilon: Double, absoluteEpsilon: Double = ???): Boolean = js.native

    override def toString(): String = js.native
  }

  @js.native
  @JSName("Cesium.Cartesian3")
  object Cartesian3 extends js.Object {
    var packedLength: Double = js.native
    var ZERO: Cartesian3 = js.native
    var UNIT_X: Cartesian3 = js.native
    var UNIT_Y: Cartesian3 = js.native
    var UNIT_Z: Cartesian3 = js.native

    def fromSpherical(spherical: Spherical, result: Cartesian3 = ???): Cartesian3 = js.native

    def fromElements(x: Double, y: Double, z: Double, result: Cartesian3 = ???): Cartesian3 = js.native

    def clone(cartesian: Cartesian3, result: Cartesian3 = ???): Cartesian3 = js.native

    def fromCartesian4(cartesian: Cartesian4, result: Cartesian3 = ???): Cartesian3 = js.native

    def pack(value: Cartesian3, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: Cartesian3 = ???): Cartesian3 = js.native

    def fromArray(array: js.Array[Double], startingIndex: Double = ???, result: Cartesian3 = ???): Cartesian3 = js.native

    def maximumComponent(cartesian: Cartesian3): Double = js.native

    def minimumComponent(cartesian: Cartesian3): Double = js.native

    def minimumByComponent(first: Cartesian3, second: Cartesian3, result: Cartesian3): Cartesian3 = js.native

    def maximumByComponent(first: Cartesian3, second: Cartesian3, result: Cartesian3): Cartesian3 = js.native

    def magnitudeSquared(cartesian: Cartesian3): Double = js.native

    def magnitude(cartesian: Cartesian3): Double = js.native

    def distance(left: Cartesian3, right: Cartesian3): Double = js.native

    def distanceSquared(left: Cartesian3, right: Cartesian3): Double = js.native

    def normalize(cartesian: Cartesian3, result: Cartesian3): Cartesian3 = js.native

    def dot(left: Cartesian3, right: Cartesian3): Double = js.native

    def multiplyComponents(left: Cartesian3, right: Cartesian3, result: Cartesian3): Cartesian3 = js.native

    def add(left: Cartesian3, right: Cartesian3, result: Cartesian3): Cartesian3 = js.native

    def subtract(left: Cartesian3, right: Cartesian3, result: Cartesian3): Cartesian3 = js.native

    def multiplyByScalar(cartesian: Cartesian3, scalar: Double, result: Cartesian3): Cartesian3 = js.native

    def divideByScalar(cartesian: Cartesian3, scalar: Double, result: Cartesian3): Cartesian3 = js.native

    def negate(cartesian: Cartesian3, result: Cartesian3): Cartesian3 = js.native

    def abs(cartesian: Cartesian3, result: Cartesian3): Cartesian3 = js.native

    def lerp(start: Cartesian3, end: Cartesian3, t: Double, result: Cartesian3): Cartesian3 = js.native

    def angleBetween(left: Cartesian3, right: Cartesian3): Double = js.native

    def mostOrthogonalAxis(cartesian: Cartesian3, result: Cartesian3): Cartesian3 = js.native

    def equals(left: Cartesian3 = ???, right: Cartesian3 = ???): Boolean = js.native

    def equalsEpsilon(left: Cartesian3, right: Cartesian3, relativeEpsilon: Double, absoluteEpsilon: Double = ???): Boolean = js.native

    def cross(left: Cartesian3, right: Cartesian3, result: Cartesian3): Cartesian3 = js.native

    def fromDegrees(longitude: Double, latitude: Double, height: Double = ???, ellipsoid: Ellipsoid = ???, result: Cartesian3 = ???): Cartesian3 = js.native

    def fromRadians(longitude: Double, latitude: Double, height: Double = ???, ellipsoid: Ellipsoid = ???, result: Cartesian3 = ???): Cartesian3 = js.native

    def fromDegreesArray(coordinates: js.Array[Double], ellipsoid: Ellipsoid = ???, result: js.Array[Cartesian3] = ???): js.Array[Cartesian3] = js.native

    def fromRadiansArray(coordinates: js.Array[Double], ellipsoid: Ellipsoid = ???, result: js.Array[Cartesian3] = ???): js.Array[Cartesian3] = js.native

    def fromDegreesArrayHeights(coordinates: js.Array[Double], ellipsoid: Ellipsoid = ???, result: js.Array[Cartesian3] = ???): js.Array[Cartesian3] = js.native

    def fromRadiansArrayHeights(coordinates: js.Array[Double], ellipsoid: Ellipsoid = ???, result: js.Array[Cartesian3] = ???): js.Array[Cartesian3] = js.native
  }

  @js.native
  @JSName("Cesium.Cartesian4")
  class Cartesian4 protected() extends js.Object {
    def this(x: Double = ???, y: Double = ???, z: Double = ???, w: Double = ???) = this()

    var x: Double = js.native
    var y: Double = js.native
    var z: Double = js.native
    var w: Double = js.native

    def clone(result: Cartesian4 = ???): Cartesian4 = js.native

    def equals(right: Cartesian4 = ???): Boolean = js.native

    def equalsEpsilon(right: Cartesian4, relativeEpsilon: Double, absoluteEpsilon: Double = ???): Boolean = js.native

    override def toString(): String = js.native
  }

  @js.native
  @JSName("Cesium.Cartesian4")
  object Cartesian4 extends js.Object {
    var packedLength: Double = js.native
    var ZERO: Cartesian4 = js.native
    var UNIT_X: Cartesian4 = js.native
    var UNIT_Y: Cartesian4 = js.native
    var UNIT_Z: Cartesian4 = js.native
    var UNIT_W: Cartesian4 = js.native

    def fromElements(x: Double, y: Double, z: Double, w: Double, result: Cartesian4 = ???): Cartesian4 = js.native

    def fromColor(color: Color, result: Cartesian4 = ???): Cartesian4 = js.native

    def clone(cartesian: Cartesian4, result: Cartesian4 = ???): Cartesian4 = js.native

    def pack(value: Cartesian4, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: Cartesian4 = ???): Cartesian4 = js.native

    def fromArray(array: js.Array[Double], startingIndex: Double = ???, result: Cartesian4 = ???): Cartesian4 = js.native

    def maximumComponent(cartesian: Cartesian4): Double = js.native

    def minimumComponent(cartesian: Cartesian4): Double = js.native

    def minimumByComponent(first: Cartesian4, second: Cartesian4, result: Cartesian4): Cartesian4 = js.native

    def maximumByComponent(first: Cartesian4, second: Cartesian4, result: Cartesian4): Cartesian4 = js.native

    def magnitudeSquared(cartesian: Cartesian4): Double = js.native

    def magnitude(cartesian: Cartesian4): Double = js.native

    def distance(left: Cartesian4, right: Cartesian4): Double = js.native

    def distanceSquared(left: Cartesian4, right: Cartesian4): Double = js.native

    def normalize(cartesian: Cartesian4, result: Cartesian4): Cartesian4 = js.native

    def dot(left: Cartesian4, right: Cartesian4): Double = js.native

    def multiplyComponents(left: Cartesian4, right: Cartesian4, result: Cartesian4): Cartesian4 = js.native

    def add(left: Cartesian4, right: Cartesian4, result: Cartesian4): Cartesian4 = js.native

    def subtract(left: Cartesian4, right: Cartesian4, result: Cartesian4): Cartesian4 = js.native

    def multiplyByScalar(cartesian: Cartesian4, scalar: Double, result: Cartesian4): Cartesian4 = js.native

    def divideByScalar(cartesian: Cartesian4, scalar: Double, result: Cartesian4): Cartesian4 = js.native

    def negate(cartesian: Cartesian4, result: Cartesian4): Cartesian4 = js.native

    def abs(cartesian: Cartesian4, result: Cartesian4): Cartesian4 = js.native

    def lerp(start: Cartesian4, end: Cartesian4, t: Double, result: Cartesian4): Cartesian4 = js.native

    def mostOrthogonalAxis(cartesian: Cartesian4, result: Cartesian4): Cartesian4 = js.native

    def equals(left: Cartesian4 = ???, right: Cartesian4 = ???): Boolean = js.native

    def equalsEpsilon(left: Cartesian4, right: Cartesian4, relativeEpsilon: Double, absoluteEpsilon: Double = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.Cartographic")
  class Cartographic protected() extends js.Object {
    def this(longitude: Double = ???, latitude: Double = ???, height: Double = ???) = this()

    var longitude: Double = js.native
    var latitude: Double = js.native
    var height: Double = js.native

    def clone(result: Cartographic = ???): Cartographic = js.native

    def equals(right: Cartographic = ???): Boolean = js.native

    def equalsEpsilon(right: Cartographic, epsilon: Double): Boolean = js.native

    override def toString(): String = js.native
  }

  @js.native
  @JSName("Cesium.Cartographic")
  object Cartographic extends js.Object {
    var ZERO: Cartographic = js.native

    def fromRadians(longitude: Double, latitude: Double, height: Double = ???, result: Cartographic = ???): Cartographic = js.native

    def fromDegrees(longitude: Double, latitude: Double, height: Double = ???, result: Cartographic = ???): Cartographic = js.native

    def fromCartesian(cartesian: Cartesian3, ellipsoid: Ellipsoid = ???, result: Cartographic = ???): Cartographic = js.native

    def clone(cartographic: Cartographic, result: Cartographic = ???): Cartographic = js.native

    def equals(left: Cartographic = ???, right: Cartographic = ???): Boolean = js.native

    def equalsEpsilon(left: Cartographic, right: Cartographic, epsilon: Double): Boolean = js.native
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
  @js.native
  @JSName("Cesium.CatmullRomSpline")
  class CatmullRomSpline protected() extends js.Object {
    def this(options: CatmullRomSplineOptions) = this()

    var times: js.Array[Double] = js.native
    var points: js.Array[Cartesian3] = js.native
    var firstTangent: Cartesian3 = js.native
    var lastTangent: Cartesian3 = js.native

    def findTimeInterval(time: Double): Double = js.native

    def evaluate(time: Double, result: Cartesian3 = ???): Cartesian3 = js.native
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
  @js.native
  @JSName("Cesium.CesiumTerrainProvider")
  class CesiumTerrainProvider protected() extends js.Object {
    def this(options: CesiumTerrainProviderOptions) = this()

    var errorEvent: Event = js.native
    var credit: Credit = js.native
    var tilingScheme: GeographicTilingScheme = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var hasWaterMask: Boolean = js.native
    var hasVertexNormals: Boolean = js.native
    var requestVertexNormals: Boolean = js.native
    var requestWaterMask: Boolean = js.native

    def requestTileGeometry(x: Double, y: Double, level: Double, throttleRequests: Boolean = ???): Promise[TerrainData] | Unit = js.native

    def getLevelMaximumGeometricError(level: Double): Double = js.native

    def getTileDataAvailable(x: Double, y: Double, level: Double): Boolean = js.native
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
  @js.native
  @JSName("Cesium.CircleGeometry")
  class CircleGeometry protected() extends js.Object {
    def this(options: CircleGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.CircleGeometry")
  object CircleGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: CircleGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: CircleGeometry = ???): CircleGeometry = js.native

    def createGeometry(circleGeometry: CircleGeometry): Geometry | Unit = js.native
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
  @js.native
  @JSName("Cesium.CircleOutlineGeometry")
  class CircleOutlineGeometry protected() extends js.Object {
    def this(options: CircleOutlineGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.CircleOutlineGeometry")
  object CircleOutlineGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: CircleOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: CircleOutlineGeometry = ???): CircleOutlineGeometry = js.native

    def createGeometry(circleGeometry: CircleOutlineGeometry): Geometry | Unit = js.native
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
  @js.native
  @JSName("Cesium.Clock")
  class Clock protected() extends js.Object {
    def this(options: ClockOptions) = this()

    var startTime: JulianDate = js.native
    var stopTime: JulianDate = js.native
    var currentTime: JulianDate = js.native
    var multiplier: Double = js.native
    var clockStep: ClockStep = js.native
    var clockRange: ClockRange = js.native
    var canAnimate: Boolean = js.native
    var shouldAnimate: Boolean = js.native
    var onTick: Event = js.native

    def tick(): JulianDate = js.native
  }

  @js.native
  @JSName("Cesium.Color")
  class Color protected() extends js.Object {
    def this(red: Double = ???, green: Double = ???, blue: Double = ???, alpha: Double = ???) = this()

    var red: Double = js.native
    var green: Double = js.native
    var blue: Double = js.native
    var alpha: Double = js.native

    def clone(result: Color = ???): Color = js.native

    def equals(other: Color): Boolean = js.native

    def equalsEpsilon(other: Color, epsilon: Double = ???): Boolean = js.native

    override def toString(): String = js.native

    def toCssColorString(): String = js.native

    def toBytes(result: js.Array[Double] = ???): js.Array[Double] = js.native

    def toRgba(): Double = js.native

    def brighten(magnitude: Double, result: Color): Color = js.native

    def darken(magnitude: Double, result: Color): Color = js.native

    def withAlpha(alpha: Double, result: Color = ???): Color = js.native
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
  @js.native
  @JSName("Cesium.Color")
  object Color extends js.Object {
    var packedLength: Double = js.native
    var ALICEBLUE: Color = js.native
    var ANTIQUEWHITE: Color = js.native
    var AQUA: Color = js.native
    var AQUAMARINE: Color = js.native
    var AZURE: Color = js.native
    var BEIGE: Color = js.native
    var BISQUE: Color = js.native
    var BLACK: Color = js.native
    var BLANCHEDALMOND: Color = js.native
    var BLUE: Color = js.native
    var BLUEVIOLET: Color = js.native
    var BROWN: Color = js.native
    var BURLYWOOD: Color = js.native
    var CADETBLUE: Color = js.native
    var CHARTREUSE: Color = js.native
    var CHOCOLATE: Color = js.native
    var CORAL: Color = js.native
    var CORNFLOWERBLUE: Color = js.native
    var CORNSILK: Color = js.native
    var CRIMSON: Color = js.native
    var CYAN: Color = js.native
    var DARKBLUE: Color = js.native
    var DARKCYAN: Color = js.native
    var DARKGOLDENROD: Color = js.native
    var DARKGRAY: Color = js.native
    var DARKGREEN: Color = js.native
    var DARKGREY: Color = js.native
    var DARKKHAKI: Color = js.native
    var DARKMAGENTA: Color = js.native
    var DARKOLIVEGREEN: Color = js.native
    var DARKORANGE: Color = js.native
    var DARKORCHID: Color = js.native
    var DARKRED: Color = js.native
    var DARKSALMON: Color = js.native
    var DARKSEAGREEN: Color = js.native
    var DARKSLATEBLUE: Color = js.native
    var DARKSLATEGRAY: Color = js.native
    var DARKSLATEGREY: Color = js.native
    var DARKTURQUOISE: Color = js.native
    var DARKVIOLET: Color = js.native
    var DEEPPINK: Color = js.native
    var DEEPSKYBLUE: Color = js.native
    var DIMGRAY: Color = js.native
    var DIMGREY: Color = js.native
    var DODGERBLUE: Color = js.native
    var FIREBRICK: Color = js.native
    var FLORALWHITE: Color = js.native
    var FORESTGREEN: Color = js.native
    var FUSCHIA: Color = js.native
    var GAINSBORO: Color = js.native
    var GHOSTWHITE: Color = js.native
    var GOLD: Color = js.native
    var GOLDENROD: Color = js.native
    var GRAY: Color = js.native
    var GREEN: Color = js.native
    var GREENYELLOW: Color = js.native
    var GREY: Color = js.native
    var HONEYDEW: Color = js.native
    var HOTPINK: Color = js.native
    var INDIANRED: Color = js.native
    var INDIGO: Color = js.native
    var IVORY: Color = js.native
    var KHAKI: Color = js.native
    var LAVENDER: Color = js.native
    var LAVENDAR_BLUSH: Color = js.native
    var LAWNGREEN: Color = js.native
    var LEMONCHIFFON: Color = js.native
    var LIGHTBLUE: Color = js.native
    var LIGHTCORAL: Color = js.native
    var LIGHTCYAN: Color = js.native
    var LIGHTGOLDENRODYELLOW: Color = js.native
    var LIGHTGRAY: Color = js.native
    var LIGHTGREEN: Color = js.native
    var LIGHTGREY: Color = js.native
    var LIGHTPINK: Color = js.native
    var LIGHTSEAGREEN: Color = js.native
    var LIGHTSKYBLUE: Color = js.native
    var LIGHTSLATEGRAY: Color = js.native
    var LIGHTSLATEGREY: Color = js.native
    var LIGHTSTEELBLUE: Color = js.native
    var LIGHTYELLOW: Color = js.native
    var LIME: Color = js.native
    var LIMEGREEN: Color = js.native
    var LINEN: Color = js.native
    var MAGENTA: Color = js.native
    var MAROON: Color = js.native
    var MEDIUMAQUAMARINE: Color = js.native
    var MEDIUMBLUE: Color = js.native
    var MEDIUMORCHID: Color = js.native
    var MEDIUMPURPLE: Color = js.native
    var MEDIUMSEAGREEN: Color = js.native
    var MEDIUMSLATEBLUE: Color = js.native
    var MEDIUMSPRINGGREEN: Color = js.native
    var MEDIUMTURQUOISE: Color = js.native
    var MEDIUMVIOLETRED: Color = js.native
    var MIDNIGHTBLUE: Color = js.native
    var MINTCREAM: Color = js.native
    var MISTYROSE: Color = js.native
    var MOCCASIN: Color = js.native
    var NAVAJOWHITE: Color = js.native
    var NAVY: Color = js.native
    var OLDLACE: Color = js.native
    var OLIVE: Color = js.native
    var OLIVEDRAB: Color = js.native
    var ORANGE: Color = js.native
    var ORANGERED: Color = js.native
    var ORCHID: Color = js.native
    var PALEGOLDENROD: Color = js.native
    var PALEGREEN: Color = js.native
    var PALETURQUOISE: Color = js.native
    var PALEVIOLETRED: Color = js.native
    var PAPAYAWHIP: Color = js.native
    var PEACHPUFF: Color = js.native
    var PERU: Color = js.native
    var PINK: Color = js.native
    var PLUM: Color = js.native
    var POWDERBLUE: Color = js.native
    var PURPLE: Color = js.native
    var RED: Color = js.native
    var ROSYBROWN: Color = js.native
    var ROYALBLUE: Color = js.native
    var SADDLEBROWN: Color = js.native
    var SALMON: Color = js.native
    var SANDYBROWN: Color = js.native
    var SEAGREEN: Color = js.native
    var SEASHELL: Color = js.native
    var SIENNA: Color = js.native
    var SILVER: Color = js.native
    var SKYBLUE: Color = js.native
    var SLATEBLUE: Color = js.native
    var SLATEGRAY: Color = js.native
    var SLATEGREY: Color = js.native
    var SNOW: Color = js.native
    var SPRINGGREEN: Color = js.native
    var STEELBLUE: Color = js.native
    var TAN: Color = js.native
    var TEAL: Color = js.native
    var THISTLE: Color = js.native
    var TOMATO: Color = js.native
    var TURQUOISE: Color = js.native
    var VIOLET: Color = js.native
    var WHEAT: Color = js.native
    var WHITE: Color = js.native
    var WHITESMOKE: Color = js.native
    var YELLOW: Color = js.native
    var YELLOWGREEN: Color = js.native
    var TRANSPARENT: Color = js.native

    def fromCartesian4(cartesian: Cartesian4, result: Color = ???): Color = js.native

    def fromBytes(red: Double = ???, green: Double = ???, blue: Double = ???, alpha: Double = ???, result: Color = ???): Color = js.native

    def fromAlpha(color: Color, alpha: Double, result: Color = ???): Color = js.native

    def fromRgba(rgba: Double, result: Color = ???): Color = js.native

    def fromHsl(hue: Double = ???, saturation: Double = ???, lightness: Double = ???, alpha: Double = ???, result: Color = ???): Color = js.native

    def fromRandom(options: RandomColorOptions = ???, result: Color = ???): Color = js.native

    def fromCssColorString(color: String, result: Color = ???): Color = js.native

    def pack(value: Color, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: Color = ???): Color = js.native

    def byteToFloat(number: Double): Double = js.native

    def floatToByte(number: Double): Double = js.native

    def clone(color: Color, result: Color = ???): Color = js.native

    def equals(left: Color, right: Color): Boolean = js.native

    def add(left: Color, right: Color, result: Color): Color = js.native

    def subtract(left: Color, right: Color, result: Color): Color = js.native

    def multiply(left: Color, right: Color, result: Color): Color = js.native

    def divide(left: Color, right: Color, result: Color): Color = js.native

    def mod(left: Color, right: Color, result: Color): Color = js.native

    def multiplyByScalar(color: Color, scalar: Double, result: Color): Color = js.native

    def divideByScalar(color: Color, scalar: Double, result: Color): Color = js.native
  }

  @js.native
  @JSName("Cesium.ColorGeometryInstanceAttribute")
  class ColorGeometryInstanceAttribute protected() extends js.Object {
    def this(red: Double = ???, green: Double = ???, blue: Double = ???, alpha: Double = ???) = this()

    var value: Uint8Array = js.native
    var componentDatatype: ComponentDatatype = js.native
    var componentsPerAttribute: Double = js.native
    var normalize: Boolean = js.native
  }

  @js.native
  @JSName("Cesium.ColorGeometryInstanceAttribute")
  object ColorGeometryInstanceAttribute extends js.Object {
    def fromColor(color: Color): ColorGeometryInstanceAttribute = js.native

    def toValue(color: Color, result: Uint8Array = ???): Uint8Array = js.native

    def equals(left: ColorGeometryInstanceAttribute = ???, right: ColorGeometryInstanceAttribute = ???): Boolean = js.native
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
  @js.native
  @JSName("Cesium.CorridorGeometry")
  class CorridorGeometry protected() extends js.Object {
    def this(options: CorridorGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.CorridorGeometry")
  object CorridorGeometry extends js.Object {
    def pack(value: CorridorGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: CorridorGeometry = ???): CorridorGeometry = js.native

    def createGeometry(corridorGeometry: CorridorGeometry): Geometry | Unit = js.native
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
  @js.native
  @JSName("Cesium.CorridorOutlineGeometry")
  class CorridorOutlineGeometry protected() extends js.Object {
    def this(options: CorridorOutlineGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.CorridorOutlineGeometry")
  object CorridorOutlineGeometry extends js.Object {
    def pack(value: CorridorOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: CorridorOutlineGeometry = ???): CorridorOutlineGeometry = js.native

    def createGeometry(corridorOutlineGeometry: CorridorOutlineGeometry): Geometry | Unit = js.native
  }

  @js.native
  @JSName("Cesium.Credit")
  class Credit protected() extends js.Object {
    def this(text: String = ???, imageUrl: String = ???, link: String = ???) = this()

    var text: String = js.native
    var imageUrl: String = js.native
    var link: String = js.native

    def hasImage(): Boolean = js.native

    def hasLink(): Boolean = js.native

    def equals(credits: Credit): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.Credit")
  object Credit extends js.Object {
    def equals(left: Credit, right: Credit): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.CylinderGeometry")
  class CylinderGeometry protected() extends js.Object {
    def this(options: js.Any) = this()
  }

  @js.native
  @JSName("Cesium.CylinderGeometry")
  object CylinderGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: CylinderGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: CylinderGeometry = ???): CylinderGeometry = js.native

    def createGeometry(cylinderGeometry: CylinderGeometry): Geometry | Unit = js.native
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
  @js.native
  @JSName("Cesium.CylinderOutlineGeometry")
  class CylinderOutlineGeometry protected() extends js.Object {
    def this(options: CylinderOutlineGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.CylinderOutlineGeometry")
  object CylinderOutlineGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: CylinderOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: CylinderOutlineGeometry = ???): CylinderOutlineGeometry = js.native

    def createGeometry(cylinderGeometry: CylinderOutlineGeometry): Geometry | Unit = js.native
  }

  @js.native
  @JSName("Cesium.DefaultProxy")
  class DefaultProxy protected() extends js.Object {
    def this(proxy: String) = this()

    def getURL(resource: String): String = js.native
  }

  @js.native
  @JSName("Cesium.DeveloperError")
  class DeveloperError protected() extends js.Object {
    def this(message: String = ???) = this()

    var name: String = js.native
    var message: String = js.native
    var stack: String = js.native
  }
  @JSName("Cesium.Options")
  @js.native
  trait EllipseGeometryOptions extends js.Object

  object EllipseGeometryOptions extends EllipseGeometryOptionsBuilder(noOpts)

  class EllipseGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EllipseGeometryOptions, EllipseGeometryOptionsBuilder](new EllipseGeometryOptionsBuilder(_)) {

    def radii(v: Cartesian3) = jsOpt("radii", v)
    def stackPartitions(v: Int) = jsOpt("stackPartitions", v)
    def slicePartitions(v: Int) = jsOpt("slicePartitions", v)
    def vertexFormat(v: VertexFormat) = jsOpt("vertexFormat", v)

  }
  @js.native
  @JSName("Cesium.EllipseGeometry")
  class EllipseGeometry protected() extends js.Object {
    def this(options: EllipseGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.EllipseGeometry")
  object EllipseGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: EllipseGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: EllipseGeometry = ???): EllipseGeometry = js.native

    def createGeometry(ellipseGeometry: EllipseGeometry): Geometry | Unit = js.native
  }
  @JSName("Cesium.Options")
  @js.native
  trait EllipseOutlineGeometryOptions extends js.Object

  object EllipseOutlineGeometryOptions extends EllipseOutlineGeometryOptionsBuilder(noOpts)

  class EllipseOutlineGeometryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EllipseOutlineGeometryOptions, EllipseOutlineGeometryOptionsBuilder](new EllipseOutlineGeometryOptionsBuilder(_)) {
    def radii(v: Cartesian3) = jsOpt("radii", v)
    def stackPartitions(v: Int) = jsOpt("stackPartitions", v)
    def slicePartitions(v: Int) = jsOpt("slicePartitions", v)
    def subdivisions(v: Int) = jsOpt("subdivisions", v)

  }
  @js.native
  @JSName("Cesium.EllipseOutlineGeometry")
  class EllipseOutlineGeometry protected() extends js.Object {
    def this(options: EllipseOutlineGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.EllipseOutlineGeometry")
  object EllipseOutlineGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: EllipseOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: EllipseOutlineGeometry = ???): EllipseOutlineGeometry = js.native

    def createGeometry(ellipseGeometry: EllipseOutlineGeometry): Geometry | Unit = js.native
  }

  @js.native
  @JSName("Cesium.Ellipsoid")
  class Ellipsoid protected() extends js.Object {
    def this(x: Double = ???, y: Double = ???, z: Double = ???) = this()

    var radii: Cartesian3 = js.native
    var radiiSquared: Cartesian3 = js.native
    var radiiToTheFourth: Cartesian3 = js.native
    var oneOverRadii: Cartesian3 = js.native
    var oneOverRadiiSquared: Cartesian3 = js.native
    var minimumRadius: Double = js.native
    var maximumRadius: Double = js.native

    def clone(result: Ellipsoid = ???): Ellipsoid = js.native

    def geocentricSurfaceNormal(cartesian: Cartesian3, result: Cartesian3 = ???): Cartesian3 = js.native

    def geodeticSurfaceNormalCartographic(cartographic: Cartographic, result: Cartesian3 = ???): Cartesian3 = js.native

    def geodeticSurfaceNormal(cartesian: Cartesian3, result: Cartesian3 = ???): Cartesian3 = js.native

    def cartographicToCartesian(cartographic: Cartographic, result: Cartesian3 = ???): Cartesian3 = js.native

    def cartographicArrayToCartesianArray(cartographics: js.Array[Cartographic], result: js.Array[Cartesian3] = ???): js.Array[Cartesian3] = js.native

    def cartesianToCartographic(cartesian: Cartesian3, result: Cartographic = ???): Cartographic = js.native

    def cartesianArrayToCartographicArray(cartesians: js.Array[Cartesian3], result: js.Array[Cartographic] = ???): js.Array[Cartographic] = js.native

    def scaleToGeodeticSurface(cartesian: Cartesian3, result: Cartesian3 = ???): Cartesian3 = js.native

    def scaleToGeocentricSurface(cartesian: Cartesian3, result: Cartesian3 = ???): Cartesian3 = js.native

    def transformPositionToScaledSpace(position: Cartesian3, result: Cartesian3 = ???): Cartesian3 = js.native

    def transformPositionFromScaledSpace(position: Cartesian3, result: Cartesian3 = ???): Cartesian3 = js.native

    def equals(right: Ellipsoid = ???): Boolean = js.native

    override def toString(): String = js.native
  }

  @js.native
  @JSName("Cesium.Ellipsoid")
  object Ellipsoid extends js.Object {
    var WGS84: Ellipsoid = js.native
    var UNIT_SPHERE: Ellipsoid = js.native
    var MOON: Ellipsoid = js.native
    var packedLength: Double = js.native

    def clone(ellipsoid: Ellipsoid, result: Ellipsoid = ???): Ellipsoid = js.native

    def fromCartesian3(radii: Cartesian3 = ???): Ellipsoid = js.native

    def pack(value: Ellipsoid, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: Ellipsoid = ???): Ellipsoid = js.native
  }

  @js.native
  @JSName("Cesium.EllipsoidGeodesic")
  class EllipsoidGeodesic protected() extends js.Object {
    def this(start: Cartographic = ???, end: Cartographic = ???, ellipsoid: Ellipsoid = ???) = this()

    var ellipsoid: Ellipsoid = js.native
    var surfaceDistance: Double = js.native
    var start: Cartographic = js.native
    var end: Cartographic = js.native
    var startHeading: Double = js.native
    var endHeading: Double = js.native

    def setEndPoints(start: Cartographic, end: Cartographic): js.Dynamic = js.native

    def interpolateUsingFraction(fraction: Double): Cartographic = js.native

    def interpolateUsingSurfaceDistance(distance: Double): Cartographic = js.native
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
  @js.native
  @JSName("Cesium.EllipsoidGeometry")
  class EllipsoidGeometry protected() extends js.Object {
    def this(options: EllipsoidGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.EllipsoidGeometry")
  object EllipsoidGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: EllipsoidGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: EllipsoidGeometry = ???): EllipsoidGeometry = js.native

    def createGeometry(ellipsoidGeometry: EllipsoidGeometry): Geometry | Unit = js.native
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
  @js.native
  @JSName("Cesium.EllipsoidOutlineGeometry")
  class EllipsoidOutlineGeometry protected() extends js.Object {
    def this(options: EllipsoidOutlineGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.EllipsoidOutlineGeometry")
  object EllipsoidOutlineGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: EllipsoidOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: EllipsoidOutlineGeometry = ???): EllipsoidOutlineGeometry = js.native

    def createGeometry(ellipsoidGeometry: EllipsoidOutlineGeometry): Geometry | Unit = js.native
  }

  @js.native
  @JSName("Cesium.EllipsoidTangentPlane")
  class EllipsoidTangentPlane protected() extends js.Object {
    def this(origin: Cartesian3, ellipsoid: Ellipsoid = ???) = this()

    var ellipsoid: Ellipsoid = js.native
    var origin: Cartesian3 = js.native
    var plane: Plane = js.native
    var xAxis: Cartesian3 = js.native
    var yAxis: Cartesian3 = js.native

    def projectPointOntoPlane(cartesian: Cartesian3, result: Cartesian2 = ???): Cartesian2 = js.native

    def projectPointsOntoPlane(cartesians: js.Array[Cartesian3], result: js.Array[Cartesian2] = ???): js.Array[Cartesian2] = js.native

    def projectPointToNearestOnPlane(cartesian: Cartesian3, result: Cartesian2 = ???): Cartesian2 = js.native

    def projectPointsToNearestOnPlane(cartesians: js.Array[Cartesian3], result: js.Array[Cartesian2] = ???): js.Array[Cartesian2] = js.native

    def projectPointsOntoEllipsoid(cartesians: js.Array[Cartesian2], result: js.Array[Cartesian3] = ???): js.Array[Cartesian3] = js.native
  }

  @js.native
  @JSName("Cesium.EllipsoidTangentPlane")
  object EllipsoidTangentPlane extends js.Object {
    def fromPoints(ellipsoid: Ellipsoid, cartesians: Cartesian3): js.Dynamic = js.native
  }
  @JSName("Cesium.Options")
  @js.native
  trait EllipsoidTerrainProviderOptions extends js.Object

  object EllipsoidTerrainProviderOptions extends EllipsoidTerrainProviderOptionsBuilder(noOpts)

  class EllipsoidTerrainProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EllipsoidTerrainProviderOptions, EllipsoidTerrainProviderOptionsBuilder](new EllipsoidTerrainProviderOptionsBuilder(_)) {

    def tilingScheme(v: TilingScheme) = jsOpt("tilingScheme", v)
    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

  }
  @js.native
  @JSName("Cesium.EllipsoidTerrainProvider")
  class EllipsoidTerrainProvider protected() extends js.Object {
    def this(options: EllipsoidTerrainProviderOptions) = this()

    var errorEvent: Event = js.native
    var credit: Credit = js.native
    var tilingScheme: GeographicTilingScheme = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var hasWaterMask: Boolean = js.native
    var hasVertexNormals: Boolean = js.native

    def requestTileGeometry(x: Double, y: Double, level: Double, throttleRequests: Boolean = ???): Promise[TerrainData] | Unit = js.native

    def getLevelMaximumGeometricError(level: Double): Double = js.native

    def getTileDataAvailable(x: Double, y: Double, level: Double): Boolean = js.native
  }

  @JSName("Cesium.Event")
  @js.native
  object Event extends js.Object {
    type RemoveCallback = js.Function0[Unit]
  }

  @js.native
  @JSName("Cesium.Event")
  class Event extends js.Object {
    var numberOfListeners: Double = js.native

    def addEventListener(listener: js.Function, scope: js.Any = ???): Event.RemoveCallback = js.native

    def removeEventListener(listener: js.Function, scope: js.Any = ???): Boolean = js.native

    def raiseEvent(args: js.Any*): js.Dynamic = js.native
  }

  @JSName("Cesium.EventHelper")
  @js.native
  object EventHelper extends js.Object {
    type RemoveCallback = js.Function0[Unit]
  }

  @js.native
  @JSName("Cesium.EventHelper")
  class EventHelper extends js.Object {
    def add(event: Event, listener: js.Function, scope: js.Any = ???): EventHelper.RemoveCallback = js.native

    def removeAll(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.GeographicProjection")
  class GeographicProjection protected() extends js.Object {
    def this(ellipsoid: Ellipsoid = ???) = this()

    var ellipsoid: Ellipsoid = js.native

    def project(cartographic: Cartographic, result: Cartesian3 = ???): Cartesian3 = js.native

    def unproject(cartesian: Cartesian3, result: Cartographic = ???): Cartographic = js.native
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
  @js.native
  @JSName("Cesium.GeographicTilingScheme")
  class GeographicTilingScheme protected() extends js.Object {
    def this(options: GeographicTilingSchemeOptions) = this()

    var ellipsoid: Ellipsoid = js.native
    var rectangle: Rectangle = js.native
    var projection: MapProjection = js.native

    def getNumberOfXTilesAtLevel(level: Double): Double = js.native

    def getNumberOfYTilesAtLevel(level: Double): Double = js.native

    def rectangleToNativeRectangle(rectangle: Rectangle, result: Rectangle = ???): Rectangle = js.native

    def tileXYToNativeRectangle(x: Double, y: Double, level: Double, result: js.Any = ???): Rectangle = js.native

    def tileXYToRectangle(x: Double, y: Double, level: Double, result: js.Any = ???): Rectangle = js.native

    def positionToTileXY(position: Cartographic, level: Double, result: Cartesian2 = ???): Cartesian2 = js.native
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
  @js.native
  @JSName("Cesium.Geometry")
  class Geometry protected() extends js.Object {
    def this(options: GeometryOptions) = this()

    var attributes: GeometryAttributes = js.native
    var indices: js.Array[js.Any] = js.native
    var primitiveType: PrimitiveType = js.native
    var boundingSphere: BoundingSphere = js.native
  }

  @js.native
  @JSName("Cesium.Geometry")
  object Geometry extends js.Object {
    def computeNumberOfVertices(geometry: Geometry): Double = js.native
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
  @js.native
  @JSName("Cesium.GeometryAttribute")
  class GeometryAttribute protected() extends js.Object {
    def this(options: GeometryAttributeOptions) = this()

    var componentDatatype: ComponentDatatype = js.native
    var componentsPerAttribute: Double = js.native
    var normalize: Boolean = js.native
    var values: Cesium.TypedArray = js.native
  }

  @js.native
  @JSName("Cesium.GeometryAttributes")
  class GeometryAttributes extends js.Object {
    var position: GeometryAttribute = js.native
    var normal: GeometryAttribute = js.native
    var st: GeometryAttribute = js.native
    var binormal: GeometryAttribute = js.native
    var tangent: GeometryAttribute = js.native
    var color: GeometryAttribute = js.native
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
  @js.native
  @JSName("Cesium.GeometryInstance")
  class GeometryInstance protected() extends js.Object {
    def this(options: GeometryInstanceOptions) = this()

    var geometry: Geometry = js.native
    var modelMatrix: Matrix4 = js.native
    var id: js.Any = js.native
    var attributes: js.Any = js.native
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
  @js.native
  @JSName("Cesium.GeometryInstanceAttribute")
  class GeometryInstanceAttribute protected() extends js.Object {
    def this(options: GeometryInstanceAttributeOptions) = this()

    var componentDatatype: ComponentDatatype = js.native
    var componentsPerAttribute: Double = js.native
    var normalize: Boolean = js.native
    var value: js.Array[Double] = js.native
  }

  @js.native
  @JSName("Cesium.GregorianDate")
  class GregorianDate extends js.Object {
    var year: Double = js.native
    var month: Double = js.native
    var day: Double = js.native
    var hour: Double = js.native
    var minute: Double = js.native
    var second: Double = js.native
    var millisecond: Double = js.native
    var isLeapSecond: Boolean = js.native
  }

  @js.native
  @JSName("Cesium.HeadingPitchRange")
  class HeadingPitchRange protected() extends js.Object {
    def this(heading: Double = ???, pitch: Double = ???, range: Double = ???) = this()

    var heading: Double = js.native
    var pitch: Double = js.native
    var range: Double = js.native
  }

  @js.native
  @JSName("Cesium.HeadingPitchRange")
  object HeadingPitchRange extends js.Object {
    def clone(hpr: HeadingPitchRange, result: HeadingPitchRange = ???): HeadingPitchRange = js.native
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
    // todo
    def childTileMask(v: Int) = jsOpt("childTileMask", v)
    // todo
    def structure(v: Object) = jsOpt("structure", v)
    def createdByUpsampling(v: Boolean) = jsOpt("createdByUpsampling", v)

  }
  @js.native
  @JSName("Cesium.HeightmapTerrainData")
  class HeightmapTerrainData protected() extends js.Object {
    def this(options: HeightmapTerrainDataOptions) = this()

    var waterMask: Uint8Array | HTMLImageElement | HTMLCanvasElement = js.native

    def interpolateHeight(rectangle: Rectangle, longitude: Double, latitude: Double): Double = js.native

    def upsample(tilingScheme: TilingScheme, thisX: Double, thisY: Double, thisLevel: Double, descendantX: Double, descendantY: Double, descendantLevel: Double): Promise[HeightmapTerrainData] | Unit = js.native

    def isChildAvailable(thisX: Double, thisY: Double, childX: Double, childY: Double): Boolean = js.native

    def wasCreatedByUpsampling(): Boolean = js.native
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
  @js.native
  @JSName("Cesium.HermiteSpline")
  class HermiteSpline protected() extends js.Object {
    def this(options: HermiteSplineOptions) = this()

    var times: js.Array[Double] = js.native
    var points: js.Array[Cartesian3] = js.native
    var inTangents: js.Array[Cartesian3] = js.native
    var outTangents: js.Array[Cartesian3] = js.native

    def findTimeInterval(time: Double): Double = js.native

    def evaluate(time: Double, result: Cartesian3 = ???): Cartesian3 = js.native
  }

  @js.native
  @JSName("Cesium.HermiteSpline")
  object HermiteSpline extends js.Object {
    def createC1(options: HermiteSplineOptions): HermiteSpline = js.native

    def createNaturalCubic(options: HermiteSplineOptions): HermiteSpline | LinearSpline = js.native

    def createClampedCubic(options: HermiteSplineOptions): HermiteSpline | LinearSpline = js.native
  }

  @js.native
  @JSName("Cesium.Interval")
  class Interval protected() extends js.Object {
    def this(start: Double = ???, stop: Double = ???) = this()

    var start: Double = js.native
    var stop: Double = js.native
  }

  @js.native
  @JSName("Cesium.JulianDate")
  class JulianDate protected() extends js.Object {
    def this(julianDayNumber: Double, secondsOfDay: Double, timeStandard: TimeStandard = ???) = this()

    var dayNumber: Double = js.native
    var secondsOfDay: Double = js.native

    def clone(result: JulianDate = ???): JulianDate = js.native

    def equals(right: JulianDate = ???): Boolean = js.native

    def equalsEpsilon(right: JulianDate, epsilon: Double): Boolean = js.native

    override def toString(): String = js.native
  }

  @js.native
  @JSName("Cesium.JulianDate")
  object JulianDate extends js.Object {
    var leapSeconds: js.Array[LeapSecond] = js.native

    def fromDate(date: Date, result: JulianDate = ???): JulianDate = js.native

    def fromIso8601(iso8601String: String, result: JulianDate = ???): JulianDate = js.native

    def now(result: JulianDate = ???): JulianDate = js.native

    def toGregorianDate(julianDate: JulianDate, result: GregorianDate = ???): GregorianDate = js.native

    def toDate(julianDate: JulianDate): Date = js.native

    def toIso8601(julianDate: JulianDate, precision: Double = ???): String = js.native

    def clone(julianDate: JulianDate, result: JulianDate = ???): JulianDate = js.native

    def compare(left: JulianDate, right: JulianDate): Double = js.native

    def equals(left: JulianDate = ???, right: JulianDate = ???): Boolean = js.native

    def equalsEpsilon(left: JulianDate, right: JulianDate, epsilon: Double): Boolean = js.native

    def totalDays(julianDate: JulianDate): Double = js.native

    def secondsDifference(left: JulianDate, right: JulianDate): Double = js.native

    def daysDifference(left: JulianDate, right: JulianDate): Double = js.native

    def computeTaiMinusUtc(julianDate: JulianDate): Double = js.native

    def addSeconds(julianDate: JulianDate, seconds: Double, result: JulianDate): JulianDate = js.native

    def addMinutes(julianDate: JulianDate, minutes: Double, result: JulianDate): JulianDate = js.native

    def addHours(julianDate: JulianDate, hours: Double, result: JulianDate): JulianDate = js.native

    def addDays(julianDate: JulianDate, days: Double, result: JulianDate): JulianDate = js.native

    def lessThan(left: JulianDate, right: JulianDate): Boolean = js.native

    def lessThanOrEquals(left: JulianDate, right: JulianDate): Boolean = js.native

    def greaterThan(left: JulianDate, right: JulianDate): Boolean = js.native

    def greaterThanOrEquals(left: JulianDate, right: JulianDate): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.LeapSecond")
  class LeapSecond protected() extends js.Object {
    def this(date: JulianDate = ???, offset: Double = ???) = this()

    var julianDate: JulianDate = js.native
    var offset: Double = js.native
  }
  @JSName("Cesium.Options")
  @js.native
  trait LinearSplineOptions extends js.Object

  object LinearSplineOptions extends LinearSplineOptionsBuilder(noOpts)

  class LinearSplineOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LinearSplineOptions, LinearSplineOptionsBuilder](new LinearSplineOptionsBuilder(_)) {

    def times(v: Array[Double]) = jsOpt("times", v)
    def points(v: Array[Cartesian3]) = jsOpt("points", v)
  }
  @js.native
  @JSName("Cesium.LinearSpline")
  class LinearSpline protected() extends js.Object {
    def this(options: LinearSplineOptions) = this()

    var times: js.Array[Double] = js.native
    var points: js.Array[Cartesian3] = js.native

    def findTimeInterval(time: Double): Double = js.native

    def evaluate(time: Double, result: Cartesian3 = ???): Cartesian3 = js.native
  }

  @js.native
  @JSName("Cesium.MapProjection")
  class MapProjection extends js.Object {
    var ellipsoid: Ellipsoid = js.native

    def project(cartographic: Cartographic, result: Cartesian3 = ???): Cartesian3 = js.native

    def unproject(cartesian: Cartesian3, result: Cartographic = ???): Cartographic = js.native
  }

  @js.native
  @JSName("Cesium.Matrix2")
  class Matrix2 protected() extends js.Object {
    def this(column0Row0: Double = ???, column1Row0: Double = ???, column0Row1: Double = ???, column1Row1: Double = ???) = this()

    var length: Double = js.native

    def clone(result: Matrix2 = ???): Matrix2 = js.native

    def equals(right: Matrix2 = ???): Boolean = js.native

    def equalsEpsilon(right: Matrix2, epsilon: Double): Boolean = js.native

    override def toString(): String = js.native
  }

  @js.native
  @JSName("Cesium.Matrix2")
  object Matrix2 extends js.Object {
    var packedLength: Double = js.native
    var IDENTITY: Matrix2 = js.native
    var ZERO: Matrix2 = js.native
    var COLUMN0ROW0: Double = js.native
    var COLUMN0ROW1: Double = js.native
    var COLUMN1ROW0: Double = js.native
    var COLUMN1ROW1: Double = js.native

    def pack(value: Matrix2, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: Matrix2 = ???): Matrix2 = js.native

    def clone(matrix: Matrix2, result: Matrix2 = ???): Matrix2 = js.native

    def fromArray(array: js.Array[Double], startingIndex: Double = ???, result: Matrix2 = ???): Matrix2 = js.native

    def fromColumnMajorArray(values: js.Array[Double], result: Matrix2 = ???): Matrix2 = js.native

    def fromRowMajorArray(values: js.Array[Double], result: Matrix2 = ???): Matrix2 = js.native

    def fromScale(scale: Cartesian2, result: Matrix2 = ???): Matrix2 = js.native

    def fromUniformScale(scale: Double, result: Matrix2 = ???): Matrix2 = js.native

    def fromRotation(angle: Double, result: Matrix2 = ???): Matrix2 = js.native

    def toArray(matrix: Matrix2, result: js.Array[Double] = ???): js.Array[Double] = js.native

    def getElementIndex(row: Double, column: Double): Double = js.native

    def getColumn(matrix: Matrix2, index: Double, result: Cartesian2): Cartesian2 = js.native

    def setColumn(matrix: Matrix2, index: Double, cartesian: Cartesian2, result: Cartesian2): Matrix2 = js.native

    def getRow(matrix: Matrix2, index: Double, result: Cartesian2): Cartesian2 = js.native

    def setRow(matrix: Matrix2, index: Double, cartesian: Cartesian2, result: Matrix2): Matrix2 = js.native

    def getScale(matrix: Matrix2, result: Cartesian2): Cartesian2 = js.native

    def getMaximumScale(matrix: Matrix2): Double = js.native

    def multiply(left: Matrix2, right: Matrix2, result: Matrix2): Matrix2 = js.native

    def add(left: Matrix2, right: Matrix2, result: Matrix2): Matrix2 = js.native

    def subtract(left: Matrix2, right: Matrix2, result: Matrix2): Matrix2 = js.native

    def multiplyByVector(matrix: Matrix2, cartesian: Cartesian2, result: Cartesian2): Cartesian2 = js.native

    def multiplyByScalar(matrix: Matrix2, scalar: Double, result: Matrix2): Matrix2 = js.native

    def multiplyByScale(matrix: Matrix2, scale: Cartesian2, result: Matrix2): Matrix2 = js.native

    def negate(matrix: Matrix2, result: Matrix2): Matrix2 = js.native

    def transpose(matrix: Matrix2, result: Matrix2): Matrix2 = js.native

    def abs(matrix: Matrix2, result: Matrix2): Matrix2 = js.native

    def equals(left: Matrix2 = ???, right: Matrix2 = ???): Boolean = js.native

    def equalsEpsilon(left: Matrix2, right: Matrix2, epsilon: Double): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.Matrix3")
  class Matrix3 protected() extends js.Object {
    def this(column0Row0: Double = ???, column1Row0: Double = ???, column2Row0: Double = ???, column0Row1: Double = ???, column1Row1: Double = ???, column2Row1: Double = ???, column0Row2: Double = ???, column1Row2: Double = ???, column2Row2: Double = ???) = this()

    var length: Double = js.native

    def clone(result: Matrix3 = ???): Matrix3 = js.native

    def equals(right: Matrix3 = ???): Boolean = js.native

    def equalsEpsilon(right: Matrix3, epsilon: Double): Boolean = js.native

    override def toString(): String = js.native
  }

  @js.native
  @JSName("Cesium.Matrix3")
  object Matrix3 extends js.Object {
    var packedLength: Double = js.native
    var IDENTITY: Matrix3 = js.native
    var ZERO: Matrix3 = js.native
    var COLUMN0ROW0: Double = js.native
    var COLUMN0ROW1: Double = js.native
    var COLUMN0ROW2: Double = js.native
    var COLUMN1ROW0: Double = js.native
    var COLUMN1ROW1: Double = js.native
    var COLUMN1ROW2: Double = js.native
    var COLUMN2ROW0: Double = js.native
    var COLUMN2ROW1: Double = js.native
    var COLUMN2ROW2: Double = js.native

    def pack(value: Matrix3, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: Matrix3 = ???): Matrix3 = js.native

    def clone(matrix: Matrix3, result: Matrix3 = ???): Matrix3 = js.native

    def fromArray(array: js.Array[Double], startingIndex: Double = ???, result: Matrix3 = ???): Matrix3 = js.native

    def fromColumnMajorArray(values: js.Array[Double], result: Matrix3 = ???): Matrix3 = js.native

    def fromRowMajorArray(values: js.Array[Double], result: Matrix3 = ???): Matrix3 = js.native

    def fromQuaternion(quaternion: Quaternion, result: Matrix3 = ???): Matrix3 = js.native

    def fromScale(scale: Cartesian3, result: Matrix3 = ???): Matrix3 = js.native

    def fromUniformScale(scale: Double, result: Matrix3 = ???): Matrix3 = js.native

    def fromCrossProduct(the: Cartesian3, result: Matrix3 = ???): Matrix3 = js.native

    def fromRotationX(angle: Double, result: Matrix3 = ???): Matrix3 = js.native

    def fromRotationY(angle: Double, result: Matrix3 = ???): Matrix3 = js.native

    def fromRotationZ(angle: Double, result: Matrix3 = ???): Matrix3 = js.native

    def toArray(matrix: Matrix3, result: js.Array[Double] = ???): js.Array[Double] = js.native

    def getElementIndex(row: Double, column: Double): Double = js.native

    def getColumn(matrix: Matrix3, index: Double, result: Cartesian3): Cartesian3 = js.native

    def setColumn(matrix: Matrix3, index: Double, cartesian: Cartesian3, result: Matrix3): Matrix3 = js.native

    def getRow(matrix: Matrix3, index: Double, result: Cartesian3): Cartesian3 = js.native

    def setRow(matrix: Matrix3, index: Double, cartesian: Cartesian3, result: Matrix3): Matrix3 = js.native

    def getScale(matrix: Matrix3, result: Cartesian3): Cartesian3 = js.native

    def getMaximumScale(matrix: Matrix3): Double = js.native

    def multiply(left: Matrix3, right: Matrix3, result: Matrix3): Matrix3 = js.native

    def add(left: Matrix3, right: Matrix3, result: Matrix3): Matrix3 = js.native

    def subtract(left: Matrix3, right: Matrix3, result: Matrix3): Matrix3 = js.native

    def multiplyByVector(matrix: Matrix3, cartesian: Cartesian3, result: Cartesian3): Cartesian3 = js.native

    def multiplyByScalar(matrix: Matrix3, scalar: Double, result: Matrix3): Matrix3 = js.native

    def multiplyByScale(matrix: Matrix3, scale: Cartesian3, result: Matrix3): Matrix3 = js.native

    def negate(matrix: Matrix3, result: Matrix3): Matrix3 = js.native

    def transpose(matrix: Matrix3, result: Matrix3): Matrix3 = js.native

    def computeEigenDecomposition(matrix: Matrix3, result: js.Any = ???): js.Dynamic = js.native

    def abs(matrix: Matrix3, result: Matrix3): Matrix3 = js.native

    def determinant(matrix: Matrix3): Double = js.native

    def inverse(matrix: Matrix3, result: Matrix3): Matrix3 = js.native

    def equals(left: Matrix3 = ???, right: Matrix3 = ???): Boolean = js.native

    def equalsEpsilon(left: Matrix3, right: Matrix3, epsilon: Double): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.Matrix4")
  class Matrix4 protected() extends js.Object {
    def this(column0Row0: Double = ???, column1Row0: Double = ???, column2Row0: Double = ???, column3Row0: Double = ???, column0Row1: Double = ???, column1Row1: Double = ???, column2Row1: Double = ???, column3Row1: Double = ???, column0Row2: Double = ???, column1Row2: Double = ???, column2Row2: Double = ???, column3Row2: Double = ???, column0Row3: Double = ???, column1Row3: Double = ???, column2Row3: Double = ???, column3Row3: Double = ???) = this()

    var length: Double = js.native

    def clone(result: Matrix4 = ???): Matrix4 = js.native

    def equals(right: Matrix4 = ???): Boolean = js.native

    def equalsEpsilon(right: Matrix4, epsilon: Double): Boolean = js.native

    override def toString(): String = js.native
  }

  @js.native
  @JSName("Cesium.Matrix4")
  object Matrix4 extends js.Object {
    var packedLength: Double = js.native
    var IDENTITY: Matrix4 = js.native
    var ZERO: Matrix4 = js.native
    var COLUMN0ROW0: Double = js.native
    var COLUMN0ROW1: Double = js.native
    var COLUMN0ROW2: Double = js.native
    var COLUMN0ROW3: Double = js.native
    var COLUMN1ROW0: Double = js.native
    var COLUMN1ROW1: Double = js.native
    var COLUMN1ROW2: Double = js.native
    var COLUMN1ROW3: Double = js.native
    var COLUMN2ROW0: Double = js.native
    var COLUMN2ROW1: Double = js.native
    var COLUMN2ROW2: Double = js.native
    var COLUMN2ROW3: Double = js.native
    var COLUMN3ROW0: Double = js.native
    var COLUMN3ROW1: Double = js.native
    var COLUMN3ROW2: Double = js.native
    var COLUMN3ROW3: Double = js.native

    def pack(value: Matrix4, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: Matrix4 = ???): Matrix4 = js.native

    def clone(matrix: Matrix4, result: Matrix4 = ???): Matrix4 = js.native

    def fromArray(array: js.Array[Double], startingIndex: Double = ???, result: Matrix4 = ???): Matrix4 = js.native

    def fromColumnMajorArray(values: js.Array[Double], result: Matrix4 = ???): Matrix4 = js.native

    def fromRowMajorArray(values: js.Array[Double], result: Matrix4 = ???): Matrix4 = js.native

    def fromRotationTranslation(rotation: Matrix3, translation: Cartesian3 = ???, result: Matrix4 = ???): Matrix4 = js.native

    def fromTranslationQuaternionRotationScale(translation: Cartesian3, rotation: Quaternion, scale: Cartesian3, result: Matrix4 = ???): Matrix4 = js.native

    def fromTranslationRotationScale(translationRotationScale: TranslationRotationScale, result: Matrix4 = ???): Matrix4 = js.native

    def fromTranslation(translation: Cartesian3, result: Matrix4 = ???): Matrix4 = js.native

    def fromScale(scale: Cartesian3, result: Matrix4 = ???): Matrix4 = js.native

    def fromUniformScale(scale: Double, result: Matrix4 = ???): Matrix4 = js.native

    def fromCamera(camera: Camera, result: Matrix4 = ???): Matrix4 = js.native

    def computePerspectiveFieldOfView(fovY: Double, aspectRatio: Double, near: Double, far: Double, result: Matrix4): Matrix4 = js.native

    def computeOrthographicOffCenter(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double, result: Matrix4): Matrix4 = js.native

    def computePerspectiveOffCenter(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double, result: Matrix4): Matrix4 = js.native

    def computeInfinitePerspectiveOffCenter(left: Double, right: Double, bottom: Double, top: Double, near: Double, result: Matrix4): Matrix4 = js.native

    def computeViewportTransformation(viewport: js.Any, nearDepthRange: Double, farDepthRange: Double, result: Matrix4): Matrix4 = js.native

    def toArray(matrix: Matrix4, result: js.Array[Double] = ???): js.Array[Double] = js.native

    def getElementIndex(row: Double, column: Double): Double = js.native

    def getColumn(matrix: Matrix4, index: Double, result: Cartesian4): Cartesian4 = js.native

    def setColumn(matrix: Matrix4, index: Double, cartesian: Cartesian4, result: Matrix4): Matrix4 = js.native

    def setTranslation(matrix: Matrix4, translation: Cartesian3, result: Cartesian4): Matrix4 = js.native

    def getRow(matrix: Matrix4, index: Double, result: Cartesian4): Cartesian4 = js.native

    def setRow(matrix: Matrix4, index: Double, cartesian: Cartesian4, result: Matrix4): Matrix4 = js.native

    def getScale(matrix: Matrix4, result: Cartesian3): Cartesian3 = js.native

    def getMaximumScale(matrix: Matrix4): Double = js.native

    def multiply(left: Matrix4, right: Matrix4, result: Matrix4): Matrix4 = js.native

    def add(left: Matrix4, right: Matrix4, result: Matrix4): Matrix4 = js.native

    def subtract(left: Matrix4, right: Matrix4, result: Matrix4): Matrix4 = js.native

    def multiplyTransformation(left: Matrix4, right: Matrix4, result: Matrix4): Matrix4 = js.native

    def multiplyByMatrix3(matrix: Matrix4, rotation: Matrix3, result: Matrix4): Matrix4 = js.native

    def multiplyByTranslation(matrix: Matrix4, translation: Cartesian3, result: Matrix4): Matrix4 = js.native

    def multiplyByUniformScale(matrix: Matrix4, scale: Double, result: Matrix4): Matrix4 = js.native

    def multiplyByScale(matrix: Matrix4, scale: Cartesian3, result: Matrix4): Matrix4 = js.native

    def multiplyByVector(matrix: Matrix4, cartesian: Cartesian4, result: Cartesian4): Cartesian4 = js.native

    def multiplyByPointAsVector(matrix: Matrix4, cartesian: Cartesian3, result: Cartesian3): Cartesian3 = js.native

    def multiplyByPoint(matrix: Matrix4, cartesian: Cartesian3, result: Cartesian3): Cartesian3 = js.native

    def multiplyByScalar(matrix: Matrix4, scalar: Double, result: Matrix4): Matrix4 = js.native

    def negate(matrix: Matrix4, result: Matrix4): Matrix4 = js.native

    def transpose(matrix: Matrix4, result: Matrix4): Matrix4 = js.native

    def abs(matrix: Matrix4, result: Matrix4): Matrix4 = js.native

    def equals(left: Matrix4 = ???, right: Matrix4 = ???): Boolean = js.native

    def equalsEpsilon(left: Matrix4, right: Matrix4, epsilon: Double): Boolean = js.native

    def getTranslation(matrix: Matrix4, result: Cartesian3): Cartesian3 = js.native

    def getRotation(matrix: Matrix4, result: Matrix3): Matrix3 = js.native

    def inverse(matrix: Matrix4, result: Matrix4): Matrix4 = js.native

    def inverseTransformation(matrix: Matrix4, result: Matrix4): Matrix4 = js.native
  }

  @js.native
  @JSName("Cesium.NearFarScalar")
  class NearFarScalar protected() extends js.Object {
    def this(near: Double = ???, nearValue: Double = ???, far: Double = ???, farValue: Double = ???) = this()

    var near: Double = js.native
    var nearValue: Double = js.native
    var far: Double = js.native
    var farValue: Double = js.native

    def clone(result: NearFarScalar = ???): NearFarScalar = js.native

    def equals(right: NearFarScalar = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.NearFarScalar")
  object NearFarScalar extends js.Object {
    var packedLength: Double = js.native

    def clone(nearFarScalar: NearFarScalar, result: NearFarScalar = ???): NearFarScalar = js.native

    def pack(value: NearFarScalar, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: NearFarScalar = ???): NearFarScalar = js.native

    def equals(left: NearFarScalar = ???, right: NearFarScalar = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.Occluder")
  class Occluder protected() extends js.Object {
    def this(occluderBoundingSphere: BoundingSphere, cameraPosition: Cartesian3) = this()

    var position: Cartesian3 = js.native
    var radius: Double = js.native
    var cameraPosition: Cartesian3 = js.native

    def isPointVisible(occludee: Cartesian3): Boolean = js.native

    def isBoundingSphereVisible(occludee: BoundingSphere): Boolean = js.native

    def computeVisibility(occludeeBS: BoundingSphere): Double = js.native
  }

  @js.native
  @JSName("Cesium.Occluder")
  object Occluder extends js.Object {
    def fromBoundingSphere(occluderBoundingSphere: BoundingSphere, cameraPosition: Cartesian3, result: Occluder = ???): Occluder = js.native

    def computeOccludeePoint(occluderBoundingSphere: BoundingSphere, occludeePosition: Cartesian3, positions: js.Array[Cartesian3]): js.Dynamic = js.native

    def computeOccludeePointFromRectangle(rectangle: Rectangle, ellipsoid: Ellipsoid = ???): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.OrientedBoundingBox")
  class OrientedBoundingBox protected() extends js.Object {
    def this(center: Cartesian3 = ???, halfAxes: Matrix3 = ???) = this()

    var center: Cartesian3 = js.native
    var halfAxes: Matrix3 = js.native

    def intersectPlane(plane: Plane): Intersect = js.native

    def distanceSquaredTo(cartesian: Cartesian3): Double = js.native

    def computePlaneDistances(position: Cartesian3, direction: Cartesian3, result: Interval = ???): Interval = js.native

    def isOccluded(occluder: Occluder): Boolean = js.native

    def clone(result: OrientedBoundingBox = ???): OrientedBoundingBox = js.native

    def equals(right: OrientedBoundingBox = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.OrientedBoundingBox")
  object OrientedBoundingBox extends js.Object {
    def fromPoints(positions: js.Array[Cartesian3], result: OrientedBoundingBox = ???): OrientedBoundingBox = js.native

    def fromRectangle(rectangle: Rectangle, minimumHeight: Double = ???, maximumHeight: Double = ???, ellipsoid: Ellipsoid = ???, result: OrientedBoundingBox = ???): OrientedBoundingBox = js.native

    def clone(box: OrientedBoundingBox, result: OrientedBoundingBox = ???): OrientedBoundingBox = js.native

    def intersectPlane(box: OrientedBoundingBox, plane: Plane): Intersect = js.native

    def distanceSquaredTo(box: OrientedBoundingBox, cartesian: Cartesian3): Double = js.native

    def computePlaneDistances(box: OrientedBoundingBox, position: Cartesian3, direction: Cartesian3, result: Interval = ???): Interval = js.native

    def isOccluded(box: OrientedBoundingBox, occluder: Occluder): Boolean = js.native

    def equals(left: OrientedBoundingBox, right: OrientedBoundingBox): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.PinBuilder")
  class PinBuilder extends js.Object {
    def fromColor(color: Color, size: Double): HTMLCanvasElement = js.native

    def fromUrl(url: String, color: Color, size: Double): HTMLCanvasElement | Promise[HTMLCanvasElement] = js.native

    def fromMakiIconId(id: String, color: Color, size: Double): HTMLCanvasElement | Promise[HTMLCanvasElement] = js.native

    def fromText(text: String, color: Color, size: Double): HTMLCanvasElement = js.native
  }

  @js.native
  @JSName("Cesium.Plane")
  class Plane protected() extends js.Object {
    def this(normal: Cartesian3, distance: Double) = this()

    var normal: Cartesian3 = js.native
    var distance: Double = js.native
  }

  @js.native
  @JSName("Cesium.Plane")
  object Plane extends js.Object {
    var ORIGIN_XY_PLANE: Plane = js.native
    var ORIGIN_YZ_PLANE: Plane = js.native
    var ORIGIN_ZX_PLANE: Plane = js.native

    def fromPointNormal(point: Cartesian3, normal: Cartesian3, result: Plane = ???): Plane = js.native

    def fromCartesian4(coefficients: Cartesian4, result: Plane = ???): Plane = js.native

    def getPointDistance(plane: Plane, point: Cartesian3): Double = js.native
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
  @js.native
  @JSName("Cesium.PolygonGeometry")
  class PolygonGeometry protected() extends js.Object {
    def this(options: PolygonGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.PolygonGeometry")
  object PolygonGeometry extends js.Object {
    def fromPositions(options: PolygonGeometryOptions): PolygonGeometry = js.native

    def pack(value: PolygonGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: PolygonGeometry = ???): js.Dynamic = js.native

    def createGeometry(polygonGeometry: PolygonGeometry): Geometry | Unit = js.native
  }

  @js.native
  @JSName("Cesium.PolygonHierarchy")
  class PolygonHierarchy protected() extends js.Object {
    def this(positions: js.Array[Cartesian3] = ???, holes: js.Array[PolygonHierarchy] = ???) = this()

    var positions: js.Array[Cartesian3] = js.native
    var holes: js.Array[PolygonHierarchy] = js.native
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
  @js.native
  @JSName("Cesium.PolygonOutlineGeometry")
  class PolygonOutlineGeometry protected() extends js.Object {
    def this(options: PolygonOutlineGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.PolygonOutlineGeometry")
  object PolygonOutlineGeometry extends js.Object {
    def pack(value: PolygonOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: PolygonOutlineGeometry = ???): PolygonOutlineGeometry = js.native

    def fromPositions(options: js.Any): PolygonOutlineGeometry = js.native

    def createGeometry(polygonGeometry: PolygonOutlineGeometry): Geometry | Unit = js.native
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
  @js.native
  @JSName("Cesium.PolylineGeometry")
  class PolylineGeometry protected() extends js.Object {
    def this(options: PolylineGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.PolylineGeometry")
  object PolylineGeometry extends js.Object {
    def pack(value: PolylineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: PolylineGeometry = ???): PolylineGeometry = js.native

    def createGeometry(polylineGeometry: PolylineGeometry): Geometry | Unit = js.native
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
  @js.native
  @JSName("Cesium.PolylineVolumeGeometry")
  class PolylineVolumeGeometry protected() extends js.Object {
    def this(options: PolylineVolumeGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.PolylineVolumeGeometry")
  object PolylineVolumeGeometry extends js.Object {
    def pack(value: PolylineVolumeGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: PolylineVolumeGeometry = ???): PolylineVolumeGeometry = js.native

    def createGeometry(polylineVolumeGeometry: PolylineVolumeGeometry): Geometry | Unit = js.native
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
  @js.native
  @JSName("Cesium.PolylineVolumeOutlineGeometry")
  class PolylineVolumeOutlineGeometry protected() extends js.Object {
    def this(options: PolylineVolumeOutlineGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.PolylineVolumeOutlineGeometry")
  object PolylineVolumeOutlineGeometry extends js.Object {
    def pack(value: PolylineVolumeOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: PolylineVolumeOutlineGeometry = ???): PolylineVolumeOutlineGeometry = js.native

    def createGeometry(polylineVolumeOutlineGeometry: PolylineVolumeOutlineGeometry): Geometry | Unit = js.native
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
    // todo
    def childTileMask(v: Int) = jsOpt("childTileMask", v)
    def createdByUpsampling(v: Boolean) = jsOpt("createdByUpsampling", v)
    def encodedNormals(v: Uint8Array) = jsOpt("encodedNormals", v)
    def waterMask(v: Uint8Array) = jsOpt("waterMask", v)
  }
  @js.native
  @JSName("Cesium.QuantizedMeshTerrainData")
  class QuantizedMeshTerrainData protected() extends js.Object {
    def this(options: QuantizedMeshTerrainDataOptions) = this()

    var waterMask: Uint8Array | HTMLImageElement | HTMLCanvasElement = js.native

    def upsample(tilingScheme: TilingScheme, thisX: Double, thisY: Double, thisLevel: Double, descendantX: Double, descendantY: Double, descendantLevel: Double): Promise[QuantizedMeshTerrainData] | Unit = js.native

    def interpolateHeight(rectangle: Rectangle, longitude: Double, latitude: Double): Double = js.native

    def isChildAvailable(thisX: Double, thisY: Double, childX: Double, childY: Double): Boolean = js.native

    def wasCreatedByUpsampling(): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.Quaternion")
  class Quaternion protected() extends js.Object {
    def this(x: Double = ???, y: Double = ???, z: Double = ???, w: Double = ???) = this()

    var x: Double = js.native
    var y: Double = js.native
    var z: Double = js.native
    var w: Double = js.native

    def clone(result: Quaternion = ???): Quaternion = js.native

    def equals(right: Quaternion = ???): Boolean = js.native

    def equalsEpsilon(right: Quaternion, epsilon: Double): Boolean = js.native

    override def toString(): String = js.native
  }

  @js.native
  @JSName("Cesium.Quaternion")
  object Quaternion extends js.Object {
    var packedLength: Double = js.native
    var packedInterpolationLength: Double = js.native
    var ZERO: Quaternion = js.native
    var IDENTITY: Quaternion = js.native

    def fromAxisAngle(axis: Cartesian3, angle: Double, result: Quaternion = ???): Quaternion = js.native

    def fromRotationMatrix(matrix: Matrix3, result: Quaternion = ???): Quaternion = js.native

    def fromHeadingPitchRoll(heading: Double, pitch: Double, roll: Double, result: Quaternion = ???): Quaternion = js.native

    def pack(value: Quaternion, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: Quaternion = ???): Quaternion = js.native

    def convertPackedArrayForInterpolation(packedArray: js.Array[Double], startingIndex: Double, lastIndex: Double, result: js.Array[Double]): js.Dynamic = js.native

    def unpackInterpolationResult(array: js.Array[Double], sourceArray: js.Array[Double], startingIndex: Double = ???, lastIndex: Double = ???, result: Quaternion = ???): Quaternion = js.native

    def clone(quaternion: Quaternion, result: Quaternion = ???): Quaternion = js.native

    def conjugate(quaternion: Quaternion, result: Quaternion): Quaternion = js.native

    def magnitudeSquared(quaternion: Quaternion): Double = js.native

    def magnitude(quaternion: Quaternion): Double = js.native

    def normalize(quaternion: Quaternion, result: Quaternion): Quaternion = js.native

    def inverse(quaternion: Quaternion, result: Quaternion): Quaternion = js.native

    def add(left: Quaternion, right: Quaternion, result: Quaternion): Quaternion = js.native

    def subtract(left: Quaternion, right: Quaternion, result: Quaternion): Quaternion = js.native

    def negate(quaternion: Quaternion, result: Quaternion): Quaternion = js.native

    def dot(left: Quaternion, right: Quaternion): Double = js.native

    def multiply(left: Quaternion, right: Quaternion, result: Quaternion): Quaternion = js.native

    def multiplyByScalar(quaternion: Quaternion, scalar: Double, result: Quaternion): Quaternion = js.native

    def divideByScalar(quaternion: Quaternion, scalar: Double, result: Quaternion): Quaternion = js.native

    def computeAxis(quaternion: Quaternion, result: Cartesian3): Cartesian3 = js.native

    def computeAngle(quaternion: Quaternion): Double = js.native

    def lerp(start: Quaternion, end: Quaternion, t: Double, result: Quaternion): Quaternion = js.native

    def slerp(start: Quaternion, end: Quaternion, t: Double, result: Quaternion): Quaternion = js.native

    def log(quaternion: Quaternion, result: Cartesian3): Cartesian3 = js.native

    def exp(cartesian: Cartesian3, result: Quaternion): Quaternion = js.native

    def computeInnerQuadrangle(q0: Quaternion, q1: Quaternion, q2: Quaternion, result: Quaternion): Quaternion = js.native

    def squad(q0: Quaternion, q1: Quaternion, s0: Quaternion, s1: Quaternion, t: Double, result: Quaternion): Quaternion = js.native

    def fastSlerp(start: Quaternion, end: Quaternion, t: Double, result: Quaternion): Quaternion = js.native

    def fastSquad(q0: Quaternion, q1: Quaternion, s0: Quaternion, s1: Quaternion, t: Double, result: Quaternion): Quaternion = js.native

    def equals(left: Quaternion = ???, right: Quaternion = ???): Boolean = js.native

    def equalsEpsilon(left: Quaternion, right: Quaternion, epsilon: Double): Boolean = js.native
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
  @js.native
  @JSName("Cesium.QuaternionSpline")
  class QuaternionSpline protected() extends js.Object {
    def this(options: QuaternionSplineOptions) = this()

    var times: js.Array[Double] = js.native
    var points: js.Array[Quaternion] = js.native
    var innerQuadrangles: js.Array[Quaternion] = js.native

    def findTimeInterval(time: Double): Double = js.native

    def evaluate(time: Double, result: Quaternion = ???): Quaternion = js.native
  }

  @JSName("Cesium.Queue")
  @js.native
  object Queue extends js.Object {
    type Comparator = js.Function2[js.Any, js.Any, Double]
  }

  @js.native
  @JSName("Cesium.Queue")
  class Queue extends js.Object {
    var length: Double = js.native

    def enqueue(item: js.Any): js.Dynamic = js.native

    def dequeue(): js.Dynamic = js.native

    def peek(): js.Dynamic = js.native

    def contains(item: js.Any): js.Dynamic = js.native

    def clear(): js.Dynamic = js.native

    def sort(compareFunction: Queue.Comparator): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.Ray")
  class Ray protected() extends js.Object {
    def this(origin: Cartesian3 = ???, direction: Cartesian3 = ???) = this()

    var origin: Cartesian3 = js.native
    var direction: Cartesian3 = js.native
  }

  @js.native
  @JSName("Cesium.Ray")
  object Ray extends js.Object {
    def getPoint(ray: Ray, t: Double, result: Cartesian3 = ???): Cartesian3 = js.native
  }

  @js.native
  @JSName("Cesium.Rectangle")
  class Rectangle protected() extends js.Object {
    def this(west: Double = ???, south: Double = ???, east: Double = ???, north: Double = ???) = this()

    var west: Double = js.native
    var south: Double = js.native
    var east: Double = js.native
    var north: Double = js.native
    var width: Double = js.native
    var height: Double = js.native

    def clone(result: Rectangle = ???): Rectangle = js.native

    def equals(other: Rectangle = ???): Boolean = js.native

    def equalsEpsilon(other: Rectangle, epsilon: Double): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.Rectangle")
  object Rectangle extends js.Object {
    var packedLength: Double = js.native
    var MAX_VALUE: Rectangle = js.native

    def pack(value: Rectangle, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: Rectangle = ???): Rectangle = js.native

    def computeWidth(rectangle: Rectangle): Double = js.native

    def computeHeight(rectangle: Rectangle): Double = js.native

    def fromDegrees(west: Double = ???, south: Double = ???, east: Double = ???, north: Double = ???, result: Rectangle = ???): Rectangle = js.native

    def fromCartographicArray(cartographics: js.Array[Cartographic], result: Rectangle = ???): Rectangle = js.native

    def clone(rectangle: Rectangle, result: Rectangle = ???): Rectangle = js.native

    def equals(left: Rectangle = ???, right: Rectangle = ???): Boolean = js.native

    def validate(rectangle: Rectangle): js.Dynamic = js.native

    def southwest(rectangle: Rectangle, result: Cartographic = ???): Cartographic = js.native

    def northwest(rectangle: Rectangle, result: Cartographic = ???): Cartographic = js.native

    def northeast(rectangle: Rectangle, result: Cartographic = ???): Cartographic = js.native

    def southeast(rectangle: Rectangle, result: Cartographic = ???): Cartographic = js.native

    def center(rectangle: Rectangle, result: Cartographic = ???): Cartographic = js.native

    def intersection(rectangle: Rectangle, otherRectangle: Rectangle, result: Rectangle = ???): Rectangle | Unit = js.native

    def union(rectangle: Rectangle, otherRectangle: Rectangle, result: Rectangle = ???): Rectangle = js.native

    def expand(rectangle: Rectangle, cartographic: Cartographic, result: Rectangle = ???): Rectangle = js.native

    def contains(rectangle: Rectangle, cartographic: Cartographic): Boolean = js.native

    def subsample(rectangle: Rectangle, ellipsoid: Ellipsoid = ???, surfaceHeight: Double = ???, result: js.Array[Cartesian3] = ???): js.Array[Cartesian3] = js.native
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
  @js.native
  @JSName("Cesium.RectangleGeometry")
  class RectangleGeometry protected() extends js.Object {
    def this(options: RectangleGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.RectangleGeometry")
  object RectangleGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: RectangleGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: RectangleGeometry = ???): RectangleGeometry = js.native

    def createGeometry(rectangleGeometry: RectangleGeometry): Geometry | Unit = js.native
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
  @js.native
  @JSName("Cesium.RectangleOutlineGeometry")
  class RectangleOutlineGeometry protected() extends js.Object {
    def this(options: RectangleOutlineGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.RectangleOutlineGeometry")
  object RectangleOutlineGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: RectangleOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: RectangleOutlineGeometry = ???): RectangleOutlineGeometry = js.native

    def createGeometry(rectangleGeometry: RectangleOutlineGeometry): Geometry | Unit = js.native
  }

  @js.native
  @JSName("Cesium.RequestErrorEvent")
  class RequestErrorEvent protected() extends js.Object {
    def this(statusCode: Double = ???, response: js.Any = ???, responseHeaders: String | js.Any = ???) = this()

    var statusCode: Double = js.native
    var response: js.Any = js.native
    var responseHeaders: js.Any = js.native

    override def toString(): String = js.native
  }

  @js.native
  @JSName("Cesium.RuntimeError")
  class RuntimeError protected() extends js.Object {
    def this(message: String = ???) = this()

    var name: String = js.native
    var message: String = js.native
    var stack: String = js.native
  }

  @js.native
  @JSName("Cesium.ScreenSpaceEventHandler")
  class ScreenSpaceEventHandler protected() extends js.Object {
    def this(element: HTMLCanvasElement = ???) = this()

    def setInputAction(action: js.Function, `type`: Double, modifier: Double = ???): js.Dynamic = js.native

    def getInputAction(`type`: Double, modifier: Double = ???): js.Dynamic = js.native

    def removeInputAction(`type`: Double, modifier: Double = ???): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  @js.native
  @JSName("Cesium.ShowGeometryInstanceAttribute")
  class ShowGeometryInstanceAttribute protected() extends js.Object {
    def this(show: Boolean = ???) = this()

    var value: Uint8Array = js.native
    var componentDatatype: ComponentDatatype = js.native
    var componentsPerAttribute: Double = js.native
    var normalize: Boolean = js.native
  }

  @js.native
  @JSName("Cesium.ShowGeometryInstanceAttribute")
  object ShowGeometryInstanceAttribute extends js.Object {
    def toValue(show: Boolean, result: Uint8Array = ???): Uint8Array = js.native
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
  @js.native
  @JSName("Cesium.SimplePolylineGeometry")
  class SimplePolylineGeometry protected() extends js.Object {
    def this(options: SimplePolylineGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.SimplePolylineGeometry")
  object SimplePolylineGeometry extends js.Object {
    def pack(value: SimplePolylineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: SimplePolylineGeometry = ???): SimplePolylineGeometry = js.native

    def createGeometry(simplePolylineGeometry: SimplePolylineGeometry): Geometry = js.native
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
  @js.native
  @JSName("Cesium.SphereGeometry")
  class SphereGeometry protected() extends js.Object {
    def this(options: SphereGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.SphereGeometry")
  object SphereGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: SphereGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: SphereGeometry = ???): SphereGeometry = js.native

    def createGeometry(sphereGeometry: SphereGeometry): Geometry = js.native
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
  @js.native
  @JSName("Cesium.SphereOutlineGeometry")
  class SphereOutlineGeometry protected() extends js.Object {
    def this(options: SphereOutlineGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.SphereOutlineGeometry")
  object SphereOutlineGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: SphereOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: SphereOutlineGeometry = ???): SphereOutlineGeometry = js.native

    def createGeometry(sphereGeometry: SphereOutlineGeometry): Geometry = js.native
  }

  @js.native
  @JSName("Cesium.Spherical")
  class Spherical protected() extends js.Object {
    def this(clock: Double = ???, cone: Double = ???, magnitude: Double = ???) = this()

    def equals(other: Spherical): Boolean = js.native

    def clone(result: Spherical = ???): Spherical = js.native

    def equalsEpsilon(other: Spherical, epsilon: Double): Boolean = js.native

    override def toString(): String = js.native
  }

  @js.native
  @JSName("Cesium.Spherical")
  object Spherical extends js.Object {
    def fromCartesian3(cartesian3: Cartesian3, spherical: Spherical = ???): Spherical = js.native

    def clone(spherical: Spherical, result: Spherical = ???): Spherical = js.native

    def normalize(spherical: Spherical, result: Spherical = ???): Spherical = js.native

    def equals(left: Spherical, right: Spherical): Boolean = js.native

    def equalsEpsilon(left: Spherical, right: Spherical, epsilon: Double = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.Spline")
  class Spline extends js.Object {
    var times: js.Array[Double] = js.native
    var points: js.Array[Cartesian3] | js.Array[Quaternion] = js.native

    def evaluate(time: Double, result: Cartesian3 | Quaternion = ???): Cartesian3 | Quaternion = js.native

    def findTimeInterval(time: Double, startIndex: Double): Double = js.native
  }

  @js.native
  @JSName("Cesium.TaskProcessor")
  class TaskProcessor protected() extends js.Object {
    def this(workerName: String, maximumActiveTasks: Double = ???) = this()

    def scheduleTask(parameters: js.Any, transferableObjects: js.Array[js.Any] = ???): Promise[js.Any] | Unit = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  @js.native
  @JSName("Cesium.TerrainData")
  class TerrainData extends js.Object {
    var waterMask: Uint8Array | HTMLImageElement | HTMLCanvasElement = js.native

    def interpolateHeight(rectangle: Rectangle, longitude: Double, latitude: Double): Double = js.native

    def isChildAvailable(thisX: Double, thisY: Double, childX: Double, childY: Double): Boolean = js.native

    def upsample(tilingScheme: TilingScheme, thisX: Double, thisY: Double, thisLevel: Double, descendantX: Double, descendantY: Double, descendantLevel: Double): Promise[TerrainData] | Unit = js.native

    def wasCreatedByUpsampling(): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.TerrainProvider")
  class TerrainProvider extends js.Object {
    var errorEvent: Event = js.native
    var credit: Credit = js.native
    var tilingScheme: TilingScheme = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var hasWaterMask: Boolean = js.native
    var hasVertexNormals: Boolean = js.native

    def requestTileGeometry(x: Double, y: Double, level: Double, throttleRequests: Boolean = ???): Promise[TerrainData] | Unit = js.native

    def getLevelMaximumGeometricError(level: Double): Double = js.native

    def getTileDataAvailable(x: Double, y: Double, level: Double): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.TerrainProvider")
  object TerrainProvider extends js.Object {
    var heightmapTerrainQuality: Double = js.native

    def getRegularGridIndices(width: Double, height: Double): Uint16Array = js.native

    def getEstimatedLevelZeroGeometricErrorForAHeightmap(ellipsoid: Ellipsoid, tileImageWidth: Double, numberOfTilesAtLevelZero: Double): Double = js.native
  }

  @js.native
  @JSName("Cesium.TileProviderError")
  class TileProviderError protected() extends js.Object {
    def this(provider: ImageryProvider | TerrainProvider, message: String, x: Double = ???, y: Double = ???, level: Double = ???, timesRetried: Double = ???, error: Error = ???) = this()

    var provider: ImageryProvider | TerrainProvider = js.native
    var message: String = js.native
    var x: Double = js.native
    var y: Double = js.native
    var level: Double = js.native
    var timesRetried: Double = js.native
    var retry: Boolean = js.native
    var error: Error = js.native
  }

  @js.native
  @JSName("Cesium.TileProviderError")
  object TileProviderError extends js.Object {
    type RetryFunction = js.Function0[Unit]

    def handleError(previousError: TileProviderError, provider: ImageryProvider | TerrainProvider, event: Event, message: String, x: Double, y: Double, level: Double,
                    retryFunction: TileProviderError.RetryFunction, errorDetails: Error = ???): TileProviderError = js.native

    def handleSuccess(previousError: TileProviderError): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.TilingScheme")
  class TilingScheme extends js.Object {
    var ellipsoid: Ellipsoid = js.native
    var rectangle: Rectangle = js.native
    var projection: MapProjection = js.native

    def getNumberOfXTilesAtLevel(level: Double): Double = js.native

    def getNumberOfYTilesAtLevel(level: Double): Double = js.native

    def rectangleToNativeRectangle(rectangle: Rectangle, result: Rectangle = ???): Rectangle = js.native

    def tileXYToNativeRectangle(x: Double, y: Double, level: Double, result: js.Any = ???): Rectangle = js.native

    def tileXYToRectangle(x: Double, y: Double, level: Double, result: js.Any = ???): Rectangle = js.native

    def positionToTileXY(position: Cartographic, level: Double, result: Cartesian2 = ???): Cartesian2 = js.native
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
  @js.native
  @JSName("Cesium.TimeInterval")
  class TimeInterval protected() extends js.Object {
    def this(options: TimeIntervalOptions) = this()

    var start: JulianDate = js.native
    var stop: JulianDate = js.native
    var data: js.Any = js.native
    var isStartIncluded: Boolean = js.native
    var isStopIncluded: Boolean = js.native
    var isEmpty: Boolean = js.native

    def clone(result: TimeInterval = ???): TimeInterval = js.native

    def equals(right: TimeInterval = ???, dataComparer: TimeInterval.DataComparer = ???): Boolean = js.native

    def equalsEpsilon(right: TimeInterval, epsilon: Double, dataComparer: TimeInterval.DataComparer = ???): Boolean = js.native

    override def toString(): String = js.native
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

  @js.native
  @JSName("Cesium.TimeInterval")
  object TimeInterval extends js.Object {
    type MergeCallback = js.Function2[js.Any, js.Any, Any]
    type DataComparer = js.Function2[js.Any, js.Any, Boolean]
    var EMPTY: TimeInterval = js.native

    def fromIso8601(options: Iso8601Options, result: TimeInterval = ???): TimeInterval = js.native

    def toIso8601(timeInterval: TimeInterval, precision: Double = ???): String = js.native

    def clone(timeInterval: TimeInterval = ???, result: TimeInterval = ???): TimeInterval = js.native

    def equals(left: TimeInterval = ???, right: TimeInterval = ???, dataComparer: TimeInterval.DataComparer = ???): Boolean = js.native

    def equalsEpsilon(left: TimeInterval, right: TimeInterval, epsilon: Double, dataComparer: TimeInterval.DataComparer = ???): Boolean = js.native

    def intersect(left: TimeInterval, right: TimeInterval, result: TimeInterval, mergeCallback: TimeInterval.MergeCallback = ???): TimeInterval = js.native

    def contains(timeInterval: TimeInterval, julianDate: JulianDate): Boolean = js.native
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

  @js.native
  @JSName("Cesium.TimeIntervalCollection")
  class TimeIntervalCollection protected() extends js.Object {
    def this(intervals: js.Array[TimeInterval] = ???) = this()

    var changedEvent: Event = js.native
    var start: JulianDate = js.native
    var isStartIncluded: Boolean = js.native
    var stop: JulianDate = js.native
    var isStopIncluded: Boolean = js.native
    var length: Double = js.native
    var isEmpty: Boolean = js.native

    def equals(right: TimeIntervalCollection = ???, dataComparer: TimeInterval.DataComparer = ???): Boolean = js.native

    def get(index: Double): TimeInterval = js.native

    def removeAll(): js.Dynamic = js.native

    def findIntervalContainingDate(date: JulianDate): TimeInterval | Unit = js.native

    def findDataForIntervalContainingDate(date: JulianDate): js.Dynamic = js.native

    def contains(julianDate: JulianDate): Boolean = js.native

    def indexOf(date: JulianDate): Double = js.native

    def findInterval(options: FindIntervalOptions): TimeInterval = js.native

    def addInterval(interval: TimeInterval, dataComparer: TimeInterval.DataComparer = ???): js.Dynamic = js.native

    def removeInterval(interval: TimeInterval): js.Dynamic = js.native

    def intersect(other: TimeIntervalCollection, dataComparer: TimeInterval.DataComparer = ???, mergeCallback: TimeInterval.MergeCallback = ???): TimeIntervalCollection = js.native
  }

  @js.native
  @JSName("Cesium.TranslationRotationScale")
  class TranslationRotationScale protected() extends js.Object {
    def this(translation: Cartesian3 = ???, rotation: Quaternion = ???, scale: Cartesian3 = ???) = this()

    var translation: Cartesian3 = js.native
    var rotation: Quaternion = js.native
    var scale: Cartesian3 = js.native

    def equals(right: TranslationRotationScale = ???): Boolean = js.native
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
  @js.native
  @JSName("Cesium.VRTheWorldTerrainProvider")
  class VRTheWorldTerrainProvider protected() extends js.Object {
    def this(options: VRTheWorldTerrainProviderOptions) = this()

    var errorEvent: Event = js.native
    var credit: Credit = js.native
    var tilingScheme: GeographicTilingScheme = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var hasWaterMask: Boolean = js.native
    var hasVertexNormals: Boolean = js.native

    def requestTileGeometry(x: Double, y: Double, level: Double, throttleRequests: Boolean = ???): Promise[TerrainData] | Unit = js.native

    def getLevelMaximumGeometricError(level: Double): Double = js.native

    def getTileDataAvailable(x: Double, y: Double, level: Double): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.VertexFormat")
  class VertexFormat protected() extends js.Object {
    def this(options: js.Any = ???) = this()    //  todo options object

    var position: Boolean = js.native
    var normal: Boolean = js.native
    var st: Boolean = js.native
    var binormal: Boolean = js.native
    var tangent: Boolean = js.native
    var color: Boolean = js.native
  }

  @js.native
  @JSName("Cesium.VertexFormat")
  object VertexFormat extends js.Object {
    var POSITION_ONLY: VertexFormat = js.native
    var POSITION_AND_NORMAL: VertexFormat = js.native
    var POSITION_NORMAL_AND_ST: VertexFormat = js.native
    var POSITION_AND_ST: VertexFormat = js.native
    var POSITION_AND_COLOR: VertexFormat = js.native
    var ALL: VertexFormat = js.native
    var DEFAULT: VertexFormat = js.native
    var packedLength: Double = js.native

    def pack(value: VertexFormat, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: VertexFormat = ???): VertexFormat = js.native

    def clone(cartesian: VertexFormat, result: VertexFormat = ???): VertexFormat = js.native
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
  @js.native
  @JSName("Cesium.VideoSynchronizer")
  class VideoSynchronizer protected() extends js.Object {
    def this(options: VideoSynchronizerOptions) = this()

    var epoch: JulianDate = js.native
    var tolerance: Double = js.native
    var clock: Clock = js.native
    var element: HTMLVideoElement = js.native

    def destroy(): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native
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
  @js.native
  @JSName("Cesium.WallGeometry")
  class WallGeometry protected() extends js.Object {
    def this(options: WallGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.WallGeometry")
  object WallGeometry extends js.Object {
    def pack(value: WallGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: WallGeometry = ???): WallGeometry = js.native

    def fromConstantHeights(options: ConstantHeightsOptions): WallGeometry = js.native

    def createGeometry(wallGeometry: WallGeometry): Geometry | Unit = js.native
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

  @js.native
  @JSName("Cesium.WallOutlineGeometry")
  class WallOutlineGeometry protected() extends js.Object {
    def this(options: WallOutlineGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.WallOutlineGeometry")
  object WallOutlineGeometry extends js.Object {
    def pack(value: WallOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Dynamic = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: WallOutlineGeometry = ???): WallOutlineGeometry = js.native

    def fromConstantHeights(options: WallOutlineGeometryOptions): WallOutlineGeometry = js.native

    def createGeometry(wallGeometry: WallOutlineGeometry): Geometry | Unit = js.native
  }

  @js.native
  @JSName("Cesium.WebMercatorProjection")
  class WebMercatorProjection protected() extends js.Object {
    def this(ellipsoid: Ellipsoid = ???) = this()

    var ellipsoid: Ellipsoid = js.native

    def project(cartographic: Cartographic, result: Cartesian3 = ???): Cartesian3 = js.native

    def unproject(cartesian: Cartesian3, result: Cartographic = ???): Cartographic = js.native
  }

  @js.native
  @JSName("Cesium.WebMercatorProjection")
  object WebMercatorProjection extends js.Object {
    var MaximumLatitude: Double = js.native

    def mercatorAngleToGeodeticLatitude(mercatorAngle: Double): Double = js.native

    def geodeticLatitudeToMercatorAngle(latitude: Double): Double = js.native
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
  @js.native
  @JSName("Cesium.WebMercatorTilingScheme")
  class WebMercatorTilingScheme protected() extends js.Object {
    def this(options: WebMercatorTilingSchemeOptions) = this()

    var ellipsoid: Ellipsoid = js.native
    var rectangle: Rectangle = js.native
    var projection: MapProjection = js.native

    def getNumberOfXTilesAtLevel(level: Double): Double = js.native

    def getNumberOfYTilesAtLevel(level: Double): Double = js.native

    def rectangleToNativeRectangle(rectangle: Rectangle, result: Rectangle = ???): Rectangle = js.native

    def tileXYToNativeRectangle(x: Double, y: Double, level: Double, result: js.Any = ???): Rectangle = js.native

    def tileXYToRectangle(x: Double, y: Double, level: Double, result: js.Any = ???): Rectangle = js.native

    def positionToTileXY(position: Cartographic, level: Double, result: Cartesian2 = ???): Cartesian2 = js.native
  }
  //------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------


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

  @js.native
  @JSName("Cesium.BillboardGraphics")
  class BillboardGraphics protected() extends js.Object {
    def this(options: BillboardGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var image: Property = js.native
    var imageSubRegion: Property = js.native
    var scale: Property = js.native
    var rotation: Property = js.native
    var alignedAxis: Property = js.native
    var horizontalOrigin: Property = js.native
    var verticalOrigin: Property = js.native
    var color: Property = js.native
    var eyeOffset: Property = js.native
    var pixelOffset: Property = js.native
    var show: Property = js.native
    var width: Property = js.native
    var height: Property = js.native
    var scaleByDistance: Property = js.native
    var translucencyByDistance: Property = js.native
    var pixelOffsetScaleByDistance: Property = js.native
    var sizeInMeters: Property = js.native

    def clone(result: BillboardGraphics = ???): BillboardGraphics = js.native

    def merge(source: BillboardGraphics): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.BillboardVisualizer")
  class BillboardVisualizer protected() extends js.Object {
    def this(scene: Scene, entityCollection: EntityCollection) = this()

    def update(time: JulianDate): Boolean = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.BoxGeometryUpdater")
  class BoxGeometryUpdater protected() extends js.Object {
    def this(entity: Entity, scene: Scene) = this()

    var entity: Entity = js.native
    var fillEnabled: Boolean = js.native
    var hasConstantFill: Boolean = js.native
    var fillMaterialProperty: MaterialProperty = js.native
    var outlineEnabled: Boolean = js.native
    var hasConstantOutline: Boolean = js.native
    var outlineColorProperty: Property = js.native
    var outlineWidth: Double = js.native
    var isDynamic: Boolean = js.native
    var isClosed: Boolean = js.native
    var geometryChanged: Boolean = js.native

    def isOutlineVisible(time: JulianDate): Boolean = js.native

    def isFilled(time: JulianDate): Boolean = js.native

    def createFillGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def createOutlineGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def createDynamicUpdater(primitives: PrimitiveCollection): DynamicGeometryUpdater = js.native
  }

  @js.native
  @JSName("Cesium.BoxGeometryUpdater")
  object BoxGeometryUpdater extends js.Object {
    var perInstanceColorAppearanceType: Appearance = js.native
    var materialAppearanceType: Appearance = js.native
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
  @js.native
  @JSName("Cesium.BoxGraphics")
  class BoxGraphics protected() extends js.Object {
    def this(options: BoxGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var show: Property = js.native
    var dimensions: Property = js.native
    var material: MaterialProperty = js.native
    var fill: Property = js.native
    var outline: Property = js.native
    var outlineColor: Property = js.native
    var outlineWidth: Property = js.native

    def clone(result: BoxGraphics = ???): BoxGraphics = js.native

    def merge(source: BoxGraphics): js.Dynamic = js.native
  }

  @JSName("Cesium.CallbackProperty")
  @js.native
  object CallbackProperty extends js.Object {
    type Callback = js.Function2[JulianDate, js.Any, Any]
  }

  @js.native
  @JSName("Cesium.CallbackProperty")
  class CallbackProperty protected() extends js.Object {
    def this(callback: CallbackProperty.Callback, isConstant: Boolean) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native

    def getValue(time: JulianDate = ???, result: js.Any = ???): js.Dynamic = js.native

    def setCallback(callback: CallbackProperty.Callback, isConstant: Boolean): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
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
  @js.native
  @JSName("Cesium.CheckerboardMaterialProperty")
  class CheckerboardMaterialProperty protected() extends js.Object {
    def this(options: CheckerboardMaterialPropertyOptions) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var evenColor: Property = js.native
    var oddColor: Property = js.native
    var repeat: Property = js.native

    def getType(time: JulianDate): String = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.ColorMaterialProperty")
  class ColorMaterialProperty protected() extends js.Object {
    def this(color: Property = ???) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var color: Property = js.native

    def getType(time: JulianDate): String = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.CompositeEntityCollection")
  class CompositeEntityCollection protected() extends js.Object {
    def this(collections: js.Array[EntityCollection] = ???, owner: DataSource | CompositeEntityCollection = ???) = this()

    var collectionChanged: Event = js.native
    var id: String = js.native
    var values: js.Array[Entity] = js.native
    var owner: DataSource | CompositeEntityCollection = js.native

    def addCollection(collection: EntityCollection, index: Double = ???): js.Dynamic = js.native

    def removeCollection(collection: EntityCollection): Boolean = js.native

    def removeAllCollections(): js.Dynamic = js.native

    def containsCollection(collection: EntityCollection): Boolean = js.native

    def contains(entity: Entity): Boolean = js.native

    def indexOfCollection(collection: EntityCollection): Double = js.native

    def getCollection(index: Double): js.Dynamic = js.native

    def getCollectionsLength(): js.Dynamic = js.native

    def raiseCollection(collection: EntityCollection): js.Dynamic = js.native

    def lowerCollection(collection: EntityCollection): js.Dynamic = js.native

    def raiseCollectionToTop(collection: EntityCollection): js.Dynamic = js.native

    def lowerCollectionToBottom(collection: EntityCollection): js.Dynamic = js.native

    def suspendEvents(): js.Dynamic = js.native

    def resumeEvents(): js.Dynamic = js.native

    def computeAvailability(): TimeInterval = js.native

    def getById(id: js.Any): Entity = js.native
  }

  @js.native
  @JSName("Cesium.CompositeMaterialProperty")
  class CompositeMaterialProperty extends js.Object {
    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var intervals: TimeIntervalCollection = js.native

    def getType(time: JulianDate): String = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.CompositePositionProperty")
  class CompositePositionProperty protected() extends js.Object {
    def this(referenceFrame: ReferenceFrame = ???) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var intervals: TimeIntervalCollection = js.native
    var referenceFrame: ReferenceFrame = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def getValueInReferenceFrame(time: JulianDate, referenceFrame: ReferenceFrame, result: Cartesian3 = ???): Cartesian3 = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.CompositeProperty")
  class CompositeProperty extends js.Object {
    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var intervals: TimeIntervalCollection = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.ConstantPositionProperty")
  class ConstantPositionProperty protected() extends js.Object {
    def this(value: Cartesian3 = ???, referenceFrame: ReferenceFrame = ???) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var referenceFrame: ReferenceFrame = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def setValue(value: Cartesian3, referenceFrame: ReferenceFrame = ???): js.Dynamic = js.native

    def getValueInReferenceFrame(time: JulianDate, referenceFrame: ReferenceFrame, result: Cartesian3 = ???): Cartesian3 = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.ConstantProperty")
  class ConstantProperty protected() extends js.Object {
    def this(value: js.Any = ???) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native

    def getValue(time: JulianDate = ???, result: js.Any = ???): js.Dynamic = js.native

    def setValue(value: js.Any): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.CorridorGeometryUpdater")
  class CorridorGeometryUpdater protected() extends js.Object {
    def this(entity: Entity, scene: Scene) = this()

    var entity: Entity = js.native
    var fillEnabled: Boolean = js.native
    var hasConstantFill: Boolean = js.native
    var fillMaterialProperty: MaterialProperty = js.native
    var outlineEnabled: Boolean = js.native
    var hasConstantOutline: Boolean = js.native
    var outlineColorProperty: Property = js.native
    var outlineWidth: Double = js.native
    var isDynamic: Boolean = js.native
    var isClosed: Boolean = js.native
    var geometryChanged: Boolean = js.native

    def isOutlineVisible(time: JulianDate): Boolean = js.native

    def isFilled(time: JulianDate): Boolean = js.native

    def createFillGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def createOutlineGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def createDynamicUpdater(primitives: PrimitiveCollection): DynamicGeometryUpdater = js.native
  }

  @js.native
  @JSName("Cesium.CorridorGeometryUpdater")
  object CorridorGeometryUpdater extends js.Object {
    var perInstanceColorAppearanceType: Appearance = js.native
    var materialAppearanceType: Appearance = js.native
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
  @js.native
  @JSName("Cesium.CorridorGraphics")
  class CorridorGraphics protected() extends js.Object {
    def this(options: CorridorGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var show: Property = js.native
    var material: MaterialProperty = js.native
    var positions: Property = js.native
    var height: Property = js.native
    var extrudedHeight: Property = js.native
    var granularity: Property = js.native
    var width: Property = js.native
    var fill: Property = js.native
    var outline: Property = js.native
    var outlineColor: Property = js.native
    var outlineWidth: Property = js.native
    var cornerType: Property = js.native

    def clone(result: CorridorGraphics = ???): CorridorGraphics = js.native

    def merge(source: CorridorGraphics): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.CustomDataSource")
  class CustomDataSource protected() extends js.Object {
    def this(name: String = ???) = this()

    var name: String = js.native
    var clock: DataSourceClock = js.native
    var entities: EntityCollection = js.native
    var isLoading: Boolean = js.native
    var changedEvent: Event = js.native
    var errorEvent: Event = js.native
    var loadingEvent: Event = js.native
    var show: Boolean = js.native
  }

  @js.native
  @JSName("Cesium.CylinderGeometryUpdater")
  class CylinderGeometryUpdater protected() extends js.Object {
    def this(entity: Entity, scene: Scene) = this()

    var entity: Entity = js.native
    var fillEnabled: Boolean = js.native
    var hasConstantFill: Boolean = js.native
    var fillMaterialProperty: MaterialProperty = js.native
    var outlineEnabled: Boolean = js.native
    var hasConstantOutline: Boolean = js.native
    var outlineColorProperty: Property = js.native
    var outlineWidth: Double = js.native
    var isDynamic: Boolean = js.native
    var isClosed: Boolean = js.native
    var geometryChanged: Boolean = js.native

    def isOutlineVisible(time: JulianDate): Boolean = js.native

    def isFilled(time: JulianDate): Boolean = js.native

    def createFillGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def createOutlineGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def createDynamicUpdater(primitives: PrimitiveCollection): DynamicGeometryUpdater = js.native
  }

  @js.native
  @JSName("Cesium.CylinderGeometryUpdater")
  object CylinderGeometryUpdater extends js.Object {
    var perInstanceColorAppearanceType: Appearance = js.native
    var materialAppearanceType: Appearance = js.native
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
  @js.native
  @JSName("Cesium.CylinderGraphics")
  class CylinderGraphics protected() extends js.Object {
    def this(options: CylinderGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var length: Property = js.native
    var topRadius: Property = js.native
    var bottomRadius: Property = js.native
    var numberOfVerticalLines: Property = js.native
    var slices: Property = js.native
    var show: Property = js.native
    var material: MaterialProperty = js.native
    var fill: Property = js.native
    var outline: Property = js.native
    var outlineColor: Property = js.native
    var outlineWidth: Property = js.native

    def clone(result: CylinderGraphics = ???): CylinderGraphics = js.native

    def merge(source: CylinderGraphics): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.CzmlDataSource")
  class CzmlDataSource protected() extends js.Object {
    def this(name: String = ???) = this()

    var name: String = js.native
    var clock: DataSourceClock = js.native
    var entities: EntityCollection = js.native
    var isLoading: Boolean = js.native
    var changedEvent: Event = js.native
    var errorEvent: Event = js.native
    var loadingEvent: Event = js.native
    var show: Boolean = js.native

    def process(czml: String | js.Any, options: js.Any = ???): Promise[CzmlDataSource] = js.native

    def load(czml: String | js.Any, options: js.Any = ???): Promise[CzmlDataSource] = js.native
  }

  @js.native
  @JSName("Cesium.CzmlDataSource")
  object CzmlDataSource extends js.Object {
    var updaters: js.Array[js.Any] = js.native

    def load(data: String | js.Any, options: js.Any = ???): Promise[CzmlDataSource] = js.native

    def processPacketData(`type`: js.Function, `object`: js.Any, propertyName: String, packetData: js.Any, interval: TimeInterval, sourceUri: String, entityCollection: EntityCollection): js.Dynamic = js.native

    def processPositionPacketData(`object`: js.Any, propertyName: String, packetData: js.Any, interval: TimeInterval, sourceUri: String, entityCollection: EntityCollection): js.Dynamic = js.native

    def processMaterialPacketData(`object`: js.Any, propertyName: String, packetData: js.Any, interval: TimeInterval, sourceUri: String, entityCollection: EntityCollection): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.DataSource")
  class DataSource extends js.Object {
    var name: String = js.native
    var clock: DataSourceClock = js.native
    var entities: EntityCollection = js.native
    var isLoading: Boolean = js.native
    var changedEvent: Event = js.native
    var errorEvent: Event = js.native
    var loadingEvent: Event = js.native
    var show: Boolean = js.native

    def update(time: JulianDate): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.DataSourceClock")
  class DataSourceClock extends js.Object {
    var definitionChanged: Event = js.native
    var startTime: JulianDate = js.native
    var stopTime: JulianDate = js.native
    var currentTime: JulianDate = js.native
    var clockRange: ClockRange = js.native
    var clockStep: ClockStep = js.native
    var multiplier: Double = js.native

    def clone(result: DataSourceClock = ???): DataSourceClock = js.native

    def equals(other: DataSourceClock): Boolean = js.native

    def merge(source: DataSourceClock): js.Dynamic = js.native

    def getValue(): Clock = js.native
  }

  @js.native
  @JSName("Cesium.DataSourceCollection")
  class DataSourceCollection extends js.Object {
    var length: Double = js.native
    var dataSourceAdded: Event = js.native
    var dataSourceRemoved: Event = js.native

    def add(dataSource: DataSource | Promise[DataSource]): Promise[DataSource] = js.native

    def remove(dataSource: DataSource, destroy: Boolean = ???): Boolean = js.native

    def removeAll(destroy: Boolean = ???): js.Dynamic = js.native

    def contains(dataSource: DataSource): Boolean = js.native

    def indexOf(dataSource: DataSource): Double = js.native

    def get(index: Double): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }


  @js.native
  @JSName("Cesium.DataSourceDisplay")
  object DataSourceDisplay extends js.Object {
    type VisualizersCallback = js.Function2[Scene, DataSource, js.Array[Visualizer]]
    var defaultVisualizersCallback: DataSourceDisplay.VisualizersCallback = js.native
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
  @js.native
  @JSName("Cesium.DataSourceDisplay")
  class DataSourceDisplay protected() extends js.Object {
    def this(options: DataSourceDisplayOptions) = this()

    var scene: Scene = js.native
    var dataSources: DataSourceCollection = js.native
    var defaultDataSource: CustomDataSource = js.native
    var ready: Boolean = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native

    def update(time: JulianDate): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.DynamicGeometryUpdater")
  class DynamicGeometryUpdater extends js.Object {
    def update(time: JulianDate): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.EllipseGeometryUpdater")
  class EllipseGeometryUpdater protected() extends js.Object {
    def this(entity: Entity, scene: Scene) = this()

    var entity: Entity = js.native
    var fillEnabled: Boolean = js.native
    var hasConstantFill: Boolean = js.native
    var fillMaterialProperty: MaterialProperty = js.native
    var outlineEnabled: Boolean = js.native
    var hasConstantOutline: Boolean = js.native
    var outlineColorProperty: Property = js.native
    var outlineWidth: Double = js.native
    var isDynamic: Boolean = js.native
    var isClosed: Boolean = js.native
    var geometryChanged: Boolean = js.native

    def isOutlineVisible(time: JulianDate): Boolean = js.native

    def isFilled(time: JulianDate): Boolean = js.native

    def createFillGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def createOutlineGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def createDynamicUpdater(primitives: PrimitiveCollection): DynamicGeometryUpdater = js.native
  }

  @js.native
  @JSName("Cesium.EllipseGeometryUpdater")
  object EllipseGeometryUpdater extends js.Object {
    var perInstanceColorAppearanceType: Appearance = js.native
    var materialAppearanceType: Appearance = js.native
  }


  @JSName("Cesium.Options")
  @js.native
  trait EllipseGraphicsOptions extends js.Object

  object EllipseGraphicsOptions extends EllipseGraphicsOptionsBuilder(noOpts)

  class EllipseGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EllipseGraphicsOptions, EllipseGraphicsOptionsBuilder](new EllipseGraphicsOptionsBuilder(_)) {

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
  @js.native
  @JSName("Cesium.EllipseGraphics")
  class EllipseGraphics protected() extends js.Object {
    def this(options: EllipseGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var semiMajorAxis: Property = js.native
    var semiMinorAxis: Property = js.native
    var rotation: Property = js.native
    var show: Property = js.native
    var material: MaterialProperty = js.native
    var height: Property = js.native
    var extrudedHeight: Property = js.native
    var granularity: Property = js.native
    var stRotation: Property = js.native
    var fill: Property = js.native
    var outline: Property = js.native
    var outlineColor: Property = js.native
    var outlineWidth: Property = js.native
    var numberOfVerticalLines: Property = js.native

    def clone(result: EllipseGraphics = ???): EllipseGraphics = js.native

    def merge(source: EllipseGraphics): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.EllipsoidGeometryUpdater")
  class EllipsoidGeometryUpdater protected() extends js.Object {
    def this(entity: Entity, scene: Scene) = this()

    var entity: Entity = js.native
    var fillEnabled: Boolean = js.native
    var hasConstantFill: Boolean = js.native
    var fillMaterialProperty: MaterialProperty = js.native
    var outlineEnabled: Boolean = js.native
    var hasConstantOutline: Boolean = js.native
    var outlineColorProperty: Property = js.native
    var outlineWidth: Double = js.native
    var isDynamic: Boolean = js.native
    var isClosed: Boolean = js.native
    var geometryChanged: Boolean = js.native

    def isOutlineVisible(time: JulianDate): Boolean = js.native

    def isFilled(time: JulianDate): Boolean = js.native

    def createFillGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def createOutlineGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def createDynamicUpdater(primitives: PrimitiveCollection): DynamicGeometryUpdater = js.native
  }

  @js.native
  @JSName("Cesium.EllipsoidGeometryUpdater")
  object EllipsoidGeometryUpdater extends js.Object {
    var perInstanceColorAppearanceType: Appearance = js.native
    var materialAppearanceType: Appearance = js.native
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
  @js.native
  @JSName("Cesium.EllipsoidGraphics")
  class EllipsoidGraphics protected() extends js.Object {
    def this(options: EllipsoidGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var show: Property = js.native
    var radii: Property = js.native
    var material: MaterialProperty = js.native
    var fill: Property = js.native
    var outline: Property = js.native
    var outlineColor: Property = js.native
    var outlineWidth: Property = js.native
    var stackPartitions: Property = js.native
    var slicePartitions: Property = js.native
    var subdivisions: Property = js.native

    def clone(result: EllipsoidGraphics = ???): EllipsoidGraphics = js.native

    def merge(source: EllipsoidGraphics): js.Dynamic = js.native
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
    def model(v: 	ModelGraphics) = jsOpt("model", v)
    def path(v: PathGraphics) = jsOpt("path", v)
    def point(v: 	PointGraphics) = jsOpt("point", v)
    def polygon(v: PolygonGraphics) = jsOpt("polygon", v)
    def polyline(v: 	PolylineGraphics) = jsOpt("polyline", v)
    def polylineVolume(v: PolylineVolumeGraphics) = jsOpt("polylineVolume", v)
    def rectangle(v: RectangleGraphics) = jsOpt("rectangle", v)
    def wall(v: WallGraphics) = jsOpt("wall", v)
  }
  @js.native
  @JSName("Cesium.Entity")
  class Entity protected() extends js.Object {
    def this(options: EntityOptions) = this()

    var entityCollection: EntityCollection = js.native
    var availability: TimeIntervalCollection = js.native
    var id: String = js.native
    var definitionChanged: Event = js.native
    var name: String = js.native
    var show: Boolean = js.native
    var isShowing: Boolean = js.native
    var parent: Entity = js.native
    var propertyNames: js.Array[js.Any] = js.native
    var billboard: BillboardGraphics = js.native
    var box: BoxGraphics = js.native
    var corridor: CorridorGraphics = js.native
    var cylinder: CylinderGraphics = js.native
    var description: Property = js.native
    var ellipse: EllipseGraphics = js.native
    var ellipsoid: EllipsoidGraphics = js.native
    var label: LabelGraphics = js.native
    var model: ModelGraphics = js.native
    var orientation: Property = js.native
    var path: PathGraphics = js.native
    var point: PointGraphics = js.native
    var polygon: PolygonGraphics = js.native
    var polyline: PolylineGraphics = js.native
    var polylineVolume: PolylineVolumeGraphics = js.native
    var position: PositionProperty = js.native
    var rectangle: RectangleGraphics = js.native
    var viewFrom: Property = js.native
    var wall: WallGraphics = js.native

    def isAvailable(time: JulianDate): Boolean = js.native

    def addProperty(propertyName: String): js.Dynamic = js.native

    def removeProperty(propertyName: String): js.Dynamic = js.native

    def merge(source: Entity): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.EntityCollection")
  class EntityCollection protected() extends js.Object {
    def this(owner: DataSource | CompositeEntityCollection = ???) = this()

    var collectionChanged: Event = js.native
    var id: String = js.native
    var values: js.Array[Entity] = js.native
    var show: Boolean = js.native
    var owner: DataSource | CompositeEntityCollection = js.native

    def suspendEvents(): js.Dynamic = js.native

    def resumeEvents(): js.Dynamic = js.native

    def computeAvailability(): TimeInterval = js.native

    def add(entity: Entity): Entity = js.native

    def remove(entity: Entity): Boolean = js.native

    def contains(entity: Entity): Boolean = js.native

    def removeById(id: js.Any): Boolean = js.native

    def removeAll(): js.Dynamic = js.native

    def getById(id: js.Any): Entity = js.native

    def getOrCreateEntity(id: js.Any): Entity = js.native
  }

  @js.native
  @JSName("Cesium.EntityCollection")
  object EntityCollection extends js.Object {
    def collectionChangedEventCallback(collection: EntityCollection, added: js.Array[Entity], removed: js.Array[Entity], changed: js.Array[Entity]): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.EntityView")
  class EntityView protected() extends js.Object {
    def this(entity: Entity, scene: Scene, ellipsoid: Ellipsoid = ???, boundingSphere: BoundingSphere = ???) = this()

    var entity: Entity = js.native
    var scene: Scene = js.native
    var ellipsoid: Ellipsoid = js.native
    var boundingSphere: Entity = js.native

    def update(time: JulianDate): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.EntityView")
  object EntityView extends js.Object {
    var defaultOffset3D: Cartesian3 = js.native
  }

  @js.native
  @JSName("Cesium.GeoJsonDataSource")
  class GeoJsonDataSource protected() extends js.Object {
    def this(name: String = ???) = this()

    var name: String = js.native
    var clock: DataSourceClock = js.native
    var entities: EntityCollection = js.native
    var isLoading: Boolean = js.native
    var changedEvent: Event = js.native
    var errorEvent: Event = js.native
    var loadingEvent: Event = js.native
    var show: Boolean = js.native

    def load(data: String | js.Any, options: js.Any = ???): Promise[GeoJsonDataSource] = js.native
  }

  @js.native
  @JSName("Cesium.GeoJsonDataSource")
  object GeoJsonDataSource extends js.Object {
    type describe = js.Function2[js.Any, String, Unit]
    var markerSize: Double = js.native
    var markerSymbol: String = js.native
    var markerColor: Color = js.native
    var stroke: Color = js.native
    var strokeWidth: Double = js.native
    var fill: Color = js.native
    var crsNames: js.Any = js.native
    var crsLinkHrefs: js.Any = js.native
    var crsLinkTypes: js.Any = js.native

    def load(data: String | js.Any, options: js.Any = ???): Promise[GeoJsonDataSource] = js.native
  }

  @js.native
  @JSName("Cesium.GeometryUpdater")
  class GeometryUpdater protected() extends js.Object {
    def this(entity: Entity, scene: Scene) = this()

    var entity: Entity = js.native
    var fillEnabled: Boolean = js.native
    var hasConstantFill: Boolean = js.native
    var fillMaterialProperty: MaterialProperty = js.native
    var outlineEnabled: Boolean = js.native
    var hasConstantOutline: Boolean = js.native
    var outlineColorProperty: Property = js.native
    var outlineWidth: Double = js.native
    var isDynamic: Boolean = js.native
    var isClosed: Boolean = js.native
    var geometryChanged: Boolean = js.native

    def isOutlineVisible(time: JulianDate): Boolean = js.native

    def isFilled(time: JulianDate): Boolean = js.native

    def createFillGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def createOutlineGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def createDynamicUpdater(primitives: PrimitiveCollection): DynamicGeometryUpdater = js.native
  }

  @js.native
  @JSName("Cesium.GeometryUpdater")
  object GeometryUpdater extends js.Object {
    var perInstanceColorAppearanceType: Appearance = js.native
    var materialAppearanceType: Appearance = js.native
  }

  @js.native
  @JSName("Cesium.GeometryVisualizer")
  class GeometryVisualizer protected() extends js.Object {
    def this(`type`: GeometryUpdater, scene: Scene, entityCollection: EntityCollection) = this()

    def update(time: JulianDate): Boolean = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
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
  @js.native
  @JSName("Cesium.GridMaterialProperty")
  class GridMaterialProperty protected() extends js.Object {
    def this(options: GridMaterialPropertyOptions) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var color: Property = js.native
    var cellAlpha: Property = js.native
    var lineCount: Property = js.native
    var lineThickness: Property = js.native
    var lineOffset: Property = js.native

    def getType(time: JulianDate): String = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
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
  @js.native
  @JSName("Cesium.ImageMaterialProperty")
  class ImageMaterialProperty protected() extends js.Object {
    def this(options: ImageMaterialPropertyOptions) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var image: Property = js.native
    var repeat: Property = js.native
    var color: Property = js.native
    var transparent: Property = js.native

    def getType(time: JulianDate): String = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.KmlDataSource")
  class KmlDataSource extends js.Object {
    var name: String = js.native
    var clock: DataSourceClock = js.native
    var entities: EntityCollection = js.native
    var isLoading: Boolean = js.native
    var changedEvent: Event = js.native
    var errorEvent: Event = js.native
    var loadingEvent: Event = js.native
    var refreshEvent: Event = js.native
    var show: Boolean = js.native

    def load(data: String | Document | Blob, options: js.Any = ???): Promise[KmlDataSource] = js.native

    def update(time: JulianDate): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.KmlDataSource")
  object KmlDataSource extends js.Object {
    def load(data: String | Document | Blob, options: js.Any = ???): Promise[KmlDataSource] = js.native
  }

  @js.native
  @JSName("Cesium.KmlFeatureData")
  class KmlFeatureData extends js.Object {
    var author: js.Any = js.native
    var link: js.Any = js.native
    var address: String = js.native
    var phoneNumber: String = js.native
    var snippet: String = js.native
    var extendedData: String = js.native
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
  @js.native
  @JSName("Cesium.LabelGraphics")
  class LabelGraphics protected() extends js.Object {
    def this(options: LabelGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var text: Property = js.native
    var font: Property = js.native
    var style: Property = js.native
    var fillColor: Property = js.native
    var outlineColor: Property = js.native
    var outlineWidth: Property = js.native
    var horizontalOrigin: Property = js.native
    var verticalOrigin: Property = js.native
    var eyeOffset: Property = js.native
    var pixelOffset: Property = js.native
    var scale: Property = js.native
    var show: Property = js.native
    var translucencyByDistance: Property = js.native
    var pixelOffsetScaleByDistance: Property = js.native

    def clone(result: LabelGraphics = ???): LabelGraphics = js.native

    def merge(source: LabelGraphics): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.LabelVisualizer")
  class LabelVisualizer protected() extends js.Object {
    def this(scene: Scene, entityCollection: EntityCollection) = this()

    def update(time: JulianDate): Boolean = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.MaterialProperty")
  class MaterialProperty extends js.Object {
    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native

    def getType(time: JulianDate): String = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
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

  }
  @js.native
  @JSName("Cesium.ModelGraphics")
  class ModelGraphics protected() extends js.Object {
    def this(options: ModelGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var show: Property = js.native
    var scale: Property = js.native
    var minimumPixelSize: Property = js.native
    var maximumScale: Property = js.native
    var incrementallyLoadTextures: Property = js.native
    var uri: Property = js.native
    var runAnimations: Property = js.native
    var nodeTransformations: PropertyBag = js.native

    def clone(result: ModelGraphics = ???): ModelGraphics = js.native

    def merge(source: ModelGraphics): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.ModelVisualizer")
  class ModelVisualizer protected() extends js.Object {
    def this(scene: Scene, entityCollection: EntityCollection) = this()

    def update(time: JulianDate): Boolean = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
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
  @js.native
  @JSName("Cesium.NodeTransformationProperty")
  class NodeTransformationProperty protected() extends js.Object {
    def this(options: NodeTransformationPropertyOptions) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var translation: Property = js.native
    var rotation: Property = js.native
    var scale: Property = js.native

    def getValue(time: JulianDate, result: TranslationRotationScale = ???): TranslationRotationScale = js.native

    def equals(other: Property = ???): Boolean = js.native
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
  @js.native
  @JSName("Cesium.PathGraphics")
  class PathGraphics protected() extends js.Object {
    def this(options: PathGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var show: Property = js.native
    var material: MaterialProperty = js.native
    var width: Property = js.native
    var resolution: Property = js.native
    var leadTime: Property = js.native
    var trailTime: Property = js.native

    def clone(result: PathGraphics = ???): PathGraphics = js.native

    def merge(source: PathGraphics): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.PathVisualizer")
  class PathVisualizer protected() extends js.Object {
    def this(scene: Scene, entityCollection: EntityCollection) = this()

    def update(time: JulianDate): Boolean = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
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
  @js.native
  @JSName("Cesium.PointGraphics")
  class PointGraphics protected() extends js.Object {
    def this(options: PointGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var color: Property = js.native
    var pixelSize: Property = js.native
    var outlineColor: Property = js.native
    var outlineWidth: Property = js.native
    var show: Property = js.native
    var scaleByDistance: Property = js.native
    var translucencyByDistance: Property = js.native

    def clone(result: PointGraphics = ???): PointGraphics = js.native

    def merge(source: PointGraphics): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.PointVisualizer")
  class PointVisualizer protected() extends js.Object {
    def this(scene: Scene, entityCollection: EntityCollection) = this()

    def update(time: JulianDate): Boolean = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.PolygonGeometryUpdater")
  class PolygonGeometryUpdater protected() extends js.Object {
    def this(entity: Entity, scene: Scene) = this()

    var entity: Entity = js.native
    var fillEnabled: Boolean = js.native
    var hasConstantFill: Boolean = js.native
    var fillMaterialProperty: MaterialProperty = js.native
    var outlineEnabled: Boolean = js.native
    var hasConstantOutline: Boolean = js.native
    var outlineColorProperty: Property = js.native
    var outlineWidth: Double = js.native
    var isDynamic: Boolean = js.native
    var isClosed: Boolean = js.native
    var geometryChanged: Boolean = js.native

    def isOutlineVisible(time: JulianDate): Boolean = js.native

    def isFilled(time: JulianDate): Boolean = js.native

    def createFillGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def createOutlineGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def createDynamicUpdater(primitives: PrimitiveCollection): DynamicGeometryUpdater = js.native
  }

  @js.native
  @JSName("Cesium.PolygonGeometryUpdater")
  object PolygonGeometryUpdater extends js.Object {
    var perInstanceColorAppearanceType: Appearance = js.native
    var materialAppearanceType: Appearance = js.native
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
  @js.native
  @JSName("Cesium.PolygonGraphics")
  class PolygonGraphics protected() extends js.Object {
    def this(options: PolygonGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var show: Property = js.native
    var material: MaterialProperty = js.native
    var hierarchy: Property = js.native
    var height: Property = js.native
    var extrudedHeight: Property = js.native
    var granularity: Property = js.native
    var stRotation: Property = js.native
    var fill: Property = js.native
    var outline: Property = js.native
    var outlineColor: Property = js.native
    var outlineWidth: Property = js.native
    var perPositionHeight: Property = js.native
    var closeTop: Property = js.native
    var closeBottom: Property = js.native

    def clone(result: PolygonGraphics = ???): PolygonGraphics = js.native

    def merge(source: PolygonGraphics): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.PolylineArrowMaterialProperty")
  class PolylineArrowMaterialProperty protected() extends js.Object {
    def this(color: Property = ???) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var color: Property = js.native

    def getType(time: JulianDate): String = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.PolylineGeometryUpdater")
  class PolylineGeometryUpdater protected() extends js.Object {
    def this(entity: Entity, scene: Scene) = this()

    var entity: Entity = js.native
    var fillEnabled: Boolean = js.native
    var hasConstantFill: Boolean = js.native
    var fillMaterialProperty: MaterialProperty = js.native
    var outlineEnabled: Boolean = js.native
    var hasConstantOutline: Boolean = js.native
    var outlineColorProperty: Property = js.native
    var isDynamic: Boolean = js.native
    var isClosed: Boolean = js.native
    var geometryChanged: Boolean = js.native

    def isOutlineVisible(time: JulianDate): Boolean = js.native

    def isFilled(time: JulianDate): Boolean = js.native

    def createFillGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def createOutlineGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def createDynamicUpdater(primitives: PrimitiveCollection): DynamicGeometryUpdater = js.native
  }

  @js.native
  @JSName("Cesium.PolylineGeometryUpdater")
  object PolylineGeometryUpdater extends js.Object {
    var perInstanceColorAppearanceType: Appearance = js.native
    var materialAppearanceType: Appearance = js.native
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolylineGlowMaterialPropertyOptions extends js.Object

  object PolylineGlowMaterialPropertyOptions extends PolylineGlowMaterialPropertyOptionsBuilder(noOpts)

  class PolylineGlowMaterialPropertyOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineGlowMaterialPropertyOptions, PolylineGlowMaterialPropertyOptionsBuilder](new PolylineGlowMaterialPropertyOptionsBuilder(_)) {

    def color(v: Property) = jsOpt("color", v)
    def glowPower(v: Property) = jsOpt("glowPower", v)

  }
  @js.native
  @JSName("Cesium.PolylineGlowMaterialProperty")
  class PolylineGlowMaterialProperty protected() extends js.Object {
    def this(options: PolylineGlowMaterialPropertyOptions) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var color: Property = js.native
    var glowPower: Property = js.native

    def getType(time: JulianDate): String = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
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
  @js.native
  @JSName("Cesium.PolylineGraphics")
  class PolylineGraphics protected() extends js.Object {
    def this(options: PolylineGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var show: Property = js.native
    var material: MaterialProperty = js.native
    var positions: Property = js.native
    var width: Property = js.native
    var followSurface: Property = js.native
    var granularity: Property = js.native

    def clone(result: PolylineGraphics = ???): PolylineGraphics = js.native

    def merge(source: PolylineGraphics): js.Dynamic = js.native
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
  @js.native
  @JSName("Cesium.PolylineOutlineMaterialProperty")
  class PolylineOutlineMaterialProperty protected() extends js.Object {
    def this(options: PolylineOutlineMaterialPropertyOptions) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var color: Property = js.native
    var outlineColor: Property = js.native
    var outlineWidth: Property = js.native

    def getType(time: JulianDate): String = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.PolylineVolumeGeometryUpdater")
  class PolylineVolumeGeometryUpdater protected() extends js.Object {
    def this(entity: Entity, scene: Scene) = this()

    var entity: Entity = js.native
    var fillEnabled: Boolean = js.native
    var hasConstantFill: Boolean = js.native
    var fillMaterialProperty: MaterialProperty = js.native
    var outlineEnabled: Boolean = js.native
    var hasConstantOutline: Boolean = js.native
    var outlineColorProperty: Property = js.native
    var outlineWidth: Double = js.native
    var isDynamic: Boolean = js.native
    var isClosed: Boolean = js.native
    var geometryChanged: Boolean = js.native

    def isOutlineVisible(time: JulianDate): Boolean = js.native

    def isFilled(time: JulianDate): Boolean = js.native

    def createFillGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def createOutlineGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def createDynamicUpdater(primitives: PrimitiveCollection): DynamicGeometryUpdater = js.native
  }

  @js.native
  @JSName("Cesium.PolylineVolumeGeometryUpdater")
  object PolylineVolumeGeometryUpdater extends js.Object {
    var perInstanceColorAppearanceType: Appearance = js.native
    var materialAppearanceType: Appearance = js.native
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
  @js.native
  @JSName("Cesium.PolylineVolumeGraphics")
  class PolylineVolumeGraphics protected() extends js.Object {
    def this(options: PolylineVolumeGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var show: Property = js.native
    var material: MaterialProperty = js.native
    var positions: Property = js.native
    var shape: Property = js.native
    var granularity: Property = js.native
    var fill: Property = js.native
    var outline: Property = js.native
    var outlineColor: Property = js.native
    var outlineWidth: Property = js.native
    var cornerType: Property = js.native

    def clone(result: PolylineVolumeGraphics = ???): PolylineVolumeGraphics = js.native

    def merge(source: PolylineVolumeGraphics): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.PositionProperty")
  class PositionProperty extends js.Object {
    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var referenceFrame: ReferenceFrame = js.native

    def getValue(time: JulianDate, result: Cartesian3 = ???): Cartesian3 = js.native

    def getValueInReferenceFrame(time: JulianDate, referenceFrame: ReferenceFrame, result: Cartesian3 = ???): Cartesian3 = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.PositionPropertyArray")
  class PositionPropertyArray protected() extends js.Object {
    def this(value: js.Array[Property] = ???, referenceFrame: ReferenceFrame = ???) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var referenceFrame: ReferenceFrame = js.native

    def getValue(time: JulianDate = ???, result: js.Array[Cartesian3] = ???): js.Array[Cartesian3] = js.native

    def getValueInReferenceFrame(time: JulianDate, referenceFrame: ReferenceFrame, result: Cartesian3 = ???): Cartesian3 = js.native

    def setValue(value: js.Array[Property]): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.Property")
  class Property extends js.Object {
    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.PropertyArray")
  class PropertyArray protected() extends js.Object {
    def this(value: js.Array[Property] = ???) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native

    def getValue(time: JulianDate, result: js.Array[js.Any] = ???): js.Array[js.Any] = js.native

    def setValue(value: js.Array[Property]): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.PropertyBag")
  class PropertyBag protected() extends js.Object {
    def this(value: js.Any = ???, createPropertyCallback: js.Function = ???) = this()

    var propertyNames: js.Array[js.Any] = js.native
    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native

    def hasProperty(propertyName: String): Boolean = js.native

    def addProperty(propertyName: String, value: js.Any = ???, createPropertyCallback: js.Function = ???): js.Dynamic = js.native

    def removeProperty(propertyName: String): js.Dynamic = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def merge(source: js.Any, createPropertyCallback: js.Function = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.RectangleGeometryUpdater")
  class RectangleGeometryUpdater protected() extends js.Object {
    def this(entity: Entity, scene: Scene) = this()

    var entity: Entity = js.native
    var fillEnabled: Boolean = js.native
    var hasConstantFill: Boolean = js.native
    var fillMaterialProperty: MaterialProperty = js.native
    var outlineEnabled: Boolean = js.native
    var hasConstantOutline: Boolean = js.native
    var outlineColorProperty: Property = js.native
    var outlineWidth: Double = js.native
    var isDynamic: Boolean = js.native
    var isClosed: Boolean = js.native
    var geometryChanged: Boolean = js.native

    def isOutlineVisible(time: JulianDate): Boolean = js.native

    def isFilled(time: JulianDate): Boolean = js.native

    def createFillGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def createOutlineGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def createDynamicUpdater(primitives: PrimitiveCollection): DynamicGeometryUpdater = js.native
  }

  @js.native
  @JSName("Cesium.RectangleGeometryUpdater")
  object RectangleGeometryUpdater extends js.Object {
    var perInstanceColorAppearanceType: Appearance = js.native
    var materialAppearanceType: Appearance = js.native
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
  @js.native
  @JSName("Cesium.RectangleGraphics")
  class RectangleGraphics protected() extends js.Object {
    def this(options: RectangleGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var show: Property = js.native
    var coordinates: Property = js.native
    var material: MaterialProperty = js.native
    var height: Property = js.native
    var extrudedHeight: Property = js.native
    var granularity: Property = js.native
    var stRotation: Property = js.native
    var rotation: Property = js.native
    var fill: Property = js.native
    var outline: Property = js.native
    var outlineColor: Property = js.native
    var outlineWidth: Property = js.native
    var closeTop: Property = js.native
    var closeBottom: Property = js.native

    def clone(result: RectangleGraphics = ???): RectangleGraphics = js.native

    def merge(source: RectangleGraphics): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.ReferenceProperty")
  class ReferenceProperty protected() extends js.Object {
    def this(targetCollection: EntityCollection, targetId: String, targetPropertyNames: js.Array[String]) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var referenceFrame: ReferenceFrame = js.native
    var targetId: String = js.native
    var targetCollection: EntityCollection = js.native
    var targetPropertyNames: js.Array[String] = js.native
    var resolvedProperty: Property = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def getValueInReferenceFrame(time: JulianDate, referenceFrame: ReferenceFrame, result: Cartesian3 = ???): Cartesian3 = js.native

    def getType(time: JulianDate): String = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.ReferenceProperty")
  object ReferenceProperty extends js.Object {
    def fromString(targetCollection: EntityCollection, referenceString: String): ReferenceProperty = js.native
  }

  @js.native
  @JSName("Cesium.SampledPositionProperty")
  class SampledPositionProperty protected() extends js.Object {
    def this(referenceFrame: ReferenceFrame = ???, numberOfDerivatives: Double = ???) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var referenceFrame: ReferenceFrame = js.native
    var interpolationDegree: Double = js.native
    var interpolationAlgorithm: InterpolationAlgorithm = js.native
    var numberOfDerivatives: Boolean = js.native
    var forwardExtrapolationType: ExtrapolationType = js.native
    var forwardExtrapolationDuration: Double = js.native
    var backwardExtrapolationType: ExtrapolationType = js.native
    var backwardExtrapolationDuration: Double = js.native

    def getValue(time: JulianDate, result: Cartesian3 = ???): Cartesian3 = js.native

    def getValueInReferenceFrame(time: JulianDate, referenceFrame: ReferenceFrame, result: Cartesian3 = ???): Cartesian3 = js.native

    def setInterpolationOptions(options: js.Any = ???): js.Dynamic = js.native

    def addSample(time: JulianDate, position: Cartesian3, derivatives: js.Array[Cartesian3] = ???): js.Dynamic = js.native

    def addSamples(times: js.Array[JulianDate], positions: js.Array[Cartesian3], derivatives: js.Array[js.Array[js.Any]] = ???): js.Dynamic = js.native

    def addSamplesPackedArray(packedSamples: js.Array[Double], epoch: JulianDate = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.SampledProperty")
  class SampledProperty protected() extends js.Object {
    def this(`type`: Double | Packable, derivativeTypes: js.Array[Packable] = ???) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var `type`: js.Any = js.native
    var derivativeTypes: js.Array[Packable] = js.native
    var interpolationDegree: Double = js.native
    var interpolationAlgorithm: InterpolationAlgorithm = js.native
    var forwardExtrapolationType: ExtrapolationType = js.native
    var forwardExtrapolationDuration: Double = js.native
    var backwardExtrapolationType: ExtrapolationType = js.native
    var backwardExtrapolationDuration: Double = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def setInterpolationOptions(options: js.Any = ???): js.Dynamic = js.native

    def addSample(time: JulianDate, value: Packable, derivatives: js.Array[Packable] = ???): js.Dynamic = js.native

    def addSamples(times: js.Array[JulianDate], values: js.Array[Packable], derivativeValues: js.Array[js.Array[js.Any]] = ???): js.Dynamic = js.native

    def addSamplesPackedArray(packedSamples: js.Array[Double], epoch: JulianDate = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
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
  @js.native
  @JSName("Cesium.StripeMaterialProperty")
  class StripeMaterialProperty protected() extends js.Object {
    def this(options: StripeMaterialPropertyOptions) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var orientation: Property = js.native
    var evenColor: Property = js.native
    var oddColor: Property = js.native
    var offset: Property = js.native
    var repeat: Property = js.native

    def getType(time: JulianDate): String = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.TimeIntervalCollectionPositionProperty")
  class TimeIntervalCollectionPositionProperty protected() extends js.Object {
    def this(referenceFrame: ReferenceFrame = ???) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var intervals: TimeIntervalCollection = js.native
    var referenceFrame: ReferenceFrame = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def getValueInReferenceFrame(time: JulianDate, referenceFrame: ReferenceFrame, result: Cartesian3 = ???): Cartesian3 = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.TimeIntervalCollectionProperty")
  class TimeIntervalCollectionProperty extends js.Object {
    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var intervals: TimeIntervalCollection = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.VelocityOrientationProperty")
  class VelocityOrientationProperty protected() extends js.Object {
    def this(position: Property = ???, ellipsoid: Ellipsoid = ???) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var position: Property = js.native
    var ellipsoid: Property = js.native

    def getValue(time: JulianDate = ???, result: Quaternion = ???): Quaternion = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.VelocityVectorProperty")
  class VelocityVectorProperty protected() extends js.Object {
    def this(position: Property = ???) = this()

    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var position: Property = js.native

    def getValue(time: JulianDate = ???, result: Cartesian3 = ???): Cartesian3 = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.Visualizer")
  class Visualizer extends js.Object {
    def update(time: JulianDate): Boolean = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.WallGeometryUpdater")
  class WallGeometryUpdater protected() extends js.Object {
    def this(entity: Entity, scene: Scene) = this()

    var entity: Entity = js.native
    var fillEnabled: Boolean = js.native
    var hasConstantFill: Boolean = js.native
    var fillMaterialProperty: MaterialProperty = js.native
    var outlineEnabled: Boolean = js.native
    var hasConstantOutline: Boolean = js.native
    var outlineColorProperty: Property = js.native
    var outlineWidth: Double = js.native
    var isDynamic: Boolean = js.native
    var isClosed: Boolean = js.native
    var geometryChanged: Boolean = js.native

    def isOutlineVisible(time: JulianDate): Boolean = js.native

    def isFilled(time: JulianDate): Boolean = js.native

    def createFillGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def createOutlineGeometryInstance(time: JulianDate): GeometryInstance = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def createDynamicUpdater(primitives: PrimitiveCollection): DynamicGeometryUpdater = js.native
  }

  @js.native
  @JSName("Cesium.WallGeometryUpdater")
  object WallGeometryUpdater extends js.Object {
    var perInstanceColorAppearanceType: Appearance = js.native
    var materialAppearanceType: Appearance = js.native
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
  @js.native
  @JSName("Cesium.WallGraphics")
  class WallGraphics protected() extends js.Object {
    def this(options: WallGraphicsOptions) = this()

    var definitionChanged: Event = js.native
    var show: Property = js.native
    var material: MaterialProperty = js.native
    var positions: Property = js.native
    var minimumHeights: Property = js.native
    var maximumHeights: Property = js.native
    var granularity: Property = js.native
    var fill: Property = js.native
    var outline: Property = js.native
    var outlineColor: Property = js.native
    var outlineWidth: Property = js.native

    def clone(result: WallGraphics = ???): WallGraphics = js.native

    def merge(source: WallGraphics): js.Dynamic = js.native
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
  @js.native
  @JSName("Cesium.Appearance")
  class Appearance protected() extends js.Object {
    def this(options: AppearanceOptions) = this()

    var material: Material = js.native
    var translucent: Boolean = js.native
    var vertexShaderSource: String = js.native
    var fragmentShaderSource: String = js.native
    var renderState: js.Any = js.native
    var closed: Boolean = js.native

    def getFragmentShaderSource(): String = js.native

    def isTranslucent(): Boolean = js.native

    def getRenderState(): js.Dynamic = js.native
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
  @js.native
  @JSName("Cesium.ArcGisMapServerImageryProvider")
  class ArcGisMapServerImageryProvider protected() extends js.Object {
    def this(options: ArcGisMapServerImageryProviderOptions) = this()

    var enablePickFeatures: Boolean = js.native
    var url: String = js.native
    var token: String = js.native
    var proxy: Proxy = js.native
    var tileWidth: Double = js.native
    var tileHeight: Double = js.native
    var maximumLevel: Double = js.native
    var minimumLevel: Double = js.native
    var tilingScheme: TilingScheme = js.native
    var rectangle: Rectangle = js.native
    var tileDiscardPolicy: TileDiscardPolicy = js.native
    var errorEvent: Event = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var credit: Credit = js.native
    var usingPrecachedTiles: Boolean = js.native
    var hasAlphaChannel: Boolean = js.native

    def getTileCredits(x: Double, y: Double, level: Double): js.Array[Credit] = js.native

    def requestImage(x: Double, y: Double, level: Double): Promise[HTMLImageElement | HTMLCanvasElement] | Unit = js.native

    def pickFeatures(x: Double, y: Double, level: Double, longitude: Double, latitude: Double): Promise[js.Array[ImageryLayerFeatureInfo]] | Unit = js.native
  }

  @JSName("Cesium.Billboard")
  @js.native
  object Billboard extends js.Object {
    type CreateImageCallback = js.Function1[String, HTMLImageElement | HTMLCanvasElement | Promise[HTMLImageElement | HTMLCanvasElement]]
  }

  @js.native
  @JSName("Cesium.Billboard")
  class Billboard extends js.Object {
    var show: Boolean = js.native
    var position: Cartesian3 = js.native
    var heightReference: HeightReference = js.native
    var pixelOffset: Cartesian2 = js.native
    var scaleByDistance: NearFarScalar = js.native
    var translucencyByDistance: NearFarScalar = js.native
    var pixelOffsetScaleByDistance: NearFarScalar = js.native
    var eyeOffset: Cartesian3 = js.native
    var horizontalOrigin: HorizontalOrigin = js.native
    var verticalOrigin: VerticalOrigin = js.native
    var scale: Double = js.native
    var color: Color = js.native
    var rotation: Double = js.native
    var alignedAxis: Cartesian3 = js.native
    var width: Double = js.native
    var height: Double = js.native
    var sizeInMeters: Boolean = js.native
    var id: js.Any = js.native
    var image: String = js.native
    var ready: Boolean = js.native

    def setImage(id: String, image: HTMLImageElement | HTMLCanvasElement | String | Billboard.CreateImageCallback): js.Dynamic = js.native

    def setImageSubRegion(id: String, subRegion: BoundingRectangle): js.Dynamic = js.native

    def computeScreenSpacePosition(scene: Scene, result: Cartesian2 = ???): Cartesian2 = js.native

    def equals(other: Billboard): Boolean = js.native
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
  @js.native
  @JSName("Cesium.BillboardCollection")
  class BillboardCollection protected() extends js.Object {
    def this(options: BillboardCollectionOptions) = this()

    var modelMatrix: Matrix4 = js.native
    var debugShowBoundingVolume: Boolean = js.native
    var length: Double = js.native

    def add(billboard: js.Any = ???): Billboard = js.native

    def remove(billboard: Billboard): Boolean = js.native

    def removeAll(): js.Dynamic = js.native

    def contains(billboard: Billboard = ???): Boolean = js.native

    def get(index: Double): Billboard = js.native

    def update(): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
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
  @js.native
  @JSName("Cesium.BingMapsImageryProvider")
  class BingMapsImageryProvider protected() extends js.Object {
    def this(options: BingMapsImageryProviderOptions) = this()

    var defaultGamma: Double = js.native
    var url: String = js.native
    var proxy: Proxy = js.native
    var key: String = js.native
    var mapStyle: BingMapsStyle = js.native
    var culture: String = js.native
    var tileWidth: Double = js.native
    var tileHeight: Double = js.native
    var maximumLevel: Double = js.native
    var minimumLevel: Double = js.native
    var tilingScheme: TilingScheme = js.native
    var rectangle: Rectangle = js.native
    var tileDiscardPolicy: TileDiscardPolicy = js.native
    var errorEvent: Event = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var credit: Credit = js.native
    var hasAlphaChannel: Boolean = js.native

    def getTileCredits(x: Double, y: Double, level: Double): js.Array[Credit] = js.native

    def requestImage(x: Double, y: Double, level: Double): Promise[HTMLImageElement | HTMLCanvasElement] | Unit = js.native

    def pickFeatures(x: Double, y: Double, level: Double, longitude: Double, latitude: Double): Promise[js.Array[ImageryLayerFeatureInfo]] | Unit = js.native
  }

  @js.native
  @JSName("Cesium.BingMapsImageryProvider")
  object BingMapsImageryProvider extends js.Object {
    def tileXYToQuadKey(x: Double, y: Double, level: Double): js.Dynamic = js.native

    def quadKeyToTileXY(quadkey: String): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.Camera")
  class Camera protected() extends js.Object {
    def this(scene: Scene) = this()

    var position: Cartesian3 = js.native
    var direction: Cartesian3 = js.native
    var up: Cartesian3 = js.native
    var right: Cartesian3 = js.native
    var frustum: Frustum = js.native
    var defaultMoveAmount: Double = js.native
    var defaultLookAmount: Double = js.native
    var defaultRotateAmount: Double = js.native
    var defaultZoomAmount: Double = js.native
    var constrainedAxis: Cartesian3 = js.native
    var maximumTranslateFactor: Double = js.native
    var maximumZoomFactor: Double = js.native
    var transform: Matrix4 = js.native
    var inverseTransform: Matrix4 = js.native
    var viewMatrix: Matrix4 = js.native
    var inverseViewMatrix: Matrix4 = js.native
    var positionCartographic: Cartographic = js.native
    var positionWC: Cartesian3 = js.native
    var directionWC: Cartesian3 = js.native
    var upWC: Cartesian3 = js.native
    var rightWC: Cartesian3 = js.native
    var heading: Double = js.native
    var pitch: Double = js.native
    var roll: Double = js.native
    var moveStart: Event = js.native
    var moveEnd: Event = js.native

    def setView(options: js.Any): js.Dynamic = js.native

    def flyHome(duration: Double = ???): js.Dynamic = js.native

    def worldToCameraCoordinates(cartesian: Cartesian4, result: Cartesian4 = ???): Cartesian4 = js.native

    def worldToCameraCoordinatesPoint(cartesian: Cartesian3, result: Cartesian3 = ???): Cartesian3 = js.native

    def worldToCameraCoordinatesVector(cartesian: Cartesian3, result: Cartesian3 = ???): Cartesian3 = js.native

    def cameraToWorldCoordinates(cartesian: Cartesian4, result: Cartesian4 = ???): Cartesian4 = js.native

    def cameraToWorldCoordinatesPoint(cartesian: Cartesian3, result: Cartesian3 = ???): Cartesian3 = js.native

    def cameraToWorldCoordinatesVector(cartesian: Cartesian3, result: Cartesian3 = ???): Cartesian3 = js.native

    def move(direction: Cartesian3, amount: Double = ???): js.Dynamic = js.native

    def moveForward(amount: Double = ???): js.Dynamic = js.native

    def moveBackward(amount: Double = ???): js.Dynamic = js.native

    def moveUp(amount: Double = ???): js.Dynamic = js.native

    def moveDown(amount: Double = ???): js.Dynamic = js.native

    def moveRight(amount: Double = ???): js.Dynamic = js.native

    def moveLeft(amount: Double = ???): js.Dynamic = js.native

    def lookLeft(amount: Double = ???): js.Dynamic = js.native

    def lookRight(amount: Double = ???): js.Dynamic = js.native

    def lookUp(amount: Double = ???): js.Dynamic = js.native

    def lookDown(amount: Double = ???): js.Dynamic = js.native

    def look(axis: Cartesian3, angle: Double = ???): js.Dynamic = js.native

    def twistLeft(amount: Double = ???): js.Dynamic = js.native

    def twistRight(amount: Double = ???): js.Dynamic = js.native

    def rotate(axis: Cartesian3, angle: Double = ???): js.Dynamic = js.native

    def rotateDown(angle: Double = ???): js.Dynamic = js.native

    def rotateUp(angle: Double = ???): js.Dynamic = js.native

    def rotateRight(angle: Double = ???): js.Dynamic = js.native

    def rotateLeft(angle: Double = ???): js.Dynamic = js.native

    def zoomIn(amount: Double = ???): js.Dynamic = js.native

    def zoomOut(amount: Double = ???): js.Dynamic = js.native

    def getMagnitude(): Double = js.native

    def lookAt(target: Cartesian3, offset: Cartesian3 | HeadingPitchRange): js.Dynamic = js.native

    def lookAtTransform(transform: Matrix4, offset: Cartesian3 | HeadingPitchRange = ???): js.Dynamic = js.native

    def getRectangleCameraCoordinates(rectangle: Rectangle, result: Cartesian3 = ???): Cartesian3 = js.native

    def pickEllipsoid(windowPosition: Cartesian2, ellipsoid: Ellipsoid = ???, result: Cartesian3 = ???): Cartesian3 = js.native

    def getPickRay(windowPosition: Cartesian2, result: Ray = ???): Ray = js.native

    def distanceToBoundingSphere(boundingSphere: BoundingSphere): Double = js.native

    def getPixelSize(boundingSphere: BoundingSphere, drawingBufferWidth: Double, drawingBufferHeight: Double): Double = js.native

    def flyTo(options: js.Any): js.Dynamic = js.native

    def viewBoundingSphere(boundingSphere: BoundingSphere, offset: HeadingPitchRange = ???): js.Dynamic = js.native

    def flyToBoundingSphere(boundingSphere: BoundingSphere, options: js.Any = ???): js.Dynamic = js.native

    def computeViewRectangle(ellipsoid: Ellipsoid = ???, result: Rectangle = ???): Rectangle | Unit = js.native
  }

  @js.native
  @JSName("Cesium.Camera")
  object Camera extends js.Object {
    type FlightCompleteCallback = js.Function0[Unit]
    type FlightCancelledCallback = js.Function0[Unit]
    var DEFAULT_VIEW_RECTANGLE: Rectangle = js.native
    var DEFAULT_VIEW_FACTOR: Double = js.native
  }

  @js.native
  @JSName("Cesium.CameraEventAggregator")
  class CameraEventAggregator protected() extends js.Object {
    def this(element: HTMLCanvasElement = ???) = this()

    var currentMousePosition: Cartesian2 = js.native
    var anyButtonDown: Boolean = js.native

    def isMoving(`type`: CameraEventType, modifier: KeyboardEventModifier = ???): Boolean = js.native

    def getMovement(`type`: CameraEventType, modifier: KeyboardEventModifier = ???): js.Dynamic = js.native

    def getLastMovement(`type`: CameraEventType, modifier: KeyboardEventModifier = ???): js.Any | Unit = js.native

    def isButtonDown(`type`: CameraEventType, modifier: KeyboardEventModifier = ???): Boolean = js.native

    def getStartMousePosition(`type`: CameraEventType, modifier: KeyboardEventModifier = ???): Cartesian2 = js.native

    def getButtonPressTime(`type`: CameraEventType, modifier: KeyboardEventModifier = ???): Date = js.native

    def getButtonReleaseTime(`type`: CameraEventType, modifier: KeyboardEventModifier = ???): Date = js.native

    def reset(): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  @js.native
  @JSName("Cesium.CreditDisplay")
  class CreditDisplay protected() extends js.Object {
    def this(container: HTMLElement, delimiter: String = ???) = this()

    var container: HTMLElement = js.native

    def addCredit(credit: Credit): js.Dynamic = js.native

    def addDefaultCredit(credit: Credit): js.Dynamic = js.native

    def removeDefaultCredit(credit: Credit): js.Dynamic = js.native

    def beginFrame(credit: Credit): js.Dynamic = js.native

    def endFrame(credit: Credit): js.Dynamic = js.native

    def destroy(): Unit = js.native

    def isDestroyed(): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.CullingVolume")
  class CullingVolume protected() extends js.Object {
    def this(planes: js.Array[Cartesian4] = ???) = this()

    var planes: js.Array[Cartesian4] = js.native

    def computeVisibility(boundingVolume: js.Any): Intersect = js.native
  }

  @js.native
  @JSName("Cesium.CullingVolume")
  object CullingVolume extends js.Object {
    def fromBoundingSphere(boundingSphere: BoundingSphere, result: CullingVolume = ???): CullingVolume = js.native
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
  @js.native
  @JSName("Cesium.DebugAppearance")
  class DebugAppearance protected() extends js.Object {
    def this(options: DebugAppearanceOptions) = this()

    var material: Material = js.native
    var translucent: Boolean = js.native
    var vertexShaderSource: String = js.native
    var fragmentShaderSource: String = js.native
    var renderState: js.Any = js.native
    var closed: Boolean = js.native
    var attributeName: String = js.native
    var glslDatatype: String = js.native

    def getFragmentShaderSource(): String = js.native

    def isTranslucent(): Boolean = js.native

    def getRenderState(): js.Dynamic = js.native
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
  @js.native
  @JSName("Cesium.DebugModelMatrixPrimitive")
  class DebugModelMatrixPrimitive protected() extends js.Object {
    def this(options: DebugModelMatrixPrimitiveOptions) = this()

    var length: Double = js.native
    var width: Double = js.native
    var show: Boolean = js.native
    var modelMatrix: Matrix4 = js.native
    var id: js.Any = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
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
  @js.native
  @JSName("Cesium.DiscardMissingTileImagePolicy")
  class DiscardMissingTileImagePolicy protected() extends js.Object {
    def this(options: DiscardMissingTileImagePolicyOptions) = this()

    def isReady(): Boolean = js.native

    def shouldDiscardImage(image: HTMLImageElement): Boolean = js.native
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
  @js.native
  @JSName("Cesium.EllipsoidSurfaceAppearance")
  class EllipsoidSurfaceAppearance protected() extends js.Object {
    def this(options: EllipsoidSurfaceAppearanceOptions) = this()

    var material: Material = js.native
    var translucent: Boolean = js.native
    var vertexShaderSource: String = js.native
    var fragmentShaderSource: String = js.native
    var renderState: js.Any = js.native
    var closed: Boolean = js.native
    var vertexFormat: VertexFormat = js.native
    var flat: Boolean = js.native
    var faceForward: Boolean = js.native
    var aboveGround: Boolean = js.native

    def getFragmentShaderSource(): String = js.native

    def isTranslucent(): Boolean = js.native

    def getRenderState(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.EllipsoidSurfaceAppearance")
  object EllipsoidSurfaceAppearance extends js.Object {
    var VERTEX_FORMAT: VertexFormat = js.native
  }

  @js.native
  @JSName("Cesium.Fog")
  class Fog extends js.Object {
    var enabled: Boolean = js.native
    var density: Double = js.native
    var screenSpaceErrorFactor: Double = js.native
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
  @js.native
  @JSName("Cesium.FrameRateMonitor")
  class FrameRateMonitor protected() extends js.Object {
    def this(options: FrameRateMonitorOptions) = this()

    var samplingWindow: Double = js.native
    var quietPeriod: Double = js.native
    var warmupPeriod: Double = js.native
    var minimumFrameRateDuringWarmup: Double = js.native
    var minimumFrameRateAfterWarmup: Double = js.native
    var scene: Scene = js.native
    var lowFrameRate: Event = js.native
    var nominalFrameRate: Event = js.native
    var lastFramesPerSecond: Double = js.native

    def pause(): js.Dynamic = js.native

    def unpause(): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  @js.native
  @JSName("Cesium.FrameRateMonitor")
  object FrameRateMonitor extends js.Object {
    var defaultSettings: js.Any = js.native

    def fromScene(scene: Scene): FrameRateMonitor = js.native
  }

  @js.native
  @JSName("Cesium.GetFeatureInfoFormat")
  class GetFeatureInfoFormat protected() extends js.Object {
    def this(`type`: String, format: String = ???, callback: js.Function = ???) = this()
  }

  @js.native
  @JSName("Cesium.Globe")
  class Globe protected() extends js.Object {
    def this(ellipsoid: Ellipsoid = ???) = this()

    var terrainProvider: TerrainProvider = js.native
    var show: Boolean = js.native
    var oceanNormalMapUrl: String = js.native
    var maximumScreenSpaceError: Double = js.native
    var tileCacheSize: Double = js.native
    var enableLighting: Boolean = js.native
    var lightingFadeOutDistance: Double = js.native
    var lightingFadeInDistance: Double = js.native
    var showWaterEffect: Boolean = js.native
    var depthTestAgainstTerrain: Boolean = js.native
    var ellipsoid: Ellipsoid = js.native
    var imageryLayers: ImageryLayerCollection = js.native
    var baseColor: Color = js.native
    var tileLoadProgressEvent: Event = js.native

    def pick(ray: Ray, scene: Scene, result: Cartesian3 = ???): Cartesian3 | Unit = js.native

    def getHeight(cartographic: Cartographic): Double | Unit = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
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
  @js.native
  @JSName("Cesium.GoogleEarthImageryProvider")
  class GoogleEarthImageryProvider protected() extends js.Object {
    def this(options: GoogleEarthImageryProviderOptions) = this()

    var defaultGamma: Double = js.native
    var url: String = js.native
    var path: String = js.native
    var proxy: Proxy = js.native
    var channel: Double = js.native
    var tileWidth: Double = js.native
    var tileHeight: Double = js.native
    var maximumLevel: Double = js.native
    var minimumLevel: Double = js.native
    var tilingScheme: TilingScheme = js.native
    var version: Double = js.native
    var requestType: String = js.native
    var rectangle: Rectangle = js.native
    var tileDiscardPolicy: TileDiscardPolicy = js.native
    var errorEvent: Event = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var credit: Credit = js.native
    var hasAlphaChannel: Boolean = js.native

    def getTileCredits(x: Double, y: Double, level: Double): js.Array[Credit] = js.native

    def requestImage(x: Double, y: Double, level: Double): Promise[HTMLImageElement | HTMLCanvasElement] | Unit = js.native

    def pickFeatures(x: Double, y: Double, level: Double, longitude: Double, latitude: Double): Promise[js.Array[ImageryLayerFeatureInfo]] | Unit = js.native
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
  @js.native
  @JSName("Cesium.GridImageryProvider")
  class GridImageryProvider protected() extends js.Object {
    def this(options: GridImageryProviderOptions) = this()

    var proxy: Proxy = js.native
    var tileWidth: Double = js.native
    var tileHeight: Double = js.native
    var maximumLevel: Double = js.native
    var minimumLevel: Double = js.native
    var tilingScheme: TilingScheme = js.native
    var rectangle: Rectangle = js.native
    var tileDiscardPolicy: TileDiscardPolicy = js.native
    var errorEvent: Event = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var credit: Credit = js.native
    var hasAlphaChannel: Boolean = js.native

    def getTileCredits(x: Double, y: Double, level: Double): js.Array[Credit] = js.native

    def requestImage(x: Double, y: Double, level: Double): Promise[HTMLImageElement | HTMLCanvasElement] | Unit = js.native

    def pickFeatures(x: Double, y: Double, level: Double, longitude: Double, latitude: Double): Promise[js.Array[ImageryLayerFeatureInfo]] | Unit = js.native
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
  }
  @js.native
  @JSName("Cesium.GroundPrimitive")
  class GroundPrimitive protected() extends js.Object {
    def this(options: GroundPrimitiveOptions) = this()

    var geometryInstances: js.Array[js.Any] | GeometryInstance = js.native
    var show: Boolean = js.native
    var debugShowBoundingVolume: Boolean = js.native
    var debugShowShadowVolume: Boolean = js.native
    var vertexCacheOptimize: Boolean = js.native
    var interleave: Boolean = js.native
    var releaseGeometryInstances: Boolean = js.native
    var allowPicking: Boolean = js.native
    var asynchronous: Boolean = js.native
    var compressVertices: Boolean = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[GroundPrimitive] = js.native

    def update(): js.Dynamic = js.native

    def getGeometryInstanceAttributes(id: js.Any): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  @js.native
  @JSName("Cesium.GroundPrimitive")
  object GroundPrimitive extends js.Object {
    def isSupported(scene: Scene): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.ImageryLayer")
  class ImageryLayer protected() extends js.Object {
    def this(imageryProvider: ImageryProvider, options: js.Any = ???) = this()

    var alpha: Double = js.native
    var brightness: Double = js.native
    var contrast: Double = js.native
    var hue: Double = js.native
    var saturation: Double = js.native
    var gamma: Double = js.native
    var show: Boolean = js.native
    var imageryProvider: ImageryProvider = js.native
    var rectangle: Rectangle = js.native

    def isBaseLayer(): Boolean = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native

    def getViewableRectangle(): Promise[Rectangle] = js.native
  }

  @js.native
  @JSName("Cesium.ImageryLayer")
  object ImageryLayer extends js.Object {
    var DEFAULT_BRIGHTNESS: Double = js.native
    var DEFAULT_CONTRAST: Double = js.native
    var DEFAULT_HUE: Double = js.native
    var DEFAULT_SATURATION: Double = js.native
    var DEFAULT_GAMMA: Double = js.native
  }

  @js.native
  @JSName("Cesium.ImageryLayerCollection")
  class ImageryLayerCollection extends js.Object {
    var layerAdded: Event = js.native
    var layerRemoved: Event = js.native
    var layerMoved: Event = js.native
    var layerShownOrHidden: Event = js.native
    var length: Double = js.native

    def add(layer: ImageryLayer, index: Double = ???): js.Dynamic = js.native

    def addImageryProvider(imageryProvider: ImageryProvider, index: Double = ???): ImageryLayer = js.native

    def remove(layer: ImageryLayer, destroy: Boolean = ???): Boolean = js.native

    def removeAll(destroy: Boolean = ???): js.Dynamic = js.native

    def contains(layer: ImageryLayer): Boolean = js.native

    def indexOf(layer: ImageryLayer): Double = js.native

    def get(index: Double): ImageryLayer = js.native

    def raise(layer: ImageryLayer): js.Dynamic = js.native

    def lower(layer: ImageryLayer): js.Dynamic = js.native

    def raiseToTop(layer: ImageryLayer): js.Dynamic = js.native

    def lowerToBottom(layer: ImageryLayer): js.Dynamic = js.native

    def pickImageryLayerFeatures(ray: Ray, scene: Scene): Promise[js.Array[ImageryLayerFeatureInfo]] | Unit = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  @js.native
  @JSName("Cesium.ImageryLayerFeatureInfo")
  class ImageryLayerFeatureInfo extends js.Object {
    var name: String = js.native
    var description: String = js.native
    var position: Cartographic = js.native
    var data: js.Any = js.native
    var imageryLayer: js.Any = js.native

    def configureNameFromProperties(properties: js.Any): js.Dynamic = js.native

    def configureDescriptionFromProperties(properties: js.Any): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.ImageryProvider")
  class ImageryProvider extends js.Object {
    var defaultAlpha: Double = js.native
    var defaultBrightness: Double = js.native
    var defaultContrast: Double = js.native
    var defaultHue: Double = js.native
    var defaultSaturation: Double = js.native
    var defaultGamma: Double = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var rectangle: Rectangle = js.native
    var tileWidth: Double = js.native
    var tileHeight: Double = js.native
    var maximumLevel: Double = js.native
    var minimumLevel: Double = js.native
    var tilingScheme: TilingScheme = js.native
    var tileDiscardPolicy: TileDiscardPolicy = js.native
    var errorEvent: Event = js.native
    var credit: Credit = js.native
    var proxy: Proxy = js.native
    var hasAlphaChannel: Boolean = js.native

    def getTileCredits(x: Double, y: Double, level: Double): js.Array[Credit] = js.native

    def requestImage(x: Double, y: Double, level: Double): Promise[HTMLImageElement | HTMLCanvasElement] | Unit = js.native

    def pickFeatures(x: Double, y: Double, level: Double, longitude: Double, latitude: Double): Promise[js.Array[ImageryLayerFeatureInfo]] | Unit = js.native
  }

  @js.native
  @JSName("Cesium.ImageryProvider")
  object ImageryProvider extends js.Object {
    def loadImage(url: String): Promise[HTMLImageElement | HTMLCanvasElement] | Unit = js.native
  }

  @js.native
  @JSName("Cesium.Label")
  class Label extends js.Object {
    var show: Boolean = js.native
    var position: Cartesian3 = js.native
    var heightReference: HeightReference = js.native
    var text: String = js.native
    var font: String = js.native
    var fillColor: Color = js.native
    var outlineColor: Color = js.native
    var outlineWidth: Double = js.native
    var style: LabelStyle = js.native
    var pixelOffset: Cartesian2 = js.native
    var translucencyByDistance: NearFarScalar = js.native
    var pixelOffsetScaleByDistance: NearFarScalar = js.native
    var eyeOffset: Cartesian3 = js.native
    var horizontalOrigin: HorizontalOrigin = js.native
    var verticalOrigin: VerticalOrigin = js.native
    var scale: Double = js.native
    var id: js.Any = js.native

    def computeScreenSpacePosition(scene: Scene, result: Cartesian2 = ???): Cartesian2 = js.native

    def equals(other: Label): Boolean = js.native

    def isDestroyed(): Boolean = js.native
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
  @js.native
  @JSName("Cesium.LabelCollection")
  class LabelCollection protected() extends js.Object {
    def this(options: LabelCollectionOptions) = this()

    var modelMatrix: Matrix4 = js.native
    var debugShowBoundingVolume: Boolean = js.native
    var length: Double = js.native

    def add(options: js.Any = ???): Label = js.native

    def remove(label: Label): Boolean = js.native

    def removeAll(): js.Dynamic = js.native

    def contains(label: Label): Boolean = js.native

    def get(index: Double): Label = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
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
    def proxy(v: Credit | String) = jsOpt("credit", v)

  }
  @js.native
  @JSName("Cesium.MapboxImageryProvider")
  class MapboxImageryProvider protected() extends js.Object {
    def this(options: MapboxImageryProviderOptions) = this()

    var url: String = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var rectangle: Rectangle = js.native
    var tileWidth: Double = js.native
    var tileHeight: Double = js.native
    var maximumLevel: Double = js.native
    var minimumLevel: Double = js.native
    var tilingScheme: TilingScheme = js.native
    var tileDiscardPolicy: TileDiscardPolicy = js.native
    var errorEvent: Event = js.native
    var credit: Credit = js.native
    var proxy: Proxy = js.native
    var hasAlphaChannel: Boolean = js.native

    def getTileCredits(x: Double, y: Double, level: Double): js.Array[Credit] = js.native

    def requestImage(x: Double, y: Double, level: Double): Promise[HTMLImageElement | HTMLCanvasElement] | Unit = js.native

    def pickFeatures(x: Double, y: Double, level: Double, longitude: Double, latitude: Double): Promise[js.Array[ImageryLayerFeatureInfo]] | Unit = js.native
  }


  @JSName("Cesium.Options")
  @js.native
  trait MaterialOptions extends js.Object

  object MaterialOptions extends MaterialOptionsBuilder(noOpts)

  class MaterialOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[MaterialOptions, MaterialOptionsBuilder](new MaterialOptionsBuilder(_)) {

    // todo

  }
  @js.native
  @JSName("Cesium.Material")
  class Material protected() extends js.Object {
    def this(options: MaterialOptions) = this()

    var `type`: String = js.native
    var shaderSource: String = js.native
    var materials: js.Any = js.native
    var uniforms: js.Any = js.native
    var translucent: Boolean | js.Function = js.native

    def isTranslucent(): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  @js.native
  @JSName("Cesium.Material")
  object Material extends js.Object {
    var DefaultImageId: String = js.native
    var DefaultCubeMapId: String = js.native
    var ColorType: String = js.native
    var ImageType: String = js.native
    var DiffuseMapType: String = js.native
    var AlphaMapType: String = js.native
    var SpecularMapType: String = js.native
    var EmissionMapType: String = js.native
    var BumpMapType: String = js.native
    var NormalMapType: String = js.native
    var GridType: String = js.native
    var StripeType: String = js.native
    var CheckerboardType: String = js.native
    var DotType: String = js.native
    var WaterType: String = js.native
    var RimLightingType: String = js.native
    var FadeType: String = js.native
    var PolylineArrowType: String = js.native
    var PolylineGlowType: String = js.native
    var PolylineOutlineType: String = js.native

    def fromType(`type`: String, uniforms: js.Any = ???): Material = js.native
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
    // todo
  //  def materialSupport(v: 	MaterialAppearance.MaterialSupport) = jsOpt("materialSupport", v)
    def material(v: Material) = jsOpt("material", v)
    def vertexShaderSource(v: String) = jsOpt("vertexShaderSource", v)
    def fragmentShaderSource(v: String) = jsOpt("fragmentShaderSource", v)
    def renderState(v: RenderState) = jsOpt("renderState", v)
  }
  @js.native
  @JSName("Cesium.MaterialAppearance")
  class MaterialAppearance protected() extends js.Object {
    def this(options: MaterialAppearanceOptions) = this()

    var material: Material = js.native
    var translucent: Boolean = js.native
    var vertexShaderSource: String = js.native
    var fragmentShaderSource: String = js.native
    var renderState: js.Any = js.native
    var closed: Boolean = js.native
    var materialSupport: MaterialAppearanceMaterialSupport = js.native
    var vertexFormat: VertexFormat = js.native
    var flat: Boolean = js.native
    var faceForward: Boolean = js.native

    def getFragmentShaderSource(): String = js.native

    def isTranslucent(): Boolean = js.native

    def getRenderState(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.MaterialAppearance")
  object MaterialAppearance extends js.Object {
    var MaterialSupport: MaterialAppearanceMaterialSupport = js.native
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
  }
  @js.native
  @JSName("Cesium.Model")
  class Model protected() extends js.Object {
    def this(options: ModelOptions) = this()

    var show: Boolean = js.native
    var modelMatrix: Matrix4 = js.native
    var scale: Double = js.native
    var minimumPixelSize: Double = js.native
    var maximumScale: Double = js.native
    var id: js.Any = js.native
    var activeAnimations: ModelAnimationCollection = js.native
    var debugShowBoundingVolume: Boolean = js.native
    var debugWireframe: Boolean = js.native
    var gltf: js.Any = js.native
    var basePath: String = js.native
    var boundingSphere: BoundingSphere = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Model] = js.native
    var asynchronous: Boolean = js.native
    var allowPicking: Boolean = js.native
    var incrementallyLoadTextures: Boolean = js.native
    var pendingTextureLoads: Double = js.native

    def getNode(name: String): ModelNode = js.native

    def getMesh(name: String): ModelMesh = js.native

    def getMaterial(name: String): ModelMaterial = js.native

    def update(): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  @js.native
  @JSName("Cesium.Model")
  object Model extends js.Object {
    def fromGltf(options: js.Any): Model = js.native
  }

  @js.native
  @JSName("Cesium.ModelAnimation")
  class ModelAnimation extends js.Object {
    var removeOnStop: Boolean = js.native
    var start: Event = js.native
    var update: Event = js.native
    var stop: Event = js.native
    var name: String = js.native
    var startTime: JulianDate = js.native
    var delay: Double = js.native
    var stopTime: JulianDate = js.native
    var speedup: Double = js.native
    var reverse: Boolean = js.native
    var loop: ModelAnimationLoop = js.native
  }

  @js.native
  @JSName("Cesium.ModelAnimationCollection")
  class ModelAnimationCollection extends js.Object {
    var animationAdded: Event = js.native
    var animationRemoved: Event = js.native
    var length: Double = js.native

    def add(options: js.Any): ModelAnimation = js.native

    def addAll(options: js.Any = ???): js.Array[ModelAnimation] = js.native

    def remove(animation: ModelAnimation): Boolean = js.native

    def removeAll(): js.Dynamic = js.native

    def contains(animation: ModelAnimation): Boolean = js.native

    def get(index: Double): ModelAnimation = js.native
  }

  @js.native
  @JSName("Cesium.ModelMaterial")
  class ModelMaterial extends js.Object {
    var name: String = js.native
    var id: String = js.native

    def setValue(name: String, value: js.Any = ???): js.Dynamic = js.native

    def getValue(name: String): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.ModelMesh")
  class ModelMesh extends js.Object {
    var name: String = js.native
    var id: String = js.native
    var materials: js.Array[ModelMaterial] = js.native
  }

  @js.native
  @JSName("Cesium.ModelNode")
  class ModelNode extends js.Object {
    var name: String = js.native
    var id: String = js.native
    var show: Boolean = js.native
    var matrix: Matrix4 = js.native
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
  @js.native
  @JSName("Cesium.Moon")
  class Moon protected() extends js.Object {
    def this(options: MoonOptions) = this()

    var show: Boolean = js.native
    var textureUrl: String = js.native
    var onlySunLighting: Boolean = js.native
    var ellipsoid: Ellipsoid = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  @js.native
  @JSName("Cesium.NeverTileDiscardPolicy")
  class NeverTileDiscardPolicy extends js.Object {
    def isReady(): Boolean = js.native

    def shouldDiscardImage(image: HTMLImageElement): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.OrthographicFrustum")
  class OrthographicFrustum extends Frustum {
    var left: Double = js.native
    var right: Double = js.native
    var top: Double = js.native
    var bottom: Double = js.native
    var near: Double = js.native
    var far: Double = js.native
    var projectionMatrix: Matrix4 = js.native

    def computeCullingVolume(position: Cartesian3, direction: Cartesian3, up: Cartesian3): CullingVolume = js.native

    def getPixelDimensions(drawingBufferWidth: Double, drawingBufferHeight: Double, distance: Double, result: Cartesian2): Cartesian2 = js.native

    def clone(result: OrthographicFrustum = ???): OrthographicFrustum = js.native

    def equals(other: OrthographicFrustum = ???): Boolean = js.native
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
  @js.native
  @JSName("Cesium.PerInstanceColorAppearance")
  class PerInstanceColorAppearance protected() extends js.Object {
    def this(options: PerInstanceColorAppearanceOptions) = this()

    var material: Material = js.native
    var translucent: Boolean = js.native
    var vertexShaderSource: String = js.native
    var fragmentShaderSource: String = js.native
    var renderState: js.Any = js.native
    var closed: Boolean = js.native
    var vertexFormat: VertexFormat = js.native
    var flat: Boolean = js.native
    var faceForward: Boolean = js.native

    def getFragmentShaderSource(): String = js.native

    def isTranslucent(): Boolean = js.native

    def getRenderState(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.PerInstanceColorAppearance")
  object PerInstanceColorAppearance extends js.Object {
    var VERTEX_FORMAT: VertexFormat = js.native
    var FLAT_VERTEX_FORMAT: VertexFormat = js.native
  }

  @js.native
  @JSName("Cesium.PerspectiveFrustum")
  class PerspectiveFrustum extends Frustum {
    var fov: Double = js.native
    var aspectRatio: Double = js.native
    var near: Double = js.native
    var far: Double = js.native
    var xOffset: Double = js.native
    var yOffset: Double = js.native
    var projectionMatrix: Matrix4 = js.native
    var infiniteProjectionMatrix: Matrix4 = js.native
    var fovy: Double = js.native

    def computeCullingVolume(position: Cartesian3, direction: Cartesian3, up: Cartesian3): CullingVolume = js.native

    def getPixelDimensions(drawingBufferWidth: Double, drawingBufferHeight: Double, distance: Double, result: Cartesian2): Cartesian2 = js.native

    def clone(result: PerspectiveFrustum = ???): PerspectiveFrustum = js.native

    def equals(other: PerspectiveFrustum = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.PerspectiveOffCenterFrustum")
  class PerspectiveOffCenterFrustum extends Frustum {
    var left: Double = js.native
    var right: Double = js.native
    var top: Double = js.native
    var bottom: Double = js.native
    var near: Double = js.native
    var far: Double = js.native
    var projectionMatrix: Matrix4 = js.native
    var infiniteProjectionMatrix: Matrix4 = js.native

    def computeCullingVolume(position: Cartesian3, direction: Cartesian3, up: Cartesian3): CullingVolume = js.native

    def getPixelDimensions(drawingBufferWidth: Double, drawingBufferHeight: Double, distance: Double, result: Cartesian2): Cartesian2 = js.native

    def clone(result: PerspectiveOffCenterFrustum = ???): PerspectiveOffCenterFrustum = js.native

    def equals(other: PerspectiveOffCenterFrustum = ???): Boolean = js.native
  }

  @js.native
  @JSName("Cesium.PointPrimitive")
  class PointPrimitive extends js.Object {
    var show: Boolean = js.native
    var position: Cartesian3 = js.native
    var scaleByDistance: NearFarScalar = js.native
    var translucencyByDistance: NearFarScalar = js.native
    var pixelSize: Double = js.native
    var color: Color = js.native
    var outlineColor: Color = js.native
    var outlineWidth: Double = js.native
    var id: js.Any = js.native

    def computeScreenSpacePosition(scene: Scene, result: Cartesian2 = ???): Cartesian2 = js.native

    def equals(other: PointPrimitive): Boolean = js.native
  }


  @JSName("Cesium.Options")
  @js.native
  trait PointPrimitiveCollectionOptions extends js.Object

  object PointPrimitiveCollectionOptions extends PointPrimitiveCollectionOptionsBuilder(noOpts)

  class PointPrimitiveCollectionOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PointPrimitiveCollectionOptions, PointPrimitiveCollectionOptionsBuilder](new PointPrimitiveCollectionOptionsBuilder(_)) {

    def modelMatrix(v: Matrix4) = jsOpt("modelMatrix", v)
    def debugShowBoundingVolume(v: Boolean) = jsOpt("debugShowBoundingVolume", v)
  }
  @js.native
  @JSName("Cesium.PointPrimitiveCollection")
  class PointPrimitiveCollection protected() extends js.Object {
    def this(options: PointPrimitiveCollectionOptions) = this()

    var modelMatrix: Matrix4 = js.native
    var debugShowBoundingVolume: Boolean = js.native
    var length: Double = js.native

    def add(pointPrimitive: js.Any = ???): PointPrimitive = js.native

    def remove(pointPrimitive: PointPrimitive): Boolean = js.native

    def removeAll(): js.Dynamic = js.native

    def contains(pointPrimitive: PointPrimitive = ???): Boolean = js.native

    def get(index: Double): PointPrimitive = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
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
  @js.native
  @JSName("Cesium.Polyline")
  class Polyline protected() extends js.Object {
    def this(options: PolylineOptions) = this()

    var show: Boolean = js.native
    var positions: js.Array[Cartesian3] = js.native
    var material: Material = js.native
    var width: Double = js.native
    var loop: Boolean = js.native
    var id: js.Any = js.native
  }


  @JSName("Cesium.Options")
  @js.native
  trait PolylineCollectionOptions extends js.Object

  object PolylineCollectionOptions extends PolylineCollectionOptionsBuilder(noOpts)

  class PolylineCollectionOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineCollectionOptions, PolylineCollectionOptionsBuilder](new PolylineCollectionOptionsBuilder(_)) {

    def modelMatrix(v: Matrix4) = jsOpt("modelMatrix", v)
    def debugShowBoundingVolume(v: Boolean) = jsOpt("debugShowBoundingVolume", v)
  }
  @js.native
  @JSName("Cesium.PolylineCollection")
  class PolylineCollection protected() extends js.Object {
    def this(options: PolylineCollectionOptions) = this()

    var modelMatrix: Matrix4 = js.native
    var debugShowBoundingVolume: Boolean = js.native
    var length: Double = js.native

    def add(polyline: js.Any = ???): Polyline = js.native

    def remove(polyline: Polyline): Boolean = js.native

    def removeAll(): js.Dynamic = js.native

    def contains(polyline: Polyline): Boolean = js.native

    def get(index: Double): Polyline = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
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
  @js.native
  @JSName("Cesium.PolylineColorAppearance")
  class PolylineColorAppearance protected() extends js.Object {
    def this(options: PolylineColorAppearanceOptions) = this()

    var material: Material = js.native
    var translucent: Boolean = js.native
    var vertexShaderSource: String = js.native
    var fragmentShaderSource: String = js.native
    var renderState: js.Any = js.native
    var closed: Boolean = js.native
    var vertexFormat: VertexFormat = js.native

    def getFragmentShaderSource(): String = js.native

    def isTranslucent(): Boolean = js.native

    def getRenderState(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.PolylineColorAppearance")
  object PolylineColorAppearance extends js.Object {
    var VERTEX_FORMAT: VertexFormat = js.native
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
  @js.native
  @JSName("Cesium.PolylineMaterialAppearance")
  class PolylineMaterialAppearance protected() extends js.Object {
    def this(options: PolylineMaterialAppearanceOptions) = this()

    var material: Material = js.native
    var translucent: Boolean = js.native
    var vertexShaderSource: String = js.native
    var fragmentShaderSource: String = js.native
    var renderState: js.Any = js.native
    var closed: Boolean = js.native
    var vertexFormat: VertexFormat = js.native

    def getFragmentShaderSource(): String = js.native

    def isTranslucent(): Boolean = js.native

    def getRenderState(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.PolylineMaterialAppearance")
  object PolylineMaterialAppearance extends js.Object {
    var VERTEX_FORMAT: VertexFormat = js.native
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
  }
  @js.native
  @JSName("Cesium.Primitive")
  class Primitive protected() extends js.Object {
    def this(options: PrimitiveOptions) = this()

    var geometryInstances: js.Array[GeometryInstance] | GeometryInstance = js.native
    var appearance: Appearance = js.native
    var modelMatrix: Matrix4 = js.native
    var show: Boolean = js.native
    var cull: Boolean = js.native
    var debugShowBoundingVolume: Boolean = js.native
    var vertexCacheOptimize: Boolean = js.native
    var interleave: Boolean = js.native
    var releaseGeometryInstances: Boolean = js.native
    var allowPicking: Boolean = js.native
    var asynchronous: Boolean = js.native
    var compressVertices: Boolean = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Primitive] = js.native

    def update(): js.Dynamic = js.native

    def getGeometryInstanceAttributes(id: js.Any): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }


  @JSName("Cesium.Options")
  @js.native
  trait PrimitiveCollectionOptions extends js.Object

  object PrimitiveCollectionOptions extends PrimitiveCollectionOptionsBuilder(noOpts)

  class PrimitiveCollectionOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PrimitiveCollectionOptions, PrimitiveCollectionOptionsBuilder](new PrimitiveCollectionOptionsBuilder(_)) {

    def show(v: Boolean) = jsOpt("show", v)
    def destroyPrimitives(v: Boolean) = jsOpt("destroyPrimitives", v)


  }
  @js.native
  @JSName("Cesium.PrimitiveCollection")
  class PrimitiveCollection protected() extends js.Object {
    def this(options: PrimitiveCollectionOptions) = this()

    var show: Boolean = js.native
    var destroyPrimitives: Boolean = js.native
    var length: Double = js.native

    def add(primitive: js.Any): js.Dynamic = js.native

    def remove(primitive: js.Any = ???): Boolean = js.native

    def removeAll(): js.Dynamic = js.native

    def contains(primitive: js.Any = ???): Boolean = js.native

    def raise(primitive: js.Any = ???): js.Dynamic = js.native

    def raiseToTop(primitive: js.Any = ???): js.Dynamic = js.native

    def lower(primitive: js.Any = ???): js.Dynamic = js.native

    def lowerToBottom(primitive: js.Any = ???): js.Dynamic = js.native

    def get(index: Double): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
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
  }
  @js.native
  @JSName("Cesium.Scene")
  class Scene protected() extends js.Object {
    def this(options: SceneOptions) = this()

    var rethrowRenderErrors: Boolean = js.native
    var completeMorphOnUserInput: Boolean = js.native
    var morphStart: Event = js.native
    var morphComplete: Event = js.native
    var skyBox: SkyBox = js.native
    var skyAtmosphere: SkyAtmosphere = js.native
    var sun: Sun = js.native
    var sunBloom: Boolean = js.native
    var moon: Moon = js.native
    var backgroundColor: Color = js.native
    var morphTime: Double = js.native
    var farToNearRatio: Double = js.native
    var debugCommandFilter: js.Function = js.native
    var debugShowCommands: Boolean = js.native
    var debugShowFrustums: Boolean = js.native
    var debugShowFramesPerSecond: Boolean = js.native
    var debugShowGlobeDepth: Boolean = js.native
    var debugShowDepthFrustum: Double = js.native
    var fxaa: Boolean = js.native
    var useDepthPicking: Boolean = js.native
    var fog: Fog = js.native
    var canvas: HTMLCanvasElement = js.native
    var drawingBufferHeight: Double = js.native
    var drawingBufferWidth: Double = js.native
    var maximumAliasedLineWidth: Double = js.native
    var maximumCubeMapSize: Double = js.native
    var pickPositionSupported: Boolean = js.native
    var globe: Globe = js.native
    var primitives: PrimitiveCollection = js.native
    var groundPrimitives: PrimitiveCollection = js.native
    var camera: Camera = js.native
    var screenSpaceCameraController: ScreenSpaceCameraController = js.native
    var mapProjection: MapProjection = js.native
    var imageryLayers: ImageryLayerCollection = js.native
    var terrainProvider: TerrainProvider = js.native
    var renderError: Event = js.native
    var preRender: Event = js.native
    var postRender: Event = js.native
    var debugFrustumStatistics: js.Any = js.native
    var scene3DOnly: Boolean = js.native
    var orderIndependentTranslucency: Boolean = js.native
    var id: String = js.native
    var mode: SceneMode = js.native
    var terrainExaggeration: Double = js.native
    var useWebVR: Boolean = js.native

    def pick(windowPosition: Cartesian2): js.Dynamic = js.native

    def pickPosition(windowPosition: Cartesian2, result: Cartesian3 = ???): Cartesian3 = js.native

    def drillPick(windowPosition: Cartesian2, limit: Double = ???): js.Array[js.Any] = js.native

    def completeMorph(): js.Dynamic = js.native

    def morphTo2D(duration: Double = ???): js.Dynamic = js.native

    def morphToColumbusView(duration: Double = ???): js.Dynamic = js.native

    def morphTo3D(duration: Double = ???): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  @js.native
  @JSName("Cesium.ScreenSpaceCameraController")
  class ScreenSpaceCameraController protected() extends js.Object {
    def this(scene: Scene) = this()

    var enableInputs: Boolean = js.native
    var enableTranslate: Boolean = js.native
    var enableZoom: Boolean = js.native
    var enableRotate: Boolean = js.native
    var enableTilt: Boolean = js.native
    var enableLook: Boolean = js.native
    var inertiaSpin: Double = js.native
    var inertiaTranslate: Double = js.native
    var inertiaZoom: Double = js.native
    var maximumMovementRatio: Double = js.native
    var bounceAnimationTime: Double = js.native
    var minimumZoomDistance: Double = js.native
    var maximumZoomDistance: Double = js.native
    var translateEventTypes: CameraEventType | js.Array[js.Any] | Unit = js.native
    var zoomEventTypes: CameraEventType | js.Array[js.Any] | Unit = js.native
    var rotateEventTypes: CameraEventType | js.Array[js.Any] | Unit = js.native
    var tiltEventTypes: CameraEventType | js.Array[js.Any] | Unit = js.native
    var lookEventTypes: CameraEventType | js.Array[js.Any] | Unit = js.native
    var minimumPickingTerrainHeight: Double = js.native
    var minimumCollisionTerrainHeight: Double = js.native
    var minimumTrackBallHeight: Double = js.native
    var enableCollisionDetection: Boolean = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
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
  @js.native
  @JSName("Cesium.SingleTileImageryProvider")
  class SingleTileImageryProvider protected() extends js.Object {
    def this(options: SingleTileImageryProviderOptions) = this()

    var url: String = js.native
    var proxy: Proxy = js.native
    var tileWidth: Double = js.native
    var tileHeight: Double = js.native
    var maximumLevel: Double = js.native
    var minimumLevel: Double = js.native
    var tilingScheme: TilingScheme = js.native
    var rectangle: Rectangle = js.native
    var tileDiscardPolicy: TileDiscardPolicy = js.native
    var errorEvent: Event = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var credit: Credit = js.native
    var hasAlphaChannel: Boolean = js.native

    def getTileCredits(x: Double, y: Double, level: Double): js.Array[Credit] = js.native

    def requestImage(x: Double, y: Double, level: Double): Promise[HTMLImageElement | HTMLCanvasElement] | Unit = js.native

    def pickFeatures(x: Double, y: Double, level: Double, longitude: Double, latitude: Double): Promise[js.Array[ImageryLayerFeatureInfo]] | Unit = js.native
  }

  @js.native
  @JSName("Cesium.SkyAtmosphere")
  class SkyAtmosphere protected() extends js.Object {
    def this(ellipsoid: Ellipsoid = ???) = this()

    var show: Boolean = js.native
    var ellipsoid: Ellipsoid = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }


  @JSName("Cesium.Options")
  @js.native
  trait SkyBoxOptions extends js.Object

  object SkyBoxOptions extends SkyBoxOptionsBuilder(noOpts)

  class SkyBoxOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[SkyBoxOptions, SkyBoxOptionsBuilder](new SkyBoxOptionsBuilder(_)) {

    def sources(v: Object) = jsOpt("sources", v)
    def show(v: Boolean) = jsOpt("show", v)

  }
  @js.native
  @JSName("Cesium.SkyBox")
  class SkyBox protected() extends js.Object {
    def this(options: SkyBoxOptions) = this()

    var sources: js.Any = js.native
    var show: Boolean = js.native

    def update(): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  @js.native
  @JSName("Cesium.Sun")
  class Sun extends js.Object {
    var show: Boolean = js.native
    var glowFactor: Double = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
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
  @js.native
  @JSName("Cesium.TileCoordinatesImageryProvider")
  class TileCoordinatesImageryProvider protected() extends js.Object {
    def this(options: TileCoordinatesImageryProviderOptions) = this()

    var proxy: Proxy = js.native
    var tileWidth: Double = js.native
    var tileHeight: Double = js.native
    var maximumLevel: Double = js.native
    var minimumLevel: Double = js.native
    var tilingScheme: TilingScheme = js.native
    var rectangle: Rectangle = js.native
    var tileDiscardPolicy: TileDiscardPolicy = js.native
    var errorEvent: Event = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var credit: Credit = js.native
    var hasAlphaChannel: Boolean = js.native

    def getTileCredits(x: Double, y: Double, level: Double): js.Array[Credit] = js.native

    def requestImage(x: Double, y: Double, level: Double): Promise[HTMLImageElement | HTMLCanvasElement] | Unit = js.native

    def pickFeatures(x: Double, y: Double, level: Double, longitude: Double, latitude: Double): Promise[js.Array[ImageryLayerFeatureInfo]] | Unit = js.native
  }

  @js.native
  @JSName("Cesium.TileDiscardPolicy")
  class TileDiscardPolicy extends js.Object {
    def isReady(): Boolean = js.native

    def shouldDiscardImage(image: HTMLImageElement): Boolean = js.native
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
  @js.native
  @JSName("Cesium.UrlTemplateImageryProvider")
  class UrlTemplateImageryProvider protected() extends js.Object {
    def this(options: UrlTemplateImageryProviderOptions) = this()

    var enablePickFeatures: Boolean = js.native
    var url: String = js.native
    var proxy: Proxy = js.native
    var tileWidth: Double = js.native
    var tileHeight: Double = js.native
    var maximumLevel: Double = js.native
    var minimumLevel: Double = js.native
    var tilingScheme: TilingScheme = js.native
    var rectangle: Rectangle = js.native
    var tileDiscardPolicy: TileDiscardPolicy = js.native
    var errorEvent: Event = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var credit: Credit = js.native
    var hasAlphaChannel: Boolean = js.native

    def reinitialize(options: Promise[js.Any] | js.Any): js.Dynamic = js.native

    def getTileCredits(x: Double, y: Double, level: Double): js.Array[Credit] = js.native

    def requestImage(x: Double, y: Double, level: Double): Promise[HTMLImageElement | HTMLCanvasElement] | Unit = js.native

    def pickFeatures(x: Double, y: Double, level: Double, longitude: Double, latitude: Double): Promise[js.Array[ImageryLayerFeatureInfo]] | Unit = js.native
  }

  @js.native
  @JSName("Cesium.ViewportQuad")
  class ViewportQuad protected() extends js.Object {
    def this(rectangle: BoundingRectangle = ???, material: Material = ???) = this()

    var show: Boolean = js.native
    var rectangle: BoundingRectangle = js.native
    var material: Material = js.native

    def update(): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
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
  @js.native
  @JSName("Cesium.WebMapServiceImageryProvider")
  class WebMapServiceImageryProvider protected() extends js.Object {
    def this(options: WebMapServiceImageryProviderOptions) = this()

    var url: String = js.native
    var proxy: Proxy = js.native
    var layers: String = js.native
    var tileWidth: Double = js.native
    var tileHeight: Double = js.native
    var maximumLevel: Double = js.native
    var minimumLevel: Double = js.native
    var tilingScheme: TilingScheme = js.native
    var rectangle: Rectangle = js.native
    var tileDiscardPolicy: TileDiscardPolicy = js.native
    var errorEvent: Event = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var credit: Credit = js.native
    var hasAlphaChannel: Boolean = js.native

    def getTileCredits(x: Double, y: Double, level: Double): js.Array[Credit] = js.native

    def requestImage(x: Double, y: Double, level: Double): Promise[HTMLImageElement | HTMLCanvasElement] | Unit = js.native

    def pickFeatures(x: Double, y: Double, level: Double, longitude: Double, latitude: Double): Promise[js.Array[ImageryLayerFeatureInfo]] | Unit = js.native
  }

  @js.native
  @JSName("Cesium.WebMapServiceImageryProvider")
  object WebMapServiceImageryProvider extends js.Object {
    var DefaultParameters: js.Any = js.native
    var GetFeatureInfoDefaultParameters: js.Any = js.native
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
    def tileMatrixSetID(v: String ) = jsOpt("tileMatrixSetID", v)
    def subdomains(v: String | Array[String]) = jsOpt("subdomains", v)

  }
  @js.native
  @JSName("Cesium.WebMapTileServiceImageryProvider")
  class WebMapTileServiceImageryProvider protected() extends js.Object {
    def this(options: WebMapTileServiceImageryProviderOptions) = this()

    var url: String = js.native
    var proxy: Proxy = js.native
    var tileWidth: Double = js.native
    var tileHeight: Double = js.native
    var maximumLevel: Double = js.native
    var minimumLevel: Double = js.native
    var tilingScheme: TilingScheme = js.native
    var rectangle: Rectangle = js.native
    var tileDiscardPolicy: TileDiscardPolicy = js.native
    var errorEvent: Event = js.native
    var format: String = js.native
    var ready: Boolean = js.native
    var readyPromise: Promise[Boolean] = js.native
    var credit: Credit = js.native
    var hasAlphaChannel: Boolean = js.native

    def getTileCredits(x: Double, y: Double, level: Double): js.Array[Credit] = js.native

    def requestImage(x: Double, y: Double, level: Double): Promise[HTMLImageElement | HTMLCanvasElement] | Unit = js.native

    def pickFeatures(x: Double, y: Double, level: Double, longitude: Double, latitude: Double): Promise[js.Array[ImageryLayerFeatureInfo]] | Unit = js.native
  }

  @js.native
  @JSName("Cesium.Animation")
  class Animation protected() extends js.Object {
    def this(container: Element | String, viewModel: AnimationViewModel) = this()

    var container: Element = js.native
    var viewModel: AnimationViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def resize(): js.Dynamic = js.native

    def applyThemeChanges(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.AnimationViewModel")
  class AnimationViewModel protected() extends js.Object {
    def this(clockViewModel: ClockViewModel) = this()

    var shuttleRingDragging: Boolean = js.native
    var snapToTicks: Boolean = js.native
    var timeLabel: String = js.native
    var dateLabel: String = js.native
    var multiplierLabel: String = js.native
    var shuttleRingAngle: Double = js.native
    var slower: Command = js.native
    var faster: Command = js.native
    var clockViewModel: ClockViewModel = js.native
    var pauseViewModel: ToggleButtonViewModel = js.native
    var playReverseViewModel: ToggleButtonViewModel = js.native
    var playForwardViewModel: ToggleButtonViewModel = js.native
    var playRealtimeViewModel: ToggleButtonViewModel = js.native
    var dateFormatter: AnimationViewModel.DateFormatter = js.native
    var timeFormatter: AnimationViewModel.TimeFormatter = js.native

    def getShuttleRingTicks(): js.Array[Double] = js.native

    def setShuttleRingTicks(positiveTicks: js.Array[Double]): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.AnimationViewModel")
  object AnimationViewModel extends js.Object {
    type DateFormatter = js.Function2[JulianDate, AnimationViewModel, String]
    type TimeFormatter = js.Function2[JulianDate, AnimationViewModel, String]
    var defaultDateFormatter: AnimationViewModel.DateFormatter = js.native
    var defaultTicks: js.Array[Double] = js.native
    var defaultTimeFormatter: AnimationViewModel.TimeFormatter = js.native
  }

  @js.native
  @JSName("Cesium.BaseLayerPicker")
  class BaseLayerPicker protected() extends js.Object {
    def this(container: Element | String, options: js.Any) = this()

    var container: Element = js.native
    var viewModel: BaseLayerPickerViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
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
  @js.native
  @JSName("Cesium.BaseLayerPickerViewModel")
  class BaseLayerPickerViewModel protected() extends js.Object {
    def this(options: BaseLayerPickerViewModelOptions) = this()

    var imageryProviderViewModels: js.Array[ProviderViewModel] = js.native
    var terrainProviderViewModels: js.Array[ProviderViewModel] = js.native
    var dropDownVisible: Boolean = js.native
    var buttonTooltip: String = js.native
    var buttonImageUrl: String = js.native
    var selectedImagery: ProviderViewModel = js.native
    var selectedTerrain: ProviderViewModel = js.native
    var toggleDropDown: Command = js.native
    var globe: Globe = js.native
  }

  @JSName("Cesium.ProviderViewModel")
  @js.native
  object ProviderViewModel extends js.Object {
    type CreationFunction = js.Function0[ImageryProvider | TerrainProvider | js.Array[ImageryProvider] | js.Array[TerrainProvider]]
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
  @js.native
  @JSName("Cesium.ProviderViewModel")
  class ProviderViewModel protected() extends js.Object {
    def this(options: ProviderViewModelOptions) = this()

    var name: String = js.native
    var tooltip: String = js.native
    var iconUrl: String = js.native
    var creationCommand: Command = js.native
  }

  @js.native
  @JSName("Cesium.CesiumInspector")
  class CesiumInspector protected() extends js.Object {
    def this(container: Element | String, scene: Scene) = this()

    var container: Element = js.native
    var viewModel: CesiumInspectorViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.CesiumInspectorViewModel")
  class CesiumInspectorViewModel protected() extends js.Object {
    def this(scene: Scene) = this()

    var frustums: Boolean = js.native
    var performance: Boolean = js.native
    var shaderCacheText: String = js.native
    var primitiveBoundingSphere: Boolean = js.native
    var primitiveReferenceFrame: Boolean = js.native
    var filterPrimitive: Boolean = js.native
    var tileBoundingSphere: Boolean = js.native
    var filterTile: Boolean = js.native
    var wireframe: Boolean = js.native
    var globeDepth: Boolean = js.native
    var pickDepth: Boolean = js.native
    var depthFrustum: Double = js.native
    var depthFrustumText: String = js.native
    var suspendUpdates: Boolean = js.native
    var tileCoordinates: Boolean = js.native
    var frustumStatisticText: String = js.native
    var tileText: String = js.native
    var hasPickedPrimitive: Boolean = js.native
    var hasPickedTile: Boolean = js.native
    var pickPimitiveActive: Boolean = js.native
    var pickTileActive: Boolean = js.native
    var dropDownVisible: Boolean = js.native
    var generalVisible: Boolean = js.native
    var primitivesVisible: Boolean = js.native
    var terrainVisible: Boolean = js.native
    var generalSwitchText: String = js.native
    var primitivesSwitchText: String = js.native
    var terrainSwitchText: String = js.native
    var scene: Scene = js.native
    var performanceContainer: Element = js.native
    var toggleDropDown: Command = js.native
    var showFrustums: Command = js.native
    var showPerformance: Command = js.native
    var showPrimitiveBoundingSphere: Command = js.native
    var showPrimitiveReferenceFrame: Command = js.native
    var doFilterPrimitive: Command = js.native
    var showWireframe: Command = js.native
    var showGlobeDepth: Command = js.native
    var showPickDepth: Command = js.native
    var incrementDepthFrustum: Command = js.native
    var decrementDepthFrustum: Command = js.native
    var doSuspendUpdates: Command = js.native
    var showTileCoordinates: Command = js.native
    var showTileBoundingSphere: Command = js.native
    var doFilterTile: Command = js.native
    var toggleGeneral: Command = js.native
    var togglePrimitives: Command = js.native
    var toggleTerrain: Command = js.native
    var pickPrimitive: Command = js.native
    var pickTile: Command = js.native
    var selectParent: Command = js.native
    var selectNW: Command = js.native
    var selectNE: Command = js.native
    var selectSW: Command = js.native
    var selectSE: Command = js.native
    var primitive: Command = js.native
    var tile: Command = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.CesiumWidget")
  class CesiumWidget protected() extends js.Object {
    def this(container: Element | String, options: js.Any = ???) = this()

    var container: Element = js.native
    var canvas: HTMLCanvasElement = js.native
    var creditContainer: Element = js.native
    var scene: Scene = js.native
    var imageryLayers: ImageryLayerCollection = js.native
    var terrainProvider: TerrainProvider = js.native
    var camera: Camera = js.native
    var clock: Clock = js.native
    var screenSpaceEventHandler: ScreenSpaceEventHandler = js.native
    var targetFrameRate: Double = js.native
    var useDefaultRenderLoop: Boolean = js.native
    var resolutionScale: Double = js.native

    def showErrorPanel(title: String, message: String, error: String = ???): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def resize(): js.Dynamic = js.native

    def render(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.ClockViewModel")
  class ClockViewModel protected() extends js.Object {
    def this(clock: Clock = ???) = this()

    var systemTime: JulianDate = js.native
    var startTime: JulianDate = js.native
    var stopTime: JulianDate = js.native
    var currentTime: JulianDate = js.native
    var multiplier: Double = js.native
    var clockStep: ClockStep = js.native
    var clockRange: ClockRange = js.native
    var canAnimate: Boolean = js.native
    var shouldAnimate: Boolean = js.native
    var clock: Clock = js.native

    def synchronize(): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.Command")
  class Command extends js.Object {
    var canExecute: Boolean = js.native
    var beforeExecute: Event = js.native
    var afterExecute: Event = js.native
  }

  @js.native
  @JSName("Cesium.FullscreenButton")
  class FullscreenButton protected() extends js.Object {
    def this(container: Element | String, fullscreenElement: Element | String = ???) = this()

    var container: Element = js.native
    var viewModel: FullscreenButtonViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.FullscreenButtonViewModel")
  class FullscreenButtonViewModel protected() extends js.Object {
    def this(fullscreenElement: Element | String = ???) = this()

    var isFullscreen: Boolean = js.native
    var isFullscreenEnabled: Boolean = js.native
    var tooltip: String = js.native
    var fullscreenElement: Element = js.native
    var command: Command = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
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
  @js.native
  @JSName("Cesium.Geocoder")
  class Geocoder protected() extends js.Object {
    def this(options: GeocoderOptions) = this()

    var container: Element = js.native
    var viewModel: GeocoderViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
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
  @js.native
  @JSName("Cesium.GeocoderViewModel")
  class GeocoderViewModel protected() extends js.Object {
    def this(options: GeocoderViewModelOptions) = this()

    var isSearchInProgress: Boolean = js.native
    var searchText: String = js.native
    var flightDuration: Double | Unit = js.native
    var url: String = js.native
    var key: String = js.native
    var complete: Event = js.native
    var scene: Scene = js.native
    var search: Command = js.native
  }

  @js.native
  @JSName("Cesium.HomeButton")
  class HomeButton protected() extends js.Object {
    def this(container: Element | String, scene: Scene, duration: Double = ???) = this()

    var container: Element = js.native
    var viewModel: HomeButtonViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.HomeButtonViewModel")
  class HomeButtonViewModel protected() extends js.Object {
    def this(scene: Scene, duration: Double = ???) = this()

    var tooltip: String = js.native
    var scene: Scene = js.native
    var command: Command = js.native
    var duration: Double | Unit = js.native
  }

  @js.native
  @JSName("Cesium.InfoBox")
  class InfoBox protected() extends js.Object {
    def this(container: Element | String) = this()

    var container: Element = js.native
    var viewModel: InfoBoxViewModel = js.native
    var frame: HTMLIFrameElement = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.InfoBoxViewModel")
  class InfoBoxViewModel extends js.Object {
    var maxHeight: Double = js.native
    var enableCamera: Boolean = js.native
    var isCameraTracking: Boolean = js.native
    var showInfo: Boolean = js.native
    var titleText: String = js.native
    var description: String = js.native
    var cameraIconPath: String = js.native
    var cameraClicked: Event = js.native
    var closeClicked: Event = js.native

    def maxHeightOffset(offset: Double): String = js.native
  }


  @JSName("Cesium.Options")
  @js.native
  trait NavigationHelpButtonOptions extends js.Object

  object NavigationHelpButtonOptions extends NavigationHelpButtonOptionsBuilder(noOpts)

  class NavigationHelpButtonOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[NavigationHelpButtonOptions, NavigationHelpButtonOptionsBuilder](new NavigationHelpButtonOptionsBuilder(_)) {

    def container(v: 	Element | String	) = jsOpt("container", v)
    def instructionsInitiallyVisible(v: Boolean) = jsOpt("instructionsInitiallyVisible", v)


  }
  @js.native
  @JSName("Cesium.NavigationHelpButton")
  class NavigationHelpButton protected() extends js.Object {
    def this(options: NavigationHelpButtonOptions) = this()

    var container: Element = js.native
    var viewModel: NavigationHelpButtonViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.NavigationHelpButtonViewModel")
  class NavigationHelpButtonViewModel extends js.Object {
    var showInstructions: Boolean = js.native
    var tooltip: String = js.native
    var command: Command = js.native
    var showClick: Command = js.native
    var showTouch: Command = js.native
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
  @js.native
  @JSName("Cesium.PerformanceWatchdog")
  class PerformanceWatchdog protected() extends js.Object {
    def this(options: PerformanceWatchdogOptions) = this()

    var container: Element = js.native
    var viewModel: PerformanceWatchdogViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }


  @JSName("Cesium.Options")
  @js.native
  trait PerformanceWatchdogViewModelOptions extends js.Object

  object PerformanceWatchdogViewModelOptions extends PerformanceWatchdogViewModelOptionsBuilder(noOpts)

  class PerformanceWatchdogViewModelOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PerformanceWatchdogViewModelOptions, PerformanceWatchdogViewModelOptionsBuilder](new PerformanceWatchdogViewModelOptionsBuilder(_)) {

    def scene(v: Scene) = jsOpt("scene", v)
    def lowFrameRateMessage(v: String) = jsOpt("lowFrameRateMessage", v)


  }
  @js.native
  @JSName("Cesium.PerformanceWatchdogViewModel")
  class PerformanceWatchdogViewModel protected() extends js.Object {
    def this(options: PerformanceWatchdogViewModelOptions) = this()

    var lowFrameRateMessage: String = js.native
    var lowFrameRateMessageDismissed: Boolean = js.native
    var showingLowFrameRateMessage: Boolean = js.native
    var scene: Scene = js.native
    var dismissMessage: Command = js.native
  }

  @js.native
  @JSName("Cesium.SceneModePicker")
  class SceneModePicker protected() extends js.Object {
    def this(container: Element | String, scene: Scene, duration: Double = ???) = this()

    var container: Element = js.native
    var viewModel: SceneModePickerViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.SceneModePickerViewModel")
  class SceneModePickerViewModel protected() extends js.Object {
    def this(scene: Scene, duration: Double = ???) = this()

    var sceneMode: SceneMode = js.native
    var dropDownVisible: Boolean = js.native
    var tooltip2D: String = js.native
    var tooltip3D: String = js.native
    var tooltipColumbusView: String = js.native
    var selectedTooltip: String = js.native
    var scene: Scene = js.native
    var duration: Double = js.native
    var toggleDropDown: Command = js.native
    var morphTo2D: Command = js.native
    var morphTo3D: Command = js.native
    var morphToColumbusView: Command = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.SelectionIndicator")
  class SelectionIndicator protected() extends js.Object {
    def this(container: Element | String, scene: Scene) = this()

    var container: Element = js.native
    var viewModel: SelectionIndicatorViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @JSName("Cesium.SelectionIndicatorViewModel")
  @js.native
  object SelectionIndicatorViewModel extends js.Object {
    type ComputeScreenSpacePosition = js.Function2[Cartesian3, Cartesian2, Cartesian2]
  }

  @js.native
  @JSName("Cesium.SelectionIndicatorViewModel")
  class SelectionIndicatorViewModel protected() extends js.Object {
    def this(scene: Scene, selectionIndicatorElement: Element, container: Element) = this()

    var position: Cartesian3 = js.native
    var showSelection: Boolean = js.native
    var isVisible: Boolean = js.native
    var computeScreenSpacePosition: SelectionIndicatorViewModel.ComputeScreenSpacePosition = js.native
    var container: Element = js.native
    var selectionIndicatorElement: Element = js.native
    var scene: Scene = js.native

    def update(): js.Dynamic = js.native

    def animateAppear(): js.Dynamic = js.native

    def animateDepart(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.Timeline")
  class Timeline protected() extends js.Object {
    def this(container: Element, clock: Clock) = this()

    var container: Element = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def zoomTo(startTime: JulianDate, stopTime: JulianDate): js.Dynamic = js.native

    def resize(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.ToggleButtonViewModel")
  class ToggleButtonViewModel protected() extends js.Object {
    def this(command: Command, options: js.Any = ???) = this()

    var toggled: Boolean = js.native
    var tooltip: String = js.native
    var command: Command = js.native
  }

  @js.native
  @JSName("Cesium.VRButton")
  class VRButton protected() extends js.Object {
    def this(container: Element | String, scene: Scene, vrElement: Element | String = ???) = this()

    var container: Element = js.native
    var viewModel: VRButtonViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.VRButtonViewModel")
  class VRButtonViewModel protected() extends js.Object {
    def this(scene: Scene, vrElement: Element | String = ???) = this()

    var isVRMode: Boolean = js.native
    var isVREnabled: Boolean = js.native
    var tooltip: String = js.native
    var vrElement: Element = js.native
    var command: Command = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  @JSName("Cesium.Viewer")
  @js.native
  object Viewer extends js.Object {
    type ViewerMixin = js.Function2[Viewer, js.Any, Unit]
  }

  @js.native
  @JSName("Cesium.Viewer")
  class Viewer protected() extends js.Object {
    def this(container: Element | String, options: js.Any = ???) = this()

    var container: Element = js.native
    var bottomContainer: Element = js.native
    var cesiumWidget: CesiumWidget = js.native
    var selectionIndicator: SelectionIndicator = js.native
    var infoBox: InfoBox = js.native
    var geocoder: Geocoder = js.native
    var homeButton: HomeButton = js.native
    var sceneModePicker: SceneModePicker = js.native
    var baseLayerPicker: BaseLayerPicker = js.native
    var navigationHelpButton: NavigationHelpButton = js.native
    var animation: Animation = js.native
    var timeline: Timeline = js.native
    var fullscreenButton: FullscreenButton = js.native
    var vrButton: VRButton = js.native
    var dataSourceDisplay: DataSourceDisplay = js.native
    var entities: EntityCollection = js.native
    var dataSources: DataSourceCollection = js.native
    var canvas: HTMLCanvasElement = js.native
    var cesiumLogo: Element = js.native
    var scene: Scene = js.native
    var imageryLayers: ImageryLayerCollection = js.native
    var terrainProvider: TerrainProvider = js.native
    var camera: Camera = js.native
    var clock: Clock = js.native
    var screenSpaceEventHandler: ScreenSpaceEventHandler = js.native
    var targetFrameRate: Double = js.native
    var useDefaultRenderLoop: Boolean = js.native
    var resolutionScale: Double = js.native
    var allowDataSourcesToSuspendAnimation: Boolean = js.native
    var trackedEntity: Entity = js.native
    var selectedEntity: Entity = js.native

    def extend(mixin: Viewer.ViewerMixin, options: js.Any = ???): js.Dynamic = js.native

    def resize(): js.Dynamic = js.native

    def forceResize(): js.Dynamic = js.native

    def render(): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def zoomTo(target: Entity | js.Array[Entity] | EntityCollection | DataSource | ImageryLayer | Promise[Entity | js.Array[Entity] | EntityCollection | DataSource | ImageryLayer], offset: HeadingPitchRange = ???): Promise[Boolean] = js.native

    def flyTo(target: Entity | js.Array[Entity] | EntityCollection | DataSource | ImageryLayer | Promise[Entity | js.Array[Entity] | EntityCollection | DataSource | ImageryLayer], options: js.Any = ???): Promise[Boolean] = js.native
  }


  @JSName("Cesium.binarySearch")
  @js.native
  object BinarySearch extends js.Object {
    type Comparator = js.Function2[js.Any, js.Any, Double]
  }

  @JSName("Cesium.mergeSort")
  @js.native
  object MergeSort extends js.Object {
    type Comparator = js.Function3[js.Any, js.Any, js.Any, Double]
  }

  @JSName("Cesium.requestAnimationFrame")
  @js.native
  object RequestAnimationFrame extends js.Object {
    type Callback = js.Function1[Double, Unit]
  }

  @JSName("Cesium.throttleRequestByServer")
  @js.native
  object ThrottleRequestByServer extends js.Object {
    type RequestFunction = js.Function1[String, Promise[js.Any]]
  }

  @JSName("Cesium.createTaskProcessorWorker")
  @js.native
  object CreateTaskProcessorWorker extends js.Object {
    type WorkerFunction = js.Function2[js.Any, js.Array[js.Any], Any]
    type TaskProcessorWorkerFunction = js.Function1[js.Any, Unit]
  }


  @JSName("Cesium")
  @js.native
  object Cesium extends js.Object {
    type RenderState = js.Any
    type TypedArray = Int8Array | Uint8Array | Int16Array | Uint16Array | Float32Array | Float64Array

    def barycentricCoordinates(point: Cartesian2 | Cartesian3, p0: Cartesian2 | Cartesian3, p1: Cartesian2 | Cartesian3, p2: Cartesian2 | Cartesian3, result: Cartesian3 = ???): Cartesian3 = js.native

    def binarySearch(array: js.Array[js.Any], itemToFind: js.Any, comparator: BinarySearch.Comparator): Double = js.native

    def cancelAnimationFrame(requestID: Double): js.Dynamic = js.native

    def clone(`object`: js.Any, deep: Boolean = ???): js.Dynamic = js.native

    def combine(object1: js.Any = ???, object2: js.Any = ???, deep: Boolean = ???): js.Dynamic = js.native

    def createGuid(): String = js.native

    def defaultValue(a: js.Any, b: js.Any): js.Dynamic = js.native

    def defined(value: js.Any): Boolean = js.native

    def destroyObject(`object`: js.Any, message: String = ???): js.Dynamic = js.native

    def formatError(`object`: js.Any): String = js.native

    def getAbsoluteUri(relative: String, base: String = ???): String = js.native

    def getBaseUri(uri: String, includeQuery: Boolean = ???): String = js.native

    def getExtensionFromUri(uri: String): String = js.native

    def getFilenameFromUri(uri: String): String = js.native

    def getImagePixels(image: HTMLImageElement): js.Array[Double] = js.native

    def isArray(value: js.Any): Boolean = js.native

    def isLeapYear(year: Double): Boolean = js.native

    def loadArrayBuffer(url: String | Promise[String], headers: js.Any = ???): Promise[ArrayBuffer] = js.native

    def loadBlob(url: String | Promise[String], headers: js.Any = ???): Promise[Blob] = js.native

    def loadImage(url: String | Promise[String], allowCrossOrigin: Boolean = ???): Promise[HTMLImageElement] = js.native

    def loadImageViaBlob(url: String | Promise[String]): Promise[HTMLImageElement] = js.native

    def loadJson(url: String | Promise[String], headers: js.Any = ???): Promise[js.Any] = js.native

    def loadJsonp(url: String, options: js.Any = ???): Promise[js.Any] = js.native

    def loadText(url: String | Promise[String], headers: js.Any = ???): Promise[String] = js.native

    def loadWithXhr(options: js.Any): Promise[js.Any] = js.native

    def loadXML(url: String | Promise[String], headers: js.Any = ???): Promise[js.Any] = js.native

    def mergeSort(array: js.Array[js.Any], comparator: MergeSort.Comparator, userDefinedObject: js.Any = ???): js.Dynamic = js.native

    def objectToQuery(obj: js.Any): String = js.native

    def pointInsideTriangle(point: Cartesian2 | Cartesian3, p0: Cartesian2 | Cartesian3, p1: Cartesian2 | Cartesian3, p2: Cartesian2 | Cartesian3): Boolean = js.native

    def queryToObject(queryString: String): js.Dynamic = js.native

    def requestAnimationFrame(callback: RequestAnimationFrame.Callback): Double = js.native

    def sampleTerrain(terrainProvider: TerrainProvider, level: Double, positions: js.Array[Cartographic]): Promise[js.Array[Cartographic]] = js.native

    def subdivideArray(array: js.Array[js.Any], numberOfArrays: Double): js.Dynamic = js.native

    def throttleRequestByServer(url: String, requestFunction: ThrottleRequestByServer.RequestFunction): Promise[js.Any] | Unit = js.native

    def createOpenStreetMapImageryProvider(options: js.Any = ???): UrlTemplateImageryProvider = js.native

    def createTangentSpaceDebugPrimitive(options: js.Any): Primitive = js.native

    def createTileMapServiceImageryProvider(options: js.Any = ???): UrlTemplateImageryProvider = js.native

    def viewerCesiumInspectorMixin(viewer: Viewer): js.Dynamic = js.native

    def viewerDragDropMixin(viewer: Viewer, options: js.Any = ???): js.Dynamic = js.native

    def viewerPerformanceWatchdogMixin(viewer: Viewer): js.Dynamic = js.native

    def createCommand(func: js.Function, canExecute: Boolean = ???): js.Dynamic = js.native

    def createTaskProcessorWorker(workerFunction: CreateTaskProcessorWorker.WorkerFunction): CreateTaskProcessorWorker.TaskProcessorWorkerFunction = js.native
  }

}


