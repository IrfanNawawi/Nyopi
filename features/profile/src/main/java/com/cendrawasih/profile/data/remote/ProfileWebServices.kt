package com.cendrawasih.profile.data.remote

import com.cendrawasih.core.remote.NyopiResponse
import com.cendrawasih.profile.data.remote.request.*
import com.cendrawasih.profile.data.remote.response.*
import retrofit2.http.*

interface ProfileWebServices {

    // User
    @POST(EndPoint.User.LOGIN)
    fun post_login(
        @Body loginRequest: LoginRegisterRequest
    ): NyopiResponse<LoginRegisterResponse>

    @POST(EndPoint.User.REGISTER)
    fun post_register(
        @Body registerRequest: LoginRegisterRequest
    ): NyopiResponse<LoginRegisterResponse>

    @GET(EndPoint.User.GET_USER)
    fun getUser(
        @Header("Authorization") auth: String = TOKEN_SAMPLE
    ): NyopiResponse<UserResponse>

    @PUT(EndPoint.User.UPDATE_IMAGE_PROFILE)
    fun put_update_image_profile(
        @Field("image") image: String
    ): NyopiResponse<UserResponse>

    @PUT(EndPoint.User.UPDATE_USER_DETAIL)
    fun put_update_user_detail(
        @FieldMap updateUserDetail: Map<String, String>
    ): NyopiResponse<UserResponse>

    // Product
    @GET(EndPoint.Product.GET_CATEGORY)
    fun get_category(): NyopiResponse<List<CategoryResponse>>

    @GET(EndPoint.Product.GET_PRODUCT)
    fun get_product(): NyopiResponse<PageResponse<ProductResponse>>

    @GET(EndPoint.Product.GET_SINGLE_PRODUCT)
    fun get_single_product(
        @QueryMap productRequest: ProductRequest
    ): NyopiResponse<ProductResponse>

    @GET(EndPoint.Product.GET_BANNERS)
    fun get_banner(): NyopiResponse<List<BannerResponse>>

    @GET(EndPoint.Product.GET_SELLER_PROFILE)
    fun get_seller_profile(
        @Path("seller_id") sellerRequest: SellerRequest
    ): NyopiResponse<SellerResponse>

    // Transaction
    @GET(EndPoint.Transaction.GET_CURRENT_TRANSACTION)
    fun get_current_transaction(@Header("Authorization") auth: String = TOKEN_SAMPLE): NyopiResponse<PageResponse<TransactionResponse>>

    @POST(EndPoint.Transaction.CREATE_TRANSACTION)
    fun post_create_transaction(
        @QueryMap transactionRequest: TransactionRequest,
        @Header("Authorization") auth: String = TOKEN_SAMPLE
    ): NyopiResponse<PageResponse<TransactionResponse>>

    // Payment
    @GET(EndPoint.Payment.GET_CURRENT_PAYMENT)
    fun get_current_payment(
        @QueryMap paymentRequest: PaymentRequest,
        @Header("Authorization") auth: String = TOKEN_SAMPLE
    ): NyopiResponse<PaymentResponse>

    @GET(EndPoint.Payment.GET_ALL_PAYMENT)
    fun get_all_payment(@Header("Authorization") auth: String = TOKEN_SAMPLE): NyopiResponse<PaymentResponse>

    @GET(EndPoint.Payment.CREATE_PAYMENT)
    fun get_create_payment(
        @QueryMap paymentRequest: PaymentRequest,
        @Header("Authorization") auth: String = TOKEN_SAMPLE
    ): NyopiResponse<PaymentResponse>

    @GET(EndPoint.Payment.GET_ALL_PAYMENT_METHOD)
    fun get_all_payment_method(@Header("Authorization") auth: String = TOKEN_SAMPLE): NyopiResponse<PayMethodResponse>

    // Cart
    @POST(EndPoint.Cart.ADD_PRODUCT_TO_CART)
    fun post_add_product_to_cart(@Header("Authorization") auth: String = TOKEN_SAMPLE): NyopiResponse<CartResponse>

    @GET(EndPoint.Cart.GET_CART)
    fun get_cart(@Header("Authorization") auth: String = TOKEN_SAMPLE): NyopiResponse<CartResponse>

    @DELETE(EndPoint.Cart.DELETE_PRODUCT_TO_CART)
    fun delete_product_to_cart(): NyopiResponse<CartResponse>

    // Simulation
    @POST(EndPoint.Simulation.PAID_SIMULATION_VIRTUAL_ACCOUNT)
    fun post_paid_simulation_to_cart(@Body simulationRequest: SimulationRequest): NyopiResponse<ProductResponse>

    @POST(EndPoint.Simulation.PAID_SIMULATION_MERCHANT)
    fun post_paid_simulation_merchant(@Body simulationRequest: SimulationRequest): NyopiResponse<ProductResponse>

    @POST(EndPoint.Simulation.FCM_TEST)
    fun post_fcm_test(): NyopiResponse<ProductResponse>

    companion object {
        const val TOKEN_SAMPLE =
            "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJawfawfzdWIiOiJBdXRoZW50aWNhdGlvbiIsImlzcyI6ImNvbS5hZWouYXVyZWwiLCJpZCI6IjU5YjNkMGYzLTE4YWMtNGZhNS1hYTM0LTBlZGFlMmMwYTJiMSIsImV4cCI6MTY0OTk0MjcwMSwiaGFzaCI6InJKUExyT0ZOWHdtdE1XcUtWV1R6UUE9PSJ9.loIOTecAMDSQJ-E2B8BNF62LULStB2yvp1mm7T_QWov-HIpXCyxSiogF4gd49vXoqcDV65XiU8c1lVukyGtNuA"
    }

    object EndPoint {
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
                "customer/product"
            const val GET_BANNERS = "customer/product/banner"
            const val GET_SELLER_PROFILE = "customer/seller/{seller_id}"
        }

        object Transaction {
            const val GET_CURRENT_TRANSACTION = "customer/transaction"
            const val CREATE_TRANSACTION = "customer/transaction?payment=BCA-VA"
        }

        object Payment {
            const val GET_CURRENT_PAYMENT =
                "customer/payment"
            const val GET_ALL_PAYMENT = "customer/payment/all"
            const val CREATE_PAYMENT =
                "customer/payment"
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