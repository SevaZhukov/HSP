package creator

import com.intellij.ide.fileTemplates.FileTemplateManager
import com.intellij.ide.fileTemplates.FileTemplateUtil
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import creator.template.Template
import creator.template.type.*
import creator.template.type.data.TypeAppDatabase
import creator.template.type.di.TypeDICoreAppComponent
import creator.template.type.di.TypeDICoreHelper
import creator.template.type.di.TypeDICoreModule
import creator.template.type.di.TypeDICoreScope
import creator.template.type.domain.TypeBaseCallback
import creator.template.type.domain.TypeMainThreadExecutor

class Creator(private val project: Project) {

    fun createDICoreModule(directory: PsiDirectory) {
        TypeDICoreModule.values().forEach { type ->
            createTemplateFile(type.getTemplate(), directory)
        }
    }

    fun createDICoreScope(directory: PsiDirectory) {
        TypeDICoreScope.values().forEach { type ->
            createTemplateFile(type.getTemplate(), directory)
        }
    }

    fun createDICoreHelper(directory: PsiDirectory) {
        TypeDICoreHelper.values().forEach { type ->
            createTemplateFile(type.getTemplate(), directory)
        }
    }

    fun createDICoreAppComponent(directory: PsiDirectory) {
        TypeDICoreAppComponent.values().forEach { type ->
            createTemplateFile(type.getTemplate(), directory)
        }
    }

    fun createApp(directory: PsiDirectory) {
        TypeApp.values().forEach { type ->
            createTemplateFile(type.getTemplate(), directory)
        }
    }

    fun createBaseCallback(directory: PsiDirectory) {
        TypeBaseCallback.values().forEach { type ->
            createTemplateFile(type.getTemplate(), directory)
        }
    }

    fun createMainThreadExecutor(directory: PsiDirectory) {
        TypeMainThreadExecutor.values().forEach { type ->
            createTemplateFile(type.getTemplate(), directory)
        }
    }

    fun createAppDatabase(directory: PsiDirectory) {
        TypeAppDatabase.values().forEach { type ->
            createTemplateFile(type.getTemplate(), directory)
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