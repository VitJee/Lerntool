/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.vithushan.lerntool;

/**
 *
 * @author Vithushan Jeevanantham
 */
public class Satz {

    private String originalSprache;
    private String fremdSprache;

    public Satz(String originalSprache, String fremdSprache) {
        this.originalSprache = originalSprache;
        this.fremdSprache = fremdSprache;
    }

    public String getOriginalSprache() {
        return originalSprache;
    }

    public void setOriginalSprache(String originalSprache) {
        this.originalSprache = originalSprache;
    }

    public String getFremdSprache() {
        return fremdSprache;
    }

    public void setFremdSprache(String fremdSprache) {
        this.fremdSprache = fremdSprache;
    }
}
