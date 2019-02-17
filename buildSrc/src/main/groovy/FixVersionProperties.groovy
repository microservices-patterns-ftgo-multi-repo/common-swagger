import org.gradle.api.*

class FixVersionProperties implements Plugin<Project> {
    void apply(Project project) {
        project.ext.properties.findAll { it.key.endsWith("Version") }.each { it ->
          def s = it.key
          def w = ""
          it.key.each { x ->
            if (Character.isUpperCase(x.charAt(0))) {
              w = w + "-" + x.toLowerCase()
            } else {
              w = w + x
            }
          }
          project.ext[w] = it.value
        }
    }
}
