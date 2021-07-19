package kr.co.ensmart.frameworkdemo.common.token;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenService {
	@Autowired
	private JwtService jwtService;
	
	public TokenDto createToken(TokenRequest request) {
		UserDetail userDetail;
		
		if (request.getTokenType() == TokenType.SERVICE_TOKEN) {
			// TODO serivce key 체크
			userDetail = new UserDetail().setUserName(request.getUserName());
			return new TokenDto()
					.setToken(jwtService.generateToken(userDetail, Arrays.asList("ROLE_SERVICE"), request.getValidMillis()))
					.setTokenType(TokenType.SERVICE_TOKEN);
		}
		else if (request.getTokenType() == TokenType.ADMIN_TOKEN) {
			// TODO id / password 체크
			userDetail = new UserDetail().setUserName(request.getUserName());
			return new TokenDto()
					.setToken(jwtService.generateToken(userDetail, Arrays.asList("ROLE_ADMIN"), request.getValidMillis()))
					.setTokenType(TokenType.ADMIN_TOKEN);
		}
		else if (request.getTokenType() == TokenType.CUSTOMER_TOKEN) {
			// TODO id / password 체크
			userDetail = new UserDetail().setUserName(request.getUserName());
			return new TokenDto()
					.setToken(jwtService.generateToken(userDetail, Arrays.asList("ROLE_CUSTOMER"), request.getValidMillis()))
					.setTokenType(TokenType.CUSTOMER_TOKEN);
		}
		else {
			throw new RuntimeException("api error");
		}
	}

}
