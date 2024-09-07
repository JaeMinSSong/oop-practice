package org.example.grade.domain;

public class GradeCalculator {
    private final Courses courses;

    public GradeCalculator(Courses courses) {
        this.courses = courses;
    }

    public GradeResult calculateGrade() {
        //(학점수x교과목 평점)의 합계
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
        //수강신청 총학점 수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        double averageGrade = totalMultipliedCreditAndCourseGrade / totalCompletedCredit;

        return new GradeResult(averageGrade, totalCompletedCredit);
    }
}
