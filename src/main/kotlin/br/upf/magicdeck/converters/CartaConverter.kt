package br.upf.magicdeck.converters

import br.upf.magicdeck.dtos.CartaResponseDTO
import br.upf.magicdeck.model.Carta
import br.upf.magicdeck.dtos.CartaDTO
import org.springframework.stereotype.Component

@Component
class CartaConverter {
    fun toCarta(dto: CartaDTO): Carta {
        return Carta(
            nome = dto.nome,
            cor = dto.cor,
            mana = dto.mana,
            artista = dto.artista,
            raridade = dto.raridade,
            tipo = dto.tipo,
            deck = listOf()
        )
    }

    fun toCartaResponseDTO(carta: Carta): CartaResponseDTO {
        return CartaResponseDTO(
            id = carta.id,
            nome = carta.nome,
            cor = carta.cor,
            mana = carta.mana,
            artista = carta.artista,
            raridade = carta.raridade,
            tipo = carta.tipo,
            deck = carta.deck
        )
    }
}