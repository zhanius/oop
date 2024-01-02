package main2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class News implements Comparable<News>,Serializable  {
	public String topic;
	public Date publDate;
	public String newsDescription;
	/**
	 * Constructor for news
	 * @param topic
	 * @param publDate
	 * @param newsDescription
	 */
	public News(String topic, Date publDate, String newsDescription) {
		super();
		this.topic = topic;
		this.publDate = publDate;
		this.newsDescription = newsDescription;
	}
	/**
	 * Generate unique hash code for news
	 * @return Objects.hash(newsDescription,publDate,topic)
	 */
	public int hashCode() {
		return Objects.hash(newsDescription, publDate, topic);
	}
	/**
	 * Compare news 
	 * @return true if news are equal by description, publication date and topic
	 * @return false if they are not equal or the compared object is not news
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return Objects.equals(newsDescription, other.newsDescription) && Objects.equals(publDate, other.publDate)
				&& Objects.equals(topic, other.topic);
	}
	
	/**
	 * Display topic, publication date and description of news
	 * @return topic
	 * @return publDate
	 * @return newsDescription
	 */
	public String toString() {
		return "News [topic=" + topic + ", publDate=" + publDate + ", newsDescription=" + newsDescription + "]";
	}
	/**
	 * Compare news by publication date
	 * @return 1 if the news date is before compared news
	 * @return -1 if the news date is after compared news
	 * @return 0 if they are equal
	 */
	@Override
	public int compareTo(News o) {
		if(this.publDate.before(o.publDate)) return 1;
		if(this.publDate.after(o.publDate)) return -1;
		return 0;
	}
	
	
	
}
