/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LogPhaseListener implements PhaseListener {
 
    public long startTime;
 
    @Override
    public void afterPhase(PhaseEvent event) {
//        if (event.getPhaseId() == PhaseId.RENDER_RESPONSE) {
//            long endTime = System.nanoTime();
//            long diffMs = (long) ((endTime - startTime) * 0.000001);
////            if (log.isDebugEnabled()) {
//                System.out.println("Execution Time = " + diffMs + "ms");
////            }
//        }
//        if (log.isDebugEnabled()) {
        System.out.println("    AFTER PHASE=" + event.getPhaseId());
        if(event.getPhaseId().getOrdinal()==6){
            JPA.getInstance().close();
        }
//            log.debug();
//        }
    }
 
    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("BEFORE PHASE="+event.getPhaseId());
        if (event.getPhaseId() == PhaseId.RESTORE_VIEW) {
            startTime = System.nanoTime();
        }
    }
 
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
 
    
}