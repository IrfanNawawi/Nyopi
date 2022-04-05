package com.cendrawasih.nyopi

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cendrawasih.nyopi.data.WebServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val tvLog: TextView by lazy { findViewById(R.id.txt_log) }
    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val services = WebServices.create()
        tvLog.setOnClickListener {
            val userDisposable = services.getUser()
                /*
                * Catatan:
                * - Network harus berada di Thread belakang (io)
                * - View harus berada di Thread UI (mainThread)
                * - Operasi network dapat terjadi memory leaks itu dikarenakan
                * stream data yang harus di consume dan tidak ditangkap oleh consumer*/
                .subscribeOn(Schedulers.io()) // Thread background (io)
                .observeOn(AndroidSchedulers.mainThread()) // Thread UI (mainThread)
                .doOnSubscribe {
                    println("Loading.....")
                    tvLog.text = "Loading..."
                }
                .doOnError {
                    // Ini bagian apabila retrofit error, contoh: timeout
                    println("Error anjay -> ${it.localizedMessage}")
                    it.printStackTrace()
                }
                .subscribe({
                    val isSuccess = it.isSuccessful
                    if (isSuccess) {
                        val response = it.body()
                        val data = response?.data
                        println("Sukses nih")
                        tvLog.text = data?.fullName
                    } else {
                        // ini bagian error dari response
                        val errorMessage = it.errorBody()
                        println("Error nih -> $errorMessage")
                        tvLog.text = errorMessage?.string()
                    }
                    println("Response anjay -> ${it.body()}")
                }, {
                    // Ini bagian apabila retrofit error, tapi ada hubungan dengan rx nya
                    println("Error di rx")
                    it.printStackTrace()
                })
            disposables.add(userDisposable)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}