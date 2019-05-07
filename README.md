# MaterialSpinner
A Simple Material Spinner
 

## Installation
Add it in your root build.gradle at the end of repositories:
```bash
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Add it in your root build.gradle at the end of repositories:
```bash
dependencies 
        {
	         implementation'com.github.devdhar04:MaterialSpinner:v0.1.2'
	}
```

 

## Usage

```<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_behavior="@string/appbar_scrolling_view_behavior"
        tools:showIn="@layout/activity_main"
        tools:context=".activity.MainActivity">



    <com.dev.materialspinner.MaterialSpinner
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="@dimen/dp_10"
            android:id="@+id/material_spinner"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent">

    </com.dev.materialspinner.MaterialSpinner>

</android.support.constraint.ConstraintLayout>
```

Set adapter to Spinner
```bash
var list_of_items = arrayOf("Select Country","USA", "Japan", "India")
var spinner = findViewById(R.id.material_spinner)
spinner.getSpinner().onItemSelectedListener = this

// Create an ArrayAdapter using a simple spinner layout and languages array
val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_items)
// Set layout to use when the list of choices appear
aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
// Set Adapter to Spinner
spinner!!.setAdapter(aa)

```

Set Error in Spinner
```bash
spinner.setError("Please select Country")
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
