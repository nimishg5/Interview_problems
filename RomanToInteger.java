import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    
    private static Map<Character, Integer> romanMap = new HashMap<>();
	private static List<Character> characterList = new ArrayList<>();
	
	static {
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		
		characterList.add('I');
		characterList.add('V');
		characterList.add('X');
		characterList.add('L');
		characterList.add('C');
		characterList.add('D');
		characterList.add('M');
	}
    
    public static int romanToInt(String s) {
        int value = romanMap.get(s.charAt(0));
        for (int i=1; i<s.toCharArray().length; i++) {
        	if (characterList.indexOf(s.charAt(i)) > characterList.indexOf(s.charAt(i-1))) {
        		value -= romanMap.get(s.charAt(i-1));
        		value += romanMap.get(s.charAt(i)) - romanMap.get(s.charAt(i-1));
        	} else {
        		value += romanMap.get(s.charAt(i));
        	}
        }
        return value;
    }
}
