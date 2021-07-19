package kr.co.ensmart.frameworkdemo.common.token;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TokenRequest {
	@NotEmpty
	private TokenType tokenType;
	@NotEmpty
	private String userName;
	private String password;
	private Long validMillis;
}
