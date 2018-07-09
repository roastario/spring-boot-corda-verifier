@file:JvmName("Runner")
package com.r3.corda.spring.boot.validation
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["com.r3.corda.spring.boot.validation"])
open class ApiApplication

/**
 * Starts the Network Map Service.
 *
 * @param args Any args passed from the command line.
 */
fun main(args: Array<String>) {
    System.setProperty("logging.level.org.springframework.web", "DEBUG")
    System.setProperty("amqp.custom.serialization.scanSpec", "")
    val app = SpringApplication(ApiApplication::class.java)
    app.isWebEnvironment = true
    app.run(*args)
}
