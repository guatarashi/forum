package br.com.atarashi.forum.model

import java.time.LocalDateTime

data class Resposta(var id: Long? = null,
                    val mensagem: String,
                    val dataCriacao: LocalDateTime = LocalDateTime.now(),
                    val autor: Usuario,
                    var topico: Topico? = null,
                    var solucao: Boolean? = false
)
