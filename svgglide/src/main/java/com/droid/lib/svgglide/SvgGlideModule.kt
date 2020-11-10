package com.droid.lib.svgglide

import android.content.Context
import android.graphics.drawable.PictureDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.model.UnitModelLoader
import com.bumptech.glide.module.LibraryGlideModule
import com.caverock.androidsvg.SVG
import com.droid.lib.svgglide.decoder.InputStreamSvgDecoder
import com.droid.lib.svgglide.decoder.StringSvgDecoder
import com.droid.lib.svgglide.decoder.UnitSvgDecoder
import java.io.InputStream

@GlideModule
class SvgGlideModule : LibraryGlideModule() {
    private val BUCKET = "com.droid.lib.svgglide"

    override fun registerComponents(
        context: Context,
        glide: Glide,
        registry: Registry
    ) {
        super.registerComponents(context, glide, registry)

        registry
            .register(SVG::class.java, PictureDrawable::class.java, SvgDrawableTranscoder())
            .append(SVG::class.java, SVG::class.java, UnitModelLoader.Factory.getInstance())
            .append(String::class.java, String::class.java, StringLoader.Factory.instance)
            .append(BUCKET, InputStream::class.java, SVG::class.java, InputStreamSvgDecoder())
            .append(BUCKET, String::class.java, SVG::class.java, StringSvgDecoder())
            .append(BUCKET, SVG::class.java, SVG::class.java, UnitSvgDecoder())
    }
}