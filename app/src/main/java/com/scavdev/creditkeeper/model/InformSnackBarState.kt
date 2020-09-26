package com.scavdev.creditkeeper.model

sealed class InformSnackBarState {
    object NothingToShow: InformSnackBarState()
    data class ItemRemoved(val creditName: String) : InformSnackBarState()
}