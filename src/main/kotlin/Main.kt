package io.github.nomisrev

import com.charleskorn.kaml.YamlConfiguration
import org.yaml.snakeyaml.Yaml
import java.io.File
import kotlin.system.measureTimeMillis
import com.charleskorn.kaml.Yaml as Kaml

fun main() {
  val yaml = File("openai-api.yaml").readText()
  val java =
    measureTimeMillis { Yaml().load<Any?>(yaml) }
  println(java) // 140ms
  val kaml  = measureTimeMillis {
    Kaml(
      configuration = YamlConfiguration(
        encodeDefaults = false,
        strictMode = false,
        allowAnchorsAndAliases = true
      )
    ).parseToYamlNode(yaml)
  }
  println(kaml) // 56_901ms
}