package src;

import java.util.HashMap;

public class DocumentProperties {

    public       
        HashMap<String, Integer> getTermFreqMap() {
            return termFreqMap;
        }
        HashMap<String, Integer> getWordCountMap() {
            return DocWordCounts;
        }
        void setTermFreqMap(HashMap<String, Integer> inMap) {
            termFreqMap = new HashMap<String, Integer>(inMap);
        }
        void setWordCountMap(HashMap<String, Integer> inMap) {
            DocWordCounts = new HashMap<String, Integer>(inMap);
        }   

    private
    	HashMap<String, Integer> termFreqMap;
     	HashMap<String, Integer> DocWordCounts;
}