package br.upf.sistemaeventos.dtos

data class UsuarioResponseDTO(
    val id: Long? = null,
    val nome: String,
    val email: String
)
