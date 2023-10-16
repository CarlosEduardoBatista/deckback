package br.upf.magicdeck

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MagicDeckApplication

fun main(args: Array<String>) {
	runApplication<MagicDeckApplication>(*args)
}
