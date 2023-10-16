package br.upf.magicdeck.dtos

import br.upf.magicdeck.model.Carta
import br.upf.magicdeck.model.Formato

data class DeckResponseDTO (
    val id: Long?,
    val nome: String,
    val formato: Formato,
    val carta: List<Carta>
)
