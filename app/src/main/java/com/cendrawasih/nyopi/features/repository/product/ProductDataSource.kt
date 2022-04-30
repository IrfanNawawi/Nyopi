package com.cendrawasih.nyopi.features.repository.product

import com.cendrawasih.core.util.mapObservable
import com.cendrawasih.profile.data.ProfileMapper
import com.cendrawasih.profile.data.entity.Banner
import com.cendrawasih.profile.data.entity.Category
import com.cendrawasih.profile.data.entity.Product
import com.cendrawasih.profile.data.entity.Seller
import com.cendrawasih.profile.data.remote.ProfileWebServices
import com.cendrawasih.profile.data.remote.request.ProductRequest
import com.cendrawasih.profile.data.remote.request.SellerRequest
import io.reactivex.Observable

class ProductDataSource(private val profileWebServices: ProfileWebServices) {
    fun get_category(): Observable<List<Category>> {
        return profileWebServices.get_category().mapObservable { categoryResponse ->
            categoryResponse.map { ProfileMapper.mapCategoryToEntity(it) }
        }
    }

//    fun get_product(): Observable<Product> {
//        return webServices.get_product().mapObservable { productResponse ->
//            Mapper.mapProductToEntity(productResponse)
//        }
//    }

    fun get_single_product(request: ProductRequest): Observable<Product> {
        return profileWebServices.get_single_product(request).mapObservable { singleProductResponse ->
            ProfileMapper.mapProductToEntity(singleProductResponse)
        }
    }

    fun get_banner(): Observable<List<Banner>> {
        return profileWebServices.get_banner().mapObservable { bannerResponse ->
            bannerResponse.map { ProfileMapper.mapBannerToEntity(it) }
        }
    }

    fun get_seller_profile(sellerRequest: SellerRequest): Observable<Seller> {
        return profileWebServices.get_seller_profile(sellerRequest).mapObservable { sellerResponse ->
            ProfileMapper.mapSellerToEntity(sellerResponse)
        }
    }
}