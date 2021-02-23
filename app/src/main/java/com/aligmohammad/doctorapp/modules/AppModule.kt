package com.aligmohammad.doctorapp.modules

import android.content.Context
import com.aligmohammad.doctorapp.data.network.RemoteDataSource
import com.aligmohammad.doctorapp.data.network.api.AuthApi
import com.aligmohammad.doctorapp.data.network.api.InsuranceCompanyApi
import com.aligmohammad.doctorapp.data.network.api.MenuApi
import com.aligmohammad.doctorapp.data.network.api.UserApi
import com.aligmohammad.doctorapp.data.network.repository.AuthRepository
import com.aligmohammad.doctorapp.data.network.repository.HomeRepository
import com.aligmohammad.doctorapp.data.network.repository.UserRepository
import com.aligmohammad.doctorapp.helpers.PreferencesStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideUserPreferences(@ApplicationContext context: Context): PreferencesStore {
        return PreferencesStore(context)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(
        userPreferences: PreferencesStore
    ): RemoteDataSource {
        return RemoteDataSource(userPreferences)
    }
    @Singleton
    @Provides
    fun provideAuthApi(
        remoteDataSource: RemoteDataSource,
        @ApplicationContext context: Context
    ): AuthApi {
        return remoteDataSource.buildApi(AuthApi::class.java, context)
    }

    @Singleton
    @Provides
    fun provideUserApi(
        remoteDataSource: RemoteDataSource,
        @ApplicationContext context: Context
    ): UserApi {
        return remoteDataSource.buildApi(UserApi::class.java, context)
    }

    @Provides
    fun provideAuthRepository(
        authApi: AuthApi,
        userPreferences: PreferencesStore
    ): AuthRepository {
        return AuthRepository(authApi, userPreferences)
    }

    @Singleton
    @Provides
    fun provideMenuApi(
        remoteDataSource: RemoteDataSource,
        @ApplicationContext context: Context
    ): MenuApi {
        return remoteDataSource.buildApi(MenuApi::class.java, context)
    }

    @Singleton
    @Provides
    fun provideInsuranceCompanyApi(
        remoteDataSource: RemoteDataSource,
        @ApplicationContext context: Context
    ): InsuranceCompanyApi {
        return remoteDataSource.buildApi(InsuranceCompanyApi::class.java, context)
    }


    @Provides
    fun provideHomeRepository(
        menuApi: MenuApi,
        insuranceApi: InsuranceCompanyApi,
        userApi: UserApi
    ): HomeRepository {
        return HomeRepository(menuApi, insuranceApi, userApi)
    }


    @Provides
    fun provideUserRepository(userApi: UserApi): UserRepository {
        return UserRepository(userApi)
    }
}