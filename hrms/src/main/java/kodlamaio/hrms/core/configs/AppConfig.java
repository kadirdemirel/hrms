package kodlamaio.hrms.core.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


import kodlamaio.hrms.core.imageuploads.ImageUploadManager;
import kodlamaio.hrms.core.imageuploads.ImageUploadService;

@Configuration
public class AppConfig {
	private Cloudinary cloudinaryService() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", "dihpo3hxj", "api_key", "872549268788792", "api_secret",
				"hmIkqn0NjuaECtrjWfv3ZecD-IY"
			

		));

	}

	@Bean
	public ImageUploadService imageUploadService() {
		return new ImageUploadManager(cloudinaryService());

	}
}
