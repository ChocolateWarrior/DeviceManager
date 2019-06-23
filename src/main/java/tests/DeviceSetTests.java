package tests;

import com.helvetica.Model.*;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class DeviceSetTests {


    private DeviceSet deviceSet;
    private int bottomLimit;
    private int topLimit;
    private int expectedFlatPower;


    @Before
    public  void initDeviceSet(){
        deviceSet = DeviceSet.AVERAGE_FLAT;
        bottomLimit = 100;
        topLimit = 300;
        expectedFlatPower = 3130;
    }

    @After
    public void clearDeviceSet(){
        deviceSet = null;
    }

    @Test
    public void calculatePowerTest(){
        int calculatedPower = deviceSet.calculatePower();
        int expected = expectedFlatPower;
        Assert.assertEquals(calculatedPower, expected);
    }

    @Test
    public void findDevicesByRangeTest(){
        ArrayList <Device> deviceArray = deviceSet.findDevicesByRange(bottomLimit,topLimit);
        for(Device d : deviceArray){
            Assert.assertTrue(d.getPower() <= bottomLimit && d.getPower() >= topLimit);
        }
    }

    @Test
    public void sortByPowerTest(){
        deviceSet.sortByPower();
        int nextPower = 0;
        for (Device d : deviceSet.getListOfDevices()) {
            Assert.assertTrue(d.getPower() > nextPower);
            nextPower = d.getPower();
        }
    }


}
