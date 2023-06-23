package br.com.atarashi.forum.repository

import br.com.atarashi.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {
}