package org.example.grade.domain;

import java.util.List;

public class Courses {
    private final List<Course> courses;
    //리스트 형태로 된(couseres를 여러개 가진) 정보만 인스턴스 변수로 가지는 클래스 : 일급컬렉션
    //다른 변수가 있으면 안됨

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    // 학점수×교과목 평점
    public double multiplyCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    // 총 이수한 학점
    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
