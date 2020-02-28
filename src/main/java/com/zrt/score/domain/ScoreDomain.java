package com.zrt.score.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class ScoreDomain {

    @Id//主键
    @GeneratedValue//自增
    private Integer stuNo;
    @NotNull
    private String stuName;
    @NotNull
    private String stuClass;
    @NotNull
    private String stuType;
    @NotNull
    @Min(value = 0,message = "成绩不能小于0")
    @Max(value = 100,message = "成绩不能大于100")
    private String stuScore;

    public Integer getStuNo() {
        return stuNo;
    }

    public void setStuNo(Integer stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuType() {
        return stuType;
    }

    public void setStuType(String stuType) {
        this.stuType = stuType;
    }

    public String getStuScore() {
        return stuScore;
    }

    public void setStuScore(String stuScore) {
        this.stuScore = stuScore;
    }

    public ScoreDomain() {
    }
}
