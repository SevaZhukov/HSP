import com.intellij.ide.fileTemplates.FileTemplateManager
import com.intellij.ide.fileTemplates.FileTemplateUtil
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class FileCreator(private val project: Project) {
    fun createFile(name: String, directory: PsiDirectory) {
        println("create file")
        SceneType.values().forEach { sceneType ->
            println("create file for each")
            val template = sceneType.getTemplate(name)
            createTemplateFile(template, directory)
        }
    }

    private fun createTemplateFile(template: Template, destinationDirectory: PsiDirectory) {
        println("create template")
        val fileTemplate = FileTemplateManager.getInstance(project).getInternalTemplate(template.templateFileName)
        val templateProperties = FileTemplateManager.getInstance(project).defaultProperties
        FileTemplateUtil.createFromTemplate(
            fileTemplate,
            template.name,
            template.getProperties(templateProperties),
            destinationDirectory
        )
        println("created")
    }
}