package org.example;

import org.example.password.PasswordGeneratePolicy;

public class CorrectPasswordGenerator implements PasswordGeneratePolicy {
    @Override
    public String generatePassword() {
        return "aaaabbbbcc";
    }
}
// 프로덕션 코드의 패키지와 테스트 코드의 패키지를 맞춰주는게 좋다