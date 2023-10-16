package br.upf.sistemaeventos.dtos

import br.upf.sistemaeventos.model.Carta
import br.upf.sistemaeventos.model.Deck

data class CartaResponseDTO (
        val id: Long? = null,
        val nome: String,
        val cor: String,
        val mana: Int,
        val artista: String,
        val raridade: String,
        val tipo: String,
        val deck: List<Deck>
)