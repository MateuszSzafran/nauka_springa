package pl.maszafran.data_generator;

public enum LanguageCollection {
    POLSKI("pl"), ENGLISH("en"), ESPANOL("es");

    private String sign;

    private LanguageCollection(String sign){
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
