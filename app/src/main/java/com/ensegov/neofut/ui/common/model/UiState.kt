package com.ensegov.neofut.ui.common.model

sealed interface UiState<out T> {
    data class Success<T>(val data: T): UiState<T>
    data object Loading : UiState<Nothing>
    data object Error : UiState<Nothing>
}