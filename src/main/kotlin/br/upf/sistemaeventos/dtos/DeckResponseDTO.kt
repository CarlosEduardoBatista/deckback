package br.upf.sistemaeventos.dtos

import br.upf.sistemaeventos.model.Carta

data class DeckResponseDTO (
    val id: Long?,
    val nome: String,
    val carta: List<Carta>
)
