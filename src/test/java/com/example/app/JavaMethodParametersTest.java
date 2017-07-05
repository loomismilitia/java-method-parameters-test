package com.example.app;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for java core method parameters.
 *
 * @author loomismilitia
 */
public class JavaMethodParametersTest {

    @Test
    public void testChangeStringParameter() throws Exception {

        String parameter = "This is a parameter value.";
        String changedParameter = this.changeStringParameter(parameter);

        Assert.assertTrue(!parameter.equalsIgnoreCase(changedParameter));
        System.out.println("Parameter: " + parameter);
        System.out.println("Changed Parameter: " + changedParameter);
    }

    @Test
    public void testChangeIntParameter() throws Exception {

        int parameter = 1;
        int changedParameter = this.changeIntParameter(parameter);

        Assert.assertTrue(parameter != changedParameter);
        System.out.println("Parameter: " + parameter);
        System.out.println("Changed Parameter: " + changedParameter);
    }

    @Test
    public void testChangeIntegerParameter() throws Exception {

        Integer parameter = 1;
        Integer changedParameter = this.changeIntegerParameter(parameter);

        Assert.assertTrue(!parameter.equals(changedParameter));
        System.out.println("Parameter: " + parameter);
        System.out.println("Changed Parameter: " + changedParameter);
    }

    @Test
    public void testChangeIntegerParameterNoReturn() throws Exception {

        Integer parameter = 1;
        int newValue = 2;

        this.changeIntegerParameterNoReturn(parameter, newValue);

        Assert.assertTrue(!parameter.equals(newValue));
        System.out.println("Parameter: " + parameter);
        System.out.println("Changed Parameter: " + newValue);
    }

    @Test
    public void testChangeClassLocalVariable() throws Exception {

        String initialValue = "This is the initial value.";
        String newValue = "This is the new value.";
        SampleClass sampleClass = new SampleClass();
        sampleClass.setLocalVariable(initialValue);
        this.changeClassLocalVariable(sampleClass, newValue);

        Assert.assertTrue(sampleClass.getLocalVariable().equals(newValue));
        System.out.println("Initial value: " + initialValue);
        System.out.println("Final value: " + newValue);
    }


    private String changeStringParameter(String parameter){
        //the passed parameter is not changed outside of the method
        parameter = "This is a parameter value changed.";
        return parameter;
    }

    private int changeIntParameter(int parameter){
        //the passed parameter is not changed outside of the method
        parameter = 2;
        return parameter;
    }

    private Integer changeIntegerParameter(Integer parameter){
        //JVM here creates a new reference hence the passed parameter is not changed outside of the method.
        parameter = 2;
        return parameter;
    }

    private void changeIntegerParameterNoReturn(Integer parameter, int newValue){
        //JVM here creates a new reference hence the passed parameter is not changed outside of the method.
        parameter = newValue;
    }

    private void changeClassLocalVariable(SampleClass sampleClass, String newValue){
        sampleClass.setLocalVariable(newValue);
    }

    class SampleClass {

        private String localVariable;

        String getLocalVariable() {
            return localVariable;
        }

        void setLocalVariable(String localVariable) {
            this.localVariable = localVariable;
        }
    }
}
