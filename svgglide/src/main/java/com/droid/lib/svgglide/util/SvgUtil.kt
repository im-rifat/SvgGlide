package com.droid.lib.svgglide.util

import android.graphics.RectF
import com.caverock.androidsvg.SVG
import com.caverock.androidsvg.SVGParseException
import java.io.*

object SvgUtil {

    @Throws(IOException::class)
    fun fix(svg: SVG) {
        val viewBox = svg.documentViewBox
        val docWidth = svg.documentWidth
        val docHeight = svg.documentHeight
        if (viewBox == null) {
            if (docWidth > 0 && docHeight > 0) {
                svg.setDocumentViewBox(0f, 0f, docWidth, docHeight)
            } else {
                throw IOException("SVG must have specify 'width' & 'height' tags or 'viewbox'")
            }
        } else if (docWidth <= 0 && docHeight <= 0) {
            svg.documentWidth = viewBox.width()
            svg.documentHeight = viewBox.height()
        } else if (docWidth <= 0) {
            svg.documentWidth = aspectRatio(viewBox) * docHeight
        } else if (docHeight <= 0) {
            svg.documentHeight = docWidth / aspectRatio(viewBox)
        }
    }

    private fun aspectRatio(rect: RectF): Float {
        return rect.width() / rect.height()
    }

    fun scaleDocumentSize(
            svg: SVG,
            scale: Float
    ) {
        svg.documentWidth = svg.documentWidth * scale
        svg.documentHeight = svg.documentHeight * scale
    }
}