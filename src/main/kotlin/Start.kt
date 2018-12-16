import cat.helm.idea.extensions.NameFormats
import cat.helm.idea.extensions.sceneNameFormat
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DataKeys
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiDirectory

import javax.swing.JPanel

class Start : AnAction() {

    lateinit var panel: JPanel

    lateinit var project: Project
    lateinit var event: AnActionEvent

    override fun actionPerformed(event: AnActionEvent) {
        this.event = event
        val file = DataKeys.VIRTUAL_FILE.getData(event.dataContext)
        project = event.project!!
        if (file == null) return
        val folder = if (file.isDirectory) file else file.parent
        WriteCommandAction.runWriteCommandAction(project) {
            createCore(folder)
            createFeature(folder)
            createApp(folder)
        }
    }

    private fun createCore(folder: VirtualFile) {
        val core = folder.createChildDirectory(folder, "core")
        createCoreDI(core)
        createCoreDomain(core)
    }

    private fun createCoreDI(folder: VirtualFile) {
        val di = folder.createChildDirectory(folder, "di")
        createCoreDICore(di)
        createCoreDIHelper(di)
        createCoreDISub(di)
    }

    private fun createCoreDICore(folder: VirtualFile) {
        val core = folder.createChildDirectory(folder, "core")
        createCoreDICoreScope(core)
        createCoreDICoreModule(core)
        //TODO create AppComponent here
    }

    private fun createCoreDICoreScope(folder: VirtualFile) {
        //TODO create scopes here
    }

    private fun createCoreDICoreModule(folder: VirtualFile) {
        //TODO create modules here
        val sceneName = "roomModule"
        val fileName = sceneName.sceneNameFormat(NameFormats.FILE)
        val directoryName = "room".sceneNameFormat(NameFormats.FOLDER)
        val destinationPath = event.getData(LangDataKeys.PSI_ELEMENT)!! as PsiDirectory
        val sceneDirectory = destinationPath.createSubdirectory(directoryName)
        val sceneFileCreator = FileCreator(project)
        sceneFileCreator.createFile(fileName, sceneDirectory)
    }

    private fun createCoreDIHelper(folder: VirtualFile) {
        val helper = folder.createChildDirectory(folder, "helper")
        //TODO create helper here
    }

    private fun createCoreDISub(folder: VirtualFile) {
        val sub = folder.createChildDirectory(folder, "sub")
    }

    private fun createFeature(folder: VirtualFile) {
        val feature = folder.createChildDirectory(folder, "feature")
    }

    private fun createCoreDomain(folder: VirtualFile) {
        val domain = folder.createChildDirectory(folder, "domain")
        createCoreDICore(domain)
        createCoreDIHelper(domain)
        createCoreDISub(domain)
    }

    private fun createApp(folder: VirtualFile) {
        //TODO create App here
    }

    /* JavaDirectoryService directoryService = JavaDirectoryService.getInstance();
    PsiDirectory directory = e.getRequiredData(LangDataKeys.IDE_VIEW).getOrChooseDirectory();
    PsiClass dtoClass = directoryService.createClass(directory, "Lol");
    Project project = dtoClass.getManager().getProject();*/
}
