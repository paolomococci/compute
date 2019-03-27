/**
 *
 * Copyright 2019 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.compute

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import local.example.compute.R.id.*
import local.example.compute.R.layout.activity_main

class MainActivity : AppCompatActivity() {
    private var compute: Compute? = null
    private var operandOne: EditText? = null
    private var operandTwo: EditText? = null
    private var resultView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        compute = Compute()
        resultView = findViewById(operation_result_text_view)
        operandOne = findViewById(operand_one_edit_text)
        operandTwo = findViewById(operand_two_edit_text)
    }

    fun onAdd(view: View) {
        getResult(Compute.Operator.ADD)
    }

    fun onSub(view: View) {
        getResult(Compute.Operator.SUB)
    }

    fun onDiv(view: View) {
        getResult(Compute.Operator.DIV)
    }

    fun onMul(view: View) {
        getResult(Compute.Operator.MUL)
    }

    private fun getResult(operator: Compute.Operator) {
        var opOne = 0.0
        var opTwo = 0.0
        try {
            opOne = getOperand(operandOne)
            opTwo = getOperand(operandTwo)
        } catch (nfe: NumberFormatException) {
            Log.e(TAG, "NumberFormatException", nfe)
            resultView!!.text = getString(R.string.computation_error)
        }

        var result = ""
        when (operator) {
            Compute.Operator.ADD -> result = compute!!.add(opOne, opTwo).toString()
            Compute.Operator.SUB -> result = compute!!.sub(opOne, opTwo).toString()
            Compute.Operator.DIV -> result = compute!!.div(opOne, opTwo).toString()
            Compute.Operator.MUL -> result = compute!!.mul(opOne, opTwo).toString()
            else -> {
            }
        }
        resultView!!.text = result
    }

    companion object {

        private val TAG = "CalculatorActivity"

        private fun getOperand(operandEditText: EditText?): Double {
            val operandText = getOperandText(operandEditText!!)
            return java.lang.Double.valueOf(operandText)
        }

        private fun getOperandText(operandEditText: EditText): String {
            return operandEditText.text.toString()
        }
    }
}
