package org.example;

import org.example.grade.domain.Course;
import org.example.grade.domain.Courses;
import org.example.grade.domain.GradeCalculator;
import org.example.grade.domain.GradeResult;
import org.example.grade.ui.ConsoleOutputUI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


/*
*요구사항
• 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
• MVC패턴(Model-View-Controller) 기반으로 구현한다.
• 일급 컬렉션 사용

* */
public class GradeCalculatorTest {
    // 학점계산기, 코스
    // 평균학점 계산 요청 ---> '학점계산기' ---> (학점수×교과목 평점)의 합계 ---> '코스'
    //                               ---> 수강신청 총학점 수
    @DisplayName("평균 학점을 계산한다")
    @Test
    void calculateGradeTest() {
        // given
        List<Course> courses = List.of(new Course("OOP", Course.MAJOR_CREDIT, "A+"),
                new Course("자료구조", Course.MAJOR_CREDIT, "A+"),
                new Course("중국어회화", Course.GENERAL_CREDIT, "C"));

        // when
        GradeCalculator gradeCalculator = new GradeCalculator(new Courses(courses));
        GradeResult gradeResult = gradeCalculator.calculateGrade();

        // then
        ConsoleOutputUI.printGrade(gradeResult);
    }
}
