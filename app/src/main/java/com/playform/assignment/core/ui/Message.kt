package com.playform.assignment.core.ui

sealed class Message {
    class ResId(val id: Int) : Message()
    class Value(val value: String) : Message()
}

