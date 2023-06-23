package br.com.atarashi.forum.service

import br.com.atarashi.forum.model.Curso
import br.com.atarashi.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long) : Curso {
        return repository.getReferenceById(id)
    }
}