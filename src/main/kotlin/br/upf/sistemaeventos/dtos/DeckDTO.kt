package br.upf.sistemaeventos.dtos

import br.upf.sistemaeventos.model.Carta
import br.upf.sistemaeventos.model.Formato
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class DeckDTO(
    @field:NotBlank(message = "Seu deck deve possuir um nome!")
    val nome: String,
    @field:NotNull(message = "Seu deck deve possuir pelo menos uma carta!")
    val carta: List<Carta> = listOf(),
    @field:NotBlank(message = "Selecione um formato para seu Deck!")
    val formato: Formato
)