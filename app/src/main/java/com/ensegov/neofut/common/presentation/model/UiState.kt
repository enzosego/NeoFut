package com.ensegov.neofut.common.presentation.model

sealed interface UiState<out T> {
    data class Success<T>(val data: T): UiState<T>
    data object Loading : UiState<Nothing>
    data class Error(val message: String) : UiState<Nothing>
}

suspend fun <T> UiState<List<T>>.updateFromNetwork(
    canUpdate: suspend () -> Boolean,
    update: (UiState<List<T>>) -> Unit,
    request: suspend () -> List<T>,
    changeIsUpdatingValue: (Boolean) -> Unit = {},
) {
    if (canUpdate()) {
        changeIsUpdatingValue(true)
        update(
            try {
                UiState.Success(request())
                    .takeIf { it.data.isNotEmpty() }
                    ?: UiState.Error(message = "")
            } catch (e: Exception) {
                if (this is UiState.Loading)
                    UiState.Error(message = e.message ?: "")
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