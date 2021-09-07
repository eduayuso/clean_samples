object Apps {

    interface IAppInfo {

        val name: String
        val id: String
        val versionName: String
        val versionCode: Int
        val testInstRunner: String
        val useDataBinding: Boolean
        val compose: Boolean
    }

    object ComposeMvvmApp: IAppInfo {

        override val name           = "CleanComposeMvvmApp"
        override val id             = "dev.eduayuso.cleansamples.composemvvmapp"
        override val versionName    = "1.0.0"
        override val versionCode    = 1
        override val testInstRunner = "dev.eduayuso.cleansamples.composemvvmapp.config.ComposeInstrumentationRunner"
        override val useDataBinding = true
        override val compose        = true
    }

    object MvvmApp: IAppInfo {

        override val name           = "CleanMvvmApp"
        override val id             = "dev.eduayuso.cleansamples.mvvmapp"
        override val versionName    = "1.0.0"
        override val versionCode    = 1
        override val testInstRunner = "dev.eduayuso.cleansamples.mvvmapp.config.MvvmInstrumentationRunner"
        override val useDataBinding = true
        override val compose        = false
    }

    object MvpApp: IAppInfo {

        override val name           = "CleanMvpApp"
        override val id             = "dev.eduayuso.cleansamples.mvpapp"
        override val versionName    = "1.0.0"
        override val versionCode    = 1
        override val testInstRunner = "dev.eduayuso.cleansamples.mvpapp.config.MvpInstrumentationRunner"
        override val useDataBinding = false
        override val compose        = false
    }
}
