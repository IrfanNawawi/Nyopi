package com.cendrawasih.nyopi.data

import com.cendrawasih.nyopi.data.entity.*
import com.cendrawasih.nyopi.data.response.*
import com.cendrawasih.nyopi.util.orFalse
import com.cendrawasih.nyopi.util.orNol

object Mapper {

    fun mapUserResponseToEntity(userResponse: UserResponse?): User {
        return User(
            role = userResponse?.city.orEmpty(),
            fullName = userResponse?.fullName.orEmpty(),
            simpleAddress = userResponse?.simpleAddress.orEmpty(),
            city = userResponse?.city.orEmpty(),
            imageUrl = userResponse?.imageUrl.orEmpty(),
            id = userResponse?.id.orEmpty(),
            username = userResponse?.username.orEmpty(),

//            contoh mapper selain variable String
//            number = userResponse?.number.orNol(),
//            list = userResponse?.list.orEmpty().map { it.orNol() }
        )
    }

    fun mapLoginRegisterToEntity(loginRegisterResponse: LoginRegisterResponse?): LoginRegister {
        return LoginRegister(
            token = loginRegisterResponse?.token.orEmpty()
        )
    }

    fun mapCategoryToEntity(categoryResponse: CategoryResponse?): Category {
        return Category(
            imageCover = categoryResponse?.imageCover.orEmpty(),
            imageIcon = categoryResponse?.imageIcon.orEmpty(),
            name = categoryResponse?.name.orEmpty(),
            id = categoryResponse?.id.orEmpty(),
        )
    }

    fun mapProductToEntity(productResponse: ProductResponse?): Product {
        return Product(
            seller = mapSellerToEntity(SellerResponse()),
            price = productResponse?.price.orNol(),
            popularity = productResponse?.popularity.orNol(),
            name = productResponse?.name.orEmpty(),
            description = productResponse?.description.orEmpty(),
            id = productResponse?.id.orEmpty(),
            stock = productResponse?.stock.orNol(),
            category = mapCategoryToEntity(CategoryResponse()),
            soldCount = productResponse?.soldCount.orNol()
        )
    }

    fun mapSellerToEntity(sellerResponse: SellerResponse?): Seller {
        return Seller(
            role = sellerResponse?.role.orEmpty(),
            fullName = sellerResponse?.fullName.orEmpty(),
            simpleAddress = sellerResponse?.simpleAddress.orEmpty(),
            city = sellerResponse?.city.orEmpty(),
            imageUrl = sellerResponse?.imageUrl.orEmpty(),
            id = sellerResponse?.id.orEmpty(),
            username = sellerResponse?.username.orEmpty(),
        )
    }

    fun mapBannerToEntity(bannerResponse: BannerResponse?): Banner {
        return Banner(
            imageUrl = bannerResponse?.imageUrl.orEmpty(),
            productId = bannerResponse?.productId.orEmpty(),
            name = bannerResponse?.name.orEmpty(),
            caption = bannerResponse?.caption.orEmpty(),
            id = bannerResponse?.id.orEmpty(),
            headline = bannerResponse?.headline.orEmpty(),
            sellerId = bannerResponse?.sellerId.orEmpty(),
        )
    }

    fun mapPaymentToEntity(paymentResponse: PaymentResponse?): Payment {
        return Payment(
            statusPayment = paymentResponse?.statusPayment.orEmpty(),
            method = paymentResponse?.method.orEmpty()
        )
    }

    fun mapPayMethodToEntity(payMethodResponse: PayMethodResponse?): PayMethod {
        return PayMethod(
            paymentType = payMethodResponse?.paymentType.orEmpty(),
            code = payMethodResponse?.code.orEmpty(),
            isActivated = payMethodResponse?.isActivated.orFalse(),
            name = payMethodResponse?.name.orEmpty(),
        )
    }

}