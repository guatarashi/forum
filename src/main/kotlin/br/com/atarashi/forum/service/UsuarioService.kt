package br.com.atarashi.forum.service

import br.com.atarashi.forum.model.Usuario
import br.com.atarashi.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return repository.getReferenceById(id)
    }
}