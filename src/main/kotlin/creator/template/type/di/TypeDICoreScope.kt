package creator.template.type.di

import creator.template.Template

enum class TypeDICoreScope {

    FRAGMENT_SCOPE {
        override fun getTemplate(): Template =
            Template.FragmentScope("FragmentScope")
    },
    FLOW_FRAGMENT_SCOPE {
        override fun getTemplate(): Template =
            Template.FlowFragmentScope("FlowFragmentScope")
    };

    abstract fun getTemplate(): Template
}
