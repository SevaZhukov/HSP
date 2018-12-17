package creator.template.type

import creator.template.Template

enum class TypeApp {

    APP {
        override fun getTemplate(): Template =
            Template.App("App")
    };

    abstract fun getTemplate(): Template
}
