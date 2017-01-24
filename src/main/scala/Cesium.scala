/**
  * A Scala.js facade for Cesium.js "An open-source JavaScript library for world-class 3D globes and maps"
  *
  * Reference:  [[http://cesiumjs.org/ and https://cesiumjs.org/refdoc.html]]
  *
  * This package implements the core elements of Cesium.
  *
  * @author Ringo Wathelet
  *         Date: 22/05/16
  */
package cesium {

  import cesiumOptions._
  import org.scalajs.dom.html.Canvas

  import scala.concurrent._
  import scala.scalajs.js
  import scala.scalajs.js.annotation._
  import scala.scalajs.js.{Promise => _, _}
  import org.scalajs.dom.{Blob, Document, Element}
  import org.scalajs.dom.raw.{HTMLCanvasElement, HTMLImageElement, HTMLVideoElement}
  import org.w3c.dom.html.{HTMLElement, HTMLIFrameElement}

  import scala.scalajs.js.typedarray.{ArrayBuffer, Float32Array, Float64Array, Int16Array, Int8Array, TypedArray, Uint16Array, Uint32Array, Uint8Array}

  import scala.language.implicitConversions

  // -------------------------------------------------------------------------------------
  // -------------------------------------------------------------------------------------
  // -------------------------------------------------------------------------------------

  @js.native
  sealed trait ShadowMode extends js.Object

  @JSName("Cesium.ShadowMode")
  @js.native
  object ShadowMode extends js.Object {
    val DISABLED: Int = js.native
    val ENABLED: Int = js.native
    val CAST_ONLY: Int = js.native
    val RECEIVE_ONLY: Int = js.native
    val NUMBER_OF_SHADOW_MODES: Int = js.native

    @JSBracketAccess
    def apply(value: ShadowMode): Int = js.native
  }

  @js.native
  sealed trait ColorBlendMode extends js.Object

  @JSName("Cesium.ColorBlendMode")
  @js.native
  object ColorBlendMode extends js.Object {
    val HIGHLIGHT: Int = js.native
    val REPLACE: Int = js.native
    val MIX: Int = js.native

    @JSBracketAccess
    def apply(value: ColorBlendMode): Int = js.native
  }

  @JSName("Cesium.Transforms")
  @js.native
  object Transforms extends js.Object {
    def computeFixedToIcrfMatrix(date: JulianDate, result: Option[Matrix3] = None): Matrix3 = js.native

    def computeIcrfToFixedMatrix(date: JulianDate, result: Option[Matrix3] = None): Matrix3 = js.native

    def computeTemeToPseudoFixedMatrix(date: JulianDate, result: Option[Matrix3] = None): Matrix3 = js.native

    def northUpEastToFixedFrame(origin: Cartesian3,
                                ellipsoid: Option[Ellipsoid] = None,
                                result: Option[Matrix4] = None): Matrix4 = js.native

    def northEastDownToFixedFrame(origin: Cartesian3, ellipsoid: Option[Ellipsoid] = None, result: Option[Matrix4] = None): Matrix4 = js.native

    def eastNorthUpToFixedFrame(origin: Cartesian3,
                                ellipsoid: Option[Ellipsoid] = None,
                                result: Option[Matrix4] = None): Matrix4 = js.native

    def headingPitchRollQuaternion(origin: Cartesian3,
                                   headingPitchRoll: HeadingPitchRoll,
                                   ellipsoid: Option[Ellipsoid] = None,
                                   result: Option[Quaternion] = None): Quaternion = js.native

    def headingPitchRollToFixedFrame(origin: Cartesian3,
                                     headingPitchRoll: HeadingPitchRoll,
                                     ellipsoid: Option[Ellipsoid] = None,
                                     result: Option[Matrix4] = None): Matrix4 = js.native

    def pointToWindowCoordinates(modelViewProjectionMatrix: Matrix4,
                                 viewportTransformation: Matrix4,
                                 point: Cartesian3, result: Option[Cartesian2] = None): Cartesian2 = js.native

    def preloadIcrfFixed(timeInterval: TimeInterval): Promise[Unit] = js.native

    def aircraftHeadingPitchRollToFixedFrame(origin: Cartesian3,
                                             headingPitchRoll: HeadingPitchRoll,
                                             ellipsoid: Option[Ellipsoid] ,
                                             result: Option[Matrix4]): Matrix4 = js.native

    def aircraftHeadingPitchRollQuaternion(origin: Cartesian3,
                                           headingPitchRoll: HeadingPitchRoll,
                                           ellipsoid: Option[Ellipsoid],
                                           result: Option[Quaternion]): Quaternion = js.native
  }

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
    // 1
    val INSIDE: Int = js.native
    // 0
    val INTERSECTING: Int = js.native
    // -1
    val OUTSIDE: Int = js.native

    @JSBracketAccess
    def apply(value: Intersect): Int = js.native
  }

  @js.native
  sealed trait ClockStep extends js.Object

  @JSName("Cesium.ClockStep")
  @js.native
  object ClockStep extends js.Object {
    // 2
    val SYSTEM_CLOCK: Int = js.native
    // 1
    val SYSTEM_CLOCK_MULTIPLIER: Int = js.native
    // 0
    val TICK_DEPENDENT: Int = js.native

    @JSBracketAccess
    def apply(value: Int): ClockStep = js.native
  }

  @js.native
  sealed trait ClockRange extends js.Object

  @JSName("Cesium.ClockRange")
  @js.native
  object ClockRange extends js.Object {
    // 1
    val CLAMPED: Int = js.native
    // 2
    val LOOP_STOP: Int = js.native
    // 0
    val UNBOUNDED: Int = js.native

    @JSBracketAccess
    def apply(value: Int): ClockRange = js.native
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

    def fromName(name: String): ComponentDatatype = js.native
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
    // 0
    val UTC: Int = js.native
    // 1
    val TAI: Int = js.native

    @JSBracketAccess
    def apply(value: TimeStandard): Int = js.native
  }

  @js.native
  sealed trait ReferenceFrame extends js.Object

  @JSName("Cesium.ReferenceFrame")
  @js.native
  object ReferenceFrame extends js.Object {
    // 0
    val FIXED: Int = js.native
    // 1
    val INERTIAL: Int = js.native

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

  @js.native
  sealed trait InterpolationAlgorithm extends js.Object {
    var `type`: String = js.native

    def apply(value: InterpolationAlgorithm): Int = js.native

    def getRequiredDataPoints(degree: Int): Int = js.native

    def interpolate(x: Double, xTable: Array[Double], yTable: Array[Double], yStride: Array[Int], inputOrder: Int, outputOrder: Int, result: Array[Double] = ???): Array[Double] = js.native

    def interpolateOrderZero(x: Double, xTable: Array[Double], yTable: Array[Double], yStride: Array[Int], result: Array[Double] = ???): Array[Double] = js.native
  }

  // todo
  @ScalaJSDefined
  sealed trait Frustum extends js.Object

  @js.native
  sealed trait Packable extends js.Object

  @js.native
  trait PackableStatic extends Packable {
    var packedLength: Int = js.native

    def pack(value: js.Object, array: js.Array[Double], startingIndex: Int = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Int = ???, result: js.Object = ???): js.Object = js.native
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
    val BASELINE: Int = js.native

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

  /**
    * Object for setting and retrieving the default BingMaps API key
    */
  @js.native
  @JSName("Cesium.BingMapsApi")
  object BingMapsApi extends js.Object {
    var defaultKey: String = js.native

    def getKey(): String = js.native
  }

  @js.native
  sealed trait WindingOrder extends js.Object

  @JSName("Cesium.WindingOrder")
  @js.native
  object WindingOrder extends js.Object {
    val CLOCKWISE: Int = js.native
    val COUNTER_CLOCKWISE: Int = js.native

    @JSBracketAccess
    def apply(value: WindingOrder): Int = js.native
  }


  // -------------------------------------------------------------------------------------
  // -------------------------------------------------------------------------------------
  // -------------------------------------------------------------------------------------

@js.native
@JSName("Cesium.HeadingPitchRoll")
class HeadingPitchRoll protected() extends js.Object {
  def this(heading: Double = 0, pitch: Double = 0, roll: Double = 0) = this()

  def fromQuaternion(quaternion: Quaternion, result: Quaternion) : HeadingPitchRoll = js.native
  def fromDegrees(heading: Double, pitch: Double, roll: Double, result: Quaternion) : Quaternion = js.native
  def clone(headingPitchRoll: HeadingPitchRoll, result: HeadingPitchRoll) : HeadingPitchRoll = js.native
  def clone(result: HeadingPitchRoll) : HeadingPitchRoll = js.native
  def equals(left: HeadingPitchRoll, right: HeadingPitchRoll): Boolean = js.native
  def equals(right: HeadingPitchRoll): Boolean = js.native
  def equalsEpsilon(left: HeadingPitchRoll, right: HeadingPitchRoll, relativeEpsilon: Double, absoluteEpsilon: Double): Boolean = js.native
  def equalsEpsilon(right: HeadingPitchRoll, relativeEpsilon: Double, absoluteEpsilon: Double): Boolean = js.native

}


  /**
    * Defines how screen space objects (billboards, points, labels) are clustered.
    */
  @js.native
  @JSName("Cesium.EntityCluster")
  class EntityCluster protected() extends js.Object {
    def this(options: EntityClusterOptions) = this()

    var clusterEvent: Event = js.native
    var enabled : Boolean = js.native
    var minimumClusterSize : Int = js.native
    var pixelRange : Int = js.native

    def destroy() : Unit = js.native
  }

  @js.native
  @JSName("Cesium.EntityCluster")
  object EntityCluster extends js.Object {
    /** A event listener function used to style clusters. */
    type newClusterCallback = js.Function1[js.Array[Entity], js.Object]
  }

  /**
    * Draws the outline of the camera's view frustum.
    */
  @js.native
  @JSName("Cesium.DebugCameraPrimitive")
  class DebugCameraPrimitive protected() extends js.Object {
    def this(options: DebugCameraPrimitiveOptions) = this()

    var id : Object = js.native
    var show : Boolean = js.native

    def destroy() : Unit = js.native
    def isDestroy() : Boolean = js.native
  }

  @js.native
  trait Proxy extends js.Object {
    def getURL(resource: String): String = js.native
  }

  /**
    * A [[TerrainProvider]] that produces terrain geometry by tessellating height maps
    * retrieved from an ArcGIS ImageServer.
    *
    * alias ArcGisImageServerTerrainProvider
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {String} options.url The URL of the ArcGIS ImageServer service.
    * - {String} [options.token] The authorization token to use to connect to the service.
    * - {Object} [options.proxy] A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL, if needed.
    * - {TilingScheme} [options.tilingScheme] The tiling scheme specifying how the terrain
    * is broken into tiles.  If this parameter is not provided, a [[GeographicTilingScheme]]
    * is used.
    * - {Ellipsoid} [options.ellipsoid] The ellipsoid.  If the tilingScheme is specified,
    * this parameter is ignored and the tiling scheme's ellipsoid is used instead.
    * If neither parameter is specified, the WGS84 ellipsoid is used.
    * - {Credit|String} [options.credit] The credit, which will is displayed on the canvas.
    *
    * @example
    * var terrainProvider = new Cesium.ArcGisImageServerTerrainProvider({
    * url : 'https://elevation.arcgisonline.com/ArcGIS/rest/services/WorldElevation/DTMEllipsoidal/ImageServer',
    * token : 'KED1aF_I4UzXOHy3BnhwyBHU4l5oY6rO6walkmHoYqGp4XyIWUd5YZUC1ZrLAzvV40pR6gBXQayh0eFA8m6vPg..',
    * proxy : new Cesium.DefaultProxy('/terrain/')
    * });
    * viewer.terrainProvider = terrainProvider;
    * @see TerrainProvider
    */
  @js.native
  @JSName("Cesium.ArcGisImageServerTerrainProvider")
  class ArcGisImageServerTerrainProvider protected() extends TerrainProvider {
    def this(options: ArcGisImageServerTerrainProviderOptions) = this()
  }

  /**
    * A collection of key-value pairs that is stored as a hash for easy
    * lookup but also provides an array for fast iteration.
    * alias AssociativeArray
    *
    */
  @js.native
  @JSName("Cesium.AssociativeArray")
  class AssociativeArray() extends js.Object {
    var length: Double = js.native
    var values: js.Array[js.Any] = js.native

    def contains(key: String | Double): Boolean = js.native

    def set(key: String | Double, value: js.Any): js.Dynamic = js.native

    def get(key: String | Double): js.Dynamic = js.native

    def remove(key: String | Double): Boolean = js.native

    def removeAll(): js.Dynamic = js.native
  }

  /**
    * Creates an instance of an AxisAlignedBoundingBox from the minimum and maximum points along the x, y, and z axes.
    * alias AxisAlignedBoundingBox
    *
    *
    * - {Cartesian3} [minimum=Cartesian3.ZERO] The minimum point along the x, y, and z axes.
    * - {Cartesian3} [maximum=Cartesian3.ZERO] The maximum point along the x, y, and z axes.
    * - {Cartesian3} [center] The center of the box; automatically computed if not supplied.
    *
    * @see BoundingSphere
    * @see BoundingRectangle
    */
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

  /**
    * A bounding rectangle given by a corner, width and height.
    * alias BoundingRectangle
    *
    *
    * - {Number} [x=0.0] The x coordinate of the rectangle.
    * - {Number} [y=0.0] The y coordinate of the rectangle.
    * - {Number} [width=0.0] The width of the rectangle.
    * - {Number} [height=0.0] The height of the rectangle.
    *
    * @see BoundingSphere
    */
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

  /**
    * A bounding sphere with a center and a radius.
    * alias BoundingSphere
    *
    *
    * - {Cartesian3} [center=Cartesian3.ZERO] The center of the bounding sphere.
    * - {Number} [radius=0.0] The radius of the bounding sphere.
    *
    * @see AxisAlignedBoundingBox
    * @see BoundingRectangle
    * @see Packable
    */
  @js.native
  @JSName("Cesium.BoundingSphere")
  class BoundingSphere protected() extends Packable {
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
  object BoundingSphere extends PackableStatic {

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

  /**
    * Describes a cube centered at the origin.
    *
    * alias BoxGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3} options.minimum The minimum x, y, and z coordinates of the box.
    * - {Cartesian3} options.maximum The maximum x, y, and z coordinates of the box.
    * - {VertexFormat} [options.vertexFormat=VertexFormat.DEFAULT] The vertex attributes to be computed.
    *
    * @see BoxGeometry.fromDimensions
    * @see BoxGeometry.createGeometry
    * @see Packable
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Box.html|Cesium Sandcastle Box Demo]]
    * @example
    * var box = new Cesium.BoxGeometry({
    * vertexFormat : Cesium.VertexFormat.POSITION_ONLY,
    * maximum : new Cesium.Cartesian3(250000.0, 250000.0, 250000.0),
    * minimum : new Cesium.Cartesian3(-250000.0, -250000.0, -250000.0)
    * });
    * var geometry = Cesium.BoxGeometry.createGeometry(box);
    */
  @js.native
  @JSName("Cesium.BoxGeometry")
  class BoxGeometry protected() extends Packable {
    def this(options: BoxGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.BoxGeometry")
  object BoxGeometry extends PackableStatic {

    def fromDimensions(options: DimensionsOptions): BoxGeometry = js.native

    def fromAxisAlignedBoundingBox(boundingBox: AxisAlignedBoundingBox): BoxGeometry = js.native

    def createGeometry(boxGeometry: BoxGeometry): Geometry | Unit = js.native
  }

  /**
    * A description of the outline of a cube centered at the origin.
    *
    * alias BoxOutlineGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3} options.minimum The minimum x, y, and z coordinates of the box.
    * - {Cartesian3} options.maximum The maximum x, y, and z coordinates of the box.
    *
    * @see BoxOutlineGeometry.fromDimensions
    * @see BoxOutlineGeometry.createGeometry
    * @see Packable
    * @example
    * var box = new Cesium.BoxOutlineGeometry({
    * maximum : new Cesium.Cartesian3(250000.0, 250000.0, 250000.0),
    * minimum : new Cesium.Cartesian3(-250000.0, -250000.0, -250000.0)
    * });
    * var geometry = Cesium.BoxOutlineGeometry.createGeometry(box);
    */
  @js.native
  @JSName("Cesium.BoxOutlineGeometry")
  class BoxOutlineGeometry protected() extends Packable {
    def this(options: BoxOutlineGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.BoxOutlineGeometry")
  object BoxOutlineGeometry extends PackableStatic {

    def fromDimensions(dimensions: Option[Cartesian3]): BoxOutlineGeometry = js.native

    def fromAxisAlignedBoundingBox(boundingBox: AxisAlignedBoundingBox): BoxOutlineGeometry = js.native

    def createGeometry(boxGeometry: BoxOutlineGeometry): Geometry | Unit = js.native
  }

  /**
    * A 2D Cartesian point.
    * alias Cartesian2
    *
    *
    * - {Number} [x=0.0] The X component.
    * - {Number} [y=0.0] The Y component.
    *
    * @see Cartesian3
    * @see Cartesian4
    * @see Packable
    */
  @js.native
  @JSName("Cesium.Cartesian2")
  class Cartesian2 protected() extends Packable {
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
  object Cartesian2 extends PackableStatic {

    var ZERO: Cartesian2 = js.native
    var UNIT_X: Cartesian2 = js.native
    var UNIT_Y: Cartesian2 = js.native

    def packArray(array: js.Array[Cartesian2], result: js.Array[Number] = ???): js.Array[Number] = js.native

    def unpackArray(array: js.Array[Number], result: js.Array[Cartesian2] = ???): js.Array[Cartesian2] = js.native

    def fromElements(x: Double, y: Double, result: Cartesian2 = ???): Cartesian2 = js.native

    def clone(cartesian: Cartesian2, result: Cartesian2 = ???): Cartesian2 = js.native

    def fromCartesian3(cartesian: Cartesian3, result: Cartesian2 = ???): Cartesian2 = js.native

    def fromCartesian4(cartesian: Cartesian4, result: Cartesian2 = ???): Cartesian2 = js.native

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

    def divideComponents(left:Cartesian2, right:Cartesian2, result:Cartesian2 = ???): Cartesian2 = js.native

  }

  /**
    * A 3D Cartesian point.
    * alias Cartesian3
    *
    *
    * - {Number} [x=0.0] The X component.
    * - {Number} [y=0.0] The Y component.
    * - {Number} [z=0.0] The Z component.
    *
    * @see Cartesian2
    * @see Cartesian4
    * @see Packable
    */
  @js.native
  @JSName("Cesium.Cartesian3")
  class Cartesian3 protected() extends Packable {
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
  object Cartesian3 extends PackableStatic {

    var ZERO: Cartesian3 = js.native
    var UNIT_X: Cartesian3 = js.native
    var UNIT_Y: Cartesian3 = js.native
    var UNIT_Z: Cartesian3 = js.native

    def packArray(array: js.Array[Cartesian3], result: js.Array[Number] = ???): js.Array[Number] = js.native

    def unpackArray(array: js.Array[Number], result: js.Array[Cartesian3] = ???): js.Array[Cartesian3] = js.native

    def fromSpherical(spherical: Spherical, result: Cartesian3 = ???): Cartesian3 = js.native

    def fromElements(x: Double, y: Double, z: Double, result: Cartesian3 = ???): Cartesian3 = js.native

    def clone(cartesian: Cartesian3, result: Cartesian3 = ???): Cartesian3 = js.native

    def fromCartesian4(cartesian: Cartesian4, result: Cartesian3 = ???): Cartesian3 = js.native

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

    def divideComponents(left:Cartesian3, right:Cartesian3, result:Cartesian3 = ???): Cartesian3 = js.native

  }

  /**
    * A 4D Cartesian point.
    * alias Cartesian4
    *
    *
    * - {Number} [x=0.0] The X component.
    * - {Number} [y=0.0] The Y component.
    * - {Number} [z=0.0] The Z component.
    * - {Number} [w=0.0] The W component.
    *
    * @see Cartesian2
    * @see Cartesian3
    * @see Packable
    */
  @js.native
  @JSName("Cesium.Cartesian4")
  class Cartesian4 protected() extends Packable {
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
  object Cartesian4 extends PackableStatic {

    var ZERO: Cartesian4 = js.native
    var UNIT_X: Cartesian4 = js.native
    var UNIT_Y: Cartesian4 = js.native
    var UNIT_Z: Cartesian4 = js.native
    var UNIT_W: Cartesian4 = js.native

    def packArray(array: js.Array[Cartesian4], result: js.Array[Number] = ???): js.Array[Number] = js.native

    def unpackArray(array: js.Array[Number], result: js.Array[Cartesian4] = ???): js.Array[Cartesian4] = js.native

    def fromElements(x: Double, y: Double, z: Double, w: Double, result: Cartesian4 = ???): Cartesian4 = js.native

    def fromColor(color: Color, result: Cartesian4 = ???): Cartesian4 = js.native

    def clone(cartesian: Cartesian4, result: Cartesian4 = ???): Cartesian4 = js.native

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

    def divideComponents(left:Cartesian4, right:Cartesian4, result:Cartesian4 = ???): Cartesian4 = js.native

  }

  /**
    * A position defined by longitude, latitude, and height.
    * alias Cartographic
    *
    *
    * - {Number} [longitude=0.0] The longitude, in radians.
    * - {Number} [latitude=0.0] The latitude, in radians.
    * - {Number} [height=0.0] The height, in meters, above the ellipsoid.
    *
    * @see Ellipsoid
    */
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

  /**
    * A Catmull-Rom spline is a cubic spline where the tangent at control points,
    * except the first and last, are computed using the previous and next control points.
    * Catmull-Rom splines are in the class C<sup>1</sup>.
    *
    * alias CatmullRomSpline
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Number[]} options.times An array of strictly increasing, unit-less, floating-point times at each point.
    * The values are in no way connected to the clock time. They are the parameterization for the curve.
    * - {Cartesian3[]} options.points The array of [[Cartesian3]] control points.
    * - {Cartesian3} [options.firstTangent] The tangent of the curve at the first control point.
    * If the tangent is not given, it will be estimated.
    * - {Cartesian3} [options.lastTangent] The tangent of the curve at the last control point.
    * If the tangent is not given, it will be estimated.
    *
    * exception {DeveloperError} points.length must be greater than or equal to 2.
    * exception {DeveloperError} times.length must be equal to points.length.
    *
    * @example
    * // spline above the earth from Philadelphia to Los Angeles
    * var spline = new Cesium.CatmullRomSpline({
    * times : [ 0.0, 1.5, 3.0, 4.5, 6.0 ],
    * points : [
    * new Cesium.Cartesian3(1235398.0, -4810983.0, 4146266.0),
    * new Cesium.Cartesian3(1372574.0, -5345182.0, 4606657.0),
    * new Cesium.Cartesian3(-757983.0, -5542796.0, 4514323.0),
    * new Cesium.Cartesian3(-2821260.0, -5248423.0, 4021290.0),
    * new Cesium.Cartesian3(-2539788.0, -4724797.0, 3620093.0)
    * ]
    * });
    *
    * var p0 = spline.evaluate(times[i]);         // equal to positions[i]
    * var p1 = spline.evaluate(times[i] + delta); // interpolated value when delta < times[i + 1] - times[i]
    * @see HermiteSpline
    * @see LinearSpline
    * @see QuaternionSpline
    */
  @js.native
  @JSName("Cesium.CatmullRomSpline")
  class CatmullRomSpline protected() extends Spline {
    def this(options: CatmullRomSplineOptions) = this()

    var firstTangent: Cartesian3 = js.native
    var lastTangent: Cartesian3 = js.native
  }

  /**
    * A [[TerrainProvider]] that access terrain data in a Cesium terrain format.
    * The format is described on the
    * [[https://github.com/AnalyticalGraphicsInc/cesium/wiki/Cesium-Terrain-Server|Cesium wiki]].
    *
    * alias CesiumTerrainProvider
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {String} options.url The URL of the Cesium terrain server.
    * - {Proxy} [options.proxy] A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL, if needed.
    * - {Boolean} [options.requestVertexNormals=false] Flag that indicates if the client should request additional lighting information from the server, in the form of per vertex normals if available.
    * - {Boolean} [options.requestWaterMask=false] Flag that indicates if the client should request per tile water masks from the server,  if available.
    * - {Ellipsoid} [options.ellipsoid] The ellipsoid.  If not specified, the WGS84 ellipsoid is used.
    * - {Credit|String} [options.credit] A credit for the data source, which is displayed on the canvas.
    *
    * @example
    * // Construct a terrain provider that uses per vertex normals for lighting
    * // to add shading detail to an imagery provider.
    * var terrainProvider = new Cesium.CesiumTerrainProvider({
    * url : 'https://assets.agi.com/stk-terrain/world',
    * requestVertexNormals : true
    * });
    *
    * // Terrain geometry near the surface of the globe is difficult to view when using NaturalEarthII imagery,
    * // unless the TerrainProvider provides additional lighting information to shade the terrain (as shown above).
    * var imageryProvider = Cesium.createTileMapServiceImageryProvider({
    * url : 'http://localhost:8080/Source/Assets/Textures/NaturalEarthII',
    * fileExtension : 'jpg'
    * });
    *
    * var viewer = new Cesium.Viewer('cesiumContainer', {
    * imageryProvider : imageryProvider,
    * baseLayerPicker : false,
    * terrainProvider : terrainProvider
    * });
    *
    * // The globe must enable lighting to make use of the terrain's vertex normals
    * viewer.scene.globe.enableLighting = true;
    * @see TerrainProvider
    */
  @js.native
  @JSName("Cesium.CesiumTerrainProvider")
  class CesiumTerrainProvider protected() extends TerrainProvider {
    def this(options: CesiumTerrainProviderOptions) = this()

    var requestVertexNormals: Boolean = js.native
    var requestWaterMask: Boolean = js.native
  }

  /**
    * A description of a circle on the ellipsoid. Circle geometry can be rendered with both [[Primitive]] and [[GroundPrimitive]].
    *
    * alias CircleGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3} options.center The circle's center point in the fixed frame.
    * - {Number} options.radius The radius in meters.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid the circle will be on.
    * - {Number} [options.height=0.0] The distance in meters between the circle and the ellipsoid surface.
    * - {Number} [options.granularity=0.02] The angular distance between points on the circle in radians.
    * - {VertexFormat} [options.vertexFormat=VertexFormat.DEFAULT] The vertex attributes to be computed.
    * - {Number} [options.extrudedHeight=0.0] The distance in meters between the circle's extruded face and the ellipsoid surface.
    * - {Number} [options.stRotation=0.0] The rotation of the texture coordinates, in radians. A positive rotation is counter-clockwise.
    *
    * exception {DeveloperError} radius must be greater than zero.
    * exception {DeveloperError} granularity must be greater than zero.
    *
    * @see CircleGeometry.createGeometry
    * @see Packable
    * @example
    * // Create a circle.
    * var circle = new Cesium.CircleGeometry({
    * center : Cesium.Cartesian3.fromDegrees(-75.59777, 40.03883),
    * radius : 100000.0
    * });
    * var geometry = Cesium.CircleGeometry.createGeometry(circle);
    */
  @js.native
  @JSName("Cesium.CircleGeometry")
  class CircleGeometry protected() extends Packable {
    def this(options: CircleGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.CircleGeometry")
  object CircleGeometry extends PackableStatic {
    def createGeometry(circleGeometry: CircleGeometry): Geometry | Unit = js.native
  }

  /**
    * A description of the outline of a circle on the ellipsoid.
    *
    * alias CircleOutlineGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3} options.center The circle's center point in the fixed frame.
    * - {Number} options.radius The radius in meters.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid the circle will be on.
    * - {Number} [options.height=0.0] The distance in meters between the circle and the ellipsoid surface.
    * - {Number} [options.granularity=0.02] The angular distance between points on the circle in radians.
    * - {Number} [options.extrudedHeight=0.0] The distance in meters between the circle's extruded face and the ellipsoid surface.
    * - {Number} [options.numberOfVerticalLines=16] Number of lines to draw between the top and bottom of an extruded circle.
    *
    * exception {DeveloperError} radius must be greater than zero.
    * exception {DeveloperError} granularity must be greater than zero.
    *
    * @see CircleOutlineGeometry.createGeometry
    * @see Packable
    * @example
    * // Create a circle.
    * var circle = new Cesium.CircleOutlineGeometry({
    * center : Cesium.Cartesian3.fromDegrees(-75.59777, 40.03883),
    * radius : 100000.0
    * });
    * var geometry = Cesium.CircleOutlineGeometry.createGeometry(circle);
    */
  @js.native
  @JSName("Cesium.CircleOutlineGeometry")
  class CircleOutlineGeometry protected() extends Packable {
    def this(options: CircleOutlineGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.CircleOutlineGeometry")
  object CircleOutlineGeometry extends PackableStatic {
    def createGeometry(circleGeometry: CircleOutlineGeometry): Geometry | Unit = js.native
  }

  /**
    * A simple clock for keeping track of simulated time.
    *
    * alias Clock
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {JulianDate} [options.startTime] The start time of the clock.
    * - {JulianDate} [options.stopTime] The stop time of the clock.
    * - {JulianDate} [options.currentTime] The current time.
    * - {Number} [options.multiplier=1.0] Determines how much time advances when tick is called, negative values allow for advancing backwards.
    * - {ClockStep} [options.clockStep=ClockStep.SYSTEM_CLOCK_MULTIPLIER] Determines if calls to <code>tick</code> are frame dependent or system clock dependent.
    * - {ClockRange} [options.clockRange=ClockRange.UNBOUNDED] Determines how the clock should behave when <code>startTime</code> or <code>stopTime</code> is reached.
    * - {Boolean} [options.canAnimate=true] Indicates whether tick can advance time.  This could be false if data is being buffered, for example.  The clock will only tick when both <code>canAnimate</code> and <code>shouldAnimate</code> are true.
    * - {Boolean} [options.shouldAnimate=true] Indicates whether tick should attempt to advance time.  The clock will only tick when both <code>canAnimate</code> and <code>shouldAnimate</code> are true.
    *
    * exception {DeveloperError} startTime must come before stopTime.
    *
    * @example
    * // Create a clock that loops on Christmas day 2013 and runs in real-time.
    * var clock = new Cesium.Clock({
    * startTime : Cesium.JulianDate.fromIso8601("2013-12-25"),
    * currentTime : Cesium.JulianDate.fromIso8601("2013-12-25"),
    * stopTime : Cesium.JulianDate.fromIso8601("2013-12-26"),
    * clockRange : Cesium.ClockRange.LOOP_STOP,
    * clockStep : Cesium.ClockStep.SYSTEM_CLOCK_MULTIPLIER
    * });
    * @see ClockStep
    * @see ClockRange
    * @see JulianDate
    */
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

  /**
    * A color, specified using red, green, blue, and alpha values,
    * which range from <code>0</code> (no intensity) to <code>1.0</code> (full intensity).
    * - {Number} [red=1.0] The red component.
    * - {Number} [green=1.0] The green component.
    * - {Number} [blue=1.0] The blue component.
    * - {Number} [alpha=1.0] The alpha component.
    *
    *
    * alias Color
    *
    * @see Packable
    */
  @js.native
  @JSName("Cesium.Color")
  class Color protected() extends Packable {
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

  @js.native
  @JSName("Cesium.Color")
  object Color extends PackableStatic {

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

    def divideByScalar(color: Color, scalar: Double, result: Color = ???): Color = js.native
  }

  /**
    * Value and type information for per-instance geometry color.
    *
    * alias ColorGeometryInstanceAttribute
    *
    *
    * - {Number} [red=1.0] The red component.
    * - {Number} [green=1.0] The green component.
    * - {Number} [blue=1.0] The blue component.
    * - {Number} [alpha=1.0] The alpha component.
    *
    * @example
    * var instance = new Cesium.GeometryInstance({
    * geometry : Cesium.BoxGeometry.fromDimensions({
    * dimensions : new Cesium.Cartesian3(1000000.0, 1000000.0, 500000.0)
    * }),
    * modelMatrix : Cesium.Matrix4.multiplyByTranslation(Cesium.Transforms.eastNorthUpToFixedFrame(
    * Cesium.Cartesian3.fromDegrees(0.0, 0.0)), new Cesium.Cartesian3(0.0, 0.0, 1000000.0), new Cesium.Matrix4()),
    * id : 'box',
    * attributes : {
    * color : new Cesium.ColorGeometryInstanceAttribute(red, green, blue, alpha)
    * }
    * });
    * @see GeometryInstance
    * @see GeometryInstanceAttribute
    */
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

  /**
    * A description of a corridor. Corridor geometry can be rendered with both [[Primitive]] and [[GroundPrimitive]].
    *
    * alias CorridorGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3[]} options.positions An array of positions that define the center of the corridor.
    * - {Number} options.width The distance between the edges of the corridor in meters.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid to be used as a reference.
    * - {Number} [options.granularity=CesiumMath.RADIANS_PER_DEGREE] The distance, in radians, between each latitude and longitude. Determines the number of positions in the buffer.
    * - {Number} [options.height=0] The distance in meters between the ellipsoid surface and the positions.
    * - {Number} [options.extrudedHeight] The distance in meters between the ellipsoid surface and the extruded face.
    * - {VertexFormat} [options.vertexFormat=VertexFormat.DEFAULT] The vertex attributes to be computed.
    * - {CornerType} [options.cornerType=CornerType.ROUNDED] Determines the style of the corners.
    *
    * @see CorridorGeometry.createGeometry
    * @see Packable
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Corridor.html|Cesium Sandcastle Corridor Demo]]
    * @example
    * var corridor = new Cesium.CorridorGeometry({
    * vertexFormat : Cesium.VertexFormat.POSITION_ONLY,
    * positions : Cesium.Cartesian3.fromDegreesArray([-72.0, 40.0, -70.0, 35.0]),
    * width : 100000
    * });
    */
  @js.native
  @JSName("Cesium.CorridorGeometry")
  class CorridorGeometry protected() extends Packable {
    def this(options: CorridorGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.CorridorGeometry")
  object CorridorGeometry extends PackableStatic {
    def createGeometry(corridorGeometry: CorridorGeometry): Geometry | Unit = js.native
  }

  /**
    * A description of a corridor outline.
    *
    * alias CorridorOutlineGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3[]} options.positions An array of positions that define the center of the corridor outline.
    * - {Number} options.width The distance between the edges of the corridor outline.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid to be used as a reference.
    * - {Number} [options.granularity=CesiumMath.RADIANS_PER_DEGREE] The distance, in radians, between each latitude and longitude. Determines the number of positions in the buffer.
    * - {Number} [options.height=0] The distance in meters between the positions and the ellipsoid surface.
    * - {Number} [options.extrudedHeight] The distance in meters between the extruded face and the ellipsoid surface.
    * - {CornerType} [options.cornerType=CornerType.ROUNDED] Determines the style of the corners.
    *
    * @see CorridorOutlineGeometry.createGeometry
    * @example
    * var corridor = new Cesium.CorridorOutlineGeometry({
    * positions : Cesium.Cartesian3.fromDegreesArray([-72.0, 40.0, -70.0, 35.0]),
    * width : 100000
    * });
    */
  @js.native
  @JSName("Cesium.CorridorOutlineGeometry")
  class CorridorOutlineGeometry protected() extends js.Object {
    def this(options: CorridorOutlineGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.CorridorOutlineGeometry")
  object CorridorOutlineGeometry extends js.Object {
    def pack(value: CorridorOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: CorridorOutlineGeometry = ???): CorridorOutlineGeometry = js.native

    def createGeometry(corridorOutlineGeometry: CorridorOutlineGeometry): Geometry | Unit = js.native
  }

  /**
    * A credit contains data pertaining to how to display attributions/credits for certain content on the screen.
    *
    * - {String} [text] The text to be displayed on the screen if no imageUrl is specified.
    * - {String} [imageUrl] The source location for an image
    * - {String} [link] A URL location for which the credit will be hyperlinked
    *
    * alias Credit
    *
    * @example
    * //Create a credit with a tooltip, image and link
    * var credit = new Cesium.Credit('Cesium', '/images/cesium_logo.png', 'http://cesiumjs.org/');
    */
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

  /**
    * A description of a cylinder.
    *
    * alias CylinderGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Number} options.length The length of the cylinder.
    * - {Number} options.topRadius The radius of the top of the cylinder.
    * - {Number} options.bottomRadius The radius of the bottom of the cylinder.
    * - {Number} [options.slices=128] The number of edges around perimeter of the cylinder.
    * - {VertexFormat} [options.vertexFormat=VertexFormat.DEFAULT] The vertex attributes to be computed.
    *
    * exception {DeveloperError} options.length must be greater than 0.
    * exception {DeveloperError} options.topRadius must be greater than 0.
    * exception {DeveloperError} options.bottomRadius must be greater than 0.
    * exception {DeveloperError} bottomRadius and topRadius cannot both equal 0.
    * exception {DeveloperError} options.slices must be greater that 3.
    *
    * @see CylinderGeometry.createGeometry
    * @example
    * // create cylinder geometry
    * var cylinder = new Cesium.CylinderGeometry({
    * length: 200000,
    * topRadius: 80000,
    * bottomRadius: 200000,
    * });
    * var geometry = Cesium.CylinderGeometry.createGeometry(cylinder);
    */
  @js.native
  @JSName("Cesium.CylinderGeometry")
  class CylinderGeometry protected() extends js.Object {
    def this(options: CylinderGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.CylinderGeometry")
  object CylinderGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: CylinderGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: CylinderGeometry = ???): CylinderGeometry = js.native

    def createGeometry(cylinderGeometry: CylinderGeometry): Geometry | Unit = js.native
  }

  /**
    * A description of the outline of a cylinder.
    *
    * alias CylinderOutlineGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Number} options.length The length of the cylinder.
    * - {Number} options.topRadius The radius of the top of the cylinder.
    * - {Number} options.bottomRadius The radius of the bottom of the cylinder.
    * - {Number} [options.slices=128] The number of edges around perimeter of the cylinder.
    * - {Number} [options.numberOfVerticalLines=16] Number of lines to draw between the top and bottom surfaces of the cylinder.
    *
    * exception {DeveloperError} options.length must be greater than 0.
    * exception {DeveloperError} options.topRadius must be greater than 0.
    * exception {DeveloperError} options.bottomRadius must be greater than 0.
    * exception {DeveloperError} bottomRadius and topRadius cannot both equal 0.
    * exception {DeveloperError} options.slices must be greater that 3.
    *
    * @see CylinderOutlineGeometry.createGeometry
    * @example
    * // create cylinder geometry
    * var cylinder = new Cesium.CylinderOutlineGeometry({
    * length: 200000,
    * topRadius: 80000,
    * bottomRadius: 200000,
    * });
    * var geometry = Cesium.CylinderOutlineGeometry.createGeometry(cylinder);
    */
  @js.native
  @JSName("Cesium.CylinderOutlineGeometry")
  class CylinderOutlineGeometry protected() extends js.Object {
    def this(options: CylinderOutlineGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.CylinderOutlineGeometry")
  object CylinderOutlineGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: CylinderOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: CylinderOutlineGeometry = ???): CylinderOutlineGeometry = js.native

    def createGeometry(cylinderGeometry: CylinderOutlineGeometry): Geometry | Unit = js.native
  }

  /**
    * A simple proxy that appends the desired resource as the sole query parameter
    * to the given proxy URL.
    *
    * alias DefaultProxy
    *
    *
    * - {String} proxy The proxy URL that will be used to requests all resources.
    */
  @js.native
  @JSName("Cesium.DefaultProxy")
  class DefaultProxy protected() extends js.Object {
    def this(proxy: String) = this()

    def getURL(resource: String): String = js.native
  }

  /**
    * Constructs an exception object that is thrown due to a developer error, e.g., invalid argument,
    * argument out of range, etc.  This exception should only be thrown during development;
    * it usually indicates a bug in the calling code.  This exception should never be
    * caught; instead the calling code should strive not to generate it.
    *
    * On the other hand, a [[RuntimeError]] indicates an exception that may
    * be thrown at runtime, e.g., out of memory, that the calling code should be prepared
    * to catch.
    *
    * alias DeveloperError
    *
    * extends Error
    *
    * - {String} [message] The error message for this exception.
    *
    * @see RuntimeError
    */
  @js.native
  @JSName("Cesium.DeveloperError")
  class DeveloperError protected() extends js.Object {
    def this(message: String = ???) = this()

    var name: String = js.native
    var message: String = js.native
    var stack: String = js.native
  }

  /**
    * A description of an ellipse on an ellipsoid. Ellipse geometry can be rendered with both [[Primitive]] and [[GroundPrimitive]].
    *
    * alias EllipseGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3} options.center The ellipse's center point in the fixed frame.
    * - {Number} options.semiMajorAxis The length of the ellipse's semi-major axis in meters.
    * - {Number} options.semiMinorAxis The length of the ellipse's semi-minor axis in meters.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid the ellipse will be on.
    * - {Number} [options.height=0.0] The distance in meters between the ellipse and the ellipsoid surface.
    * - {Number} [options.extrudedHeight] The distance in meters between the ellipse's extruded face and the ellipsoid surface.
    * - {Number} [options.rotation=0.0] The angle of rotation counter-clockwise from north.
    * - {Number} [options.stRotation=0.0] The rotation of the texture coordinates counter-clockwise from north.
    * - {Number} [options.granularity=CesiumMath.RADIANS_PER_DEGREE] The angular distance between points on the ellipse in radians.
    * - {VertexFormat} [options.vertexFormat=VertexFormat.DEFAULT] The vertex attributes to be computed.
    *
    * exception {DeveloperError} semiMajorAxis and semiMinorAxis must be greater than zero.
    * exception {DeveloperError} semiMajorAxis must be greater than or equal to the semiMinorAxis.
    * exception {DeveloperError} granularity must be greater than zero.
    *
    * @example
    * // Create an ellipse.
    * var ellipse = new Cesium.EllipseGeometry({
    * center : Cesium.Cartesian3.fromDegrees(-75.59777, 40.03883),
    * semiMajorAxis : 500000.0,
    * semiMinorAxis : 300000.0,
    * rotation : Cesium.Math.toRadians(60.0)
    * });
    * var geometry = Cesium.EllipseGeometry.createGeometry(ellipse);
    * @see EllipseGeometry.createGeometry
    */
  @js.native
  @JSName("Cesium.EllipseGeometry")
  class EllipseGeometry protected() extends js.Object {
    def this(options: EllipseGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.EllipseGeometry")
  object EllipseGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: EllipseGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: EllipseGeometry = ???): EllipseGeometry = js.native

    def createGeometry(ellipseGeometry: EllipseGeometry): Geometry | Unit = js.native
  }

  /**
    * A description of the outline of an ellipse on an ellipsoid.
    *
    * alias EllipseOutlineGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3} options.center The ellipse's center point in the fixed frame.
    * - {Number} options.semiMajorAxis The length of the ellipse's semi-major axis in meters.
    * - {Number} options.semiMinorAxis The length of the ellipse's semi-minor axis in meters.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid the ellipse will be on.
    * - {Number} [options.height=0.0] The distance in meters between the ellipse and the ellipsoid surface.
    * - {Number} [options.extrudedHeight] The distance in meters between the ellipse's extruded face and the ellipsoid surface.
    * - {Number} [options.rotation=0.0] The angle from north (counter-clockwise) in radians.
    * - {Number} [options.granularity=0.02] The angular distance between points on the ellipse in radians.
    * - {Number} [options.numberOfVerticalLines=16] Number of lines to draw between the top and bottom surface of an extruded ellipse.
    *
    * exception {DeveloperError} semiMajorAxis and semiMinorAxis must be greater than zero.
    * exception {DeveloperError} semiMajorAxis must be greater than or equal to the semiMinorAxis.
    * exception {DeveloperError} granularity must be greater than zero.
    *
    * @see EllipseOutlineGeometry.createGeometry
    * @example
    * var ellipse = new Cesium.EllipseOutlineGeometry({
    * center : Cesium.Cartesian3.fromDegrees(-75.59777, 40.03883),
    * semiMajorAxis : 500000.0,
    * semiMinorAxis : 300000.0,
    * rotation : Cesium.Math.toRadians(60.0)
    * });
    * var geometry = Cesium.EllipseOutlineGeometry.createGeometry(ellipse);
    */
  @js.native
  @JSName("Cesium.EllipseOutlineGeometry")
  class EllipseOutlineGeometry protected() extends js.Object {
    def this(options: EllipseOutlineGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.EllipseOutlineGeometry")
  object EllipseOutlineGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: EllipseOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: EllipseOutlineGeometry = ???): EllipseOutlineGeometry = js.native

    def createGeometry(ellipseGeometry: EllipseOutlineGeometry): Geometry | Unit = js.native
  }

  /**
    * A quadratic surface defined in Cartesian coordinates by the equation
    * <code>(x / a)^2 + (y / b)^2 + (z / c) 2 = 1</code>.  Primarily used
    * by Cesium to represent the shape of planetary bodies.
    *
    * Rather than constructing this object directly, one of the provided
    * constants is normally used.
    * alias Ellipsoid
    *
    *
    * - {Number} [x=0] The radius in the x direction.
    * - {Number} [y=0] The radius in the y direction.
    * - {Number} [z=0] The radius in the z direction.
    *
    * exception {DeveloperError} All radii components must be greater than or equal to zero.
    *
    * @see Ellipsoid.fromCartesian3
    * @see Ellipsoid.WGS84
    * @see Ellipsoid.UNIT_SPHERE
    */
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

    def pack(value: Ellipsoid, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: Ellipsoid = ???): Ellipsoid = js.native
  }

  /**
    * Initializes a geodesic on the ellipsoid connecting the two provided planetodetic points.
    *
    * alias EllipsoidGeodesic
    *
    *
    * - {Cartographic} [start] The initial planetodetic point on the path.
    * - {Cartographic} [end] The final planetodetic point on the path.
    * - {Ellipsoid} [ellipsoid=Ellipsoid.WGS84] The ellipsoid on which the geodesic lies.
    */
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

  /**
    * A description of an ellipsoid centered at the origin.
    *
    * alias EllipsoidGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3} [options.radii=Cartesian3(1.0, 1.0, 1.0)] The radii of the ellipsoid in the x, y, and z directions.
    * - {Number} [options.stackPartitions=64] The number of times to partition the ellipsoid into stacks.
    * - {Number} [options.slicePartitions=64] The number of times to partition the ellipsoid into radial slices.
    * - {VertexFormat} [options.vertexFormat=VertexFormat.DEFAULT] The vertex attributes to be computed.
    *
    * exception {DeveloperError} options.slicePartitions cannot be less than three.
    * exception {DeveloperError} options.stackPartitions cannot be less than three.
    *
    * @see EllipsoidGeometry#createGeometry
    * @example
    * var ellipsoid = new Cesium.EllipsoidGeometry({
    * vertexFormat : Cesium.VertexFormat.POSITION_ONLY,
    * radii : new Cesium.Cartesian3(1000000.0, 500000.0, 500000.0)
    * });
    * var geometry = Cesium.EllipsoidGeometry.createGeometry(ellipsoid);
    */
  @js.native
  @JSName("Cesium.EllipsoidGeometry")
  class EllipsoidGeometry protected() extends js.Object {
    def this(options: EllipsoidGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.EllipsoidGeometry")
  object EllipsoidGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: EllipsoidGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: EllipsoidGeometry = ???): EllipsoidGeometry = js.native

    def createGeometry(ellipsoidGeometry: EllipsoidGeometry): Geometry | Unit = js.native
  }

  /**
    * A description of the outline of an ellipsoid centered at the origin.
    *
    * alias EllipsoidOutlineGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3} [options.radii=Cartesian3(1.0, 1.0, 1.0)] The radii of the ellipsoid in the x, y, and z directions.
    * - {Number} [options.stackPartitions=10] The count of stacks for the ellipsoid (1 greater than the number of parallel lines).
    * - {Number} [options.slicePartitions=8] The count of slices for the ellipsoid (Equal to the number of radial lines).
    * - {Number} [options.subdivisions=128] The number of points per line, determining the granularity of the curvature .
    *
    * exception {DeveloperError} options.stackPartitions must be greater than or equal to one.
    * exception {DeveloperError} options.slicePartitions must be greater than or equal to zero.
    * exception {DeveloperError} options.subdivisions must be greater than or equal to zero.
    *
    * @example
    * var ellipsoid = new Cesium.EllipsoidOutlineGeometry({
    * radii : new Cesium.Cartesian3(1000000.0, 500000.0, 500000.0),
    * stackPartitions: 6,
    * slicePartitions: 5
    * });
    * var geometry = Cesium.EllipsoidOutlineGeometry.createGeometry(ellipsoid);
    */
  @js.native
  @JSName("Cesium.EllipsoidOutlineGeometry")
  class EllipsoidOutlineGeometry protected() extends js.Object {
    def this(options: EllipsoidOutlineGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.EllipsoidOutlineGeometry")
  object EllipsoidOutlineGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: EllipsoidOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: EllipsoidOutlineGeometry = ???): EllipsoidOutlineGeometry = js.native

    def createGeometry(ellipsoidGeometry: EllipsoidOutlineGeometry): Geometry | Unit = js.native
  }

  /**
    * A plane tangent to the provided ellipsoid at the provided origin.
    * If origin is not on the surface of the ellipsoid, it's surface projection will be used.
    * If origin is at the center of the ellipsoid, an exception will be thrown.
    * alias EllipsoidTangentPlane
    *
    *
    * - {Cartesian3} origin The point on the surface of the ellipsoid where the tangent plane touches.
    * - {Ellipsoid} [ellipsoid=Ellipsoid.WGS84] The ellipsoid to use.
    *
    * exception {DeveloperError} origin must not be at the center of the ellipsoid.
    */
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

  /**
    * A very simple [[TerrainProvider]] that produces geometry by tessellating an ellipsoidal
    * surface.
    *
    * alias EllipsoidTerrainProvider
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {TilingScheme} [options.tilingScheme] The tiling scheme specifying how the ellipsoidal
    * surface is broken into tiles.  If this parameter is not provided, a [[GeographicTilingScheme]]
    * is used.
    * - {Ellipsoid} [options.ellipsoid] The ellipsoid.  If the tilingScheme is specified,
    * this parameter is ignored and the tiling scheme's ellipsoid is used instead. If neither
    * parameter is specified, the WGS84 ellipsoid is used.
    *
    * @see TerrainProvider
    */
  @js.native
  @JSName("Cesium.EllipsoidTerrainProvider")
  class EllipsoidTerrainProvider protected() extends TerrainProvider {
    def this(options: EllipsoidTerrainProviderOptions) = this()
  }

  @JSName("Cesium.Event")
  @js.native
  object Event extends js.Object {
    type RemoveCallback = js.Function0[Unit]
  }

  /**
    * A generic utility class for managing subscribers for a particular event.
    * This class is usually instantiated inside of a container class and
    * exposed as a property for others to subscribe to.
    *
    * alias Event
    *
    * @example
    * MyObject.prototype.myListener = function(arg1, arg2) {
    * this.myArg1Copy = arg1;
    * this.myArg2Copy = arg2;
    * }
    *
    * var myObjectInstance = new MyObject();
    * var evt = new Cesium.Event();
    * evt.addEventListener(MyObject.prototype.myListener, myObjectInstance);
    * evt.raiseEvent('1', '2');
    * evt.removeEventListener(MyObject.prototype.myListener);
    */
  @js.native
  @JSName("Cesium.Event")
  class Event() extends js.Object {
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

  /**
    * A convenience object that simplifies the common pattern of attaching event listeners
    * to several events, then removing all those listeners at once later, for example, in
    * a destroy method.
    *
    * alias EventHelper
    *
    * @example
    * var helper = new Cesium.EventHelper();
    *
    * helper.add(someObject.event, listener1, this);
    * helper.add(otherObject.event, listener2, this);
    *
    * // later...
    * helper.removeAll();
    * @see Event
    */
  @js.native
  @JSName("Cesium.EventHelper")
  class EventHelper() extends js.Object {
    def add(event: Event, listener: js.Function, scope: js.Any = ???): EventHelper.RemoveCallback = js.native

    def removeAll(): js.Dynamic = js.native
  }

  /**
    * A simple map projection where longitude and latitude are linearly mapped to X and Y by multiplying
    * them by the [[Ellipsoid#maximumRadius]].  This projection
    * is commonly known as geographic, equirectangular, equidistant cylindrical, or plate carrée.  It
    * is also known as EPSG:4326.
    *
    * alias GeographicProjection
    *
    *
    * - {Ellipsoid} [ellipsoid=Ellipsoid.WGS84] The ellipsoid.
    *
    * @see WebMercatorProjection
    */
  @js.native
  @JSName("Cesium.GeographicProjection")
  class GeographicProjection protected() extends js.Object {
    def this(ellipsoid: Ellipsoid = ???) = this()

    var ellipsoid: Ellipsoid = js.native

    def project(cartographic: Cartographic, result: Cartesian3 = ???): Cartesian3 = js.native

    def unproject(cartesian: Cartesian3, result: Cartographic = ???): Cartographic = js.native
  }

  /**
    * A tiling scheme for geometry referenced to a simple [[GeographicProjection]] where
    * longitude and latitude are directly mapped to X and Y.  This projection is commonly
    * known as geographic, equirectangular, equidistant cylindrical, or plate carrée.
    *
    * alias GeographicTilingScheme
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid whose surface is being tiled. Defaults to
    * the WGS84 ellipsoid.
    * - {Rectangle} [options.rectangle=Rectangle.MAX_VALUE] The rectangle, in radians, covered by the tiling scheme.
    * - {Number} [options.numberOfLevelZeroTilesX=2] The number of tiles in the X direction at level zero of
    * the tile tree.
    * - {Number} [options.numberOfLevelZeroTilesY=1] The number of tiles in the Y direction at level zero of
    * the tile tree.
    */
  @js.native
  @JSName("Cesium.GeographicTilingScheme")
  class GeographicTilingScheme protected() extends TilingScheme {
    def this(options: GeographicTilingSchemeOptions) = this()
  }

  /**
    * A geometry representation with attributes forming vertices and optional index data
    * defining primitives.  Geometries and an [[Appearance]], which describes the shading,
    * can be assigned to a [[Primitive]] for visualization.  A <code>Primitive</code> can
    * be created from many heterogeneous - in many cases - geometries for performance.
    * <p>
    * Geometries can be transformed and optimized using functions in [[GeometryPipeline]].
    * </p>
    *
    * alias Geometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {GeometryAttributes} options.attributes Attributes, which make up the geometry's vertices.
    * - {PrimitiveType} [options.primitiveType=PrimitiveType.TRIANGLES] The type of primitives in the geometry.
    * - {Uint16Array|Uint32Array} [options.indices] Optional index data that determines the primitives in the geometry.
    * - {BoundingSphere} [options.boundingSphere] An optional bounding sphere that fully enclosed the geometry.
    *
    * @see PolygonGeometry
    * @see RectangleGeometry
    * @see EllipseGeometry
    * @see CircleGeometry
    * @see WallGeometry
    * @see SimplePolylineGeometry
    * @see BoxGeometry
    * @see EllipsoidGeometry
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Geometry%20and%20Appearances.html|Geometry and Appearances Demo]]
    * @example
    * // Create geometry with a position attribute and indexed lines.
    * var positions = new Float64Array([
    * 0.0, 0.0, 0.0,
    * 7500000.0, 0.0, 0.0,
    * 0.0, 7500000.0, 0.0
    * ]);
    *
    * var geometry = new Cesium.Geometry({
    * attributes : {
    * position : new Cesium.GeometryAttribute({
    * componentDatatype : Cesium.ComponentDatatype.DOUBLE,
    * componentsPerAttribute : 3,
    * values : positions
    * })
    * },
    * indices : new Uint16Array([0, 1, 1, 2, 2, 0]),
    * primitiveType : Cesium.PrimitiveType.LINES,
    * boundingSphere : Cesium.BoundingSphere.fromVertices(positions)
    * });
    */
  @js.native
  @JSName("Cesium.Geometry")
  class Geometry protected() extends js.Object {
    def this(options: GeometryOptions) = this()

    var attributes: GeometryAttributes = js.native
    var indices: Uint16Array | Uint32Array = js.native
    var primitiveType: PrimitiveType = js.native
    var boundingSphere: BoundingSphere = js.native
  }

  @js.native
  @JSName("Cesium.Geometry")
  object Geometry extends js.Object {
    def computeNumberOfVertices(geometry: Geometry): Double = js.native
  }

  /**
    * Values and type information for geometry attributes.  A [[Geometry]]
    * generally contains one or more attributes.  All attributes together form
    * the geometry's vertices.
    *
    * alias GeometryAttribute
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {ComponentDatatype} [options.componentDatatype] The datatype of each component in the attribute, e.g., individual elements in values.
    * - {Number} [options.componentsPerAttribute] A number between 1 and 4 that defines the number of components in an attributes.
    * - {Boolean} [options.normalize=false] When <code>true</code> and <code>componentDatatype</code> is an integer format, indicate that the components should be mapped to the range [0, 1] (unsigned) or [-1, 1] (signed) when they are accessed as floating-point for rendering.
    * - {TypedArray} [options.values] The values for the attributes stored in a typed array.
    *
    * exception {DeveloperError} options.componentsPerAttribute must be between 1 and 4.
    *
    * @example
    * var geometry = new Cesium.Geometry({
    * attributes : {
    * position : new Cesium.GeometryAttribute({
    * componentDatatype : Cesium.ComponentDatatype.FLOAT,
    * componentsPerAttribute : 3,
    * values : new Float32Array([
    * 0.0, 0.0, 0.0,
    * 7500000.0, 0.0, 0.0,
    * 0.0, 7500000.0, 0.0
    * ])
    * })
    * },
    * primitiveType : Cesium.PrimitiveType.LINE_LOOP
    * });
    * @see Geometry
    */
  @js.native
  @JSName("Cesium.GeometryAttribute")
  class GeometryAttribute protected() extends js.Object {
    def this(options: GeometryAttributeOptions) = this()

    var componentDatatype: ComponentDatatype = js.native
    var componentsPerAttribute: Double = js.native
    var normalize: Boolean = js.native
    var values: Cesium.TypedArray = js.native
  }

  /**
    * Attributes, which make up a geometry's vertices.  Each property in this object corresponds to a
    * [[GeometryAttribute]] containing the attribute's data.
    * <p>
    * Attributes are always stored non-interleaved in a Geometry.
    * </p>
    *
    * alias GeometryAttributes
    *
    */
  @js.native
  @JSName("Cesium.GeometryAttributes")
  class GeometryAttributes() extends js.Object {
    var position: GeometryAttribute = js.native
    var normal: GeometryAttribute = js.native
    var st: GeometryAttribute = js.native
    var bitangent: GeometryAttribute = js.native
    var tangent: GeometryAttribute = js.native
    var color: GeometryAttribute = js.native
  }

  /**
    * Geometry instancing allows one [[Geometry]] object to be positions in several
    * different locations and colored uniquely.  For example, one [[BoxGeometry]] can
    * be instanced several times, each with a different <code>modelMatrix</code> to change
    * its position, rotation, and scale.
    *
    * alias GeometryInstance
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Geometry} options.geometry The geometry to instance.
    * - {Matrix4} [options.modelMatrix=Matrix4.IDENTITY] The model matrix that transforms to transform the geometry from model to world coordinates.
    * - {Object} [options.id] A user-defined object to return when the instance is picked with [[Scene#pick]] or get/set per-instance attributes with [[Primitive#getGeometryInstanceAttributes]]
    * - {Object} [options.attributes] Per-instance attributes like a show or color attribute shown in the example below.
    *
    * @example
    * // Create geometry for a box, and two instances that refer to it.
    * // One instance positions the box on the bottom and colored aqua.
    * // The other instance positions the box on the top and color white.
    * var geometry = Cesium.BoxGeometry.fromDimensions({
    * vertexFormat : Cesium.VertexFormat.POSITION_AND_NORMAL,
    * dimensions : new Cesium.Cartesian3(1000000.0, 1000000.0, 500000.0)
    * });
    * var instanceBottom = new Cesium.GeometryInstance({
    * geometry : geometry,
    * modelMatrix : Cesium.Matrix4.multiplyByTranslation(Cesium.Transforms.eastNorthUpToFixedFrame(
    * Cesium.Cartesian3.fromDegrees(-75.59777, 40.03883)), new Cesium.Cartesian3(0.0, 0.0, 1000000.0), new Cesium.Matrix4()),
    * attributes : {
    * color : Cesium.ColorGeometryInstanceAttribute.fromColor(Cesium.Color.AQUA)
    * },
    * id : 'bottom'
    * });
    * var instanceTop = new Cesium.GeometryInstance({
    * geometry : geometry,
    * modelMatrix : Cesium.Matrix4.multiplyByTranslation(Cesium.Transforms.eastNorthUpToFixedFrame(
    * Cesium.Cartesian3.fromDegrees(-75.59777, 40.03883)), new Cesium.Cartesian3(0.0, 0.0, 3000000.0), new Cesium.Matrix4()),
    * attributes : {
    * color : Cesium.ColorGeometryInstanceAttribute.fromColor(Cesium.Color.AQUA)
    * },
    * id : 'top'
    * });
    * @see Geometry
    */
  @js.native
  @JSName("Cesium.GeometryInstance")
  class GeometryInstance protected() extends js.Object {
    def this(options: GeometryInstanceOptions) = this()

    var geometry: Geometry = js.native
    var modelMatrix: Matrix4 = js.native
    var id: js.Any = js.native
    var attributes: js.Any = js.native
  }

  /**
    * Values and type information for per-instance geometry attributes.
    *
    * alias GeometryInstanceAttribute
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {ComponentDatatype} [options.componentDatatype] The datatype of each component in the attribute, e.g., individual elements in values.
    * - {Number} [options.componentsPerAttribute] A number between 1 and 4 that defines the number of components in an attributes.
    * - {Boolean} [options.normalize=false] When <code>true</code> and <code>componentDatatype</code> is an integer format, indicate that the components should be mapped to the range [0, 1] (unsigned) or [-1, 1] (signed) when they are accessed as floating-point for rendering.
    * - {Number[]} [options.value] The value for the attribute.
    *
    * exception {DeveloperError} options.componentsPerAttribute must be between 1 and 4.
    *
    * @example
    * var instance = new Cesium.GeometryInstance({
    * geometry : Cesium.BoxGeometry.fromDimensions({
    * dimensions : new Cesium.Cartesian3(1000000.0, 1000000.0, 500000.0)
    * }),
    * modelMatrix : Cesium.Matrix4.multiplyByTranslation(Cesium.Transforms.eastNorthUpToFixedFrame(
    * Cesium.Cartesian3.fromDegrees(0.0, 0.0)), new Cesium.Cartesian3(0.0, 0.0, 1000000.0), new Cesium.Matrix4()),
    * id : 'box',
    * attributes : {
    * color : new Cesium.GeometryInstanceAttribute({
    * componentDatatype : Cesium.ComponentDatatype.UNSIGNED_BYTE,
    * componentsPerAttribute : 4,
    * normalize : true,
    * value : [255, 255, 0, 255]
    * })
    * }
    * });
    * @see ColorGeometryInstanceAttribute
    * @see ShowGeometryInstanceAttribute
    */
  @js.native
  @JSName("Cesium.GeometryInstanceAttribute")
  class GeometryInstanceAttribute protected() extends js.Object {
    def this(options: GeometryInstanceAttributeOptions) = this()

    var componentDatatype: ComponentDatatype = js.native
    var componentsPerAttribute: Double = js.native
    var normalize: Boolean = js.native
    var value: js.Array[Double] = js.native
  }

  /**
    * Represents a Gregorian date in a more precise format than the JavaScript Date object.
    * In addition to submillisecond precision, this object can also represent leap seconds.
    * alias GregorianDate
    *
    * @see JulianDate#toGregorianDate
    */
  @js.native
  @JSName("Cesium.GregorianDate")
  class GregorianDate() extends js.Object {
    var year: Double = js.native
    var month: Double = js.native
    var day: Double = js.native
    var hour: Double = js.native
    var minute: Double = js.native
    var second: Double = js.native
    var millisecond: Double = js.native
    var isLeapSecond: Boolean = js.native
  }

  /**
    * Defines a heading angle, pitch angle, and range in a local frame.
    * Heading is the rotation from the local north direction where a positive angle is increasing eastward.
    * Pitch is the rotation from the local xy-plane. Positive pitch angles are above the plane. Negative pitch
    * angles are below the plane. Range is the distance from the center of the frame.
    * alias HeadingPitchRange
    *
    *
    * - {Number} [heading=0.0] The heading angle in radians.
    * - {Number} [pitch=0.0] The pitch angle in radians.
    * - {Number} [range=0.0] The distance from the center in meters.
    */
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

  /**
    * Terrain data for a single tile where the terrain data is represented as a heightmap.  A heightmap
    * is a rectangular array of heights in row-major order from south to north and west to east.
    *
    * alias HeightmapTerrainData
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {TypedArray} options.buffer The buffer containing height data.
    * - {Number} options.width The width (longitude direction) of the heightmap, in samples.
    * - {Number} options.height The height (latitude direction) of the heightmap, in samples.
    * - {Number} [options.childTileMask=15] A bit mask indicating which of this tile's four children exist.
    * If a child's bit is set, geometry will be requested for that tile as well when it
    * is needed.  If the bit is cleared, the child tile is not requested and geometry is
    * instead upsampled from the parent.  The bit values are as follows:
    * <table>
    * <tr><th>Bit Position</th><th>Bit Value</th><th>Child Tile</th></tr>
    * <tr><td>0</td><td>1</td><td>Southwest</td></tr>
    * <tr><td>1</td><td>2</td><td>Southeast</td></tr>
    * <tr><td>2</td><td>4</td><td>Northwest</td></tr>
    * <tr><td>3</td><td>8</td><td>Northeast</td></tr>
    * </table>
    * - {Object} [options.structure] An object describing the structure of the height data.
    * - {Number} [options.structure.heightScale=1.0] The factor by which to multiply height samples in order to obtain
    * the height above the heightOffset, in meters.  The heightOffset is added to the resulting
    * height after multiplying by the scale.
    * - {Number} [options.structure.heightOffset=0.0] The offset to add to the scaled height to obtain the final
    * height in meters.  The offset is added after the height sample is multiplied by the
    * heightScale.
    * - {Number} [options.structure.elementsPerHeight=1] The number of elements in the buffer that make up a single height
    * sample.  This is usually 1, indicating that each element is a separate height sample.  If
    * it is greater than 1, that number of elements together form the height sample, which is
    * computed according to the structure.elementMultiplier and structure.isBigEndian properties.
    * - {Number} [options.structure.stride=1] The number of elements to skip to get from the first element of
    * one height to the first element of the next height.
    * - {Number} [options.structure.elementMultiplier=256.0] The multiplier used to compute the height value when the
    * stride property is greater than 1.  For example, if the stride is 4 and the strideMultiplier
    * is 256, the height is computed as follows:
    * `height = buffer[index] + buffer[index + 1] * 256 + buffer[index + 2] * 256 * 256 + buffer[index + 3] * 256 * 256 * 256`
    * This is assuming that the isBigEndian property is false.  If it is true, the order of the
    * elements is reversed.
    * - {Boolean} [options.structure.isBigEndian=false] Indicates endianness of the elements in the buffer when the
    * stride property is greater than 1.  If this property is false, the first element is the
    * low-order element.  If it is true, the first element is the high-order element.
    * - {Boolean} [options.createdByUpsampling=false] True if this instance was created by upsampling another instance;
    * otherwise, false.
    *
    * @example
    * var buffer = ...
    * var heightBuffer = new Uint16Array(buffer, 0, that._heightmapWidth * that._heightmapWidth);
    * var childTileMask = new Uint8Array(buffer, heightBuffer.byteLength, 1)[0];
    * var waterMask = new Uint8Array(buffer, heightBuffer.byteLength + 1, buffer.byteLength - heightBuffer.byteLength - 1);
    * var terrainData = new Cesium.HeightmapTerrainData({
    * buffer : heightBuffer,
    * width : 65,
    * height : 65,
    * childTileMask : childTileMask,
    * waterMask : waterMask
    * });
    * @see TerrainData
    * @see QuantizedMeshTerrainData
    */
  @js.native
  @JSName("Cesium.HeightmapTerrainData")
  class HeightmapTerrainData protected() extends TerrainData {
    def this(options: HeightmapTerrainDataOptions) = this()
  }

  /**
    * A Hermite spline is a cubic interpolating spline. Points, incoming tangents, outgoing tangents, and times
    * must be defined for each control point. The outgoing tangents are defined for points [0, n - 2] and the incoming
    * tangents are defined for points [1, n - 1]. For example, when interpolating a segment of the curve between <code>points[i]</code> and
    * <code>points[i + 1]</code>, the tangents at the points will be <code>outTangents[i]</code> and <code>inTangents[i]</code>,
    * respectively.
    *
    * alias HermiteSpline
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Number[]} options.times An array of strictly increasing, unit-less, floating-point times at each point.
    * The values are in no way connected to the clock time. They are the parameterization for the curve.
    * - {Cartesian3[]} options.points The array of [[Cartesian3]] control points.
    * - {Cartesian3[]} options.inTangents The array of [[Cartesian3]] incoming tangents at each control point.
    * - {Cartesian3[]} options.outTangents The array of [[Cartesian3]] outgoing tangents at each control point.
    *
    * exception {DeveloperError} points.length must be greater than or equal to 2.
    * exception {DeveloperError} times.length must be equal to points.length.
    * exception {DeveloperError} inTangents and outTangents must have a length equal to points.length - 1.
    *
    * @example
    * // Create a G<sup>1</sup> continuous Hermite spline
    * var times = [ 0.0, 1.5, 3.0, 4.5, 6.0 ];
    * var spline = new Cesium.HermiteSpline({
    * times : times,
    * points : [
    * new Cesium.Cartesian3(1235398.0, -4810983.0, 4146266.0),
    * new Cesium.Cartesian3(1372574.0, -5345182.0, 4606657.0),
    * new Cesium.Cartesian3(-757983.0, -5542796.0, 4514323.0),
    * new Cesium.Cartesian3(-2821260.0, -5248423.0, 4021290.0),
    * new Cesium.Cartesian3(-2539788.0, -4724797.0, 3620093.0)
    * ],
    * outTangents : [
    * new Cesium.Cartesian3(1125196, -161816, 270551),
    * new Cesium.Cartesian3(-996690.5, -365906.5, 184028.5),
    * new Cesium.Cartesian3(-2096917, 48379.5, -292683.5),
    * new Cesium.Cartesian3(-890902.5, 408999.5, -447115)
    * ],
    * inTangents : [
    * new Cesium.Cartesian3(-1993381, -731813, 368057),
    * new Cesium.Cartesian3(-4193834, 96759, -585367),
    * new Cesium.Cartesian3(-1781805, 817999, -894230),
    * new Cesium.Cartesian3(1165345, 112641, 47281)
    * ]
    * });
    *
    * var p0 = spline.evaluate(times[0]);
    * @see CatmullRomSpline
    * @see LinearSpline
    * @see QuaternionSpline
    */
  @js.native
  @JSName("Cesium.HermiteSpline")
  class HermiteSpline protected() extends Spline {
    def this(options: HermiteSplineOptions) = this()

    var inTangents: js.Array[Cartesian3] = js.native
    var outTangents: js.Array[Cartesian3] = js.native
  }

  @js.native
  @JSName("Cesium.HermiteSpline")
  object HermiteSpline extends js.Object {
    def createC1(options: HermiteSplineOptions): HermiteSpline = js.native

    def createNaturalCubic(options: HermiteSplineOptions): HermiteSpline | LinearSpline = js.native

    def createClampedCubic(options: HermiteSplineOptions): HermiteSpline | LinearSpline = js.native
  }

  /**
    * Represents the closed interval [start, stop].
    * alias Interval
    *
    *
    * - {Number} [start=0.0] The beginning of the interval.
    * - {Number} [stop=0.0] The end of the interval.
    */
  @js.native
  @JSName("Cesium.Interval")
  class Interval protected() extends js.Object {
    def this(start: Double = ???, stop: Double = ???) = this()

    var start: Double = js.native
    var stop: Double = js.native
  }

  /**
    * Represents an astronomical Julian date, which is the number of days since noon on January 1, -4712 (4713 BC).
    * For increased precision, this class stores the whole number part of the date and the seconds
    * part of the date in separate components.  In order to be safe for arithmetic and represent
    * leap seconds, the date is always stored in the International Atomic Time standard
    * [[TimeStandard.TAI]].
    * alias JulianDate
    *
    *
    * - {Number} julianDayNumber The Julian Day Number representing the number of whole days.  Fractional days will also be handled correctly.
    * - {Number} secondsOfDay The number of seconds into the current Julian Day Number.  Fractional seconds, negative seconds and seconds greater than a day will be handled correctly.
    * - {TimeStandard} [timeStandard=TimeStandard.UTC] The time standard in which the first two parameters are defined.
    */
  @js.native
  @JSName("Cesium.JulianDate")
  class JulianDate() extends js.Object {
    def this(julianDayNumber: Double, secondsOfDay: Double, timeStandard: TimeStandard = ???) = this()

    var dayNumber: Int = js.native
    var secondsOfDay: Int = js.native

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

  /**
    * Describes a single leap second, which is constructed from a [[JulianDate]] and a
    * numerical offset representing the number of seconds TAI is ahead of the UTC time standard.
    * alias LeapSecond
    *
    *
    * - {JulianDate} [date] A Julian date representing the time of the leap second.
    * - {Number} [offset] The cumulative number of seconds that TAI is ahead of UTC at the provided date.
    */
  @js.native
  @JSName("Cesium.LeapSecond")
  class LeapSecond protected() extends js.Object {
    def this(date: JulianDate = ???, offset: Double = ???) = this()

    var julianDate: JulianDate = js.native
    var offset: Double = js.native
  }

  /**
    * A spline that uses piecewise linear interpolation to create a curve.
    *
    * alias LinearSpline
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Number[]} options.times An array of strictly increasing, unit-less, floating-point times at each point.
    * The values are in no way connected to the clock time. They are the parameterization for the curve.
    * - {Cartesian3[]} options.points The array of [[Cartesian3]] control points.
    *
    * exception {DeveloperError} points.length must be greater than or equal to 2.
    * exception {DeveloperError} times.length must be equal to points.length.
    *
    * @example
    * var times = [ 0.0, 1.5, 3.0, 4.5, 6.0 ];
    * var spline = new Cesium.LinearSpline({
    * times : times,
    * points : [
    * new Cesium.Cartesian3(1235398.0, -4810983.0, 4146266.0),
    * new Cesium.Cartesian3(1372574.0, -5345182.0, 4606657.0),
    * new Cesium.Cartesian3(-757983.0, -5542796.0, 4514323.0),
    * new Cesium.Cartesian3(-2821260.0, -5248423.0, 4021290.0),
    * new Cesium.Cartesian3(-2539788.0, -4724797.0, 3620093.0)
    * ]
    * });
    *
    * var p0 = spline.evaluate(times[0]);
    * @see HermiteSpline
    * @see CatmullRomSpline
    * @see QuaternionSpline
    */
  @js.native
  @JSName("Cesium.LinearSpline")
  class LinearSpline protected() extends Spline {
    def this(options: LinearSplineOptions) = this()
  }

  /**
    * Defines how geodetic ellipsoid coordinates ([[Cartographic]]) project to a
    * flat map like Cesium's 2D and Columbus View modes.
    *
    * alias MapProjection
    *
    * @see GeographicProjection
    * @see WebMercatorProjection
    */
  @js.native
  @JSName("Cesium.MapProjection")
  class MapProjection() extends js.Object {
    var ellipsoid: Ellipsoid = js.native

    def project(cartographic: Cartographic, result: Cartesian3 = ???): Cartesian3 = js.native

    def unproject(cartesian: Cartesian3, result: Cartographic = ???): Cartographic = js.native
  }

  /**
    * A 2x2 matrix, indexable as a column-major order array.
    * Constructor parameters are in row-major order for code readability.
    * alias Matrix2
    *
    *
    * - {Number} [column0Row0=0.0] The value for column 0, row 0.
    * - {Number} [column1Row0=0.0] The value for column 1, row 0.
    * - {Number} [column0Row1=0.0] The value for column 0, row 1.
    * - {Number} [column1Row1=0.0] The value for column 1, row 1.
    *
    * @see Matrix2.fromColumnMajorArray
    * @see Matrix2.fromRowMajorArray
    * @see Matrix2.fromScale
    * @see Matrix2.fromUniformScale
    * @see Matrix3
    * @see Matrix4
    */
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

    def pack(value: Matrix2, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: Matrix2 = ???): Matrix2 = js.native

    def clone(matrix: Matrix2, result: Matrix2 = ???): Matrix2 = js.native

    def fromArray(array: js.Array[Double], startingIndex: Double = ???, result: Matrix2 = ???): Matrix2 = js.native

    def fromColumnMajorArray(values: js.Array[Double], result: Matrix2 = ???): Matrix2 = js.native

    def fromRowMajorArray(values: js.Array[Double], result: Matrix2 = ???): Matrix2 = js.native

    def fromScale(scale: Cartesian2, result: Matrix2 = ???): Matrix2 = js.native

    def fromUniformScale(scale: Double, result: Matrix2 = ???): Matrix2 = js.native

    def fromRotation(angle: Double, result: Matrix2 = ???): Matrix2 = js.native

    def toArray(matrix: Matrix2, result: js.Array[Double]): js.Array[Double] = js.native

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

    def transpose(matrix: Matrix2, result: Matrix2 = ???): Matrix2 = js.native

    def abs(matrix: Matrix2, result: Matrix2): Matrix2 = js.native

    def equals(left: Matrix2 = ???, right: Matrix2 = ???): Boolean = js.native

    def equalsEpsilon(left: Matrix2, right: Matrix2, epsilon: Double): Boolean = js.native
  }

  /**
    * A 3x3 matrix, indexable as a column-major order array.
    * Constructor parameters are in row-major order for code readability.
    * alias Matrix3
    *
    *
    * - {Number} [column0Row0=0.0] The value for column 0, row 0.
    * - {Number} [column1Row0=0.0] The value for column 1, row 0.
    * - {Number} [column2Row0=0.0] The value for column 2, row 0.
    * - {Number} [column0Row1=0.0] The value for column 0, row 1.
    * - {Number} [column1Row1=0.0] The value for column 1, row 1.
    * - {Number} [column2Row1=0.0] The value for column 2, row 1.
    * - {Number} [column0Row2=0.0] The value for column 0, row 2.
    * - {Number} [column1Row2=0.0] The value for column 1, row 2.
    * - {Number} [column2Row2=0.0] The value for column 2, row 2.
    *
    * @see Matrix3.fromColumnMajorArray
    * @see Matrix3.fromRowMajorArray
    * @see Matrix3.fromQuaternion
    * @see Matrix3.fromScale
    * @see Matrix3.fromUniformScale
    * @see Matrix2
    * @see Matrix4
    */
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

    def pack(value: Matrix3, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

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

    def fromHeadingPitchRoll(headingPitchRoll: HeadingPitchRoll, result: Matrix3 = ???): Matrix3 = js.native

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

  /**
    * A 4x4 matrix, indexable as a column-major order array.
    * Constructor parameters are in row-major order for code readability.
    * alias Matrix4
    *
    *
    * - {Number} [column0Row0=0.0] The value for column 0, row 0.
    * - {Number} [column1Row0=0.0] The value for column 1, row 0.
    * - {Number} [column2Row0=0.0] The value for column 2, row 0.
    * - {Number} [column3Row0=0.0] The value for column 3, row 0.
    * - {Number} [column0Row1=0.0] The value for column 0, row 1.
    * - {Number} [column1Row1=0.0] The value for column 1, row 1.
    * - {Number} [column2Row1=0.0] The value for column 2, row 1.
    * - {Number} [column3Row1=0.0] The value for column 3, row 1.
    * - {Number} [column0Row2=0.0] The value for column 0, row 2.
    * - {Number} [column1Row2=0.0] The value for column 1, row 2.
    * - {Number} [column2Row2=0.0] The value for column 2, row 2.
    * - {Number} [column3Row2=0.0] The value for column 3, row 2.
    * - {Number} [column0Row3=0.0] The value for column 0, row 3.
    * - {Number} [column1Row3=0.0] The value for column 1, row 3.
    * - {Number} [column2Row3=0.0] The value for column 2, row 3.
    * - {Number} [column3Row3=0.0] The value for column 3, row 3.
    *
    * @see Matrix4.fromColumnMajorArray
    * @see Matrix4.fromRowMajorArray
    * @see Matrix4.fromRotationTranslation
    * @see Matrix4.fromTranslationRotationScale
    * @see Matrix4.fromTranslationQuaternionRotationScale
    * @see Matrix4.fromTranslation
    * @see Matrix4.fromScale
    * @see Matrix4.fromUniformScale
    * @see Matrix4.fromCamera
    * @see Matrix4.computePerspectiveFieldOfView
    * @see Matrix4.computeOrthographicOffCenter
    * @see Matrix4.computePerspectiveOffCenter
    * @see Matrix4.computeInfinitePerspectiveOffCenter
    * @see Matrix4.computeViewportTransformation
    * @see Matrix2
    * @see Matrix3
    * @see Packable
    */
  @js.native
  @JSName("Cesium.Matrix4")
  class Matrix4 protected() extends Packable {
    def this(column0Row0: Double = ???, column1Row0: Double = ???, column2Row0: Double = ???, column3Row0: Double = ???, column0Row1: Double = ???, column1Row1: Double = ???, column2Row1: Double = ???, column3Row1: Double = ???, column0Row2: Double = ???, column1Row2: Double = ???, column2Row2: Double = ???, column3Row2: Double = ???, column0Row3: Double = ???, column1Row3: Double = ???, column2Row3: Double = ???, column3Row3: Double = ???) = this()

    var length: Double = js.native

    def clone(result: Matrix4 = ???): Matrix4 = js.native

    def equals(right: Matrix4 = ???): Boolean = js.native

    def equalsEpsilon(right: Matrix4, epsilon: Double): Boolean = js.native

    override def toString(): String = js.native
  }

  @js.native
  @JSName("Cesium.Matrix4")
  object Matrix4 extends PackableStatic {

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

    def clone(matrix: Matrix4, result: Matrix4): Matrix4 = js.native

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

    def computePerspectiveFieldOfView(fovY: Double, aspectRatio: Double, near: Double, far: Double, result: Matrix4 = ???): Matrix4 = js.native

    def computeOrthographicOffCenter(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double, result: Matrix4): Matrix4 = js.native

    def computePerspectiveOffCenter(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double, result: Matrix4): Matrix4 = js.native

    def computeInfinitePerspectiveOffCenter(left: Double, right: Double, bottom: Double, top: Double, near: Double, result: Matrix4): Matrix4 = js.native

    def computeViewportTransformation(viewport: js.Any, nearDepthRange: Double, farDepthRange: Double, result: Matrix4): Matrix4 = js.native

    def computeView(position: Cartesian3, direction: Cartesian3, up: Cartesian3, right: Cartesian3, result: Matrix4): Matrix4 = js.native

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

    def inverse(matrix: Matrix4, result: Matrix4 = ???): Matrix4 = js.native

    def inverseTransformation(matrix: Matrix4, result: Matrix4): Matrix4 = js.native
  }

  /**
    * Defines the interface for a geometry updater.  A GeometryUpdater maps
    * geometry defined as part of a [[Entity]] into [[Geometry]]
    * instances.  These instances are then visualized by [[GeometryVisualizer]]
    *
    * This type defines an interface and cannot be instantiated directly.
    *
    * alias GeometryUpdater
    *
    *
    * - {Entity} entity The entity containing the geometry to be visualized.
    * - {Scene} scene The scene where visualization is taking place.
    *
    * @see EllipseGeometryUpdater
    * @see EllipsoidGeometryUpdater
    * @see PolygonGeometryUpdater
    * @see PolylineGeometryUpdater
    * @see RectangleGeometryUpdater
    * @see WallGeometryUpdater
    */
  @js.native
  trait GeometryUpdater extends js.Object {

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
  trait GeometryUpdaterStatic extends js.Object {
    var perInstanceColorAppearanceType: Appearance = js.native
    var materialAppearanceType: Appearance = js.native
  }

  /**
    * Represents a scalar value's lower and upper bound at a near distance and far distance in eye space.
    * alias NearFarScalar
    *
    *
    * - {Number} [near=0.0] The lower bound of the camera range.
    * - {Number} [nearValue=0.0] The value at the lower bound of the camera range.
    * - {Number} [far=1.0] The upper bound of the camera range.
    * - {Number} [farValue=0.0] The value at the upper bound of the camera range.
    *
    * @see Packable
    */
  @js.native
  @JSName("Cesium.NearFarScalar")
  class NearFarScalar protected() extends Packable {
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
  object NearFarScalar extends PackableStatic {

    def clone(nearFarScalar: NearFarScalar, result: NearFarScalar = ???): NearFarScalar = js.native

    def equals(left: NearFarScalar = ???, right: NearFarScalar = ???): Boolean = js.native
  }

  /**
    * Creates an Occluder derived from an object's position and radius, as well as the camera position.
    * The occluder can be used to determine whether or not other objects are visible or hidden behind the
    * visible horizon defined by the occluder and camera position.
    *
    * alias Occluder
    *
    * - {BoundingSphere} occluderBoundingSphere The bounding sphere surrounding the occluder.
    * - {Cartesian3} cameraPosition The coordinate of the viewer/camera.
    *
    * @example
    * // Construct an occluder one unit away from the origin with a radius of one.
    * var cameraPosition = Cesium.Cartesian3.ZERO;
    * var occluderBoundingSphere = new Cesium.BoundingSphere(new Cesium.Cartesian3(0, 0, -1), 1);
    * var occluder = new Cesium.Occluder(occluderBoundingSphere, cameraPosition);
    */
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

  /**
    * Creates an instance of an OrientedBoundingBox.
    * An OrientedBoundingBox of some object is a closed and convex cuboid. It can provide a tighter bounding volume than [[BoundingSphere]] or [[AxisAlignedBoundingBox]] in many cases.
    * alias OrientedBoundingBox
    *
    *
    * - {Cartesian3} [center=Cartesian3.ZERO] The center of the box.
    * - {Matrix3} [halfAxes=Matrix3.ZERO] The three orthogonal half-axes of the bounding box.
    * Equivalently, the transformation matrix, to rotate and scale a 2x2x2
    * cube centered at the origin.
    *
    * @example
    * // Create an OrientedBoundingBox using a transformation matrix, a position where the box will be translated, and a scale.
    * var center = new Cesium.Cartesian3(1.0, 0.0, 0.0);
    * var halfAxes = Cesium.Matrix3.fromScale(new Cesium.Cartesian3(1.0, 3.0, 2.0), new Cesium.Matrix3());
    *
    * var obb = new Cesium.OrientedBoundingBox(center, halfAxes);
    * @see BoundingSphere
    * @see BoundingRectangle
    */
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

  /**
    * A utility class for generating custom map pins as canvas elements.
    *
    * <div align='center'>
    * <img src='images/PinBuilder.png' width='500'/><br />
    * Example pins generated using both the maki icon set, which ships with Cesium, and single character text.
    * </div>
    *
    * alias PinBuilder
    *
    *
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Map%20Pins.html|Cesium Sandcastle PinBuilder Demo]]
    */
  @js.native
  @JSName("Cesium.PinBuilder")
  class PinBuilder() extends js.Object {
    def fromColor(color: Color, size: Double): HTMLCanvasElement = js.native

    def fromUrl(url: String, color: Color, size: Double): HTMLCanvasElement | Promise[HTMLCanvasElement] = js.native

    def fromMakiIconId(id: String, color: Color, size: Double): HTMLCanvasElement | Promise[HTMLCanvasElement] = js.native

    def fromText(text: String, color: Color, size: Double): HTMLCanvasElement = js.native
  }

  /**
    * A plane in Hessian Normal Form defined by
    * <pre>
    * ax + by + cz + d = 0
    * </pre>
    * where (a, b, c) is the plane's <code>normal</code>, d is the signed
    * <code>distance</code> to the plane, and (x, y, z) is any point on
    * the plane.
    *
    * alias Plane
    *
    *
    * - {Cartesian3} normal The plane's normal (normalized).
    * - {Number} distance The shortest distance from the origin to the plane.  The sign of
    * <code>distance</code> determines which side of the plane the origin
    * is on.  If <code>distance</code> is positive, the origin is in the half-space
    * in the direction of the normal; if negative, the origin is in the half-space
    * opposite to the normal; if zero, the plane passes through the origin.
    *
    * @example
    * // The plane x=0
    * var plane = new Cesium.Plane(Cesium.Cartesian3.UNIT_X, 0.0);
    */
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

  /**
    * A description of a polygon on the ellipsoid. The polygon is defined by a polygon hierarchy. Polygon geometry can be rendered with both [[Primitive]] and [[GroundPrimitive]].
    *
    * alias PolygonGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {PolygonHierarchy} options.polygonHierarchy A polygon hierarchy that can include holes.
    * - {Number} [options.height=0.0] The distance in meters between the polygon and the ellipsoid surface.
    * - {Number} [options.extrudedHeight] The distance in meters between the polygon's extruded face and the ellipsoid surface.
    * - {VertexFormat} [options.vertexFormat=VertexFormat.DEFAULT] The vertex attributes to be computed.
    * - {Number} [options.stRotation=0.0] The rotation of the texture coordinates, in radians. A positive rotation is counter-clockwise.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid to be used as a reference.
    * - {Number} [options.granularity=CesiumMath.RADIANS_PER_DEGREE] The distance, in radians, between each latitude and longitude. Determines the number of positions in the buffer.
    * - {Boolean} [options.perPositionHeight=false] Use the height of options.positions for each position instead of using options.height to determine the height.
    * - {Boolean} [options.closeTop=true] When false, leaves off the top of an extruded polygon open.
    * - {Boolean} [options.closeBottom=true] When false, leaves off the bottom of an extruded polygon open.
    *
    * @see PolygonGeometry#createGeometry
    * @see PolygonGeometry#fromPositions
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Polygon.html|Cesium Sandcastle Polygon Demo]]
    * @example
    * // 1. create a polygon from points
    * var polygon = new Cesium.PolygonGeometry({
    * polygonHierarchy : new Cesium.PolygonHierarchy(
    * Cesium.Cartesian3.fromDegreesArray([
    * -72.0, 40.0,
    * -70.0, 35.0,
    * -75.0, 30.0,
    * -70.0, 30.0,
    * -68.0, 40.0
    * ])
    * )
    * });
    * var geometry = Cesium.PolygonGeometry.createGeometry(polygon);
    *
    * // 2. create a nested polygon with holes
    * var polygonWithHole = new Cesium.PolygonGeometry({
    * polygonHierarchy : new Cesium.PolygonHierarchy(
    * Cesium.Cartesian3.fromDegreesArray([
    * -109.0, 30.0,
    * -95.0, 30.0,
    * -95.0, 40.0,
    * -109.0, 40.0
    * ]),
    * [new Cesium.PolygonHierarchy(
    * Cesium.Cartesian3.fromDegreesArray([
    * -107.0, 31.0,
    * -107.0, 39.0,
    * -97.0, 39.0,
    * -97.0, 31.0
    * ]),
    * [new Cesium.PolygonHierarchy(
    * Cesium.Cartesian3.fromDegreesArray([
    * -105.0, 33.0,
    * -99.0, 33.0,
    * -99.0, 37.0,
    * -105.0, 37.0
    * ]),
    * [new Cesium.PolygonHierarchy(
    * Cesium.Cartesian3.fromDegreesArray([
    * -103.0, 34.0,
    * -101.0, 34.0,
    * -101.0, 36.0,
    * -103.0, 36.0
    * ])
    * )]
    * )]
    * )]
    * )
    * });
    * var geometry = Cesium.PolygonGeometry.createGeometry(polygonWithHole);
    *
    * // 3. create extruded polygon
    * var extrudedPolygon = new Cesium.PolygonGeometry({
    * polygonHierarchy : new Cesium.PolygonHierarchy(
    * Cesium.Cartesian3.fromDegreesArray([
    * -72.0, 40.0,
    * -70.0, 35.0,
    * -75.0, 30.0,
    * -70.0, 30.0,
    * -68.0, 40.0
    * ])
    * ),
    * extrudedHeight: 300000
    * });
    * var geometry = Cesium.PolygonGeometry.createGeometry(extrudedPolygon);
    */
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

    def pack(value: PolygonGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: PolygonGeometry = ???): js.Dynamic = js.native

    def createGeometry(polygonGeometry: PolygonGeometry): Geometry | Unit = js.native
  }

  /**
    * An hierarchy of linear rings which define a polygon and its holes.
    * The holes themselves may also have holes which nest inner polygons.
    * alias PolygonHierarchy
    *
    *
    * - {Cartesian3[]} [positions] A linear ring defining the outer boundary of the polygon or hole.
    * - {PolygonHierarchy[]} [holes] An array of polygon hierarchies defining holes in the polygon.
    */
  @js.native
  @JSName("Cesium.PolygonHierarchy")
  class PolygonHierarchy protected() extends js.Object {
    def this(positions: js.Array[Cartesian3] = ???, holes: js.Array[PolygonHierarchy] = ???) = this()

    var positions: js.Array[Cartesian3] = js.native
    var holes: js.Array[PolygonHierarchy] = js.native
  }

  /**
    * A description of the outline of a polygon on the ellipsoid. The polygon is defined by a polygon hierarchy.
    *
    * alias PolygonOutlineGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {PolygonHierarchy} options.polygonHierarchy A polygon hierarchy that can include holes.
    * - {Number} [options.height=0.0] The distance in meters between the polygon and the ellipsoid surface.
    * - {Number} [options.extrudedHeight] The distance in meters between the polygon's extruded face and the ellipsoid surface.
    * - {VertexFormat} [options.vertexFormat=VertexFormat.DEFAULT] The vertex attributes to be computed.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid to be used as a reference.
    * - {Number} [options.granularity=CesiumMath.RADIANS_PER_DEGREE] The distance, in radians, between each latitude and longitude. Determines the number of positions in the buffer.
    * - {Boolean} [options.perPositionHeight=false] Use the height of options.positions for each position instead of using options.height to determine the height.
    *
    * @see PolygonOutlineGeometry#createGeometry
    * @see PolygonOutlineGeometry#fromPositions
    * @example
    * // 1. create a polygon outline from points
    * var polygon = new Cesium.PolygonOutlineGeometry({
    * polygonHierarchy : new Cesium.PolygonHierarchy(
    * Cesium.Cartesian3.fromDegreesArray([
    * -72.0, 40.0,
    * -70.0, 35.0,
    * -75.0, 30.0,
    * -70.0, 30.0,
    * -68.0, 40.0
    * ])
    * )
    * });
    * var geometry = Cesium.PolygonOutlineGeometry.createGeometry(polygon);
    *
    * // 2. create a nested polygon with holes outline
    * var polygonWithHole = new Cesium.PolygonOutlineGeometry({
    * polygonHierarchy : new Cesium.PolygonHierarchy(
    * Cesium.Cartesian3.fromDegreesArray([
    * -109.0, 30.0,
    * -95.0, 30.0,
    * -95.0, 40.0,
    * -109.0, 40.0
    * ]),
    * [new Cesium.PolygonHierarchy(
    * Cesium.Cartesian3.fromDegreesArray([
    * -107.0, 31.0,
    * -107.0, 39.0,
    * -97.0, 39.0,
    * -97.0, 31.0
    * ]),
    * [new Cesium.PolygonHierarchy(
    * Cesium.Cartesian3.fromDegreesArray([
    * -105.0, 33.0,
    * -99.0, 33.0,
    * -99.0, 37.0,
    * -105.0, 37.0
    * ]),
    * [new Cesium.PolygonHierarchy(
    * Cesium.Cartesian3.fromDegreesArray([
    * -103.0, 34.0,
    * -101.0, 34.0,
    * -101.0, 36.0,
    * -103.0, 36.0
    * ])
    * )]
    * )]
    * )]
    * )
    * });
    * var geometry = Cesium.PolygonOutlineGeometry.createGeometry(polygonWithHole);
    *
    * // 3. create extruded polygon outline
    * var extrudedPolygon = new Cesium.PolygonOutlineGeometry({
    * polygonHierarchy : new Cesium.PolygonHierarchy(
    * Cesium.Cartesian3.fromDegreesArray([
    * -72.0, 40.0,
    * -70.0, 35.0,
    * -75.0, 30.0,
    * -70.0, 30.0,
    * -68.0, 40.0
    * ])
    * ),
    * extrudedHeight: 300000
    * });
    * var geometry = Cesium.PolygonOutlineGeometry.createGeometry(extrudedPolygon);
    */
  @js.native
  @JSName("Cesium.PolygonOutlineGeometry")
  class PolygonOutlineGeometry protected() extends js.Object {
    def this(options: PolygonOutlineGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.PolygonOutlineGeometry")
  object PolygonOutlineGeometry extends js.Object {
    def pack(value: PolygonOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: PolygonOutlineGeometry = ???): PolygonOutlineGeometry = js.native

    def fromPositions(options: PositionsOptions): PolygonOutlineGeometry = js.native

    def createGeometry(polygonGeometry: PolygonOutlineGeometry): Geometry | Unit = js.native
  }

  /**
    * A description of a polyline modeled as a line strip; the first two positions define a line segment,
    * and each additional position defines a line segment from the previous position. The polyline is capable of
    * displaying with a material.
    *
    * alias PolylineGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3[]} options.positions An array of [[Cartesian3]] defining the positions in the polyline as a line strip.
    * - {Number} [options.width=1.0] The width in pixels.
    * - {Color[]} [options.colors] An Array of [[Color]] defining the per vertex or per segment colors.
    * - {Boolean} [options.colorsPerVertex=false] A boolean that determines whether the colors will be flat across each segment of the line or interpolated across the vertices.
    * - {Boolean} [options.followSurface=true] A boolean that determines whether positions will be adjusted to the surface of the ellipsoid via a great arc.
    * - {Number} [options.granularity=CesiumMath.RADIANS_PER_DEGREE] The distance, in radians, between each latitude and longitude if options.followSurface=true. Determines the number of positions in the buffer.
    * - {VertexFormat} [options.vertexFormat=VertexFormat.DEFAULT] The vertex attributes to be computed.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid to be used as a reference.
    *
    * exception {DeveloperError} At least two positions are required.
    * exception {DeveloperError} width must be greater than or equal to one.
    * exception {DeveloperError} colors has an invalid length.
    *
    * @see PolylineGeometry#createGeometry
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Polyline.html|Cesium Sandcastle Polyline Demo]]
    * @example
    * // A polyline with two connected line segments
    * var polyline = new Cesium.PolylineGeometry({
    * positions : Cesium.Cartesian3.fromDegreesArray([
    * 0.0, 0.0,
    * 5.0, 0.0,
    * 5.0, 5.0
    * ]),
    * width : 10.0
    * });
    * var geometry = Cesium.PolylineGeometry.createGeometry(polyline);
    */
  @js.native
  @JSName("Cesium.PolylineGeometry")
  class PolylineGeometry protected() extends js.Object {
    def this(options: PolylineGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.PolylineGeometry")
  object PolylineGeometry extends js.Object {
    def pack(value: PolylineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: PolylineGeometry = ???): PolylineGeometry = js.native

    def createGeometry(polylineGeometry: PolylineGeometry): Geometry | Unit = js.native
  }

  /**
    * A description of a polyline with a volume (a 2D shape extruded along a polyline).
    *
    * alias PolylineVolumeGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3[]} options.polylinePositions An array of [[Cartesian3]] positions that define the center of the polyline volume.
    * - {Cartesian2[]} options.shapePositions An array of [[Cartesian2]] positions that define the shape to be extruded along the polyline
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid to be used as a reference.
    * - {Number} [options.granularity=CesiumMath.RADIANS_PER_DEGREE] The distance, in radians, between each latitude and longitude. Determines the number of positions in the buffer.
    * - {VertexFormat} [options.vertexFormat=VertexFormat.DEFAULT] The vertex attributes to be computed.
    * - {CornerType} [options.cornerType=CornerType.ROUNDED] Determines the style of the corners.
    *
    * @see PolylineVolumeGeometry#createGeometry
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Polyline%20Volume.html|Cesium Sandcastle Polyline Volume Demo]]
    * @example
    * function computeCircle(radius) {
    * var positions = [];
    * for (var i = 0; i < 360; i++) {
    * var radians = Cesium.Math.toRadians(i);
    * positions.push(new Cesium.Cartesian2(radius * Math.cos(radians), radius * Math.sin(radians)));
    * }
    * return positions;
    * }
    *
    * var volume = new Cesium.PolylineVolumeGeometry({
    * vertexFormat : Cesium.VertexFormat.POSITION_ONLY,
    * polylinePositions : Cesium.Cartesian3.fromDegreesArray([
    * -72.0, 40.0,
    * -70.0, 35.0
    * ]),
    * shapePositions : computeCircle(100000.0)
    * });
    */
  @js.native
  @JSName("Cesium.PolylineVolumeGeometry")
  class PolylineVolumeGeometry protected() extends js.Object {
    def this(options: PolylineVolumeGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.PolylineVolumeGeometry")
  object PolylineVolumeGeometry extends js.Object {
    def pack(value: PolylineVolumeGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: PolylineVolumeGeometry = ???): PolylineVolumeGeometry = js.native

    def createGeometry(polylineVolumeGeometry: PolylineVolumeGeometry): Geometry | Unit = js.native
  }

  /**
    * A description of a polyline with a volume (a 2D shape extruded along a polyline).
    *
    * alias PolylineVolumeOutlineGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3[]} options.polylinePositions An array of positions that define the center of the polyline volume.
    * - {Cartesian2[]} options.shapePositions An array of positions that define the shape to be extruded along the polyline
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid to be used as a reference.
    * - {Number} [options.granularity=CesiumMath.RADIANS_PER_DEGREE] The distance, in radians, between each latitude and longitude. Determines the number of positions in the buffer.
    * - {CornerType} [options.cornerType=CornerType.ROUNDED] Determines the style of the corners.
    *
    * @see PolylineVolumeOutlineGeometry#createGeometry
    * @example
    * function computeCircle(radius) {
    * var positions = [];
    * for (var i = 0; i < 360; i++) {
    * var radians = Cesium.Math.toRadians(i);
    * positions.push(new Cesium.Cartesian2(radius * Math.cos(radians), radius * Math.sin(radians)));
    * }
    * return positions;
    * }
    *
    * var volumeOutline = new Cesium.PolylineVolumeOutlineGeometry({
    * polylinePositions : Cesium.Cartesian3.fromDegreesArray([
    * -72.0, 40.0,
    * -70.0, 35.0
    * ]),
    * shapePositions : computeCircle(100000.0)
    * });
    */
  @js.native
  @JSName("Cesium.PolylineVolumeOutlineGeometry")
  class PolylineVolumeOutlineGeometry protected() extends js.Object {
    def this(options: PolylineVolumeOutlineGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.PolylineVolumeOutlineGeometry")
  object PolylineVolumeOutlineGeometry extends js.Object {
    def pack(value: PolylineVolumeOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: PolylineVolumeOutlineGeometry = ???): PolylineVolumeOutlineGeometry = js.native

    def createGeometry(polylineVolumeOutlineGeometry: PolylineVolumeOutlineGeometry): Geometry | Unit = js.native
  }

  /**
    * Terrain data for a single tile where the terrain data is represented as a quantized mesh.  A quantized
    * mesh consists of three vertex attributes, longitude, latitude, and height.  All attributes are expressed
    * as 16-bit values in the range 0 to 32767.  Longitude and latitude are zero at the southwest corner
    * of the tile and 32767 at the northeast corner.  Height is zero at the minimum height in the tile
    * and 32767 at the maximum height in the tile.
    *
    * alias QuantizedMeshTerrainData
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Uint16Array} options.quantizedVertices The buffer containing the quantized mesh.
    * - {Uint16Array|Uint32Array} options.indices The indices specifying how the quantized vertices are linked
    * together into triangles.  Each three indices specifies one triangle.
    * - {Number} options.minimumHeight The minimum terrain height within the tile, in meters above the ellipsoid.
    * - {Number} options.maximumHeight The maximum terrain height within the tile, in meters above the ellipsoid.
    * - {BoundingSphere} options.boundingSphere A sphere bounding all of the vertices in the mesh.
    * - {OrientedBoundingBox} [options.orientedBoundingBox] An OrientedBoundingBox bounding all of the vertices in the mesh.
    * - {Cartesian3} options.horizonOcclusionPoint The horizon occlusion point of the mesh.  If this point
    * is below the horizon, the entire tile is assumed to be below the horizon as well.
    * The point is expressed in ellipsoid-scaled coordinates.
    * - {Number[]} options.westIndices The indices of the vertices on the western edge of the tile.
    * - {Number[]} options.southIndices The indices of the vertices on the southern edge of the tile.
    * - {Number[]} options.eastIndices The indices of the vertices on the eastern edge of the tile.
    * - {Number[]} options.northIndices The indices of the vertices on the northern edge of the tile.
    * - {Number} options.westSkirtHeight The height of the skirt to add on the western edge of the tile.
    * - {Number} options.southSkirtHeight The height of the skirt to add on the southern edge of the tile.
    * - {Number} options.eastSkirtHeight The height of the skirt to add on the eastern edge of the tile.
    * - {Number} options.northSkirtHeight The height of the skirt to add on the northern edge of the tile.
    * - {Number} [options.childTileMask=15] A bit mask indicating which of this tile's four children exist.
    * If a child's bit is set, geometry will be requested for that tile as well when it
    * is needed.  If the bit is cleared, the child tile is not requested and geometry is
    * instead upsampled from the parent.  The bit values are as follows:
    * <table>
    * <tr><th>Bit Position</th><th>Bit Value</th><th>Child Tile</th></tr>
    * <tr><td>0</td><td>1</td><td>Southwest</td></tr>
    * <tr><td>1</td><td>2</td><td>Southeast</td></tr>
    * <tr><td>2</td><td>4</td><td>Northwest</td></tr>
    * <tr><td>3</td><td>8</td><td>Northeast</td></tr>
    * </table>
    * - {Boolean} [options.createdByUpsampling=false] True if this instance was created by upsampling another instance;
    * otherwise, false.
    * - {Uint8Array} [options.encodedNormals] The buffer containing per vertex normals, encoded using 'oct' encoding
    * - {Uint8Array} [options.waterMask] The buffer containing the watermask.
    *
    * @example
    * var data = new Cesium.QuantizedMeshTerrainData({
    * minimumHeight : -100,
    * maximumHeight : 2101,
    * quantizedVertices : new Uint16Array([// order is SW NW SE NE
    * // longitude
    * 0, 0, 32767, 32767,
    * // latitude
    * 0, 32767, 0, 32767,
    * // heights
    * 16384, 0, 32767, 16384]),
    * indices : new Uint16Array([0, 3, 1,
    * 0, 2, 3]),
    * boundingSphere : new Cesium.BoundingSphere(new Cesium.Cartesian3(1.0, 2.0, 3.0), 10000),
    * orientedBoundingBox : new Cesium.OrientedBoundingBox(new Cesium.Cartesian3(1.0, 2.0, 3.0), Cesium.Matrix3.fromRotationX(Cesium.Math.PI, new Cesium.Matrix3())),
    * horizonOcclusionPoint : new Cesium.Cartesian3(3.0, 2.0, 1.0),
    * westIndices : [0, 1],
    * southIndices : [0, 1],
    * eastIndices : [2, 3],
    * northIndices : [1, 3],
    * westSkirtHeight : 1.0,
    * southSkirtHeight : 1.0,
    * eastSkirtHeight : 1.0,
    * northSkirtHeight : 1.0
    * });
    * @see TerrainData
    * @see HeightmapTerrainData
    */
  @js.native
  @JSName("Cesium.QuantizedMeshTerrainData")
  class QuantizedMeshTerrainData protected() extends TerrainData {
    def this(options: QuantizedMeshTerrainDataOptions) = this()
  }

  /**
    * A set of 4-dimensional coordinates used to represent rotation in 3-dimensional space.
    * alias Quaternion
    *
    *
    * - {Number} [x=0.0] The X component.
    * - {Number} [y=0.0] The Y component.
    * - {Number} [z=0.0] The Z component.
    * - {Number} [w=0.0] The W component.
    *
    * @see PackableForInterpolation
    */
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
  object Quaternion extends PackableForInterpolation {

    var ZERO: Quaternion = js.native
    var IDENTITY: Quaternion = js.native

    def fromAxisAngle(axis: Cartesian3, angle: Double, result: Quaternion = ???): Quaternion = js.native

    def fromRotationMatrix(matrix: Matrix3, result: Quaternion = ???): Quaternion = js.native

    def fromHeadingPitchRoll(heading: Double, pitch: Double, roll: Double, result: Quaternion = ???): Quaternion = js.native

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

  /**
    * A spline that uses spherical quadrangle (squad) interpolation to create a quaternion curve.
    * The generated curve is in the class C<sup>1</sup>.
    *
    * alias QuaternionSpline
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Number[]} options.times An array of strictly increasing, unit-less, floating-point times at each point.
    * The values are in no way connected to the clock time. They are the parameterization for the curve.
    * - {Quaternion[]} options.points The array of [[Quaternion]] control points.
    * - {Quaternion} [options.firstInnerQuadrangle] The inner quadrangle of the curve at the first control point.
    * If the inner quadrangle is not given, it will be estimated.
    * - {Quaternion} [options.lastInnerQuadrangle] The inner quadrangle of the curve at the last control point.
    * If the inner quadrangle is not given, it will be estimated.
    *
    * exception {DeveloperError} points.length must be greater than or equal to 2.
    * exception {DeveloperError} times.length must be equal to points.length.
    *
    * @see HermiteSpline
    * @see CatmullRomSpline
    * @see LinearSpline
    */
  @js.native
  @JSName("Cesium.QuaternionSpline")
  class QuaternionSpline protected() extends Spline {
    def this(options: QuaternionSplineOptions) = this()

    var innerQuadrangles: js.Array[Quaternion] = js.native
  }

  @JSName("Cesium.Queue")
  @js.native
  object Queue extends js.Object {
    type Comparator = js.Function2[js.Any, js.Any, Double]
  }

  /**
    * A queue that can enqueue items at the end, and dequeue items from the front.
    *
    * alias Queue
    *
    */
  @js.native
  @JSName("Cesium.Queue")
  class Queue() extends js.Object {
    var length: Double = js.native

    def enqueue(item: js.Any): js.Dynamic = js.native

    def dequeue(): js.Dynamic = js.native

    def peek(): js.Dynamic = js.native

    def contains(item: js.Any): js.Dynamic = js.native

    def clear(): js.Dynamic = js.native

    def sort(compareFunction: Queue.Comparator): js.Dynamic = js.native
  }

  /**
    * Represents a ray that extends infinitely from the provided origin in the provided direction.
    * alias Ray
    *
    *
    * - {Cartesian3} [origin=Cartesian3.ZERO] The origin of the ray.
    * - {Cartesian3} [direction=Cartesian3.ZERO] The direction of the ray.
    */
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

  /**
    * A two dimensional region specified as longitude and latitude coordinates.
    *
    * alias Rectangle
    *
    *
    * - {Number} [west=0.0] The westernmost longitude, in radians, in the range [-Pi, Pi].
    * - {Number} [south=0.0] The southernmost latitude, in radians, in the range [-Pi/2, Pi/2].
    * - {Number} [east=0.0] The easternmost longitude, in radians, in the range [-Pi, Pi].
    * - {Number} [north=0.0] The northernmost latitude, in radians, in the range [-Pi/2, Pi/2].
    *
    * @see Packable
    */
  @js.native
  @JSName("Cesium.Rectangle")
  class Rectangle protected() extends Packable {
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
  object Rectangle extends PackableStatic {

    var MAX_VALUE: Rectangle = js.native

    def computeWidth(rectangle: Rectangle): Double = js.native

    def computeHeight(rectangle: Rectangle): Double = js.native

    def fromDegrees(west: Double = ???, south: Double = ???, east: Double = ???, north: Double = ???, result: Rectangle = ???): Rectangle = js.native

    def fromRadians(west: Double = ???, south: Double = ???, east: Double = ???, north: Double = ???, result: Rectangle = ???): Rectangle = js.native

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

    def simpleIntersection(rectangle: Rectangle, otherRectangle: Rectangle, result: Rectangle = ???): Rectangle | Unit = js.native

    def union(rectangle: Rectangle, otherRectangle: Rectangle, result: Rectangle = ???): Rectangle = js.native

    def expand(rectangle: Rectangle, cartographic: Cartographic, result: Rectangle = ???): Rectangle = js.native

    def contains(rectangle: Rectangle, cartographic: Cartographic): Boolean = js.native

    def subsample(rectangle: Rectangle, ellipsoid: Ellipsoid = ???, surfaceHeight: Double = ???, result: js.Array[Cartesian3] = ???): js.Array[Cartesian3] = js.native
  }

  /**
    * A description of a cartographic rectangle on an ellipsoid centered at the origin. Rectangle geometry can be rendered with both [[Primitive]] and [[GroundPrimitive]].
    *
    * alias RectangleGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Rectangle} options.rectangle A cartographic rectangle with north, south, east and west properties in radians.
    * - {VertexFormat} [options.vertexFormat=VertexFormat.DEFAULT] The vertex attributes to be computed.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid on which the rectangle lies.
    * - {Number} [options.granularity=CesiumMath.RADIANS_PER_DEGREE] The distance, in radians, between each latitude and longitude. Determines the number of positions in the buffer.
    * - {Number} [options.height=0.0] The distance in meters between the rectangle and the ellipsoid surface.
    * - {Number} [options.rotation=0.0] The rotation of the rectangle, in radians. A positive rotation is counter-clockwise.
    * - {Number} [options.stRotation=0.0] The rotation of the texture coordinates, in radians. A positive rotation is counter-clockwise.
    * - {Number} [options.extrudedHeight] The distance in meters between the rectangle's extruded face and the ellipsoid surface.
    * - {Boolean} [options.closeTop=true] Specifies whether the rectangle has a top cover when extruded.
    * - {Boolean} [options.closeBottom=true] Specifies whether the rectangle has a bottom cover when extruded.
    *
    * exception {DeveloperError} <code>options.rectangle.north</code> must be in the interval [<code>-Pi/2</code>, <code>Pi/2</code>].
    * exception {DeveloperError} <code>options.rectangle.south</code> must be in the interval [<code>-Pi/2</code>, <code>Pi/2</code>].
    * exception {DeveloperError} <code>options.rectangle.east</code> must be in the interval [<code>-Pi</code>, <code>Pi</code>].
    * exception {DeveloperError} <code>options.rectangle.west</code> must be in the interval [<code>-Pi</code>, <code>Pi</code>].
    * exception {DeveloperError} <code>options.rectangle.north</code> must be greater than <code>options.rectangle.south</code>.
    *
    * @see RectangleGeometry#createGeometry
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Rectangle.html|Cesium Sandcastle Rectangle Demo]]
    * @example
    * // 1. create an rectangle
    * var rectangle = new Cesium.RectangleGeometry({
    * ellipsoid : Cesium.Ellipsoid.WGS84,
    * rectangle : Cesium.Rectangle.fromDegrees(-80.0, 39.0, -74.0, 42.0),
    * height : 10000.0
    * });
    * var geometry = Cesium.RectangleGeometry.createGeometry(rectangle);
    *
    * // 2. create an extruded rectangle without a top
    * var rectangle = new Cesium.RectangleGeometry({
    * ellipsoid : Cesium.Ellipsoid.WGS84,
    * rectangle : Cesium.Rectangle.fromDegrees(-80.0, 39.0, -74.0, 42.0),
    * height : 10000.0,
    * extrudedHeight: 300000,
    * closeTop: false
    * });
    * var geometry = Cesium.RectangleGeometry.createGeometry(rectangle);
    */
  @js.native
  @JSName("Cesium.RectangleGeometry")
  class RectangleGeometry protected() extends js.Object {
    def this(options: RectangleGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.RectangleGeometry")
  object RectangleGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: RectangleGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: RectangleGeometry = ???): RectangleGeometry = js.native

    def createGeometry(rectangleGeometry: RectangleGeometry): Geometry | Unit = js.native
  }

  /**
    * A description of the outline of a a cartographic rectangle on an ellipsoid centered at the origin.
    *
    * alias RectangleOutlineGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Rectangle} options.rectangle A cartographic rectangle with north, south, east and west properties in radians.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid on which the rectangle lies.
    * - {Number} [options.granularity=CesiumMath.RADIANS_PER_DEGREE] The distance, in radians, between each latitude and longitude. Determines the number of positions in the buffer.
    * - {Number} [options.height=0.0] The distance in meters between the rectangle and the ellipsoid surface.
    * - {Number} [options.rotation=0.0] The rotation of the rectangle, in radians. A positive rotation is counter-clockwise.
    * - {Number} [options.extrudedHeight] The distance in meters between the rectangle's extruded face and the ellipsoid surface.
    *
    * exception {DeveloperError} <code>options.rectangle.north</code> must be in the interval [<code>-Pi/2</code>, <code>Pi/2</code>].
    * exception {DeveloperError} <code>options.rectangle.south</code> must be in the interval [<code>-Pi/2</code>, <code>Pi/2</code>].
    * exception {DeveloperError} <code>options.rectangle.east</code> must be in the interval [<code>-Pi</code>, <code>Pi</code>].
    * exception {DeveloperError} <code>options.rectangle.west</code> must be in the interval [<code>-Pi</code>, <code>Pi</code>].
    * exception {DeveloperError} <code>options.rectangle.north</code> must be greater than <code>rectangle.south</code>.
    *
    * @see RectangleOutlineGeometry#createGeometry
    * @example
    * var rectangle = new Cesium.RectangleOutlineGeometry({
    * ellipsoid : Cesium.Ellipsoid.WGS84,
    * rectangle : Cesium.Rectangle.fromDegrees(-80.0, 39.0, -74.0, 42.0),
    * height : 10000.0
    * });
    * var geometry = Cesium.RectangleOutlineGeometry.createGeometry(rectangle);
    */
  @js.native
  @JSName("Cesium.RectangleOutlineGeometry")
  class RectangleOutlineGeometry protected() extends js.Object {
    def this(options: RectangleOutlineGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.RectangleOutlineGeometry")
  object RectangleOutlineGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: RectangleOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: RectangleOutlineGeometry = ???): RectangleOutlineGeometry = js.native

    def createGeometry(rectangleGeometry: RectangleOutlineGeometry): Geometry | Unit = js.native
  }

  /**
    * An event that is raised when a request encounters an error.
    *
    *
    * alias RequestErrorEvent
    *
    * - {Number} [statusCode] The HTTP error status code, such as 404.
    * - {Object} [response] The response included along with the error.
    * - {String|Object} [responseHeaders] The response headers, represented either as an object literal or as a
    * string in the format returned by XMLHttpRequest's getAllResponseHeaders() function.
    */
  @js.native
  @JSName("Cesium.RequestErrorEvent")
  class RequestErrorEvent protected() extends js.Object {
    def this(statusCode: Double = ???, response: js.Any = ???, responseHeaders: String | js.Any = ???) = this()

    var statusCode: Double = js.native
    var response: js.Any = js.native
    var responseHeaders: js.Any = js.native

    override def toString(): String = js.native
  }

  /**
    * Constructs an exception object that is thrown due to an error that can occur at runtime, e.g.,
    * out of memory, could not compile shader, etc.  If a function may throw this
    * exception, the calling code should be prepared to catch it.
    *
    * On the other hand, a [[DeveloperError]] indicates an exception due
    * to a developer error, e.g., invalid argument, that usually indicates a bug in the
    * calling code.
    *
    * alias RuntimeError
    *
    * extends Error
    *
    * - {String} [message] The error message for this exception.
    *
    * @see DeveloperError
    */
  @js.native
  @JSName("Cesium.RuntimeError")
  class RuntimeError protected() extends js.Object {
    def this(message: String = ???) = this()

    var name: String = js.native
    var message: String = js.native
    var stack: String = js.native
  }

  /**
    * Defines the interface for data sources, which turn arbitrary data into a
    * [[EntityCollection]] for generic consumption. This object is an interface
    * for documentation purposes and is not intended to be instantiated directly.
    * alias DataSource
    *
    * @see Entity
    * @see DataSourceDisplay
    */
  @js.native
  trait DataSource extends js.Object {
    var name: String = js.native
    var clock: DataSourceClock = js.native
    var entities: EntityCollection = js.native
    var isLoading: Boolean = js.native
    var changedEvent: Event = js.native
    var errorEvent: Event = js.native
    var loadingEvent: Event = js.native
    var show: Boolean = js.native
    var clustering: EntityCluster = js.native

    def update(time: JulianDate): Boolean = js.native
  }

  /**
    * Handles user input events. Custom functions can be added to be executed on
    * when the user enters input.
    *
    * alias ScreenSpaceEventHandler
    *
    * - {Canvas} [element=document] The element to add events to.
    *
    *
    */
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

  /**
    * Value and type information for per-instance geometry attribute that determines if the geometry instance will be shown.
    *
    * alias ShowGeometryInstanceAttribute
    *
    *
    * - {Boolean} [show=true] Determines if the geometry instance will be shown.
    *
    * @example
    * var instance = new Cesium.GeometryInstance({
    * geometry : new Cesium.BoxGeometry({
    * vertexFormat : Cesium.VertexFormat.POSITION_AND_NORMAL,
    * minimum : new Cesium.Cartesian3(-250000.0, -250000.0, -250000.0),
    * maximum : new Cesium.Cartesian3(250000.0, 250000.0, 250000.0)
    * }),
    * modelMatrix : Cesium.Matrix4.multiplyByTranslation(Cesium.Transforms.eastNorthUpToFixedFrame(
    * Cesium.Cartesian3.fromDegrees(-75.59777, 40.03883)), new Cesium.Cartesian3(0.0, 0.0, 1000000.0), new Cesium.Matrix4()),
    * id : 'box',
    * attributes : {
    * show : new Cesium.ShowGeometryInstanceAttribute(false)
    * }
    * });
    * @see GeometryInstance
    * @see GeometryInstanceAttribute
    */
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

  /**
    * A description of a polyline modeled as a line strip; the first two positions define a line segment,
    * and each additional position defines a line segment from the previous position.
    *
    * alias SimplePolylineGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3[]} options.positions An array of [[Cartesian3]] defining the positions in the polyline as a line strip.
    * - {Color[]} [options.colors] An Array of [[Color]] defining the per vertex or per segment colors.
    * - {Boolean} [options.colorsPerVertex=false] A boolean that determines whether the colors will be flat across each segment of the line or interpolated across the vertices.
    * - {Boolean} [options.followSurface=true] A boolean that determines whether positions will be adjusted to the surface of the ellipsoid via a great arc.
    * - {Number} [options.granularity=CesiumMath.RADIANS_PER_DEGREE] The distance, in radians, between each latitude and longitude if options.followSurface=true. Determines the number of positions in the buffer.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid to be used as a reference.
    *
    * exception {DeveloperError} At least two positions are required.
    * exception {DeveloperError} colors has an invalid length.
    *
    * @see SimplePolylineGeometry#createGeometry
    * @example
    * // A polyline with two connected line segments
    * var polyline = new Cesium.SimplePolylineGeometry({
    * positions : Cesium.Cartesian3.fromDegreesArray([
    * 0.0, 0.0,
    * 5.0, 0.0,
    * 5.0, 5.0
    * ])
    * });
    * var geometry = Cesium.SimplePolylineGeometry.createGeometry(polyline);
    */
  @js.native
  @JSName("Cesium.SimplePolylineGeometry")
  class SimplePolylineGeometry protected() extends js.Object {
    def this(options: SimplePolylineGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.SimplePolylineGeometry")
  object SimplePolylineGeometry extends js.Object {
    def pack(value: SimplePolylineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: SimplePolylineGeometry = ???): SimplePolylineGeometry = js.native

    def createGeometry(simplePolylineGeometry: SimplePolylineGeometry): Geometry = js.native
  }

  /**
    * A description of a sphere centered at the origin.
    *
    * alias SphereGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Number} [options.radius=1.0] The radius of the sphere.
    * - {Number} [options.stackPartitions=64] The number of times to partition the ellipsoid into stacks.
    * - {Number} [options.slicePartitions=64] The number of times to partition the ellipsoid into radial slices.
    * - {VertexFormat} [options.vertexFormat=VertexFormat.DEFAULT] The vertex attributes to be computed.
    *
    * exception {DeveloperError} options.slicePartitions cannot be less than three.
    * exception {DeveloperError} options.stackPartitions cannot be less than three.
    *
    * @see SphereGeometry#createGeometry
    * @example
    * var sphere = new Cesium.SphereGeometry({
    * radius : 100.0,
    * vertexFormat : Cesium.VertexFormat.POSITION_ONLY
    * });
    * var geometry = Cesium.SphereGeometry.createGeometry(sphere);
    */
  @js.native
  @JSName("Cesium.SphereGeometry")
  class SphereGeometry protected() extends js.Object {
    def this(options: SphereGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.SphereGeometry")
  object SphereGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: SphereGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: SphereGeometry = ???): SphereGeometry = js.native

    def createGeometry(sphereGeometry: SphereGeometry): Geometry = js.native
  }

  /**
    * A description of the outline of a sphere.
    *
    * alias SphereOutlineGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Number} [options.radius=1.0] The radius of the sphere.
    * - {Number} [options.stackPartitions=10] The count of stacks for the sphere (1 greater than the number of parallel lines).
    * - {Number} [options.slicePartitions=8] The count of slices for the sphere (Equal to the number of radial lines).
    * - {Number} [options.subdivisions=200] The number of points per line, determining the granularity of the curvature .
    *
    * exception {DeveloperError} options.stackPartitions must be greater than or equal to one.
    * exception {DeveloperError} options.slicePartitions must be greater than or equal to zero.
    * exception {DeveloperError} options.subdivisions must be greater than or equal to zero.
    *
    * @example
    * var sphere = new Cesium.SphereOutlineGeometry({
    * radius : 100.0,
    * stackPartitions : 6,
    * slicePartitions: 5
    * });
    * var geometry = Cesium.SphereOutlineGeometry.createGeometry(sphere);
    */
  @js.native
  @JSName("Cesium.SphereOutlineGeometry")
  class SphereOutlineGeometry protected() extends js.Object {
    def this(options: SphereOutlineGeometryOptions) = this()
  }

  @js.native
  @JSName("Cesium.SphereOutlineGeometry")
  object SphereOutlineGeometry extends js.Object {
    var packedLength: Double = js.native

    def pack(value: SphereOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: SphereOutlineGeometry = ???): SphereOutlineGeometry = js.native

    def createGeometry(sphereGeometry: SphereOutlineGeometry): Geometry = js.native
  }

  /**
    * A set of curvilinear 3-dimensional coordinates.
    *
    * alias Spherical
    *
    *
    * - {Number} [clock=0.0] The angular coordinate lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.
    * - {Number} [cone=0.0] The angular coordinate measured from the positive z-axis and toward the negative z-axis.
    * - {Number} [magnitude=1.0] The linear coordinate measured from the origin.
    */
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

  /**
    * Creates a curve parameterized and evaluated by time. This type describes an interface
    * and is not intended to be instantiated directly.
    *
    * alias Spline
    *
    * @see CatmullRomSpline
    * @see HermiteSpline
    * @see LinearSpline
    * @see QuaternionSpline
    */
  @js.native
  trait Spline extends js.Object {
    var times: js.Array[Double] = js.native
    var points: js.Array[Cartesian3] | js.Array[Quaternion] = js.native

    def evaluate(time: Double, result: Cartesian3 | Quaternion = ???): Cartesian3 | Quaternion = js.native

    def findTimeInterval(time: Double, startIndex: Double): Double = js.native
  }

  /**
    * A wrapper around a web worker that allows scheduling tasks for a given worker,
    * returning results asynchronously via a promise.
    *
    * The Worker is not constructed until a task is scheduled.
    *
    * alias TaskProcessor
    *
    *
    * - {String} workerName The name of the worker.  This is expected to be a script
    * in the Workers folder.
    * - {Number} [maximumActiveTasks=5] The maximum number of active tasks.  Once exceeded,
    * scheduleTask will not queue any more tasks, allowing
    * work to be rescheduled in future frames.
    */
  @js.native
  @JSName("Cesium.TaskProcessor")
  class TaskProcessor protected() extends js.Object {
    def this(workerName: String, maximumActiveTasks: Double = ???) = this()

    def scheduleTask(parameters: js.Any, transferableObjects: js.Array[js.Any] = ???): Promise[js.Any] | Unit = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  /**
    * Terrain data for a single tile.  This type describes an
    * interface and is not intended to be instantiated directly.
    *
    * alias TerrainData
    *
    * @see HeightmapTerrainData
    * @see QuantizedMeshTerrainData
    */
  @js.native
  trait TerrainData extends js.Object {
    var waterMask: Uint8Array | HTMLImageElement | HTMLCanvasElement = js.native

    def interpolateHeight(rectangle: Rectangle, longitude: Double, latitude: Double): Double = js.native

    def isChildAvailable(thisX: Double, thisY: Double, childX: Double, childY: Double): Boolean = js.native

    def upsample(tilingScheme: TilingScheme, thisX: Double, thisY: Double, thisLevel: Double, descendantX: Double, descendantY: Double, descendantLevel: Double): Promise[TerrainData] | Unit = js.native

    def wasCreatedByUpsampling(): Boolean = js.native
  }

  /**
    * Provides terrain or other geometry for the surface of an ellipsoid.  The surface geometry is
    * organized into a pyramid of tiles according to a [[TilingScheme]].  This type describes an
    * interface and is not intended to be instantiated directly.
    *
    * alias TerrainProvider
    *
    * @see EllipsoidTerrainProvider
    * @see CesiumTerrainProvider
    * @see ArcGisImageServerTerrainProvider
    */
  @js.native
  trait TerrainProvider extends js.Object {
    var availability: Boolean = js.native
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

    // todo check this is correct, should these be in an object?
    // static methods
    var heightmapTerrainQuality: Double = js.native

    def getRegularGridIndices(width: Double, height: Double): Uint16Array = js.native

    def getEstimatedLevelZeroGeometricErrorForAHeightmap(ellipsoid: Ellipsoid, tileImageWidth: Double, numberOfTilesAtLevelZero: Double): Double = js.native

  }

  /**
    * Provides details about an error that occurred in an [[ImageryProvider]] or a [[TerrainProvider]].
    *
    * alias TileProviderError
    *
    *
    * - {ImageryProvider|TerrainProvider} provider The imagery or terrain provider that experienced the error.
    * - {String} message A message describing the error.
    * - {Number} [x] The X coordinate of the tile that experienced the error, or undefined if the error
    * is not specific to a particular tile.
    * - {Number} [y] The Y coordinate of the tile that experienced the error, or undefined if the error
    * is not specific to a particular tile.
    * - {Number} [level] The level of the tile that experienced the error, or undefined if the error
    * is not specific to a particular tile.
    * - {Number} [timesRetried=0] The number of times this operation has been retried.
    * - {Error} [error] The error or exception that occurred, if any.
    */
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

  /**
    * A tiling scheme for geometry or imagery on the surface of an ellipsoid.  At level-of-detail zero,
    * the coarsest, least-detailed level, the number of tiles is configurable.
    * At level of detail one, each of the level zero tiles has four children, two in each direction.
    * At level of detail two, each of the level one tiles has four children, two in each direction.
    * This continues for as many levels as are present in the geometry or imagery source.
    *
    * alias TilingScheme
    *
    * @see WebMercatorTilingScheme
    * @see GeographicTilingScheme
    */
  @js.native
  trait TilingScheme extends js.Object {
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

  /**
    * An interval defined by a start and a stop time; optionally including those times as part of the interval.
    * Arbitrary data can optionally be associated with each instance for used with [[TimeIntervalCollection]].
    *
    * alias TimeInterval
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {JulianDate} [options.start=new JulianDate()] The start time of the interval.
    * - {JulianDate} [options.stop=new JulianDate()] The stop time of the interval.
    * - {Boolean} [options.isStartIncluded=true] <code>true</code> if <code>options.start</code> is included in the interval, <code>false</code> otherwise.
    * - {Boolean} [options.isStopIncluded=true] <code>true</code> if <code>options.stop</code> is included in the interval, <code>false</code> otherwise.
    * - {Object} [options.data] Arbitrary data associated with this interval.
    *
    * @example
    * // Create an instance that spans August 1st, 1980 and is associated
    * // with a Cartesian position.
    * var timeInterval = new Cesium.TimeInterval({
    * start : Cesium.JulianDate.fromIso8601('1980-08-01T00:00:00Z'),
    * stop : Cesium.JulianDate.fromIso8601('1980-08-02T00:00:00Z'),
    * isStartIncluded : true,
    * isStopIncluded : false,
    * data : Cesium.Cartesian3.fromDegrees(39.921037, -75.170082)
    * });
    * @example
    * // Create two instances from ISO 8601 intervals with associated numeric data
    * // then compute their intersection, summing the data they contain.
    * var left = Cesium.TimeInterval.fromIso8601({
    * iso8601 : '2000/2010',
    * data : 2
    * });
    *
    * var right = Cesium.TimeInterval.fromIso8601({
    * iso8601 : '1995/2005',
    * data : 3
    * });
    *
    * //The result of the below intersection will be an interval equivalent to
    * //var intersection = Cesium.TimeInterval.fromIso8601({
    * //  iso8601 : '2000/2005',
    * //  data : 5
    * //});
    * var intersection = new Cesium.TimeInterval();
    * Cesium.TimeInterval.intersect(left, right, intersection, function(leftData, rightData) {
    * return leftData + rightData;
    * });
    * @example
    * // Check if an interval contains a specific time.
    * var dateToCheck = Cesium.JulianDate.fromIso8601('1982-09-08T11:30:00Z');
    * var containsDate = Cesium.TimeInterval.contains(timeInterval, dateToCheck);
    */
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

  /**
    * A non-overlapping collection of [[TimeInterval]] instances sorted by start time.
    * alias TimeIntervalCollection
    *
    *
    * - {TimeInterval[]} [intervals] An array of intervals to add to the collection.
    */
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

  /**
    * An affine transformation defined by a translation, rotation, and scale.
    * alias TranslationRotationScale
    *
    *
    * - {Cartesian3} [translation=Cartesian3.ZERO] A [[Cartesian3]] specifying the (x, y, z) translation to apply to the node.
    * - {Quaternion} [rotation=Quaternion.IDENTITY] A [[Quaternion]] specifying the (x, y, z, w) rotation to apply to the node.
    * - {Cartesian3} [scale=new Cartesian3(1.0, 1.0, 1.0)] A [[Cartesian3]] specifying the (x, y, z) scaling to apply to the node.
    */
  @js.native
  @JSName("Cesium.TranslationRotationScale")
  class TranslationRotationScale protected() extends js.Object {
    def this(translation: Cartesian3 = ???, rotation: Quaternion = ???, scale: Cartesian3 = ???) = this()

    var translation: Cartesian3 = js.native
    var rotation: Quaternion = js.native
    var scale: Cartesian3 = js.native

    def equals(right: TranslationRotationScale = ???): Boolean = js.native
  }

  /**
    * A [[TerrainProvider]] that produces terrain geometry by tessellating height maps
    * retrieved from a [[http://vr-theworld.com/|VT MÄK VR-TheWorld server]].
    *
    * alias VRTheWorldTerrainProvider
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {String} options.url The URL of the VR-TheWorld TileMap.
    * - {Object} [options.proxy] A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL, if needed.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid.  If this parameter is not
    * specified, the WGS84 ellipsoid is used.
    * - {Credit|String} [options.credit] A credit for the data source, which is displayed on the canvas.
    *
    * @example
    * var terrainProvider = new Cesium.VRTheWorldTerrainProvider({
    * url : 'https://www.vr-theworld.com/vr-theworld/tiles1.0.0/73/'
    * });
    * viewer.terrainProvider = terrainProvider;
    * @see TerrainProvider
    */
  @js.native
  @JSName("Cesium.VRTheWorldTerrainProvider")
  class VRTheWorldTerrainProvider protected() extends TerrainProvider {
    def this(options: VRTheWorldTerrainProviderOptions) = this()
  }

  /**
    * A vertex format defines what attributes make up a vertex.  A VertexFormat can be provided
    * to a [[Geometry]] to request that certain properties be computed, e.g., just position,
    * position and normal, etc.
    *
    * - {Object} [options] An object with boolean properties corresponding to VertexFormat properties as shown in the code example.
    *
    * alias VertexFormat
    *
    * @example
    * // Create a vertex format with position and 2D texture coordinate attributes.
    * var format = new Cesium.VertexFormat({
    * position : true,
    * st : true
    * });
    * @see Geometry#attributes
    * @see Packable
    */
  @js.native
  @JSName("Cesium.VertexFormat")
  class VertexFormat protected() extends Packable {
    def this(options: VertexFormatOptions = ???) = this()

    var position: Boolean = js.native
    var normal: Boolean = js.native
    var st: Boolean = js.native
    var bitangent: Boolean = js.native
    var tangent: Boolean = js.native
    var color: Boolean = js.native
  }

  @js.native
  @JSName("Cesium.VertexFormat")
  object VertexFormat extends PackableStatic {
    var POSITION_ONLY: VertexFormat = js.native
    var POSITION_AND_NORMAL: VertexFormat = js.native
    var POSITION_NORMAL_AND_ST: VertexFormat = js.native
    var POSITION_AND_ST: VertexFormat = js.native
    var POSITION_AND_COLOR: VertexFormat = js.native
    var ALL: VertexFormat = js.native
    var DEFAULT: VertexFormat = js.native

    def clone(cartesian: VertexFormat, result: VertexFormat = ???): VertexFormat = js.native
  }

  /**
    * Synchronizes a video element with a simulation clock.
    *
    * alias VideoSynchronizer
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Clock} [options.clock] The clock instance used to drive the video.
    * - {HTMLVideoElement} [options.element] The video element to be synchronized.
    * - {JulianDate} [options.epoch=Iso8601.MINIMUM_VALUE] The simulation time that marks the start of the video.
    * - {Number} [options.tolerance=1.0] The maximum amount of time, in seconds, that the clock and video can diverge.
    *
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Video.html|Video Material Demo]]
    */
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

  /**
    * A description of a wall, which is similar to a KML line string. A wall is defined by a series of points,
    * which extrude down to the ground. Optionally, they can extrude downwards to a specified height.
    *
    * alias WallGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3[]} options.positions An array of Cartesian objects, which are the points of the wall.
    * - {Number} [options.granularity=CesiumMath.RADIANS_PER_DEGREE] The distance, in radians, between each latitude and longitude. Determines the number of positions in the buffer.
    * - {Number[]} [options.maximumHeights] An array parallel to <code>positions</code> that give the maximum height of the
    * wall at <code>positions</code>. If undefined, the height of each position in used.
    * - {Number[]} [options.minimumHeights] An array parallel to <code>positions</code> that give the minimum height of the
    * wall at <code>positions</code>. If undefined, the height at each position is 0.0.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid for coordinate manipulation
    * - {VertexFormat} [options.vertexFormat=VertexFormat.DEFAULT] The vertex attributes to be computed.
    *
    * exception {DeveloperError} positions length must be greater than or equal to 2.
    * exception {DeveloperError} positions and maximumHeights must have the same length.
    * exception {DeveloperError} positions and minimumHeights must have the same length.
    *
    * @see WallGeometry#createGeometry
    * @see WallGeometry#fromConstantHeight
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Wall.html|Cesium Sandcastle Wall Demo]]
    * @example
    * // create a wall that spans from ground level to 10000 meters
    * var wall = new Cesium.WallGeometry({
    * positions : Cesium.Cartesian3.fromDegreesArrayHeights([
    * 19.0, 47.0, 10000.0,
    * 19.0, 48.0, 10000.0,
    * 20.0, 48.0, 10000.0,
    * 20.0, 47.0, 10000.0,
    * 19.0, 47.0, 10000.0
    * ])
    * });
    * var geometry = Cesium.WallGeometry.createGeometry(wall);
    */
  @js.native
  @JSName("Cesium.WallGeometry")
  class WallGeometry protected() extends js.Object {
    def this(options: WallGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.WallGeometry")
  object WallGeometry extends js.Object {
    def pack(value: WallGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: WallGeometry = ???): WallGeometry = js.native

    def fromConstantHeights(options: ConstantHeightsOptions): WallGeometry = js.native

    def createGeometry(wallGeometry: WallGeometry): Geometry | Unit = js.native
  }

  /**
    * A description of a wall outline. A wall is defined by a series of points,
    * which extrude down to the ground. Optionally, they can extrude downwards to a specified height.
    *
    * alias WallOutlineGeometry
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Cartesian3[]} options.positions An array of Cartesian objects, which are the points of the wall.
    * - {Number} [options.granularity=CesiumMath.RADIANS_PER_DEGREE] The distance, in radians, between each latitude and longitude. Determines the number of positions in the buffer.
    * - {Number[]} [options.maximumHeights] An array parallel to <code>positions</code> that give the maximum height of the
    * wall at <code>positions</code>. If undefined, the height of each position in used.
    * - {Number[]} [options.minimumHeights] An array parallel to <code>positions</code> that give the minimum height of the
    * wall at <code>positions</code>. If undefined, the height at each position is 0.0.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid for coordinate manipulation
    *
    * exception {DeveloperError} positions length must be greater than or equal to 2.
    * exception {DeveloperError} positions and maximumHeights must have the same length.
    * exception {DeveloperError} positions and minimumHeights must have the same length.
    *
    * @see WallGeometry#createGeometry
    * @see WallGeometry#fromConstantHeight
    * @example
    * // create a wall outline that spans from ground level to 10000 meters
    * var wall = new Cesium.WallOutlineGeometry({
    * positions : Cesium.Cartesian3.fromDegreesArrayHeights([
    * 19.0, 47.0, 10000.0,
    * 19.0, 48.0, 10000.0,
    * 20.0, 48.0, 10000.0,
    * 20.0, 47.0, 10000.0,
    * 19.0, 47.0, 10000.0
    * ])
    * });
    * var geometry = Cesium.WallOutlineGeometry.createGeometry(wall);
    */
  @js.native
  @JSName("Cesium.WallOutlineGeometry")
  class WallOutlineGeometry protected() extends js.Object {
    def this(options: WallOutlineGeometryOptions) = this()

    var packedLength: Double = js.native
  }

  @js.native
  @JSName("Cesium.WallOutlineGeometry")
  object WallOutlineGeometry extends js.Object {
    def pack(value: WallOutlineGeometry, array: js.Array[Double], startingIndex: Double = ???): js.Array[Double] = js.native

    def unpack(array: js.Array[Double], startingIndex: Double = ???, result: WallOutlineGeometry = ???): WallOutlineGeometry = js.native

    def fromConstantHeights(options: WallOutlineGeometryOptions): WallOutlineGeometry = js.native

    def createGeometry(wallGeometry: WallOutlineGeometry): Geometry | Unit = js.native
  }

  /**
    * The map projection used by Google Maps, Bing Maps, and most of ArcGIS Online, EPSG:3857.  This
    * projection use longitude and latitude expressed with the WGS84 and transforms them to Mercator using
    * the spherical (rather than ellipsoidal) equations.
    *
    * alias WebMercatorProjection
    *
    *
    * - {Ellipsoid} [ellipsoid=Ellipsoid.WGS84] The ellipsoid.
    *
    * @see GeographicProjection
    */
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

  /**
    * A tiling scheme for geometry referenced to a [[WebMercatorProjection]], EPSG:3857.  This is
    * the tiling scheme used by Google Maps, Microsoft Bing Maps, and most of ESRI ArcGIS Online.
    *
    * alias WebMercatorTilingScheme
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.WGS84] The ellipsoid whose surface is being tiled. Defaults to
    * the WGS84 ellipsoid.
    * - {Number} [options.numberOfLevelZeroTilesX=1] The number of tiles in the X direction at level zero of
    * the tile tree.
    * - {Number} [options.numberOfLevelZeroTilesY=1] The number of tiles in the Y direction at level zero of
    * the tile tree.
    * - {Cartesian2} [options.rectangleSouthwestInMeters] The southwest corner of the rectangle covered by the
    * tiling scheme, in meters.  If this parameter or rectangleNortheastInMeters is not specified, the entire
    * globe is covered in the longitude direction and an equal distance is covered in the latitude
    * direction, resulting in a square projection.
    * - {Cartesian2} [options.rectangleNortheastInMeters] The northeast corner of the rectangle covered by the
    * tiling scheme, in meters.  If this parameter or rectangleSouthwestInMeters is not specified, the entire
    * globe is covered in the longitude direction and an equal distance is covered in the latitude
    * direction, resulting in a square projection.
    */
  @js.native
  @JSName("Cesium.WebMercatorTilingScheme")
  class WebMercatorTilingScheme protected() extends TilingScheme {
    def this(options: WebMercatorTilingSchemeOptions) = this()
  }

  //------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------
  /**
    * Describes a two dimensional icon located at the position of the containing [[Entity]].
    * <p>
    * <div align='center'>
    * <img src='images/Billboard.png' width='400' height='300' /><br />
    * Example billboards
    * </div>
    * </p>
    *
    * alias BillboardGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.image] A Property specifying the Image, URI, or Canvas to use for the billboard.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the billboard.
    * - {Property} [options.scale=1.0] A numeric Property specifying the scale to apply to the image size.
    * - {Property} [options.horizontalOrigin=HorizontalOrigin.CENTER] A Property specifying the [[HorizontalOrigin]].
    * - {Property} [options.verticalOrigin=VerticalOrigin.CENTER] A Property specifying the [[VerticalOrigin]].
    * - {Property} [options.eyeOffset=Cartesian3.ZERO] A [[Cartesian3]] Property specifying the eye offset.
    * - {Property} [options.pixelOffset=Cartesian2.ZERO] A [[Cartesian2]] Property specifying the pixel offset.
    * - {Property} [options.rotation=0] A numeric Property specifying the rotation about the alignedAxis.
    * - {Property} [options.alignedAxis=Cartesian3.ZERO] A [[Cartesian3]] Property specifying the axis of rotation.
    * - {Property} [options.width] A numeric Property specifying the width of the billboard in pixels, overriding the native size.
    * - {Property} [options.height] A numeric Property specifying the height of the billboard in pixels, overriding the native size.
    * - {Property} [options.color=Color.WHITE] A Property specifying the tint [[Color]] of the image.
    * - {Property} [options.scaleByDistance] A [[NearFarScalar]] Property used to scale the point based on distance from the camera.
    * - {Property} [options.translucencyByDistance] A [[NearFarScalar]] Property used to set translucency based on distance from the camera.
    * - {Property} [options.pixelOffsetScaleByDistance] A [[NearFarScalar]] Property used to set pixelOffset based on distance from the camera.
    * - {Property} [options.imageSubRegion] A Property specifying a [[BoundingRectangle]] that defines a sub-region of the image to use for the billboard, rather than the entire image.
    * - {Property} [options.sizeInMeters] A boolean Property specifying whether this billboard's size should be measured in meters.
    *
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Billboards.html|Cesium Sandcastle Billboard Demo]]
    */
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
    var distanceDisplayCondition: Property = js.native

    def clone(result: BillboardGraphics = ???): BillboardGraphics = js.native

    def merge(source: BillboardGraphics): js.Dynamic = js.native
  }

  /**
    * A [[Visualizer]] which maps [[Entity#billboard]] to a [[Billboard]]
    * alias BillboardVisualizer
    *
    *
    * - {Scene} scene The scene the primitives will be rendered in.
    * - {EntityCollection} entityCollection The entityCollection to visualize.
    */
  @js.native
  @JSName("Cesium.BillboardVisualizer")
  class BillboardVisualizer protected() extends Visualizer {
    def this(entityCluster: EntityCluster, entityCollection: EntityCollection) = this()
  }

  /**
    * A [[GeometryUpdater]] for boxes.
    * Clients do not normally create this class directly, but instead rely on [[DataSourceDisplay]]
    * alias BoxGeometryUpdater
    *
    *
    * - {Entity} entity The entity containing the geometry to be visualized.
    * - {Scene} scene The scene where visualization is taking place.
    */
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

  /**
    * Describes a box. The center position and orientation are determined by the containing [[Entity]]
    *
    * alias BoxGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.dimensions] A [[Cartesian3]] Property specifying the length, width, and height of the box.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the box.
    * - {Property} [options.fill=true] A boolean Property specifying whether the box is filled with the provided material.
    * - {MaterialProperty} [options.material=Color.WHITE] A Property specifying the material used to fill the box.
    * - {Property} [options.outline=false] A boolean Property specifying whether the box is outlined.
    * - {Property} [options.outlineColor=Color.BLACK] A Property specifying the [[Color]] of the outline.
    * - {Property} [options.outlineWidth=1.0] A numeric Property specifying the width of the outline.
    *
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Box.html|Cesium Sandcastle Box Demo]]
    */
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
    var distanceDisplayCondition: Property = js.native

    def clone(result: BoxGraphics = ???): BoxGraphics = js.native

    def merge(source: BoxGraphics): js.Dynamic = js.native
  }

  @JSName("Cesium.CallbackProperty")
  @js.native
  object CallbackProperty extends js.Object {
    type Callback = js.Function2[JulianDate, js.Any, Any]
  }

  /**
    * A [[Property]] whose value is lazily evaluated by a callback function.
    *
    * alias CallbackProperty
    *
    *
    * - {CallbackProperty~Callback]] callback The function to be called when the property is evaluated.
    * - {Boolean]] isConstant <code>true</code> when the callback function returns the same value every time, <code>false</code> if the value will change.
    */
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

  /**
    * A [[MaterialProperty]] that maps to checkerboard [[Material]] uniforms.
    * alias CheckerboardMaterialProperty
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.evenColor=Color.WHITE] A Property specifying the first [[Color]]
    * - {Property} [options.oddColor=Color.BLACK] A Property specifying the second [[Color]]
    * - {Property} [options.repeat=new Cartesian2(2.0, 2.0)] A [[Cartesian2]] Property specifying how many times the tiles repeat in each direction.
    */
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

  /**
    * A [[MaterialProperty]] that maps to solid color [[Material]] uniforms.
    *
    * - {Property} [color=Color.WHITE] The [[Color]] Property to be used.
    *
    * alias ColorMaterialProperty
    *
    */
  @js.native
  @JSName("Cesium.ColorMaterialProperty")
  class ColorMaterialProperty protected() extends MaterialProperty {
    def this(color: Property = ???) = this()

    var color: Property = js.native
  }

  /**
    * Non-destructively composites multiple [[EntityCollection]] instances into a single collection.
    * If a Entity with the same ID exists in multiple collections, it is non-destructively
    * merged into a single new entity instance.  If an entity has the same property in multiple
    * collections, the property of the Entity in the last collection of the list it
    * belongs to is used.  CompositeEntityCollection can be used almost anywhere that a
    * EntityCollection is used.
    *
    * alias CompositeEntityCollection
    *
    *
    * - {EntityCollection[]} [collections] The initial list of EntityCollection instances to merge.
    * - {DataSource|CompositeEntityCollection} [owner] The data source (or composite entity collection) which created this collection.
    */
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

  /**
    * A [[CompositeProperty]] which is also a [[MaterialProperty]]
    *
    * alias CompositeMaterialProperty
    *
    */
  @js.native
  @JSName("Cesium.CompositeMaterialProperty")
  class CompositeMaterialProperty() extends MaterialProperty {
    var intervals: TimeIntervalCollection = js.native
  }

  /**
    * A [[CompositeProperty]] which is also a [[PositionProperty]]
    *
    * alias CompositePositionProperty
    *
    *
    * - {ReferenceFrame} [referenceFrame=ReferenceFrame.FIXED] The reference frame in which the position is defined.
    */
  @js.native
  @JSName("Cesium.CompositePositionProperty")
  class CompositePositionProperty protected() extends PositionProperty {
    def this(referenceFrame: ReferenceFrame = ???) = this()

    var intervals: TimeIntervalCollection = js.native
  }

  /**
    * A [[Property]] which is defined by a [[TimeIntervalCollection]], where the
    * data property of each [[TimeInterval]] is another Property instance which is
    * evaluated at the provided time.
    *
    * alias CompositeProperty
    *
    * @example
    * var constantProperty = ...;
    * var sampledProperty = ...;
    *
    * //Create a composite property from two previously defined properties
    * //where the property is valid on August 1st, 2012 and uses a constant
    * //property for the first half of the day and a sampled property for the
    * //remaining half.
    * var composite = new Cesium.CompositeProperty();
    * composite.intervals.addInterval(Cesium.TimeInterval.fromIso8601({
    * iso8601 : '2012-08-01T00:00:00.00Z/2012-08-01T12:00:00.00Z',
    * data : constantProperty
    * }));
    * composite.intervals.addInterval(Cesium.TimeInterval.fromIso8601({
    * iso8601 : '2012-08-01T12:00:00.00Z/2012-08-02T00:00:00.00Z',
    * isStartIncluded : false,
    * isStopIncluded : false,
    * data : sampledProperty
    * }));
    * @see CompositeMaterialProperty
    * @see CompositePositionProperty
    */
  @js.native
  @JSName("Cesium.CompositeProperty")
  class CompositeProperty extends Property {
    var intervals: TimeIntervalCollection = js.native
  }

  /**
    * A [[PositionProperty]] whose value does not change in respect to the
    * [[ReferenceFrame]] in which is it defined.
    *
    * alias ConstantPositionProperty
    *
    *
    * - {Cartesian3} [value] The property value.
    * - {ReferenceFrame} [referenceFrame=ReferenceFrame.FIXED] The reference frame in which the position is defined.
    */
  @js.native
  @JSName("Cesium.ConstantPositionProperty")
  class ConstantPositionProperty protected() extends PositionProperty {
    def this(value: Cartesian3 = ???, referenceFrame: ReferenceFrame = ???) = this()

    def setValue(value: Cartesian3, referenceFrame: ReferenceFrame = ???): js.Dynamic = js.native
  }

  /**
    * A [[Property]] whose value does not change with respect to simulation time.
    *
    * alias ConstantProperty
    *
    *
    * - {Object} [value] The property value.
    *
    * @see ConstantPositionProperty
    *
    *      exception {DeveloperError} value.clone is a required function.
    *      exception {DeveloperError} value.equals is a required function.
    */
  @js.native
  @JSName("Cesium.ConstantProperty")
  class ConstantProperty protected() extends Property {
    def this(value: js.Any = ???) = this()

    def setValue(value: js.Any): js.Dynamic = js.native
  }

  /**
    * A [[GeometryUpdater]] for corridors.
    * Clients do not normally create this class directly, but instead rely on [[DataSourceDisplay]]
    * alias CorridorGeometryUpdater
    *
    *
    * - {Entity} entity The entity containing the geometry to be visualized.
    * - {Scene} scene The scene where visualization is taking place.
    */
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

  /**
    * Describes a corridor, which is a shape defined by a centerline and width that
    * conforms to the curvature of the globe. It can be placed on the surface or at altitude
    * and can optionally be extruded into a volume.
    *
    * alias CorridorGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.positions] A Property specifying the array of [[Cartesian3]] positions that define the centerline of the corridor.
    * - {Property} [options.width] A numeric Property specifying the distance between the edges of the corridor.
    * - {Property} [options.cornerType=CornerType.ROUNDED] A [[CornerType]] Property specifying the style of the corners.
    * - {Property} [options.height=0] A numeric Property specifying the altitude of the corridor relative to the ellipsoid surface.
    * - {Property} [options.extrudedHeight] A numeric Property specifying the altitude of the corridor's extruded face relative to the ellipsoid surface.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the corridor.
    * - {Property} [options.fill=true] A boolean Property specifying whether the corridor is filled with the provided material.
    * - {MaterialProperty} [options.material=Color.WHITE] A Property specifying the material used to fill the corridor.
    * - {Property} [options.outline=false] A boolean Property specifying whether the corridor is outlined.
    * - {Property} [options.outlineColor=Color.BLACK] A Property specifying the [[Color]] of the outline.
    * - {Property} [options.outlineWidth=1.0] A numeric Property specifying the width of the outline.
    * - {Property} [options.granularity=Cesium.Math.RADIANS_PER_DEGREE] A numeric Property specifying the distance between each latitude and longitude.
    *
    * @see Entity
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Corridor.html|Cesium Sandcastle Corridor Demo]]
    */
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
    var distanceDisplayCondition: Property = js.native

    def clone(result: CorridorGraphics = ???): CorridorGraphics = js.native

    def merge(source: CorridorGraphics): js.Dynamic = js.native
  }

  /**
    * A [[DataSource]] implementation which can be used to manually manage a group of entities.
    *
    * alias CustomDataSource
    *
    *
    * - {String} [name] A human-readable name for this instance.
    *
    * @example
    * var dataSource = new Cesium.CustomDataSource('myData');
    *
    * var entity = dataSource.entities.add({
    * position : Cesium.Cartesian3.fromDegrees(1, 2, 0),
    * billboard : {
    * image : 'image.png'
    * }
    * });
    *
    * viewer.dataSources.add(dataSource);
    */
  @js.native
  @JSName("Cesium.CustomDataSource")
  class CustomDataSource protected() extends DataSource {
    def this(name: String = ???) = this()
  }

  /**
    * A [[GeometryUpdater]] for cylinders.
    * Clients do not normally create this class directly, but instead rely on [[DataSourceDisplay]]
    * alias CylinderGeometryUpdater
    *
    *
    * - {Entity} entity The entity containing the geometry to be visualized.
    * - {Scene} scene The scene where visualization is taking place.
    */
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

  /**
    * Describes a cylinder, truncated cone, or cone defined by a length, top radius, and bottom radius.
    * The center position and orientation are determined by the containing [[Entity]]
    *
    * alias CylinderGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.length] A numeric Property specifying the length of the cylinder.
    * - {Property} [options.topRadius] A numeric Property specifying the radius of the top of the cylinder.
    * - {Property} [options.bottomRadius] A numeric Property specifying the radius of the bottom of the cylinder.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the cylinder.
    * - {Property} [options.fill=true] A boolean Property specifying whether the cylinder is filled with the provided material.
    * - {MaterialProperty} [options.material=Color.WHITE] A Property specifying the material used to fill the cylinder.
    * - {Property} [options.outline=false] A boolean Property specifying whether the cylinder is outlined.
    * - {Property} [options.outlineColor=Color.BLACK] A Property specifying the [[Color]] of the outline.
    * - {Property} [options.outlineWidth=1.0] A numeric Property specifying the width of the outline.
    * - {Property} [options.numberOfVerticalLines=16] A numeric Property specifying the number of vertical lines to draw along the perimeter for the outline.
    * - {Property} [options.slices=128] The number of edges around perimeter of the cylinder.
    *
    */
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
    var distanceDisplayCondition: Property = js.native

    def clone(result: CylinderGraphics = ???): CylinderGraphics = js.native

    def merge(source: CylinderGraphics): js.Dynamic = js.native
  }

  /**
    * A [[DataSource]] which processes [[https://github.com/AnalyticalGraphicsInc/cesium/wiki/CZML-Guide|CZML]]
    * alias CzmlDataSource
    *
    *
    * - {String} [name] An optional name for the data source.  This value will be overwritten if a loaded document contains a name.
    *
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=CZML.html|Cesium Sandcastle CZML Demo]]
    */
  @js.native
  @JSName("Cesium.CzmlDataSource")
  class CzmlDataSource protected() extends DataSource {
    def this(name: String = ???) = this()

    def process(czml: String | js.Any, options: CzmlDataSourceOptions = ???): Promise[CzmlDataSource] = js.native

    def load(czml: String | js.Any, options: CzmlDataSourceOptions = ???): Promise[CzmlDataSource] = js.native
  }

  @js.native
  @JSName("Cesium.CzmlDataSource")
  object CzmlDataSource extends js.Object {
    var updaters: js.Array[js.Any] = js.native

    def load(data: String | js.Any, options: CzmlDataSourceOptions = ???): Promise[CzmlDataSource] = js.native

    def processPacketData(`type`: js.Function, `object`: js.Any, propertyName: String, packetData: js.Any, interval: TimeInterval, sourceUri: String, entityCollection: EntityCollection): js.Dynamic = js.native

    def processPositionPacketData(`object`: js.Any, propertyName: String, packetData: js.Any, interval: TimeInterval, sourceUri: String, entityCollection: EntityCollection): js.Dynamic = js.native

    def processMaterialPacketData(`object`: js.Any, propertyName: String, packetData: js.Any, interval: TimeInterval, sourceUri: String, entityCollection: EntityCollection): js.Dynamic = js.native
  }

  /**
    * Represents CZML document-level clock settings.
    *
    * alias DataSourceClock
    *
    */
  @js.native
  @JSName("Cesium.DataSourceClock")
  class DataSourceClock() extends js.Object {
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

  /**
    * A collection of [[DataSource]] instances.
    * alias DataSourceCollection
    *
    */
  @js.native
  @JSName("Cesium.DataSourceCollection")
  class DataSourceCollection() extends js.Object {
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

  /**
    * Visualizes a collection of [[DataSource]] instances.
    * alias DataSourceDisplay
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Scene} options.scene The scene in which to display the data.
    * - {DataSourceCollection} options.dataSourceCollection The data sources to display.
    * - {DataSourceDisplay~VisualizersCallback} [options.visualizersCallback=DataSourceDisplay.defaultVisualizersCallback]
    * A function which creates an array of visualizers used for visualization.
    * If undefined, all standard visualizers are used.
    */
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

  /**
    * Defines the interface for a dynamic geometry updater.  A DynamicGeometryUpdater
    * is responsible for handling visualization of a specific type of geometry
    * that needs to be recomputed based on simulation time.
    * This object is never used directly by client code, but is instead created by
    * [[GeometryUpdater]] implementations which contain dynamic geometry.
    *
    * This type defines an interface and cannot be instantiated directly.
    *
    * alias DynamicGeometryUpdater
    *
    */
  @js.native
  trait DynamicGeometryUpdater extends js.Object {
    def update(time: JulianDate): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  /**
    * A [[GeometryUpdater]] for ellipses.
    * Clients do not normally create this class directly, but instead rely on [[DataSourceDisplay]]
    * alias EllipseGeometryUpdater
    *
    *
    * - {Entity} entity The entity containing the geometry to be visualized.
    * - {Scene} scene The scene where visualization is taking place.
    */
  @js.native
  @JSName("Cesium.EllipseGeometryUpdater")
  class EllipseGeometryUpdater protected() extends GeometryUpdater {
    def this(entity: Entity, scene: Scene) = this()
  }

  @js.native
  @JSName("Cesium.EllipseGeometryUpdater")
  object EllipseGeometryUpdater extends GeometryUpdaterStatic

  /**
    * Describes an ellipse defined by a center point and semi-major and semi-minor axes.
    * The ellipse conforms to the curvature of the globe and can be placed on the surface or
    * at altitude and can optionally be extruded into a volume.
    * The center point is determined by the containing [[Entity]]
    *
    * alias EllipseGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.semiMajorAxis] The numeric Property specifying the semi-major axis.
    * - {Property} [options.semiMinorAxis] The numeric Property specifying the semi-minor axis.
    * - {Property} [options.height=0] A numeric Property specifying the altitude of the ellipse relative to the ellipsoid surface.
    * - {Property} [options.extrudedHeight] A numeric Property specifying the altitude of the ellipse's extruded face relative to the ellipsoid surface.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the ellipse.
    * - {Property} [options.fill=true] A boolean Property specifying whether the ellipse is filled with the provided material.
    * - {MaterialProperty} [options.material=Color.WHITE] A Property specifying the material used to fill the ellipse.
    * - {Property} [options.outline=false] A boolean Property specifying whether the ellipse is outlined.
    * - {Property} [options.outlineColor=Color.BLACK] A Property specifying the [[Color]] of the outline.
    * - {Property} [options.outlineWidth=1.0] A numeric Property specifying the width of the outline.
    * - {Property} [options.numberOfVerticalLines=16] A numeric Property specifying the number of vertical lines to draw along the perimeter for the outline.
    * - {Property} [options.rotation=0.0] A numeric property specifying the rotation of the ellipse counter-clockwise from north.
    * - {Property} [options.stRotation=0.0] A numeric property specifying the rotation of the ellipse texture counter-clockwise from north.
    * - {Property} [options.granularity=Cesium.Math.RADIANS_PER_DEGREE] A numeric Property specifying the angular distance between points on the ellipse.
    *
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Circles and Ellipses.html|Cesium Sandcastle Circles and Ellipses Demo]]
    */
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
    var distanceDisplayCondition: Property = js.native

    def clone(result: EllipseGraphics = ???): EllipseGraphics = js.native

    def merge(source: EllipseGraphics): js.Dynamic = js.native
  }

  /**
    * A [[GeometryUpdater]] for ellipsoids.
    * Clients do not normally create this class directly, but instead rely on [[DataSourceDisplay]]
    * alias EllipsoidGeometryUpdater
    *
    *
    * - {Entity} entity The entity containing the geometry to be visualized.
    * - {Scene} scene The scene where visualization is taking place.
    */
  @js.native
  @JSName("Cesium.EllipsoidGeometryUpdater")
  class EllipsoidGeometryUpdater protected() extends GeometryUpdater {
    def this(entity: Entity, scene: Scene) = this()
  }

  @js.native
  @JSName("Cesium.EllipsoidGeometryUpdater")
  object EllipsoidGeometryUpdater extends GeometryUpdaterStatic

  /**
    * Describe an ellipsoid or sphere.  The center position and orientation are determined by the containing [[Entity]]
    *
    * alias EllipsoidGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.radii] A [[Cartesian3]] Property specifying the radii of the ellipsoid.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the ellipsoid.
    * - {Property} [options.fill=true] A boolean Property specifying whether the ellipsoid is filled with the provided material.
    * - {MaterialProperty} [options.material=Color.WHITE] A Property specifying the material used to fill the ellipsoid.
    * - {Property} [options.outline=false] A boolean Property specifying whether the ellipsoid is outlined.
    * - {Property} [options.outlineColor=Color.BLACK] A Property specifying the [[Color]] of the outline.
    * - {Property} [options.outlineWidth=1.0] A numeric Property specifying the width of the outline.
    * - {Property} [options.subdivisions=128] A Property specifying the number of samples per outline ring, determining the granularity of the curvature.
    * - {Property} [options.stackPartitions=64] A Property specifying the number of stacks.
    * - {Property} [options.slicePartitions=64] A Property specifying the number of radial slices.
    *
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Spheres%20and%20Ellipsoids.html|Cesium Sandcastle Spheres and Ellipsoids Demo]]
    */
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
    var distanceDisplayCondition: Property = js.native

    def clone(result: EllipsoidGraphics = ???): EllipsoidGraphics = js.native

    def merge(source: EllipsoidGraphics): js.Dynamic = js.native
  }

  /**
    * Entity instances aggregate multiple forms of visualization into a single high-level object.
    * They can be created manually and added to [[Viewer#entities]] or be produced by
    * data sources, such as [[CzmlDataSource]] and [[GeoJsonDataSource]]
    * alias Entity
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {String} [options.id] A unique identifier for this object. If none is provided, a GUID is generated.
    * - {String} [options.name] A human readable name to display to users. It does not have to be unique.
    * - {TimeIntervalCollection} [options.availability] The availability, if any, associated with this object.
    * - {Boolean} [options.show] A boolean value indicating if the entity and its children are displayed.
    * - {Property} [options.description] A string Property specifying an HTML description for this entity.
    * - {PositionProperty} [options.position] A Property specifying the entity position.
    * - {Property} [options.orientation] A Property specifying the entity orientation.
    * - {Property} [options.viewFrom] A suggested initial offset for viewing this object.
    * - {Entity} [options.parent] A parent entity to associate with this entity.
    * - {BillboardGraphics} [options.billboard] A billboard to associate with this entity.
    * - {BoxGraphics} [options.box] A box to associate with this entity.
    * - {CorridorGraphics} [options.corridor] A corridor to associate with this entity.
    * - {CylinderGraphics} [options.cylinder] A cylinder to associate with this entity.
    * - {EllipseGraphics} [options.ellipse] A ellipse to associate with this entity.
    * - {EllipsoidGraphics} [options.ellipsoid] A ellipsoid to associate with this entity.
    * - {LabelGraphics} [options.label] A options.label to associate with this entity.
    * - {ModelGraphics} [options.model] A model to associate with this entity.
    * - {PathGraphics} [options.path] A path to associate with this entity.
    * - {PointGraphics} [options.point] A point to associate with this entity.
    * - {PolygonGraphics} [options.polygon] A polygon to associate with this entity.
    * - {PolylineGraphics} [options.polyline] A polyline to associate with this entity.
    * - {PolylineVolumeGraphics} [options.polylineVolume] A polylineVolume to associate with this entity.
    * - {RectangleGraphics} [options.rectangle] A rectangle to associate with this entity.
    * - {WallGraphics} [options.wall] A wall to associate with this entity.
    *
    * @see [[http://cesiumjs.org/2015/02/02/Visualizing-Spatial-Data/|Visualizing Spatial Data]]
    */
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

  /**
    * An observable collection of [[Entity]] instances where each entity has a unique id.
    * alias EntityCollection
    *
    *
    * - {DataSource|CompositeEntityCollection} [owner] The data source (or composite entity collection) which created this collection.
    */
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

  /**
    * A utility object for tracking an entity with the camera.
    * alias EntityView
    *
    *
    * - {Entity} entity The entity to track with the camera.
    * - {Scene} scene The scene to use.
    * - {Ellipsoid} [ellipsoid=Ellipsoid.WGS84] The ellipsoid to use for orienting the camera.
    * - {BoundingSphere} [boundingSphere] An initial bounding sphere for setting the default view.
    */
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

  /**
    * A [[DataSource]] which processes both
    * [[http://www.geojson.org/|GeoJSON]] and [[https://github.com/mbostock/topojson|TopoJSON]] data.
    * [[https://github.com/mapbox/simplestyle-spec|simplestyle-spec]] properties will also be used if they
    * are present.
    *
    * alias GeoJsonDataSource
    *
    *
    * - {String} [name] The name of this data source.  If undefined, a name will be taken from
    * the name of the GeoJSON file.
    *
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=GeoJSON%20and%20TopoJSON.html|Cesium Sandcastle GeoJSON and TopoJSON Demo]]
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=GeoJSON%20simplestyle.html|Cesium Sandcastle GeoJSON simplestyle Demo]]
    *
    * @example
    * var viewer = new Cesium.Viewer('cesiumContainer');
    * viewer.dataSources.add(Cesium.GeoJsonDataSource.load('../../SampleData/ne_10m_us_states.topojson', {
    * stroke: Cesium.Color.HOTPINK,
    * fill: Cesium.Color.PINK,
    * strokeWidth: 3,
    * markerSymbol: '?'
    * }));
    */
  @js.native
  @JSName("Cesium.GeoJsonDataSource")
  class GeoJsonDataSource protected() extends DataSource {
    def this(name: String = ???) = this()

    def load(data: String | js.Object, options: GeoJsonDataSourceOptions = ???): Promise[GeoJsonDataSource] = js.native
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
    var clampToGround: Boolean = js.native

    def load(data: String | js.Object, options: GeoJsonDataSourceOptions = ???): Promise[GeoJsonDataSource] = js.native
  }

  /**
    * A general purpose visualizer for geometry represented by [[Primitive]] instances.
    * alias GeometryVisualizer
    *
    *
    * - {GeometryUpdater} type The updater to be used for creating the geometry.
    * - {Scene} scene The scene the primitives will be rendered in.
    * - {EntityCollection} entityCollection The entityCollection to visualize.
    */
  @js.native
  @JSName("Cesium.GeometryVisualizer")
  class GeometryVisualizer protected() extends Visualizer {
    def this(`type`: GeometryUpdater, scene: Scene, entityCollection: EntityCollection) = this()
  }

  /**
    * A [[MaterialProperty]] that maps to grid [[Material]] uniforms.
    * alias GridMaterialProperty
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.color=Color.WHITE] A Property specifying the grid [[Color]]
    * - {Property} [options.cellAlpha=0.1] A numeric Property specifying cell alpha values.
    * - {Property} [options.lineCount=new Cartesian2(8, 8)] A [[Cartesian2]] Property specifying the number of grid lines along each axis.
    * - {Property} [options.lineThickness=new Cartesian2(1.0, 1.0)] A [[Cartesian2]] Property specifying the thickness of grid lines along each axis.
    * - {Property} [options.lineOffset=new Cartesian2(0.0, 0.0)] A [[Cartesian2]] Property specifying starting offset of grid lines along each axis.
    *
    *
    */
  @js.native
  @JSName("Cesium.GridMaterialProperty")
  class GridMaterialProperty protected() extends MaterialProperty {
    def this(options: GridMaterialPropertyOptions) = this()

    var color: Property = js.native
    var cellAlpha: Property = js.native
    var lineCount: Property = js.native
    var lineThickness: Property = js.native
    var lineOffset: Property = js.native
  }

  /**
    * A [[MaterialProperty]] that maps to image [[Material]] uniforms.
    * alias ImageMaterialProperty
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.image] A Property specifying the Image, URL, Canvas, or Video.
    * - {Property} [options.repeat=new Cartesian2(1.0, 1.0)] A [[Cartesian2]] Property specifying the number of times the image repeats in each direction.
    * - {Property} [options.color=Color.WHITE] The color applied to the image
    * - {Property} [options.transparent=false] Set to true when the image has transparency (for example, when a png has transparent sections)
    */
  @js.native
  @JSName("Cesium.ImageMaterialProperty")
  class ImageMaterialProperty protected() extends MaterialProperty {
    def this(options: ImageMaterialPropertyOptions) = this()

    var image: Property = js.native
    var repeat: Property = js.native
    var color: Property = js.native
    var transparent: Property = js.native
  }

  /**
    * A [[DataSource]] which processes Keyhole Markup Language 2.2 (KML).
    * <p>
    * KML support in Cesium is incomplete, but a large amount of the standard,
    * as well as Google's <code>gx</code> extension namespace, is supported. See Github issue
    * [[https://github.com/AnalyticalGraphicsInc/cesium/issues/873|#873} for a
    * detailed list of what is and isn't support. Cesium will also write information to the
    * console when it encounters most unsupported features.
    * </p>
    * <p>
    * Non visual feature data, such as <code>atom:author</code> and <code>ExtendedData</code>
    * is exposed via an instance of [[KmlFeatureData]], which is added to each [[Entity]]
    * under the <code>kml</code> property.
    * </p>
    *
    * alias KmlDataSource
    *
    *
    * - {Camera} options.camera The camera that is used for viewRefreshModes and sending camera properties to network links.
    * - {Canvas} options.canvas The canvas that is used for sending viewer properties to network links.
    * - {DefaultProxy} [options.proxy] A proxy to be used for loading external data.
    *
    * @see [[http://www.opengeospatial.org/standards/kml/|Open Geospatial Consortium KML Standard]]
    * @see [[https://developers.google.com/kml/|Google KML Documentation]]
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=KML.html|Cesium Sandcastle KML Demo]]
    * @example
    * var viewer = new Cesium.Viewer('cesiumContainer');
    * viewer.dataSources.add(Cesium.KmlDataSource.load('../../SampleData/facilities.kmz'),
    * {
    * camera: viewer.scene.camera,
    * canvas: viewer.scene.canvas
    * });
    */
  @js.native
  @JSName("Cesium.KmlDataSource")
  class KmlDataSource protected() extends DataSource {
    def this(options: KmlDataSourceOptions) = this()

    var refreshEvent: Event = js.native
    var unsupportedNodeEvent: Event = js.native

    var camera: Camera = js.native
    var canvas: Canvas = js.native

    def load(data: String | Document | Blob, options: KmlDataSourceOptions = ???): Promise[KmlDataSource] = js.native
  }

  @js.native
  @JSName("Cesium.KmlDataSource")
  object KmlDataSource extends js.Object {
    def load(data: String | Document | Blob, options: KmlDataSourceOptions = ???): Promise[KmlDataSource] = js.native
  }

  /**
    * Contains KML Feature data loaded into the <code>Entity.kml</code> property by [[KmlDataSource]]
    * alias KmlFeatureData
    *
    */
  @js.native
  @JSName("Cesium.KmlFeatureData")
  class KmlFeatureData() extends js.Object {
    var author: js.Any = js.native
    var link: js.Any = js.native
    var address: String = js.native
    var phoneNumber: String = js.native
    var snippet: String = js.native
    var extendedData: String = js.native
  }

  /**
    * Describes a two dimensional label located at the position of the containing [[Entity]]
    * <p>
    * <div align='center'>
    * <img src='images/Label.png' width='400' height='300' /><br />
    * Example labels
    * </div>
    * </p>
    *
    * alias LabelGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.text] A Property specifying the text.
    * - {Property} [options.font='10px sans-serif'] A Property specifying the CSS font.
    * - {Property} [options.style=LabelStyle.FILL] A Property specifying the [[LabelStyle]]
    * - {Property} [options.fillColor=Color.WHITE] A Property specifying the fill [[Color]]
    * - {Property} [options.outlineColor=Color.BLACK] A Property specifying the outline [[Color]]
    * - {Property} [options.outlineWidth=1.0] A numeric Property specifying the outline width.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the label.
    * - {Property} [options.scale=1.0] A numeric Property specifying the scale to apply to the text.
    * - {Property} [options.horizontalOrigin=HorizontalOrigin.CENTER] A Property specifying the [[HorizontalOrigin]]
    * - {Property} [options.verticalOrigin=VerticalOrigin.CENTER] A Property specifying the [[VerticalOrigin]]
    * - {Property} [options.eyeOffset=Cartesian3.ZERO] A [[Cartesian3]] Property specifying the eye offset.
    * - {Property} [options.pixelOffset=Cartesian2.ZERO] A [[Cartesian2]] Property specifying the pixel offset.
    * - {Property} [options.translucencyByDistance] A [[NearFarScalar]] Property used to set translucency based on distance from the camera.
    * - {Property} [options.pixelOffsetScaleByDistance] A [[NearFarScalar]] Property used to set pixelOffset based on distance from the camera.
    *
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Labels.html|Cesium Sandcastle Labels Demo]]
    */
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
    var distanceDisplayCondition: Property = js.native

    var showBackground: Property = js.native
    var backgroundColor: Property = js.native
    var backgroundPadding: Property = js.native

    def clone(result: LabelGraphics = ???): LabelGraphics = js.native

    def merge(source: LabelGraphics): js.Dynamic = js.native
  }

  /**
    * A [[Visualizer]] which maps the [[LabelGraphics]] instance
    * in [[Entity#label]] to a [[Label]]
    * alias LabelVisualizer
    *
    *
    * - {Scene} scene The scene the primitives will be rendered in.
    * - {EntityCollection} entityCollection The entityCollection to visualize.
    */
  @js.native
  @JSName("Cesium.LabelVisualizer")
  class LabelVisualizer protected() extends Visualizer {
    def this(entityCluster: EntityCluster, entityCollection: EntityCollection) = this()
  }

  /**
    * The interface for all [[Property]] objects that represent [[Material]] uniforms.
    * This type defines an interface and cannot be instantiated directly.
    *
    * alias MaterialProperty
    *
    * @see ColorMaterialProperty
    * @see CompositeMaterialProperty
    * @see GridMaterialProperty
    * @see ImageMaterialProperty
    * @see PolylineGlowMaterialProperty
    * @see PolylineOutlineMaterialProperty
    * @see StripeMaterialProperty
    */
  @js.native
  trait MaterialProperty extends js.Object {
    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native

    def getType(time: JulianDate): String = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  /**
    * A 3D model based on [[https://github.com/KhronosGroup/glTF|glTF]], the runtime asset format for WebGL, OpenGL ES, and OpenGL.
    * The position and orientation of the model is determined by the containing [[Entity]]
    * <p>
    * Cesium includes support for glTF geometry, materials, animations, and skinning.
    * Cameras and lights are not currently supported.
    * </p>
    *
    * alias ModelGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.uri] A string Property specifying the URI of the glTF asset.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the model.
    * - {Property} [options.scale=1.0] A numeric Property specifying a uniform linear scale.
    * - {Property} [options.minimumPixelSize=0.0] A numeric Property specifying the approximate minimum pixel size of the model regardless of zoom.
    * - {Property} [options.maximumScale] The maximum scale size of a model. An upper limit for minimumPixelSize.
    * - {Property} [options.incrementallyLoadTextures=true] Determine if textures may continue to stream in after the model is loaded.
    * - {Property} [options.runAnimations=true] A boolean Property specifying if glTF animations specified in the model should be started.
    * - {Property} [options.nodeTransformations] An object, where keys are names of nodes, and values are [[TranslationRotationScale]] Properties describing the transformation to apply to that node.
    *
    * @see [[http://cesiumjs.org/2014/03/03/Cesium-3D-Models-Tutorial/|3D Models Tutorial]]
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=3D%20Models.html|Cesium Sandcastle 3D Models Demo]]
    */
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
    var shadows: Int = js.native
    var distanceDisplayCondition: Property = js.native

    var color: Color = js.native
    var colorBlendMode: ColorBlendMode = js.native
    var colorBlendAmount: Double = js.native

    var silhouetteColor: Color = js.native
    var silhouetteSize: Double = js.native

    def clone(result: ModelGraphics = ???): ModelGraphics = js.native

    def merge(source: ModelGraphics): js.Dynamic = js.native
  }

  /**
    * A [[Visualizer]] which maps [[Entity#model]] to a [[Model]]
    * alias ModelVisualizer
    *
    *
    * - {Scene} scene The scene the primitives will be rendered in.
    * - {EntityCollection} entityCollection The entityCollection to visualize.
    */
  @js.native
  @JSName("Cesium.ModelVisualizer")
  class ModelVisualizer protected() extends Visualizer {
    def this(scene: Scene, entityCollection: EntityCollection) = this()
  }

  /**
    * A [[Property]] that produces [[TranslationRotationScale]] data.
    * alias NodeTransformationProperty
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.translation=Cartesian3.ZERO] A [[Cartesian3]] Property specifying the (x, y, z) translation to apply to the node.
    * - {Property} [options.rotation=Quaternion.IDENTITY] A [[Quaternion]] Property specifying the (x, y, z, w) rotation to apply to the node.
    * - {Property} [options.scale=new Cartesian3(1.0, 1.0, 1.0)] A [[Cartesian3]] Property specifying the (x, y, z) scaling to apply to the node.
    */
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

  /**
    * Describes a polyline defined as the path made by an [[Entity]] as it moves over time.
    *
    * alias PathGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.leadTime] A Property specifying the number of seconds behind the object to show.
    * - {Property} [options.trailTime] A Property specifying the number of seconds in front of the object to show.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the path.
    * - {Property} [options.width=1.0] A numeric Property specifying the width in pixels.
    * - {MaterialProperty} [options.material=Color.WHITE] A Property specifying the material used to draw the path.
    * - {Property} [options.resolution=60] A numeric Property specifying the width in pixels.
    */
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
    var distanceDisplayCondition: Property = js.native

    def clone(result: PathGraphics = ???): PathGraphics = js.native

    def merge(source: PathGraphics): js.Dynamic = js.native
  }

  /**
    * A [[Visualizer]] which maps [[Entity#path]] to a [[Polyline]]
    * alias PathVisualizer
    *
    *
    * - {Scene} scene The scene the primitives will be rendered in.
    * - {EntityCollection} entityCollection The entityCollection to visualize.
    */
  @js.native
  @JSName("Cesium.PathVisualizer")
  class PathVisualizer protected() extends Visualizer {
    def this(scene: Scene, entityCollection: EntityCollection) = this()
  }

  /**
    * Describes a graphical point located at the position of the containing [[Entity]]
    *
    * alias PointGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.color=Color.WHITE] A Property specifying the [[Color]] of the point.
    * - {Property} [options.pixelSize=1] A numeric Property specifying the size in pixels.
    * - {Property} [options.outlineColor=Color.BLACK] A Property specifying the [[Color]] of the outline.
    * - {Property} [options.outlineWidth=0] A numeric Property specifying the the outline width in pixels.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the point.
    * - {Property} [options.scaleByDistance] A [[NearFarScalar]] Property used to scale the point based on distance.
    * - {Property} [options.translucencyByDistance] A [[NearFarScalar]] Property used to set translucency based on distance from the camera.
    */
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

    var heightReference: HeightReference = js.native
    var distanceDisplayCondition: Property = js.native

    def clone(result: PointGraphics = ???): PointGraphics = js.native

    def merge(source: PointGraphics): js.Dynamic = js.native
  }

  /**
    * A [[Visualizer]] which maps [[Entity#point]] to a [[PointPrimitive]]
    * alias PointVisualizer
    *
    *
    * - {Scene} scene The scene the primitives will be rendered in.
    * - {EntityCollection} entityCollection The entityCollection to visualize.
    */
  @js.native
  @JSName("Cesium.PointVisualizer")
  class PointVisualizer protected() extends Visualizer {
    def this(entityCluster: EntityCluster, entityCollection: EntityCollection) = this()
  }

  /**
    * A [[GeometryUpdater]] for polygons.
    * Clients do not normally create this class directly, but instead rely on [[DataSourceDisplay]]
    * alias PolygonGeometryUpdater
    *
    *
    * - {Entity} entity The entity containing the geometry to be visualized.
    * - {Scene} scene The scene where visualization is taking place.
    */
  @js.native
  @JSName("Cesium.PolygonGeometryUpdater")
  class PolygonGeometryUpdater protected() extends GeometryUpdater {
    def this(entity: Entity, scene: Scene) = this()
  }

  @js.native
  @JSName("Cesium.PolygonGeometryUpdater")
  object PolygonGeometryUpdater extends GeometryUpdaterStatic

  /**
    * Describes a polygon defined by an hierarchy of linear rings which make up the outer shape and any nested holes.
    * The polygon conforms to the curvature of the globe and can be placed on the surface or
    * at altitude and can optionally be extruded into a volume.
    *
    * alias PolygonGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.hierarchy] A Property specifying the [[PolygonHierarchy]]
    * - {Property} [options.height=0] A numeric Property specifying the altitude of the polygon relative to the ellipsoid surface.
    * - {Property} [options.extrudedHeight] A numeric Property specifying the altitude of the polygon's extruded face relative to the ellipsoid surface.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the polygon.
    * - {Property} [options.fill=true] A boolean Property specifying whether the polygon is filled with the provided material.
    * - {MaterialProperty} [options.material=Color.WHITE] A Property specifying the material used to fill the polygon.
    * - {Property} [options.outline=false] A boolean Property specifying whether the polygon is outlined.
    * - {Property} [options.outlineColor=Color.BLACK] A Property specifying the [[Color]] of the outline.
    * - {Property} [options.outlineWidth=1.0] A numeric Property specifying the width of the outline.
    * - {Property} [options.stRotation=0.0] A numeric property specifying the rotation of the polygon texture counter-clockwise from north.
    * - {Property} [options.granularity=Cesium.Math.RADIANS_PER_DEGREE] A numeric Property specifying the angular distance between each latitude and longitude point.
    * - {Property} [options.perPositionHeight=false] A boolean specifying whether or not the the height of each position is used.
    * - {Boolean} [options.closeTop=true] When false, leaves off the top of an extruded polygon open.
    * - {Boolean} [options.closeBottom=true] When false, leaves off the bottom of an extruded polygon open.
    *
    * @see Entity
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Polygon.html|Cesium Sandcastle Polygon Demo]]
    */
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
    var distanceDisplayCondition: Property = js.native

    def clone(result: PolygonGraphics = ???): PolygonGraphics = js.native

    def merge(source: PolygonGraphics): js.Dynamic = js.native
  }

  /**
    * A [[MaterialProperty]] that maps to PolylineArrow [[Material]] uniforms.
    *
    * - {Property} [color=Color.WHITE] The [[Color]] Property to be used.
    *
    * alias PolylineArrowMaterialProperty
    *
    */
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

  /**
    * A [[GeometryUpdater]] for polylines.
    * Clients do not normally create this class directly, but instead rely on [[DataSourceDisplay]]
    * alias PolylineGeometryUpdater
    *
    *
    * - {Entity} entity The entity containing the geometry to be visualized.
    * - {Scene} scene The scene where visualization is taking place.
    */
  @js.native
  @JSName("Cesium.PolylineGeometryUpdater")
  class PolylineGeometryUpdater protected() extends GeometryUpdater {
    def this(entity: Entity, scene: Scene) = this()
  }

  @js.native
  @JSName("Cesium.PolylineGeometryUpdater")
  object PolylineGeometryUpdater extends GeometryUpdaterStatic

  /**
    * A [[MaterialProperty]] that maps to polyline glow [[Material]] uniforms.
    * alias PolylineGlowMaterialProperty
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.color=Color.WHITE] A Property specifying the [[Color]] of the line.
    * - {Property} [options.glowPower=0.25] A numeric Property specifying the strength of the glow, as a percentage of the total line width.
    */
  @js.native
  @JSName("Cesium.PolylineGlowMaterialProperty")
  class PolylineGlowMaterialProperty protected() extends MaterialProperty {
    def this(options: PolylineGlowMaterialPropertyOptions) = this()

    var color: Property = js.native
    var glowPower: Property = js.native
  }

  /**
    * Describes a polyline defined as a line strip. The first two positions define a line segment,
    * and each additional position defines a line segment from the previous position. The segments
    * can be linear connected points or great arcs.
    *
    * alias PolylineGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.positions] A Property specifying the array of [[Cartesian3]] positions that define the line strip.
    * - {Property} [options.followSurface=true] A boolean Property specifying whether the line segments should be great arcs or linearly connected.
    * - {Property} [options.width=1.0] A numeric Property specifying the width in pixels.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the polyline.
    * - {MaterialProperty} [options.material=Color.WHITE] A Property specifying the material used to draw the polyline.
    * - {Property} [options.granularity=Cesium.Math.RADIANS_PER_DEGREE] A numeric Property specifying the angular distance between each latitude and longitude if followSurface is true.
    *
    * @see Entity
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Polyline.html|Cesium Sandcastle Polyline Demo]]
    */
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
    var distanceDisplayCondition: Property = js.native

    def clone(result: PolylineGraphics = ???): PolylineGraphics = js.native

    def merge(source: PolylineGraphics): js.Dynamic = js.native
  }

  /**
    * A [[MaterialProperty]] that maps to polyline outline [[Material]] uniforms.
    * alias PolylineOutlineMaterialProperty
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.color=Color.WHITE] A Property specifying the [[Color]] of the line.
    * - {Property} [options.outlineColor=Color.BLACK] A Property specifying the [[Color]] of the outline.
    * - {Property} [options.outlineWidth=1.0] A numeric Property specifying the width of the outline, in pixels.
    */
  @js.native
  @JSName("Cesium.PolylineOutlineMaterialProperty")
  class PolylineOutlineMaterialProperty protected() extends MaterialProperty {
    def this(options: PolylineOutlineMaterialPropertyOptions) = this()

    var color: Property = js.native
    var outlineColor: Property = js.native
    var outlineWidth: Property = js.native
  }

  /**
    * A [[GeometryUpdater]] for polyline volumes.
    * Clients do not normally create this class directly, but instead rely on [[DataSourceDisplay]]
    * alias PolylineVolumeGeometryUpdater
    *
    *
    * - {Entity} entity The entity containing the geometry to be visualized.
    * - {Scene} scene The scene where visualization is taking place.
    */
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

  /**
    * Describes a polyline volume defined as a line strip and corresponding two dimensional shape which is extruded along it.
    * The resulting volume conforms to the curvature of the globe.
    *
    * alias PolylineVolumeGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.positions] A Property specifying the array of [[Cartesian3]] positions which define the line strip.
    * - {Property} [options.shape] A Property specifying the array of [[Cartesian2]] positions which define the shape to be extruded.
    * - {Property} [options.cornerType=CornerType.ROUNDED] A [[CornerType]] Property specifying the style of the corners.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the volume.
    * - {Property} [options.fill=true] A boolean Property specifying whether the volume is filled with the provided material.
    * - {MaterialProperty} [options.material=Color.WHITE] A Property specifying the material used to fill the volume.
    * - {Property} [options.outline=false] A boolean Property specifying whether the volume is outlined.
    * - {Property} [options.outlineColor=Color.BLACK] A Property specifying the [[Color]] of the outline.
    * - {Property} [options.outlineWidth=1.0] A numeric Property specifying the width of the outline.
    * - {Property} [options.granularity=Cesium.Math.RADIANS_PER_DEGREE] A numeric Property specifying the angular distance between each latitude and longitude point.
    *
    * @see Entity
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Polyline%20Volume.html|Cesium Sandcastle Polyline Volume Demo]]
    */
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
    var distanceDisplayCondition: Property = js.native

    def clone(result: PolylineVolumeGraphics = ???): PolylineVolumeGraphics = js.native

    def merge(source: PolylineVolumeGraphics): js.Dynamic = js.native
  }

  /**
    * The interface for all [[Property]] objects that define a world
    * location as a [[Cartesian3]] with an associated [[ReferenceFrame]]
    * This type defines an interface and cannot be instantiated directly.
    *
    * alias PositionProperty
    *
    * @see CompositePositionProperty
    * @see ConstantPositionProperty
    * @see SampledPositionProperty
    * @see TimeIntervalCollectionPositionProperty
    */
  @js.native
  trait PositionProperty extends js.Object {
    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native
    var referenceFrame: ReferenceFrame = js.native

    def getValue(time: JulianDate, result: Cartesian3 = ???): Cartesian3 = js.native

    def getValueInReferenceFrame(time: JulianDate, referenceFrame: ReferenceFrame, result: Cartesian3 = ???): Cartesian3 = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  /**
    * A [[PositionProperty]] whose value is an array whose items are the computed value
    * of other PositionProperty instances.
    *
    * alias PositionPropertyArray
    *
    *
    * - {Property[]} [value] An array of Property instances.
    * - {ReferenceFrame} [referenceFrame=ReferenceFrame.FIXED] The reference frame in which the position is defined.
    */
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

  /**
    * The interface for all properties, which represent a value that can optionally vary over time.
    * This type defines an interface and cannot be instantiated directly.
    *
    * alias Property
    *
    * @see CompositeProperty
    * @see ConstantProperty
    * @see SampledProperty
    * @see TimeIntervalCollectionProperty
    * @see MaterialProperty
    * @see PositionProperty
    * @see ReferenceProperty
    */
  @js.native
  trait Property extends js.Object {
    var isConstant: Boolean = js.native
    var definitionChanged: Event = js.native

    def getValue(time: JulianDate, result: js.Any = ???): js.Dynamic = js.native

    def equals(other: Property = ???): Boolean = js.native
  }

  /**
    * A [[Property]] whose value is an array whose items are the computed value
    * of other property instances.
    *
    * alias PropertyArray
    *
    *
    * - {Property[]} [value] An array of Property instances.
    */
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

  /**
    * A [[Property]] whose value is a key-value mapping of property names to the computed value of other properties.
    *
    * alias PropertyBag
    *
    *
    * - {Object} [value] An object, containing key-value mapping of property names to properties.
    * - {Function} [createPropertyCallback] A function that will be called when the value of any of the properties in value are not a Property.
    */
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

  /**
    * A [[GeometryUpdater]] for rectangles.
    * Clients do not normally create this class directly, but instead rely on [[DataSourceDisplay]]
    * alias RectangleGeometryUpdater
    *
    *
    * - {Entity} entity The entity containing the geometry to be visualized.
    * - {Scene} scene The scene where visualization is taking place.
    */
  @js.native
  @JSName("Cesium.RectangleGeometryUpdater")
  class RectangleGeometryUpdater protected() extends GeometryUpdater {
    def this(entity: Entity, scene: Scene) = this()
  }

  @js.native
  @JSName("Cesium.RectangleGeometryUpdater")
  object RectangleGeometryUpdater extends GeometryUpdaterStatic

  /**
    * Describes graphics for a [[Rectangle]]
    * The rectangle conforms to the curvature of the globe and can be placed on the surface or
    * at altitude and can optionally be extruded into a volume.
    *
    * alias RectangleGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.coordinates] The Property specifying the [[Rectangle]]
    * - {Property} [options.height=0] A numeric Property specifying the altitude of the rectangle relative to the ellipsoid surface.
    * - {Property} [options.extrudedHeight] A numeric Property specifying the altitude of the rectangle's extruded face relative to the ellipsoid surface.
    * - {Property} [options.closeTop=true] A boolean Property specifying whether the rectangle has a top cover when extruded
    * - {Property} [options.closeBottom=true] A boolean Property specifying whether the rectangle has a bottom cover when extruded.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the rectangle.
    * - {Property} [options.fill=true] A boolean Property specifying whether the rectangle is filled with the provided material.
    * - {MaterialProperty} [options.material=Color.WHITE] A Property specifying the material used to fill the rectangle.
    * - {Property} [options.outline=false] A boolean Property specifying whether the rectangle is outlined.
    * - {Property} [options.outlineColor=Color.BLACK] A Property specifying the [[Color]] of the outline.
    * - {Property} [options.outlineWidth=1.0] A numeric Property specifying the width of the outline.
    * - {Property} [options.rotation=0.0] A numeric property specifying the rotation of the rectangle clockwise from north.
    * - {Property} [options.stRotation=0.0] A numeric property specifying the rotation of the rectangle texture counter-clockwise from north.
    * - {Property} [options.granularity=Cesium.Math.RADIANS_PER_DEGREE] A numeric Property specifying the angular distance between points on the rectangle.
    *
    * @see Entity
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Rectangle.html|Cesium Sandcastle Rectangle Demo]]
    */
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
    var distanceDisplayCondition: Property = js.native

    def clone(result: RectangleGraphics = ???): RectangleGraphics = js.native

    def merge(source: RectangleGraphics): js.Dynamic = js.native
  }

  /**
    * A [[Property]] which transparently links to another property on a provided object.
    *
    * alias ReferenceProperty
    *
    *
    * - {EntityCollection} targetCollection The entity collection which will be used to resolve the reference.
    * - {String} targetId The id of the entity which is being referenced.
    * - {String[]} targetPropertyNames The names of the property on the target entity which we will use.
    *
    * @example
    * var collection = new Cesium.EntityCollection();
    *
    * //Create a new entity and assign a billboard scale.
    * var object1 = new Cesium.Entity({id:'object1'});
    * object1.billboard = new Cesium.BillboardGraphics();
    * object1.billboard.scale = new Cesium.ConstantProperty(2.0);
    * collection.add(object1);
    *
    * //Create a second entity and reference the scale from the first one.
    * var object2 = new Cesium.Entity({id:'object2'});
    * object2.model = new Cesium.ModelGraphics();
    * object2.model.scale = new Cesium.ReferenceProperty(collection, 'object1', ['billboard', 'scale']);
    * collection.add(object2);
    *
    * //Create a third object, but use the fromString helper function.
    * var object3 = new Cesium.Entity({id:'object3'});
    * object3.billboard = new Cesium.BillboardGraphics();
    * object3.billboard.scale = Cesium.ReferenceProperty.fromString(collection, 'object1#billboard.scale');
    * collection.add(object3);
    *
    * //You can refer to an entity with a # or . in id and property names by escaping them.
    * var object4 = new Cesium.Entity({id:'#object.4'});
    * object4.billboard = new Cesium.BillboardGraphics();
    * object4.billboard.scale = new Cesium.ConstantProperty(2.0);
    * collection.add(object4);
    *
    * var object5 = new Cesium.Entity({id:'object5'});
    * object5.billboard = new Cesium.BillboardGraphics();
    * object5.billboard.scale = Cesium.ReferenceProperty.fromString(collection, '\\#object\\.4#billboard.scale');
    * collection.add(object5);
    */
  @js.native
  @JSName("Cesium.ReferenceProperty")
  class ReferenceProperty protected() extends Property {
    def this(targetCollection: EntityCollection, targetId: String, targetPropertyNames: js.Array[String]) = this()

    var referenceFrame: ReferenceFrame = js.native
    var targetId: String = js.native
    var targetCollection: EntityCollection = js.native
    var targetPropertyNames: js.Array[String] = js.native
    var resolvedProperty: Property = js.native

    def getValueInReferenceFrame(time: JulianDate, referenceFrame: ReferenceFrame, result: Cartesian3 = ???): Cartesian3 = js.native

    def getType(time: JulianDate): String = js.native
  }

  @js.native
  @JSName("Cesium.ReferenceProperty")
  object ReferenceProperty extends js.Object {
    def fromString(targetCollection: EntityCollection, referenceString: String): ReferenceProperty = js.native
  }

  /**
    * A [[SampledProperty]] which is also a [[PositionProperty]]
    *
    * alias SampledPositionProperty
    *
    *
    * - {ReferenceFrame} [referenceFrame=ReferenceFrame.FIXED] The reference frame in which the position is defined.
    * - {Number} [numberOfDerivatives=0] The number of derivatives that accompany each position; i.e. velocity, acceleration, etc...
    */
  @js.native
  @JSName("Cesium.SampledPositionProperty")
  class SampledPositionProperty protected() extends PositionProperty {
    def this(referenceFrame: ReferenceFrame = ???, numberOfDerivatives: Double = ???) = this()

    var interpolationDegree: Double = js.native
    var interpolationAlgorithm: InterpolationAlgorithm = js.native
    var numberOfDerivatives: Boolean = js.native
    var forwardExtrapolationType: ExtrapolationType = js.native
    var forwardExtrapolationDuration: Double = js.native
    var backwardExtrapolationType: ExtrapolationType = js.native
    var backwardExtrapolationDuration: Double = js.native

    def setInterpolationOptions(options: InterpolationOptions = ???): js.Dynamic = js.native

    def addSample(time: JulianDate, position: Cartesian3, derivatives: js.Array[Cartesian3] = ???): js.Dynamic = js.native

    def addSamples(times: js.Array[JulianDate], positions: js.Array[Cartesian3], derivatives: js.Array[js.Array[js.Any]] = ???): js.Dynamic = js.native

    def addSamplesPackedArray(packedSamples: js.Array[Double], epoch: JulianDate = ???): js.Dynamic = js.native
  }

  /**
    * A [[Property]] whose value is interpolated for a given time from the
    * provided set of samples and specified interpolation algorithm and degree.
    * alias SampledProperty
    *
    *
    * - {Number|Packable} type The type of property.
    * - {Packable[]} [derivativeTypes] When supplied, indicates that samples will contain derivative information of the specified types.
    *
    * @example
    * //Create a linearly interpolated Cartesian2
    * var property = new Cesium.SampledProperty(Cesium.Cartesian2);
    *
    * //Populate it with data
    * property.addSample(Cesium.JulianDate.fromIso8601(`2012-08-01T00:00:00.00Z`), new Cesium.Cartesian2(0, 0));
    * property.addSample(Cesium.JulianDate.fromIso8601(`2012-08-02T00:00:00.00Z`), new Cesium.Cartesian2(4, 7));
    *
    * //Retrieve an interpolated value
    * var result = property.getValue(Cesium.JulianDate.fromIso8601(`2012-08-01T12:00:00.00Z`));
    * @example
    * //Create a simple numeric SampledProperty that uses third degree Hermite Polynomial Approximation
    * var property = new Cesium.SampledProperty(Number);
    * property.setInterpolationOptions({
    * interpolationDegree : 3,
    * interpolationAlgorithm : Cesium.HermitePolynomialApproximation
    * });
    *
    * //Populate it with data
    * property.addSample(Cesium.JulianDate.fromIso8601(`2012-08-01T00:00:00.00Z`), 1.0);
    * property.addSample(Cesium.JulianDate.fromIso8601(`2012-08-01T00:01:00.00Z`), 6.0);
    * property.addSample(Cesium.JulianDate.fromIso8601(`2012-08-01T00:02:00.00Z`), 12.0);
    * property.addSample(Cesium.JulianDate.fromIso8601(`2012-08-01T00:03:30.00Z`), 5.0);
    * property.addSample(Cesium.JulianDate.fromIso8601(`2012-08-01T00:06:30.00Z`), 2.0);
    *
    * //Samples can be added in any order.
    * property.addSample(Cesium.JulianDate.fromIso8601(`2012-08-01T00:00:30.00Z`), 6.2);
    *
    * //Retrieve an interpolated value
    * var result = property.getValue(Cesium.JulianDate.fromIso8601(`2012-08-01T00:02:34.00Z`));
    * @see SampledPositionProperty
    */
  @js.native
  @JSName("Cesium.SampledProperty")
  class SampledProperty protected() extends Property {
    def this(`type`: js.Dynamic | Packable, derivativeTypes: js.Array[js.Dynamic] | js.Array[Packable] = ???) = this()

    var derivativeTypes: js.Array[js.Dynamic] | js.Array[Packable] = js.native
    var interpolationDegree: Double = js.native
    var interpolationAlgorithm: InterpolationAlgorithm = js.native
    var forwardExtrapolationType: ExtrapolationType = js.native
    var forwardExtrapolationDuration: Double = js.native
    var backwardExtrapolationType: ExtrapolationType = js.native
    var backwardExtrapolationDuration: Double = js.native

    def setInterpolationOptions(options: InterpolationOptions = ???): js.Dynamic = js.native

    def addSample(time: JulianDate, value: Double | Packable, derivatives: js.Array[Double] | js.Array[Packable] = ???): js.Dynamic = js.native

    def addSamples(times: js.Array[JulianDate], values: js.Array[Double] | js.Array[Packable], derivativeValues: js.Array[js.Array[js.Any]] = ???): js.Dynamic = js.native

    def addSamplesPackedArray(packedSamples: js.Array[Double], epoch: JulianDate = ???): js.Dynamic = js.native
  }

  /**
    * A [[MaterialProperty]] that maps to stripe [[Material]] uniforms.
    * alias StripeMaterialProperty
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.evenColor=Color.WHITE] A Property specifying the first [[Color]]
    * - {Property} [options.oddColor=Color.BLACK] A Property specifying the second [[Color]]
    * - {Property} [options.repeat=1] A numeric Property specifying how many times the stripes repeat.
    * - {Property} [options.offset=0] A numeric Property specifying how far into the pattern to start the material.
    * - {Property} [options.orientation=StripeOrientation.HORIZONTAL] A Property specifying the StripeOrientation
    */
  @js.native
  @JSName("Cesium.StripeMaterialProperty")
  class StripeMaterialProperty protected() extends MaterialProperty {
    def this(options: StripeMaterialPropertyOptions) = this()

    var orientation: Property = js.native
    var evenColor: Property = js.native
    var oddColor: Property = js.native
    var offset: Property = js.native
    var repeat: Property = js.native
  }

  /**
    * A [[TimeIntervalCollectionProperty]] which is also a [[PositionProperty]]
    *
    * alias TimeIntervalCollectionPositionProperty
    *
    *
    * - {ReferenceFrame} [referenceFrame=ReferenceFrame.FIXED] The reference frame in which the position is defined.
    */
  @js.native
  @JSName("Cesium.TimeIntervalCollectionPositionProperty")
  class TimeIntervalCollectionPositionProperty protected() extends PositionProperty {
    def this(referenceFrame: ReferenceFrame = ???) = this()

    var intervals: TimeIntervalCollection = js.native
  }

  /**
    * A [[Property]] which is defined by a [[TimeIntervalCollection]], where the
    * data property of each [[TimeInterval]] represents the value at time.
    *
    * alias TimeIntervalCollectionProperty
    *
    * @example
    * //Create a Cartesian2 interval property which contains data on August 1st, 2012
    * //and uses a different value every 6 hours.
    * var composite = new Cesium.TimeIntervalCollectionProperty();
    * composite.intervals.addInterval(Cesium.TimeInterval.fromIso8601({
    * iso8601 : '2012-08-01T00:00:00.00Z/2012-08-01T06:00:00.00Z',
    * isStartIncluded : true,
    * isStopIncluded : false,
    * data : new Cesium.Cartesian2(2.0, 3.4)
    * }));
    * composite.intervals.addInterval(Cesium.TimeInterval.fromIso8601({
    * iso8601 : '2012-08-01T06:00:00.00Z/2012-08-01T12:00:00.00Z',
    * isStartIncluded : true,
    * isStopIncluded : false,
    * data : new Cesium.Cartesian2(12.0, 2.7)
    * }));
    * composite.intervals.addInterval(Cesium.TimeInterval.fromIso8601({
    * iso8601 : '2012-08-01T12:00:00.00Z/2012-08-01T18:00:00.00Z',
    * isStartIncluded : true,
    * isStopIncluded : false,
    * data : new Cesium.Cartesian2(5.0, 12.4)
    * }));
    * composite.intervals.addInterval(Cesium.TimeInterval.fromIso8601({
    * iso8601 : '2012-08-01T18:00:00.00Z/2012-08-02T00:00:00.00Z',
    * isStartIncluded : true,
    * isStopIncluded : true,
    * data : new Cesium.Cartesian2(85.0, 4.1)
    * }));
    */
  @js.native
  @JSName("Cesium.TimeIntervalCollectionProperty")
  class TimeIntervalCollectionProperty() extends Property {
    var intervals: TimeIntervalCollection = js.native
  }

  /**
    * A [[Property]] which evaluates to a [[Quaternion]] rotation
    * based on the velocity of the provided [[PositionProperty]]
    *
    * alias VelocityOrientationProperty
    *
    *
    * - {Property} [position] The position property used to compute the orientation.
    * - {Ellipsoid} [ellipsoid=Ellipsoid.WGS84] The ellipsoid used to determine which way is up.
    *
    * @example
    * //Create an entity with position and orientation.
    * var position = new Cesium.SampledProperty();
    * position.addSamples(...);
    * var entity = viewer.entities.add({
    * position : position,
    * orientation : new Cesium.VelocityOrientationProperty(position)
    * }));
    */
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

  /**
    * A [[Property]] which evaluates to a [[Cartesian3]] vector
    * based on the velocity of the provided [[PositionProperty]]
    *
    * alias VelocityVectorProperty
    *
    *
    * - {Property} [position] The position property used to compute the velocity.
    *
    * @example
    * //Create an entity with a billboard rotated to match its velocity.
    * var position = new Cesium.SampledProperty();
    * position.addSamples(...);
    * var entity = viewer.entities.add({
    * position : position,
    * billboard : {
    * image : 'image.png',
    * alignedAxis : new Cesium.VelocityVectorProperty(position)
    * }
    * }));
    */
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

  /**
    * Defines the interface for visualizers. Visualizers are plug-ins to
    * [[DataSourceDisplay]] that render data associated with
    * [[DataSource]] instances.
    * This object is an interface for documentation purposes and is not intended
    * to be instantiated directly.
    * alias Visualizer
    *
    * @see BillboardVisualizer
    * @see LabelVisualizer
    * @see ModelVisualizer
    * @see PathVisualizer
    * @see PointVisualizer
    * @see GeometryVisualizer
    */
  @js.native
  trait Visualizer extends js.Object {
    def update(time: JulianDate): Boolean = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  /**
    * A [[GeometryUpdater]] for walls.
    * Clients do not normally create this class directly, but instead rely on [[DataSourceDisplay]]
    * alias WallGeometryUpdater
    *
    *
    * - {Entity} entity The entity containing the geometry to be visualized.
    * - {Scene} scene The scene where visualization is taking place.
    */
  @js.native
  @JSName("Cesium.WallGeometryUpdater")
  class WallGeometryUpdater protected() extends GeometryUpdater {
    def this(entity: Entity, scene: Scene) = this()
  }

  @js.native
  @JSName("Cesium.WallGeometryUpdater")
  object WallGeometryUpdater extends GeometryUpdaterStatic

  /**
    * Describes a two dimensional wall defined as a line strip and optional maximum and minimum heights.
    * The wall conforms to the curvature of the globe and can be placed along the surface or at altitude.
    *
    * alias WallGraphics
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Property} [options.positions] A Property specifying the array of [[Cartesian3]] positions which define the top of the wall.
    * - {Property} [options.maximumHeights] A Property specifying an array of heights to be used for the top of the wall instead of the height of each position.
    * - {Property} [options.minimumHeights] A Property specifying an array of heights to be used for the bottom of the wall instead of the globe surface.
    * - {Property} [options.show=true] A boolean Property specifying the visibility of the wall.
    * - {Property} [options.fill=true] A boolean Property specifying whether the wall is filled with the provided material.
    * - {MaterialProperty} [options.material=Color.WHITE] A Property specifying the material used to fill the wall.
    * - {Property} [options.outline=false] A boolean Property specifying whether the wall is outlined.
    * - {Property} [options.outlineColor=Color.BLACK] A Property specifying the [[Color]] of the outline.
    * - {Property} [options.outlineWidth=1.0] A numeric Property specifying the width of the outline.
    * - {Property} [options.granularity=Cesium.Math.RADIANS_PER_DEGREE] A numeric Property specifying the angular distance between each latitude and longitude point.
    *
    * @see Entity
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Wall.html|Cesium Sandcastle Wall Demo]]
    */
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
    var distanceDisplayCondition: Property = js.native

    def clone(result: WallGraphics = ???): WallGraphics = js.native

    def merge(source: WallGraphics): js.Dynamic = js.native
  }

  /**
    * An appearance defines the full GLSL vertex and fragment shaders and the
    * render state used to draw a [[Primitive]]   All appearances implement
    * this base <code>Appearance</code> interface.
    *
    * alias Appearance
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Boolean} [options.translucent=true] When <code>true</code>, the geometry is expected to appear translucent so [[Appearance#renderState]] has alpha blending enabled.
    * - {Boolean} [options.closed=false] When <code>true</code>, the geometry is expected to be closed so [[Appearance#renderState]] has backface culling enabled.
    * - {Material} [options.material=Material.ColorType] The material used to determine the fragment color.
    * - {String} [options.vertexShaderSource] Optional GLSL vertex shader source to override the default vertex shader.
    * - {String} [options.fragmentShaderSource] Optional GLSL fragment shader source to override the default fragment shader.
    * - {RenderState} [options.renderState] Optional render state to override the default render state.
    *
    * @see MaterialAppearance
    * @see EllipsoidSurfaceAppearance
    * @see PerInstanceColorAppearance
    * @see DebugAppearance
    * @see PolylineColorAppearance
    * @see PolylineMaterialAppearance
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Geometry%20and%20Appearances.html|Geometry and Appearances Demo]]
    */
  // todo this should be a trait?
  @js.native
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

  /**
    * Provides tiled imagery hosted by an ArcGIS MapServer.  By default, the server's pre-cached tiles are
    * used, if available.
    *
    * alias ArcGisMapServerImageryProvider
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {String} options.url The URL of the ArcGIS MapServer service.
    * - {String} [options.token] The ArcGIS token used to authenticate with the ArcGIS MapServer service.
    * - {TileDiscardPolicy} [options.tileDiscardPolicy] The policy that determines if a tile
    * is invalid and should be discarded.  If this value is not specified, a default
    * [[DiscardMissingTileImagePolicy]] is used for tiled map servers, and a
    * [[NeverTileDiscardPolicy]] is used for non-tiled map servers.  In the former case,
    * we request tile 0,0 at the maximum tile level and check pixels (0,0), (200,20), (20,200),
    * (80,110), and (160, 130).  If all of these pixels are transparent, the discard check is
    * disabled and no tiles are discarded.  If any of them have a non-transparent color, any
    * tile that has the same values in these pixel locations is discarded.  The end result of
    * these defaults should be correct tile discarding for a standard ArcGIS Server.  To ensure
    * that no tiles are discarded, construct and pass a [[NeverTileDiscardPolicy]] for this
    * parameter.
    * - {Proxy} [options.proxy] A proxy to use for requests. This object is
    * expected to have a getURL function which returns the proxied URL, if needed.
    * - {Boolean} [options.usePreCachedTilesIfAvailable=true] If true, the server's pre-cached
    * tiles are used if they are available.  If false, any pre-cached tiles are ignored and the
    * 'export' service is used.
    * - {String} [options.layers] A comma-separated list of the layers to show, or undefined if all layers should be shown.
    * - {Boolean} [options.enablePickFeatures=true] If true, [[ArcGisMapServerImageryProvider#pickFeatures]] will invoke
    * the Identify service on the MapServer and return the features included in the response.  If false,
    * [[ArcGisMapServerImageryProvider#pickFeatures]] will immediately return undefined (indicating no pickable features)
    * without communicating with the server.  Set this property to false if you don't want this provider's features to
    * be pickable. Can be overridden by setting the [[ArcGisMapServerImageryProvider#enablePickFeatures]] property on the object.
    * - {Rectangle} [options.rectangle=Rectangle.MAX_VALUE] The rectangle of the layer.  This parameter is ignored when accessing
    * a tiled layer.
    * - {TilingScheme} [options.tilingScheme=new GeographicTilingScheme()] The tiling scheme to use to divide the world into tiles.
    * This parameter is ignored when accessing a tiled server.
    * - {Ellipsoid} [options.ellipsoid] The ellipsoid.  If the tilingScheme is specified and used,
    * this parameter is ignored and the tiling scheme's ellipsoid is used instead. If neither
    * parameter is specified, the WGS84 ellipsoid is used.
    * - {Number} [options.tileWidth=256] The width of each tile in pixels.  This parameter is ignored when accessing a tiled server.
    * - {Number} [options.tileHeight=256] The height of each tile in pixels.  This parameter is ignored when accessing a tiled server.
    * - {Number} [options.maximumLevel] The maximum tile level to request, or undefined if there is no maximum.  This parameter is ignored when accessing
    * a tiled server.
    *
    * @see BingMapsImageryProvider
    * @see GoogleEarthImageryProvider
    * @see createOpenStreetMapImageryProvider
    * @see SingleTileImageryProvider
    * @see createTileMapServiceImageryProvider
    * @see WebMapServiceImageryProvider
    * @see WebMapTileServiceImageryProvider
    * @see UrlTemplateImageryProvider
    * @example
    * var esri = new Cesium.ArcGisMapServerImageryProvider({
    * url : 'https://services.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer'
    * });
    * @see [[http://resources.esri.com/help/9.3/arcgisserver/apis/rest/|ArcGIS Server REST API]]
    * @see [[http://www.w3.org/TR/cors/|Cross-Origin Resource Sharing]]
    */
  @js.native
  @JSName("Cesium.ArcGisMapServerImageryProvider")
  class ArcGisMapServerImageryProvider protected() extends ImageryProvider {
    def this(options: ArcGisMapServerImageryProviderOptions) = this()

    var enablePickFeatures: Boolean = js.native
    var url: String = js.native
    var token: String = js.native
    var usingPrecachedTiles: Boolean = js.native
  }

  @js.native
  @JSName("Cesium.ArcGisMapServerImageryProvider")
  object ArcGisMapServerImageryProvider extends ImageryProviderStatic

  @JSName("Cesium.Billboard")
  @js.native
  object Billboard extends js.Object {
    type CreateImageCallback = js.Function1[String, HTMLImageElement | HTMLCanvasElement | Promise[HTMLImageElement | HTMLCanvasElement]]
  }

  /**
    * A viewport-aligned image positioned in the 3D scene, that is created
    * and rendered using a [[BillboardCollection]]   A billboard is created and its initial
    * properties are set by calling [[BillboardCollection#add]]
    *
    * <div align='center'>
    * <img src='images/Billboard.png' width='400' height='300' /><br />
    * Example billboards
    * </div>
    *
    * alias Billboard
    *
    * performance Reading a property, e.g., [[Billboard#show]], is constant time.
    * Assigning to a property is constant time but results in
    * CPU to GPU traffic when [[BillboardCollection#update]] is called.  The per-billboard traffic is
    * the same regardless of how many properties were updated.  If most billboards in a collection need to be
    * updated, it may be more efficient to clear the collection with [[BillboardCollection#removeAll]]
    * and add new billboards instead of modifying each one.
    *
    * exception {DeveloperError} scaleByDistance.far must be greater than scaleByDistance.near
    * exception {DeveloperError} translucencyByDistance.far must be greater than translucencyByDistance.near
    * exception {DeveloperError} pixelOffsetScaleByDistance.far must be greater than pixelOffsetScaleByDistance.near
    *
    * @see BillboardCollection
    * @see BillboardCollection#add
    * @see Label
    *
    *
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Billboards.html|Cesium Sandcastle Billboard Demo]]
    */
  @js.native
  trait Billboard extends js.Object {
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

  /**
    * A renderable collection of billboards.  Billboards are viewport-aligned
    * images positioned in the 3D scene.
    *
    * <div align='center'>
    * <img src='images/Billboard.png' width='400' height='300' /><br />
    * Example billboards
    * </div>
    *
    * Billboards are added and removed from the collection using [[BillboardCollection#add]]
    * and [[BillboardCollection#remove]]   Billboards in a collection automatically share textures
    * for images with the same identifier.
    *
    * alias BillboardCollection
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Matrix4} [options.modelMatrix=Matrix4.IDENTITY] The 4x4 transformation matrix that transforms each billboard from model to world coordinates.
    * - {Boolean} [options.debugShowBoundingVolume=false] For debugging only. Determines if this primitive's commands' bounding spheres are shown.
    * - {Scene} [options.scene] Must be passed in for billboards that use the height reference property or will be depth tested against the globe.
    *
    * performance For best performance, prefer a few collections, each with many billboards, to
    * many collections with only a few billboards each.  Organize collections so that billboards
    * with the same update frequency are in the same collection, i.e., billboards that do not
    * change should be in one collection; billboards that change every frame should be in another
    * collection; and so on.
    *
    * @see BillboardCollection#add
    * @see BillboardCollection#remove
    * @see Billboard
    * @see LabelCollection
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Billboards.html|Cesium Sandcastle Billboard Demo]]
    * @example
    * // Create a billboard collection with two billboards
    * var billboards = scene.primitives.add(new Cesium.BillboardCollection());
    * billboards.add({
    * position : new Cesium.Cartesian3(1.0, 2.0, 3.0),
    * image : 'url/to/image'
    * });
    * billboards.add({
    * position : new Cesium.Cartesian3(4.0, 5.0, 6.0),
    * image : 'url/to/another/image'
    * });
    */
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

  /**
    * Provides tiled imagery using the Bing Maps Imagery REST API.
    *
    * alias BingMapsImageryProvider
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {String} options.url The url of the Bing Maps server hosting the imagery.
    * - {String} [options.key] The Bing Maps key for your application, which can be
    * created at [[https://www.bingmapsportal.com/]]
    * If this parameter is not provided, [[BingMapsApi.defaultKey]] is used.
    * If [[BingMapsApi.defaultKey]] is undefined as well, a message is
    * written to the console reminding you that you must create and supply a Bing Maps
    * key as soon as possible.  Please do not deploy an application that uses
    * Bing Maps imagery without creating a separate key for your application.
    * - {String} [options.tileProtocol] The protocol to use when loading tiles, e.g. 'http:' or 'https:'.
    * By default, tiles are loaded using the same protocol as the page.
    * - {String} [options.mapStyle=BingMapsStyle.AERIAL] The type of Bing Maps
    * imagery to load.
    * - {String} [options.culture= ] The culture to use when requesting Bing Maps imagery. Not
    * all cultures are supported. See [[http://msdn.microsoft.com/en-us/library/hh441729.aspx}
    * for information on the supported cultures.
    * - {Ellipsoid} [options.ellipsoid] The ellipsoid.  If not specified, the WGS84 ellipsoid is used.
    * - {TileDiscardPolicy} [options.tileDiscardPolicy] The policy that determines if a tile
    * is invalid and should be discarded.  If this value is not specified, a default
    * [[DiscardMissingTileImagePolicy]] is used which requests
    * tile 0,0 at the maximum tile level and checks pixels (0,0), (120,140), (130,160),
    * (200,50), and (200,200).  If all of these pixels are transparent, the discard check is
    * disabled and no tiles are discarded.  If any of them have a non-transparent color, any
    * tile that has the same values in these pixel locations is discarded.  The end result of
    * these defaults should be correct tile discarding for a standard Bing Maps server.  To ensure
    * that no tiles are discarded, construct and pass a [[NeverTileDiscardPolicy]] for this
    * parameter.
    * - {Proxy} [options.proxy] A proxy to use for requests. This object is
    * expected to have a getURL function which returns the proxied URL, if needed.
    *
    * @see ArcGisMapServerImageryProvider
    * @see GoogleEarthImageryProvider
    * @see createOpenStreetMapImageryProvider
    * @see SingleTileImageryProvider
    * @see createTileMapServiceImageryProvider
    * @see WebMapServiceImageryProvider
    * @see WebMapTileServiceImageryProvider
    * @see UrlTemplateImageryProvider
    * @example
    * var bing = new Cesium.BingMapsImageryProvider({
    * url : 'https://dev.virtualearth.net',
    * key : 'get-yours-at-https://www.bingmapsportal.com/',
    * mapStyle : Cesium.BingMapsStyle.AERIAL
    * });
    * @see [[http://msdn.microsoft.com/en-us/library/ff701713.aspx|Bing Maps REST Services]]
    * @see [[http://www.w3.org/TR/cors/|Cross-Origin Resource Sharing]]
    */
  @js.native
  @JSName("Cesium.BingMapsImageryProvider")
  class BingMapsImageryProvider protected() extends ImageryProvider {
    def this(options: BingMapsImageryProviderOptions) = this()

    var url: String = js.native
    var key: String = js.native
    var mapStyle: BingMapsStyle = js.native
    var culture: String = js.native
  }

  @js.native
  @JSName("Cesium.BingMapsImageryProvider")
  object BingMapsImageryProvider extends ImageryProviderStatic {
    def tileXYToQuadKey(x: Double, y: Double, level: Double): js.Dynamic = js.native

    def quadKeyToTileXY(quadkey: String): js.Dynamic = js.native
  }

  /**
    * The camera is defined by a position, orientation, and view frustum.
    *
    * The orientation forms an orthonormal basis with a view, up and right = view x up unit vectors.
    *
    * The viewing frustum is defined by 6 planes.
    * Each plane is represented by a [[Cartesian4]] object, where the x, y, and z components
    * define the unit vector normal to the plane, and the w component is the distance of the
    * plane from the origin/camera position.
    *
    * alias Camera
    *
    *
    *
    * - {Scene} scene The scene.
    *
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Camera.html|Cesium Sandcastle Camera Demo]]
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Camera%20Tutorial.html">Sandcastle Example</a> from the <a href="http://cesiumjs.org/2013/02/13/Cesium-Camera-Tutorial/|Camera Tutorial]]
    *
    * @example
    * // Create a camera looking down the negative z-axis, positioned at the origin,
    * // with a field of view of 60 degrees, and 1:1 aspect ratio.
    * var camera = new Cesium.Camera(scene);
    * camera.position = new Cesium.Cartesian3();
    * camera.direction = Cesium.Cartesian3.negate(Cesium.Cartesian3.UNIT_Z, new Cesium.Cartesian3());
    * camera.up = Cesium.Cartesian3.clone(Cesium.Cartesian3.UNIT_Y);
    * camera.frustum.fov = Cesium.Math.PI_OVER_THREE;
    * camera.frustum.near = 1.0;
    * camera.frustum.far = 2.0;
    */
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

    def cancelFlight(): Unit = js.native

    def setView(options: CameraSetViewOptions): js.Dynamic = js.native

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

    def flyTo(options: CameraFlyToOptions): js.Dynamic = js.native

    def viewBoundingSphere(boundingSphere: BoundingSphere, offset: HeadingPitchRange = ???): js.Dynamic = js.native

    def flyToBoundingSphere(boundingSphere: BoundingSphere, options: CameraFlyToBoundingSphereOptions = ???): js.Dynamic = js.native

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

  /**
    * Aggregates input events. For example, suppose the following inputs are received between frames:
    * left mouse button down, mouse move, mouse move, left mouse button up. These events will be aggregated into
    * one event with a start and end position of the mouse.
    *
    * alias CameraEventAggregator
    *
    *
    * - {Canvas} [element=document] The element to handle events for.
    *
    * @see ScreenSpaceEventHandler
    */
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

  /**
    * The credit display is responsible for displaying credits on screen.
    *
    * - {HTMLElement} container The HTML element where credits will be displayed
    * - {String} [delimiter= ' • '] The string to separate text credits
    *
    * alias CreditDisplay
    *
    * @example
    * var creditDisplay = new Cesium.CreditDisplay(creditContainer);
    */
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

  /**
    * The culling volume defined by planes.
    *
    * alias CullingVolume
    *
    *
    * - {Cartesian4[]} [planes] An array of clipping planes.
    */
  @js.native
  @JSName("Cesium.CullingVolume")
  class CullingVolume protected() extends js.Object {
    def this(planes: js.Array[Cartesian4] = ???) = this()

    var planes: js.Array[Cartesian4] = js.native

    def computeVisibility(boundingVolume: js.Any): Intersect = js.native

    def fromBoundingSphere(boundingSphere: BoundingSphere, result: CullingVolume = ???): CullingVolume = js.native
  }

  @js.native
  @JSName("Cesium.CullingVolume")
  object CullingVolume extends js.Object {
    def fromBoundingSphere(boundingSphere: BoundingSphere, result: CullingVolume = ???): CullingVolume = js.native
  }

  /**
    * Visualizes a vertex attribute by displaying it as a color for debugging.
    * <p>
    * Components for well-known unit-length vectors, i.e., <code>normal</code>,
    * <code>binormal</code>, and <code>tangent</code>, are scaled and biased
    * from [-1.0, 1.0] to (-1.0, 1.0).
    * </p>
    *
    * alias DebugAppearance
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {String} options.attributeName The name of the attribute to visualize.
    * - {String} [options.glslDatatype='vec3'] The GLSL datatype of the attribute.  Supported datatypes are <code>float</code>, <code>vec2</code>, <code>vec3</code>, and <code>vec4</code>.
    * - {String} [options.vertexShaderSource] Optional GLSL vertex shader source to override the default vertex shader.
    * - {String} [options.fragmentShaderSource] Optional GLSL fragment shader source to override the default fragment shader.
    * - {RenderState} [options.renderState] Optional render state to override the default render state.
    *
    * exception {DeveloperError} options.glslDatatype must be float, vec2, vec3, or vec4.
    *
    * @example
    * var primitive = new Cesium.Primitive({
    * geometryInstances : // ...
    * appearance : new Cesium.DebugAppearance({
    * attributeName : 'normal'
    * })
    * });
    */
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

  /**
    * Draws the axes of a reference frame defined by a matrix that transforms to world
    * coordinates, i.e., Earth's WGS84 coordinates.  The most prominent example is
    * a primitives <code>modelMatrix</code>.
    * <p>
    * The X axis is red; Y is green; and Z is blue.
    * </p>
    * <p>
    * This is for debugging only; it is not optimized for production use.
    * </p>
    *
    * alias DebugModelMatrixPrimitive
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Number} [options.length=10000000.0] The length of the axes in meters.
    * - {Number} [options.width=2.0] The width of the axes in pixels.
    * - {Matrix4} [options.modelMatrix=Matrix4.IDENTITY] The 4x4 matrix that defines the reference frame, i.e., origin plus axes, to visualize.
    * - {Boolean} [options.show=true] Determines if this primitive will be shown.
    * - {Object} [options.id] A user-defined object to return when the instance is picked with [[Scene#pick]]
    *
    * @example
    * primitives.add(new Cesium.DebugModelMatrixPrimitive({
    * modelMatrix : primitive.modelMatrix,  // primitive to debug
    * length : 100000.0,
    * width : 10.0
    * }));
    */
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

  /**
    * A policy for discarding tile images that match a known image containing a
    * "missing" image.
    *
    * alias DiscardMissingTileImagePolicy
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {String} options.missingImageUrl The URL of the known missing image.
    * - {Cartesian2[]} options.pixelsToCheck An array of [[Cartesian2]] pixel positions to
    * compare against the missing image.
    * - {Boolean} [options.disableCheckIfAllPixelsAreTransparent=false] If true, the discard check will be disabled
    * if all of the pixelsToCheck in the missingImageUrl have an alpha value of 0.  If false, the
    * discard check will proceed no matter the values of the pixelsToCheck.
    */
  @js.native
  @JSName("Cesium.DiscardMissingTileImagePolicy")
  class DiscardMissingTileImagePolicy protected() extends TileDiscardPolicy {
    def this(options: DiscardMissingTileImagePolicyOptions) = this()
  }

  /**
    * An appearance for geometry on the surface of the ellipsoid like [[PolygonGeometry]]
    * and [[RectangleGeometry]], which supports all materials like [[MaterialAppearance]]
    * with [[MaterialAppearance.MaterialSupport]]   However, this appearance requires
    * fewer vertex attributes since the fragment shader can procedurally compute <code>normal</code>,
    * <code>binormal</code>, and <code>tangent</code>.
    *
    * alias EllipsoidSurfaceAppearance
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Boolean} [options.flat=false] When <code>true</code>, flat shading is used in the fragment shader, which means lighting is not taking into account.
    * - {Boolean} [options.faceForward=options.aboveGround] When <code>true</code>, the fragment shader flips the surface normal as needed to ensure that the normal faces the viewer to avoid dark spots.  This is useful when both sides of a geometry should be shaded like [[WallGeometry]]
    * - {Boolean} [options.translucent=true] When <code>true</code>, the geometry is expected to appear translucent so [[EllipsoidSurfaceAppearance#renderState]] has alpha blending enabled.
    * - {Boolean} [options.aboveGround=false] When <code>true</code>, the geometry is expected to be on the ellipsoid's surface - not at a constant height above it - so [[EllipsoidSurfaceAppearance#renderState]] has backface culling enabled.
    * - {Material} [options.material=Material.ColorType] The material used to determine the fragment color.
    * - {String} [options.vertexShaderSource] Optional GLSL vertex shader source to override the default vertex shader.
    * - {String} [options.fragmentShaderSource] Optional GLSL fragment shader source to override the default fragment shader.
    * - {RenderState} [options.renderState] Optional render state to override the default render state.
    *
    * @see [[https://github.com/AnalyticalGraphicsInc/cesium/wiki/Fabric|Fabric]]
    * @example
    * var primitive = new Cesium.Primitive({
    * geometryInstances : new Cesium.GeometryInstance({
    * geometry : new Cesium.PolygonGeometry({
    * vertexFormat : Cesium.EllipsoidSurfaceAppearance.VERTEX_FORMAT,
    * // ...
    * })
    * }),
    * appearance : new Cesium.EllipsoidSurfaceAppearance({
    * material : Cesium.Material.fromType('Stripe')
    * })
    * });
    */
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

  /**
    * Blends the atmosphere to geometry far from the camera for horizon views. Allows for additional
    * performance improvements by rendering less geometry and dispatching less terrain requests.
    *
    * alias Fog
    *
    */
  @js.native
  @JSName("Cesium.Fog")
  class Fog() extends js.Object {
    var enabled: Boolean = js.native
    var density: Double = js.native
    var screenSpaceErrorFactor: Double = js.native
  }

  /**
    * Monitors the frame rate (frames per second) in a [[Scene]] and raises an event if the frame rate is
    * lower than a threshold.  Later, if the frame rate returns to the required level, a separate event is raised.
    * To avoid creating multiple FrameRateMonitors for a single [[Scene]], use [[FrameRateMonitor]]
    * instead of constructing an instance explicitly.
    *
    * alias FrameRateMonitor
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Scene} options.scene The Scene instance for which to monitor performance.
    * - {Number} [options.samplingWindow=5.0] The length of the sliding window over which to compute the average frame rate, in seconds.
    * - {Number} [options.quietPeriod=2.0] The length of time to wait at startup and each time the page becomes visible (i.e. when the user
    * switches back to the tab) before starting to measure performance, in seconds.
    * - {Number} [options.warmupPeriod=5.0] The length of the warmup period, in seconds.  During the warmup period, a separate
    * (usually lower) frame rate is required.
    * - {Number} [options.minimumFrameRateDuringWarmup=4] The minimum frames-per-second that are required for acceptable performance during
    * the warmup period.  If the frame rate averages less than this during any samplingWindow during the warmupPeriod, the
    * lowFrameRate event will be raised and the page will redirect to the redirectOnLowFrameRateUrl, if any.
    * - {Number} [options.minimumFrameRateAfterWarmup=8] The minimum frames-per-second that are required for acceptable performance after
    * the end of the warmup period.  If the frame rate averages less than this during any samplingWindow after the warmupPeriod, the
    * lowFrameRate event will be raised and the page will redirect to the redirectOnLowFrameRateUrl, if any.
    */
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

  /**
    * Describes the format in which to request GetFeatureInfo from a Web Map Service (WMS) server.
    *
    * alias GetFeatureInfoFormat
    *
    *
    * - {String} type The type of response to expect from a GetFeatureInfo request.  Valid
    * values are 'json', 'xml', 'html', or 'text'.
    * - {String} [format] The info format to request from the WMS server.  This is usually a
    * MIME type such as 'application/json' or text/xml'.  If this parameter is not specified, the provider will request 'json'
    * using 'application/json', 'xml' using 'text/xml', 'html' using 'text/html', and 'text' using 'text/plain'.
    * - {Function} [callback] A function to invoke with the GetFeatureInfo response from the WMS server
    * in order to produce an array of picked [[ImageryLayerFeatureInfo]] instances.  If this parameter is not specified,
    * a default function for the type of response is used.
    */
  @js.native
  @JSName("Cesium.GetFeatureInfoFormat")
  class GetFeatureInfoFormat protected() extends js.Object {
    def this(`type`: String, format: String = ???, callback: js.Function = ???) = this()
  }

  /**
    * The globe rendered in the scene, including its terrain ([[Globe#terrainProvider]])
    * and imagery layers ([[Globe#imageryLayers]]).  Access the globe using [[Scene#globe]]
    *
    * alias Globe
    *
    *
    * - {Ellipsoid} [ellipsoid=Ellipsoid.WGS84] Determines the size and shape of the
    * globe.
    */
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
    var shadows: Int = js.native
  //  var castShadows: Boolean = js.native
  //  var receiveShadows: Boolean = js.native
    var terrainProviderChanged: Event = js.native

    def pick(ray: Ray, scene: Scene, result: Cartesian3 = ???): Cartesian3 | Unit = js.native

    def getHeight(cartographic: Cartographic): Double | Unit = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  /**
    * Provides tiled imagery using the Google Earth Imagery API.
    *
    * Notes: This imagery provider does not work with the public Google Earth servers. It works with the
    * Google Earth Enterprise Server.
    *
    * By default the Google Earth Enterprise server does not set the
    * [[http://www.w3.org/TR/cors/|Cross-Origin Resource Sharing]] headers. You can either
    * use a proxy server which adds these headers, or in the /opt/google/gehttpd/conf/gehttpd.conf
    * and add the 'Header set Access-Control-Allow-Origin "*"' option to the '&lt;Directory /&gt;' and
    * '&lt;Directory "/opt/google/gehttpd/htdocs"&gt;' directives.
    *
    * alias GoogleEarthImageryProvider
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {String} options.url The url of the Google Earth server hosting the imagery.
    * - {Number} options.channel The channel (id) to be used when requesting data from the server.
    * The channel number can be found by looking at the json file located at:
    * earth.localdomain/default_map/query?request=Json&vars=geeServerDefs The /default_map path may
    * differ depending on your Google Earth Enterprise server configuration. Look for the "id" that
    * is associated with a "ImageryMaps" requestType. There may be more than one id available.
    * Example:
    * {
    * layers: [
    * {
    * id: 1002,
    * requestType: "ImageryMaps"
    * },
    * {
    * id: 1007,
    * requestType: "VectorMapsRaster"
    * }
    * ]
    * }
    * - {String} [options.path="/default_map"] The path of the Google Earth server hosting the imagery.
    * - {Number} [options.maximumLevel] The maximum level-of-detail supported by the Google Earth
    * Enterprise server, or undefined if there is no limit.
    * - {TileDiscardPolicy} [options.tileDiscardPolicy] The policy that determines if a tile
    * is invalid and should be discarded. To ensure that no tiles are discarded, construct and pass
    * a [[NeverTileDiscardPolicy]] for this parameter.
    * - {Ellipsoid} [options.ellipsoid] The ellipsoid.  If not specified, the WGS84 ellipsoid is used.
    * - {Proxy} [options.proxy] A proxy to use for requests. This object is
    * expected to have a getURL function which returns the proxied URL, if needed.
    *
    * exception {RuntimeError} Could not find layer with channel (id) of <code>options.channel</code>.
    * exception {RuntimeError} Could not find a version in channel (id) <code>options.channel</code>.
    * exception {RuntimeError} Unsupported projection <code>data.projection</code>.
    *
    * @see ArcGisMapServerImageryProvider
    * @see BingMapsImageryProvider
    * @see createOpenStreetMapImageryProvider
    * @see SingleTileImageryProvider
    * @see createTileMapServiceImageryProvider
    * @see WebMapServiceImageryProvider
    * @see WebMapTileServiceImageryProvider
    * @see UrlTemplateImageryProvider
    * @example
    * var google = new Cesium.GoogleEarthImageryProvider({
    * url : 'https://earth.localdomain',
    * channel : 1008
    * });
    * @see [[http://www.w3.org/TR/cors/|Cross-Origin Resource Sharing]]
    */
  @js.native
  @JSName("Cesium.GoogleEarthImageryProvider")
  class GoogleEarthImageryProvider protected() extends ImageryProvider {
    def this(options: GoogleEarthImageryProviderOptions) = this()

    var url: String = js.native
    var path: String = js.native
    var channel: Double = js.native
    var version: Double = js.native
    var requestType: String = js.native
  }

  @js.native
  @JSName("Cesium.GoogleEarthImageryProvider")
  object GoogleEarthImageryProvider extends ImageryProviderStatic

  /**
    * An [[ImageryProvider]] that draws a wireframe grid on every tile with controllable background and glow.
    * May be useful for custom rendering effects or debugging terrain.
    *
    * alias GridImageryProvider
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {TilingScheme} [options.tilingScheme=new GeographicTilingScheme()] The tiling scheme for which to draw tiles.
    * - {Ellipsoid} [options.ellipsoid] The ellipsoid.  If the tilingScheme is specified,
    * this parameter is ignored and the tiling scheme's ellipsoid is used instead. If neither
    * parameter is specified, the WGS84 ellipsoid is used.
    * - {Number} [options.cells=8] The number of grids cells.
    * - {Color} [options.color=Color(1.0, 1.0, 1.0, 0.4)] The color to draw grid lines.
    * - {Color} [options.glowColor=Color(0.0, 1.0, 0.0, 0.05)] The color to draw glow for grid lines.
    * - {Number} [options.glowWidth=6] The width of lines used for rendering the line glow effect.
    * - {Color} [backgroundColor=Color(0.0, 0.5, 0.0, 0.2)] Background fill color.
    * - {Number} [options.tileWidth=256] The width of the tile for level-of-detail selection purposes.
    * - {Number} [options.tileHeight=256] The height of the tile for level-of-detail selection purposes.
    * - {Number} [options.canvasSize=256] The size of the canvas used for rendering.
    */
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

  /**
    * A ground primitive represents geometry draped over the terrain in the [[Scene]]   The geometry must be from a single [[GeometryInstance]]
    * Batching multiple geometries is not yet supported.
    * <p>
    * A primitive combines the geometry instance with an [[Appearance]] that describes the full shading, including
    * [[Material]] and RenderState   Roughly, the geometry instance defines the structure and placement,
    * and the appearance defines the visual characteristics.  Decoupling geometry and appearance allows us to mix
    * and match most of them and add a new geometry or appearance independently of each other. Only the [[PerInstanceColorAppearance]]
    * is supported at this time.
    * </p>
    * <p>
    * Because of the cutting edge nature of this feature in WebGL, it requires the EXT_frag_depth extension, which is currently only supported in Chrome,
    * Firefox, and Edge. Apple support is expected in iOS 9 and MacOS Safari 9. Android support varies by hardware and IE11 will most likely never support
    * it. You can use webglreport.com to verify support for your hardware. Finally, this feature is currently only supported in Primitives and not yet
    * available via the Entity API.
    * </p>
    * <p>
    * Valid geometries are [[CircleGeometry]], [[CorridorGeometry]], [[EllipseGeometry]], [[PolygonGeometry]], and [[RectangleGeometry]]
    * </p>
    *
    * alias GroundPrimitive
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Array|GeometryInstance} [options.geometryInstances] The geometry instances to render.
    * - {Boolean} [options.show=true] Determines if this primitive will be shown.
    * - {Boolean} [options.vertexCacheOptimize=false] When <code>true</code>, geometry vertices are optimized for the pre and post-vertex-shader caches.
    * - {Boolean} [options.interleave=false] When <code>true</code>, geometry vertex attributes are interleaved, which can slightly improve rendering performance but increases load time.
    * - {Boolean} [options.compressVertices=true] When <code>true</code>, the geometry vertices are compressed, which will save memory.
    * - {Boolean} [options.releaseGeometryInstances=true] When <code>true</code>, the primitive does not keep a reference to the input <code>geometryInstances</code> to save memory.
    * - {Boolean} [options.allowPicking=true] When <code>true</code>, each geometry instance will only be pickable with [[Scene#pick]]   When <code>false</code>, GPU memory is saved.
    * - {Boolean} [options.asynchronous=true] Determines if the primitive will be created asynchronously or block until ready.
    * - {Boolean} [options.debugShowBoundingVolume=false] For debugging only. Determines if this primitive's commands' bounding spheres are shown.
    * - {Boolean} [options.debugShowShadowVolume=false] For debugging only. Determines if the shadow volume for each geometry in the primitive is drawn. Must be <code>true</code> on
    * creation for the volumes to be created before the geometry is released or options.releaseGeometryInstance must be <code>false</code>.
    *
    * @example
    * // Example 1: Create primitive with a single instance
    * var rectangleInstance = new Cesium.GeometryInstance({
    * geometry : new Cesium.RectangleGeometry({
    * rectangle : Cesium.Rectangle.fromDegrees(-140.0, 30.0, -100.0, 40.0)
    * }),
    * id : 'rectangle',
    * attributes : {
    * color : new Cesium.ColorGeometryInstanceAttribute(0.0, 1.0, 1.0, 0.5)
    * }
    * });
    * scene.primitives.add(new Cesium.GroundPrimitive({
    * geometryInstances : rectangleInstance
    * }));
    *
    * // Example 2: Batch instances
    * var color = new Cesium.ColorGeometryInstanceAttribute(0.0, 1.0, 1.0, 0.5); // Both instances must have the same color.
    * var rectangleInstance = new Cesium.GeometryInstance({
    * geometry : new Cesium.RectangleGeometry({
    * rectangle : Cesium.Rectangle.fromDegrees(-140.0, 30.0, -100.0, 40.0)
    * }),
    * id : 'rectangle',
    * attributes : {
    * color : color
    * }
    * });
    * var ellipseInstance = new Cesium.GeometryInstance({
    * geometry : new Cesium.EllipseGeometry({
    * center : Cesium.Cartesian3.fromDegrees(-105.0, 40.0),
    * semiMinorAxis : 300000.0,
    * semiMajorAxis : 400000.0
    * }),
    * id : 'ellipse',
    * attributes : {
    * color : color
    * }
    * });
    * scene.primitives.add(new Cesium.GroundPrimitive({
    * geometryInstances : [rectangleInstance, ellipseInstance]
    * }));
    * @see Primitive
    * @see GeometryInstance
    * @see Appearance
    */
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

  /**
    * An imagery layer that displays tiled image data from a single imagery provider
    * on a [[Globe]]
    *
    * alias ImageryLayer
    *
    *
    * - {ImageryProvider} imageryProvider The imagery provider to use.
    * - '''The ''options'' object takes the following properties'''
    * - {Rectangle} [options.rectangle=imageryProvider.rectangle] The rectangle of the layer.  This rectangle
    * can limit the visible portion of the imagery provider.
    * - {Number|Function} [options.alpha=1.0] The alpha blending value of this layer, from 0.0 to 1.0.
    * This can either be a simple number or a function with the signature
    * <code>function(frameState, layer, x, y, level)</code>.  The function is passed the
    * current frame state, this layer, and the x, y, and level coordinates of the
    * imagery tile for which the alpha is required, and it is expected to return
    * the alpha value to use for the tile.
    * - {Number|Function} [options.brightness=1.0] The brightness of this layer.  1.0 uses the unmodified imagery
    * color.  Less than 1.0 makes the imagery darker while greater than 1.0 makes it brighter.
    * This can either be a simple number or a function with the signature
    * <code>function(frameState, layer, x, y, level)</code>.  The function is passed the
    * current frame state, this layer, and the x, y, and level coordinates of the
    * imagery tile for which the brightness is required, and it is expected to return
    * the brightness value to use for the tile.  The function is executed for every
    * frame and for every tile, so it must be fast.
    * - {Number|Function} [options.contrast=1.0] The contrast of this layer.  1.0 uses the unmodified imagery color.
    * Less than 1.0 reduces the contrast while greater than 1.0 increases it.
    * This can either be a simple number or a function with the signature
    * <code>function(frameState, layer, x, y, level)</code>.  The function is passed the
    * current frame state, this layer, and the x, y, and level coordinates of the
    * imagery tile for which the contrast is required, and it is expected to return
    * the contrast value to use for the tile.  The function is executed for every
    * frame and for every tile, so it must be fast.
    * - {Number|Function} [options.hue=0.0] The hue of this layer.  0.0 uses the unmodified imagery color.
    * This can either be a simple number or a function with the signature
    * <code>function(frameState, layer, x, y, level)</code>.  The function is passed the
    * current frame state, this layer, and the x, y, and level coordinates
    * of the imagery tile for which the hue is required, and it is expected to return
    * the contrast value to use for the tile.  The function is executed for every
    * frame and for every tile, so it must be fast.
    * - {Number|Function} [options.saturation=1.0] The saturation of this layer.  1.0 uses the unmodified imagery color.
    * Less than 1.0 reduces the saturation while greater than 1.0 increases it.
    * This can either be a simple number or a function with the signature
    * <code>function(frameState, layer, x, y, level)</code>.  The function is passed the
    * current frame state, this layer, and the x, y, and level coordinates
    * of the imagery tile for which the saturation is required, and it is expected to return
    * the contrast value to use for the tile.  The function is executed for every
    * frame and for every tile, so it must be fast.
    * - {Number|Function} [options.gamma=1.0] The gamma correction to apply to this layer.  1.0 uses the unmodified imagery color.
    * This can either be a simple number or a function with the signature
    * <code>function(frameState, layer, x, y, level)</code>.  The function is passed the
    * current frame state, this layer, and the x, y, and level coordinates of the
    * imagery tile for which the gamma is required, and it is expected to return
    * the gamma value to use for the tile.  The function is executed for every
    * frame and for every tile, so it must be fast.
    * - {Boolean} [options.show=true] True if the layer is shown; otherwise, false.
    * - {Number} [options.maximumAnisotropy=maximum supported] The maximum anisotropy level to use
    * for texture filtering.  If this parameter is not specified, the maximum anisotropy supported
    * by the WebGL stack will be used.  Larger values make the imagery look better in horizon
    * views.
    * - {Number} [options.minimumTerrainLevel] The minimum terrain level-of-detail at which to show this imagery layer,
    * or undefined to show it at all levels.  Level zero is the least-detailed level.
    * - {Number} [options.maximumTerrainLevel] The maximum terrain level-of-detail at which to show this imagery layer,
    * or undefined to show it at all levels.  Level zero is the least-detailed level.
    */
  @js.native
  @JSName("Cesium.ImageryLayer")
  class ImageryLayer protected() extends js.Object {
    def this(imageryProvider: ImageryProvider, options: ImageryLayerOptions = ???) = this()

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

  /**
    * An ordered collection of imagery layers.
    *
    * alias ImageryLayerCollection
    *
    *
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Imagery%20Adjustment.html|Cesium Sandcastle Imagery Adjustment Demo]]
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Imagery%20Layers%20Manipulation.html|Cesium Sandcastle Imagery Manipulation Demo]]
    */
  @js.native
  @JSName("Cesium.ImageryLayerCollection")
  class ImageryLayerCollection() extends js.Object {
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

  /**
    * Describes a rasterized feature, such as a point, polygon, polyline, etc., in an imagery layer.
    *
    * alias ImageryLayerFeatureInfo
    *
    */
  @js.native
  @JSName("Cesium.ImageryLayerFeatureInfo")
  class ImageryLayerFeatureInfo() extends js.Object {
    var name: String = js.native
    var description: String = js.native
    var position: Cartographic = js.native
    var data: js.Any = js.native
    var imageryLayer: js.Any = js.native

    def configureNameFromProperties(properties: js.Any): js.Dynamic = js.native

    def configureDescriptionFromProperties(properties: js.Any): js.Dynamic = js.native
  }

  /**
    * Provides imagery to be displayed on the surface of an ellipsoid.  This type describes an
    * interface and is not intended to be instantiated directly.
    *
    * alias ImageryProvider
    *
    * @see ArcGisMapServerImageryProvider
    * @see SingleTileImageryProvider
    * @see BingMapsImageryProvider
    * @see GoogleEarthImageryProvider
    * @see MapboxImageryProvider
    * @see createOpenStreetMapImageryProvider
    * @see WebMapTileServiceImageryProvider
    * @see WebMapServiceImageryProvider
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Imagery%20Layers.html|Cesium Sandcastle Imagery Layers Demo]]
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Imagery%20Layers%20Manipulation.html|Cesium Sandcastle Imagery Manipulation Demo]]
    */
  @js.native
  trait ImageryProvider extends js.Object {
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
  trait ImageryProviderStatic extends js.Object {
    def loadImage(url: String): Promise[HTMLImageElement | HTMLCanvasElement] | Unit = js.native
  }

  /**
    * A Label draws viewport-aligned text positioned in the 3D scene.  This constructor
    * should not be used directly, instead create labels by calling [[LabelCollection#add]]
    *
    * alias Label
    *
    *
    * exception {DeveloperError} translucencyByDistance.far must be greater than translucencyByDistance.near
    * exception {DeveloperError} pixelOffsetScaleByDistance.far must be greater than pixelOffsetScaleByDistance.near
    *
    * @see LabelCollection
    * @see LabelCollection#add
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Labels.html|Cesium Sandcastle Labels Demo]]
    */
  @js.native
  trait Label extends js.Object {
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

    var showBackground: Boolean = js.native
    var backgroundColor: Color = js.native
    var backgroundPadding: Cartesian2 = js.native

    def computeScreenSpacePosition(scene: Scene, result: Cartesian2 = ???): Cartesian2 = js.native

    def equals(other: Label): Boolean = js.native

    def isDestroyed(): Boolean = js.native
  }

  /**
    * A renderable collection of labels.  Labels are viewport-aligned text positioned in the 3D scene.
    * Each label can have a different font, color, scale, etc.
    *
    * <div align='center'>
    * <img src='images/Label.png' width='400' height='300' /><br />
    * Example labels
    * </div>
    *
    * Labels are added and removed from the collection using [[LabelCollection#add]]
    * and [[LabelCollection#remove]]
    *
    * alias LabelCollection
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Matrix4} [options.modelMatrix=Matrix4.IDENTITY] The 4x4 transformation matrix that transforms each label from model to world coordinates.
    * - {Boolean} [options.debugShowBoundingVolume=false] For debugging only. Determines if this primitive's commands' bounding spheres are shown.
    * - {Scene} [options.scene] Must be passed in for labels that use the height reference property or will be depth tested against the globe.
    *
    * performance For best performance, prefer a few collections, each with many labels, to
    * many collections with only a few labels each.  Avoid having collections where some
    * labels change every frame and others do not; instead, create one or more collections
    * for static labels, and one or more collections for dynamic labels.
    *
    * @see LabelCollection#add
    * @see LabelCollection#remove
    * @see Label
    * @see BillboardCollection
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Labels.html|Cesium Sandcastle Labels Demo]]
    * @example
    * // Create a label collection with two labels
    * var labels = scene.primitives.add(new Cesium.LabelCollection());
    * labels.add({
    * position : new Cesium.Cartesian3(1.0, 2.0, 3.0),
    * text : 'A label'
    * });
    * labels.add({
    * position : new Cesium.Cartesian3(4.0, 5.0, 6.0),
    * text : 'Another label'
    * });
    */
  @js.native
  @JSName("Cesium.LabelCollection")
  class LabelCollection protected() extends js.Object {
    def this(options: LabelCollectionOptions) = this()

    var modelMatrix: Matrix4 = js.native
    var debugShowBoundingVolume: Boolean = js.native
    var length: Double = js.native

    def add(options: LabelOptions = ???): Label = js.native

    def remove(label: Label): Boolean = js.native

    def removeAll(): js.Dynamic = js.native

    def contains(label: Label): Boolean = js.native

    def get(index: Double): Label = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  /**
    * Provides tiled imagery hosted by Mapbox.
    *
    * alias MapboxImageryProvider
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {String} [options.url='https://api.mapbox.com/v4/'] The Mapbox server url.
    * - {String} options.mapId The Mapbox Map ID.
    * - {String} [options.accessToken] The public access token for the imagery.
    * - {String} [options.format='png'] The format of the image request.
    * - {Object} [options.proxy] A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL.
    * - {Ellipsoid} [options.ellipsoid] The ellipsoid.  If not specified, the WGS84 ellipsoid is used.
    * - {Number} [options.minimumLevel=0] The minimum level-of-detail supported by the imagery provider.  Take care when specifying
    * this that the number of tiles at the minimum level is small, such as four or less.  A larger number is likely
    * to result in rendering problems.
    * - {Number} [options.maximumLevel] The maximum level-of-detail supported by the imagery provider, or undefined if there is no limit.
    * - {Rectangle} [options.rectangle=Rectangle.MAX_VALUE] The rectangle, in radians, covered by the image.
    * - {Credit|String} [options.credit] A credit for the data source, which is displayed on the canvas.
    *
    * @example
    * // Mapbox tile provider
    * var mapbox = new Cesium.MapboxImageryProvider({
    * mapId: 'mapbox.streets',
    * accessToken: 'thisIsMyAccessToken'
    * });
    * @see [[https://www.mapbox.com/developers/api/maps/#tiles]]
    * @see [[https://www.mapbox.com/developers/api/#access-tokens]]
    */
  @js.native
  @JSName("Cesium.MapboxImageryProvider")
  class MapboxImageryProvider protected() extends ImageryProvider {
    def this(options: MapboxImageryProviderOptions) = this()

    var url: String = js.native
  }

  @js.native
  @JSName("Cesium.MapboxImageryProvider")
  object MapboxImageryProvider extends ImageryProviderStatic


  /**
    * A Material defines surface appearance through a combination of diffuse, specular,
    * normal, emission, and alpha components. These values are specified using a
    * JSON schema called Fabric which gets parsed and assembled into glsl shader code
    * behind-the-scenes. Check out the [[https://github.com/AnalyticalGraphicsInc/cesium/wiki/Fabric|wiki page]]
    * for more details on Fabric.
    *
    * <style type="text/css">
    * #materialDescriptions code {
    * font-weight: normal;
    * font-family: Consolas, 'Lucida Console', Monaco, monospace;
    * color: #A35A00;
    * }
    * #materialDescriptions ul, #materialDescriptions ul ul {
    * list-style-type: none;
    * }
    * #materialDescriptions ul ul {
    * margin-bottom: 10px;
    * }
    * #materialDescriptions ul ul li {
    * font-weight: normal;
    * color: #000000;
    * text-indent: -2em;
    * margin-left: 2em;
    * }
    * #materialDescriptions ul li {
    * font-weight: bold;
    * color: #0053CF;
    * }
    * </style>
    *
    * Base material types and their uniforms:
    * <div id='materialDescriptions'>
    * <ul>
    * <li>Color</li>
    * <ul>
    * <li><code>color</code>:  rgba color object.</li>
    * </ul>
    * <li>Image</li>
    * <ul>
    * <li><code>image</code>:  path to image.</li>
    * <li><code>repeat</code>:  Object with x and y values specifying the number of times to repeat the image.</li>
    * </ul>
    * <li>DiffuseMap</li>
    * <ul>
    * <li><code>image</code>:  path to image.</li>
    * <li><code>channels</code>:  Three character string containing any combination of r, g, b, and a for selecting the desired image channels.</li>
    * <li><code>repeat</code>:  Object with x and y values specifying the number of times to repeat the image.</li>
    * </ul>
    * <li>AlphaMap</li>
    * <ul>
    * <li><code>image</code>:  path to image.</li>
    * <li><code>channel</code>:  One character string containing r, g, b, or a for selecting the desired image channel. </li>
    * <li><code>repeat</code>:  Object with x and y values specifying the number of times to repeat the image.</li>
    * </ul>
    * <li>SpecularMap</li>
    * <ul>
    * <li><code>image</code>: path to image.</li>
    * <li><code>channel</code>: One character string containing r, g, b, or a for selecting the desired image channel. </li>
    * <li><code>repeat</code>: Object with x and y values specifying the number of times to repeat the image.</li>
    * </ul>
    * <li>EmissionMap</li>
    * <ul>
    * <li><code>image</code>:  path to image.</li>
    * <li><code>channels</code>:  Three character string containing any combination of r, g, b, and a for selecting the desired image channels. </li>
    * <li><code>repeat</code>:  Object with x and y values specifying the number of times to repeat the image.</li>
    * </ul>
    * <li>BumpMap</li>
    * <ul>
    * <li><code>image</code>:  path to image.</li>
    * <li><code>channel</code>:  One character string containing r, g, b, or a for selecting the desired image channel. </li>
    * <li><code>repeat</code>:  Object with x and y values specifying the number of times to repeat the image.</li>
    * <li><code>strength</code>:  Bump strength value between 0.0 and 1.0 where 0.0 is small bumps and 1.0 is large bumps.</li>
    * </ul>
    * <li>NormalMap</li>
    * <ul>
    * <li><code>image</code>:  path to image.</li>
    * <li><code>channels</code>:  Three character string containing any combination of r, g, b, and a for selecting the desired image channels. </li>
    * <li><code>repeat</code>:  Object with x and y values specifying the number of times to repeat the image.</li>
    * <li><code>strength</code>:  Bump strength value between 0.0 and 1.0 where 0.0 is small bumps and 1.0 is large bumps.</li>
    * </ul>
    * <li>Grid</li>
    * <ul>
    * <li><code>color</code>:  rgba color object for the whole material.</li>
    * <li><code>cellAlpha</code>: Alpha value for the cells between grid lines.  This will be combined with color.alpha.</li>
    * <li><code>lineCount</code>:  Object with x and y values specifying the number of columns and rows respectively.</li>
    * <li><code>lineThickness</code>:  Object with x and y values specifying the thickness of grid lines (in pixels where available).</li>
    * <li><code>lineOffset</code>:  Object with x and y values specifying the offset of grid lines (range is 0 to 1).</li>
    * </ul>
    * <li>Stripe</li>
    * <ul>
    * <li><code>horizontal</code>:  Boolean that determines if the stripes are horizontal or vertical.</li>
    * <li><code>evenColor</code>:  rgba color object for the stripe's first color.</li>
    * <li><code>oddColor</code>:  rgba color object for the stripe's second color.</li>
    * <li><code>offset</code>:  Number that controls at which point into the pattern to begin drawing; with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between.</li>
    * <li><code>repeat</code>:  Number that controls the total number of stripes, half light and half dark.</li>
    * </ul>
    * <li>Checkerboard</li>
    * <ul>
    * <li><code>lightColor</code>:  rgba color object for the checkerboard's light alternating color.</li>
    * <li><code>darkColor</code>: rgba color object for the checkerboard's dark alternating color.</li>
    * <li><code>repeat</code>:  Object with x and y values specifying the number of columns and rows respectively.</li>
    * </ul>
    * <li>Dot</li>
    * <ul>
    * <li><code>lightColor</code>:  rgba color object for the dot color.</li>
    * <li><code>darkColor</code>:  rgba color object for the background color.</li>
    * <li><code>repeat</code>:  Object with x and y values specifying the number of columns and rows of dots respectively.</li>
    * </ul>
    * <li>Water</li>
    * <ul>
    * <li><code>baseWaterColor</code>:  rgba color object base color of the water.</li>
    * <li><code>blendColor</code>:  rgba color object used when blending from water to non-water areas.</li>
    * <li><code>specularMap</code>:  Single channel texture used to indicate areas of water.</li>
    * <li><code>normalMap</code>:  Normal map for water normal perturbation.</li>
    * <li><code>frequency</code>:  Number that controls the number of waves.</li>
    * <li><code>normalMap</code>:  Normal map for water normal perturbation.</li>
    * <li><code>animationSpeed</code>:  Number that controls the animations speed of the water.</li>
    * <li><code>amplitude</code>:  Number that controls the amplitude of water waves.</li>
    * <li><code>specularIntensity</code>:  Number that controls the intensity of specular reflections.</li>
    * </ul>
    * <li>RimLighting</li>
    * <ul>
    * <li><code>color</code>:  diffuse color and alpha.</li>
    * <li><code>rimColor</code>:  diffuse color and alpha of the rim.</li>
    * <li><code>width</code>:  Number that determines the rim's width.</li>
    * </ul>
    * <li>Fade</li>
    * <ul>
    * <li><code>fadeInColor</code>: diffuse color and alpha at <code>time</code></li>
    * <li><code>fadeOutColor</code>: diffuse color and alpha at <code>maximumDistance</code> from <code>time</code></li>
    * <li><code>maximumDistance</code>: Number between 0.0 and 1.0 where the <code>fadeInColor</code> becomes the <code>fadeOutColor</code>. A value of 0.0 gives the entire material a color of <code>fadeOutColor</code> and a value of 1.0 gives the the entire material a color of <code>fadeInColor</code></li>
    * <li><code>repeat</code>: true if the fade should wrap around the texture coodinates.</li>
    * <li><code>fadeDirection</code>: Object with x and y values specifying if the fade should be in the x and y directions.</li>
    * <li><code>time</code>: Object with x and y values between 0.0 and 1.0 of the <code>fadeInColor</code> position</li>
    * </ul>
    * <li>PolylineArrow</li>
    * <ul>
    * <li><code>color</code>: diffuse color and alpha.</li>
    * </ul>
    * <li>PolylineGlow</li>
    * <ul>
    * <li><code>color</code>: color and maximum alpha for the glow on the line.</li>
    * <li><code>glowPower</code>: strength of the glow, as a percentage of the total line width (less than 1.0).</li>
    * </ul>
    * <li>PolylineOutline</li>
    * <ul>
    * <li><code>color</code>: diffuse color and alpha for the interior of the line.</li>
    * <li><code>outlineColor</code>: diffuse color and alpha for the outline.</li>
    * <li><code>outlineWidth</code>: width of the outline in pixels.</li>
    * </ul>
    * </ul>
    * </div>
    *
    * alias Material
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Boolean} [options.strict=false] Throws errors for issues that would normally be ignored, including unused uniforms or materials.
    * - {Boolean|Function} [options.translucent=true] When <code>true</code> or a function that returns <code>true</code>, the geometry
    * with this material is expected to appear translucent.
    * - {Object} options.fabric The fabric JSON used to generate the material.
    *
    *
    *
    * exception {DeveloperError} fabric: uniform has invalid type.
    * exception {DeveloperError} fabric: uniforms and materials cannot share the same property.
    * exception {DeveloperError} fabric: cannot have source and components in the same section.
    * exception {DeveloperError} fabric: property name is not valid. It should be 'type', 'materials', 'uniforms', 'components', or 'source'.
    * exception {DeveloperError} fabric: property name is not valid. It should be 'diffuse', 'specular', 'shininess', 'normal', 'emission', or 'alpha'.
    * exception {DeveloperError} strict: shader source does not use string.
    * exception {DeveloperError} strict: shader source does not use uniform.
    * exception {DeveloperError} strict: shader source does not use material.
    *
    * @see [[https://github.com/AnalyticalGraphicsInc/cesium/wiki/Fabric|Fabric wiki page]] for a more detailed options of Fabric.
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Materials.html|Cesium Sandcastle Materials Demo]]
    * @example
    * // Create a color material with fromType:
    * polygon.material = Cesium.Material.fromType('Color');
    * polygon.material.uniforms.color = new Cesium.Color(1.0, 1.0, 0.0, 1.0);
    *
    * // Create the default material:
    * polygon.material = new Cesium.Material();
    *
    * // Create a color material with full Fabric notation:
    * polygon.material = new Cesium.Material({
    * fabric : {
    * type : 'Color',
    * uniforms : {
    * color : new Cesium.Color(1.0, 1.0, 0.0, 1.0)
    * }
    * }
    * });
    */
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

  /**
    * An appearance for arbitrary geometry (as opposed to [[EllipsoidSurfaceAppearance]], for example)
    * that supports shading with materials.
    *
    * alias MaterialAppearance
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Boolean} [options.flat=false] When <code>true</code>, flat shading is used in the fragment shader, which means lighting is not taking into account.
    * - {Boolean} [options.faceForward=!options.closed] When <code>true</code>, the fragment shader flips the surface normal as needed to ensure that the normal faces the viewer to avoid dark spots.  This is useful when both sides of a geometry should be shaded like [[WallGeometry]]
    * - {Boolean} [options.translucent=true] When <code>true</code>, the geometry is expected to appear translucent so [[MaterialAppearance#renderState]] has alpha blending enabled.
    * - {Boolean} [options.closed=false] When <code>true</code>, the geometry is expected to be closed so [[MaterialAppearance#renderState]] has backface culling enabled.
    * - {MaterialAppearance.MaterialSupport} [options.materialSupport=MaterialAppearance.MaterialSupport.TEXTURED] The type of materials that will be supported.
    * - {Material} [options.material=Material.ColorType] The material used to determine the fragment color.
    * - {String} [options.vertexShaderSource] Optional GLSL vertex shader source to override the default vertex shader.
    * - {String} [options.fragmentShaderSource] Optional GLSL fragment shader source to override the default fragment shader.
    * - {RenderState} [options.renderState] Optional render state to override the default render state.
    *
    * @see [[https://github.com/AnalyticalGraphicsInc/cesium/wiki/Fabric|Fabric]]
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Materials.html|Cesium Sandcastle Material Appearance Demo]]
    * @example
    * var primitive = new Cesium.Primitive({
    * geometryInstances : new Cesium.GeometryInstance({
    * geometry : new Cesium.WallGeometry({
    * materialSupport :  Cesium.MaterialAppearance.MaterialSupport.BASIC.vertexFormat,
    * // ...
    * })
    * }),
    * appearance : new Cesium.MaterialAppearance({
    * material : Cesium.Material.fromType('Color'),
    * faceForward : true
    * })
    *
    * });
    */
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

  /**
    * A 3D model based on glTF, the runtime asset format for WebGL, OpenGL ES, and OpenGL.
    * <p>
    * Cesium includes support for geometry and materials, glTF animations, and glTF skinning.
    * In addition, individual glTF nodes are pickable with [[Scene#pick]] and animatable
    * with [[Model#getNode]]   glTF cameras and lights are not currently supported.
    * </p>
    * <p>
    * An external glTF asset is created with [[Model]]   glTF JSON can also be
    * created at runtime and passed to this constructor function.  In either case, the
    * [[Model#readyPromise]] is resolved when the model is ready to render, i.e.,
    * when the external binary, image, and shader files are downloaded and the WebGL
    * resources are created.
    * </p>
    * <p>
    * For high-precision rendering, Cesium supports the CESIUM_RTC extension, which introduces the
    * CESIUM_RTC_MODELVIEW parameter semantic that says the node is in WGS84 coordinates translated
    * relative to a local origin.
    * </p>
    *
    * alias Model
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Object|ArrayBuffer|Uint8Array} [options.gltf] The object for the glTF JSON or an arraybuffer of Binary glTF defined by the KHR_binary_glTF extension.
    * - {String} [options.basePath= ] The base path that paths in the glTF JSON are relative to.
    * - {Boolean} [options.show=true] Determines if the model primitive will be shown.
    * - {Matrix4} [options.modelMatrix=Matrix4.IDENTITY] The 4x4 transformation matrix that transforms the model from model to world coordinates.
    * - {Number} [options.scale=1.0] A uniform scale applied to this model.
    * - {Number} [options.minimumPixelSize=0.0] The approximate minimum pixel size of the model regardless of zoom.
    * - {Number} [options.maximumScale] The maximum scale size of a model. An upper limit for minimumPixelSize.
    * - {Object} [options.id] A user-defined object to return when the model is picked with [[Scene#pick]]
    * - {Boolean} [options.allowPicking=true] When <code>true</code>, each glTF mesh and primitive is pickable with [[Scene#pick]]
    * - {Boolean} [options.incrementallyLoadTextures=true] Determine if textures may continue to stream in after the model is loaded.
    * - {Boolean} [options.asynchronous=true] Determines if model WebGL resource creation will be spread out over several frames or block until completion once all glTF files are loaded.
    * - {Boolean} [options.debugShowBoundingVolume=false] For debugging only. Draws the bounding sphere for each draw command in the model.
    * - {Boolean} [options.debugWireframe=false] For debugging only. Draws the model in wireframe.
    *
    * exception {DeveloperError} bgltf is not a valid Binary glTF file.
    * exception {DeveloperError} Only glTF Binary version 1 is supported.
    *
    * @see Model.fromGltf
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=3D%20Models.html|Cesium Sandcastle Models Demo]]
    */
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

    var color: Color = js.native
    var colorBlendMode: ColorBlendMode = js.native
    var colorBlendAmount: Double = js.native

    var silhouetteColor: Color = js.native
    var silhouetteSize: Double = js.native

    var castShadows: Boolean = js.native

    var heightReference: HeightReference = js.native

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
    def fromGltf(options: ModelFromGltfOptions): Model = js.native
  }

  /**
    * An active glTF animation.  A glTF asset can contain animations.  An active animation
    * is an animation that is currently playing or scheduled to be played because it was
    * added to a model's [[ModelAnimationCollection]]   An active animation is an
    * instance of an animation; for example, there can be multiple active animations
    * for the same glTF animation, each with a different start time.
    * <p>
    * Create this by calling [[ModelAnimationCollection#add]]
    * </p>
    *
    * alias ModelAnimation
    *
    * @see ModelAnimationCollection#add
    */
  @js.native
  trait ModelAnimation extends js.Object {
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

  /**
    * A collection of active model animations.  Access this using [[Model#activeAnimations]]
    *
    * alias ModelAnimationCollection
    *
    * @see Model#activeAnimations
    */
  @js.native
  trait ModelAnimationCollection extends js.Object {
    var animationAdded: Event = js.native
    var animationRemoved: Event = js.native
    var length: Double = js.native

    def add(options: ModelAnimationCollectionAddOptions): ModelAnimation = js.native

    def addAll(options: ModelAnimationCollectionAddAllOptions = ???): js.Array[ModelAnimation] = js.native

    def remove(animation: ModelAnimation): Boolean = js.native

    def removeAll(): js.Dynamic = js.native

    def contains(animation: ModelAnimation): Boolean = js.native

    def get(index: Double): ModelAnimation = js.native
  }

  /**
    * A model's material with modifiable parameters.  A glTF material
    * contains parameters defined by the material's technique with values
    * defined by the technique and potentially overridden by the material.
    * This class allows changing these values at runtime.
    * <p>
    * Use [[Model#getMaterial]] to create an instance.
    * </p>
    *
    * alias ModelMaterial
    *
    * @see Model#getMaterial
    */
  @js.native
  trait ModelMaterial extends js.Object {
    var name: String = js.native
    var id: String = js.native

    def setValue(name: String, value: js.Any = ???): js.Dynamic = js.native

    def getValue(name: String): js.Dynamic = js.native
  }

  /**
    * A model's mesh and its materials.
    * <p>
    * Use [[Model#getMesh]] to create an instance.
    * </p>
    *
    * alias ModelMesh
    *
    * @see Model#getMesh
    */
  @js.native
  trait ModelMesh extends js.Object {
    var name: String = js.native
    var id: String = js.native
    var materials: js.Array[ModelMaterial] = js.native
  }

  /**
    * A model node with a transform for user-defined animations.  A glTF asset can
    * contain animations that target a node's transform.  This class allows
    * changing a node's transform externally so animation can be driven by another
    * source, not just an animation in the glTF asset.
    * <p>
    * Use [[Model#getNode]] to create an instance.
    * </p>
    *
    * alias ModelNode
    *
    * @example
    * var node = model.getNode('LOD3sp');
    * node.matrix = Cesium.Matrix4.fromScale(new Cesium.Cartesian3(5.0, 1.0, 1.0), node.matrix);
    * @see Model#getNode
    */
  @js.native
  trait ModelNode extends js.Object {
    var name: String = js.native
    var id: String = js.native
    var show: Boolean = js.native
    var matrix: Matrix4 = js.native
  }

  /**
    * Draws the Moon in 3D.
    * alias Moon
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Boolean} [options.show=true] Determines whether the moon will be rendered.
    * - {String} [options.textureUrl=buildModuleUrl('Assets/Textures/moonSmall.jpg')] The moon texture.
    * - {Ellipsoid} [options.ellipsoid=Ellipsoid.MOON] The moon ellipsoid.
    * - {Boolean} [options.onlySunLighting=true] Use the sun as the only light source.
    *
    * @example
    * scene.moon = new Cesium.Moon();
    * @see Scene#moon
    */
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

  /**
    * A [[TileDiscardPolicy]] specifying that tile images should never be discard.
    *
    * alias NeverTileDiscardPolicy
    *
    * @see DiscardMissingTileImagePolicy
    */
  @js.native
  @JSName("Cesium.NeverTileDiscardPolicy")
  class NeverTileDiscardPolicy() extends TileDiscardPolicy

  /**
    * The viewing frustum is defined by 6 planes.
    * Each plane is represented by a [[Cartesian4]] object, where the x, y, and z components
    * define the unit vector normal to the plane, and the w component is the distance of the
    * plane from the origin/camera position.
    *
    * alias OrthographicFrustum
    *
    * @example
    * var maxRadii = ellipsoid.maximumRadius;
    *
    * var frustum = new Cesium.OrthographicFrustum();
    * frustum.right = maxRadii * Cesium.Math.PI;
    * frustum.left = -c.frustum.right;
    * frustum.top = c.frustum.right * (canvas.clientHeight / canvas.clientWidth);
    * frustum.bottom = -c.frustum.top;
    * frustum.near = 0.01 * maxRadii;
    * frustum.far = 50.0 * maxRadii;
    */
  @js.native
  @JSName("Cesium.OrthographicFrustum")
  class OrthographicFrustum() extends Frustum {
    var left: Double = js.native
    var right: Double = js.native
    var top: Double = js.native
    var bottom: Double = js.native
    var near: Double = js.native
    var far: Double = js.native
    var projectionMatrix: Matrix4 = js.native

    def computeCullingVolume(position: Cartesian3, direction: Cartesian3, up: Cartesian3): CullingVolume = js.native

    def getPixelDimensions(drawingBufferWidth: Double, drawingBufferHeight: Double, distance: Double, result: Cartesian2 = ???): Cartesian2 = js.native

    def clone(result: OrthographicFrustum = ???): OrthographicFrustum = js.native

    def equals(other: OrthographicFrustum = ???): Boolean = js.native
  }

  /**
    * An appearance for [[GeometryInstance]] instances with color attributes.
    * This allows several geometry instances, each with a different color, to
    * be drawn with the same [[Primitive]] as shown in the second example below.
    *
    * alias PerInstanceColorAppearance
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Boolean} [options.flat=false] When <code>true</code>, flat shading is used in the fragment shader, which means lighting is not taking into account.
    * - {Boolean} [options.faceForward=!options.closed] When <code>true</code>, the fragment shader flips the surface normal as needed to ensure that the normal faces the viewer to avoid dark spots.  This is useful when both sides of a geometry should be shaded like [[WallGeometry]]
    * - {Boolean} [options.translucent=true] When <code>true</code>, the geometry is expected to appear translucent so [[PerInstanceColorAppearance#renderState]] has alpha blending enabled.
    * - {Boolean} [options.closed=false] When <code>true</code>, the geometry is expected to be closed so [[PerInstanceColorAppearance#renderState]] has backface culling enabled.
    * - {String} [options.vertexShaderSource] Optional GLSL vertex shader source to override the default vertex shader.
    * - {String} [options.fragmentShaderSource] Optional GLSL fragment shader source to override the default fragment shader.
    * - {RenderState} [options.renderState] Optional render state to override the default render state.
    *
    * @example
    * // A solid white line segment
    * var primitive = new Cesium.Primitive({
    * geometryInstances : new Cesium.GeometryInstance({
    * geometry : new Cesium.SimplePolylineGeometry({
    * positions : Cesium.Cartesian3.fromDegreesArray([
    * 0.0, 0.0,
    * 5.0, 0.0
    * ])
    * }),
    * attributes : {
    * color : Cesium.ColorGeometryInstanceAttribute.fromColor(new Cesium.Color(1.0, 1.0, 1.0, 1.0))
    * }
    * }),
    * appearance : new Cesium.PerInstanceColorAppearance({
    * flat : true,
    * translucent : false
    * })
    * });
    *
    * // Two rectangles in a primitive, each with a different color
    * var instance = new Cesium.GeometryInstance({
    * geometry : new Cesium.RectangleGeometry({
    * rectangle : Cesium.Rectangle.fromDegrees(0.0, 20.0, 10.0, 30.0)
    * }),
    * attributes : {
    * color : new Cesium.Color(1.0, 0.0, 0.0, 0.5)
    * }
    * });
    *
    * var anotherInstance = new Cesium.GeometryInstance({
    * geometry : new Cesium.RectangleGeometry({
    * rectangle : Cesium.Rectangle.fromDegrees(0.0, 40.0, 10.0, 50.0)
    * }),
    * attributes : {
    * color : new Cesium.Color(0.0, 0.0, 1.0, 0.5)
    * }
    * });
    *
    * var rectanglePrimitive = new Cesium.Primitive({
    * geometryInstances : [instance, anotherInstance],
    * appearance : new Cesium.PerInstanceColorAppearance()
    * });
    */
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

  /**
    * The viewing frustum is defined by 6 planes.
    * Each plane is represented by a [[Cartesian4]] object, where the x, y, and z components
    * define the unit vector normal to the plane, and the w component is the distance of the
    * plane from the origin/camera position.
    *
    * alias PerspectiveFrustum
    *
    * @example
    * var frustum = new Cesium.PerspectiveFrustum();
    * frustum.aspectRatio = canvas.clientWidth / canvas.clientHeight;
    * frustum.fov = Cesium.Math.PI_OVER_THREE;
    * frustum.near = 1.0;
    * frustum.far = 2.0;
    * @see PerspectiveOffCenterFrustum
    */
  @js.native
  @JSName("Cesium.PerspectiveFrustum")
  class PerspectiveFrustum() extends Frustum {
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

    def getPixelDimensions(drawingBufferWidth: Double, drawingBufferHeight: Double, distance: Double, result: Cartesian2 = ???): Cartesian2 = js.native

    def clone(result: PerspectiveFrustum = ???): PerspectiveFrustum = js.native

    def equals(other: PerspectiveFrustum = ???): Boolean = js.native
  }

  /**
    * The viewing frustum is defined by 6 planes.
    * Each plane is represented by a [[Cartesian4]] object, where the x, y, and z components
    * define the unit vector normal to the plane, and the w component is the distance of the
    * plane from the origin/camera position.
    *
    * alias PerspectiveOffCenterFrustum
    *
    * @example
    * var frustum = new Cesium.PerspectiveOffCenterFrustum();
    * frustum.right = 1.0;
    * frustum.left = -1.0;
    * frustum.top = 1.0;
    * frustum.bottom = -1.0;
    * frustum.near = 1.0;
    * frustum.far = 2.0;
    * @see PerspectiveFrustum
    */
  @js.native
  @JSName("Cesium.PerspectiveOffCenterFrustum")
  class PerspectiveOffCenterFrustum() extends Frustum {
    var left: Double = js.native
    var right: Double = js.native
    var top: Double = js.native
    var bottom: Double = js.native
    var near: Double = js.native
    var far: Double = js.native
    var projectionMatrix: Matrix4 = js.native
    var infiniteProjectionMatrix: Matrix4 = js.native

    def computeCullingVolume(position: Cartesian3, direction: Cartesian3, up: Cartesian3): CullingVolume = js.native

    def getPixelDimensions(drawingBufferWidth: Double, drawingBufferHeight: Double, distance: Double, result: Cartesian2 = ???): Cartesian2 = js.native

    def clone(result: PerspectiveOffCenterFrustum = ???): PerspectiveOffCenterFrustum = js.native

    def equals(other: PerspectiveOffCenterFrustum = ???): Boolean = js.native
  }

  /**
    * A graphical point positioned in the 3D scene, that is created
    * and rendered using a [[PointPrimitiveCollection]]   A point is created and its initial
    * properties are set by calling [[PointPrimitiveCollection#add]]
    *
    * alias PointPrimitive
    *
    * performance Reading a property, e.g., [[PointPrimitive#show]], is constant time.
    * Assigning to a property is constant time but results in
    * CPU to GPU traffic when [[PointPrimitiveCollection]] is called.  The per-pointPrimitive traffic is
    * the same regardless of how many properties were updated.  If most pointPrimitives in a collection need to be
    * updated, it may be more efficient to clear the collection with [[PointPrimitiveCollection#removeAll]]
    * and add new pointPrimitives instead of modifying each one.
    *
    * exception {DeveloperError} scaleByDistance.far must be greater than scaleByDistance.near
    * exception {DeveloperError} translucencyByDistance.far must be greater than translucencyByDistance.near
    *
    * @see PointPrimitiveCollection
    * @see PointPrimitiveCollection#add
    *
    *
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Points.html|Cesium Sandcastle Points Demo]]
    */
  @js.native
  trait PointPrimitive extends js.Object {
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

  /**
    * A renderable collection of points.
    *
    * Points are added and removed from the collection using [[PointPrimitiveCollection#add]]
    * and [[PointPrimitiveCollection#remove]]
    *
    * alias PointPrimitiveCollection
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Matrix4} [options.modelMatrix=Matrix4.IDENTITY] The 4x4 transformation matrix that transforms each point from model to world coordinates.
    * - {Boolean} [options.debugShowBoundingVolume=false] For debugging only. Determines if this primitive's commands' bounding spheres are shown.
    *
    * performance For best performance, prefer a few collections, each with many points, to
    * many collections with only a few points each.  Organize collections so that points
    * with the same update frequency are in the same collection, i.e., points that do not
    * change should be in one collection; points that change every frame should be in another
    * collection; and so on.
    *
    * @example
    * // Create a pointPrimitive collection with two points
    * var points = scene.primitives.add(new Cesium.PointPrimitiveCollection());
    * points.add({
    * position : new Cesium.Cartesian3(1.0, 2.0, 3.0),
    * color : Cesium.Color.YELLOW
    * });
    * points.add({
    * position : new Cesium.Cartesian3(4.0, 5.0, 6.0),
    * color : Cesium.Color.CYAN
    * });
    * @see PointPrimitiveCollection#add
    * @see PointPrimitiveCollection#remove
    * @see PointPrimitive
    */
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

  /**
    * A renderable polyline. Create this by calling [[PolylineCollection#add]]
    *
    * alias Polyline
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Boolean} [options.show=true] <code>true</code> if this polyline will be shown; otherwise, <code>false</code>.
    * - {Number} [options.width=1.0] The width of the polyline in pixels.
    * - {Boolean} [options.loop=false] Whether a line segment will be added between the last and first line positions to make this line a loop.
    * - {Material} [options.material=Material.ColorType] The material.
    * - {Cartesian3[]} [options.positions] The positions.
    * - {Object} [options.id] The user-defined object to be returned when this polyline is picked.
    *
    * @see PolylineCollection
    *
    */
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

  /**
    * A renderable collection of polylines.
    *
    * <div align="center">
    * <img src="images/Polyline.png" width="400" height="300" /><br />
    * Example polylines
    * </div>
    *
    * Polylines are added and removed from the collection using [[PolylineCollection#add]]
    * and [[PolylineCollection#remove]]
    *
    * alias PolylineCollection
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Matrix4} [options.modelMatrix=Matrix4.IDENTITY] The 4x4 transformation matrix that transforms each polyline from model to world coordinates.
    * - {Boolean} [options.debugShowBoundingVolume=false] For debugging only. Determines if this primitive's commands' bounding spheres are shown.
    *
    * performance For best performance, prefer a few collections, each with many polylines, to
    * many collections with only a few polylines each.  Organize collections so that polylines
    * with the same update frequency are in the same collection, i.e., polylines that do not
    * change should be in one collection; polylines that change every frame should be in another
    * collection; and so on.
    *
    * @see PolylineCollection#add
    * @see PolylineCollection#remove
    * @see Polyline
    * @see LabelCollection
    * @example
    * // Create a polyline collection with two polylines
    * var polylines = new Cesium.PolylineCollection();
    * polylines.add({
    * positions : Cesium.Cartesian3.fromDegreesArray([
    * -75.10, 39.57,
    * -77.02, 38.53,
    * -80.50, 35.14,
    * -80.12, 25.46]),
    * width : 2
    * });
    *
    * polylines.add({
    * positions : Cesium.Cartesian3.fromDegreesArray([
    * -73.10, 37.57,
    * -75.02, 36.53,
    * -78.50, 33.14,
    * -78.12, 23.46]),
    * width : 4
    * });
    */
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

  /**
    * An appearance for [[GeometryInstance]] instances with color attributes and [[PolylineGeometry]]
    * This allows several geometry instances, each with a different color, to
    * be drawn with the same [[Primitive]]
    *
    * alias PolylineColorAppearance
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Boolean} [options.translucent=true] When <code>true</code>, the geometry is expected to appear translucent so [[PolylineColorAppearance#renderState]] has alpha blending enabled.
    * - {String} [options.vertexShaderSource] Optional GLSL vertex shader source to override the default vertex shader.
    * - {String} [options.fragmentShaderSource] Optional GLSL fragment shader source to override the default fragment shader.
    * - {RenderState} [options.renderState] Optional render state to override the default render state.
    *
    * @example
    * // A solid white line segment
    * var primitive = new Cesium.Primitive({
    * geometryInstances : new Cesium.GeometryInstance({
    * geometry : new Cesium.PolylineGeometry({
    * positions : Cesium.Cartesian3.fromDegreesArray([
    * 0.0, 0.0,
    * 5.0, 0.0
    * ]),
    * width : 10.0,
    * vertexFormat : Cesium.PolylineColorAppearance.VERTEX_FORMAT
    * }),
    * attributes : {
    * color : Cesium.ColorGeometryInstanceAttribute.fromColor(new Cesium.Color(1.0, 1.0, 1.0, 1.0))
    * }
    * }),
    * appearance : new Cesium.PolylineColorAppearance({
    * translucent : false
    * })
    * });
    */
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

  /**
    * An appearance for [[PolylineGeometry]] that supports shading with materials.
    *
    * alias PolylineMaterialAppearance
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Boolean} [options.translucent=true] When <code>true</code>, the geometry is expected to appear translucent so [[PolylineMaterialAppearance#renderState]] has alpha blending enabled.
    * - {Material} [options.material=Material.ColorType] The material used to determine the fragment color.
    * - {String} [options.vertexShaderSource] Optional GLSL vertex shader source to override the default vertex shader.
    * - {String} [options.fragmentShaderSource] Optional GLSL fragment shader source to override the default fragment shader.
    * - {RenderState} [options.renderState] Optional render state to override the default render state.
    *
    * @see [[https://github.com/AnalyticalGraphicsInc/cesium/wiki/Fabric|Fabric]]
    * @example
    * var primitive = new Cesium.Primitive({
    * geometryInstances : new Cesium.GeometryInstance({
    * geometry : new Cesium.PolylineGeometry({
    * positions : Cesium.Cartesian3.fromDegreesArray([
    * 0.0, 0.0,
    * 5.0, 0.0
    * ]),
    * width : 10.0,
    * vertexFormat : Cesium.PolylineMaterialAppearance.VERTEX_FORMAT
    * })
    * }),
    * appearance : new Cesium.PolylineMaterialAppearance({
    * material : Cesium.Material.fromType('Color')
    * })
    * });
    */
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

  /**
    * A primitive represents geometry in the [[Scene]]   The geometry can be from a single [[GeometryInstance]]
    * as shown in example 1 below, or from an array of instances, even if the geometry is from different
    * geometry types, e.g., an [[RectangleGeometry]] and an [[EllipsoidGeometry]] as shown in Code Example 2.
    * <p>
    * A primitive combines geometry instances with an [[Appearance]] that describes the full shading, including
    * [[Material]] and RenderState   Roughly, the geometry instance defines the structure and placement,
    * and the appearance defines the visual characteristics.  Decoupling geometry and appearance allows us to mix
    * and match most of them and add a new geometry or appearance independently of each other.
    * </p>
    * <p>
    * Combining multiple instances into one primitive is called batching, and significantly improves performance for static data.
    * Instances can be individually picked; [[Scene#pick]] returns their [[GeometryInstance#id]]   Using
    * per-instance appearances like [[PerInstanceColorAppearance]], each instance can also have a unique color.
    * </p>
    * <p>
    * [[Geometry]] can either be created and batched on a web worker or the main thread. The first two examples
    * show geometry that will be created on a web worker by using the descriptions of the geometry. The third example
    * shows how to create the geometry on the main thread by explicitly calling the <code>createGeometry</code> method.
    * </p>
    *
    * alias Primitive
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {GeometryInstance[]|GeometryInstance} [options.geometryInstances] The geometry instances - or a single geometry instance - to render.
    * - {Appearance} [options.appearance] The appearance used to render the primitive.
    * - {Boolean} [options.show=true] Determines if this primitive will be shown.
    * - {Matrix4} [options.modelMatrix=Matrix4.IDENTITY] The 4x4 transformation matrix that transforms the primitive (all geometry instances) from model to world coordinates.
    * - {Boolean} [options.vertexCacheOptimize=false] When <code>true</code>, geometry vertices are optimized for the pre and post-vertex-shader caches.
    * - {Boolean} [options.interleave=false] When <code>true</code>, geometry vertex attributes are interleaved, which can slightly improve rendering performance but increases load time.
    * - {Boolean} [options.compressVertices=true] When <code>true</code>, the geometry vertices are compressed, which will save memory.
    * - {Boolean} [options.releaseGeometryInstances=true] When <code>true</code>, the primitive does not keep a reference to the input <code>geometryInstances</code> to save memory.
    * - {Boolean} [options.allowPicking=true] When <code>true</code>, each geometry instance will only be pickable with [[Scene#pick]]   When <code>false</code>, GPU memory is saved.
    * - {Boolean} [options.cull=true] When <code>true</code>, the renderer frustum culls and horizon culls the primitive's commands based on their bounding volume.  Set this to <code>false</code> for a small performance gain if you are manually culling the primitive.
    * - {Boolean} [options.asynchronous=true] Determines if the primitive will be created asynchronously or block until ready.
    * - {Boolean} [options.debugShowBoundingVolume=false] For debugging only. Determines if this primitive's commands' bounding spheres are shown.
    *
    * @example
    * // 1. Draw a translucent ellipse on the surface with a checkerboard pattern
    * var instance = new Cesium.GeometryInstance({
    * geometry : new Cesium.EllipseGeometry({
    * center : Cesium.Cartesian3.fromDegrees(-100.0, 20.0),
    * semiMinorAxis : 500000.0,
    * semiMajorAxis : 1000000.0,
    * rotation : Cesium.Math.PI_OVER_FOUR,
    * vertexFormat : Cesium.VertexFormat.POSITION_AND_ST
    * }),
    * id : 'object returned when this instance is picked and to get/set per-instance attributes'
    * });
    * scene.primitives.add(new Cesium.Primitive({
    * geometryInstances : instance,
    * appearance : new Cesium.EllipsoidSurfaceAppearance({
    * material : Cesium.Material.fromType('Checkerboard')
    * })
    * }));
    * @example
    * // 2. Draw different instances each with a unique color
    * var rectangleInstance = new Cesium.GeometryInstance({
    * geometry : new Cesium.RectangleGeometry({
    * rectangle : Cesium.Rectangle.fromDegrees(-140.0, 30.0, -100.0, 40.0),
    * vertexFormat : Cesium.PerInstanceColorAppearance.VERTEX_FORMAT
    * }),
    * id : 'rectangle',
    * attributes : {
    * color : new Cesium.ColorGeometryInstanceAttribute(0.0, 1.0, 1.0, 0.5)
    * }
    * });
    * var ellipsoidInstance = new Cesium.GeometryInstance({
    * geometry : new Cesium.EllipsoidGeometry({
    * radii : new Cesium.Cartesian3(500000.0, 500000.0, 1000000.0),
    * vertexFormat : Cesium.VertexFormat.POSITION_AND_NORMAL
    * }),
    * modelMatrix : Cesium.Matrix4.multiplyByTranslation(Cesium.Transforms.eastNorthUpToFixedFrame(
    * Cesium.Cartesian3.fromDegrees(-95.59777, 40.03883)), new Cesium.Cartesian3(0.0, 0.0, 500000.0), new Cesium.Matrix4()),
    * id : 'ellipsoid',
    * attributes : {
    * color : Cesium.ColorGeometryInstanceAttribute.fromColor(Cesium.Color.AQUA)
    * }
    * });
    * scene.primitives.add(new Cesium.Primitive({
    * geometryInstances : [rectangleInstance, ellipsoidInstance],
    * appearance : new Cesium.PerInstanceColorAppearance()
    * }));
    * @example
    * // 3. Create the geometry on the main thread.
    * scene.primitives.add(new Cesium.Primitive({
    * geometryInstances : new Cesium.GeometryInstance({
    * geometry : Cesium.EllipsoidGeometry.createGeometry(new Cesium.EllipsoidGeometry({
    * radii : new Cesium.Cartesian3(500000.0, 500000.0, 1000000.0),
    * vertexFormat : Cesium.VertexFormat.POSITION_AND_NORMAL
    * })),
    * modelMatrix : Cesium.Matrix4.multiplyByTranslation(Cesium.Transforms.eastNorthUpToFixedFrame(
    * Cesium.Cartesian3.fromDegrees(-95.59777, 40.03883)), new Cesium.Cartesian3(0.0, 0.0, 500000.0), new Cesium.Matrix4()),
    * id : 'ellipsoid',
    * attributes : {
    * color : Cesium.ColorGeometryInstanceAttribute.fromColor(Cesium.Color.AQUA)
    * }
    * }),
    * appearance : new Cesium.PerInstanceColorAppearance()
    * }));
    * @see GeometryInstance
    * @see Appearance
    */
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
    var shadows: Int = js.native

  //  var castShadows: Boolean = js.native
  //  var receiveShadows: Boolean = js.native

    def update(): js.Dynamic = js.native

    def getGeometryInstanceAttributes(id: js.Any): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  /**
    * A collection of primitives.  This is most often used with [[Scene#primitives]],
    * but <code>PrimitiveCollection</code> is also a primitive itself so collections can
    * be added to collections forming a hierarchy.
    *
    * alias PrimitiveCollection
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Boolean} [options.show=true] Determines if the primitives in the collection will be shown.
    * - {Boolean} [options.destroyPrimitives=true] Determines if primitives in the collection are destroyed when they are removed.
    *
    * @example
    * var billboards = new Cesium.BillboardCollection();
    * var labels = new Cesium.LabelCollection();
    *
    * var collection = new Cesium.PrimitiveCollection();
    * collection.add(billboards);
    *
    * scene.primitives.add(collection);  // Add collection
    * scene.primitives.add(labels);      // Add regular primitive
    */
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

  /**
    * The container for all 3D graphical objects and state in a Cesium virtual scene.  Generally,
    * a scene is not created directly; instead, it is implicitly created by [[CesiumWidget]]
    * <p>
    * <em><code>contextOptions</code> parameter details:</em>
    * </p>
    * <p>
    * The default values are:
    * <code>
    * {
    * webgl : {
    * alpha : false,
    * depth : true,
    * stencil : false,
    * antialias : true,
    * premultipliedAlpha : true,
    * preserveDrawingBuffer : false,
    * failIfMajorPerformanceCaveat : false
    * },
    * allowTextureFilterAnisotropic : true
    * }
    * </code>
    * </p>
    * <p>
    * The <code>webgl</code> property corresponds to the [[http://www.khronos.org/registry/webgl/specs/latest/#5.2|WebGLContextAttributes]]
    * object used to create the WebGL context.
    * </p>
    * <p>
    * <code>webgl.alpha</code> defaults to false, which can improve performance compared to the standard WebGL default
    * of true.  If an application needs to composite Cesium above other HTML elements using alpha-blending, set
    * <code>webgl.alpha</code> to true.
    * </p>
    * <p>
    * The other <code>webgl</code> properties match the WebGL defaults for [[http://www.khronos.org/registry/webgl/specs/latest/#5.2|WebGLContextAttributes]]
    * </p>
    * <p>
    * <code>allowTextureFilterAnisotropic</code> defaults to true, which enables anisotropic texture filtering when the
    * WebGL extension is supported.  Setting this to false will improve performance, but hurt visual quality, especially for horizon views.
    * </p>
    *
    * alias Scene
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Canvas} options.canvas The HTML canvas element to create the scene for.
    * - {Object} [options.contextOptions] Context and WebGL creation properties.  See details above.
    * - {Element} [options.creditContainer] The HTML element in which the credits will be displayed.
    * - {MapProjection} [options.mapProjection=new GeographicProjection()] The map projection to use in 2D and Columbus View modes.
    * - {Boolean} [options.orderIndependentTranslucency=true] If true and the configuration supports it, use order independent translucency.
    * - {Boolean} [options.scene3DOnly=false] If true, optimizes memory use and performance for 3D mode but disables the ability to use 2D or Columbus View.
    * - {Number} [options.terrainExaggeration=1.0] A scalar used to exaggerate the terrain. Note that terrain exaggeration will not modify any other primitive as they are positioned relative to the ellipsoid.
    *
    * @see CesiumWidget
    * @see [[http://www.khronos.org/registry/webgl/specs/latest/#5.2|WebGLContextAttributes]]
    *
    *      exception {DeveloperError} options and options.canvas are required.
    * @example
    * // Create scene without anisotropic texture filtering
    * var scene = new Cesium.Scene({
    * canvas : canvas,
    * contextOptions : {
    * allowTextureFilterAnisotropic : false
    * }
    * });
    */
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

    var shadowMap: ShadowMap = js.native
    var terrainProviderChanged: Event = js.native
    var nearToFarDistance2D: Double = js.native

    var rotatable2D: Boolean = js.native

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

  /**
    * Modifies the camera position and orientation based on mouse input to a canvas.
    * alias ScreenSpaceCameraController
    *
    *
    * - {Scene} scene The scene.
    */
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

  /**
    * Provides a single, top-level imagery tile.  The single image is assumed to use a
    * [[GeographicTilingScheme]]
    *
    * alias SingleTileImageryProvider
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {String} options.url The url for the tile.
    * - {Rectangle} [options.rectangle=Rectangle.MAX_VALUE] The rectangle, in radians, covered by the image.
    * - {Credit|String} [options.credit] A credit for the data source, which is displayed on the canvas.
    * - {Ellipsoid} [options.ellipsoid] The ellipsoid.  If not specified, the WGS84 ellipsoid is used.
    * - {Object} [options.proxy] A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL, if needed.
    *
    * @see ArcGisMapServerImageryProvider
    * @see BingMapsImageryProvider
    * @see GoogleEarthImageryProvider
    * @see createOpenStreetMapImageryProvider
    * @see createTileMapServiceImageryProvider
    * @see WebMapServiceImageryProvider
    * @see WebMapTileServiceImageryProvider
    * @see UrlTemplateImageryProvider
    */
  @js.native
  @JSName("Cesium.SingleTileImageryProvider")
  class SingleTileImageryProvider protected() extends ImageryProvider {
    def this(options: SingleTileImageryProviderOptions) = this()

    var url: String = js.native
  }

  @js.native
  @JSName("Cesium.SingleTileImageryProvider")
  object SingleTileImageryProvider extends ImageryProviderStatic

  /**
    * An atmosphere drawn around the limb of the provided ellipsoid.  Based on
    * [[http://http.developer.nvidia.com/GPUGems2/gpugems2_chapter16.html|Accurate Atmospheric Scattering]]
    * in GPU Gems 2.
    * <p>
    * This is only supported in 3D.  atmosphere is faded out when morphing to 2D or Columbus view.
    * </p>
    *
    * alias SkyAtmosphere
    *
    *
    * - {Ellipsoid} [ellipsoid=Ellipsoid.WGS84] The ellipsoid that the atmosphere is drawn around.
    *
    * @example
    * scene.skyAtmosphere = new Cesium.SkyAtmosphere();
    * @see Scene.skyAtmosphere
    */
  @js.native
  @JSName("Cesium.SkyAtmosphere")
  class SkyAtmosphere protected() extends js.Object {
    def this(ellipsoid: Ellipsoid = ???) = this()

    var show: Boolean = js.native
    var ellipsoid: Ellipsoid = js.native
    var brightnessShift: Double = js.native
    var hueShift: Double = js.native
    var saturationShift: Double = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  /**
    * A sky box around the scene to draw stars.  The sky box is defined using the True Equator Mean Equinox (TEME) axes.
    * <p>
    * This is only supported in 3D.  The sky box is faded out when morphing to 2D or Columbus view.  The size of
    * the sky box must not exceed [[Scene#maximumCubeMapSize]]
    * </p>
    *
    * alias SkyBox
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Object} [options.sources] The source URL or <code>Image</code> object for each of the six cube map faces.  See the example below.
    * - {Boolean} [options.show=true] Determines if this primitive will be shown.
    *
    * @example
    * scene.skyBox = new Cesium.SkyBox({
    * sources : {
    * positiveX : 'skybox_px.png',
    * negativeX : 'skybox_nx.png',
    * positiveY : 'skybox_py.png',
    * negativeY : 'skybox_ny.png',
    * positiveZ : 'skybox_pz.png',
    * negativeZ : 'skybox_nz.png'
    * }
    * });
    * @see Scene#skyBox
    * @see Transforms.computeTemeToPseudoFixedMatrix
    */
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

  /**
    * Draws a sun billboard.
    * <p>This is only supported in 3D and Columbus view.</p>
    *
    * alias Sun
    *
    * @example
    * scene.sun = new Cesium.Sun();
    * @see Scene#sun
    */
  @js.native
  @JSName("Cesium.Sun")
  class Sun() extends js.Object {
    var show: Boolean = js.native
    var glowFactor: Double = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): Unit = js.native
  }

  /**
    * An [[ImageryProvider]] that draws a box around every rendered tile in the tiling scheme, and draws
    * a label inside it indicating the X, Y, Level coordinates of the tile.  This is mostly useful for
    * debugging terrain and imagery rendering problems.
    *
    * alias TileCoordinatesImageryProvider
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {TilingScheme} [options.tilingScheme=new GeographicTilingScheme()] The tiling scheme for which to draw tiles.
    * - {Ellipsoid} [options.ellipsoid] The ellipsoid.  If the tilingScheme is specified,
    * this parameter is ignored and the tiling scheme's ellipsoid is used instead. If neither
    * parameter is specified, the WGS84 ellipsoid is used.
    * - {Color} [options.color=Color.YELLOW] The color to draw the tile box and label.
    * - {Number} [options.tileWidth=256] The width of the tile for level-of-detail selection purposes.
    * - {Number} [options.tileHeight=256] The height of the tile for level-of-detail selection purposes.
    */
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

  /**
    * A policy for discarding tile images according to some criteria.  This type describes an
    * interface and is not intended to be instantiated directly.
    *
    * alias TileDiscardPolicy
    *
    * @see DiscardMissingTileImagePolicy
    * @see NeverTileDiscardPolicy
    */
  @js.native
  trait TileDiscardPolicy extends js.Object {
    def isReady(): Boolean = js.native

    def shouldDiscardImage(image: HTMLImageElement): Boolean = js.native
  }

  /**
    * Provides imagery by requesting tiles using a specified URL template.
    *
    * alias UrlTemplateImageryProvider
    *
    *
    * - {Promise.<Object>|Object} [options] Object with the following properties:
    * - {String} options.url  The URL template to use to request tiles.  It has the following keywords:
    * <ul>
    * <li><code>{z}</code>: The level of the tile in the tiling scheme.  Level zero is the root of the quadtree pyramid.</li>
    * <li><code>{x}</code>: The tile X coordinate in the tiling scheme, where 0 is the Westernmost tile.</li>
    * <li><code>{y}</code>: The tile Y coordinate in the tiling scheme, where 0 is the Northernmost tile.</li>
    * <li><code>{s}</code>: One of the available subdomains, used to overcome browser limits on the number of simultaneous requests per host.</li>
    * <li><code>{reverseX}</code>: The tile X coordinate in the tiling scheme, where 0 is the Easternmost tile.</li>
    * <li><code>{reverseY}</code>: The tile Y coordinate in the tiling scheme, where 0 is the Southernmost tile.</li>
    * <li><code>{reverseZ}</code>: The level of the tile in the tiling scheme, where level zero is the maximum level of the quadtree pyramid.  In order to use reverseZ, maximumLevel must be defined.</li>
    * <li><code>{westDegrees}</code>: The Western edge of the tile in geodetic degrees.</li>
    * <li><code>{southDegrees}</code>: The Southern edge of the tile in geodetic degrees.</li>
    * <li><code>{eastDegrees}</code>: The Eastern edge of the tile in geodetic degrees.</li>
    * <li><code>{northDegrees}</code>: The Northern edge of the tile in geodetic degrees.</li>
    * <li><code>{westProjected}</code>: The Western edge of the tile in projected coordinates of the tiling scheme.</li>
    * <li><code>{southProjected}</code>: The Southern edge of the tile in projected coordinates of the tiling scheme.</li>
    * <li><code>{eastProjected}</code>: The Eastern edge of the tile in projected coordinates of the tiling scheme.</li>
    * <li><code>{northProjected}</code>: The Northern edge of the tile in projected coordinates of the tiling scheme.</li>
    * <li><code>{width}</code>: The width of each tile in pixels.</li>
    * <li><code>{height}</code>: The height of each tile in pixels.</li>
    * </ul>
    * - {String} [options.pickFeaturesUrl] The URL template to use to pick features.  If this property is not specified,
    * [[UrlTemplateImageryProvider#pickFeatures]] will immediately returned undefined, indicating no
    * features picked.  The URL template supports all of the keywords supported by the <code>url</code>
    * parameter, plus the following:
    * <ul>
    * <li><code>{i}</code>: The pixel column (horizontal coordinate) of the picked position, where the Westernmost pixel is 0.</li>
    * <li><code>{j}</code>: The pixel row (vertical coordinate) of the picked position, where the Northernmost pixel is 0.</li>
    * <li><code>{reverseI}</code>: The pixel column (horizontal coordinate) of the picked position, where the Easternmost pixel is 0.</li>
    * <li><code>{reverseJ}</code>: The pixel row (vertical coordinate) of the picked position, where the Southernmost pixel is 0.</li>
    * <li><code>{longitudeDegrees}</code>: The longitude of the picked position in degrees.</li>
    * <li><code>{latitudeDegrees}</code>: The latitude of the picked position in degrees.</li>
    * <li><code>{longitudeProjected}</code>: The longitude of the picked position in the projected coordinates of the tiling scheme.</li>
    * <li><code>{latitudeProjected}</code>: The latitude of the picked position in the projected coordinates of the tiling scheme.</li>
    * <li><code>{format}</code>: The format in which to get feature information, as specified in the [[GetFeatureInfoFormat]] </li>
    * </ul>
    * - {String|String[]} [options.subdomains='abc'] The subdomains to use for the <code>{s}</code> placeholder in the URL template.
    * If this parameter is a single string, each character in the string is a subdomain.  If it is
    * an array, each element in the array is a subdomain.
    * - {Object} [options.proxy] A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL.
    * - {Credit|String} [options.credit= ] A credit for the data source, which is displayed on the canvas.
    * - {Number} [options.minimumLevel=0] The minimum level-of-detail supported by the imagery provider.  Take care when specifying
    * this that the number of tiles at the minimum level is small, such as four or less.  A larger number is likely
    * to result in rendering problems.
    * - {Number} [options.maximumLevel] The maximum level-of-detail supported by the imagery provider, or undefined if there is no limit.
    * - {Rectangle} [options.rectangle=Rectangle.MAX_VALUE] The rectangle, in radians, covered by the image.
    * - {TilingScheme} [options.tilingScheme=WebMercatorTilingScheme] The tiling scheme specifying how the ellipsoidal
    * surface is broken into tiles.  If this parameter is not provided, a [[WebMercatorTilingScheme]]
    * is used.
    * - {Ellipsoid} [options.ellipsoid] The ellipsoid.  If the tilingScheme is specified,
    * this parameter is ignored and the tiling scheme's ellipsoid is used instead. If neither
    * parameter is specified, the WGS84 ellipsoid is used.
    * - {Number} [options.tileWidth=256] Pixel width of image tiles.
    * - {Number} [options.tileHeight=256] Pixel height of image tiles.
    * - {Boolean} [options.hasAlphaChannel=true] true if the images provided by this imagery provider
    * include an alpha channel; otherwise, false.  If this property is false, an alpha channel, if
    * present, will be ignored.  If this property is true, any images without an alpha channel will
    * be treated as if their alpha is 1.0 everywhere.  When this property is false, memory usage
    * and texture upload time are potentially reduced.
    * - {GetFeatureInfoFormat[]} [options.getFeatureInfoFormats] The formats in which to get feature information at a
    * specific location when [[UrlTemplateImageryProvider#pickFeatures]] is invoked.  If this
    * parameter is not specified, feature picking is disabled.
    * - {Boolean} [options.enablePickFeatures=true] If true, [[UrlTemplateImageryProvider#pickFeatures]] will
    * request the <code>options.pickFeaturesUrl</code> and attempt to interpret the features included in the response.  If false,
    * [[UrlTemplateImageryProvider#pickFeatures]] will immediately return undefined (indicating no pickable
    * features) without communicating with the server.  Set this property to false if you know your data
    * source does not support picking features or if you don't want this provider's features to be pickable. Note
    * that this can be dynamically overridden by modifying the [[UrlTemplateImageryProvider]]
    * property.
    *
    * @example
    * // Access Natural Earth II imagery, which uses a TMS tiling scheme and Geographic (EPSG:4326) project
    * var tms = new Cesium.UrlTemplateImageryProvider({
    * url : 'https://cesiumjs.org/tilesets/imagery/naturalearthii/{z}/{x}/{reverse} jpg',
    * credit : '© Analytical Graphics, Inc.',
    * tilingScheme : new Cesium.GeographicTilingScheme(),
    * maximumLevel : 5
    * });
    * // Access the CartoDB Positron basemap, which uses an OpenStreetMap-like tiling scheme.
    * var positron = new Cesium.UrlTemplateImageryProvider({
    * url : 'http://{s basemaps.cartocdn.com/light_all/{z}/{x}/{y png',
    * credit : 'Map tiles by CartoDB, under CC BY 3.0. Data by OpenStreetMap, under ODbL.'
    * });
    * // Access a Web Map Service (WMS) server.
    * var wms = new Cesium.UrlTemplateImageryProvider({
    * url : 'https://programs.communications.gov.au/geoserver/ows?tiled=true&' +
    * 'transparent=true&format=image%2Fpng&exceptions=application%2Fvnd.ogc.se_xml&' +
    * 'styles=&service=WMS&version=1.1.1&request=GetMap&' +
    * 'layers=public%3AMyBroadband_Availability&srs=EPSG%3A3857&' +
    * 'bbox={westProjected}%2C{southProjected}%2C{eastProjected}%2C{northProjected}&' +
    * 'width=256&height=256',
    * rectangle : Cesium.Rectangle.fromDegrees(96.799393, -43.598214999057824, 153.63925700000001, -9.2159219997013)
    * });
    * @see ArcGisMapServerImageryProvider
    * @see BingMapsImageryProvider
    * @see GoogleEarthImageryProvider
    * @see createOpenStreetMapImageryProvider
    * @see SingleTileImageryProvider
    * @see createTileMapServiceImageryProvider
    * @see WebMapServiceImageryProvider
    * @see WebMapTileServiceImageryProvider
    */
  @js.native
  @JSName("Cesium.UrlTemplateImageryProvider")
  class UrlTemplateImageryProvider protected() extends ImageryProvider {
    def this(options: UrlTemplateImageryProviderOptions) = this()

    var enablePickFeatures: Boolean = js.native
    var url: String = js.native

    def urlSchemeZeroPadding: js.Object = js.native

    def reinitialize(options: Promise[js.Any] | js.Any): js.Dynamic = js.native
  }

  @js.native
  @JSName("Cesium.UrlTemplateImageryProvider")
  object UrlTemplateImageryProvider extends ImageryProviderStatic

  /**
    * A viewport aligned quad.
    *
    * alias ViewportQuad
    *
    *
    * - {BoundingRectangle} [rectangle] The [[BoundingRectangle]] defining the quad's position within the viewport.
    * - {Material} [material] The [[Material]] defining the surface appearance of the viewport quad.
    *
    * @example
    * var viewportQuad = new Cesium.ViewportQuad(new Cesium.BoundingRectangle(0, 0, 80, 40));
    * viewportQuad.material.uniforms.color = new Cesium.Color(1.0, 0.0, 0.0, 1.0);
    */
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

  /**
    * Provides tiled imagery hosted by a Web Map Service (WMS) server.
    *
    * alias WebMapServiceImageryProvider
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {String} options.url The URL of the WMS service. The URL supports the same keywords as the [[UrlTemplateImageryProvider]]
    * - {String} options.layers The layers to include, separated by commas.
    * - {Object} [options.parameters=WebMapServiceImageryProvider.DefaultParameters] Additional parameters
    * to pass to the WMS server in the GetMap URL.
    * - {Object} [options.getFeatureInfoParameters=WebMapServiceImageryProvider.GetFeatureInfoDefaultParameters] Additional
    * parameters to pass to the WMS server in the GetFeatureInfo URL.
    * - {Boolean} [options.enablePickFeatures=true] If true, [[WebMapServiceImageryProvider#pickFeatures]] will invoke
    * the GetFeatureInfo operation on the WMS server and return the features included in the response.  If false,
    * [[WebMapServiceImageryProvider#pickFeatures]] will immediately return undefined (indicating no pickable features)
    * without communicating with the server.  Set this property to false if you know your WMS server does not support
    * GetFeatureInfo or if you don't want this provider's features to be pickable. Note that this can be dynamically
    * overridden by modifying the WebMapServiceImageryProvider#enablePickFeatures property.
    * - {GetFeatureInfoFormat[]} [options.getFeatureInfoFormats=WebMapServiceImageryProvider.DefaultGetFeatureInfoFormats] The formats
    * in which to try WMS GetFeatureInfo requests.
    * - {Rectangle} [options.rectangle=Rectangle.MAX_VALUE] The rectangle of the layer.
    * - {TilingScheme} [options.tilingScheme=new GeographicTilingScheme()] The tiling scheme to use to divide the world into tiles.
    * - {Ellipsoid} [options.ellipsoid] The ellipsoid.  If the tilingScheme is specified,
    * this parameter is ignored and the tiling scheme's ellipsoid is used instead. If neither
    * parameter is specified, the WGS84 ellipsoid is used.
    * - {Number} [options.tileWidth=256] The width of each tile in pixels.
    * - {Number} [options.tileHeight=256] The height of each tile in pixels.
    * - {Number} [options.minimumLevel=0] The minimum level-of-detail supported by the imagery provider.  Take care when
    * specifying this that the number of tiles at the minimum level is small, such as four or less.  A larger number is
    * likely to result in rendering problems.
    * - {Number} [options.maximumLevel] The maximum level-of-detail supported by the imagery provider, or undefined if there is no limit.
    * If not specified, there is no limit.
    * - {Credit|String} [options.credit] A credit for the data source, which is displayed on the canvas.
    * - {Object} [options.proxy] A proxy to use for requests. This object is
    * expected to have a getURL function which returns the proxied URL, if needed.
    * - {String|String[]} [options.subdomains='abc'] The subdomains to use for the <code>{s}</code> placeholder in the URL template.
    * If this parameter is a single string, each character in the string is a subdomain.  If it is
    * an array, each element in the array is a subdomain.
    *
    * @see ArcGisMapServerImageryProvider
    * @see BingMapsImageryProvider
    * @see GoogleEarthImageryProvider
    * @see createOpenStreetMapImageryProvider
    * @see SingleTileImageryProvider
    * @see createTileMapServiceImageryProvider
    * @see WebMapTileServiceImageryProvider
    * @see UrlTemplateImageryProvider
    * @see [[http://resources.esri.com/help/9.3/arcgisserver/apis/rest/|ArcGIS Server REST API]]
    * @see [[http://www.w3.org/TR/cors/|Cross-Origin Resource Sharing]]
    * @example
    * var provider = new Cesium.WebMapServiceImageryProvider({
    * url : 'https://sampleserver1.arcgisonline.com/ArcGIS/services/Specialty/ESRI_StatesCitiesRivers_USA/MapServer/WMSServer',
    * layers : '0',
    * proxy: new Cesium.DefaultProxy('/proxy/')
    * });
    *
    * viewer.imageryLayers.addImageryProvider(provider);
    */
  @js.native
  @JSName("Cesium.WebMapServiceImageryProvider")
  class WebMapServiceImageryProvider protected() extends ImageryProvider {
    def this(options: WebMapServiceImageryProviderOptions) = this()

    var url: String = js.native
    var layers: String = js.native
  }

  @js.native
  @JSName("Cesium.WebMapServiceImageryProvider")
  object WebMapServiceImageryProvider extends ImageryProviderStatic {
    var DefaultParameters: js.Any = js.native
    var GetFeatureInfoDefaultParameters: js.Any = js.native
  }

  /**
    * Provides tiled imagery served by [[http://www.opengeospatial.org/standards/wmts|WMTS 1.0.0]] compliant servers.
    * This provider supports HTTP KVP-encoded and RESTful GetTile requests, but does not yet support the SOAP encoding.
    *
    * alias WebMapTileServiceImageryProvider
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {String} options.url The base URL for the WMTS GetTile operation (for KVP-encoded requests) or the tile-URL template (for RESTful requests). The tile-URL template should contain the following variables: &#123;style&#125;, &#123;TileMatrixSet&#125;, &#123;TileMatrix&#125;, &#123;TileRow&#125;, &#123;TileCol&#125;. The first two are optional if actual values are hardcoded or not required by the server. The &#123;s&#125; keyword may be used to specify subdomains.
    * - {String} [options.format='image/jpeg'] The MIME type for images to retrieve from the server.
    * - {String} options.layer The layer name for WMTS requests.
    * - {String} options.style The style name for WMTS requests.
    * - {String} options.tileMatrixSetID The identifier of the TileMatrixSet to use for WMTS requests.
    * - {Array} [options.tileMatrixLabels] A list of identifiers in the TileMatrix to use for WMTS requests, one per TileMatrix level.
    * - {Number} [options.tileWidth=256] The tile width in pixels.
    * - {Number} [options.tileHeight=256] The tile height in pixels.
    * - {TilingScheme} [options.tilingScheme] The tiling scheme corresponding to the organization of the tiles in the TileMatrixSet.
    * - {Object} [options.proxy] A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL.
    * - {Rectangle} [options.rectangle=Rectangle.MAX_VALUE] The rectangle covered by the layer.
    * - {Number} [options.minimumLevel=0] The minimum level-of-detail supported by the imagery provider.
    * - {Number} [options.maximumLevel] The maximum level-of-detail supported by the imagery provider, or undefined if there is no limit.
    * - {Ellipsoid} [options.ellipsoid] The ellipsoid.  If not specified, the WGS84 ellipsoid is used.
    * - {Credit|String} [options.credit] A credit for the data source, which is displayed on the canvas.
    * - {String|String[]} [options.subdomains='abc'] The subdomains to use for the <code>{s}</code> placeholder in the URL template.
    * If this parameter is a single string, each character in the string is a subdomain.  If it is
    * an array, each element in the array is a subdomain.
    *
    * @example
    * // Example 1. USGS shaded relief tiles (KVP)
    * var shadedRelief1 = new Cesium.WebMapTileServiceImageryProvider({
    * url : 'http://basemap.nationalmap.gov/arcgis/rest/services/USGSShadedReliefOnly/MapServer/WMTS',
    * layer : 'USGSShadedReliefOnly',
    * style : 'default',
    * format : 'image/jpeg',
    * tileMatrixSetID : 'default028mm',
    * // tileMatrixLabels : ['default028mm:0', 'default028mm:1', 'default028mm:2' ...],
    * maximumLevel: 19,
    * credit : new Cesium.Credit('U. S. Geological Survey')
    * });
    * viewer.imageryLayers.addImageryProvider(shadedRelief1);
    * @example
    * // Example 2. USGS shaded relief tiles (RESTful)
    * var shadedRelief2 = new Cesium.WebMapTileServiceImageryProvider({
    * url : 'http://basemap.nationalmap.gov/arcgis/rest/services/USGSShadedReliefOnly/MapServer/WMTS/tile/1.0.0/USGSShadedReliefOnly/{Style}/{TileMatrixSet}/{TileMatrix}/{TileRow}/{TileCol} jpg',
    * layer : 'USGSShadedReliefOnly',
    * style : 'default',
    * format : 'image/jpeg',
    * tileMatrixSetID : 'default028mm',
    * maximumLevel: 19,
    * credit : new Cesium.Credit('U. S. Geological Survey')
    * });
    * viewer.imageryLayers.addImageryProvider(shadedRelief2);
    * @see ArcGisMapServerImageryProvider
    * @see BingMapsImageryProvider
    * @see GoogleEarthImageryProvider
    * @see createOpenStreetMapImageryProvider
    * @see SingleTileImageryProvider
    * @see createTileMapServiceImageryProvider
    * @see WebMapServiceImageryProvider
    * @see UrlTemplateImageryProvider
    */
  @js.native
  @JSName("Cesium.WebMapTileServiceImageryProvider")
  class WebMapTileServiceImageryProvider protected() extends ImageryProvider {
    def this(options: WebMapTileServiceImageryProviderOptions) = this()

    var url: String = js.native
    var format: String = js.native
  }

  @js.native
  @JSName("Cesium.WebMapTileServiceImageryProvider")
  object WebMapTileServiceImageryProvider extends ImageryProviderStatic

  /**
    *
    * <img src="images/AnimationWidget.png" width="211" height="142" alt="" />
    * <br />Animation widget
    *
    *
    * The Animation widget provides buttons for play, pause, and reverse, along with the
    * current time and date, surrounded by a "shuttle ring" for controlling the speed of animation.
    *
    * The "shuttle ring" concept is borrowed from video editing, where typically a
    * "jog wheel" can be rotated to move past individual animation frames very slowly, and
    * a surrounding shuttle ring can be twisted to control direction and speed of fast playback.
    * Cesium typically treats time as continuous (not broken into pre-defined animation frames),
    * so this widget offers no jog wheel.  Instead, the shuttle ring is capable of both fast and
    * very slow playback.  Click and drag the shuttle ring pointer itself (shown above in green),
    * or click in the rest of the ring area to nudge the pointer to the next preset speed in that direction.
    *
    * The Animation widget also provides a "realtime" button (in the upper-left) that keeps
    * animation time in sync with the end user's system clock, typically displaying
    * "today" or "right now."  This mode is not available in [[ClockRange.CLAMPED]] or
    * [[ClockRange.LOOP_STOP]] mode if the current time is outside of createCommand Clock's startTime and endTime.
    *
    * alias Animation
    *
    *
    * - {Element|String} container The DOM element or ID that will contain the widget.
    * - {AnimationViewModel} viewModel The view model used by this widget.
    *
    * exception {DeveloperError} Element with id "container" does not exist in the document.
    *
    * @example
    * // In HTML head, include a link to Animation.css stylesheet,
    * // and in the body, include: <div id="animationContainer"></div>
    *
    * var clock = new Cesium.Clock();
    * var clockViewModel = new Cesium.ClockViewModel(clock);
    * var viewModel = new Cesium.AnimationViewModel(clockViewModel);
    * var widget = new Cesium.Animation('animationContainer', viewModel);
    *
    * function tick() {
    * clock.tick();
    * Cesium.requestAnimationFrame(tick);
    * }
    * Cesium.requestAnimationFrame(tick);
    * @see AnimationViewModel
    * @see Clock
    */
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

  /**
    * The view model for the [[Animation]] widget.
    * alias AnimationViewModel
    *
    *
    * - {ClockViewModel} clockViewModel The ClockViewModel instance to use.
    *
    * @see Animation
    */
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

  /**
    *
    * <img src="images/BaseLayerPicker.png" width="264" height="287" alt="" />
    * BaseLayerPicker with its drop-panel open.
    *
    *
    * The BaseLayerPicker is a single button widget that displays a panel of available imagery and
    * terrain providers.  When imagery is selected, the corresponding imagery layer is created and inserted
    * as the base layer of the imagery collection; removing the existing base.  When terrain is selected,
    * it replaces the current terrain provider.  Each item in the available providers list contains a name,
    * a representative icon, and a tooltip to display more information when hovered. The list is initially
    * empty, and must be configured before use, as illustrated in the below example.
    *
    * alias BaseLayerPicker.
    *
    * - {Element|String} container The parent HTML container node or ID for this widget.
    * - '''The ''options'' object takes the following properties'''
    * - {Globe} options.globe The Globe to use.
    * - {ProviderViewModel[]} [options.imageryProviderViewModels=[]] The array of ProviderViewModel instances to use for imagery.
    * - {ProviderViewModel} [options.selectedImageryProviderViewModel] The view model for the current base imagery layer, if not supplied the first available imagery layer is used.
    * - {ProviderViewModel[]} [options.terrainProviderViewModels=[]] The array of ProviderViewModel instances to use for terrain.
    * - {ProviderViewModel} [options.selectedTerrainProviderViewModel] The view model for the current base terrain layer, if not supplied the first available terrain layer is used.
    *
    * exception {DeveloperError} Element with id "container" does not exist in the document.
    *
    * @example
    * // In HTML head, include a link to the BaseLayerPicker.css stylesheet,
    * // and in the body, include: <div id="baseLayerPickerContainer"
    * //   style="position:absolute;top:24px;right:24px;width:38px;height:38px;"></div>
    *
    * //Create the list of available providers we would like the user to select from.
    * //This example uses 3, OpenStreetMap, The Black Marble, and a single, non-streaming world image.
    * var imageryViewModels = [];
    * imageryViewModels.push(new Cesium.ProviderViewModel({
    * name : 'Open\u00adStreet\u00adMap',
    * iconUrl : Cesium.buildModuleUrl('Widgets/Images/ImageryProviders/openStreetMap.png'),
    * tooltip : 'OpenStreetMap (OSM) is a collaborative project to create a free editable \
    * map of the world.\nhttp://www.openstreetmap.org',
    * creationFunction : function() {
    * return Cesium.createOpenStreetMapImageryProvider({
    * url : 'https://a.tile.openstreetmap.org/'
    * });
    * }
    * }));
    *
    * imageryViewModels.push(new Cesium.ProviderViewModel({
    * name : 'Black Marble',
    * iconUrl : Cesium.buildModuleUrl('Widgets/Images/ImageryProviders/blackMarble.png'),
    * tooltip : 'The lights of cities and villages trace the outlines of civilization \
    * in this global view of the Earth at night as seen by NASA/NOAA\'s Suomi NPP satellite.',
    * creationFunction : function() {
    * return Cesium.createTileMapServiceImageryProvider({
    * url : 'https://cesiumjs.org/blackmarble',
    * credit : 'Black Marble imagery courtesy NASA Earth Observatory',
    * flipXY : true
    * });
    * }
    * }));
    *
    * imageryViewModels.push(new Cesium.ProviderViewModel({
    * name : 'Natural Earth\u00a0II',
    * iconUrl : Cesium.buildModuleUrl('Widgets/Images/ImageryProviders/naturalEarthII.png'),
    * tooltip : 'Natural Earth II, darkened for contrast.\nhttp://www.naturalearthdata.com/',
    * creationFunction : function() {
    * return Cesium.createTileMapServiceImageryProvider({
    * url : Cesium.buildModuleUrl('Assets/Textures/NaturalEarthII')
    * });
    * }
    * }));
    *
    * //Create a CesiumWidget without imagery, if you haven't already done so.
    * var cesiumWidget = new Cesium.CesiumWidget('cesiumContainer', { imageryProvider: false });
    *
    * //Finally, create the baseLayerPicker widget using our view models.
    * var layers = cesiumWidget.imageryLayers;
    * var baseLayerPicker = new Cesium.BaseLayerPicker('baseLayerPickerContainer', {
    * globe : cesiumWidget.scene.globe,
    * imageryProviderViewModels : imageryViewModels
    * });
    * @see TerrainProvider
    * @see ImageryProvider
    * @see ImageryLayerCollection
    */
  @js.native
  @JSName("Cesium.BaseLayerPicker")
  class BaseLayerPicker protected() extends js.Object {
    def this(container: Element | String, options: BaseLayerPickerOptions) = this()

    var container: Element = js.native
    var viewModel: BaseLayerPickerViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  /**
    * The view model for [[BaseLayerPicker]]
    * alias BaseLayerPickerViewModel
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Globe} options.globe The Globe to use.
    * - {ProviderViewModel[]} [options.imageryProviderViewModels=[]] The array of ProviderViewModel instances to use for imagery.
    * - {ProviderViewModel} [options.selectedImageryProviderViewModel] The view model for the current base imagery layer, if not supplied the first available imagery layer is used.
    * - {ProviderViewModel[]} [options.terrainProviderViewModels=[]] The array of ProviderViewModel instances to use for terrain.
    * - {ProviderViewModel} [options.selectedTerrainProviderViewModel] The view model for the current base terrain layer, if not supplied the first available terrain layer is used.
    *
    * exception {DeveloperError} imageryProviderViewModels must be an array.
    * exception {DeveloperError} terrainProviderViewModels must be an array.
    */
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

  /**
    * A view model that represents each item in the [[BaseLayerPicker]]
    *
    * alias ProviderViewModel
    *
    *
    * - {Object} options The object containing all parameters.
    * - {String} options.name The name of the layer.
    * - {String} options.tooltip The tooltip to show when the item is moused over.
    * - {String} options.iconUrl An icon representing the layer.
    * - {ProviderViewModel~CreationFunction|Command} options.creationFunction A function or Command
    * that creates one or more providers which will be added to the globe when this item is selected.
    *
    * @see BaseLayerPicker
    * @see ImageryProvider
    * @see TerrainProvider
    */
  @js.native
  @JSName("Cesium.ProviderViewModel")
  class ProviderViewModel protected() extends js.Object {
    def this(options: ProviderViewModelOptions) = this()

    var name: String = js.native
    var tooltip: String = js.native
    var iconUrl: String = js.native
    var creationCommand: Command = js.native
  }

  /**
    * Inspector widget to aid in debugging
    *
    * alias CesiumInspector
    *
    *
    * - {Element|String} container The DOM element or ID that will contain the widget.
    * - {Scene} scene The Scene instance to use.
    *
    * exception {DeveloperError} container is required.
    * exception {DeveloperError} scene is required.
    *
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Cesium%20Inspector.html|Cesium Sandcastle Cesium Inspector Demo]]
    */
  @js.native
  @JSName("Cesium.CesiumInspector")
  class CesiumInspector protected() extends js.Object {
    def this(container: Element | String, scene: Scene) = this()

    var container: Element = js.native
    var viewModel: CesiumInspectorViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  /**
    * The view model for [[CesiumInspector]]
    * alias CesiumInspectorViewModel
    *
    *
    * - {Scene} scene The scene instance to use.
    *
    * exception {DeveloperError} scene is required.
    */
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

  /**
    * A widget containing a Cesium scene.
    *
    * alias CesiumWidget
    *
    *
    * - {Element|String} container The DOM element or ID that will contain the widget.
    * - '''The ''options'' object takes the following properties'''
    * - {Clock} [options.clock=new Clock()] The clock to use to control current time.
    * - {ImageryProvider} [options.imageryProvider=new BingMapsImageryProvider()] The imagery provider to serve as the base layer. If set to <code>false</code>, no imagery provider will be added.
    * - {TerrainProvider} [options.terrainProvider=new EllipsoidTerrainProvider] The terrain provider.
    * - {SkyBox} [options.skyBox] The skybox used to render the stars.  When <code>undefined</code>, the default stars are used. If set to <code>false</code>, no skyBox, Sun, or Moon will be added.
    * - {SkyAtmosphere} [options.skyAtmosphere] Blue sky, and the glow around the Earth's limb.  Set to <code>false</code> to turn it off.
    * - {SceneMode} [options.sceneMode=SceneMode.SCENE3D] The initial scene mode.
    * - {Boolean} [options.scene3DOnly=false] When <code>true</code>, each geometry instance will only be rendered in 3D to save GPU memory.
    * - {Boolean} [options.orderIndependentTranslucency=true] If true and the configuration supports it, use order independent translucency.
    * - {MapProjection} [options.mapProjection=new GeographicProjection()] The map projection to use in 2D and Columbus View modes.
    * - {Globe} [options.globe=new Globe(mapProjection.ellipsoid)] The globe to use in the scene.  If set to <code>false</code>, no globe will be added.
    * - {Boolean} [options.useDefaultRenderLoop=true] True if this widget should control the render loop, false otherwise.
    * - {Number} [options.targetFrameRate] The target frame rate when using the default render loop.
    * - {Boolean} [options.showRenderLoopErrors=true] If true, this widget will automatically display an HTML panel to the user containing the error, if a render loop error occurs.
    * - {Object} [options.contextOptions] Context and WebGL creation properties corresponding to <code>options</code> passed to [[Scene]]
    * - {Element|String} [options.creditContainer] The DOM element or ID that will contain the [[CreditDisplay]]   If not specified, the credits are added
    * to the bottom of the widget itself.
    * - {Number} [options.terrainExaggeration=1.0] A scalar used to exaggerate the terrain. Note that terrain exaggeration will not modify any other primitive as they are positioned relative to the ellipsoid.
    *
    * exception {DeveloperError} Element with id "container" does not exist in the document.
    *
    * demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Cesium%20Widget.html|Cesium Sandcastle Cesium Widget Demo]]
    *
    * @example
    * // For each example, include a link to CesiumWidget.css stylesheet in HTML head,
    * // and in the body, include: <div id="cesiumContainer"></div>
    *
    * //Widget with no terrain and default Bing Maps imagery provider.
    * var widget = new Cesium.CesiumWidget('cesiumContainer');
    *
    * //Widget with OpenStreetMaps imagery provider and Cesium terrain provider hosted by AGI.
    * var widget = new Cesium.CesiumWidget('cesiumContainer', {
    * imageryProvider : Cesium.createOpenStreetMapImageryProvider(),
    * terrainProvider : new Cesium.CesiumTerrainProvider({
    * url : 'https://assets.agi.com/stk-terrain/world'
    * }),
    * // Use high-res stars downloaded from https://github.com/AnalyticalGraphicsInc/cesium-assets
    * skyBox : new Cesium.SkyBox({
    * sources : {
    * positiveX : 'stars/TychoSkymapII.t3_08192x04096_80_px.jpg',
    * negativeX : 'stars/TychoSkymapII.t3_08192x04096_80_mx.jpg',
    * positiveY : 'stars/TychoSkymapII.t3_08192x04096_80_py.jpg',
    * negativeY : 'stars/TychoSkymapII.t3_08192x04096_80_my.jpg',
    * positiveZ : 'stars/TychoSkymapII.t3_08192x04096_80_pz.jpg',
    * negativeZ : 'stars/TychoSkymapII.t3_08192x04096_80_mz.jpg'
    * }
    * }),
    * // Show Columbus View map with Web Mercator projection
    * sceneMode : Cesium.SceneMode.COLUMBUS_VIEW,
    * mapProjection : new Cesium.WebMercatorProjection()
    * });
    */
  @js.native
  @JSName("Cesium.CesiumWidget")
  class CesiumWidget protected() extends js.Object {
    def this(container: Element | String, options: CesiumWidgetOptions = ???) = this()

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

    var rotatable2D: Boolean = js.native

    def showErrorPanel(title: String, message: String, error: String = ???): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def resize(): js.Dynamic = js.native

    def render(): js.Dynamic = js.native
  }

  /**
    * A view model which exposes a  Clock for user interfaces.
    * alias ClockViewModel
    *
    *
    * - {Clock} [clock] The clock object wrapped by this view model, if undefined a new instance will be created.
    *
    * @see Clock
    */
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

  /**
    * A Command is a function with an extra <code>canExecute</code> observable property to determine
    * whether the command can be executed.  When executed, a Command function will check the
    * value of <code>canExecute</code> and throw if false.
    *
    * This type describes an interface and is not intended to be instantiated directly.
    * See createCommand to create a command from a function.
    *
    * alias Command
    *
    */
  @js.native
  trait Command extends js.Object {
    var canExecute: Boolean = js.native
    var beforeExecute: Event = js.native
    var afterExecute: Event = js.native
  }

  /**
    * A single button widget for toggling fullscreen mode.
    *
    * alias FullscreenButton
    *
    *
    * - {Element|String} container The DOM element or ID that will contain the widget.
    * - {Element|String} [fullscreenElement=document.body] The element or id to be placed into fullscreen mode.
    *
    * exception {DeveloperError} Element with id "container" does not exist in the document.
    *
    * @see Fullscreen
    */
  @js.native
  @JSName("Cesium.FullscreenButton")
  class FullscreenButton protected() extends js.Object {
    def this(container: Element | String, fullscreenElement: Element | String = ???) = this()

    var container: Element = js.native
    var viewModel: FullscreenButtonViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  /**
    * The view model for [[FullscreenButton]]
    * alias FullscreenButtonViewModel
    *
    *
    * - {Element|String} [fullscreenElement=document.body] The element or id to be placed into fullscreen mode.
    */
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

  /**
    * A widget for finding addresses and landmarks, and flying the camera to them.  Geocoding is
    * performed using the [[http://msdn.microsoft.com/en-us/library/ff701715.aspx|Bing Maps Locations API]]
    *
    * alias Geocoder
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Element|String} options.container The DOM element or ID that will contain the widget.
    * - {Scene} options.scene The Scene instance to use.
    * - {String} [options.url='https://dev.virtualearth.net'] The base URL of the Bing Maps API.
    * - {String} [options.key] The Bing Maps key for your application, which can be
    * created at [[https://www.bingmapsportal.com]]
    * If this parameter is not provided, [[BingMapsApi.defaultKey]] is used.
    * If [[BingMapsApi.defaultKey]] is undefined as well, a message is
    * written to the console reminding you that you must create and supply a Bing Maps
    * key as soon as possible.  Please do not deploy an application that uses
    * this widget without creating a separate key for your application.
    * - {Number} [options.flightDuration=1.5] The duration of the camera flight to an entered location, in seconds.
    */
  @js.native
  @JSName("Cesium.Geocoder")
  class Geocoder protected() extends js.Object {
    def this(options: GeocoderOptions) = this()

    var container: Element = js.native
    var viewModel: GeocoderViewModel = js.native
    var keepExpanded: Boolean = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  /**
    * The view model for the [[Geocoder]] widget.
    * alias GeocoderViewModel
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Scene} options.scene The Scene instance to use.
    * - {String} [options.url='https://dev.virtualearth.net'] The base URL of the Bing Maps API.
    * - {String} [options.key] The Bing Maps key for your application, which can be
    * created at [[https://www.bingmapsportal.com]]
    * If this parameter is not provided, [[BingMapsApi.defaultKey]] is used.
    * If [[BingMapsApi.defaultKey]] is undefined as well, a message is
    * written to the console reminding you that you must create and supply a Bing Maps
    * key as soon as possible.  Please do not deploy an application that uses
    * this widget without creating a separate key for your application.
    * - {Number} [options.flightDuration] The duration of the camera flight to an entered location, in seconds.
    */
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

  /**
    * A single button widget for returning to the default camera view of the current scene.
    *
    * alias HomeButton
    *
    *
    * - {Element|String} container The DOM element or ID that will contain the widget.
    * - {Scene} scene The Scene instance to use.
    * - {Number} [duration] The time, in seconds, it takes to complete the camera flight home.
    */
  @js.native
  @JSName("Cesium.HomeButton")
  class HomeButton protected() extends js.Object {
    def this(container: Element | String, scene: Scene, duration: Double = ???) = this()

    var container: Element = js.native
    var viewModel: HomeButtonViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  /**
    * The view model for [[HomeButton]]
    * alias HomeButtonViewModel
    *
    *
    * - {Scene} scene The scene instance to use.
    * - {Number} [duration] The duration of the camera flight in seconds.
    */
  @js.native
  @JSName("Cesium.HomeButtonViewModel")
  class HomeButtonViewModel protected() extends js.Object {
    def this(scene: Scene, duration: Double = ???) = this()

    var tooltip: String = js.native
    var scene: Scene = js.native
    var command: Command = js.native
    var duration: Double | Unit = js.native
  }

  /**
    * A widget for displaying information or a description.
    *
    * alias InfoBox
    *
    *
    * - {Element|String} container The DOM element or ID that will contain the widget.
    *
    * exception {DeveloperError} Element with id "container" does not exist in the document.
    */
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

  /**
    * The view model for [[InfoBox]]
    * alias InfoBoxViewModel
    *
    */
  @js.native
  @JSName("Cesium.InfoBoxViewModel")
  class InfoBoxViewModel() extends js.Object {
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

  /**
    * <p>The NavigationHelpButton is a single button widget for displaying instructions for
    * navigating the globe with the mouse.</p><p style="clear: both;"></p><br/>
    *
    * alias NavigationHelpButton
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Element|String} options.container The DOM element or ID that will contain the widget.
    * - {Boolean} [options.instructionsInitiallyVisible=false] True if the navigation instructions should initially be visible; otherwise, false.
    *
    * exception {DeveloperError} Element with id "container" does not exist in the document.
    *
    * @example
    * // In HTML head, include a link to the NavigationHelpButton.css stylesheet,
    * // and in the body, include: <div id="navigationHelpButtonContainer"></div>
    *
    * var navigationHelpButton = new Cesium.NavigationHelpButton({
    * container : 'navigationHelpButtonContainer'
    * });
    */
  @js.native
  @JSName("Cesium.NavigationHelpButton")
  class NavigationHelpButton protected() extends js.Object {
    def this(options: NavigationHelpButtonOptions) = this()

    var container: Element = js.native
    var viewModel: NavigationHelpButtonViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  /**
    * The view model for [[NavigationHelpButton]]
    * alias NavigationHelpButtonViewModel
    *
    */
  @js.native
  @JSName("Cesium.NavigationHelpButtonViewModel")
  class NavigationHelpButtonViewModel() extends js.Object {
    var showInstructions: Boolean = js.native
    var tooltip: String = js.native
    var command: Command = js.native
    var showClick: Command = js.native
    var showTouch: Command = js.native
  }

  /**
    * Monitors performance of the application and displays a message if poor performance is detected.
    *
    * alias PerformanceWatchdog
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Element|String} options.container The DOM element or ID that will contain the widget.
    * - {Scene} options.scene The [[Scene]] for which to monitor performance.
    * - {String} [options.lowFrameRateMessage='This application appears to be performing poorly on your system.  Please try using a different web browser or updating your video drivers.'] The
    * message to display when a low frame rate is detected.  The message is interpeted as HTML, so make sure
    * it comes from a trusted source so that your application is not vulnerable to cross-site scripting attacks.
    */
  @js.native
  @JSName("Cesium.PerformanceWatchdog")
  class PerformanceWatchdog protected() extends js.Object {
    def this(options: PerformanceWatchdogOptions) = this()

    var container: Element = js.native
    var viewModel: PerformanceWatchdogViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  /**
    * The view model for [[PerformanceWatchdog]]
    *
    * alias PerformanceWatchdogViewModel
    *
    *
    * - '''The ''options'' object takes the following properties'''
    * - {Scene} options.scene The Scene instance for which to monitor performance.
    * - {String} [options.lowFrameRateMessage='This application appears to be performing poorly on your system.  Please try using a different web browser or updating your video drivers.'] The
    * message to display when a low frame rate is detected.  The message is interpeted as HTML, so make sure
    * it comes from a trusted source so that your application is not vulnerable to cross-site scripting attacks.
    */
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

  /**
    * <img src="images/sceneModePicker.png" style="float: left; margin-right: 10px;" width="44" height="116" />
    * <p>The SceneModePicker is a single button widget for switching between scene modes;
    * shown to the left in its expanded state. Programatic switching of scene modes will
    * be automatically reflected in the widget as long as the specified Scene
    * is used to perform the change.</p><p style="clear: both;"></p><br/>
    *
    * alias SceneModePicker
    *
    *
    * - {Element|String} container The DOM element or ID that will contain the widget.
    * - {Scene} scene The Scene instance to use.
    * - {Number} [duration=2.0] The time, in seconds, it takes for the scene to transition.
    *
    * exception {DeveloperError} Element with id "container" does not exist in the document.
    *
    * @example
    * // In HTML head, include a link to the SceneModePicker.css stylesheet,
    * // and in the body, include: <div id="sceneModePickerContainer"></div>
    * // Note: This code assumes you already have a Scene instance.
    *
    * var sceneModePicker = new Cesium.SceneModePicker('sceneModePickerContainer', scene);
    */
  @js.native
  @JSName("Cesium.SceneModePicker")
  class SceneModePicker protected() extends js.Object {
    def this(container: Element | String, scene: Scene, duration: Double = ???) = this()

    var container: Element = js.native
    var viewModel: SceneModePickerViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  /**
    * The view model for [[SceneModePicker]]
    * alias SceneModePickerViewModel
    *
    *
    * - {Scene} scene The Scene to morph
    * - {Number} [duration=2.0] The duration of scene morph animations, in seconds
    */
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

  /**
    * A widget for displaying an indicator on a selected object.
    *
    * alias SelectionIndicator
    *
    *
    * - {Element|String} container The DOM element or ID that will contain the widget.
    * - {Scene} scene The Scene instance to use.
    *
    * exception {DeveloperError} Element with id "container" does not exist in the document.
    */
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

  /**
    * The view model for [[SelectionIndicator]]
    * alias SelectionIndicatorViewModel
    *
    *
    * - {Scene} scene The scene instance to use for screen-space coordinate conversion.
    * - {Element} selectionIndicatorElement The element containing all elements that make up the selection indicator.
    * - {Element} container The DOM element that contains the widget.
    */
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

  /**
    * The Timeline is a widget for displaying and controlling the current scene time.
    * alias Timeline
    *
    *
    * - {Element} container The parent HTML container node for this widget.
    * - {Clock} clock The clock to use.
    */
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

  /**
    * A view model which exposes the properties of a toggle button.
    * alias ToggleButtonViewModel
    *
    *
    * - {Command} command The command which will be executed when the button is toggled.
    * - '''The ''options'' object takes the following properties'''
    * - {Boolean} [options.toggled=false] A boolean indicating whether the button should be initially toggled.
    * - {String} [options.tooltip= ] A string containing the button's tooltip.
    **/
  @js.native
  @JSName("Cesium.ToggleButtonViewModel")
  class ToggleButtonViewModel protected() extends js.Object {
    def this(command: Command, options: ToggleButtonViewModelOptions = ???) = this()

    var toggled: Boolean = js.native
    var tooltip: String = js.native
    var command: Command = js.native
  }

  /**
    * A single button widget for toggling vr mode.
    *
    * alias VRButton
    *
    *
    * - {Element|String} container The DOM element or ID that will contain the widget.
    * - {Scene} scene The scene.
    * - {Element|String} [vrElement=document.body] The element or id to be placed into vr mode.
    *
    * exception {DeveloperError} Element with id "container" does not exist in the document.
    */
  @js.native
  @JSName("Cesium.VRButton")
  class VRButton protected() extends js.Object {
    def this(container: Element | String, scene: Scene, vrElement: Element | String = ???) = this()

    var container: Element = js.native
    var viewModel: VRButtonViewModel = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native
  }

  /**
    * The view model for [[VRButton]]
    * alias VRButtonViewModel
    *
    *
    * - {Scene} scene The scene.
    * - {Element|String} [vrElement=document.body] The element or id to be placed into VR mode.
    */
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

  @js.native
  @JSName("Cesium.ShadowMap")
  class ShadowMap protected() extends js.Object {
    def this(options: ShadowMapOptions = ???) = this()

    var darkness: Double = js.native
    var enabled: Boolean = js.native
    var maximumDistance: Double = js.native
    var size: Double = js.native
    var softShadows: Boolean = js.native

  }

  @JSName("Cesium.Viewer")
  @js.native
  object Viewer extends js.Object {
    type ViewerMixin = js.Function2[Viewer, js.Any, Unit]
  }

  /**
    * A base widget for building applications.  It composites all of the standard Cesium widgets into one reusable package.
    * The widget can always be extended by using mixins, which add functionality useful for a variety of applications.
    *
    * alias Viewer
    *
    *
    * - {Element|String} container The DOM element or ID that will contain the widget.
    * - '''The ''options'' object takes the following properties'''
    * - {Boolean} [options.animation=true] If set to false, the Animation widget will not be created.
    * - {Boolean} [options.baseLayerPicker=true] If set to false, the BaseLayerPicker widget will not be created.
    * - {Boolean} [options.fullscreenButton=true] If set to false, the FullscreenButton widget will not be created.
    * - {Boolean} [options.vrButton=false] If set to true, the VRButton widget will be created.
    * - {Boolean} [options.geocoder=true] If set to false, the Geocoder widget will not be created.
    * - {Boolean} [options.homeButton=true] If set to false, the HomeButton widget will not be created.
    * - {Boolean} [options.infoBox=true] If set to false, the InfoBox widget will not be created.
    * - {Boolean} [options.sceneModePicker=true] If set to false, the SceneModePicker widget will not be created.
    * - {Boolean} [options.selectionIndicator=true] If set to false, the SelectionIndicator widget will not be created.
    * - {Boolean} [options.timeline=true] If set to false, the Timeline widget will not be created.
    * - {Boolean} [options.navigationHelpButton=true] If set to false, the navigation help button will not be created.
    * - {Boolean} [options.navigationInstructionsInitiallyVisible=true] True if the navigation instructions should initially be visible, or false if the should not be shown until the user explicitly clicks the button.
    * - {Boolean} [options.scene3DOnly=false] When <code>true</code>, each geometry instance will only be rendered in 3D to save GPU memory.
    * - {Clock} [options.clock=new Clock()] The clock to use to control current time.
    * - {ProviderViewModel} [options.selectedImageryProviderViewModel] The view model for the current base imagery layer, if not supplied the first available base layer is used.  This value is only valid if options.baseLayerPicker is set to true.
    * - {ProviderViewModel[]} [options.imageryProviderViewModels=createDefaultImageryProviderViewModels()] The array of ProviderViewModels to be selectable from the BaseLayerPicker.  This value is only valid if options.baseLayerPicker is set to true.
    * - {ProviderViewModel} [options.selectedTerrainProviderViewModel] The view model for the current base terrain layer, if not supplied the first available base layer is used.  This value is only valid if options.baseLayerPicker is set to true.
    * - {ProviderViewModel[]} [options.terrainProviderViewModels=createDefaultTerrainProviderViewModels()] The array of ProviderViewModels to be selectable from the BaseLayerPicker.  This value is only valid if options.baseLayerPicker is set to true.
    * - {ImageryProvider} [options.imageryProvider=new BingMapsImageryProvider()] The imagery provider to use.  This value is only valid if options.baseLayerPicker is set to false.
    * - {TerrainProvider} [options.terrainProvider=new EllipsoidTerrainProvider()] The terrain provider to use
    * - {SkyBox} [options.skyBox] The skybox used to render the stars.  When <code>undefined</code>, the default stars are used.
    * - {SkyAtmosphere} [options.skyAtmosphere] Blue sky, and the glow around the Earth's limb.  Set to <code>false</code> to turn it off.
    * - {Element|String} [options.fullscreenElement=document.body] The element or id to be placed into fullscreen mode when the full screen button is pressed.
    * - {Boolean} [options.useDefaultRenderLoop=true] True if this widget should control the render loop, false otherwise.
    * - {Number} [options.targetFrameRate] The target frame rate when using the default render loop.
    * - {Boolean} [options.showRenderLoopErrors=true] If true, this widget will automatically display an HTML panel to the user containing the error, if a render loop error occurs.
    * - {Boolean} [options.automaticallyTrackDataSourceClocks=true] If true, this widget will automatically track the clock settings of newly added DataSources, updating if the DataSource's clock changes.  Set this to false if you want to configure the clock independently.
    * - {Object} [options.contextOptions] Context and WebGL creation properties corresponding to <code>options</code> passed to [[Scene]]
    * - {SceneMode} [options.sceneMode=SceneMode.SCENE3D] The initial scene mode.
    * - {MapProjection} [options.mapProjection=new GeographicProjection()] The map projection to use in 2D and Columbus View modes.
    * - {Globe} [options.globe=new Globe(mapProjection.ellipsoid)] The globe to use in the scene.  If set to <code>false</code>, no globe will be added.
    * - {Boolean} [options.orderIndependentTranslucency=true] If true and the configuration supports it, use order independent translucency.
    * - {Element|String} [options.creditContainer] The DOM element or ID that will contain the [[CreditDisplay]]   If not specified, the credits are added to the bottom of the widget itself.
    * - {DataSourceCollection} [options.dataSources=new DataSourceCollection()] The collection of data sources visualized by the widget.  If this parameter is provided,
    * the instance is assumed to be owned by the caller and will not be destroyed when the viewer is destroyed.
    * - {Number} [options.terrainExaggeration=1.0] A scalar used to exaggerate the terrain. Note that terrain exaggeration will not modify any other primitive as they are positioned relative to the ellipsoid.
    *
    * exception {DeveloperError} Element with id "container" does not exist in the document.
    * exception {DeveloperError} options.imageryProvider is not available when using the BaseLayerPicker widget, specify options.selectedImageryProviderViewModel instead.
    * exception {DeveloperError} options.terrainProvider is not available when using the BaseLayerPicker widget, specify options.selectedTerrainProviderViewModel instead.
    * exception {DeveloperError} options.selectedImageryProviderViewModel is not available when not using the BaseLayerPicker widget, specify options.imageryProvider instead.
    * exception {DeveloperError} options.selectedTerrainProviderViewModel is not available when not using the BaseLayerPicker widget, specify options.terrainProvider instead.
    *
    * @see Animation
    * @see BaseLayerPicker
    * @see CesiumWidget
    * @see FullscreenButton
    * @see HomeButton
    * @see SceneModePicker
    * @see Timeline
    * @see viewerDragDropMixin
    *
    *      demo [[http://cesiumjs.org/Cesium/Apps/Sandcastle/index.html?src=Hello%20World.html|Cesium Sandcastle Hello World Demo]]
    * @example
    * //Initialize the viewer widget with several custom options and mixins.
    * var viewer = new Cesium.Viewer('cesiumContainer', {
    * //Start in Columbus Viewer
    * sceneMode : Cesium.SceneMode.COLUMBUS_VIEW,
    * //Use standard Cesium terrain
    * terrainProvider : new Cesium.CesiumTerrainProvider({
    * url : 'https://assets.agi.com/stk-terrain/world'
    * }),
    * //Hide the base layer picker
    * baseLayerPicker : false,
    * //Use OpenStreetMaps
    * imageryProvider : Cesium.createOpenStreetMapImageryProvider({
    * url : 'https://a.tile.openstreetmap.org/'
    * }),
    * // Use high-res stars downloaded from https://github.com/AnalyticalGraphicsInc/cesium-assets
    * skyBox : new Cesium.SkyBox({
    * sources : {
    * positiveX : 'stars/TychoSkymapII.t3_08192x04096_80_px.jpg',
    * negativeX : 'stars/TychoSkymapII.t3_08192x04096_80_mx.jpg',
    * positiveY : 'stars/TychoSkymapII.t3_08192x04096_80_py.jpg',
    * negativeY : 'stars/TychoSkymapII.t3_08192x04096_80_my.jpg',
    * positiveZ : 'stars/TychoSkymapII.t3_08192x04096_80_pz.jpg',
    * negativeZ : 'stars/TychoSkymapII.t3_08192x04096_80_mz.jpg'
    * }
    * }),
    * // Show Columbus View map with Web Mercator projection
    * mapProjection : new Cesium.WebMercatorProjection()
    * });
    *
    * //Add basic drag and drop functionality
    * viewer.extend(Cesium.viewerDragDropMixin);
    *
    * //Show a pop-up alert if we encounter an error when processing a dropped file
    * viewer.dropError.addEventListener(function(dropHandler, name, error) {
    * console.log(error);
    * window.alert(error);
    * });
    */
  @js.native
  @JSName("Cesium.Viewer")
  class Viewer protected() extends js.Object {
    def this(container: Element | String, options: ViewerOptions = ???) = this()

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
    var shadows: Boolean = js.native
    var terrainShadows: Int = js.native
    var rotatable2D: Boolean = js.native
    var shadowMap: ShadowMap = js.native

    def extend(mixin: Viewer.ViewerMixin, options: js.Any = ???): js.Dynamic = js.native

    def resize(): js.Dynamic = js.native

    def forceResize(): js.Dynamic = js.native

    def render(): js.Dynamic = js.native

    def isDestroyed(): Boolean = js.native

    def destroy(): js.Dynamic = js.native

    def zoomTo(target: Entity | js.Array[Entity] | EntityCollection | DataSource | ImageryLayer | Promise[Entity | js.Array[Entity] | EntityCollection | DataSource | ImageryLayer], offset: HeadingPitchRange = ???): Promise[Boolean] = js.native

    def flyTo(target: Entity | js.Array[Entity] | EntityCollection | DataSource | ImageryLayer | Promise[Entity | js.Array[Entity] | EntityCollection | DataSource | ImageryLayer], options: ViewerFlyToOptions = ???): Promise[Boolean] = js.native
  }

  /**
    * Finds an item in a sorted array.
    */
  @JSName("Cesium.binarySearch")
  @js.native
  object BinarySearch extends js.Object {
    type Comparator = js.Function2[js.Any, js.Any, Double]
  }

  /**
    * A stable merge sort.
    */
  @JSName("Cesium.mergeSort")
  @js.native
  object MergeSort extends js.Object {
    type Comparator = js.Function3[js.Any, js.Any, js.Any, Double]
  }

  /**
    * A browser-independent function to request a new animation frame.
    * This is used to create an application's draw loop as shown in the example below.
    */
  @JSName("Cesium.requestAnimationFrame")
  @js.native
  object RequestAnimationFrame extends js.Object {
    type Callback = js.Function1[Double, Unit]
  }

  /**
    * Because browsers throttle the number of parallel requests allowed to each server, this function tracks
    * the number of active requests in progress to each server, and returns undefined immediately
    * if the request would exceed the maximum, allowing the caller to retry later,
    * instead of queueing indefinitely under the browser's control.
    */
  @JSName("Cesium.throttleRequestByServer")
  @js.native
  object ThrottleRequestByServer extends js.Object {
    type RequestFunction = js.Function1[String, Promise[js.Any]]
  }

  /**
    * Creates an adapter function to allow a calculation function to operate as a Web Worker,
    * paired with TaskProcessor, to receive tasks and return results.
    */
  @JSName("Cesium.createTaskProcessorWorker")
  @js.native
  object CreateTaskProcessorWorker extends js.Object {
    type WorkerFunction = js.Function2[js.Any, js.Array[js.Any], Any]
    type TaskProcessorWorkerFunction = js.Function1[js.Any, Unit]
  }

  /**
    * Cesium is an open-source JavaScript library for world-class 3D globes and maps
    *
    * see: [[http://cesiumjs.org/index.html]]
    *
    */
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

    def loadJsonp(url: String, options: JsonpOptions = ???): Promise[js.Any] = js.native

    def loadText(url: String | Promise[String], headers: js.Any = ???): Promise[String] = js.native

    def loadWithXhr(options: WithXhrOptions): Promise[js.Any] = js.native

    def loadXML(url: String | Promise[String], headers: js.Any = ???): Promise[js.Any] = js.native

    def mergeSort(array: js.Array[js.Any], comparator: MergeSort.Comparator, userDefinedObject: js.Any = ???): js.Dynamic = js.native

    def objectToQuery(obj: js.Any): String = js.native

    def pointInsideTriangle(point: Cartesian2 | Cartesian3, p0: Cartesian2 | Cartesian3, p1: Cartesian2 | Cartesian3, p2: Cartesian2 | Cartesian3): Boolean = js.native

    def queryToObject(queryString: String): js.Dynamic = js.native

    def requestAnimationFrame(callback: RequestAnimationFrame.Callback): Double = js.native

    def sampleTerrain(terrainProvider: TerrainProvider, level: Double, positions: js.Array[Cartographic]): Promise[js.Array[Cartographic]] = js.native

    def subdivideArray(array: js.Array[js.Any], numberOfArrays: Double): js.Dynamic = js.native

    def throttleRequestByServer(url: String, requestFunction: ThrottleRequestByServer.RequestFunction): Promise[js.Any] | Unit = js.native

    def createOpenStreetMapImageryProvider(options: OpenStreetMapImageryProviderOptions = ???): UrlTemplateImageryProvider = js.native

    def createTangentSpaceDebugPrimitive(options: TangentSpaceDebugPrimitiveOptions): Primitive = js.native

    def createTileMapServiceImageryProvider(options: TileMapServiceImageryProviderOptions = ???): UrlTemplateImageryProvider = js.native

    def viewerCesiumInspectorMixin(viewer: Viewer): js.Dynamic = js.native

    def viewerDragDropMixin(viewer: Viewer, options: DragDropMixinOptions = ???): js.Dynamic = js.native

    def viewerPerformanceWatchdogMixin(viewer: Viewer): js.Dynamic = js.native

    def createCommand(func: js.Function, canExecute: Boolean = ???): js.Dynamic = js.native

    def createTaskProcessorWorker(workerFunction: CreateTaskProcessorWorker.WorkerFunction): CreateTaskProcessorWorker.TaskProcessorWorkerFunction = js.native

    def sampleTerrainMostDetailed(terrainProvider: TerrainProvider, positions: Array[Cartographic] = ???): Promise[Array[Cartographic]]  = js.native

  }

  /**
    * Content pipeline functions for geometries.
    */
  @JSName("Cesium.GeometryPipeline")
  @js.native
  object GeometryPipeline extends js.Object {

    def compressVertices(geometry: Geometry): Geometry = js.native

    /** deprecated use GeometryPipeline.createTangentAndBitangent */
    def computeBinormalAndTangent(geometry: Geometry): Geometry = js.native

    def createTangentAndBitangent(geometry: Geometry): Geometry = js.native

    def computeNormal(geometry: Geometry): Geometry = js.native

    def createAttributeLocations(geometry: Geometry): js.Dynamic = js.native

    def createLineSegmentsForVectors(geometry: Geometry, attributeName: String, length: Double): Geometry = js.native

    def encodeAttribute(geometry: Geometry, attributeName: String, attributeHighName: String, attributeLowName: String): Geometry = js.native

    def fitToUnsignedShortIndices(geometry: Geometry): Array[Geometry] = js.native

    def projectTo2D(geometry: Geometry, attributeName: String, attributeName3D: String, attributeName2D: String, projection: js.Any): Geometry = js.native

    def reorderForPostVertexCache(geometry: Geometry, cacheCapacity: Int): Geometry = js.native

    def reorderForPreVertexCache(geometry: Geometry): Geometry = js.native

    def toWireframe(geometry: Geometry): Geometry = js.native

    def transformToWorldCoordinates(instance: GeometryInstance): GeometryInstance = js.native

  }

  /**
    * An InterpolationAlgorithm for performing linear interpolation.
    */
  @JSName("Cesium.LinearApproximation")
  @js.native
  object LinearApproximation extends InterpolationAlgorithm

  @JSName("Cesium.LagrangePolynomialApproximation")
  @js.native
  object LagrangePolynomialApproximation extends InterpolationAlgorithm

  @JSName("Cesium.HermitePolynomialApproximation")
  @js.native
  object HermitePolynomialApproximation extends InterpolationAlgorithm

  @js.native
  trait PackableForInterpolation extends Packable {
    var packedInterpolationLength: Int = js.native

    def convertPackedArrayForInterpolation(packedArray: Array[Double], startingIndex: Int = ???, lastIndex: Int = ???, result: js.Object = ???): Unit = js.native

    def unpackInterpolationResult(array: Array[Double], sourceArray: Array[Double], startingIndex: Int = ???, lastIndex: Int = ???, result: js.Object = ???): Unit = js.native
  }

  /**
    * Easing functions for use with TweenCollection. These function are from Tween.js and Robert Penner.
    * See the Tween.js graphs for each function.
    */
  @js.native
  @JSName("Cesium.EasingFunction")
  class EasingFunction protected() extends js.Object {
    val BACK_IN: EasingFunction.Callback = js.native
    val BACK_IN_OUT: EasingFunction.Callback = js.native
    val BACK_OUT: EasingFunction.Callback = js.native
    val BOUNCE_IN: EasingFunction.Callback = js.native
    val BOUNCE_IN_OUT: EasingFunction.Callback = js.native
    val BOUNCE_OUT: EasingFunction.Callback = js.native
    val CIRCULAR_IN: EasingFunction.Callback = js.native
    val CIRCULAR_IN_OUT: EasingFunction.Callback = js.native
    val CIRCULAR_OUT: EasingFunction.Callback = js.native
    val CUBIC_IN: EasingFunction.Callback = js.native
    val CUBIC_IN_OUT: EasingFunction.Callback = js.native
    val CUBIC_OUT: EasingFunction.Callback = js.native
    val ELASTIC_IN: EasingFunction.Callback = js.native
    val ELASTIC_IN_OUT: EasingFunction.Callback = js.native
    val ELASTIC_OUT: EasingFunction.Callback = js.native
    val EXPONENTIAL_IN: EasingFunction.Callback = js.native
    val EXPONENTIAL_IN_OUT: EasingFunction.Callback = js.native
    val EXPONENTIAL_OUT: EasingFunction.Callback = js.native
    val LINEAR_NONE: EasingFunction.Callback = js.native
    val QUADRACTIC_IN: EasingFunction.Callback = js.native
    val QUADRACTIC_IN_OUT: EasingFunction.Callback = js.native
    val QUADRACTIC_OUT: EasingFunction.Callback = js.native
    val QUINTIC_IN: EasingFunction.Callback = js.native
    val QUINTIC_IN_OUT: EasingFunction.Callback = js.native
    val QUINTIC_OUT: EasingFunction.Callback = js.native
    val SINUSOIDAL_IN: EasingFunction.Callback = js.native
    val SINUSOIDAL_IN_OUT: EasingFunction.Callback = js.native
    val SINUSOIDAL_OUT: EasingFunction.Callback = js.native

  }

  @JSName("Cesium.EasingFunction")
  @js.native
  object EasingFunction extends js.Object {
    type Callback = js.Function1[Double, Double]
  }

  // todo
  @js.native
  trait IntersectionTests extends js.Object {

  }

  // todo
  @js.native
  trait Intersection2D extends js.Object {

  }

  /**
    * Enum containing WebGL Constant values by name.
    * for use without an active WebGL context, or in cases where certain constants are unavailable using the WebGL context
    * (For example, in [Safari 9]{https://github.com/AnalyticalGraphicsInc/cesium/issues/2989}).
    *
    * These match the constants from the [WebGL 1.0]{https://www.khronos.org/registry/webgl/specs/latest/1.0/}
    * and [WebGL 2.0]{https://www.khronos.org/registry/webgl/specs/latest/2.0/}
    * specifications.
    *
    * see: https://github.com/AnalyticalGraphicsInc/cesium/blob/8328880c6a50e4fb735f68f8b87338eb477efb1f/Source/Core/WebGLConstants.js
    *
    */
  @JSName("Cesium.WebGLConstants")
  @js.native
  object WebGLConstants extends js.Object {

    val DEPTH_BUFFER_BIT: Int = js.native
    val STENCIL_BUFFER_BIT: Int = js.native
    val COLOR_BUFFER_BIT: Int = js.native
    val POINTS: Int = js.native
    val LINES: Int = js.native
    val LINE_LOOP: Int = js.native
    val LINE_STRIP: Int = js.native
    val TRIANGLES: Int = js.native
    val TRIANGLE_STRIP: Int = js.native
    val TRIANGLE_FAN: Int = js.native
    val ZERO: Int = js.native
    val ONE: Int = js.native
    val SRC_COLOR: Int = js.native
    val ONE_MINUS_SRC_COLOR: Int = js.native
    val SRC_ALPHA: Int = js.native
    val ONE_MINUS_SRC_ALPHA: Int = js.native
    val DST_ALPHA: Int = js.native
    val ONE_MINUS_DST_ALPHA: Int = js.native
    val DST_COLOR: Int = js.native
    val ONE_MINUS_DST_COLOR: Int = js.native
    val SRC_ALPHA_SATURATE: Int = js.native
    val FUNC_ADD: Int = js.native
    val BLEND_EQUATION: Int = js.native
    val BLEND_EQUATION_RGB: Int = js.native
    // same as BLEND_EQUATION
    val BLEND_EQUATION_ALPHA: Int = js.native
    val FUNC_SUBTRACT: Int = js.native
    val FUNC_REVERSE_SUBTRACT: Int = js.native
    val BLEND_DST_RGB: Int = js.native
    val BLEND_SRC_RGB: Int = js.native
    val BLEND_DST_ALPHA: Int = js.native
    val BLEND_SRC_ALPHA: Int = js.native
    val CONSTANT_COLOR: Int = js.native
    val ONE_MINUS_CONSTANT_COLOR: Int = js.native
    val CONSTANT_ALPHA: Int = js.native
    val ONE_MINUS_CONSTANT_ALPHA: Int = js.native
    val BLEND_COLOR: Int = js.native
    val ARRAY_BUFFER: Int = js.native
    val ELEMENT_ARRAY_BUFFER: Int = js.native
    val ARRAY_BUFFER_BINDING: Int = js.native
    val ELEMENT_ARRAY_BUFFER_BINDING: Int = js.native
    val STREAM_DRAW: Int = js.native
    val STATIC_DRAW: Int = js.native
    val DYNAMIC_DRAW: Int = js.native
    val BUFFER_SIZE: Int = js.native
    val BUFFER_USAGE: Int = js.native
    val CURRENT_VERTEX_ATTRIB: Int = js.native
    val FRONT: Int = js.native
    val BACK: Int = js.native
    val FRONT_AND_BACK: Int = js.native
    val CULL_FACE: Int = js.native
    val BLEND: Int = js.native
    val DITHER: Int = js.native
    val STENCIL_TEST: Int = js.native
    val DEPTH_TEST: Int = js.native
    val SCISSOR_TEST: Int = js.native
    val POLYGON_OFFSET_FILL: Int = js.native
    val SAMPLE_ALPHA_TO_COVERAGE: Int = js.native
    val SAMPLE_COVERAGE: Int = js.native
    val NO_ERROR: Int = js.native
    val INVALID_ENUM: Int = js.native
    val INVALID_VALUE: Int = js.native
    val INVALID_OPERATION: Int = js.native
    val OUT_OF_MEMORY: Int = js.native
    val CW: Int = js.native
    val CCW: Int = js.native
    val LINE_WIDTH: Int = js.native
    val ALIASED_POINT_SIZE_RANGE: Int = js.native
    val ALIASED_LINE_WIDTH_RANGE: Int = js.native
    val CULL_FACE_MODE: Int = js.native
    val FRONT_FACE: Int = js.native
    val DEPTH_RANGE: Int = js.native
    val DEPTH_WRITEMASK: Int = js.native
    val DEPTH_CLEAR_VALUE: Int = js.native
    val DEPTH_FUNC: Int = js.native
    val STENCIL_CLEAR_VALUE: Int = js.native
    val STENCIL_FUNC: Int = js.native
    val STENCIL_FAIL: Int = js.native
    val STENCIL_PASS_DEPTH_FAIL: Int = js.native
    val STENCIL_PASS_DEPTH_PASS: Int = js.native
    val STENCIL_REF: Int = js.native
    val STENCIL_VALUE_MASK: Int = js.native
    val STENCIL_WRITEMASK: Int = js.native
    val STENCIL_BACK_FUNC: Int = js.native
    val STENCIL_BACK_FAIL: Int = js.native
    val STENCIL_BACK_PASS_DEPTH_FAIL: Int = js.native
    val STENCIL_BACK_PASS_DEPTH_PASS: Int = js.native
    val STENCIL_BACK_REF: Int = js.native
    val STENCIL_BACK_VALUE_MASK: Int = js.native
    val STENCIL_BACK_WRITEMASK: Int = js.native
    val VIEWPORT: Int = js.native
    val SCISSOR_BOX: Int = js.native
    val COLOR_CLEAR_VALUE: Int = js.native
    val COLOR_WRITEMASK: Int = js.native
    val UNPACK_ALIGNMENT: Int = js.native
    val PACK_ALIGNMENT: Int = js.native
    val MAX_TEXTURE_SIZE: Int = js.native
    val MAX_VIEWPORT_DIMS: Int = js.native
    val SUBPIXEL_BITS: Int = js.native
    val RED_BITS: Int = js.native
    val GREEN_BITS: Int = js.native
    val BLUE_BITS: Int = js.native
    val ALPHA_BITS: Int = js.native
    val DEPTH_BITS: Int = js.native
    val STENCIL_BITS: Int = js.native
    val POLYGON_OFFSET_UNITS: Int = js.native
    val POLYGON_OFFSET_FACTOR: Int = js.native
    val TEXTURE_BINDING_2D: Int = js.native
    val SAMPLE_BUFFERS: Int = js.native
    val SAMPLES: Int = js.native
    val SAMPLE_COVERAGE_VALUE: Int = js.native
    val SAMPLE_COVERAGE_INVERT: Int = js.native
    val COMPRESSED_TEXTURE_FORMATS: Int = js.native
    val DONT_CARE: Int = js.native
    val FASTEST: Int = js.native
    val NICEST: Int = js.native
    val GENERATE_MIPMAP_HINT: Int = js.native
    val BYTE: Int = js.native
    val UNSIGNED_BYTE: Int = js.native
    val SHORT: Int = js.native
    val UNSIGNED_SHORT: Int = js.native
    val INT: Int = js.native
    val UNSIGNED_INT: Int = js.native
    val FLOAT: Int = js.native
    val DEPTH_COMPONENT: Int = js.native
    val ALPHA: Int = js.native
    val RGB: Int = js.native
    val RGBA: Int = js.native
    val LUMINANCE: Int = js.native
    val LUMINANCE_ALPHA: Int = js.native
    val UNSIGNED_SHORT_4_4_4_4: Int = js.native
    val UNSIGNED_SHORT_5_5_5_1: Int = js.native
    val UNSIGNED_SHORT_5_6_5: Int = js.native
    val FRAGMENT_SHADER: Int = js.native
    val VERTEX_SHADER: Int = js.native
    val MAX_VERTEX_ATTRIBS: Int = js.native
    val MAX_VERTEX_UNIFORM_VECTORS: Int = js.native
    val MAX_VARYING_VECTORS: Int = js.native
    val MAX_COMBINED_TEXTURE_IMAGE_UNITS: Int = js.native
    val MAX_VERTEX_TEXTURE_IMAGE_UNITS: Int = js.native
    val MAX_TEXTURE_IMAGE_UNITS: Int = js.native
    val MAX_FRAGMENT_UNIFORM_VECTORS: Int = js.native
    val SHADER_TYPE: Int = js.native
    val DELETE_STATUS: Int = js.native
    val LINK_STATUS: Int = js.native
    val VALIDATE_STATUS: Int = js.native
    val ATTACHED_SHADERS: Int = js.native
    val ACTIVE_UNIFORMS: Int = js.native
    val ACTIVE_ATTRIBUTES: Int = js.native
    val SHADING_LANGUAGE_VERSION: Int = js.native
    val CURRENT_PROGRAM: Int = js.native
    val NEVER: Int = js.native
    val LESS: Int = js.native
    val EQUAL: Int = js.native
    val LEQUAL: Int = js.native
    val GREATER: Int = js.native
    val NOTEQUAL: Int = js.native
    val GEQUAL: Int = js.native
    val ALWAYS: Int = js.native
    val KEEP: Int = js.native
    val REPLACE: Int = js.native
    val INCR: Int = js.native
    val DECR: Int = js.native
    val INVERT: Int = js.native
    val INCR_WRAP: Int = js.native
    val DECR_WRAP: Int = js.native
    val VENDOR: Int = js.native
    val RENDERER: Int = js.native
    val VERSION: Int = js.native
    val NEAREST: Int = js.native
    val LINEAR: Int = js.native
    val NEAREST_MIPMAP_NEAREST: Int = js.native
    val LINEAR_MIPMAP_NEAREST: Int = js.native
    val NEAREST_MIPMAP_LINEAR: Int = js.native
    val LINEAR_MIPMAP_LINEAR: Int = js.native
    val TEXTURE_MAG_FILTER: Int = js.native
    val TEXTURE_MIN_FILTER: Int = js.native
    val TEXTURE_WRAP_S: Int = js.native
    val TEXTURE_WRAP_T: Int = js.native
    val TEXTURE_2D: Int = js.native
    val TEXTURE: Int = js.native
    val TEXTURE_CUBE_MAP: Int = js.native
    val TEXTURE_BINDING_CUBE_MAP: Int = js.native
    val TEXTURE_CUBE_MAP_POSITIVE_X: Int = js.native
    val TEXTURE_CUBE_MAP_NEGATIVE_X: Int = js.native
    val TEXTURE_CUBE_MAP_POSITIVE_Y: Int = js.native
    val TEXTURE_CUBE_MAP_NEGATIVE_Y: Int = js.native
    val TEXTURE_CUBE_MAP_POSITIVE_Z: Int = js.native
    val TEXTURE_CUBE_MAP_NEGATIVE_Z: Int = js.native
    val MAX_CUBE_MAP_TEXTURE_SIZE: Int = js.native
    val TEXTURE0: Int = js.native
    val TEXTURE1: Int = js.native
    val TEXTURE2: Int = js.native
    val TEXTURE3: Int = js.native
    val TEXTURE4: Int = js.native
    val TEXTURE5: Int = js.native
    val TEXTURE6: Int = js.native
    val TEXTURE7: Int = js.native
    val TEXTURE8: Int = js.native
    val TEXTURE9: Int = js.native
    val TEXTURE10: Int = js.native
    val TEXTURE11: Int = js.native
    val TEXTURE12: Int = js.native
    val TEXTURE13: Int = js.native
    val TEXTURE14: Int = js.native
    val TEXTURE15: Int = js.native
    val TEXTURE16: Int = js.native
    val TEXTURE17: Int = js.native
    val TEXTURE18: Int = js.native
    val TEXTURE19: Int = js.native
    val TEXTURE20: Int = js.native
    val TEXTURE21: Int = js.native
    val TEXTURE22: Int = js.native
    val TEXTURE23: Int = js.native
    val TEXTURE24: Int = js.native
    val TEXTURE25: Int = js.native
    val TEXTURE26: Int = js.native
    val TEXTURE27: Int = js.native
    val TEXTURE28: Int = js.native
    val TEXTURE29: Int = js.native
    val TEXTURE30: Int = js.native
    val TEXTURE31: Int = js.native
    val ACTIVE_TEXTURE: Int = js.native
    val REPEAT: Int = js.native
    val CLAMP_TO_EDGE: Int = js.native
    val MIRRORED_REPEAT: Int = js.native
    val FLOAT_VEC2: Int = js.native
    val FLOAT_VEC3: Int = js.native
    val FLOAT_VEC4: Int = js.native
    val INT_VEC2: Int = js.native
    val INT_VEC3: Int = js.native
    val INT_VEC4: Int = js.native
    val BOOL: Int = js.native
    val BOOL_VEC2: Int = js.native
    val BOOL_VEC3: Int = js.native
    val BOOL_VEC4: Int = js.native
    val FLOAT_MAT2: Int = js.native
    val FLOAT_MAT3: Int = js.native
    val FLOAT_MAT4: Int = js.native
    val SAMPLER_2D: Int = js.native
    val SAMPLER_CUBE: Int = js.native
    val VERTEX_ATTRIB_ARRAY_ENABLED: Int = js.native
    val VERTEX_ATTRIB_ARRAY_SIZE: Int = js.native
    val VERTEX_ATTRIB_ARRAY_STRIDE: Int = js.native
    val VERTEX_ATTRIB_ARRAY_TYPE: Int = js.native
    val VERTEX_ATTRIB_ARRAY_NORMALIZED: Int = js.native
    val VERTEX_ATTRIB_ARRAY_POINTER: Int = js.native
    val VERTEX_ATTRIB_ARRAY_BUFFER_BINDING: Int = js.native
    val IMPLEMENTATION_COLOR_READ_TYPE: Int = js.native
    val IMPLEMENTATION_COLOR_READ_FORMAT: Int = js.native
    val COMPILE_STATUS: Int = js.native
    val LOW_FLOAT: Int = js.native
    val MEDIUM_FLOAT: Int = js.native
    val HIGH_FLOAT: Int = js.native
    val LOW_INT: Int = js.native
    val MEDIUM_INT: Int = js.native
    val HIGH_INT: Int = js.native
    val FRAMEBUFFER: Int = js.native
    val RENDERBUFFER: Int = js.native
    val RGBA4: Int = js.native
    val RGB5_A1: Int = js.native
    val RGB565: Int = js.native
    val DEPTH_COMPONENT16: Int = js.native
    val STENCIL_INDEX: Int = js.native
    val STENCIL_INDEX8: Int = js.native
    val DEPTH_STENCIL: Int = js.native
    val RENDERBUFFER_WIDTH: Int = js.native
    val RENDERBUFFER_HEIGHT: Int = js.native
    val RENDERBUFFER_INTERNAL_FORMAT: Int = js.native
    val RENDERBUFFER_RED_SIZE: Int = js.native
    val RENDERBUFFER_GREEN_SIZE: Int = js.native
    val RENDERBUFFER_BLUE_SIZE: Int = js.native
    val RENDERBUFFER_ALPHA_SIZE: Int = js.native
    val RENDERBUFFER_DEPTH_SIZE: Int = js.native
    val RENDERBUFFER_STENCIL_SIZE: Int = js.native
    val FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE: Int = js.native
    val FRAMEBUFFER_ATTACHMENT_OBJECT_NAME: Int = js.native
    val FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL: Int = js.native
    val FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE: Int = js.native
    val COLOR_ATTACHMENT0: Int = js.native
    val DEPTH_ATTACHMENT: Int = js.native
    val STENCIL_ATTACHMENT: Int = js.native
    val DEPTH_STENCIL_ATTACHMENT: Int = js.native
    val NONE: Int = js.native
    val FRAMEBUFFER_COMPLETE: Int = js.native
    val FRAMEBUFFER_INCOMPLETE_ATTACHMENT: Int = js.native
    val FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT: Int = js.native
    val FRAMEBUFFER_INCOMPLETE_DIMENSIONS: Int = js.native
    val FRAMEBUFFER_UNSUPPORTED: Int = js.native
    val FRAMEBUFFER_BINDING: Int = js.native
    val RENDERBUFFER_BINDING: Int = js.native
    val MAX_RENDERBUFFER_SIZE: Int = js.native
    val INVALID_FRAMEBUFFER_OPERATION: Int = js.native
    val UNPACK_FLIP_Y_WEBGL: Int = js.native
    val UNPACK_PREMULTIPLY_ALPHA_WEBGL: Int = js.native
    val CONTEXT_LOST_WEBGL: Int = js.native
    val UNPACK_COLORSPACE_CONVERSION_WEBGL: Int = js.native
    val BROWSER_DEFAULT_WEBGL: Int = js.native
    // Desktop OpenGL
    val DOUBLE: Int = js.native
    // WebGL 2
    val READ_BUFFER: Int = js.native
    val UNPACK_ROW_LENGTH: Int = js.native
    val UNPACK_SKIP_ROWS: Int = js.native
    val UNPACK_SKIP_PIXELS: Int = js.native
    val PACK_ROW_LENGTH: Int = js.native
    val PACK_SKIP_ROWS: Int = js.native
    val PACK_SKIP_PIXELS: Int = js.native
    val COLOR: Int = js.native
    val DEPTH: Int = js.native
    val STENCIL: Int = js.native
    val RED: Int = js.native
    val RGB8: Int = js.native
    val RGBA8: Int = js.native
    val RGB10_A2: Int = js.native
    val TEXTURE_BINDING_3D: Int = js.native
    val UNPACK_SKIP_IMAGES: Int = js.native
    val UNPACK_IMAGE_HEIGHT: Int = js.native
    val TEXTURE_3D: Int = js.native
    val TEXTURE_WRAP_R: Int = js.native
    val MAX_3D_TEXTURE_SIZE: Int = js.native
    val UNSIGNED_INT_2_10_10_10_REV: Int = js.native
    val MAX_ELEMENTS_VERTICES: Int = js.native
    val MAX_ELEMENTS_INDICES: Int = js.native
    val TEXTURE_MIN_LOD: Int = js.native
    val TEXTURE_MAX_LOD: Int = js.native
    val TEXTURE_BASE_LEVEL: Int = js.native
    val TEXTURE_MAX_LEVEL: Int = js.native
    val MIN: Int = js.native
    val MAX: Int = js.native
    val DEPTH_COMPONENT24: Int = js.native
    val MAX_TEXTURE_LOD_BIAS: Int = js.native
    val TEXTURE_COMPARE_MODE: Int = js.native
    val TEXTURE_COMPARE_FUNC: Int = js.native
    val CURRENT_QUERY: Int = js.native
    val QUERY_RESULT: Int = js.native
    val QUERY_RESULT_AVAILABLE: Int = js.native
    val STREAM_READ: Int = js.native
    val STREAM_COPY: Int = js.native
    val STATIC_READ: Int = js.native
    val STATIC_COPY: Int = js.native
    val DYNAMIC_READ: Int = js.native
    val DYNAMIC_COPY: Int = js.native
    val MAX_DRAW_BUFFERS: Int = js.native
    val DRAW_BUFFER0: Int = js.native
    val DRAW_BUFFER1: Int = js.native
    val DRAW_BUFFER2: Int = js.native
    val DRAW_BUFFER3: Int = js.native
    val DRAW_BUFFER4: Int = js.native
    val DRAW_BUFFER5: Int = js.native
    val DRAW_BUFFER6: Int = js.native
    val DRAW_BUFFER7: Int = js.native
    val DRAW_BUFFER8: Int = js.native
    val DRAW_BUFFER9: Int = js.native
    val DRAW_BUFFER10: Int = js.native
    val DRAW_BUFFER11: Int = js.native
    val DRAW_BUFFER12: Int = js.native
    val DRAW_BUFFER13: Int = js.native
    val DRAW_BUFFER14: Int = js.native
    val DRAW_BUFFER15: Int = js.native
    val MAX_FRAGMENT_UNIFORM_COMPONENTS: Int = js.native
    val MAX_VERTEX_UNIFORM_COMPONENTS: Int = js.native
    val SAMPLER_3D: Int = js.native
    val SAMPLER_2D_SHADOW: Int = js.native
    val FRAGMENT_SHADER_DERIVATIVE_HINT: Int = js.native
    val PIXEL_PACK_BUFFER: Int = js.native
    val PIXEL_UNPACK_BUFFER: Int = js.native
    val PIXEL_PACK_BUFFER_BINDING: Int = js.native
    val PIXEL_UNPACK_BUFFER_BINDING: Int = js.native
    val FLOAT_MAT2x3: Int = js.native
    val FLOAT_MAT2x4: Int = js.native
    val FLOAT_MAT3x2: Int = js.native
    val FLOAT_MAT3x4: Int = js.native
    val FLOAT_MAT4x2: Int = js.native
    val FLOAT_MAT4x3: Int = js.native
    val SRGB: Int = js.native
    val SRGB8: Int = js.native
    val SRGB8_ALPHA8: Int = js.native
    val COMPARE_REF_TO_TEXTURE: Int = js.native
    val RGBA32F: Int = js.native
    val RGB32F: Int = js.native
    val RGBA16F: Int = js.native
    val RGB16F: Int = js.native
    val VERTEX_ATTRIB_ARRAY_INTEGER: Int = js.native
    val MAX_ARRAY_TEXTURE_LAYERS: Int = js.native
    val MIN_PROGRAM_TEXEL_OFFSET: Int = js.native
    val MAX_PROGRAM_TEXEL_OFFSET: Int = js.native
    val MAX_VARYING_COMPONENTS: Int = js.native
    val TEXTURE_2D_ARRAY: Int = js.native
    val TEXTURE_BINDING_2D_ARRAY: Int = js.native
    val R11F_G11F_B10F: Int = js.native
    val UNSIGNED_INT_10F_11F_11F_REV: Int = js.native
    val RGB9_E5: Int = js.native
    val UNSIGNED_INT_5_9_9_9_REV: Int = js.native
    val TRANSFORM_FEEDBACK_BUFFER_MODE: Int = js.native
    val MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS: Int = js.native
    val TRANSFORM_FEEDBACK_VARYINGS: Int = js.native
    val TRANSFORM_FEEDBACK_BUFFER_START: Int = js.native
    val TRANSFORM_FEEDBACK_BUFFER_SIZE: Int = js.native
    val TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN: Int = js.native
    val RASTERIZER_DISCARD: Int = js.native
    val MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS: Int = js.native
    val MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS: Int = js.native
    val INTERLEAVED_ATTRIBS: Int = js.native
    val SEPARATE_ATTRIBS: Int = js.native
    val TRANSFORM_FEEDBACK_BUFFER: Int = js.native
    val TRANSFORM_FEEDBACK_BUFFER_BINDING: Int = js.native
    val RGBA32UI: Int = js.native
    val RGB32UI: Int = js.native
    val RGBA16UI: Int = js.native
    val RGB16UI: Int = js.native
    val RGBA8UI: Int = js.native
    val RGB8UI: Int = js.native
    val RGBA32I: Int = js.native
    val RGB32I: Int = js.native
    val RGBA16I: Int = js.native
    val RGB16I: Int = js.native
    val RGBA8I: Int = js.native
    val RGB8I: Int = js.native
    val RED_INTEGER: Int = js.native
    val RGB_INTEGER: Int = js.native
    val RGBA_INTEGER: Int = js.native
    val SAMPLER_2D_ARRAY: Int = js.native
    val SAMPLER_2D_ARRAY_SHADOW: Int = js.native
    val SAMPLER_CUBE_SHADOW: Int = js.native
    val UNSIGNED_INT_VEC2: Int = js.native
    val UNSIGNED_INT_VEC3: Int = js.native
    val UNSIGNED_INT_VEC4: Int = js.native
    val INT_SAMPLER_2D: Int = js.native
    val INT_SAMPLER_3D: Int = js.native
    val INT_SAMPLER_CUBE: Int = js.native
    val INT_SAMPLER_2D_ARRAY: Int = js.native
    val UNSIGNED_INT_SAMPLER_2D: Int = js.native
    val UNSIGNED_INT_SAMPLER_3D: Int = js.native
    val UNSIGNED_INT_SAMPLER_CUBE: Int = js.native
    val UNSIGNED_INT_SAMPLER_2D_ARRAY: Int = js.native
    val DEPTH_COMPONENT32F: Int = js.native
    val DEPTH32F_STENCIL8: Int = js.native
    val FLOAT_32_UNSIGNED_INT_24_8_REV: Int = js.native
    val FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING: Int = js.native
    val FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE: Int = js.native
    val FRAMEBUFFER_ATTACHMENT_RED_SIZE: Int = js.native
    val FRAMEBUFFER_ATTACHMENT_GREEN_SIZE: Int = js.native
    val FRAMEBUFFER_ATTACHMENT_BLUE_SIZE: Int = js.native
    val FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE: Int = js.native
    val FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE: Int = js.native
    val FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE: Int = js.native
    val FRAMEBUFFER_DEFAULT: Int = js.native
    val UNSIGNED_INT_24_8: Int = js.native
    val DEPTH24_STENCIL8: Int = js.native
    val UNSIGNED_NORMALIZED: Int = js.native
    val DRAW_FRAMEBUFFER_BINDING: Int = js.native
    // Same as FRAMEBUFFER_BINDING
    val READ_FRAMEBUFFER: Int = js.native
    val DRAW_FRAMEBUFFER: Int = js.native
    val READ_FRAMEBUFFER_BINDING: Int = js.native
    val RENDERBUFFER_SAMPLES: Int = js.native
    val FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER: Int = js.native
    val MAX_COLOR_ATTACHMENTS: Int = js.native
    val COLOR_ATTACHMENT1: Int = js.native
    val COLOR_ATTACHMENT2: Int = js.native
    val COLOR_ATTACHMENT3: Int = js.native
    val COLOR_ATTACHMENT4: Int = js.native
    val COLOR_ATTACHMENT5: Int = js.native
    val COLOR_ATTACHMENT6: Int = js.native
    val COLOR_ATTACHMENT7: Int = js.native
    val COLOR_ATTACHMENT8: Int = js.native
    val COLOR_ATTACHMENT9: Int = js.native
    val COLOR_ATTACHMENT10: Int = js.native
    val COLOR_ATTACHMENT11: Int = js.native
    val COLOR_ATTACHMENT12: Int = js.native
    val COLOR_ATTACHMENT13: Int = js.native
    val COLOR_ATTACHMENT14: Int = js.native
    val COLOR_ATTACHMENT15: Int = js.native
    val FRAMEBUFFER_INCOMPLETE_MULTISAMPLE: Int = js.native
    val MAX_SAMPLES: Int = js.native
    val HALF_FLOAT: Int = js.native
    val RG: Int = js.native
    val RG_INTEGER: Int = js.native
    val R8: Int = js.native
    val RG8: Int = js.native
    val R16F: Int = js.native
    val R32F: Int = js.native
    val RG16F: Int = js.native
    val RG32F: Int = js.native
    val R8I: Int = js.native
    val R8UI: Int = js.native
    val R16I: Int = js.native
    val R16UI: Int = js.native
    val R32I: Int = js.native
    val R32UI: Int = js.native
    val RG8I: Int = js.native
    val RG8UI: Int = js.native
    val RG16I: Int = js.native
    val RG16UI: Int = js.native
    val RG32I: Int = js.native
    val RG32UI: Int = js.native
    val VERTEX_ARRAY_BINDING: Int = js.native
    val R8_SNORM: Int = js.native
    val RG8_SNORM: Int = js.native
    val RGB8_SNORM: Int = js.native
    val RGBA8_SNORM: Int = js.native
    val SIGNED_NORMALIZED: Int = js.native
    val COPY_READ_BUFFER: Int = js.native
    val COPY_WRITE_BUFFER: Int = js.native
    val COPY_READ_BUFFER_BINDING: Int = js.native
    // Same as COPY_READ_BUFFER
    val COPY_WRITE_BUFFER_BINDING: Int = js.native
    // Same as COPY_WRITE_BUFFER
    val UNIFORM_BUFFER: Int = js.native
    val UNIFORM_BUFFER_BINDING: Int = js.native
    val UNIFORM_BUFFER_START: Int = js.native
    val UNIFORM_BUFFER_SIZE: Int = js.native
    val MAX_VERTEX_UNIFORM_BLOCKS: Int = js.native
    val MAX_FRAGMENT_UNIFORM_BLOCKS: Int = js.native
    val MAX_COMBINED_UNIFORM_BLOCKS: Int = js.native
    val MAX_UNIFORM_BUFFER_BINDINGS: Int = js.native
    val MAX_UNIFORM_BLOCK_SIZE: Int = js.native
    val MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS: Int = js.native
    val MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS: Int = js.native
    val UNIFORM_BUFFER_OFFSET_ALIGNMENT: Int = js.native
    val ACTIVE_UNIFORM_BLOCKS: Int = js.native
    val UNIFORM_TYPE: Int = js.native
    val UNIFORM_SIZE: Int = js.native
    val UNIFORM_BLOCK_INDEX: Int = js.native
    val UNIFORM_OFFSET: Int = js.native
    val UNIFORM_ARRAY_STRIDE: Int = js.native
    val UNIFORM_MATRIX_STRIDE: Int = js.native
    val UNIFORM_IS_ROW_MAJOR: Int = js.native
    val UNIFORM_BLOCK_BINDING: Int = js.native
    val UNIFORM_BLOCK_DATA_SIZE: Int = js.native
    val UNIFORM_BLOCK_ACTIVE_UNIFORMS: Int = js.native
    val UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES: Int = js.native
    val UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER: Int = js.native
    val UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER: Int = js.native
    val INVALID_INDEX: Int = js.native
    val MAX_VERTEX_OUTPUT_COMPONENTS: Int = js.native
    val MAX_FRAGMENT_INPUT_COMPONENTS: Int = js.native
    val MAX_SERVER_WAIT_TIMEOUT: Int = js.native
    val OBJECT_TYPE: Int = js.native
    val SYNC_CONDITION: Int = js.native
    val SYNC_STATUS: Int = js.native
    val SYNC_FLAGS: Int = js.native
    val SYNC_FENCE: Int = js.native
    val SYNC_GPU_COMMANDS_COMPLETE: Int = js.native
    val UNSIGNALED: Int = js.native
    val SIGNALED: Int = js.native
    val ALREADY_SIGNALED: Int = js.native
    val TIMEOUT_EXPIRED: Int = js.native
    val CONDITION_SATISFIED: Int = js.native
    val WAIT_FAILED: Int = js.native
    val SYNC_FLUSH_COMMANDS_BIT: Int = js.native
    val VERTEX_ATTRIB_ARRAY_DIVISOR: Int = js.native
    val ANY_SAMPLES_PASSED: Int = js.native
    val ANY_SAMPLES_PASSED_CONSERVATIVE: Int = js.native
    val SAMPLER_BINDING: Int = js.native
    val RGB10_A2UI: Int = js.native
    val INT_2_10_10_10_REV: Int = js.native
    val TRANSFORM_FEEDBACK: Int = js.native
    val TRANSFORM_FEEDBACK_PAUSED: Int = js.native
    val TRANSFORM_FEEDBACK_ACTIVE: Int = js.native
    val TRANSFORM_FEEDBACK_BINDING: Int = js.native
    val COMPRESSED_R11_EAC: Int = js.native
    val COMPRESSED_SIGNED_R11_EAC: Int = js.native
    val COMPRESSED_RG11_EAC: Int = js.native
    val COMPRESSED_SIGNED_RG11_EAC: Int = js.native
    val COMPRESSED_RGB8_ETC2: Int = js.native
    val COMPRESSED_SRGB8_ETC2: Int = js.native
    val COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2: Int = js.native
    val COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2: Int = js.native
    val COMPRESSED_RGBA8_ETC2_EAC: Int = js.native
    val COMPRESSED_SRGB8_ALPHA8_ETC2_EAC: Int = js.native
    val TEXTURE_IMMUTABLE_FORMAT: Int = js.native
    val MAX_ELEMENT_INDEX: Int = js.native
    val TEXTURE_IMMUTABLE_LEVELS: Int = js.native

  }

  @js.native
  trait GeocoderResult extends js.Object {
    val displayName: String = js.native
    val destination: Rectangle | Cartesian3 = js.native
  }

  @js.native
  trait GeocoderService extends js.Object {
    def geocode(query: String): Promise[GeocoderResult] = js.native
  }

  @js.native
  @JSName("Cesium.BingMapsGeocoderService")
  class BingMapsGeocoderService protected() extends GeocoderService {
    def this(options: BingMapsGeocoderServiceOptions) = this()
    val url: String = js.native
    val key: String = js.native
    val autoComplete: Boolean = js.native
  }

  @js.native
  @JSName("Cesium.CartographicGeocoderService")
  class CartographicGeocoderService protected() extends GeocoderService


}
