package com.irzstudio.SeninSepetin.di

import com.irzstudio.SeninSepetin.data.DummyDataSource
import com.irzstudio.SeninSepetin.data.Repository
import com.irzstudio.SeninSepetin.model.DataBase
import org.koin.dsl.module

val dataModule = module {

    single { DataBase.getInstance() }
    factory { DummyDataSource() }
    single { Repository(get(), get()) }

}