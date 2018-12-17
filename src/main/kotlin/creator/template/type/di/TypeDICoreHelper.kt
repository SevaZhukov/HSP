package creator.template.type.di

import creator.template.Template

enum class TypeDICoreHelper {

    DAGGER_COMPONENT_HELPER {
        override fun getTemplate(): Template =
            Template.DaggerComponentHelper("DaggerComponentHelper")
    };

    abstract fun getTemplate(): Template
}
