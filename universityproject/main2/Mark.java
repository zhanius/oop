package main2;

import java.io.Serializable;

public class Mark implements Serializable {
    private Grade grades;
    private double firstAttestation = 0;
    private double secondAttestation = 0;
    private double finalExam;
    int limit = 7;
    public Mark(){}
    public Mark(double finalExam){
        this.finalExam = finalExam;
    }
    // setters
    /**
     * Set the score for first attestation
     * @param firstAttestation
     */
    public void setFirstAttestation(double firstAttestation){
        this.firstAttestation = firstAttestation;
    }
    /**
     * Set the score for second attestation
     * @param secondAttestation
     */
    public void setSecondAttestation(double secondAttestation){
        this.secondAttestation = secondAttestation;
    }
    /**
     * Set the score for final exam
     * @param finalExam
     */
    public void setFinalExam(double finalExam){
        this.finalExam = finalExam;
    }
    //getters
    /**
     * Get score of first attestation
     * @return firstAttestation
     */
    public double getFirstAttestation(){
        return this.firstAttestation;
    }
    /**
     * Get score of second attestation
     * @return secondAttestation
     */
    public double getSecondAttestation(){
        return this.secondAttestation;
    }
    /**
     * Get score of final exam
     * @return finalEXam
     */
    public double getFinalExam(){
        return this.finalExam;
    }
    /**
     * Set the grade for attestations and exam
     * @param g grade
     */
    public void setGrade(Grade g) {
        this.grades = g;
    }
    /**
     * Get the grades
     * @return grades
     */
    public Grade getGrade() {
        return grades;
    }
    /**
     * Check if student can attend on final
     * @return true if total score of first and second attestation exceeds or equal 30 
     * @return false if total score of first and second attestation is lower than 30 
     */
    public boolean canAttendFinal() {
        if(this.firstAttestation + this.secondAttestation >= 30) {
            return true;
        }
        return false;
    }
    /**
     * Add up to 7 points to first or second attestation 
     * @param point
     */
    public void addPoint(double point){
        if(limit != 0) {
            this.firstAttestation += point;
            limit -= 1;
        }
        else this.secondAttestation += point;
    }
    /**
     * Put grade for student
     * @param student
     */
    public void putGrade(Student student){}
    /**
     * Check retake possibility of student 
     * @return true if student can't attend on the final
     * @return true if final exam is lower than 20
     * @return false if student can attend final and have final score more than 20
     */
    public boolean checkRetake(){
        if(!canAttendFinal()) {
            return true;
        }
        if(this.finalExam < 20) {
            return true;
        }
        return false;
    }
    /**
     * Displays grades for 1st,2nd attestation and the final exam
     * @return grades
     * @return firstAttestation
     * @return secondAttestation
     * @return finalExam
     */
    @Override
    public String toString() {
        return "Mark [grades=" + grades + ", firstAttestation=" + firstAttestation + ", secondAttestation="
                + secondAttestation + ", finalExam=" + finalExam + "]";
    }


}
