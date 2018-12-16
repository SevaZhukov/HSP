import com.intellij.ide.fileTemplates.FileTemplateManager
import com.intellij.ide.fileTemplates.FileTemplateUtil
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class FileCreator(private val project: Project) {
    fun createFile(directory: PsiDirectory) {
        StartType.values().forEach { sceneType ->
            println("foreach ${sceneType.name}")
            val template = sceneType.getTemplate()
            createTemplateFile(template, directory)
        }
    }

    private fun createTemplateFile(startTemplate: StartTemplate, destinationDirectory: PsiDirectory) {
        val fileTemplate = FileTemplateManager.getInstance(project).getInternalTemplate(startTemplate.templateFileName)
        val templateProperties = FileTemplateManager.getInstance(project).defaultProperties
        FileTemplateUtil.createFromTemplate(
            fileTemplate,
            startTemplate.name,
            startTemplate.getProperties(templateProperties),
            destinationDirectory
        )
    }
}