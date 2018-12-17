
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DataKeys
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiDirectory
import creator.Creator
import javax.swing.JDialog
import com.intellij.openapi.wm.impl.IdeFrameImpl
import com.intellij.openapi.wm.WindowManager
import com.intellij.openapi.wm.ex.WindowManagerEx
import java.awt.Window
import javax.swing.JFrame


class Start : AnAction() {

    lateinit var classCreator: Creator
    private lateinit var event: AnActionEvent

    /*private fun getParentWindow(project: Project): Window? {
        val windowManager = WindowManager.getInstance() as WindowManagerEx
        var window = windowManager.suggestParentWindow(project)
        if (window == null) {
            val focusedWindow = windowManager.mostRecentFocusedWindow
            if (focusedWindow is IdeFrameImpl) {
                window = focusedWindow
            }
        }
        return window
    }*/

    override fun actionPerformed(event: AnActionEvent) {
        this.event = event
        val project = event.project!!

        /*val frame = JFrame()
        val dialog = JDialog(frame, "Lol", true)
        frame.add(dialog)
        getParentWindow(project)!!.add(frame)*/

        classCreator = Creator(project)
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
        createCoreData(core)
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
        val destinationPath = event.getData(LangDataKeys.PSI_ELEMENT) as PsiDirectory
        val classDirectory = destinationPath
            .findSubdirectory("core")!!
            .findSubdirectory("di")!!
            .findSubdirectory("core")!!
        classCreator.createDICoreAppComponent(classDirectory)
    }

    private fun createCoreDICoreScope(folder: VirtualFile) {
        folder.createChildDirectory(folder, "scope")
        val destinationPath = event.getData(LangDataKeys.PSI_ELEMENT) as PsiDirectory
        val classDirectory = destinationPath
            .findSubdirectory("core")!!
            .findSubdirectory("di")!!
            .findSubdirectory("core")!!
            .findSubdirectory("scope")!!
        classCreator.createDICoreScope(classDirectory)
    }

    private fun createCoreDICoreModule(folder: VirtualFile) {
        folder.createChildDirectory(folder, "module")
        val destinationPath = event.getData(LangDataKeys.PSI_ELEMENT) as PsiDirectory
        val classDirectory = destinationPath
            .findSubdirectory("core")!!
            .findSubdirectory("di")!!
            .findSubdirectory("core")!!
            .findSubdirectory("module")!!
        classCreator.createDICoreModule(classDirectory)
    }

    private fun createCoreDIHelper(folder: VirtualFile) {
        folder.createChildDirectory(folder, "helper")
        val destinationPath = event.getData(LangDataKeys.PSI_ELEMENT) as PsiDirectory
        val classDirectory = destinationPath
            .findSubdirectory("core")!!
            .findSubdirectory("di")!!
            .findSubdirectory("helper")!!
        classCreator.createDICoreHelper(classDirectory)
    }

    private fun createCoreDISub(folder: VirtualFile) {
        val sub = folder.createChildDirectory(folder, "sub")
    }

    private fun createFeature(folder: VirtualFile) {
        val feature = folder.createChildDirectory(folder, "feature")
    }

    private fun createCoreDomain(folder: VirtualFile) {
        folder.createChildDirectory(folder, "domain")
        val destinationPath = event.getData(LangDataKeys.PSI_ELEMENT) as PsiDirectory
        val classDirectory = destinationPath
            .findSubdirectory("core")!!
            .findSubdirectory("domain")!!
        classCreator.createBaseCallback(classDirectory)
        classCreator.createMainThreadExecutor(classDirectory)
    }

    private fun createCoreData(folder: VirtualFile) {
        folder.createChildDirectory(folder, "data")
        val destinationPath = event.getData(LangDataKeys.PSI_ELEMENT) as PsiDirectory
        val classDirectory = destinationPath
            .findSubdirectory("core")!!
            .findSubdirectory("data")!!
        classCreator.createAppDatabase(classDirectory)
    }

    private fun createApp(folder: VirtualFile) {
        val destinationPath = event.getData(LangDataKeys.PSI_ELEMENT) as PsiDirectory
        classCreator.createApp(destinationPath)
    }
}
