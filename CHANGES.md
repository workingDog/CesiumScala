Change Log
==========

## changes in 1.2-SNAPSHOT

* changed CustomDataSource, CzmlDataSource, GeoJsonDataSource and KmlDataSource to extends DataSource
* changed Packable to be a simple trait that extends js.Object
* added trait PackableStatic that extends Packable, so that derived classes extends Packable and
their companion object extends PackableStatic which has the required static methods.
* changed BoundingSphere, BoxGeometry, BoxOutlineGeometry, Cartesian2, Cartesian3, Cartesian4, CircleGeometry,
CircleOutlineGeometry, Color, CorridorGeometry, Matrix4, NearFarScalar, Rectangle,
VertexFormat to extends Packable and their corresponding object extends PackableStatic
* changed Quaternion to extends PackableForInterpolation
* changed class TerrainProvider to trait TerrainProvider
* removed object TerrainProvider and moved its methods to trait TerrainProvider
* changed VRTheWorldTerrainProvider, ArcGisImageServerTerrainProvider, CesiumTerrainProvider, EllipsoidTerrainProvider,
to extends TerrainProvider
* changed class TerrainData to trait TerrainData
* changed HeightmapTerrainData and QuantizedMeshTerrainData to extends TerrainData
* changed class GeometryUpdater to trait GeometryUpdater
* changed object GeometryUpdater to trait GeometryUpdaterStatic
* changed EllipseGeometryUpdater, EllipsoidGeometryUpdater, PolygonGeometryUpdater,
PolylineGeometryUpdater, RectangleGeometryUpdater, WallGeometryUpdater to extends GeometryUpdater
also their corresponding object to extends GeometryUpdaterStatic
* changed class MaterialProperty to trait MaterialProperty
* changed class PositionProperty to trait PositionProperty
* changed class Visualizer to trait Visualizer
* changed BillboardVisualizer,LabelVisualizer,ModelVisualizer,PathVisualizer,PointVisualizer,GeometryVisualizer
to extends Visualizer
* changed class ImageryProvider to trait ImageryProvider
* changed object ImageryProvider to trait ImageryProviderStatic
* changed ArcGisMapServerImageryProvider, SingleTileImageryProvider,BingMapsImageryProvider, UrlTemplateImageryProvider,
GoogleEarthImageryProvider,MapboxImageryProvider,WebMapTileServiceImageryProvider,WebMapServiceImageryProvider
to extends ImageryProvider, also add a corresponding object to all that extends ImageryProviderStatic
* changed class Label to trait Label
* changed class ModelAnimation to trait ModelAnimation
* changed class ModelAnimationCollection to trait ModelAnimationCollection
* changed class ModelMaterial to trait ModelMaterial
* changed class ModelMesh to trait ModelMesh
* changed class ModelNode to trait ModelNode
* changed class TileDiscardPolicy to trait TileDiscardPolicy
* changed class PointPrimitive to trait PointPrimitive
* changed class Billboard to trait Billboard
* changed class Spline to trait Spline
* changed CatmullRomSpline, LinearSpline, QuaternionSpline and HermiteSpline to extends Spline
* changed class TilingScheme to trait TilingScheme
* changed WebMercatorTilingScheme and GeographicTilingScheme to extends TilingScheme
* changed class DynamicGeometryUpdater to trait DynamicGeometryUpdater
* added rotatable2D to Viewer, Scene, CesiumWidget, ViewerOptions, SceneOptions, CesiumWidgetOptions
* added packArray and unpackArray to Cartesian2, Cartesian3, and Cartesian4 objects
* added aircraftHeadingPitchRollToFixedFrame, aircraftHeadingPitchRollQuaternion to Transforms
* renamed headingPitchRollMatrix4 to headingPitchRollToFixedFrame in Transforms


