import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMaxVote {
	
	public static String findMaxVote(String[] names){
		Map<String, Integer> voteCount = new HashMap<>();
		List<String> voterList = new ArrayList<>();
		int maxCount = Integer.MIN_VALUE;
		for(String name : names){
			if(voteCount.containsKey(name)){
				int count = voteCount.get(name);
				count++;
				if(count>maxCount){
					maxCount = count;
				}
				voteCount.put(name, count);
			}else{
				if(1>maxCount){
					maxCount = 1;
				}
				voteCount.put(name, 1);
			}
		}
		
		for(String name : voteCount.keySet()){
			if(voteCount.get(name)==maxCount){
				voterList.add(name);
			}
		}
		Collections.sort(voterList);
		return voterList.get(voterList.size()-1);
	}
	
	public static void main(String[] args) {
		String[] names = {"a","c","a","d","c","a","b","a","d","d","c","c","c","d","a"};
		System.out.println(findMaxVote(names));
	}

}
