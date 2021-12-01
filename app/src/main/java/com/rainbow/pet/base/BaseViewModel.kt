package com.rainbow.pet.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

open class BaseViewModel : ViewModel() {

    val exception: MutableLiveData<Throwable> = MutableLiveData()

    fun launchOnUI(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(Dispatchers.Main) { block() }

    fun <T> launchOnIO(block: suspend CoroutineScope.() -> T) =
        viewModelScope.launch(Dispatchers.IO) { block() }

    fun launchDefault(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(Dispatchers.Default) { block() }

    fun launchOnIOTryCatch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        handleCancellationExceptionManually: Boolean = false
    ) = launchOnIO {
        tryCatch(tryBlock, {}, {}, handleCancellationExceptionManually)
    }

    private suspend fun tryCatch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        catchBlock: suspend CoroutineScope.(Throwable) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit,
        handleCancellationExceptionManually: Boolean = false
    ) {

        coroutineScope {
            try {
                tryBlock()
            } catch (e: Throwable) {
                if (e !is CancellationException || handleCancellationExceptionManually) {
                    withContext(Dispatchers.Main) {

                    }
                    catchBlock(e)
                } else {
                    throw e
                }
            } finally {
                finallyBlock()
            }
        }

    }


}