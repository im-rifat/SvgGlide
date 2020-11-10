package com.droid.lib.svgglide

import com.bumptech.glide.load.engine.Resource
import com.caverock.androidsvg.SVG
import com.droid.lib.svgglide.util.SvgUtil

class SvgResource(private val svg: SVG, private val width: Int
                  , private val height: Int, private val size: Int): Resource<SVG> {

    init {
        SvgUtil.fix(svg)
    }

    fun getWidth(): Int {
        return width
    }

    fun getHeight(): Int {
        return height
    }

    override fun getResourceClass(): Class<SVG> {
        return SVG::class.java
    }

    override fun get(): SVG {
        return svg
    }

    override fun getSize(): Int {
        return size
    }

    override fun recycle() {
    }
}