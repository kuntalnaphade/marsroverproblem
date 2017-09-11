package com.mars.rover;

import com.mars.rover.util.MarsRoverUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MarsRoverUtilTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MarsRoverUtilTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MarsRoverUtilTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
	public void canGetRoverPosition() {
		String dimensions = "5 5";
		String position = "1 2 N";
		String command = "LMLMLMLMM";
		MarsRoverUtil marsRoverUtil = new MarsRoverUtil();
		marsRoverUtil.parseInput(dimensions);
		marsRoverUtil.parseInput(position);
		String actual = marsRoverUtil.parseInput(command);

		String expected = "1 3 N";

		assertEquals(actual, expected);
	}
}
