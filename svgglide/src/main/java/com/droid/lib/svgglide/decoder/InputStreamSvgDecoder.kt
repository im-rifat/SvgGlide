package com.droid.lib.svgglide.decoder

import com.caverock.androidsvg.SVG
import com.caverock.androidsvg.SVGParseException
import com.droid.lib.svgglide.util.SizeUtil
import java.io.IOException
import java.io.InputStream

/** Decodes an SVG internal representation from an [InputStream].  */
class InputStreamSvgDecoder : SvgDecoder<InputStream>() {

    override fun getSize(source: InputStream): Int {
        return SizeUtil.getSize(source)
    }

    override fun loadSvg(source: InputStream): SVG {
        return try {
            return SVG.getFromInputStream(source)
        } catch (ex: SVGParseException) {
            throw IOException("Cannot load SVG from stream", ex)
        }
    }
}