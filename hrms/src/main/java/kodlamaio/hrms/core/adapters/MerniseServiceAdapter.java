package kodlamaio.hrms.core.adapters;

import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MerniseServiceAdapter implements CandidateCheckService {

	public boolean CheckIfRealPerson(Candidate candidate) {
		try {
			KPSPublicSoap client = new KPSPublicSoapProxy();

			boolean isValid = client.TCKimlikNoDogrula(Long.valueOf(candidate.getIdentificationNumber()),
					candidate.getFirstName().toUpperCase(new Locale("tr")),
					candidate.getLastName().toUpperCase(new Locale("tr")), candidate.getBirthDate().getYear());

			return isValid;

		} catch (Exception e) {

			System.out.println("Giriş bilgileri doğru değil");
		}

		return false;
	}
}
