package creator.template.type.di

import creator.template.Template

enum class TypeDICoreModule {

    ROOM_MODULE {
        override fun getTemplate(): Template = Template.RoomModule("RoomModule")
    },
    RETROFIT_MODULE {
        override fun getTemplate(): Template =
            Template.RetrofitModule("RetrofitModule")
    },
    APP_MODULE {
        override fun getTemplate(): Template = Template.AppModule("AppModule")
    },
    SHARED_PREFERENCES_MODULE {
        override fun getTemplate(): Template =
            Template.SharedPreferencesModule("SharedPreferencesModule")
    };

    abstract fun getTemplate(): Template
}
