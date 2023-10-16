package br.upf.magicdeck.repository

import br.upf.magicdeck.model.Deck
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DeckRepository: JpaRepository<Deck, Long> {

    fun findByNome(nomeDeck: String, paginacao: Pageable): Page<Deck>
}
