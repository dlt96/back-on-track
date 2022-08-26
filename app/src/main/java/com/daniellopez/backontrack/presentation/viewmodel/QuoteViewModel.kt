package com.daniellopez.backontrack.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniellopez.backontrack.data.model.QuoteModel
import com.daniellopez.backontrack.data.model.QuoteProvider
import com.daniellopez.backontrack.domain.GetQuotesUseCase
import com.daniellopez.backontrack.domain.GetRandomquoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomquoteUseCase()

    fun onCreate() {
        viewModelScope.launch {//with viewModelScope we don't have to delete coroutine on Destroy
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()) {
                isLoading.postValue(false)
                quoteModel.postValue(result[0])
            }
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if (quote != null) {
            quoteModel.postValue(quote!!)
        }
        isLoading.postValue(false)
    }
}