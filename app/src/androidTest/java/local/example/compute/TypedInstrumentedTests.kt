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

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import local.example.compute.R.id.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TypedInstrumentedTests {

    /* remember to switch on the screen on testing device */

    @get:Rule var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun operandOneIsDisplayedTest() {
        onView(withId(operand_one)).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun operandTwoIsDisplayedTest() {
        onView(withId(operand_two)).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun addTest() {
        onView(withId(operand_one)).perform(
            clearText(),
            typeText((-2.5).toString()),
            closeSoftKeyboard()
        )
        onView(withId(operand_two)).perform(
            clearText(),
            typeText(3.6.toString()),
            closeSoftKeyboard()
        )
        onView(withId(button_add)).perform(click())
        onView(withId(R.id.operation_result)).check(ViewAssertions.matches(ViewMatchers.withText(1.1.toString())))
    }

    @Test
    fun subTest() {
        onView(withId(operand_one)).perform(
            clearText(),
            typeText((-2.5).toString()),
            closeSoftKeyboard()
        )
        onView(withId(operand_two)).perform(
            clearText(),
            typeText(3.6.toString()),
            closeSoftKeyboard()
        )
        onView(withId(button_sub)).perform(click())
        onView(withId(R.id.operation_result)).check(ViewAssertions.matches(ViewMatchers.withText((-6.1).toString())))
    }

    @Test
    fun divTest() {
        onView(withId(operand_one)).perform(
            clearText(),
            typeText((-2.5).toString()),
            closeSoftKeyboard()
        )
        onView(withId(operand_two)).perform(
            clearText(),
            typeText(3.6.toString()),
            closeSoftKeyboard()
        )
        onView(withId(button_div)).perform(click())
        onView(withId(R.id.operation_result)).check(ViewAssertions.matches(ViewMatchers.withText((-0.694444).toString())))
    }

    @Test
    fun mulTest() {
        onView(withId(operand_one)).perform(
            clearText(),
            typeText((-2.5).toString()),
            closeSoftKeyboard()
        )
        onView(withId(operand_two)).perform(
            clearText(),
            typeText(3.6.toString()),
            closeSoftKeyboard()
        )
        onView(withId(button_mul)).perform(click())
        onView(withId(R.id.operation_result)).check(ViewAssertions.matches(ViewMatchers.withText((-9.0).toString())))
    }
}
