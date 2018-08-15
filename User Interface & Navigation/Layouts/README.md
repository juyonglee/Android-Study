# Layouts
- A layout defines the structure for a `user interface` in your app, such as in an activity. 
- All elements in the layout are built using a `hierarchy of View and ViewGroup objects.` 

     **View vs View Group**
    - **View**: It usually draws something `the user can see and interact with.` A View usually draws something the user can see and interact with. The View objects are usually called **`"widgets"`** and can be one of many subclasses, such as __*[Button](https://developer.android.com/reference/android/widget/Button)*__ or __*[TextView](https://developer.android.com/reference/android/widget/TextView)*__. 
    - **ViewGroup**: It is an `invisible container` that defines the layout structure for View and other ViewGroup objects. A ViewGroup is an `invisible container` that defines `the layout structure` for View and other ViewGroup objects. The ViewGroup objects are usually called **`"layouts"`** can be one of many types that provide a different layout structure, such as **_[LinearLayout](https://developer.android.com/reference/android/widget/LinearLayout)_** or **_[ConstraintLayout](https://developer.android.com/reference/android/support/constraint/ConstraintLayout)_**.

**You can Declare a layout in two ways**
1. **Declare UI elements in XML**

    Android provides a straightforward XML vocabulary that corresponds to the _`View classes`_ and _`subclasses`_, such as those for widgets and layouts.
2. **Instantiate layout elements at runtime** 
    
    `Your app can create View and ViewGroup objects (and manipulate their properties) programmatically.` Declaring your UI in XML allows you to separate the presentation of your app from the code that controls its behavior. **The Android framework** gives you the flexibility to use either or both of these methods to build your app's UI.

    
## Write the XML
- Using Android's XML vocabulary, you can quickly design UI layouts and the screen elements they contain, _in the same way you create web pages in **HTML**_ — **`with a series of nested elements`**. 
- Each layout file must contain exactly **one root element**, which must be a View or ViewGroup object. Once you've defined the root element, you can add additional layout objects or widgets as child elements to gradually build a View hierarchy that defines your layout.
- After you've declared your layout in XML, save the file with the **_`.xml`_** extension, in your Android project's **_`res/layout/`_** directory, so it will properly compile.

    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical" >
        <TextView android:id="@+id/nameTextView"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Hello, I'm Juyong Lee" />
        <Button android:id="@+id/greetingButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Nice to meet you!" />
    </LinearLayout>
    ```