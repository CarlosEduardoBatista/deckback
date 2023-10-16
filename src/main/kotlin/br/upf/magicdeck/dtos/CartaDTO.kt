package br.upf.magicdeck.dtos

import br.upf.magicdeck.model.Deck

data class CartaDTO (
    val nome: String,
    val cor: String,
    val mana: Int,
    val artista: String,
    val raridade: String,
    val tipo: String,
    val deck: List<Deck> = listOf(),
)