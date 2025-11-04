package com.example.calculator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

class CalculatorViewModel : ViewModel() {

    private val _equationText = MutableLiveData("")
    val equationText: LiveData<String> = _equationText

    private val _resultText = MutableLiveData("0")
    val resultText: LiveData<String> = _resultText

    fun onButtonClick(btn: String) {
        Log.e("Click Button", btn)

        _equationText.value?.let {
            when (btn) {
                "AC" -> {
                    _equationText.value = ""
                    _resultText.value = "0"
                    return
                }

                "C" -> {
                    if (it.isNotEmpty()) {
                        _equationText.value = it.substring(0, it.length - 1)
                    }
                    return
                }

                "=" -> {
                    _equationText.value = _resultText.value
                    return
                }

                else -> {
                    _equationText.value = it + btn
                }
            }

            // Calculate Result
            try {
                _resultText.value = calculatorResult(_equationText.value.toString())
            } catch (_: Exception) {
                // ignore errors
            }
        }
    }

    private fun calculatorResult(equation: String): String {
        val context = Context.enter()
        context.optimizationLevel = -1
        return try {
            val scriptable: Scriptable = context.initStandardObjects()
            var finalResult = context.evaluateString(scriptable, equation, "JavaScript", 1, null).toString()

            if (finalResult.endsWith(".0")) {
                finalResult = finalResult.replace(".0", "")
            }
            finalResult
        } finally {
            Context.exit()
        }
    }
}
