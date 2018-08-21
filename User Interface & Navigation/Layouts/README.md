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
- `Some are common to all View objects, because they are inherited from the root View class (like the id attribute)`. 
- Other attributes are considered _**`"layout parameters"`**_, _which are attributes that describe certain layout orientations of the View object, as defined by that object's parent ViewGroup object._
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
### Layout Parameters
- XML layout attributes named _**`layout_something`**_ define `layout parameters for the View` that are appropriate for the ViewGroup in which it resides.
- **`Every ViewGroup class implements a nested class that extends`** _ViewGroup.LayoutParams_. This subclass contains property types that define the **`size`** and **`position`** for each child view, as appropriate for the view group. 
- _**`The parent view group defines layout parameters for each child view (including the child view group).`**_
- _`Note that every LayoutParams subclass has its own syntax for setting values.`_ Each child element must define LayoutParams that are appropriate for its parent, though it may also define different LayoutParams for its own children.
- All view groups include a **width** and **height** `(layout_width and layout_height)`, and each view is required to define them. Many LayoutParams also include optional `margins` and `borders`.

You can specify width and height with exact measurements, though you probably won't want to do this often. More often, you will use one of these constants to set the width or height:

1. **wrap_content**: It tells your view to size itself to the dimensions required by its content.
2. **match_parent**: It tells your view to become as big as its parent view group will allow.
- `In general, specifying a layout width and height using absolute units such as pixels is not recommended.` 
- Instead, using relative measurements such as `density-independent pixel units (dp)`, `wrap_content`, or `match_parent`, is a better approach, because it helps ensure that your app will display properly across a variety of device screen sizes. The accepted measurement types are defined in the [Available Resources](https://developer.android.com/guide/topics/resources/available-resources#dimension) document.

## Layout Position
The geometry of a view is that of a **`rectangle`**. A view has a location, expressed as a pair of _**`left`**_ and _**`top coordinates`**_, and two dimensions, expressed as a **`width`** and a **`height`**. The unit for location and dimensions is the pixel.

It is possible to retrieve the location of a view by invoking the methods _`getLeft()`_ and _`getTop()`_. 
- **_`getLeft()`_**: It returns the left, or X, coordinate of the rectangle representing the view. 
- **_`getTop()`_**: It returns the top, or Y, coordinate of the rectangle representing the view.

## Size, Padding and Margins
**`The size of a view is expressed with a width and a height.`** A view actually possess two pairs of width and height values.

- **Measured Width and Measured Height**: These dimensions define _**`how big a view wants to be within its parent.`**_ The measured dimensions can be obtained by calling _`getMeasuredWidth()`_ and _`getMeasuredHeight()`_.
- **Width and Height**: It is sometimes drawing width and drawing height. These dimensions define the _**`actual size of the view on screen`**_, at drawing time and after layout. These values may, but do not have to, be different from the measured width and height. The width and height can be obtained by calling _`getWidth()`_ and _`getHeight()`_.

- **Padding**: The padding is expressed in pixels for the left, top, right and bottom parts of the view. Padding can be used to offset the content of the view by a specific number of pixels.Padding can be set using the _`setPadding(int, int, int, int)`_ method and queried by calling _`getPaddingLeft()`_, _`getPaddingTop()`_, _`getPaddingRight()`_ and _`getPaddingBottom()`_.

Even though a view can define a padding, it does not provide any support for margins. However, view groups provide such a support. Refer to ViewGroup and ViewGroup.MarginLayoutParams for further information. For more information about dimensions, see [Dimension Values](https://developer.android.com/guide/topics/resources/more-resources#Dimension).

## Common Layouts
Each subclass of _`the ViewGroup class`_ provides a unique way _**`to display the views you nest within it`**_. Below are some of the more common layout types that are built into the Android platform.

    [Note] Although you can nest one or more layouts within another layout to achieve your UI design, you should strive to keep your layout hierarchy as shallow as possible. Your layout draws faster if it has fewer nested layouts (a wide view hierarchy is better than a deep view hierarchy).
1. **Linear Layout**: A layout that organizes its children into a single _**`horizontal`**_ or _**`vertical`**_ row. It creates a scrollbar if the length of the window exceeds the length of the screen.
2. **Relative Layout**: Enables you to specify the location of child objects relative to each other.
3. **Web View**: Displays web pages.

## Building Layouts with an Adapter
- When the content for your layout is _**`dynamic`**_ or _**`not pre-determined`**_, you can use a layout that subclasses **`AdapterView`** to populate the layout with views at _`runtime`_. 
- _**`A subclass of the AdapterView class uses an Adapter to bind data to its layout.`**_ 
- The Adapter behaves as a _**`middleman`**_ between the data source and the AdapterView layout
— The Adapter retrieves the data (from a source such as an array or a database query) and converts each entry into a view that can be added into the AdapterView layout.
1. **List View**: Displays a scrolling single column list.
2. **Grid View**: Displays a scrolling grid of columns and rows.
