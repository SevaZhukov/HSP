package creator.template.type.extensions

import creator.template.Template

enum class TypeExtensions {

    EXTENSIONS {
        override fun getTemplate(): Template =
            Template.App("Extensions")
    };

    abstract fun getTemplate(): Template
}
