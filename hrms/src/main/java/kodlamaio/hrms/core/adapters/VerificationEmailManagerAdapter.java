package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.VerificationEmailService;
import kodlamaio.hrms.core.verificationEmails.VerificationEmailManager;
@Service
public class VerificationEmailManagerAdapter implements VerificationEmailService {

	VerificationEmailManager email = new VerificationEmailManager();

	@Override
	public Boolean verificationEmail(String message) {
		email.verificationEmail(message);
		return true;

	}

}
