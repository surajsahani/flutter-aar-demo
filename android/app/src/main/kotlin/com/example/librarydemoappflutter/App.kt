package com.example.librarydemoappflutter

import android.app.Application
import com.lib.loopsdk.auth.LoopInstance
import io.reactivex.rxjava3.disposables.CompositeDisposable

class App: Application() {

    override fun onCreate() {
        LoopInstance.initialize(this)
        super.onCreate()
    }
}