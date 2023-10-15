package br.upf.sistemaeventos.converters

import br.upf.sistemaeventos.dtos.UsuarioDTO
import br.upf.sistemaeventos.dtos.UsuarioResponseDTO
import br.upf.sistemaeventos.model.Usuario
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class UsuarioConverter {
    fun toUsuarioResponseDTO(usuario: Usuario): UsuarioResponseDTO {
        return UsuarioResponseDTO(
            id = usuario.id,
            nome = usuario.nome,
            email = usuario.email
        )
    }

    fun toUsuario(dto: UsuarioDTO): Usuario {
        return Usuario(
            nome = dto.nome,
            email = dto.email,
            senha = BCryptPasswordEncoder().encode(dto.senha)
        )
    }
}