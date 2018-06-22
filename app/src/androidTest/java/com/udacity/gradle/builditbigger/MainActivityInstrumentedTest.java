package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    private static final String TAG = MainActivityInstrumentedTest.class.getSimpleName();
    @Rule
    public ActivityTestRule<MainActivity> mRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void executeAsyncTask_returnsNonEmptyString() {
        try {
            String result = mRule.getActivity().new EndpointsAsyncTask(mRule.getActivity()).execute().get();

            Log.i(TAG, result);

            Assert.assertNotNull(result);
            Assert.assertTrue(! result.isEmpty());
        } catch (InterruptedException e) {
            Log.e(TAG, e.getMessage());
        } catch (ExecutionException e) {
            Log.e(TAG, e.getMessage());
        }
    }
}
