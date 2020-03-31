# Flip digit library

# ![](gif.gif)

# Installation
``` 
   implementation 'com.github.aldrek:Flip_Digit:1.0'
```
## Usage
  
  Use this in xml 
  
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
        
   Use this in code
    
     Kotlin
        var i = 0
        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                filipSingle.setDigit(i , true)
                i++
            }

            override fun onFinish() {
            }
         }.start()
         
      Java

         int i = 0;
         new CountDownTimer(10000, 1000) {

             public void onTick(long millisUntilFinished) {
                digit.setDigit(i*2 , true);
             }

             public void onFinish() {
             }

           }.start();


## Contributing

## Credits

## License

