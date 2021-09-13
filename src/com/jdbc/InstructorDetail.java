package com.jdbc;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //java bean 
@Table(name = "instructor_detail")   // table name 
public class InstructorDetail {
	//annotate  the class as an entity and map to db  table
	//define the fields 
	//annotate the fields  with db coloumn nams
	//create constructor 
	////generate getter and setters
	//generate toString(method)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="youtube_channel")
	private String youtubeChannel;
	@Column(name ="hobby")
	private String  hobby;
	//add new field for instructor (also getter/setters)
	//add @oneTOone annotations
	//mappedBy >tell the hibernate to check the relationship in Instructor table for join
	//mappedBy used to make bidirection relationship in both table.
	//That mean if i want to retrieve the record of Instructor table from Instructor detail table so i can 
	//In unidirectinal this is one way steet. If i want to get details of Instructor detail table i need to go through 
	//Intructor  table 
	@OneToOne(mappedBy="instructorDetail", //refer instructot detailedview in Instructor class to check relation
			cascade= {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST, CascadeType.REFRESH})
	private Instructor instructor;
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public InstructorDetail()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYoutubeChannel() {
		return youtubeChannel;
	}
	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	}
