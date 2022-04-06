package com.cendrawasih.nyopi.data

import com.cendrawasih.nyopi.data.response.*
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface WebServices {

    // User
    @POST(EndPoint.User.LOGIN)
    fun login(@FieldMap userLogin: Map<String, String>): NyopiResponse<LoginRegisResponse>

    @POST(EndPoint.User.REGISTER)
    fun register(@FieldMap userRegister: Map<String, String>): NyopiResponse<LoginRegisResponse>

    @GET(EndPoint.User.GET_USER)
    fun getUser(@Header("Authorization") auth: String = TOKEN_SAMPLE): NyopiResponse<UserResponse>

    @PUT(EndPoint.User.UPDATE_IMAGE_PROFILE)
    fun update_image_profile(@Field("image") image: String): NyopiResponse<UserResponse>

    @PUT(EndPoint.User.UPDATE_USER_DETAIL)
    fun update_user_detail(@FieldMap updateUserDetail: Map<String, String>): NyopiResponse<UserResponse>

    // Product
    @GET(EndPoint.Product.GET_CATEGORY)
    fun get_category(): NyopiResponse<CategoryResponse>

    @GET(EndPoint.Product.GET_PRODUCT)
    fun get_product(): NyopiResponse<PageResponse<ProductResponse>>

    @GET(EndPoint.Product.GET_SINGLE_PRODUCT)
    fun getSingleProduct(): NyopiResponse<ProductResponse>

    @GET(EndPoint.Product.GET_BANNERS)
    fun get_banners(): NyopiResponse<BannerResponse>

    @GET(EndPoint.Product.GET_SELLER_PROFILE)
    fun get_seller_profile(): NyopiResponse<SellerResponse>

    // Transaction
    @GET(EndPoint.Transaction.GET_CURRENT_TRANSACTION)
    fun get_current_transaction(@Header("Authorization") auth: String = TOKEN_SAMPLE): NyopiResponse<PageResponse<TransactionResponse>>

    @POST(EndPoint.Transaction.CREATE_TRANSACTION)
    fun create_transaction(@Header("Authorization") auth: String = TOKEN_SAMPLE): NyopiResponse<PageResponse<TransactionResponse>>

    // Payment
    @GET(EndPoint.Payment.GET_CURRENT_PAYMENT)
    fun get_current_payment(@Header("Authorization") auth: String = TOKEN_SAMPLE): NyopiResponse<PaymentResponse>

    @GET(EndPoint.Payment.GET_ALL_PAYMENT)
    fun get_all_payment(@Header("Authorization") auth: String = TOKEN_SAMPLE): NyopiResponse<PaymentResponse>

    @GET(EndPoint.Payment.CREATE_PAYMENT)
    fun create_payment(@Header("Authorization") auth: String = TOKEN_SAMPLE): NyopiResponse<PaymentResponse>

    @GET(EndPoint.Payment.GET_ALL_PAYMENT_METHOD)
    fun get_all_payment_method(@Header("Authorization") auth: String = TOKEN_SAMPLE): NyopiResponse<PayMethodResponse>

    // Cart
    @POST(EndPoint.Cart.ADD_PRODUCT_TO_CART)
    fun add_product_to_cart(@Header("Authorization") auth: String = TOKEN_SAMPLE): NyopiResponse<CartResponse>

    @GET(EndPoint.Cart.GET_CART)
    fun get_cart(@Header("Authorization") auth: String = TOKEN_SAMPLE): NyopiResponse<CartResponse>

    @DELETE(EndPoint.Cart.DELETE_PRODUCT_TO_CART)
    fun delete_product_to_cart(): NyopiResponse<CartResponse>

    // Simulation
    @POST(EndPoint.Simulation.PAID_SIMULATION_VIRTUAL_ACCOUNT)
    fun paid_simulation_to_cart(): NyopiResponse<ProductResponse>

    @POST(EndPoint.Simulation.PAID_SIMULATION_MERCHANT)
    fun paid_simulation_merchant(): NyopiResponse<ProductResponse>

    @POST(EndPoint.Simulation.FCM_TEST)
    fun fcm_test(): NyopiResponse<ProductResponse>

    companion object {
        const val TOKEN_SAMPLE =
            "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBdXRoZW50aWNhdGlvbiIsImlzcyI6ImNvbS5hZWouYXVyZWwiLCJpZCI6ImQyZTQ2MjdjLTU5MjgtNDJhZi05YTQzLTk5YjRkMzYyNTBlYiIsImV4cCI6MTY0OTczMjQyNSwiaGFzaCI6InJKUExyT0ZOWHdtdE1XcUtWV1R6UUE9PSJ9.0uT4RYT9r1px3faXcUCl52eMg5Jf5nyJkimg5tRsNX8aHFVVXk_KwVugwtmoW24WiDQJxgPPYTp8-_oa9ha7gg"

        private val gson = GsonBuilder()
            .setPrettyPrinting()
            .setLenient()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

        private val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()

        fun create(): WebServices {
            return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(EndPoint.BASE_URL)
                .client(okHttpClient)
                .build()
                .create(WebServices::class.java)
        }
    }

    object EndPoint {
        const val BASE_URL = "https://aurel-store.herokuapp.com/v1/"
        const val BASE_URL_ROOT = "https://aurel-store.herokuapp.com/"

        object User {
            const val GET_USER = "user"
            const val LOGIN = "user/login"
            const val REGISTER = "user/customer/register"
            const val UPDATE_IMAGE_PROFILE = "user/image"
            const val UPDATE_USER_DETAIL = "user"
        }

        object Product {
            const val GET_CATEGORY = "category"
            const val GET_PRODUCT = "customer/product"
            const val GET_SINGLE_PRODUCT =
                "customer/product?product_id=c6dbac34-14f2-46e7-8c8d-f98265fa6ee3"
            const val GET_BANNERS = "customer/product/banner"
            const val GET_SELLER_PROFILE = "customer/seller/:seller_id"
        }

        object Transaction {
            const val GET_CURRENT_TRANSACTION = "customer/transaction"
            const val CREATE_TRANSACTION = "customer/transaction?payment=BCA-VA"
        }

        object Payment {
            const val GET_CURRENT_PAYMENT =
                "customer/payment?transaction_id=b65cc32d-bf7b-46ab-b471-9146f37ebe17"
            const val GET_ALL_PAYMENT = "customer/payment/all"
            const val CREATE_PAYMENT =
                "customer/payment?transaction_id=843dcfc9-1c14-49ce-a496-1d8fae750286"
            const val GET_ALL_PAYMENT_METHOD = "customer/payment/method"
        }

        object Cart {
            const val ADD_PRODUCT_TO_CART = "customer/cart"
            const val GET_CART = "customer/cart"
            const val DELETE_PRODUCT_TO_CART = "customer/cart"
        }

        object Simulation {
            const val PAID_SIMULATION_VIRTUAL_ACCOUNT = "payment/simulation/va"
            const val PAID_SIMULATION_MERCHANT = "payment/simulation/merchant"
            const val FCM_TEST = "https://fcm.googleapis.com/fcm/send"
        }
    }
}