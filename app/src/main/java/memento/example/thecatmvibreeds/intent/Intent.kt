package memento.example.thecatmvibreeds.intent

sealed class Intent {
    object GetCatEvent: Intent()
    object None: Intent()
}