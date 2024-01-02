package main2;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Transcript implements Serializable {
	HashMap <Student,Mark> transcript;
	/**
	 * Get transcript of certain student
	 * @return transcript
	 */
	public HashMap<Student,Mark> getTranscript(){
		return this.transcript;
	}
}
