package br.com.atarashi.forum.dto

import br.com.atarashi.forum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoView(val id: Long?,
                      val titulo: String,
                      val mensagem: String,
                      val status: StatusTopico,
                      val dataCriacao: LocalDateTime
)
