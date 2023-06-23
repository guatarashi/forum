package br.com.atarashi.forum.repository

import br.com.atarashi.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {
}