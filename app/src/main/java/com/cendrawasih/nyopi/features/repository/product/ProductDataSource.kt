package com.cendrawasih.nyopi.features.repository.product

import com.cendrawasih.nyopi.data.Mapper
import com.cendrawasih.nyopi.data.WebServices
import com.cendrawasih.nyopi.data.entity.Category
import com.cendrawasih.nyopi.util.mapObservable
import io.reactivex.Observable

class ProductDataSource(private val webServices: WebServices) {
//    fun get_category(): Observable<Category> {
//        return webServices.get_category().mapObservable { categoryResponse ->
//            Mapper.mapCategoryToEntity(categoryResponse)
//        }
//    }
}