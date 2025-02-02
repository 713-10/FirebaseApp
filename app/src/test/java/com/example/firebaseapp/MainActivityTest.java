package com.example.firebaseapp;

import android.content.Intent;
import android.widget.Button;

import androidx.test.core.app.ActivityScenario;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {28, 30}, manifest = Config.NONE) // Avoid manifest requirement for testing
public class MainActivityTest {

    @Before
    public void setUp() {
        // Initialize anything if needed, for now no Firebase setup required
    }

    @Test
    public void testButtonClick_NavigatesToSaveDataActivity() {
        // Launch the MainActivity and check for navigation
        ActivityScenario.launch(MainActivity.class).onActivity(activity -> {
            Button navigateButton = activity.findViewById(R.id.navigateButton);
            assertNotNull("Button should not be null", navigateButton);
            navigateButton.performClick();

            // Check the intent after button click
            Intent expectedIntent = new Intent(activity, SaveDataActivity.class);
            Intent actualIntent = activity.getIntent();

            assertNotNull("Intent should not be null", actualIntent);
            assertEquals("Intent should navigate to SaveDataActivity", expectedIntent.getComponent(), actualIntent.getComponent());
        });
    }
}
