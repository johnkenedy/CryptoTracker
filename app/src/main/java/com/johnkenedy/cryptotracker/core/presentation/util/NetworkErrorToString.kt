package com.johnkenedy.cryptotracker.core.presentation.util

import android.content.Context
import com.johnkenedy.cryptotracker.R
import com.johnkenedy.cryptotracker.core.domain.util.NetworkError

fun NetworkError.toString(context: Context): String {
    val resId = when(this) {
        NetworkError.REQUEST_TIMEOUT -> R.string.error_request_timeout
        NetworkError.TOO_MANY_REQUESTS -> R.string.error_too_many_requests
        NetworkError.NO_INTERNET -> R.string.error_no_internet
        NetworkError.SERVER_ERROR -> R.string.error_unknow
        NetworkError.SERIALIZATION -> R.string.error_serialization
        NetworkError.UNKNOW -> R.string.error_unknow
    }
    return context.getString(resId)
}