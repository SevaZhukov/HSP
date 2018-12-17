package creator.template.type.domain

import creator.template.Template

enum class TypeMainThreadExecutor {

    MAIN_THREAD_EXECUTOR {
        override fun getTemplate(): Template =
            Template.MainThreadExecutor("MainThreadExecutor")
    };

    abstract fun getTemplate(): Template
}
