# Flip digit library

  Flip digit Library makes a cool and flexible animation when changing numbers
  
[![](https://jitpack.io/v/aldrek/Flip_Digit.svg)](https://jitpack.io/#aldrek/Flip_Digit)
[![platform](https://img.shields.io/badge/platform-Android-green.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=21)

# ![](gif.gif)

## :hammer: Setup
 In your ``` build.gradle:```

``` 
dependencies {
   implementation 'com.github.aldrek:Flip_Digit:1.0.1'
}
```

## Usage
  
  Use this in xml 
  
```
    <com.aldrek.digitflip.FlipDigit
        android:id="@+id/digit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:isFastFlip="true"
        app:tintColor="#FF0000"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        ></com.aldrek.digitflip.FlipDigit>
```

   Use this in code
   
   Kotlin
     
```
        var i = 0
        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                filipSingle.setDigit(i , true)
                i++
            }

            override fun onFinish() {
            }
         }.start()
```

   Java
   
   
```
         int i = 0;
         new CountDownTimer(10000, 1000) {

             public void onTick(long millisUntilFinished) {
                digit.setDigit(i*2 , true);
             }

             public void onFinish() {
             }

           }.start();
```

## License
Copyright 2018 aldrek . All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
