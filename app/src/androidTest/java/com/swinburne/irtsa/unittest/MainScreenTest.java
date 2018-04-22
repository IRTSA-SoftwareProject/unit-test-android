package com.swinburne.irtsa.unittest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Lionel on 4/22/2018.
 */

//Annotation to specify that we will be running AndrpodJUnit4 tests that will run
// using the AndroidJUnit4 runner
@RunWith(AndroidJUnit4.class)
public class MainScreenTest {

    //Specify a rule for this test class that ensures MainActivity is run before the tests
    //specified in this class are run. This activity test rule destroys the activity once all
    //tests have completed
    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    //Here we declare a test to assert a button press changes the TextView.
    //Naming convention for test methods are: <UI element targeted>_<expected UI action>
    @Test
    public void clickChangeTextButton_changesTextView() throws Exception{
        //Perform the click action on our change text action.
        onView(withId(R.id.changeTextButton))
                .perform(click());
        //Assert our TextView contains the correct text.
        onView(withId(R.id.textToChange))
                .check(matches(withText("You pressed the button!")));
    }

    //Here we declare a test to check if the button that inserts the colour fragment actually
    //inserts the fragment.
    @Test
    public void clickInsertColourFragmentButton_insertsColourFragment() throws Exception{
        //Perform a click on the button that inserts the fragment
        onView(withId(R.id.insertFragmentButton))
                .perform(click());

        //Check if a view exists in the view heirarchy with text: "Fragment showing colour green."
        onView(withText("Fragment showing colour green."))
                .check(matches(isDisplayed()));
    }
}
