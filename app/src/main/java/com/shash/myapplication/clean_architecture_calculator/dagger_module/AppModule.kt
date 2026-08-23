package com.shash.myapplication.clean_architecture_calculator.dagger_module

import com.shash.myapplication.clean_architecture_calculator.data.repository.CalculatorRepositoryImpl
import com.shash.myapplication.clean_architecture_calculator.domain.repository.CalculatorRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun bindCalculatorRepository(impl: CalculatorRepositoryImpl): CalculatorRepository
}

