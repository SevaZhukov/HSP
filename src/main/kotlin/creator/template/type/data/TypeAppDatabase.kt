package creator.template.type.data

import creator.template.Template

enum class TypeAppDatabase {

    APP_DATABASE {
        override fun getTemplate(): Template =
            Template.AppDatabase("AppDatabase")
    };

    abstract fun getTemplate(): Template
}
