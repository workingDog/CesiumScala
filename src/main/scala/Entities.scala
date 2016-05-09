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

import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.{|, UndefOr, undefined}

import org.querki.jsext.{JSOptionBuilder, OptMap, noOpts}

/**
  * this section deals with the Entity API
  */

package cesium {


  @JSName("Cesium.Property")
  @js.native
  trait Property extends js.Object {

    def definitionChanged: Event = js.native

    def isConstant: Boolean = js.native

    def equals(other: UndefOr[Property] = undefined): Boolean = js.native

    def getValue(time: JulianDate, result: UndefOr[Object] = undefined): Object = js.native
  }

  @js.native
  trait DataComparer extends js.Object {
    // todo
  }

  @JSName("Cesium.TimeIntervalCollection")
  @js.native
  class TimeIntervalCollection(intervals: UndefOr[Array[TimeInterval]] = undefined) extends js.Object {

    def addInterval(interval: TimeInterval, dataComparer: UndefOr[DataComparer] = undefined): Unit = js.native

    // todo
  }

  @JSName("Cesium.ConstantProperty")
  @js.native
  class ConstantProperty(value: UndefOr[js.Object]) extends Property

  @JSName("Cesium.CompositeProperty")
  @js.native
  class CompositeProperty() extends Property {
    def intervals: TimeIntervalCollection = js.native
  }

  @js.native
  trait Packable extends js.Object {
    // todo
  }

  @JSName("Cesium.SampledProperty")
  @js.native
  class SampledProperty(`type`: Number | Packable, derivativeTypes: UndefOr[Array[Packable]]) extends Property {
    // todo
  }

  @JSName("Cesium.TimeIntervalCollectionProperty")
  @js.native
  class TimeIntervalCollectionProperty() extends Property {
    def intervals: TimeIntervalCollection = js.native
  }

  @JSName("Cesium.MaterialProperty")
  @js.native
  trait MaterialProperty extends Property {
    def getType(time: JulianDate): String = js.native
  }

  @JSName("Cesium.PositionProperty")
  @js.native
  trait PositionProperty extends Property {

    val referenceFrame: ReferenceFrame = js.native

    def getValueInReferenceFrame(time: JulianDate, referenceFrame: ReferenceFrame, result: UndefOr[Object] = undefined): Cartesian3 = js.native
  }

  @JSName("Cesium.CompositePositionProperty")
  @js.native
  class CompositePositionProperty(referenceFrame: ReferenceFrame) extends PositionProperty {
    def intervals: TimeIntervalCollection = js.native
  }

  @JSName("Cesium.ConstantPositionProperty")
  @js.native
  class ConstantPositionProperty(value: Cartesian3, referenceFrame: ReferenceFrame) extends PositionProperty {
    def setValue(value: Cartesian3, referenceFrame: ReferenceFrame): Unit = js.native
  }

  @js.native
  trait InterpolationAlgorithm extends js.Object {
    // todo
  }

  @js.native
  trait ExtrapolationType extends js.Object {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait SampledPositionOptions extends js.Object

  object SampledPositionOptions extends SampledPositionOptionsBuilder(noOpts)

  class SampledPositionOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[SampledPositionOptions, SampledPositionOptionsBuilder](new SampledPositionOptionsBuilder(_)) {

    def interpolationAlgorithm(v: InterpolationAlgorithm) = jsOpt("interpolationAlgorithm", v)

    def interpolationDegree(v: Int) = jsOpt("interpolationDegree", v)

  }

  @JSName("Cesium.SampledPositionProperty")
  @js.native
  class SampledPositionProperty(referenceFrame: ReferenceFrame, numberOfDerivatives: Int) extends PositionProperty {

    def backwardExtrapolationDuration(referenceFrame: ReferenceFrame, numberOfDerivatives: Int): Unit = js.native

    def backwardExtrapolationType: ExtrapolationType = js.native

    def forwardExtrapolationDuration(referenceFrame: ReferenceFrame, numberOfDerivatives: Int): Unit = js.native

    def forwardExtrapolationType: ExtrapolationType = js.native

    def interpolationAlgorithm: InterpolationAlgorithm = js.native

    def interpolationDegree: Int = js.native

    def addSamplesPackedArray(packedSamples: Array[Int], epoch: JulianDate): Unit = js.native

    def addSample(time: JulianDate, position: Cartesian3, derivatives: Array[Cartesian3]): Unit = js.native

    def addSamples(time: Array[JulianDate], position: Array[Cartesian3], derivatives: Array[Array[Cartesian3]]): Unit = js.native

    def setInterpolationOptions(options: SampledPositionOptions): Unit = js.native

  }

  @JSName("Cesium.TimeIntervalCollectionPositionProperty")
  @js.native
  class TimeIntervalCollectionPositionProperty(referenceFrame: ReferenceFrame) extends PositionProperty {
    def intervals: TimeIntervalCollection = js.native
  }

  @JSName("Cesium.TimeIntervalCollectionProperty")
  @js.native
  class ReferenceProperty(targetCollection: EntityCollection, targetId: String, targetPropertyNames: Array[String]) extends Property {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait BillboardOptions extends js.Object

  object BillboardOptions extends BillboardOptionsBuilder(noOpts)

  class BillboardOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[BillboardOptions, BillboardOptionsBuilder](new BillboardOptionsBuilder(_)) {

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

  @JSName("Cesium.BillboardGraphics")
  @js.native
  class BillboardGraphics(options: BillboardOptions = ???) extends js.Object {
    var alignedAxis: Property = js.native
    var color: Property = js.native
    var eyeOffset: Property = js.native
    var height: Property = js.native
    var image: Property = js.native
    var imageSubRegion: Property = js.native
    var pixelOffset: Property = js.native
    var pixelOffsetScaleByDistance: Property = js.native
    var rotation: Property = js.native
    var scale: Property = js.native
    var scaleByDistance: Property = js.native
    var show: Property = js.native
    var sizeInMeters: Property = js.native
    var translucencyByDistance: Property = js.native
    var verticalOrigin: Property = js.native
    var width: Property = js.native

    def definitionChanged: Event = js.native

    def clone(result: UndefOr[BillboardGraphics] = undefined): BillboardGraphics = js.native

    def merge(source: BillboardGraphics): Unit = js.native
  }

  @JSName("Cesium.Options")
  @js.native
  trait BoxGraphicsOptions extends js.Object

  object BoxGraphicsOptions extends BoxGraphicsOptionsBuilder(noOpts)

  class BoxGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[BoxGraphicsOptions, BoxGraphicsOptionsBuilder](new BoxGraphicsOptionsBuilder(_)) {
    def xxx(v: Property) = jsOpt("xxx", v)

    // todo
  }

  @JSName("Cesium.BoxGraphics")
  @js.native
  class BoxGraphics(options: BoxGraphicsOptions = ???) extends js.Object {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait CorridorGraphicsOptions extends js.Object

  object CorridorGraphicsOptions extends CorridorGraphicsOptionsBuilder(noOpts)

  class CorridorGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CorridorGraphicsOptions, CorridorGraphicsOptionsBuilder](new CorridorGraphicsOptionsBuilder(_)) {
    def xxx(v: Property) = jsOpt("xxx", v)

    // todo
  }

  @JSName("Cesium.CorridorGraphics")
  @js.native
  class CorridorGraphics(options: CorridorGraphicsOptions = ???) extends js.Object {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait CylinderGraphicsOptions extends js.Object

  object CylinderGraphicsOptions extends CylinderGraphicsOptionsBuilder(noOpts)

  class CylinderGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[CylinderGraphicsOptions, CylinderGraphicsOptionsBuilder](new CylinderGraphicsOptionsBuilder(_)) {
    def xxx(v: Property) = jsOpt("xxx", v)

    // todo
  }

  @JSName("Cesium.CylinderGraphics")
  @js.native
  class CylinderGraphics(options: CylinderGraphicsOptions = ???) extends js.Object {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait EllipseGraphicsOptions extends js.Object

  object EllipseGraphicsOptions extends EllipseGraphicsOptionsBuilder(noOpts)

  class EllipseGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EllipseGraphicsOptions, EllipseGraphicsOptionsBuilder](new EllipseGraphicsOptionsBuilder(_)) {
    def xxx(v: Property) = jsOpt("xxx", v)

    // todo
  }

  @JSName("Cesium.EllipseGraphics")
  @js.native
  class EllipseGraphics(options: EllipseGraphicsOptions = ???) extends js.Object {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait EllipsoidGraphicsOptions extends js.Object

  object EllipsoidGraphicsOptions extends EllipsoidGraphicsOptionsBuilder(noOpts)

  class EllipsoidGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[EllipsoidGraphicsOptions, EllipsoidGraphicsOptionsBuilder](new EllipsoidGraphicsOptionsBuilder(_)) {
    def xxx(v: Property) = jsOpt("xxx", v)

    // todo
  }

  @JSName("Cesium.EllipsoidGraphics")
  @js.native
  class EllipsoidGraphics(options: EllipsoidGraphicsOptions = ???) extends js.Object {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait LabelGraphicsOptions extends js.Object

  object LabelGraphicsOptions extends LabelGraphicsOptionsBuilder(noOpts)

  class LabelGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LabelGraphicsOptions, LabelGraphicsOptionsBuilder](new LabelGraphicsOptionsBuilder(_)) {
    def xxx(v: Property) = jsOpt("xxx", v)

    // todo
  }

  @JSName("Cesium.LabelGraphics")
  @js.native
  class LabelGraphics(options: LabelGraphicsOptions = ???) extends js.Object {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait ModelGraphicsOptions extends js.Object

  object ModelGraphicsOptions extends ModelGraphicsOptionsBuilder(noOpts)

  class ModelGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ModelGraphicsOptions, ModelGraphicsOptionsBuilder](new ModelGraphicsOptionsBuilder(_)) {
    def xxx(v: Property) = jsOpt("xxx", v)

    // todo
  }

  @JSName("Cesium.ModelGraphics")
  @js.native
  class ModelGraphics(options: ModelGraphicsOptions = ???) extends js.Object {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait PathGraphicsOptions extends js.Object

  object PathGraphicsOptions extends PathGraphicsOptionsBuilder(noOpts)

  class PathGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PathGraphicsOptions, PathGraphicsOptionsBuilder](new PathGraphicsOptionsBuilder(_)) {
    def xxx(v: Property) = jsOpt("xxx", v)

    // todo
  }

  @JSName("Cesium.PathGraphics")
  @js.native
  class PathGraphics(options: PathGraphicsOptions = ???) extends js.Object {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait PointGraphicsOptions extends js.Object

  object PointGraphicsOptions extends PointGraphicsOptionsBuilder(noOpts)

  class PointGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PointGraphicsOptions, PointGraphicsOptionsBuilder](new PointGraphicsOptionsBuilder(_)) {
    def xxx(v: Property) = jsOpt("xxx", v)

    // todo
  }

  @JSName("Cesium.PointGraphics")
  @js.native
  class PointGraphics(options: PointGraphicsOptions = ???) extends js.Object {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait PolygonGraphicsOptions extends js.Object

  object PolygonGraphicsOptions extends PolygonGraphicsOptionsBuilder(noOpts)

  class PolygonGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolygonGraphicsOptions, PolygonGraphicsOptionsBuilder](new PolygonGraphicsOptionsBuilder(_)) {
    def xxx(v: Property) = jsOpt("xxx", v)

    // todo
  }

  @JSName("Cesium.PolygonGraphics")
  @js.native
  class PolygonGraphics(options: PolygonGraphicsOptions = ???) extends js.Object {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait PolylineGraphicsOptions extends js.Object

  object PolylineGraphicsOptions extends PolylineGraphicsOptionsBuilder(noOpts)

  class PolylineGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineGraphicsOptions, PolylineGraphicsOptionsBuilder](new PolylineGraphicsOptionsBuilder(_)) {
    def xxx(v: Property) = jsOpt("xxx", v)

    // todo
  }

  @JSName("Cesium.PolylineGraphics")
  @js.native
  class PolylineGraphics(options: PolylineGraphicsOptions = ???) extends js.Object {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait PolylineVolumeGraphicsOptions extends js.Object

  object PolylineVolumeGraphicsOptions extends PolylineVolumeGraphicsOptionsBuilder(noOpts)

  class PolylineVolumeGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolylineVolumeGraphicsOptions, PolylineVolumeGraphicsOptionsBuilder](new PolylineVolumeGraphicsOptionsBuilder(_)) {
    def xxx(v: Property) = jsOpt("xxx", v)

    // todo
  }

  @JSName("Cesium.PolylineVolumeGraphics")
  @js.native
  class PolylineVolumeGraphics(options: PolylineVolumeGraphicsOptions = ???) extends js.Object {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait RectangleGraphicsOptions extends js.Object

  object RectangleGraphicsOptions extends RectangleGraphicsOptionsBuilder(noOpts)

  class RectangleGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[RectangleGraphicsOptions, RectangleGraphicsOptionsBuilder](new RectangleGraphicsOptionsBuilder(_)) {
    def xxx(v: Property) = jsOpt("xxx", v)

    // todo
  }

  @JSName("Cesium.RectangleGraphics")
  @js.native
  class RectangleGraphics(options: RectangleGraphicsOptions = ???) extends js.Object {
    // todo
  }

  @JSName("Cesium.Options")
  @js.native
  trait WallGraphicsOptions extends js.Object

  object WallGraphicsOptions extends WallGraphicsOptionsBuilder(noOpts)

  class WallGraphicsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[WallGraphicsOptions, WallGraphicsOptionsBuilder](new WallGraphicsOptionsBuilder(_)) {
    def xxx(v: Property) = jsOpt("xxx", v)

    // todo
  }

  @JSName("Cesium.WallGraphics")
  @js.native
  class WallGraphics(options: WallGraphicsOptions = ???) extends js.Object {
    // todo
  }

  @JSName("Cesium.Entity")
  @js.native
  class Entity(options: EntityOptions = ???) extends js.Object {

    var id: String = js.native
    var availability: TimeIntervalCollection = js.native
    var billboard: BillboardGraphics = js.native
    var box: BoxGraphics = js.native
    var corridor: CorridorGraphics = js.native
    var cylinder: CylinderGraphics = js.native
    var description: Property = js.native
    var ellipse: EllipseGraphics = js.native
    var ellipsoid: EllipsoidGraphics = js.native
    var entityCollection: EntityCollection = js.native
    var isShowing: Boolean = js.native
    var label: LabelGraphics = js.native
    var model: ModelGraphics = js.native
    var name: String = js.native
    var orientation: Property = js.native
    var parent: Entity = js.native
    var path: PathGraphics = js.native
    var point: PointGraphics = js.native
    var polygon: PolygonGraphics = js.native
    var polyline: PolylineGraphics = js.native
    var polylineVolume: PolylineVolumeGraphics = js.native
    var position: PositionProperty = js.native
    var propertyNames: Array[Int] = js.native  // check type of array todo
    var rectangle: RectangleGraphics = js.native
    var show: Boolean = js.native
    var viewFrom: Property = js.native
    var wall: WallGraphics = js.native

    def definitionChanged: Event = js.native

    def addProperty(propertyName: String): Unit = js.native

    def isAvailable(time: JulianDate): Boolean = js.native

    def merge(source: Entity): Unit = js.native

    def removeProperty(propertyName: String): Unit = js.native
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


}
