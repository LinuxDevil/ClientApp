package com.aligmohammad.doctorapp.data.network

import com.aligmohammad.doctorapp.data.model.User

object UserSingleton {

    private lateinit var _user: User

    init {
        _user = User(null,null,null,null,null,null,null,null,0,null,0,null, null,null,null,null,null,null,null)
    }

    fun setUser(user: User) {
        _user = user
    }

    fun getCurrentUser(): User {
        return _user
    }

}