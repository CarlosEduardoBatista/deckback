package br.upf.sistemaeventos.dtos

import br.upf.sistemaeventos.model.Deck

data class CartaDTO (
    val nome: String,
    val cor: String,
    val mana: Int,
    val artista: String,
    val raridade: String,
    val tipo: String,
    val deck: List<Deck> = listOf(),
)