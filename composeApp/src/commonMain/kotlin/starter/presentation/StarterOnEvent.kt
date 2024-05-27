package starter.presentation

sealed interface StarterOnEvent {
    data object STARTED : StarterOnEvent
}
