package br.upf.sistemaeventos.model

import jakarta.persistence.*

@Entity
data class Deck(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    @OneToMany(mappedBy = "deck")
    val carta: List<Carta> = listOf()
)
