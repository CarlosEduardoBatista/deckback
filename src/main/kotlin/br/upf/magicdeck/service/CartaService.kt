package br.upf.magicdeck.service

import br.upf.magicdeck.converters.CartaConverter
import br.upf.magicdeck.dtos.CartaDTO
import br.upf.magicdeck.dtos.CartaResponseDTO
import br.upf.magicdeck.exceptions.NotFoundException
import br.upf.magicdeck.repository.CartaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val EVENTO_NOT_FOUND_MESSAGE = "Evento não encontrado!"

@Service
class CartaService(
    private val repository: CartaRepository,
    private val converter: CartaConverter
) {

    fun listar(
        nomeCarta: String?,
        paginacao: Pageable): Page<CartaResponseDTO> {
        val carta = if (nomeCarta == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeCarta, paginacao)
        }
        return carta
            .map(converter::toCartaResponseDTO)
    }

    fun buscarPorId(id: Long): CartaResponseDTO {
        val carta = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
        return converter.toCartaResponseDTO(carta)
    }

    fun cadastrar(dto: CartaDTO): CartaResponseDTO {
        return converter.toCartaResponseDTO(
            repository.save(converter.toCarta(dto))
        )
    }

    fun atualizar(id: Long, dto: CartaDTO): CartaResponseDTO {
        val carta = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
            )
        return converter.toCartaResponseDTO(repository.save(carta))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}