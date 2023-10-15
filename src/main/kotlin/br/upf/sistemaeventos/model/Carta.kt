package br.upf.sistemaeventos.model


data class Carta(
    val id: Long? = null,
    val nome: String,
    val cor: String,
    val mana: Int,
    val artista: String,
    val raridade: String,
    val tipo: String,
)
