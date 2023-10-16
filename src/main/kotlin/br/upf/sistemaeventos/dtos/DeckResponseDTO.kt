package br.upf.sistemaeventos.dtos

import br.upf.sistemaeventos.model.Carta
import br.upf.sistemaeventos.model.Formato

data class DeckResponseDTO (
    val id: Long?,
    val nome: String,
    val formato: Formato,
    val carta: List<Carta>
)
