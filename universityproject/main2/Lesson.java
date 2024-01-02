package main2;

import java.io.Serializable;
import java.util.*;

public class Lesson implements Serializable  {
	/**
	 * Lesson have type, date, course name, duration, list of attendances of students and students marks
	 */
	public LessonType type;
	public Date lessonDate;
	public Course nameCourse;
	public int duration;
	public Map<Date, HashMap<Student, Boolean>> attendances;
	public HashMap<Student, Mark> marksOfStudent;
	/**
	 * Constructor for lesson
	 * @param type the type that lessons have {@link LessonType}
	 * @param nameCourse course name
	 * @param duration course duration
	 */
	public Lesson(LessonType type, Course nameCourse, int duration) {
		super();
		this.type = type;
		this.nameCourse = nameCourse;
		this.duration = duration;
		this.attendances = new HashMap<>();
	}
	/**
	 * Put mark for certain student
	 * In the first place, method checks if student can attend final - checks sum of first and second attestation and checks for retakes
	 * If student have retake, student will get F for final exam and add +1 to num of retakes of student
	 * In the second place, method using else if statements to determing the grade by formula and puts the grade to student's course
	 * @param m the mark which will be applied to student
	 * @param s the student that will get the mark
	 * @throws Exception if sum of first and second attestation exceed 100 , the method will display message that the grades out of range
	 */
	public void putMark(Mark m, Student s) throws Exception{
		int num = 0;
		if(m.canAttendFinal()) {
			num = (int) (m.getFirstAttestation() + m.getSecondAttestation());
			if(!m.checkRetake()) {
				num += m.getFinalExam();
			}else {
				s.setNumRetake(s.getNumRetake()+1);
				m.setFinalExam(0);
			}
		}else {
			s.setNumRetake(s.getNumRetake()+1);
			m.setFinalExam(0);
		}
			   if(num < 50) {
					   m.setGrade(Grade.F);
			  }else if(50 <= num &&  num <= 54) {
				  m.setGrade(Grade.D);
			  }else if(55 <= num &&  num <= 59) {
				  m.setGrade(Grade.D_PLUS);
			  }else if(60 <= num &&  num <= 64) {
				  m.setGrade(Grade.C_MINUS);
			  }else if(65 <= num &&  num <= 69) {
				  m.setGrade(Grade.C);
			  }else if(70 <= num &&  num <= 74) {
			   m.setGrade(Grade.C_PLUS);
			  }else if(75 <= num &&  num <= 79) {
				  m.setGrade(Grade.B_MINUS);
			  }else if(80 <= num &&  num <= 84) {
				  m.setGrade(Grade.B);
			  }else if(85 <= num &&  num <= 89) {
				  m.setGrade(Grade.B_PLUS);
			  }else if(90 <= num &&  num <= 94) {
				  m.setGrade(Grade.A_MINUS);
			  }else if(95 <= num &&  num <= 100) {
				  m.setGrade(Grade.A);
			  }else if(num < 0 || num > 100) {
				  throw new OutOfGradeException("The grades is out of the range!!!");
			  }
			   
			   
			HashMap<Course, Mark> newMap = s.getCourses();
			newMap.put(this.nameCourse, m);
			s.setCourses(newMap);
	}
	/**
	 * Put attendance for student
	 * @param d the date of attendance
	 * @param s the student
	 * @param b if student is absent  the parameter is false, if student is on the lesson the method will put student to attendances list 
	 */
	public void putAttendance(Date d, Student s, Boolean b) {
		HashMap<Student, Boolean> attendanceForDate = new HashMap<>();
		attendanceForDate.put(s, b);
		attendances.put(d, attendanceForDate);
	}
	
	
	
}
