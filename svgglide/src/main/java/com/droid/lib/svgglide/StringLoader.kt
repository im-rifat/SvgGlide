package com.droid.lib.svgglide

import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import com.bumptech.glide.load.model.UnitModelLoader

class StringLoader : UnitModelLoader<String>() {
    override fun handles(s: String): Boolean {
        return s.contains("<svg")
    }

    internal class Factory : ModelLoaderFactory<String, String> {
        override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<String, String> {
            return getInstance()
        }

        override fun teardown() {
        }

        companion object {
            val instance = Factory()
        }
    }
}