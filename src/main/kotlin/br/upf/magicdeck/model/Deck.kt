package br.upf.magicdeck.model

import jakarta.persistence.*

@Entity
data class Deck(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    @ManyToMany
    @JoinTable(
        name = "Carta_Deck",
        joinColumns = [JoinColumn(name = "deck_id")],
        inverseJoinColumns = [JoinColumn(name = "carta_id")]
    )
    val carta: List<Carta> = listOf(),
    val formato: Formato
)
