package com.example.bhavanas.roboelectricandroidtesting.Test;

/**
 * Created by bhavana.s on 2/10/2016.
 */

import com.example.bhavanas.roboelectricandroidtesting.BuildConfig;
import com.example.bhavanas.roboelectricandroidtesting.RoboelectricActivity;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.android.api.Assertions.assertThat;


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RoboelectricActivityTest {

    private RoboelectricActivity mActivity;

    @Before
    public void setup() {
        mActivity = Robolectric.buildActivity(RoboelectricActivity.class).create().get();
    }

    @Test
    public void myActivityAppearsAsExpectedInitially() {
        assertThat(mActivity.mClickMeButton).hasText("Click me!");
        assertThat(mActivity.mHelloWorldTextView).hasText("Hello world!");
    }

    @Test
    public void clickingClickMeButtonChangesHelloWorldText() {
        assertThat(mActivity.mHelloWorldTextView).hasText("Hello world!");
        mActivity.mClickMeButton.performClick();
        assertThat(mActivity.mHelloWorldTextView).hasText("HEY WORLD");
    }


    @Test
    public void testClickAddButton_withPositiveValues() {

        mActivity.getFirstNumber().setText("1");
        mActivity.getSecondNumber().setText("2");
        mActivity.getAddButton().performClick();
        Assert.assertEquals("3", mActivity.getTotal().getText().toString());



    }



}