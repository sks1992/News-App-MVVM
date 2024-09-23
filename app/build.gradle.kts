plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.navigation.safeargs)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.androidx.room)
}

android {
    namespace = "sk.sandeep.newsappmvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "sk.sandeep.newsappmvvm"
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
        dataBinding = true
    }
    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // navigation fragment
    implementation (libs.androidx.navigation.fragment)
    //implementation ("androidx.navigation:navigation-fragment:2.8.1")
    implementation (libs.androidx.navigation.ui)
    //implementation ("androidx.navigation:navigation-ui:2.8.1")

    //activity-ktx to create viewmodel object
    implementation(libs.androidx.activity.ktx)
    //implementation("androidx.activity:activity-ktx:1.9.2")

    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    //implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
    // LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)
    //implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.6")

    //coroutine
    implementation(libs.kotlinx.coroutines.core)
    //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation(libs.kotlinx.coroutines.android)
    //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

    //retrofit
    implementation(libs.retrofit)
    //implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation(libs.converter.gson)
    //implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation(libs.gson)
    //implementation("com.google.code.gson:gson:2.11.0")

    //dagger hilt
    implementation(libs.hilt.android)
    //implementation("com.google.dagger:hilt-android:2.51.1")
    kapt(libs.hilt.android.compiler)
   //kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    //room dependencies
    implementation(libs.androidx.room.runtime)
    //implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor(libs.androidx.room.compiler)
    //annotationProcessor("androidx.room:room-compiler:2.6.1")

    //glide image dependencies
    implementation(libs.glide)
    //implementation("com.github.bumptech.glide:glide:4.16.0")

    //view pager 2
    implementation(libs.androidx.viewpager2)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}