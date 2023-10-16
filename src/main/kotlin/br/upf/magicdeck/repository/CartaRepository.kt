package br.upf.magicdeck.repository

import br.upf.magicdeck.model.Carta
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CartaRepository: JpaRepository<Carta, Long> {

    fun findByNome(nomeCarta: String, paginacao: Pageable): Page<Carta>
}