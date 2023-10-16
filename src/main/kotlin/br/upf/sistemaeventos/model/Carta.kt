package br.upf.sistemaeventos.model

import jakarta.persistence.*

@Entity
data class Carta(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val cor: String,
    val mana: Int,
    val artista: String,
    val raridade: String,
    val tipo: String,
    @ManyToOne
    val deck: Deck,
    )
