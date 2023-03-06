package com.example.librarydemoappflutter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.lib.loopsdk.core.util.RxBusOnboardingRelay
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugins.GeneratedPluginRegistrant
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainActivity: FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        //GeneratedPluginRegistrant.registerWith(flutterEngine)
            flutterEngine
            .platformViewsController
            .registry
            .registerViewFactory("<platform-view-type>", NativeViewFactory())
    }
    private val disposables by lazy { CompositeDisposable() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
//        Logger.isEnabled = true
//        Logger.d("MainActivity", "hello")
        Toast.makeText(this, "Native SDK called", Toast.LENGTH_SHORT).show()
        disposables.add(RxBusOnboardingRelay.subscribe{ primaryUserId->
            Intent(this, LoginActivity::class.java).apply {
                this.putExtra("USERID", primaryUserId)
                startActivity(this)
            }
            this.finish()
        })
    }
    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

}
