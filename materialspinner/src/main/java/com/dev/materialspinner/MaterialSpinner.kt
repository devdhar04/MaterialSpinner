package com.dev.materialspinner

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class MaterialSpinner(context: Context, attr: AttributeSet) : LinearLayout(context, attr) {

    init {
        initializeViews(context, attr)
    }

    private lateinit var errorTextView: TextView
    private lateinit var spinner: Spinner
    private lateinit var mLabel: TextView
    private lateinit var spinnerLayout: LinearLayout

    private fun initializeViews(context: Context, attr: AttributeSet) {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.material_custom_spinner, this, true)

        orientation = LinearLayout.VERTICAL
        layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val typedArray = context.obtainStyledAttributes(attr, R.styleable.CustomSpinner, 0, 0)
        val labelText = typedArray.getString(R.styleable.CustomSpinner_labelText)

        typedArray.recycle()

        spinnerLayout = findViewById(R.id.spinner_layout)

        errorTextView = findViewById(R.id.error);

        spinner = findViewById(R.id.spinner);

        mLabel = findViewById(R.id.label);


        if (labelText == null) {
            mLabel.visibility = View.GONE
        } else {
            mLabel.text = labelText
            mLabel.visibility = View.VISIBLE
        }
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
            spinnerLayout.setBackgroundResource(R.drawable.payment_edit_error_bg)

        } else {
            errorTextView.visibility = View.INVISIBLE
            spinnerLayout.setBackgroundResource(R.drawable.payment_edit_bg)
        }
    }

    fun setErrorEnabled(isErrorEnabled: Boolean) {
        if (isErrorEnabled) {
            spinnerLayout.setBackgroundResource(R.drawable.payment_edit_error_bg)
            errorTextView.visibility = View.VISIBLE

        } else {
            errorTextView.visibility = View.INVISIBLE
            spinnerLayout.setBackgroundResource(R.drawable.payment_edit_bg)
        }
    }
}
