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

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import org.junit.Assert.assertEquals

@RunWith(JUnit4::class)
class ComputeTests {

    private var compute: Compute? = null

    @Before
    fun init() {
        compute = Compute()
    }

    @Test
    fun addTest() {
        val result = compute!!.add(2.0, 2.0)
        assertEquals(result, 4.0, 0.0)
    }

    @Test
    fun subTest() {
        val result = compute!!.sub(4.0, 2.5)
        assertEquals(result, 1.5, 0.0)
    }

    @Test
    fun divZeroTest() {
        val result = compute!!.div(1.0, 0.0)
        assertEquals(result, java.lang.Double.NaN, 0.0)
    }

    @Test
    fun divTest() {
        val result = compute!!.div(6.0, 3.0)
        assertEquals(result, 2.0, 0.0)
    }

    @Test
    fun mulTest() {
        val result = compute!!.mul(3.0, 4.0)
        assertEquals(result, 12.0, 0.0)
    }
}
