# Custome Loaders

[![](https://jitpack.io/v/hpkaushik121/CustomLoader.svg)](https://jitpack.io/#hpkaushik121/CustomLoader)


## Usage:

````<hostingegnine.tech.progressloaders.MergedLoaders.MergerdLoadersView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                app:mk_type="< Type of loader >"
                app:srcDrawable="@drawable/loader" //only if mk_type is GifLoader
                />
````

## Supported Types:

* Sharingan
* TwinFishesSpinner
* ClassicSpinner
* LineSpinner
* FishSpinner
* PhoneWave
* ThreePulse
* FourPulse
* FivePulse
* Worm
* Whirlpool
* Radar
* ProgressDots
* GifLoader 
* * srcDrawable

## Download :
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
and:

```gradle
dependencies {
    implementation 'com.github.hpkaushik121:CustomLoader:{latest version}'
}
```


