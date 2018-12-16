enum class SceneType {

    ROOM_MODULE {
        override fun getTemplate(name: String): Template = Template.RoomModule(name)
    };

    /*ACTIVITY {
        override fun getTemplate(sceneName: String): Template = Template.Activity(sceneName)
    },
    ACTIVITY_MODULE {
        override fun getTemplate(sceneName: String): Template = Template.ActivityModule(sceneName)

    },
    LAYOUT {
        override fun getTemplate(sceneName: String): Template = Template.Layout(sceneName)

    },
    PRESENTER {
        override fun getTemplate(sceneName: String): Template = Template.Presenter(sceneName)
    },
    VIEW {
        override fun getTemplate(sceneName: String): Template = Template.View(sceneName)
    };*/


    abstract fun getTemplate(sceneName: String): Template


    //fun isSourceFile(): Boolean  = this != LAYOUT

}
