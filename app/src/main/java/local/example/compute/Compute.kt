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

import java.math.BigDecimal
import java.math.RoundingMode

class Compute {

    enum class Operator {
        ADD, SUB, DIV, MUL
    }

    fun add(firstOperand: Double, secondOperand: Double): Double {
        return round(firstOperand + secondOperand)
    }

    fun sub(firstOperand: Double, secondOperand: Double): Double {
        return round(firstOperand - secondOperand)
    }

    fun div(firstOperand: Double, secondOperand: Double): Double {
        var quotient = 0.0
        quotient = firstOperand / secondOperand
        return if (java.lang.Double.isInfinite(quotient) || java.lang.Double.isNaN(quotient)) {
            java.lang.Double.NaN
        } else round(quotient)
    }

    fun mul(firstOperand: Double, secondOperand: Double): Double {
        return round(firstOperand * secondOperand)
    }

    private fun round(num: Double): Double {
        val temp = BigDecimal(num)
        return temp.setScale(6, RoundingMode.HALF_UP).toDouble()
    }
}
