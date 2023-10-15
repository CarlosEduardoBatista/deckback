package br.upf.sistemaeventos.controller

import br.upf.sistemaeventos.dtos.DeckDTO
import br.upf.sistemaeventos.dtos.DeckResponseDTO
import br.upf.sistemaeventos.service.DeckService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/eventos")
class DeckController(val service: DeckService) {

    @GetMapping
    fun listar(
        @RequestParam(required = false) nomeDeck: String?,
        @PageableDefault(size = 10) paginacao: Pageable)
            : Page<DeckResponseDTO> {
        return service.listar(nomeDeck, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): DeckResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(@RequestBody @Valid dto: DeckDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<DeckResponseDTO> {
        val eventoResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/eventos/${eventoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(eventoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: DeckDTO
    ): DeckResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}