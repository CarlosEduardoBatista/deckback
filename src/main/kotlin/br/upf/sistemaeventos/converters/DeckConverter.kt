package br.upf.sistemadecks.converters

import br.upf.sistemaeventos.dtos.DeckResponseDTO
import br.upf.sistemaeventos.model.Deck
import br.upf.sistemaeventos.dtos.DeckDTO
import org.springframework.stereotype.Component

@Component
class DeckConverter {
    fun toDeck(dto: DeckDTO): Deck {
        return Deck(
            nome = dto.nome,
            cartas = listOf()
        )
    }

    fun toDeckResponseDTO(deck: Deck): DeckResponseDTO {
        return DeckResponseDTO(
            id = deck.id,
            nome = deck.nome,
            carta = deck.cartas
        )
    }
}