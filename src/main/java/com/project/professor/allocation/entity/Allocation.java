package com.project.professor.allocation.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.DayOfWeek;
import java.util.Date;
import javax.persistence.*;


@Entity
public class Allocation {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DayOfWeek day;

    @ApiModelProperty(example = "10:00-0300")
    @JsonFormat(pattern = "HH:mmZ")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date start;

    @ApiModelProperty(example = "10:00-0300")
    @JsonFormat(pattern = "HH:mmZ")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date end;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "professor_id", nullable = false)
    private Long professorId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false, updatable = false , insertable = false)
    private Course course;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(optional = false)
    @JoinColumn(name = "professor_id", nullable = false, updatable = false, insertable = false )
    private Professor professor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


    @Override
    public String toString() {
        return "Allocation{" +
                "id=" + id +
                ", day=" + day +
                ", start=" + start +
                ", end=" + end +
                ", courseId=" + courseId +
                ", professorId=" + professorId +
                ", course=" + course +
                ", professor=" + professor +
                '}';
    }
}
