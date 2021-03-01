object Apps {

    interface IAppInfo {

        val name: String
        val id: String
        val versionName: String
        val versionCode: Int
        val testInstRunner: String
        val useDataBinding: Boolean
    }

    object MvvmApp: IAppInfo {

        override val name           = "CleanMvvmApp"
        override val id             = "dev.eduayuso.cleansamples.mvvmapp"
        override val versionName    = "1.0.0"
        override val versionCode    = 1
        override val testInstRunner = "dev.eduayuso.cleansamples.mvvmapp.config.MvvmInstrumentationRunner"
        override val useDataBinding = true
    }

    object MvpApp: IAppInfo {

        override val name           = "CleanMvpApp"
        override val id             = "dev.eduayuso.cleansamples.mvpapp"
        override val versionName    = "1.0.0"
        override val versionCode    = 1
        override val testInstRunner = "dev.eduayuso.cleansamples.mvpapp.config.MvpInstrumentationRunner"
        override val useDataBinding = false
    }
}
