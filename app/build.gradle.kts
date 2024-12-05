plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.gms.google-services")



}

android {
    namespace = "com.example.bookread"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.bookread"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"


    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3" // نسخه جدید Compose Compiler
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")


    implementation ("io.github.jan-tennert.supabase:gotrue-kt:1.4.7")
    implementation ("io.github.jan-tennert.supabase:postgrest-kt:1.4.7")
    implementation(platform("io.github.jan-tennert.supabase:bom:2.0.0-rc-1"))
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
    implementation("io.ktor:ktor-client-android:2.3.7")


//    //Dagger - Hilt
//    implementation("com.google.dagger:hilt-android:2.48")
//
//    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
//// Dagger - Hilt
//    implementation(libs.hilt.android)
//    implementation(libs.hilt.navigation.compose)

    // Coroutine Lifecycle Scopes
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.runtime.ktx.v287)

    // Coil
    implementation(libs.coil.compose)
    // Retrofit
    implementation (libs.retrofit)

    // OkHttp
    implementation(libs.okhttp)

    // JSON Converter
    implementation (libs.converter.gson)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
