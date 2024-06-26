# snakeyaml-kmp-reproducer

Code from main.kt

```kotlin
val yaml = File("openai-api.yaml").readText()

val java = measureTimeMillis { Yaml().load<Any?>(yaml) }
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
```