package com.enestigli.diyetkolikcase.viewmodel

import android.bluetooth.BluetoothAdapter.ERROR
import android.bluetooth.BluetoothDevice.ERROR
import android.provider.VoicemailContract
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.viewmodel.compose.viewModel
import com.enestigli.diyetkolikcase.data.repo.FakeExchangeRepository
import com.enestigli.diyetkolikcase.domain.InsertExchangeUseCaseTest
import com.enestigli.diyetkolikcase.domain.usecase.getconversionratebycurrency.GetConversionRateByCurrencyUseCase
import com.enestigli.diyetkolikcase.presentation.exchangemainscreen.ExchangeMainViewModel
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class ExchangeViewModelTest {


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel : ExchangeMainViewModel
    private lateinit var fakeRepository: FakeExchangeRepository

    @Before
    fun setup() {
        fakeRepository = FakeExchangeRepository()
        viewModel = ExchangeMainViewModel(GetConversionRateByCurrencyUseCase(fakeRepository))
    }

    @Test
    fun `is click dropdown menu item 1`() {


        viewModel.dropDownMenuItem1 = "item1"

        val result = viewModel.dropDownMenuItem1
        assertThat(result).contains("item1")

    }

    @Test
    fun `is click dropdown menu item 2`() {

        viewModel.dropDownMenuItem2 = "item2"

        val result = viewModel.dropDownMenuItem2
        assertThat(result).contains("item2")

    }


    @Test
    fun `is empty value first conversion rate at the first time`() {

        val result = viewModel.firstConversionRate
        assertThat(result).isEqualTo(0.0)

    }

    @Test
    fun `is empty second conversion rate`() {

        val result = viewModel.secondConversionRate
        assertThat(result).isEqualTo(0.0)

    }



}