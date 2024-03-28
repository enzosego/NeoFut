package com.ensegov.neofut.match_detail.presentation.events.model

sealed class EventType(detail: String) {
    class Goal(detail: String) : EventType(detail)
    class Card(detail: String) : EventType(detail)
    class Sub(detail: String) : EventType(detail)
    class Var(detail: String) : EventType(detail)

    override fun toString(): String = this::class.simpleName ?: ""
}