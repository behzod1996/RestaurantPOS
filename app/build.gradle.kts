plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    `maven-publish`
}

android {

    compileSdk = Configs.compileSdkVersion

    defaultConfig {
        applicationId = Configs.applicationIdName
        minSdk = Configs.minSdkVersion
        targetSdk = Configs.targetSdkVersion
        versionCode = Configs.versionCodeVersion
        versionName = Configs.versionName
        testInstrumentationRunner = Configs.testInstrumentationRunnerName

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf("room.schemaLocation" to "$projectDir/schemas.")            }
        }
    }
    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName(BuildTypes.RELEASE) {
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
        jvmTarget = ("1.8")
    }
    sourceSets {
        // Adds exported schema location as test app assets.
        getByName("androidTest").assets.srcDir("$projectDir/schemas")
    }

}

dependencies {
    implementation("androidx.test:core-ktx:1.4.0")
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    core()
    appCompat()
    materialDesign()
    constraintLayout()
    test()
    navigation()
    room()
    hilt()
    coroutine()
    workManager()
    viewPager()
    lifecycle()
    ktx()
    timber()
    logger()
    powerSpinner()
    passwordView()
    expandableLayout()
    pinEdit()
    imagePicker()
    glide()
    workManagerWithHilt()
    gson()
}