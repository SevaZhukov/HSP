package creator.template.type.domain

import creator.template.Template

enum class BaseCallback {

    BASE_CALLBACK {
        override fun getTemplate(): Template =
            Template.App("BaseCallback")
    };

    abstract fun getTemplate(): Template
}
