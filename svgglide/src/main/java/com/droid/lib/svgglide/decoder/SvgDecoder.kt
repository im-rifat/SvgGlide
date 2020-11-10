package com.droid.lib.svgglide.decoder

import com.bumptech.glide.load.Options
import com.bumptech.glide.load.ResourceDecoder
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.request.target.Target
import com.caverock.androidsvg.SVG
import com.droid.lib.svgglide.SvgResource
import com.droid.lib.svgglide.util.SvgUtil
import java.io.InputStream
import kotlin.math.roundToInt

/** Base Class.  */
abstract class SvgDecoder<T>: ResourceDecoder<T, SVG> {

    override fun handles(source: T, options: Options): Boolean {
        return true
    }

    override fun decode(source: T, width: Int, height: Int, options: Options): Resource<SVG>? {
        val size = getSize(source)
        val svg = loadSvg(source)

        SvgUtil.fix(svg)
        val sizes: IntArray = getResourceSize(svg, width, height)

        return SvgResource(svg, sizes[0], sizes[1], size)
    }

    open fun getResourceSize(svg: SVG, width: Int, height: Int): IntArray {
        val sizes = intArrayOf(width, height)
        if (width == Target.SIZE_ORIGINAL && height == Target.SIZE_ORIGINAL) {
            sizes[0] = svg.documentWidth.roundToInt()
            sizes[1] = svg.documentHeight.roundToInt()
        } else if (width == Target.SIZE_ORIGINAL) {
            sizes[0] = svg.documentAspectRatio.roundToInt() * height
        } else if (height == Target.SIZE_ORIGINAL) {
            sizes[1] = (width.toFloat() / svg.documentAspectRatio).roundToInt()
        }
        return sizes
    }

    abstract fun getSize(source: T): Int
    abstract fun loadSvg(source: T): SVG
}