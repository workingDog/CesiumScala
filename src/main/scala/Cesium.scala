import org.scalajs.dom._

import scala.concurrent._
import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.|


/**
  * A Scala.js facade for Cesium.js "An open-source JavaScript library for world-class 3D globes and maps"
  *
  * see:  http://cesiumjs.org/
  *
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

  @JSName("Cesium")
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

  @JSName("JulianDate")
  @js.native
  trait JulianDate extends js.Object {
    // todo
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
  trait AppearenceOptions extends js.Object {
    var translucent: Boolean = js.native
    var closed: Boolean = js.native
    var material: Material = js.native
    var vertexShaderSource: String = js.native
    var fragmentShaderSource: String = js.native
    var renderState: RenderState = js.native
  }

  object AppearenceOptions {
    def apply(translucent: js.UndefOr[Boolean] = js.undefined,
              closed: js.UndefOr[Boolean] = js.undefined,
              material: js.UndefOr[Material] = Material.ColorType,
              vertexShaderSource: js.UndefOr[String] = js.undefined,
              fragmentShaderSource: js.UndefOr[String] = js.undefined,
              renderState: js.UndefOr[RenderState] = js.undefined
             ): AppearenceOptions = {
      js.Dynamic.literal(translucent = translucent,
        closed = closed,
        material = material,
        vertexShaderSource = vertexShaderSource,
        fragmentShaderSource = fragmentShaderSource,
        renderState = renderState
      ).asInstanceOf[AppearenceOptions]
    }
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

  @JSName("Cesium.Options")
  @js.native
  trait ArcGisImageServerTerrainProviderOptions extends js.Object {
    var url: String = js.native
    var token: String = js.native
    var proxy: Object = js.native
    var tilingScheme: TilingScheme = js.native
    var ellipsoid: Ellipsoid = js.native
    var credit: Credit | String = js.native
  }

  object ArcGisImageServerTerrainProviderOptions {
    def apply(url: String = null,
              token: js.UndefOr[String] = js.undefined,
              proxy: js.UndefOr[js.Any] = js.undefined,
              tilingScheme: js.UndefOr[TilingScheme] = js.undefined,
              ellipsoid: js.UndefOr[Ellipsoid] = js.undefined,
              credit: js.UndefOr[js.Any] = js.undefined
             ): ArcGisImageServerTerrainProviderOptions = {
      js.Dynamic.literal(url = url,
        token = token,
        proxy = proxy,
        tilingScheme = tilingScheme,
        ellipsoid = ellipsoid,
        credit = credit
      ).asInstanceOf[ArcGisImageServerTerrainProviderOptions]
    }
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

    def requestTileGeometry(x: Double, y: Double, level: Int): Option[Future[TerrainData]] = js.native
  }


  //-------------------------------------------------------------------------------

  @JSName("Cesium.TimeInterval")
  @js.native
  class TimeInterval() extends js.Object {
    // todo
  }

  @JSName("Cesium.Entity")
  @js.native
  class Entity() extends js.Object {
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
  trait CzmlDSOptions extends js.Object {
    var sourceUri: String = js.native
  }

  object CzmlDSOptions {
    def apply(sourceUri: String): CzmlDSOptions = {
      js.Dynamic.literal(sourceUri = sourceUri).asInstanceOf[CzmlDSOptions]
    }
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
  class CzmlDataSource(name: String = null) extends DataSource {

    def load(data: String | Object, options: CzmlDSOptions = null): Promise[DataSource] = js.native

    def process(czml: String | Object, options: CzmlDSOptions = null): Promise[DataSource] = js.native
  }

  @js.native
  object CzmlDataSource extends js.Object {
    var updaters: Array[js.Function] = js.native

    def load(data: String | Object, options: CzmlDSOptions = null): Promise[DataSource] = js.native

    def process(czml: String | Object, options: CzmlDSOptions = null): Promise[DataSource] = js.native

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
  class Viewer(container: Element | String, opts: ViewerOptions = null) extends js.Object {

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

  @JSName("Cesium.Options")
  @js.native
  trait ViewerOptions extends js.Object {
    var animation: Boolean = js.native
    var baseLayerPicker: Boolean = js.native
    var fullscreenButton: Boolean = js.native
    var geocoder: Boolean = js.native
    var homeButton: Boolean = js.native
    var infoBox: Boolean = js.native
    var sceneModePicker: Boolean = js.native
    var selectionIndicator: Boolean = js.native
    var timeline: Boolean = js.native
    var navigationHelpButton: Boolean = js.native
    var navigationInstructionsInitiallyVisible: Boolean = js.native
    var scene3DOnly: Boolean = js.native
    //    var clock: Clock = js.native
    //    var selectedImageryProviderViewModel: ProviderViewModel = js.native
    //    var imageryProviderViewModels: Array[ProviderViewModel] = js.native
    //    var selectedTerrainProviderViewModel: ProviderViewModel = js.native
    //    var terrainProviderViewModels: Array[ProviderViewModel] = js.native
    //    var imageryProvider: ImageryProvider = js.native
    //    var terrainProvider: TerrainProvider = js.native
    //    var skyBox: SkyBox = js.native
    //    var skyAtmosphere: SkyAtmosphere = js.native
    //    var fullscreenElement: Element | String = js.native
    //    var useDefaultRenderLoop: Boolean = js.native
    //    var targetFrameRate: Number = js.native
    //    var showRenderLoopErrors: Boolean = js.native
    //    var automaticallyTrackDataSourceClocks: Boolean = js.native
    //    var contextOptions: ContextOptions = js.native
    //    var sceneMode: SceneMode = js.native
    //    var mapProjection: MapProjection = js.native
    //    var globe: Globe = js.native
    var orderIndependentTranslucency: Boolean = js.native
    var creditContainer: Element | String = js.native
    var dataSources: DataSourceCollection = js.native
    var terrainExaggeration: Double = js.native
  }

  object ViewerOptions {
    def apply(
               animation: Boolean = true,
               baseLayerPicker: Boolean = true,
               fullscreenButton: Boolean = true,
               geocoder: Boolean = true,
               homeButton: Boolean = true,
               infoBox: Boolean = true,
               sceneModePicker: Boolean = true,
               selectionIndicator: Boolean = true,
               timeline: Boolean = true,
               navigationHelpButton: Boolean = true,
               navigationInstructionsInitiallyVisible: Boolean = true,
               scene3DOnly: Boolean = false,
               //               clock: Clock = new Clock(),
               //               selectedImageryProviderViewModel: ProviderViewModel = null,
               //               imageryProviderViewModels: Array[ProviderViewModel] = createDefaultImageryProviderViewModels(),
               //               selectedTerrainProviderViewModel: ProviderViewModel = null,
               //               terrainProviderViewModels: Array[ProviderViewModel] = createDefaultTerrainProviderViewModels(),
               //               imageryProvider: ImageryProvider = new BingMapsImageryProvider(),
               //               terrainProvider: TerrainProvider = new EllipsoidTerrainProvider(),
               //               skyBox: SkyBox = null,
               //               skyAtmosphere: SkyAtmosphere = null,
               //               fullscreenElement: Element | String = document.body,
               //               useDefaultRenderLoop: Boolean = true,
               //               targetFrameRate: Number = null,
               //               showRenderLoopErrors: Boolean = true,
               //               automaticallyTrackDataSourceClocks: Boolean = true,
               //               contextOptions: ContextOptions = null,
               //               sceneMode: SceneMode = SceneMode.SCENE3D,
               //               mapProjection: MapProjection = new GeographicProjection(),
               //               globe: Globe = new Globe(mapProjection.ellipsoid),
               orderIndependentTranslucency: Boolean = true,
               // creditContainer: Element | String = null,
               creditContainer: String = null,
               dataSources: DataSourceCollection = new DataSourceCollection(),
               terrainExaggeration: Double = 1.0
             ): ViewerOptions = {
      js.Dynamic.literal(
        animation = animation,
        baseLayerPicker = baseLayerPicker,
        fullscreenButton = fullscreenButton,
        geocoder = geocoder,
        homeButton = homeButton,
        infoBox = infoBox,
        sceneModePicker = sceneModePicker,
        selectionIndicator = selectionIndicator,
        timeline = timeline,
        navigationHelpButton = navigationHelpButton,
        navigationInstructionsInitiallyVisible = navigationInstructionsInitiallyVisible,
        scene3DOnly = scene3DOnly,
        //        clock = clock,
        //        selectedImageryProviderViewModel = selectedImageryProviderViewModel,
        //        imageryProviderViewModels = imageryProviderViewModels,
        //        selectedTerrainProviderViewModel = selectedTerrainProviderViewModel,
        //        terrainProviderViewModels = terrainProviderViewModels,
        //        imageryProvider = imageryProvider,
        //        terrainProvider = terrainProvider,
        //        skyBox = skyBox,
        //        skyAtmosphere = skyAtmosphere,
        //        fullscreenElement = fullscreenElement,
        //        useDefaultRenderLoop = useDefaultRenderLoop,
        //        targetFrameRate = targetFrameRate,
        //        showRenderLoopErrors = showRenderLoopErrors,
        //        automaticallyTrackDataSourceClocks = automaticallyTrackDataSourceClocks,
        //        contextOptions = contextOptions,
        //        sceneMode = sceneMode,
        //        mapProjection = mapProjection,
        //        globe = globe,
        orderIndependentTranslucency = orderIndependentTranslucency,
        creditContainer = creditContainer,
        dataSources = dataSources,
        terrainExaggeration = terrainExaggeration
      ).asInstanceOf[ViewerOptions]
    }
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
  trait FlyOptions extends js.Object {
    var duration: Double = js.native
    var maximumHeight: Double = js.native
    var offset: HeadingPitchRange = js.native
  }

  object FlyOptions {
    def apply(
               duration: Double = 3.0,
               maximumHeight: Double = 1.0,
               offset: HeadingPitchRange = null
             ): FlyOptions = {
      js.Dynamic.literal(
        duration = duration,
        maximumHeight = maximumHeight,
        offset = offset
      ).asInstanceOf[FlyOptions]
    }
  }



}