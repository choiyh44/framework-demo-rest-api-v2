package kr.co.ensmart.frameworkdemo.common.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
public class TokenDto {
	private TokenType tokenType;
	private String token;
}
