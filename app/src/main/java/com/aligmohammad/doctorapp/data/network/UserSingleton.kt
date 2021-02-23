package com.aligmohammad.doctorapp.data.network

import com.aligmohammad.doctorapp.data.network.response.User

object UserSingleton {

    private lateinit var _user: User

    init {
        _user = User(null,null,null,null,null,null,null,null,null,null,null,null, null, null, null)
    }

    fun setUser(user: User) {
        _user = user
    }

    fun getCurrentUser(): User {
        return _user
    }

}