package edu.uns.sgsi.ejb;

import java.util.Calendar;
import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class ServerTimer {

    @EJB
    private ServerLocal servidor;

//    @Timeout
//    @AccessTimeout(value =4, unit = TimeUnit.HOURS)
//
//    @Schedule(minute = "*/1", second = "*/10", hour = "*", persistent = false)
    public void doWork() {
        Calendar c=Calendar.getInstance();
        int d[]={1,2,3,4,5,6,7};
        int h=19;
        boolean es=false;
        for(int dd:d){
            if(c.get(Calendar.DAY_OF_WEEK)==dd){
                es=true;
                break;
            }
        }
        if(es&&c.get(Calendar.HOUR_OF_DAY)>h){
            servidor.doBackup();
        }
    }

}
