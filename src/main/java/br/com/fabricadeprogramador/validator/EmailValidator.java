package br.com.fabricadeprogramador.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator(value="emailValidator")
public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		
		String email = (String) value;
		
		// Indexof valida a posição de um caracter
		if(email.indexOf("@")==-1){
			FacesMessage msg = new FacesMessage("E-Mail Incorreto");
			throw new ValidatorException(msg);
		}
		
	}

}
