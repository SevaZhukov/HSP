package creator.template.type.di

import creator.template.Template

enum class TypeDICoreAppComponent {

    APP_COMPONENT {
        override fun getTemplate(): Template =
            Template.AppComponent("AppComponent")
    };

    abstract fun getTemplate(): Template
}
