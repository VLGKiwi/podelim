package com.zdk.podelim.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Generic response for API calls that return a simple message
@Serializable
data class MessageResponse(
    @SerialName("message")
    val message: String,
)