package org.example;

import org.example.password.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    //alt+ins 에서 Test Method : 이 경우는 프로덕션 먼저 만든 후 테스트 코드 작성
    @DisplayName("패스워드를 초기화한다")
    @Test
    void passwordTest() {
        //코드 실행시 랜덤값 RandomPasswordGenerator의 0-12가 if(randomPassword.length() >= 8 && randomPassword.length() <= 12)
        //조건에 만족한다면 pw가 세팅될 것이고, 아니라면 안될 것. 따라서 실행마다 결과가 다름
        //이런 경우에 테스트코드를 짜기 어려운 이유는 RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();이 코드 때문
        //어떻게 몇 글자를 만드는지 모름. 이를 제어하기 위한 PasswordGeneratePolicy

        //given
        User user = new User();
        //when
        user.initPassword(new CorrectPasswordGenerator()); //여기에 CorrectPWG 추가, 이 경우 항상 성공
        //이때 CorrectPasswordGenerator는 메소드를 하나 가진 funtional interface이기에
        //구현체를 만들 필요 없이 람다를 이용해서 () -> "aaaabbbbcc"
        //then
        assertThat(user.getPassword()).isNotNull(); //pw가 setting이 되기를 기대한다 init pw를 했을 때
    }


    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다")
    @Test
    void passwordTest2() {
        //given
        User user = new User();
        //when
        user.initPassword(new WrongPasswordGenerator());
        //then
        assertThat(user.getPassword()).isNull(); //이 경우 항상 2글자가 리턴되므로 초기화가 되지 않기에 isNull
    }

}