public class LongestStrWithoutRepeatingChars {

    public static void main(String[] args) {
        System.out.println(findSubStr("pwwkew"));
        System.out.println(findSubStr("bbbbb"));
        System.out.println(findSubStr("passport"));
        System.out.println(findSubStr("abcabcbb"));

    }

    public static String findSubStr(String s) {

        if(s == null || s.trim().length() == 0)
            return "";

        int [] lastOccurrenceIndex = new int[26];
        int [] occurrenceCount = new int[26];

        char presentChar;
        int presentCharIndex = 0;

        String longestSubstr = new StringBuffer(s.charAt(0)).toString();

        String runningStr = "";

        for(int i  = 0; i < s.length(); i++) {
            presentChar = s.charAt(i);
            presentCharIndex = (int) (presentChar - 'a');

            if(occurrenceCount[presentCharIndex] > i-runningStr.length())
            {
                runningStr = s.substring(lastOccurrenceIndex[presentCharIndex]+1, i) + presentChar;
            }
            else{
                occurrenceCount[presentCharIndex] = occurrenceCount[presentCharIndex]+1;
                runningStr = runningStr + presentChar;
                if(runningStr.length() > longestSubstr.length()) {
                    longestSubstr = runningStr;
                }
            }

            lastOccurrenceIndex[presentCharIndex] = i;
        }
        return longestSubstr;
    }
}
