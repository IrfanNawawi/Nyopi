package com.cendrawasih.nyopi.features.repository.product

import com.cendrawasih.nyopi.data.entity.Banner
import com.cendrawasih.nyopi.data.entity.Category
import com.cendrawasih.nyopi.data.entity.Product
import com.cendrawasih.nyopi.data.entity.Seller
import com.cendrawasih.nyopi.data.event.MutableStateEventManager
import com.cendrawasih.nyopi.data.event.StateEventManager
import com.cendrawasih.nyopi.data.request.SellerRequest
import com.cendrawasih.nyopi.util.fetchStateEventSubscriber
import io.reactivex.disposables.CompositeDisposable
import okhttp3.internal.closeQuietly

class ProductRepositoryImpl(private val dataSource: ProductDataSource) : ProductRepository {

    private val disposables = CompositeDisposable()

    private var _categoryStateEventManager: MutableStateEventManager<Category> =
        MutableStateEventManager()
    override val categoryStateEventManager: StateEventManager<Category>
        get() = _categoryStateEventManager

    private var _productStateEventManager: MutableStateEventManager<Product> =
        MutableStateEventManager()
    override val productStateEventManager: StateEventManager<Product>
        get() = _productStateEventManager

    private var _bannerStateEventManager: MutableStateEventManager<Banner> =
        MutableStateEventManager()
    override val bannerStateEventManager: StateEventManager<Banner>
        get() = _bannerStateEventManager

    private var _sellerStateEventManager: MutableStateEventManager<Seller> =
        MutableStateEventManager()
    override val sellerStateEventManager: StateEventManager<Seller>
        get() = _sellerStateEventManager

    override fun get_category() {

    }

    override fun get_product() {
    }

    override fun get_single_product() {

    }

    override fun get_banner() {

    }

    override fun get_seller_profile(sellerRequest: SellerRequest) {
        val disposable =
            dataSource.get_seller_profile(sellerRequest).fetchStateEventSubscriber { stateEvent ->
                _sellerStateEventManager.post(stateEvent)
            }

        disposables.add(disposable)
    }

    override fun close() {
        _categoryStateEventManager.closeQuietly()
        _productStateEventManager.closeQuietly()
        _bannerStateEventManager.closeQuietly()
        _sellerStateEventManager.closeQuietly()
        disposables.dispose()
    }
}