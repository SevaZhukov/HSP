package cat.helm.idea.extensions


enum class NameFormats {
    FOLDER,
    FILE,
    LAYOUT
}

fun String.sceneNameFormat(format: NameFormats): String = when (format) {
    NameFormats.FOLDER,
    NameFormats.LAYOUT -> this.substring(0, 1).toLowerCase() + this.substring(1)
    NameFormats.FILE -> this.substring(0, 1).toUpperCase() + this.substring(1)
}


