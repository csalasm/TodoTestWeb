/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controller.DoTestServlet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author csalas
 */
public class Chronometer {
    private static Thread chrono;
    private static int testTime;
    private static boolean noTime = false;
    
    
    public static int getTime() {
        if (noTime == true)
            return 1;
        
        return testTime;
    }
    
    public static void stopChronometer() {
        try {
            if (chrono != null)
                chrono.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Chronometer.class.getName()).log(Level.SEVERE, null, ex);
        }
        chrono = null;
        noTime = false;
    }
    
    public static void setTestWithoutTime(boolean time) {
        noTime = time;
    }
    
    public static void startChronometer(int time) {
        if (noTime)
            return;
        
        if (chrono == null) {
            testTime = time;
            chrono = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (testTime > 0) {
                            Thread.sleep(1000);
                            testTime--;
                            
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DoTestServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            chrono.start();
        }
    }
}
