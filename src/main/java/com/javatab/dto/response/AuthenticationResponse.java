package com.javatab.dto.response;

import com.javatab.model.base.ModelBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthenticationResponse extends ModelBase {

	private static final long serialVersionUID = 7431193836933783650L;

	private String token;
}
