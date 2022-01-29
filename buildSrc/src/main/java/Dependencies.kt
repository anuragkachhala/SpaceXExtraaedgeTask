import Version.activity_ktx_version
import Version.appcompat_version
import Version.carousel_version
import Version.constraint_layout_version
import Version.core_ktx_version
import Version.glide_version
import Version.gradle_version
import Version.hilt_androidx
import Version.hilt_version
import Version.hilt_viewModel_version
import Version.kotlin_gradle_version
import Version.lifecycle_ext
import Version.lifecycle_version
import Version.material_version
import Version.okhttp3_version
import Version.retrofit2_version
import Version.room_version

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

object AppDependencies {
    const val gradle = "com.android.tools.build:gradle:${gradle_version}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:1.4.21-2"
    const val kotlinGradle =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlin_gradle_version}"
    const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${hilt_version}"
}


// core
object AndroidCore {
    const val coreKtx = "androidx.core:core-ktx:${core_ktx_version}"
    const val appcompat = "androidx.appcompat:appcompat:${appcompat_version}"
    const val materialDesign = "com.google.android.material:material:${material_version}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${constraint_layout_version}"
    const val activityKtx = "androidx.activity:activity-ktx:${activity_ktx_version}"
}

//Retrofit
object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofit2_version"
    const val retrofitConverterGson =
        "com.squareup.retrofit2:converter-gson:${retrofit2_version}"
    const val okhttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${okhttp3_version}"
}
//Lifecycle
object Lifecycle {
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${lifecycle_version}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
    const val lifecycleCommon =
        "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"
    const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${lifecycle_ext}"
}

//Hilt
object Hilt {
    const val hiltAndroid = "com.google.dagger:hilt-android:$hilt_version"
    const val daggerCompiler = "com.google.dagger:hilt-android-compiler:$hilt_version"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${hilt_androidx}"
    const val hiltViewModel =
        "androidx.hilt:hilt-lifecycle-viewmodel:${hilt_viewModel_version}"
}

//Coroutines
object Coroutines {
    const val core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines_android_version}"
    const val android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines_android_version}"
}

object Glide {
    const val glide =  "com.github.bumptech.glide:glide:4.12.0"
    const val glideAnnotation = "com.github.bumptech.glide:compiler:4.12.0"
}

object Carousel {
    const val carousel = "com.synnapps:carouselview:0.1.5"
}

object Room {
    const val compiler = "androidx.room:room-compiler:$room_version"
    const val ktx1 = "androidx.room:room-ktx:${room_version}"
    const val runtime1 = "androidx.room:room-runtime:${room_version}"
}

//Testing
object Testing {
    const val jUnit = "junit:junit:${Version.junit}"
    const val extJUnit = "androidx.test.ext:junit:${Version.test_junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
}