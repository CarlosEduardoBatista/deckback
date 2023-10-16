package br.upf.sistemaeventos.dtos

data class CartaResponseDTO (
        val id: Long? = null,
        val nome: String,
        val cor: String,
        val mana: Int,
        val artista: String,
        val raridade: String,
        val tipo: String
)