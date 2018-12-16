import java.util.*

sealed class StartTemplate {

    abstract val name: String
    abstract val templateFileName: String

    abstract fun getProperties(templateProperties: Properties): Properties?

    class RoomModule : StartTemplate() {
        override fun getProperties(templateProperties: Properties): Properties? {
            return templateProperties
        }
        override val name: String = "RoomModule"
        override val templateFileName: String = "RoomModule"
    }

    class RetrofitModule : StartTemplate() {
        override fun getProperties(templateProperties: Properties): Properties? {
            return templateProperties
        }
        override val name: String = "RetrofitModule"
        override val templateFileName: String = "RetrofitModule"
    }

    class AppModule : StartTemplate() {
        override fun getProperties(templateProperties: Properties): Properties? {
            return templateProperties
        }
        override val name: String = "AppModule"
        override val templateFileName: String = "AppModule"
    }

    class SharedPreferencesModule : StartTemplate() {
        override fun getProperties(templateProperties: Properties): Properties? {
            return templateProperties
        }
        override val name: String = "SharedPreferencesModule"
        override val templateFileName: String = "SharedPreferencesModule"
    }
}