package com.ensegov.neofut.common.presentation.model

import android.util.Log

sealed interface UiState<out T> {
    data class Success<T>(val data: T): UiState<T>
    data object Loading : UiState<Nothing>
    data object Error : UiState<Nothing>
}

suspend fun <T> UiState<List<T>>.updateFromNetwork(
    canUpdate: suspend () -> Boolean,
    request: suspend () -> List<T>,
    tag: String
): UiState<List<T>> =
    if (canUpdate() && this is UiState.Loading)
        try {
            UiState.Success(request())
        } catch (e: Exception) {
            Log.d(tag, "${e.message}")
            UiState.Error
        }
    else if (this is UiState.Loading)
        UiState.Success(emptyList())
    else
        this