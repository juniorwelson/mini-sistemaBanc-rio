package service

import model.NewUser

class UserService {

    fun isValid(user: NewUser): Boolean {
        return user.name.isNotBlank() && user.age >= 18
    }

}
