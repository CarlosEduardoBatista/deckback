package br.upf.magicdeck.service

import br.upf.magicdeck.converters.DeckConverter
import br.upf.magicdeck.dtos.DeckDTO
import br.upf.magicdeck.dtos.DeckResponseDTO
import br.upf.magicdeck.exceptions.NotFoundException
import br.upf.magicdeck.repository.DeckRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val EVENTO_NOT_FOUND_MESSAGE = "Evento não encontrado!"

@Service
class DeckService(
    private val repository: DeckRepository,
    private val converter: DeckConverter
) {

    fun listar(
        nomeDeck: String?,
        paginacao: Pageable): Page<DeckResponseDTO> {
        val deck = if (nomeDeck == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeDeck, paginacao)
        }
        return deck
            .map(converter::toDeckResponseDTO)
    }

    fun buscarPorId(id: Long): DeckResponseDTO {
        val deck = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
        return converter.toDeckResponseDTO(deck)
    }

    fun cadastrar(dto: DeckDTO): DeckResponseDTO {
        return converter.toDeckResponseDTO(
            repository.save(converter.toDeck(dto))
        )
    }

    fun atualizar(id: Long, dto: DeckDTO): DeckResponseDTO {
        val deck = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
            )
        return converter.toDeckResponseDTO(repository.save(deck))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}