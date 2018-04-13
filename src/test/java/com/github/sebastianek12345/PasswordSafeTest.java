package com.github.sebastianek12345;

import com.github.sebastianek12345.model.PasswordSafe;
import org.junit.Assert;
import org.junit.Test;

public class PasswordSafeTest {

    @Test

    public void whenAddingPasswordSafe_WhenAddingEntry_ThenEntryShouldAdd() {
        //given
        PasswordSafe passwordSafe = new PasswordSafe();

        //when
        passwordSafe.addEntries("super", "duper", "extra");

        //then
        Assert.assertTrue(passwordSafe.exists("super","duper"));
    }

    @Test

    public void giveSafeWithServiceUserEntry() {
        //given
        PasswordSafe passwordSafe = new PasswordSafe();

        //when
        passwordSafe.addEntries("service", "user", "143");

        //then
        try {
            passwordSafe.addEntries("service", "user", "143");
            Assert.fail();
        } catch (RuntimeException e) {
        }
    }

    @ Test

    public void whenAddingPasswordName_ThenEntryShouldShow(){
        //given
        PasswordSafe passwordSafe = new PasswordSafe();

        //when
        passwordSafe.addEntries("swojksi","super","twoja");

        //then
        Assert.assertEquals("twoja",passwordSafe.show("swojksi"));
    }
}
