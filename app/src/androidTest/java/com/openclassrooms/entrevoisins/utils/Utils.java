package com.openclassrooms.entrevoisins.utils;

import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Matcher;

public class Utils {public static String getText(ViewInteraction matcher) {
    final String[] text = new String[1];

    matcher.perform(new ViewAction()  {
        @Override
        public Matcher<View> getConstraints() {
            return isAssignableFrom( TextView.class );
        }

        @Override
        public String getDescription() {
            return "Text of the view";
        }

        @Override
        public void perform(UiController uiController, View view) {
            TextView tv = (TextView) view;
            text[0] = tv.getText().toString();
        }
    });

    return text[0];
}

}
