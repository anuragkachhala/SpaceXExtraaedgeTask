import Version.activity_ktx_version
import Version.appcompat_version
import Version.constraint_layout_version
import Version.core_ktx_version
import Version.gradle_version
import Version.kotlin_gradle_version
import Version.material_version
import Version.okhttp3_version
import Version.retrofit2_version

/**
 * @Author: Anurag Kumar Kachhala
 * @Date: 29,January,2022
 */

object AppDependencies {
    const val gradle = "com.android.tools.build:gradle:${gradle_version}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:1.4.21-2"
    const val kotlinGradle =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlin_gradle_version}"
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

//Testing
object Testing {
    const val jUnit = "junit:junit:${Version.junit}"
    const val extJUnit = "androidx.test.ext:junit:${Version.test_junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
}