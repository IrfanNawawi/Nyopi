package com.cendrawasih.nyopi.features.repository.product

import com.cendrawasih.nyopi.data.Mapper
import com.cendrawasih.nyopi.data.WebServices
import com.cendrawasih.nyopi.data.entity.Banner
import com.cendrawasih.nyopi.data.entity.Category
import com.cendrawasih.nyopi.data.entity.Product
import com.cendrawasih.nyopi.data.entity.Seller
import com.cendrawasih.nyopi.data.request.ProductRequest
import com.cendrawasih.nyopi.data.request.SellerRequest
import com.cendrawasih.nyopi.util.mapObservable
import io.reactivex.Observable

class ProductDataSource(private val webServices: WebServices) {
    fun get_category(): Observable<List<Category>> {
        return webServices.get_category().mapObservable { categoryResponse ->
            categoryResponse.map { Mapper.mapCategoryToEntity(it) }
        }
    }

//    fun get_product(): Observable<Product> {
//        return webServices.get_product().mapObservable { productResponse ->
//            Mapper.mapProductToEntity(productResponse)
//        }
//    }

    fun get_single_product(request: ProductRequest): Observable<Product> {
        return webServices.get_single_product(request).mapObservable { singleProductResponse ->
            Mapper.mapProductToEntity(singleProductResponse)
        }
    }

    fun get_banner(): Observable<List<Banner>> {
        return webServices.get_banner().mapObservable { bannerResponse ->
            bannerResponse.map { Mapper.mapBannerToEntity(it) }
        }
    }

    fun get_seller_profile(sellerRequest: SellerRequest): Observable<Seller> {
        return webServices.get_seller_profile(sellerRequest).mapObservable { sellerResponse ->
            Mapper.mapSellerToEntity(sellerResponse)
        }
    }
}