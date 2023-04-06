package br.com.atarashi.forum.dto

import br.com.atarashi.forum.model.Topico
import br.com.atarashi.forum.model.Usuario
import java.time.LocalDateTime

data class RespostaView(var id: Long? = null,
                        val mensagem: String,
                        val dataCriacao: LocalDateTime = LocalDateTime.now(),
                        val autor: Usuario,
                        var topico: Topico? = null,
                        var solucao: Boolean? = false
)
