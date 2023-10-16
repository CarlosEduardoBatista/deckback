package br.upf.magicdeck.dtos

data class UsuarioResponseDTO(
    val id: Long? = null,
    val nome: String,
    val email: String
)
