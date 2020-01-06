package com.cschua.androidpaginglibrary;

import android.content.Context;
import android.os.Looper;

import com.cschua.androidpaginglibrary.model.remote.User;
import com.cschua.androidpaginglibrary.repository.UserDataSourceFactory;

import org.junit.Before;
import org.junit.Test;

import androidx.paging.DataSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    //@Mock
    //private UserDataSourceFactory userDataSourceFactory;
    private Looper mLooper;

    @Before
    public void setup() {
        mLooper = mock(Looper.class);
        Context ctx = mock(Context.class);
        when(ctx.getMainLooper()).thenReturn(mLooper);
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testUserDataSourceFactoryCreate() {
        UserDataSourceFactory userDataSourceFactory = new UserDataSourceFactory();
        DataSource<Long, User> dataSource = userDataSourceFactory.create();
        assertNotNull(dataSource);
    }
}