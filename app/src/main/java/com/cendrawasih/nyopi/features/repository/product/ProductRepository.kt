package com.cendrawasih.nyopi.features.repository.product

import com.cendrawasih.nyopi.data.entity.Banner
import com.cendrawasih.nyopi.data.entity.Category
import com.cendrawasih.nyopi.data.entity.Product
import com.cendrawasih.nyopi.data.entity.Seller
import com.cendrawasih.nyopi.data.event.StateEventManager
import com.cendrawasih.nyopi.data.request.SellerRequest
import java.io.Closeable

interface ProductRepository : Closeable {
    val categoryStateEventManager: StateEventManager<Category>
    val productStateEventManager: StateEventManager<Product>
    val bannerStateEventManager: StateEventManager<Banner>
    val sellerStateEventManager: StateEventManager<Seller>

    fun get_category()
    fun get_product()
    fun get_single_product()
    fun get_banner()
    fun get_seller_profile(sellerRequest: SellerRequest)
}