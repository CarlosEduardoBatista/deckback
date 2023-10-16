package br.upf.sistemaeventos.dtos

data class CartaDTO (
    val nome: String,
    val cor: String,
    val mana: Int,
    val artista: String,
    val raridade: String,
    val tipo: String
)