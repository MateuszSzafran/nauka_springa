package pl.mszafran.thymeleaf_control;

import org.springframework.stereotype.Service;

@Service
class TextStatsService {

    public int getTextLength(String data) {
        return data.length();
    }

    public int getWordsNumber(String data){
        String[] words = data.split("\\s");
        return words.length;
    }

    //returns 1 if text is palindrome or -1 if it is not
    public int isPalindrome(String data){
        String originalOrder = data.replaceAll("\\s", "");
        StringBuilder reversedOrderBuilder = (new StringBuilder(originalOrder)).reverse();
        String reversedOrder = reversedOrderBuilder.toString();
        boolean isPalindrome = originalOrder.equalsIgnoreCase(reversedOrder);
        return isPalindrome? 1: -1;
    }

    public void setFirstMostPopularWordAndNum(TextDto text){
        String original = text.getText();
        String[] words = original.split("\\s");
        String mostPopular = null;
        int counter = 0;
        for (String word : words) {
            int tempCounter = 0;
            for (String w : words) {
                if (word.equals(w)){
                    tempCounter++;
                }
            }
            if(tempCounter > counter){
                counter = tempCounter;
                mostPopular = word;
            }
        }
        text.setMostPopularWord(mostPopular);
        text.setMostPopularWordNum(counter);
    }

    public TextDto getTextInfo(String data, boolean textLength, boolean wordsNumber, boolean palindrome, boolean popularWord) {
        TextDto textDto = new TextDto(data);
        if(textLength) {
            textDto.setLength(getTextLength(data));
        }
        if(wordsNumber) {
            textDto.setWordsNumber(getWordsNumber(data));
        }
        if(palindrome) {
            textDto.setPalindrome(isPalindrome(data));
        }
        if(popularWord) {
            setFirstMostPopularWordAndNum(textDto);
        }
        return textDto;
    }
}
