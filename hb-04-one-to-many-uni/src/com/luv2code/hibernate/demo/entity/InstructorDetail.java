package com.luv2code.hibernate.demo.entity;

import javax.persistence.*;

/**
 * Created by David on 2017-08-12.
 */
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    // annotate this class as an entity and map to db table

    // define the fields and annotate the fields with db column names
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChanel;

    @Column(name = "hobby")
    private String hobby;

    // add a new field for instructor (also add getter/setter)
    // add @OneToOne annotation
    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instructor;

    // create constructors

    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChanel, String hobby) {
        this.youtubeChanel = youtubeChanel;
        this.hobby = hobby;
    }

    // generate getters/setters methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChanel() {
        return youtubeChanel;
    }

    public void setYoutubeChanel(String youtubeChanel) {
        this.youtubeChanel = youtubeChanel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    // generate toString() method for displaying object details

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChanel='" + youtubeChanel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
