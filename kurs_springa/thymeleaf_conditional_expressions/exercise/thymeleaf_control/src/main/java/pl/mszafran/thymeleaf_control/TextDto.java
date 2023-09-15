package pl.mszafran.thymeleaf_control;

class TextDto {
    private String text;
    private int length;
    private int wordsNumber;
    private int palindrome;
    private String mostPopularWord;
    private int mostPopularWordNum;

    public TextDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWordsNumber() {
        return wordsNumber;
    }

    public void setWordsNumber(int wordsNumber) {
        this.wordsNumber = wordsNumber;
    }

    public int getPalindrome() {
        return palindrome;
    }

    public void setPalindrome(int palindrome) {
        this.palindrome = palindrome;
    }

    public String getMostPopularWord() {
        return mostPopularWord;
    }

    public void setMostPopularWord(String mostPopularWord) {
        this.mostPopularWord = mostPopularWord;
    }

    public int getMostPopularWordNum() {
        return mostPopularWordNum;
    }

    public void setMostPopularWordNum(int mostPopularWordNum) {
        this.mostPopularWordNum = mostPopularWordNum;
    }
}
