package com.rabagel.marian.guardcheckpoint.Login;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import com.rabagel.marian.guardcheckpoint.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {
    ActivityTestRule<LoginActivity> activityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void checkUserNameIsDisplayed(){
        activityActivityTestRule.launchActivity(new Intent());

        onView(withId(R.id.user_name_textBox)).check(matches(isDisplayed()));
    }

    @Test
    public void checkErrorMessageIsDisplayedForEmptyData(){
        activityActivityTestRule.launchActivity(new Intent());

        onView(withId(R.id.login_button)).check(matches(isDisplayed())).perform(click());
        onView(withText(R.string.IncorrectUserError)).check(matches(isDisplayed()));
    }

    @Test
    public void checkLoginSuccessful(){
        activityActivityTestRule.launchActivity(new Intent());
        Context context = InstrumentationRegistry.getTargetContext();

        onView(withId(R.id.user_name_textBox)).perform(typeText(context.getString(R.string.UserName)));
        onView(withId(R.id.password_textBox)).perform(typeText(context.getString(R.string.Password)));
        onView(withId(R.id.login_button)).check(matches(isDisplayed())).perform(click());
        onView(withText(R.string.LoginSuccessfulMessage)).check(matches(isDisplayed()));
    }
}
