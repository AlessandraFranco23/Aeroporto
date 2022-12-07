package core;

import java.util.regex.Pattern;

//Classe para validar valores com REGEX
public class Validator<T> {

    private final Pattern pattern;

    private Validator(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public boolean isValid(String value) {
        return pattern.matcher(value).find();
    }

    public static  Validator<String> numeracaoPista() {
        return new Validator<String>(Patterns.NUMERACAO_PISTA);
    }

    public static Validator<String> prefixoAviao() {
        return new Validator<String>(Patterns.PREFIXO_AVIAO);
    }
    
    public static Validator<String> numeracaoVoo() {
        return new Validator<String>(Patterns.NUMERACAO_VOO);
    }

    public static Validator<String> origemDestinoVoo() {
        return new Validator<String>(Patterns.ORIGEM_DESTINO_VOO);
    }

    private static class Patterns {
        public static final String NUMERACAO_PISTA = "[A-Za-z]|\\d{2}";
        public static final String PREFIXO_AVIAO = "[A-Za-z]{3}|\\d{4}";
        public static final String NUMERACAO_VOO = "[A-Za-z]{3}|\\d{6}";
        public static final String ORIGEM_DESTINO_VOO = "[A-Za-z]{3}";
    }
}