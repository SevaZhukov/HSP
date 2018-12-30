package creator.template

import java.util.*

sealed class Template(val name: String) {

    fun getProperties(templateProperties: Properties): Properties {
        return templateProperties
    }

    class RoomModule(name: String) : Template(name)
    class RetrofitModule(name: String) : Template(name)
    class AppModule(name: String) : Template(name)
    class SharedPreferencesModule(name: String) : Template(name)
    class AppComponent(name: String) : Template(name)
    class FragmentScope(name: String) : Template(name)
    class FlowFragmentScope(name: String) : Template(name)
    class DaggerComponentHelper(name: String) : Template(name)
    class App(name: String) : Template(name)
    class BaseCallback(name: String) : Template(name)
    class MainThreadExecutor(name: String) : Template(name)
    class AppDatabase(name: String) : Template(name)
    class Extensions(name: String) : Template(name)
}