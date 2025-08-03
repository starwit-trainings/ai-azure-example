package main.java.starwit;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.azure.ai.vision.imageanalysis.ImageAnalysisAsyncClient;
import com.azure.ai.vision.imageanalysis.ImageAnalysisClient;
import com.azure.ai.vision.imageanalysis.ImageAnalysisClientBuilder;
import com.azure.core.credential.KeyCredential;
import com.microsoft.cognitiveservices.speech.SpeechConfig;

@SpringBootApplication
public class AiAgentApplication {

	@Value( "${speech.key}" )
    private String speechKey;

    @Value( "${speech.endpoint}" )
    private String speechEndpoint;

	@Value( "${vision.key}" )
    private String visionKey;

    @Value( "${vision.endpoint}" )
    private String visionEndpoint;

    @Value( "${speech.region}" )
    private String region;

	public static void main(String[] args) {
		SpringApplication.run(AiAgentApplication.class, args);
	}

	@Bean
	public SpeechConfig speechConfig() {
		SpeechConfig speechConfig = SpeechConfig.fromEndpoint(URI.create(speechEndpoint), speechKey);
		speechConfig.setSpeechRecognitionLanguage("en-US");
		return speechConfig;
	}
}
