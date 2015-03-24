/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprogclasses;

/**
 *
 * @author Kevin
 */
public class LogInfo {
    
    private String numSessions;
    private String[] filepath;
    private String[] sessionIds;

   
    public String getNumSessions() {
        return numSessions;
    }

    public void setNumSessions(String numSessions) {
        this.numSessions = numSessions;
    }

    /**
     * @return the filepath
     */
    public String[] getFilepath() {
        return filepath;
    }

    /**
     * @param filepath the filepath to set
     */
    public void setFilepath(String[] filepath) {
        this.filepath = filepath;
    }

    /**
     * @return the sessionIds
     */
    public String[] getSessionIds() {
        return sessionIds;
    }

    /**
     * @param sessionIds the sessionIds to set
     */
    public void setSessionIds(String[] sessionIds) {
        this.sessionIds = sessionIds;
    }
}
