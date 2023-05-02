package br.com.igor.arquivomultiplosformatosjob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.igor.arquivomultiplosformatosjob.dominio.Cliente;

@Configuration
public class LeituraArquivoMultiplosFormatosStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Bean
	public Step leituraArquivoMultiplosFormatosStep(
			MultiResourceItemReader<Cliente> multiplosArquivosClienteLivrosReader, 
			ItemWriter leituraArquivoMultiplosFormatosItemWriter) {
		return stepBuilderFactory
				.get("leituraArquivosMultiplosFormatosStep")
				.chunk(1)
				.reader(multiplosArquivosClienteLivrosReader)
				.writer(leituraArquivoMultiplosFormatosItemWriter)
				.build();
	}
}
 