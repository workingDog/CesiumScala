# Scala.js interface to Cesium.js

[Cesium](http://cesiumjs.org/) is a JavaScript library for creating 3D globes and 2D maps in a web browser without a plugin. 
It uses WebGL for hardware-accelerated graphics, and is cross-platform, cross-browser, 
and tuned for dynamic-data visualization. 

This library **cesiumscala**, is a Scala.js facade to Cesium.js.
Cesium client applications can now be written in [Scala](http://www.scala-lang.org/) and compiled into javascript
using [Scala.js](https://www.scala-js.org/).

## References
 
1) [Scala.js](https://www.scala-js.org/)

2) [Cesium](https://cesiumjs.org/)

## Dependencies code inclusions

The code from [jsext](https://github.com/jducoeur/jsext) relating to JSOptionBuilder is used in **cesiumscala** and
is included here rather than as an external dependency.

## Compiling, packaging and documenting

    sbt fastOptJS
    sbt package
    sbt doc

## Status

work in progress



