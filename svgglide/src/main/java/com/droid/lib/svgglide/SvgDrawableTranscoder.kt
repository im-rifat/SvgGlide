package com.droid.lib.svgglide

import android.graphics.Picture
import android.graphics.drawable.PictureDrawable
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.resource.SimpleResource
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder
import com.caverock.androidsvg.SVG
import com.droid.lib.svgglide.util.SvgUtil
import kotlin.math.roundToInt

/**
 * Convert the [SVG]'s internal representation to an Android-compatible one ([Picture]).
 */
class SvgDrawableTranscoder :
    ResourceTranscoder<SVG, PictureDrawable> {
    override fun transcode(
        toTranscode: Resource<SVG>,
        options: Options
    ): Resource<PictureDrawable>? {
        prepareSvg(toTranscode, options)
        val svg = toTranscode.get()

        val picture = svg.renderToPicture(svg.documentWidth.roundToInt(), svg.documentHeight.roundToInt())
        val drawable =
            PictureDrawable(picture)
        return SimpleResource(drawable)
    }

    private fun prepareSvg(toTranscode: Resource<SVG>, options: Options?) {
        if (toTranscode !is SvgResource) {
            return
        }
        val strategy = options?.get(DownsampleStrategy.OPTION)
        if (strategy != null) {
            val scaleFactor = strategy.getScaleFactor(
                    toTranscode.get().documentWidth.roundToInt(),
                    toTranscode.get().documentHeight.roundToInt(),
                    toTranscode.getWidth(),
                    toTranscode.getHeight()
            )
            SvgUtil.scaleDocumentSize(toTranscode.get(), scaleFactor)
        }
    }
}