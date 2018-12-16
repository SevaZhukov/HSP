enum class StartType {

    ROOM_MODULE {
        override fun getTemplate(): StartTemplate = StartTemplate.RoomModule()
    },
    RETROFIT_MODULE {
        override fun getTemplate(): StartTemplate = StartTemplate.RetrofitModule()
    },
    APP_MODULE {
        override fun getTemplate(): StartTemplate = StartTemplate.AppModule()
    },
    SHARED_PREFERENCES_MODULE {
        override fun getTemplate(): StartTemplate = StartTemplate.SharedPreferencesModule()
    };

    abstract fun getTemplate(): StartTemplate
}
