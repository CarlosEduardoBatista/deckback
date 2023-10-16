package br.upf.sistemaeventos.converters

import br.upf.sistemaeventos.dtos.DeckResponseDTO
import br.upf.sistemaeventos.model.Deck
import br.upf.sistemaeventos.dtos.DeckDTO
import org.springframework.stereotype.Component

@Component
class DeckConverter {
    fun toDeck(dto: DeckDTO): Deck {
        return Deck(
            nome = dto.nome,
            carta = listOf(),
            formato = dto.formato
        )
    }

    fun toDeckResponseDTO(deck: Deck): DeckResponseDTO {
        return DeckResponseDTO(
            id = deck.id,
            nome = deck.nome,
            carta = deck.carta,
            formato = deck.formato
        )
    }
}