package creator.template.type.domain

import creator.template.Template

enum class TypeBaseCallback {

    BASE_CALLBACK {
        override fun getTemplate(): Template =
            Template.BaseCallback("BaseCallback")
    };

    abstract fun getTemplate(): Template
}
