
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DataKeys
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiDirectory

import javax.swing.JPanel

class Start : AnAction() {

    lateinit var panel: JPanel

    lateinit var classFileCreator: FileCreator
    lateinit var event: AnActionEvent

    override fun actionPerformed(event: AnActionEvent) {
        this.event = event
        val project = event.project!!
        classFileCreator = FileCreator(project)
        val file = DataKeys.VIRTUAL_FILE.getData(event.dataContext) ?: return
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
        folder.createChildDirectory(folder, "scope")
    }

    private fun createCoreDICoreModule(folder: VirtualFile) {
        folder.createChildDirectory(folder, "module")
        val destinationPath = event.getData(LangDataKeys.PSI_ELEMENT) as PsiDirectory
        val classDirectory = destinationPath
            .findSubdirectory("core")!!
            .findSubdirectory("di")!!
            .findSubdirectory("core")!!
            .findSubdirectory("module")!!
        classFileCreator.createFile(classDirectory)
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
    }

    private fun createApp(folder: VirtualFile) {
        //TODO create App here
    }
}
