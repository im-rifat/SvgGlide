package com.droid.lib.svgglide.decoder

import com.caverock.androidsvg.SVG

class UnitSvgDecoder: SvgDecoder<SVG>() {
    override fun getSize(source: SVG): Int {
        return 0
    }

    override fun loadSvg(source: SVG): SVG {
        return source
    }
}