package com.droid.lib.svgglide.decoder

import com.caverock.androidsvg.SVG
import com.caverock.androidsvg.SVGParseException
import com.droid.lib.svgglide.util.SizeUtil
import java.io.IOException
import java.io.InputStream

/** Decodes an SVG internal representation from [String].  */
class StringSvgDecoder: SvgDecoder<String>() {

    override fun getSize(source: String): Int {
        return SizeUtil.getSize(source)
    }

    override fun loadSvg(source: String): SVG {
        return try {
            return SVG.getFromString(source)
        } catch (ex: SVGParseException) {
            throw IOException("Cannot load SVG from string", ex)
        }
    }
}