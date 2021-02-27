object Apps {

    interface IAppInfo {

        val name: String
        val id: String
        val versionName: String
        val versionCode: Int
        val testInstRunner: String
    }

    object MvvmApp: IAppInfo {

        override val name           = "efitow"
        override val id             = "dev.eduayuso.cleansamples.mvvmapp"
        override val versionName    = "1.0.0"
        override val versionCode    = 1
        override val testInstRunner = "dev.eduayuso.cleansamples.mvvmapp.MvvmInstrumentationRunner"
    }
}
