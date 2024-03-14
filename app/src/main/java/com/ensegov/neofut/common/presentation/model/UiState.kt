package com.ensegov.neofut.common.presentation.model

import android.util.Log

sealed interface UiState<out T> {
    data class Success<T>(val data: T): UiState<T>
    data object Loading : UiState<Nothing>
    data object Error : UiState<Nothing>
}

suspend fun <T> UiState<List<T>>.updateFromNetwork(
    canUpdate: suspend () -> Boolean,
    update: (UiState<List<T>>) -> Unit,
    changeIsUpdatingValue: (Boolean) -> Unit,
    request: suspend () -> List<T>,
    tag: String
) {
    if (canUpdate()) {
        changeIsUpdatingValue(true)
        update(
            try {
                UiState.Success(request())
            } catch (e: Exception) {
                Log.d(tag, "${e.message}")
                if (this is UiState.Loading)
                    UiState.Error
                else
                    this
            }
        )
        changeIsUpdatingValue(false)
    } else if (this is UiState.Loading)
        update(UiState.Success(emptyList()))
    else
        update(this)
}