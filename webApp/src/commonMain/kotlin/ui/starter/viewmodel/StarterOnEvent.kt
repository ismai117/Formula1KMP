package starter.viewmodel

sealed interface StarterOnEvent {
    data object STARTED : StarterOnEvent
}
