package org.example.password;

public class User {                     //alt + ins로 test선택
    private String password;

    public void initPassword(PasswordGeneratePolicy passwordGeneratePolicy){//제어할 수 없는 부분을 외부로 부터 주입(PasswordGeneratePolicy)
        //randomPasswordGenerator = new RandomPasswordGenerator();

        //as-is 방식
        //RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        // 내부에서 생성하는 경우는 강한 결합

        //to-be 방식
        //String password = passwordGeneratePolicy.generatePassword();
        // 상위에 인터페이스를 둠으로써 랜덤 패스워드 제너레이터에 대해 의존할 필요 없어짐 더 낮은 결합도를 가진 설계


        String password = passwordGeneratePolicy.generatePassword();
        /*
        비밀번호는 최소 8자 이상 12자 이하여야 한다
         */
        if(password.length() >= 8 && password.length() <= 12){
            this.password = password;
        }
    }

    //UserTest의 then에서 넘어와 getter생성
    public String getPassword() {
        return password;
    }
}
