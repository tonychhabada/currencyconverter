package com.currencyconverter

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.currencyconverter.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
public class UITestCase {


    @Rule var activityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun getCountryDetails(){
//        onView(withId(R.id.txtSearch)).perform(typeText("IN"))
//        onView(withId(R.id.btnSearch)).perform(click())

    }
}