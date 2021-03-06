/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesReception;

import java.sql.Timestamp;

/**
 *
 * @author fcastillo
 */
public class Details {
    
    private int dtId;
    private int itId;
    private Timestamp dateIn;
    private Timestamp dateOut;
    private String dtReceivedBy;
    private String dtCategory;
    private String dtStatus;
    private String dtRegisterBy;
    private String dtObservation;

    public String getDtObservation() {
        return dtObservation;
    }

    public void setDtObservation(String dtObservation) {
        this.dtObservation = dtObservation;
    }
    
    public Details() {
    }
    
    public Details(int dtId, int itId, Timestamp dateIn, Timestamp dateOut, String dtReceivedBy, String dtCategory, String dtStatus, String dtRegisterBy, String dtObservation) {
        this.dtId = dtId;
        this.itId = itId;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.dtReceivedBy = dtReceivedBy;
        this.dtCategory = dtCategory;
        this.dtStatus = dtStatus;
        this.dtRegisterBy = dtRegisterBy;
        this.dtObservation = dtObservation;
    }

     public String getDtRegisterBy() {
        return dtRegisterBy;
    }

    public void setDtRegisterBy(String dtRegisterBy) {
        this.dtRegisterBy = dtRegisterBy;
    }
    
    public int getDtId() {
        return dtId;
    }

    public void setDtId(int dtId) {
        this.dtId = dtId;
    }

    public int getItId() {
        return itId;
    }

    public void setItId(int itId) {
        this.itId = itId;
    }

    public Timestamp getDateIn() {
        return dateIn;
    }

    public void setDateIn(Timestamp dateIn) {
        this.dateIn = dateIn;
    }

    public Timestamp getDateOut() {
        return dateOut;
    }

    public void setDateOut(Timestamp dateOut) {
        this.dateOut = dateOut;
    }

    public String getDtReceivedBy() {
        return dtReceivedBy;
    }

    public void setDtReceivedBy(String dtReceivedBy) {
        this.dtReceivedBy = dtReceivedBy;
    }

    public String getDtCategory() {
        return dtCategory;
    }

    public void setDtCategory(String dtCategory) {
        this.dtCategory = dtCategory;
    }
    
    public String getDtStatus() {
        return dtStatus;
    }

    public void setDtStatus(String dtStatus) {
        this.dtStatus = dtStatus;
    }
    
        @Override
    public String toString() {
        return "Details{" + "dtId=" + dtId + ", itId=" + itId + ", dateIn=" + dateIn + ", dateOut=" + dateOut + ", dtReceivedBy=" + dtReceivedBy + ", dtCategory=" + dtCategory + '}';
    }
    
    
}
