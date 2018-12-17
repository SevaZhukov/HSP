package creator

import com.intellij.ide.fileTemplates.FileTemplateManager
import com.intellij.ide.fileTemplates.FileTemplateUtil
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import creator.template.Template
import creator.template.Type

class Creator(private val project: Project) {
    fun createFile(directory: PsiDirectory) {
        Type.values().forEach { sceneType ->
            val template = sceneType.getTemplate()
            createTemplateFile(template, directory)
        }
    }

    private fun createTemplateFile(template: Template, destinationDirectory: PsiDirectory) {
        val fileTemplate = FileTemplateManager.getInstance(project).getInternalTemplate(template.name)
        val templateProperties = FileTemplateManager.getInstance(project).defaultProperties
        FileTemplateUtil.createFromTemplate(
            fileTemplate,
            template.name,
            template.getProperties(templateProperties),
            destinationDirectory
        )
    }
}