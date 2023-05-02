package br.com.igor.arquivomultiplosformatosjob.reader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.igor.arquivomultiplosformatosjob.dominio.Cliente;
import br.com.igor.arquivomultiplosformatosjob.dominio.Livros;

@Configuration
public class ClienteTransacaoLineMapperConfig {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public PatternMatchingCompositeLineMapper lineMapper() {
		System.out.println("Iniciando lineMapper");
		PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper<>();
		lineMapper.setTokenizers(tokenizers());
		lineMapper.setFieldSetMappers(fieldSetMappers());
		return lineMapper;
	}

	@SuppressWarnings("rawtypes")
	private Map<String, FieldSetMapper> fieldSetMappers() {
		System.out.println("Iniciando fieldSetMappers");
		Map<String, FieldSetMapper> fieldSetMappers = new HashMap<>();
		fieldSetMappers.put("0*", fieldSetMapper(Cliente.class));
		fieldSetMappers.put("1*", fieldSetMapper(Livros.class));
		return fieldSetMappers;
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private FieldSetMapper fieldSetMapper(Class classe) {
		System.out.println("Iniciando fieldSetMapper");
		BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(classe);
		return fieldSetMapper;
	}

	private Map<String, LineTokenizer> tokenizers() {
		System.out.println("Iniciando tokenizers");
		Map<String, LineTokenizer> tokenizers = new HashMap<>();
		tokenizers.put("0*", clienteLineTokenizer());
		tokenizers.put("1*", livroLineTokenizer());
		return tokenizers;
	}

	private LineTokenizer clienteLineTokenizer() {
		System.out.println("Iniciando clienteLineTokenizer");
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("nome", "sobrenome", "idade", "email");
		lineTokenizer.setIncludedFields(1, 2, 3, 4);
		return lineTokenizer;
	}

	private LineTokenizer livroLineTokenizer() {
		System.out.println("Iniciando livroLineTokenizer");
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("nome","valor", "id", "tpMovimento");
		lineTokenizer.setIncludedFields(1, 2, 3, 4);
		return lineTokenizer;
	}
}
