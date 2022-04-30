package com.cendrawasih.nyopi

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.cendrawasih.nyopi.features.screen.splash.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val progressBar : ProgressBar by lazy {
        findViewById(R.id.progressBar)
    }

    private val splashViewModel : SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val userManager = splashViewModel.userManager
        userManager.onLoading = {
            progressBar.isVisible = true
        }

        userManager.onSuccess = { user ->
            progressBar.isVisible = false
            Toast.makeText(this, "Must be Intent to Main", Toast.LENGTH_LONG).show()
        }

        userManager.onFailure = { throwable ->
            progressBar.isVisible = false
            Toast.makeText(this, throwable.localizedMessage, Toast.LENGTH_LONG).show()
        }

        splashViewModel.getUser()
    }
}