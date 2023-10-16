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
    @ManyToMany
    @JoinTable(
        name = "Carta_Deck",
        joinColumns = [JoinColumn(name = "id_carta")],
        inverseJoinColumns = [JoinColumn(name = "id_deck")]
    )
    val deck: List<Deck> = listOf(),
    )
