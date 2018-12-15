import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DataKeys
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.vfs.VirtualFile

import javax.swing.JPanel

class Start : AnAction() {

    lateinit var panel: JPanel

    override fun actionPerformed(event: AnActionEvent) {

        /*val dialogValues = Messages
            .showInputDialogWithCheckBox(
                "",
                "New Scene",
                "Insert layout file?",
                true,
                true,
                null,
                null,
                null
            )*/

        val file = DataKeys.VIRTUAL_FILE.getData(event.dataContext)
        val project = event.project
        if (file == null || project == null) return
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
