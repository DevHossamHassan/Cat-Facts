package com.letsgotoperfection.cat_facts;

/**
 * @author hossam.
 */

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.xw.repo.BubbleSeekBar;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Tests for the catFacts screen, the main screen which contains a list of all catFacts.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class CatFactsListScreenTest {
    /**
     * {@link ActivityTestRule} is a JUnit {@link Rule @Rule} to launch your activity under test.
     * <p>
     * <p>
     * Rules are interceptors which are executed for each test method and are important building
     * blocks of Junit tests.
     */
    @Rule
    public ActivityTestRule<MainActivity> catFactsMainActivity =
            new ActivityTestRule<>(MainActivity.class);


    /**
     * This method helps to use the bubbleSeekBar to set Progress
     *
     * @param progress
     * @return
     */
    public static ViewAction setProgress(final int progress) {
        return new ViewAction() {
            @Override
            public void perform(UiController uiController, View view) {
                BubbleSeekBar seekBar = (BubbleSeekBar) view;
                seekBar.setProgress(progress);
            }

            @Override
            public String getDescription() {
                return "Set a progress on a SeekBar";
            }

            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(BubbleSeekBar.class);
            }
        };
    }

    @Test
    public void SeekTheSeekBar_showsListOfCatFacts() throws Exception {
        // drag on the seekBar to fetch catFacts from the server
        onView(withId(R.id.bubbleSeekBar)).perform(setProgress(100));

        // Check if the add note screen is displayed
        onView(withId(R.id.recyclerViewCatFacts)).check(matches(isDisplayed()));
    }
}
