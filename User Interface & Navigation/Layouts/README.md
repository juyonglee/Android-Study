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

## Load the XML Resource
- When you compile your app, **`each XML layout file is compiled into a View resource`**. 
- You should load the layout resource from your app code, in your _**`Activity.onCreate()`**_ callback implementation. 
- Do so by calling _**`setContentView()`**_, passing it _**the reference**_ to your layout resource in the form of: _**`R.layout.layout_file_name`**_.
- The _**`onCreate()`**_ callback method in your Activity _**`is called by the Android framework`**_ when your Activity is launched.
```java
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);
}
```

## Attributes
- Every View and ViewGroup object supports their own variety of XML attributes. 
- Some attributes are specific to a View object (for example, TextView supports the textSize attribute), but these attributes are also inherited by any View objects that may extend this class. 
- Some are common to all View objects, because they are inherited from the root View class (like the id attribute). 
- And, other attributes are considered "layout parameters," which are attributes that describe certain layout orientations of the View object, as defined by that object's parent ViewGroup object.
### ID
- Any View object may have an _**`integer ID`**_ associated with it, to uniquely identify the View _**within the tree**_. 
- When the app is compiled, this ID is referenced as an integer, **but the ID is typically assigned in the layout XML file as a _string_**, in the id attribute. 
- The syntax for an ID, inside an XML tag is:
    ```xml
    android:id="@+id/my_button"
    ```
- _**`The at-symbol (@)`**_ at the beginning of the string indicates that the XML parser should parse and expand the rest of the ID string and identify it as an ID resource. 
- _**`The plus-symbol (+)`**_ means that this is a new resource name that must be created and added to our resources `(in the R.java file)`. There are a number of other ID resources that are offered by the Android framework. 
- **`When referencing an Android resource ID`**, you do not need the plus-symbol, but _must add the android package namespace._
    ```xml
    android:id="@android:id/empty"
    ```
- With the android package namespace in place, we're now referencing an ID from the android.R resources class, rather than the local resources class.

**`[Common Pattern]`** In order to create views and reference them from the app.
1. Define a view/widget in _the layout file_ and assign it a unique ID:

    ```xml
    <Button android:id="@+id/my_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/my_button_text"/>
    ```

2. Create an _**`instance of the view object`**_ and capture it from the layout.
    ```java
    Button myButton = (Button) findViewById(R.id.my_button);
    ```