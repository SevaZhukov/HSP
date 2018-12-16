package template

enum class StartType {

    ROOM_MODULE {
        override fun getTemplate(name: String): StartTemplate = StartTemplate.RoomModule(name)
    },
    RETROFIT_MODULE {
        override fun getTemplate(name: String): StartTemplate = StartTemplate.RetrofitModule(name)
    },
    APP_MODULE {
        override fun getTemplate(name: String): StartTemplate = StartTemplate.AppModule(name)
    },
    SHARED_PREFERENCES_MODULE {
        override fun getTemplate(name: String): StartTemplate = StartTemplate.SharedPreferencesModule(name)
    };

    abstract fun getTemplate(sceneName: String): StartTemplate
}
