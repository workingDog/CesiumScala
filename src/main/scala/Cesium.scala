/*
 * Copyright (c) 2016, Ringo Wathelet
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above copyright notice, this
 *   list of conditions and the following disclaimer in the documentation and/or
 *   other materials provided with the distribution.
 *
 * - Neither the name of "CesiumScala" nor the names of its contributors may
 *   be used to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.scalajs.dom._

import scala.concurrent._
import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.{|, UndefOr, undefined}

import org.querki.jsext.{JSOptionBuilder, OptMap, noOpts}


/**
  * A Scala.js facade for Cesium.js "An open-source JavaScript library for world-class 3D globes and maps"
  *
  * Reference:  http://cesiumjs.org/
  *
  * @author Ringo Wathelet
  *         Date: 14/04/16
  *         Version: 1
  */

package cesium {

  @js.native
  trait Promise[+A] extends js.Object {

    @JSName("catch")
    def recover[B >: A](onRejected: js.Function1[Any, B]): Promise[Any] = js.native

    @JSName("then")
    def andThen[B](onFulfilled: js.Function1[A, B]): Promise[Any] = js.native

    @JSName("then")
    def andThen[B](onFulfilled: js.Function1[A, B], onRejected: js.Function1[Any, B]): Promise[Any] = js.native
  }

  @js.native
  object Cesium extends js.GlobalScope {
    def Cesium: CesiumStatic = js.native
  }

  @js.native
  trait CesiumStatic extends js.Object {
    def VERSION: String = js.native

    // todo
    def shaders: String = js.native
  }

  //-------------------------------------------------------------------------------

  @js.native
  sealed trait TimeStandard extends js.Object

  @JSName("Cesium.TimeStandard")
  @js.native
  object TimeStandard extends js.Object {
    val UTC: Int = js.native  // 0
    val TAI: Int = js.native  // 1

    @JSBracketAccess
    def apply(value: TimeStandard): Int = js.native
  }

  @JSName("JulianDate")
  @js.native
  class JulianDate(julianDayNumber: Int | Double, secondsOfDay: Int | Double, timeStandard: UndefOr[TimeStandard] = undefined) extends js.Object {

    def clone(result: UndefOr[JulianDate] = undefined): JulianDate = js.native

    def equals(right: UndefOr[JulianDate] = undefined): Boolean = js.native

    def equalsEpsilon(right: UndefOr[JulianDate] = undefined, epsilon: Double): Boolean = js.native
  }

  @js.native
  object JulianDate extends js.Object {
    // todo
    // def leapSeconds : Array[LeapSecond] = js.native

    def addDays(julianDate: JulianDate, days: Int | Double, result: JulianDate): JulianDate = js.native

    // todo
  }

  @js.native
  sealed trait ReferenceFrame extends js.Object

  @JSName("Cesium.ReferenceFrame")
  @js.native
  object ReferenceFrame extends js.Object {
    val FIXED: Int = js.native       // 0
    val INERTIAL: Int = js.native    // 1

    @JSBracketAccess
    def apply(value: ReferenceFrame): Int = js.native
  }

  @JSName("Cesium.Cartesian3")
  @js.native
  class Cartesian3(x: Double, y: Double, z: Double) extends js.Object {
    // todo
    def clone(result: UndefOr[Cartesian3] = undefined): Cartesian3 = js.native

    def equals(right: UndefOr[Cartesian3] = undefined): Boolean = js.native

    def equalsEpsilon(right: UndefOr[Cartesian3] = undefined, relativeEpsilon: Double, absoluteEpsilon: UndefOr[Double] = undefined): Boolean = js.native
  }

  @js.native
  object Cartesian3 extends js.Object {
    // todo
    def packedLength: Int = js.native

    val UNIT_X: Cartesian3 = js.native
    val UNIT_Y: Cartesian3 = js.native
    val UNIT_Z: Cartesian3 = js.native
    val ZERO: Cartesian3 = js.native
  }

  @JSName("Cesium.Command")
  @js.native
  trait Command extends js.Object {
    // todo
  }

  @JSName("Cesium.ToggleButtonViewModel")
  @js.native
  trait ToggleButtonViewModel extends js.Object {
    // todo
  }

  @JSName("Cesium.Material")
  @js.native
  trait Material extends js.Object {
    // todo
  }

  @js.native
  object Material extends js.Object {
    // todo
    def ColorType: Material = js.native
  }

  @JSName("Cesium.RenderState")
  @js.native
  trait RenderState extends js.Object {
    // todo
  }

  @JSName("Cesium.ClockViewModel")
  @js.native
  class ClockViewModel extends js.Object {
    // todo
  }

  @JSName("Cesium.TilingScheme")
  @js.native
  class TilingScheme extends js.Object {
    // todo
  }

  @JSName("Cesium.Ellipsoid")
  @js.native
  class Ellipsoid extends js.Object {
    // todo
  }

  @JSName("Cesium.Credit")
  @js.native
  class Credit extends js.Object {
    // todo
  }

  @JSName("Cesium.GeographicTilingScheme")
  @js.native
  class GeographicTilingScheme extends js.Object {
    // todo
  }

  @JSName("Cesium.TerrainData")
  @js.native
  class TerrainData extends js.Object {
    // todo
  }

  @JSName("Cesium.Rectangle")
  @js.native
  class Rectangle extends js.Object {
    // todo
  }

  @JSName("Cesium.TileDiscardPolicy")
  @js.native
  class TileDiscardPolicy extends js.Object {
    // todo
  }

  @JSName("Cesium.Image")
  @js.native
  class Image extends js.Object {
    // todo
  }

  @JSName("Cesium.Canvas")
  @js.native
  class Canvas extends js.Object {
    // todo
  }

  @JSName("Cesium.ImageryLayerFeatureInfo")
  @js.native
  class ImageryLayerFeatureInfo extends js.Object {
    // todo
  }


  //-------------------------------------------------------------------------------

  @JSName("Cesium.AnimationViewModel")
  @js.native
  class AnimationViewModel(clockViewModel: ClockViewModel) extends js.Object {
    // to access the formatter type
    import AnimationViewModel._

    var dateFormatter: formatter = js.native
    var timeFormatter: formatter = js.native
    var faster: Command = js.native
    var multiplierLabel: String = js.native
    var pauseViewModel: ToggleButtonViewModel = js.native
    var playForwardViewModel: ToggleButtonViewModel = js.native
    var playRealtimeViewModel: ToggleButtonViewModel = js.native
    var playReverseViewModel: ToggleButtonViewModel = js.native
    var shuttleRingAngle: Double = js.native
    var shuttleRingDragging: Boolean = js.native
    var slower: Command = js.native
    var snapToTicks: Boolean = js.native
    var timeLabel: String = js.native
    var dateLabel: String = js.native

    def getShuttleRingTicks: Array[Int] = js.native

    def setShuttleRingTicks(positiveTicks: Array[Int]): Unit = js.native
  }

  @js.native
  object AnimationViewModel extends js.Object {
    type formatter = Function1[JulianDate, AnimationViewModel] => String

    // function definitions
    def formatter(date: JulianDate, viewModel: AnimationViewModel): String = js.native

    // static members
    def defaultDateFormatter: Function1[JulianDate, AnimationViewModel] => String = js.native

    def defaultTicks: Array[Int] = js.native

    def defaultTimeFormatter: Function1[JulianDate, AnimationViewModel] => String = js.native

  }

  @JSName("Cesium.Animation")
  @js.native
  class Animation(container: Element | String, viewModel: AnimationViewModel) extends js.Object {
    def applyThemeChanges(): Unit = js.native

    def destroy(): Unit = js.native

    def isDestroyed(): Boolean = js.native

    def resize(): Unit = js.native
  }

  @JSName("Cesium.Options")
  @js.native
  trait AppearenceOptions extends js.Object

  object AppearenceOptions extends AppearenceOptionsBuilder(noOpts)

  class AppearenceOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[AppearenceOptions, AppearenceOptionsBuilder](new AppearenceOptionsBuilder(_)) {
    def translucent(v: Boolean) = jsOpt("translucent", v)

    def closed(v: Boolean) = jsOpt("closed", v)

    def material(v: Material) = jsOpt("material", v)

    def vertexShaderSource(v: String) = jsOpt("vertexShaderSource", v)

    def fragmentShaderSource(v: String) = jsOpt("fragmentShaderSource", v)

    def renderState(v: RenderState) = jsOpt("renderState", v)
  }

  @JSName("Cesium.Appearance")
  @js.native
  class Appearance(options: AppearenceOptions) extends js.Object {

    def closed: Boolean = js.native

    def fragmentShaderSource: String = js.native

    var material: Material = js.native

    var translucent: Boolean = js.native

    def renderState: Object = js.native

    def vertexShaderSource: String = js.native

    def getFragmentShaderSource(): String = js.native

    def getRenderState(): Object = js.native

    def isTranslucent(): Boolean = js.native
  }

  object Appearance {
    def apply(options: AppearenceOptions) = new Appearance(options)
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

  @JSName("Cesium.ArcGisImageServerTerrainProvider")
  @js.native
  class ArcGisImageServerTerrainProvider(options: ArcGisImageServerTerrainProviderOptions) extends js.Object {
    var credit: Credit = js.native

    var errorEvent: Event = js.native

    var hasVertexNormals: Boolean = js.native

    var hasWaterMask: Boolean = js.native

    var ready: Boolean = js.native

    var tilingScheme: GeographicTilingScheme = js.native

    // read only
    def readyPromise: Future[Boolean] = js.native

    // methods
    def getLevelMaximumGeometricError(level: Int): Int = js.native

    def getTileDataAvailable(x: Double, y: Double, level: Int): Boolean = js.native

    // todo check this
    def requestTileGeometry(x: Double, y: Double, level: Int): Option[Future[TerrainData]] = js.native
  }

  object ArcGisImageServerTerrainProvider {
    def apply(options: ArcGisImageServerTerrainProviderOptions) = new ArcGisImageServerTerrainProvider(options)
  }

  @JSName("Cesium.Options")
  @js.native
  trait ArcGisMapServerImageryProviderOptions extends js.Object

  object ArcGisMapServerImageryProviderOptions extends ArcGisMapServerImageryProviderOptionsBuilder(noOpts)

  class ArcGisMapServerImageryProviderOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ArcGisMapServerImageryProviderOptions, ArcGisMapServerImageryProviderOptionsBuilder](new ArcGisMapServerImageryProviderOptionsBuilder(_)) {
    def url(v: String) = jsOpt("url", v)

    def token(v: String) = jsOpt("token", v)

    def proxy(v: Object) = jsOpt("proxy", v)

    def tileDiscardPolicy(v: TileDiscardPolicy) = jsOpt("tileDiscardPolicy", v)

    def tilingScheme(v: TilingScheme) = jsOpt("tilingScheme", v)

    def ellipsoid(v: Ellipsoid) = jsOpt("ellipsoid", v)

    def usePreCachedTilesIfAvailable(v: Boolean) = jsOpt("usePreCachedTilesIfAvailable", v)

    def layers(v: String) = jsOpt("layers", v)

    def enablePickFeatures(v: Boolean) = jsOpt("enablePickFeatures", v)

    def rectangle(v: Rectangle) = jsOpt("rectangle", v)

    def tileWidth(v: Int) = jsOpt("tileWidth", v)

    def tileHeight(v: Int) = jsOpt("tileHeight", v)

    def maximumLevel(v: Int) = jsOpt("maximumLevel", v)
  }

  @JSName("Cesium.ArcGisMapServerImageryProvider")
  @js.native
  class ArcGisMapServerImageryProvider(options: ArcGisMapServerImageryProviderOptions) extends js.Object {
    var enablePickFeatures: Boolean = js.native

    // read only
    def credit: Credit = js.native

    def errorEvent: Event = js.native

    def hasAlphaChannel: Boolean = js.native

    def maximumLevel: Int = js.native

    def minimumLevel: Int = js.native

    def proxy: Proxy = js.native

    def ready: Boolean = js.native

    def readyPromise: Future[Boolean] = js.native

    def rectangle: Rectangle = js.native

    def tileDiscardPolicy: TileDiscardPolicy = js.native

    def tileHeight: Int = js.native

    def tileWidth: Int = js.native

    def tilingScheme: TilingScheme = js.native

    def token: String = js.native

    def url: String = js.native

    def usingPrecachedTiles: Boolean = js.native

    // methods
    def getTileCredits(x: Double, y: Double, level: Int): Array[Credit] = js.native

    def pickFeatures(x: Double, y: Double, level: Int, longitude: Double, latitude: Double): Option[Future[ImageryLayerFeatureInfo]] = js.native

    def requestImage(x: Double, y: Double, level: Int): Option[Future[Image | Canvas]] = js.native

  }

  object ArcGisMapServerImageryProvider {
    def apply(options: ArcGisMapServerImageryProviderOptions) = new ArcGisMapServerImageryProvider(options)
  }


  //-------------------------------------------------------------------------------

  @JSName("Cesium.TimeInterval")
  @js.native
  class TimeInterval() extends js.Object {
    // todo
  }

  @JSName("Cesium.CompositeEntityCollection")
  @js.native
  class CompositeEntityCollection(collections: Array[EntityCollection]) extends js.Object {
    // todo
  }

  @JSName("Cesium.EntityCollection")
  @js.native
  class EntityCollection(owner: DataSource | CompositeEntityCollection) extends js.Object {

    @JSBracketAccess
    def apply(index: Int): Entity = js.native

    @JSBracketAccess
    def update(index: Int, entity: Entity): Unit = js.native

    def add(entity: Entity): Entity = js.native

    def computeAvailability(): TimeInterval = js.native

    def contains(entity: Entity): Boolean = js.native

    @JSBracketAccess
    def getById(id: Object): Entity = js.native

    @JSBracketAccess
    def getOrCreateEntity(id: Object): Entity = js.native

    def remove(entity: Entity): Boolean = js.native

    def removeAll(): Unit = js.native

    def removeById(id: Object): Boolean = js.native

    def resumeEvents(): Unit = js.native

    def suspendEvents(): Unit = js.native

    // members readonly
    def collectionChanged: Event = js.native

    def id: String = js.native

    def values: js.Array[Entity] = js.native
  }

  @js.native
  object EntityCollection extends js.Object {

    def collectionChangedEventCallback(collection: EntityCollection, added: Array[Entity],
                                       removed: Array[Entity], changed: Array[Entity]): Unit = js.native
  }

  @JSName("Cesium.DataSource")
  @js.native
  trait DataSource extends js.Object {
    //  def update(time: JulianDate): Boolean = js.native
    def update(time: String): Boolean = js.native

    var changedEvent: Event = js.native
    //  var clock: DataSourceClock = js.native
    var entities: EntityCollection = js.native
    var errorEvent: Event = js.native
    var isLoading: Boolean = js.native
    var loadingEvent: Event = js.native
    var name: String = js.native
  }

  @JSName("Cesium.Options")
  @js.native
  trait CzmlDSOptions extends js.Object

  object CzmlDSOptions extends CzmlDSOptionsBuilder(noOpts)

  class CzmlDSOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CzmlDSOptions, CzmlDSOptionsBuilder](new CzmlDSOptionsBuilder(_)) {
    def sourceUri(v: String) = jsOpt("sourceUri", v)
  }

  @JSName("Cesium.DataSourceCollection")
  @js.native
  class DataSourceCollection() extends js.Object {

    def add(dataSource: DataSource): Promise[DataSource] = js.native

    def contains(dataSource: DataSource): Boolean = js.native

    def destroy(): Unit = js.native

    def get(index: Int): DataSource = js.native

    def indexOf(dataSource: DataSource): Int = js.native

    def isDestroyed(): Boolean = js.native

    def remove(dataSource: DataSource, destroyed: Boolean = false): Boolean = js.native

    def removeAll(destroyed: Boolean = false): Unit = js.native

    // members readonly
    def dataSourceAdded: Event = js.native

    def remove: Event = js.native

    def length: Int = js.native
  }

  @JSName("Cesium.CzmlDataSource")
  @js.native
  class CzmlDataSource(name: UndefOr[String] = undefined) extends DataSource {

    def load(data: String | Object, options: CzmlDSOptions = ???): Promise[DataSource] = js.native

    def process(czml: String | Object, options: CzmlDSOptions = ???): Promise[DataSource] = js.native
  }

  @js.native
  object CzmlDataSource extends js.Object {

    var updaters: Array[js.Function] = js.native

    def load(data: String | Object, options: CzmlDSOptions = ???): Promise[DataSource] = js.native

    def process(czml: String | Object, options: CzmlDSOptions = ???): Promise[DataSource] = js.native

    def processMaterialPacketData(`object`: Object, propertyName: String, packetData: Object,
                                  interval: TimeInterval, sourceUri: String,
                                  entityCollection: EntityCollection): Unit = js.native

    def processPacketData(`type`: js.Function, `object`: Object, propertyName: String, packetData: Object,
                          interval: TimeInterval, sourceUri: String,
                          entityCollection: EntityCollection): Unit = js.native

    def processPositionPacketData(`object`: Object, propertyName: String, packetData: Object,
                                  interval: TimeInterval, sourceUri: String,
                                  entityCollection: EntityCollection): Unit = js.native
  }

  @JSName("Cesium.Viewer")
  @js.native
  class Viewer(container: Element | String, opts: ViewerOptions = ???) extends js.Object {

    def destroy(): Unit = js.native

    // mixin ..... todo
    // def ViewerMixin(viewer: Viewer, options: ViewerOptions)
    // def extend(mixin: ViewerMixin, options: MixinOptions): Unit = js.native

    def flyTo(target: Entity | Array[Entity] | EntityCollection | DataSource, options: FlyOptions): Promise[Boolean] = js.native

    @JSName("flyTo")
    def flyToFuture(target: Future[Entity] | Future[Array[Entity]] | Future[EntityCollection] | Future[DataSource], options: FlyOptions): Promise[Boolean] = js.native

    def forceResize(): Unit = js.native

    def isDestroyed(): Boolean = js.native

    def render(): Unit = js.native

    def resize(): Unit = js.native

    def zoomTo(target: Entity, offset: HeadingPitchRange): Promise[Boolean] = js.native

    // members
    var allowDataSourcesToSuspendAnimation: Boolean = js.native
    var resolutionScale: Double = js.native

    def selectedEntity: Entity = js.native

    //  var terrainProvider: TerrainProvider = js.native
    var trackedEntity: Entity = js.native
    var useDefaultRenderLoop: Boolean = js.native

    // readonly members
    //    val animation: Animation = js.native
    //    val baseLayerPicker: BaseLayerPicker = js.native
    //    val bottomContainer: Element = js.native
    //    val camera: Camera = js.native
    //    val canvas: Canvas = js.native
    //    val cesiumLogo: Element = js.native
    //    val cesiumWidget: CesiumWidget = js.native
    //    val clock: Clock = js.native
    //    val container: Element = js.native
    //    val dataSourceDisplay: DataSourceDisplay = js.native

    def dataSources: DataSourceCollection = js.native

    //    val entities: EntityCollection = js.native
    //    val fullscreenButton: FullscreenButton = js.native
    //    val geocoder: Geocoder = js.native
    //    val homeButton: HomeButton = js.native
    //    val imageryLayers: ImageryLayerCollection = js.native
    //    val infoBox: InfoBox = js.native
    //    val navigationHelpButton: NavigationHelpButton = js.native
    //    val scene: Scene = js.native
    //    val sceneModePicker: SceneModePicker = js.native
    //    val screenSpaceEventHandler: ScreenSpaceEventHandler = js.native
    //    val selectionIndicator: SelectionIndicator = js.native
    //    val timeline: Timeline = js.native
  }

  object Viewer {
    def apply(container: Element | String, options: ViewerOptions) = new Viewer(container, options)
  }

  @JSName("Cesium.Options")
  @js.native
  trait ViewerOptions extends js.Object

  object ViewerOptions extends ViewerOptionsBuilder(noOpts)

  class ViewerOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ViewerOptions, ViewerOptionsBuilder](new ViewerOptionsBuilder(_)) {

    def animation(v: Boolean) = jsOpt("animation", v)

    def baseLayerPicker(v: Boolean) = jsOpt("baseLayerPicker", v)

    def fullscreenButton(v: Boolean) = jsOpt("fullscreenButton", v)

    def geocoder(v: Boolean) = jsOpt("geocoder", v)

    def homeButton(v: Boolean) = jsOpt("homeButton", v)

    def infoBox(v: Boolean) = jsOpt("infoBox", v)

    def sceneModePicker(v: Boolean) = jsOpt("sceneModePicker", v)

    def selectionIndicator(v: Boolean) = jsOpt("selectionIndicator", v)

    def timeline(v: Boolean) = jsOpt("timeline", v)

    def navigationHelpButton(v: Boolean) = jsOpt("navigationHelpButton", v)

    def navigationInstructionsInitiallyVisible(v: Boolean) = jsOpt("navigationInstructionsInitiallyVisible", v)

    def scene3DOnly(v: Boolean) = jsOpt("scene3DOnly", v)

    def orderIndependentTranslucency(v: Boolean) = jsOpt("orderIndependentTranslucency", v)

    def creditContainer(v: Element | String) = jsOpt("creditContainer", v)

    def dataSources(v: DataSourceCollection) = jsOpt("dataSources", v)

    def terrainExaggeration(v: Double) = jsOpt("terrainExaggeration", v)

    //    def clock(v: Clock) = jsOpt("dataSources", v)
    //    def selectedImageryProviderViewModel(v: ProviderViewModel) = jsOpt("dataSources", v)
    //    def imageryProviderViewModels(v: Array[ProviderViewModel] ) = jsOpt("dataSources", v)
    //    def selectedTerrainProviderViewModel(v: ProviderViewModel) = jsOpt("dataSources", v)
    //    def terrainProviderViewModels(v: Array[ProviderViewModel]) = jsOpt("dataSources", v)
    //    def imageryProvider(v: ImageryProvider) = jsOpt("dataSources", v)
    //    def terrainProvider(v: TerrainProvider) = jsOpt("dataSources", v)
    //    def skyBox(v: SkyBox) = jsOpt("dataSources", v)
    //    def skyAtmosphere(v: SkyAtmosphere) = jsOpt("dataSources", v)
    //    def fullscreenElement(v: Element | String) = jsOpt("dataSources", v)
    //    def useDefaultRenderLoop(v: Boolean) = jsOpt("dataSources", v)
    //    def targetFrameRate(v: Int) = jsOpt("dataSources", v)
    //    def showRenderLoopErrors(v: Boolean) = jsOpt("dataSources", v)
    //    def automaticallyTrackDataSourceClocks(v: Boolean) = jsOpt("dataSources", v)
    //    def contextOptions(v: ContextOptions) = jsOpt("dataSources", v)
    //    def sceneMode(v: SceneMode) = jsOpt("dataSources", v)
    //    def mapProjection(v: MapProjection) = jsOpt("dataSources", v)
    //    def globe(v: Globe) = jsOpt("dataSources", v)
  }

  @JSName("Cesium.HeadingPitchRange")
  @js.native
  class HeadingPitchRange(heading: Double = 0.0, pitch: Double = 0.0, range: Double = 0.0) extends js.Object

  @js.native
  object HeadingPitchRange extends js.Object {
    def clone(hpr: HeadingPitchRange, result: HeadingPitchRange): HeadingPitchRange = js.native
  }

  @JSName("Cesium.Options")
  @js.native
  trait FlyOptions extends js.Object

  object FlyOptions extends FlyOptionsBuilder(noOpts)

  class FlyOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[FlyOptions, FlyOptionsBuilder](new FlyOptionsBuilder(_)) {
    def duration(v: Double) = jsOpt("duration", v)

    def maximumHeight(v: Double) = jsOpt("maximumHeight", v)

    def offset(v: HeadingPitchRange) = jsOpt("offset", v)
  }

}