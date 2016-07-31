
import cesium._

import scala.language.implicitConversions
import scala.scalajs.js


/**
  * a set of implicit conversions. Use with care.
  *
  */
object CesiumImplicits {

  implicit def Cartesian3ToConstPosProp(value: Cartesian3): ConstantPositionProperty = new ConstantPositionProperty(value)

  implicit def ValueToConstProp(value: Any): ConstantProperty = new ConstantProperty(value.asInstanceOf[js.Any])

  implicit def IntToClockRange(value: Int): ClockRange = ClockRange(value)

  implicit def IntToClockStep(value: Int): ClockStep = ClockStep(value)

}