package com.cendrawasih.nyopi.data

import com.cendrawasih.nyopi.data.entity.Category
import com.cendrawasih.nyopi.data.entity.LoginRegister
import com.cendrawasih.nyopi.data.entity.User
import com.cendrawasih.nyopi.data.response.CategoryResponse
import com.cendrawasih.nyopi.data.response.LoginRegisterResponse
import com.cendrawasih.nyopi.data.response.UserResponse

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
}