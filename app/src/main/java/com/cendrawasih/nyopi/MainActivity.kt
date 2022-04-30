package com.cendrawasih.nyopi

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cendrawasih.nyopi.features.screen.homepage.HomePageViewModel
import io.reactivex.disposables.CompositeDisposable
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val tvLog: TextView by lazy { findViewById(R.id.txt_log) }
    private val disposables = CompositeDisposable()

    private val homePageViewModel: HomePageViewModel by viewModel<HomePageViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvLog.setOnClickListener {
////            login dan register
////            val params = HashMap<String, String>()
////            params["username"] = "irfan"
////            params["password"] = "123456"
//
////            single product
////            val params = HashMap<String?, String?>()
////            params["product_id"] = "26c18512-56c5-409b-b47b-67352284795f"
//
////            seller profile
////            val sellerId = "b331f42b-bb0a-4e7f-9e27-61857f3af19a"
//
//            val userDisposable = services.getUser()
//                /*
//                * Catatan:
//                * - Network harus berada di Thread belakang (io)
//                * - View harus berada di Thread UI (mainThread)
//                * - Operasi network dapat terjadi memory leaks itu dikarenakan
//                * stream data yang harus di consume dan tidak ditangkap oleh consumer*/
//                .subscribeOn(Schedulers.io()) // Thread background (io)
//                .observeOn(AndroidSchedulers.mainThread()) // Thread UI (mainThread)
//                .doOnSubscribe {
//                    println("Loading.....")
//                    tvLog.text = "Loading..."
//                }
//                .doOnError {
//                    // Ini bagian apabila retrofit error, contoh: timeout
//                    println("Error anjay -> ${it.localizedMessage}")
//                    it.printStackTrace()
//                }
//                .subscribe({
//                    val isSuccess = it.isSuccessful
//                    if (isSuccess) {
//                        val response = it.body()
//                        val data = response?.data
//                        println("Sukses nih")
//                        tvLog.text = data?.username
//                    } else {
//                        // ini bagian error dari response
//                        val errorMessage = it.errorBody()
//                        println("Error nih -> $errorMessage")
//                        tvLog.text = errorMessage?.string()
//                    }
//                    println("Response anjay -> ${it.body()}")
//                }, {
//                    // Ini bagian apabila retrofit error, tapi ada hubungan dengan rx nya
//                    println("Error di rx")
//                    it.printStackTrace()
//                })
//            disposables.add(userDisposable)

//            val dataUserDisposable = dataSource.getUser()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe{
//                    tvLog.text = "Loading..."
//                }
//                .subscribe({ user ->
//                    tvLog.text = user.username
//                }, { throwable ->
//                    tvLog.text = throwable.localizedMessage
//                })
//
//            disposables.add(dataUserDisposable)

            homePageViewModel.login("ucok", "123456")
        }

        val userManager = homePageViewModel.userManager
        userManager.onLoading = {
            tvLog.text = "Loading..."
        }

        userManager.onSuccess = { user ->
            tvLog.text = user.token
        }

        userManager.onFailure = { throwable ->
            tvLog.text = throwable.localizedMessage
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}