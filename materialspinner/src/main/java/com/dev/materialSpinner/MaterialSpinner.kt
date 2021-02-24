package com.dev.materialSpinner

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MaterialSpinner(context: Context, attr: AttributeSet) : LinearLayout(context, attr) {

    private lateinit var errorTextView: TextView
    private lateinit var spinner: Spinner
    private lateinit var mLabel: TextView
    private lateinit var spinnerLayout: LinearLayout
    private lateinit var errorBorderBg : Drawable
    private var errorTextColor: Int = 0

    init {
        initializeViews(context, attr)
    }

    private fun initializeViews(context: Context, attr: AttributeSet) {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.material_custom_spinner, this, true)

        orientation = VERTICAL
        layoutParams = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val typedArray = context.obtainStyledAttributes(attr, R.styleable.MaterialSpinner, 0, 0)
        val labelText = typedArray.getString(R.styleable.MaterialSpinner_labelText)
        errorBorderBg = typedArray.getDrawable(R.styleable.MaterialSpinner_errorBorderDrawable)
        errorTextColor = typedArray.getColor(R.styleable.MaterialSpinner_errorTextColor,
            ContextCompat.getColor(context, R.color.faded_orange))

        typedArray.recycle()

        spinnerLayout = findViewById(R.id.spinner_layout)

        errorTextView = findViewById(R.id.error)

        spinner = findViewById(R.id.spinner)

        mLabel = findViewById(R.id.label)

        if (labelText == null) {
            mLabel.visibility = View.GONE
        } else {
            mLabel.text = labelText
            mLabel.visibility = View.VISIBLE
        }
        setErrorBorder(errorBorderBg = errorBorderBg)
        setErrorTextColor(errorTextColor)
    }

    fun getSpinner(): Spinner {
        return spinner
    }

    fun setItemSelectedListener(onItemSelectedListener: AdapterView.OnItemSelectedListener) {
        spinner.onItemSelectedListener = onItemSelectedListener
    }

    fun setAdapter(adapter: SpinnerAdapter) {
        spinner.adapter = adapter
    }

    fun setLabel(labelText: String) {
        if (labelText.isEmpty()) {
            mLabel.visibility = View.GONE
        } else {
            mLabel.text = labelText
            mLabel.visibility = View.VISIBLE
        }
    }

    fun setError(error: String) {
        if (error.trim().isNotEmpty()) {

            errorTextView.visibility = View.VISIBLE
            errorTextView.text = error
            spinnerLayout.background = errorBorderBg

        } else {
            errorTextView.visibility = View.INVISIBLE
            spinnerLayout.setBackgroundResource(R.drawable.payment_edit_bg)
        }
    }

    fun setErrorTextColor(@ColorInt errorTextColor : Int){
        errorTextView.setTextColor(errorTextColor)
    }

    fun setErrorBorder(errorBorderBg : Drawable){
        this.errorBorderBg = errorBorderBg
        spinnerLayout.background = errorBorderBg
    }

    fun setErrorEnabled(isErrorEnabled: Boolean) {
        if (isErrorEnabled) {
            spinnerLayout.background = errorBorderBg
            errorTextView.visibility = View.VISIBLE

        } else {
            errorTextView.visibility = View.INVISIBLE
            spinnerLayout.setBackgroundResource(R.drawable.payment_edit_bg)
        }
    }
}
