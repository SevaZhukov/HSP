import javax.swing.JButton
import javax.swing.JDialog
import javax.swing.JFrame
import javax.swing.JLabel

class Dialog(owner: JFrame, title: String, some: Boolean) : JDialog(owner, title, some) {
    init {
        add(JLabel("Я тут захерачил плагин чтобы не писать тонны шаблонного кода ручками :3 Так что если хочешь сделать быстрый старт, то жми ПОГНАЛИ"))
        val okButton = JButton("ПОГНАЛИ")
        okButton.addActionListener {

        }
    }
}