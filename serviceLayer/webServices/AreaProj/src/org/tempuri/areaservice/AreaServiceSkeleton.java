
/**
 * AreaServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
    package org.tempuri.areaservice;
    /**
     *  AreaServiceSkeleton java skeleton for the axisService
     */
    public class AreaServiceSkeleton{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param parameters
         */
        
                 public org.tempuri.areaservice.Area CalculateRectArea
                  (
                  org.tempuri.areaservice.Parameters parameters
                  )
            {
                try {
                	System.out.println("test");
					Area area = new Area();
					area.setArea(parameters.getParameters().getWidth() * parameters.getParameters().getHeight());
					return area;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#CalculateRectArea");
				}
        }
     
    }
    