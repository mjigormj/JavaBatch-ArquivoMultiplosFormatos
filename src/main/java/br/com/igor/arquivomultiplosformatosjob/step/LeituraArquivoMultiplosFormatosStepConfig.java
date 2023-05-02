package br.com.igor.arquivomultiplosformatosjob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.igor.arquivomultiplosformatosjob.reader.ArquivoClienteLivroReader;


@Configuration
public class LeituraArquivoMultiplosFormatosStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@SuppressWarnings("unchecked")
	@Bean
	public Step leituraArquivoMultiplosFormatosStep(
			@SuppressWarnings("rawtypes") FlatFileItemReader leituraArquivoMultiplosFormatosReader,
			@SuppressWarnings("rawtypes") ItemWriter leituraArquivoMultiplosFormatosItemWriter) {
		return stepBuilderFactory
				.get("leituraArquivosMultiplosFormatosStep")
				.chunk(1)
				.reader(new ArquivoClienteLivroReader(leituraArquivoMultiplosFormatosReader))
				.writer(leituraArquivoMultiplosFormatosItemWriter)
				.build();
	}
}
