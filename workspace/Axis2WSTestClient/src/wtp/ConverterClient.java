package wtp;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import wtp.ConverterStub.CelsiusToFarenheit;
import wtp.ConverterStub.CelsiusToFarenheitResponse;
import wtp.ConverterInchStub.CmToInch;
import wtp.ConverterInchStub.CmToInchResponse;

public class ConverterClient {

        public static void main(String[] args) {
                try {
                        float celsiusValue = 100;
                        ConverterStub stub = new ConverterStub();
                        CelsiusToFarenheit c2f = new CelsiusToFarenheit();
                        c2f.setCelsius(celsiusValue);
                        CelsiusToFarenheitResponse res = stub.celsiusToFarenheit(c2f);
                        System.out.println("Celsius : "+celsiusValue+" = "+"Farenheit : "+res.get_return());
                        
                        float cmValue = 254f;
                        ConverterInchStub ciStub = new ConverterInchStub();
                        CmToInch c2i = new CmToInch();
                        c2i.setCm(cmValue);
                        CmToInchResponse resci = ciStub.cmToInch(c2i);
                        System.out.println("cm : "+cmValue+" = inch : "+resci.get_return());
                        
                } catch (AxisFault e) {
                        e.printStackTrace();
                } catch (RemoteException e) {
                        e.printStackTrace();
                }

        }
}
