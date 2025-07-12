package com.zdk.podelim.data.remote.dto

import kotlinx.serialization.Serializable

// Generic response for API calls that return a simple message
@Serializable
data class MessageResponse(
    val message: String,
)