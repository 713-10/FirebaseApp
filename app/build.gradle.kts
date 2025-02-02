plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.firebaseapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.firebaseapp"
        minSdk = 21
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
    
}

dependencies {

    // Mockito for mocking Firebase Firestore
    testImplementation(libs.mockito.mockito.core)
    testImplementation (libs.mockito.inline)
    testImplementation (libs.robolectric)
    testImplementation (libs.robolectric)
    testImplementation (libs.junit)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    testImplementation(libs.core)
    testImplementation(libs.espresso.core)
    testImplementation(libs.androidx.espresso.intents)
    testImplementation(libs.ext.junit)
    testImplementation(libs.junit.jupiter)
    androidTestImplementation (libs.ext.junit)
    androidTestImplementation (libs.espresso.core)
    androidTestImplementation (libs.androidx.espresso.intents)
    testImplementation (libs.firebase.auth)
    testImplementation (libs.firebase.firestore)
}
