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
}