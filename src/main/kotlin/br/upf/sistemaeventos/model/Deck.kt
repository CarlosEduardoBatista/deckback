package br.upf.sistemaeventos.model

data class Deck(
    val id: Long? = null,
    val nome: String,
    val cartas: List<Carta> = listOf()
)
