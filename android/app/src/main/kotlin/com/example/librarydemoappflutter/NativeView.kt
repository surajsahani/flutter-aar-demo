package com.example.librarydemoappflutter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.armanco.state_button.StateButton
import com.lib.loopsdk.core.customViews.TriggerButton
import io.flutter.plugin.platform.PlatformView
import io.reactivex.rxjava3.disposables.CompositeDisposable

internal class NativeView(context: Context, id: Int, creationParams: Map<String?, Any?>?) : PlatformView {
    private val nativeView: View


    override fun getView(): View {
        return nativeView
    }

    override fun dispose() {}


    init {
        nativeView = LayoutInflater.from(context).inflate(R.layout.activity_main, null)
        setupViews(nativeView)
    }
    private fun setupViews(nativeView: View?) {

    }
}
