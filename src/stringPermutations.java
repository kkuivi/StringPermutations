import java.util.ArrayList;

/*This program takes in a String as an input stores all its permutations in list.*/
public class stringPermutations {
	public static void main(String [] args){
		String str = "same";
		ArrayList<String> stringList = listStringPermutations(str);
		outputList(stringList);
	}
	
	/*Prints out all the Strings in the ArrayList<String>*/
	static void outputList(ArrayList<String> stringList){
		for(int i = 0; i < stringList.size(); i ++){
			System.out.print(stringList.get(i) + "| ");
		}
	}
	
	/*Takes in a String and returns an ArrayList containing all the permutations of the String*/
	static ArrayList<String> listStringPermutations(String str){
		ArrayList<String> permutationlist = new ArrayList<String>(); //stores a list of all the permutations of str
		
		/*if str is an empty or null string*/
		if(str == null || str.equals("")){
			permutationlist.add("");
			return permutationlist;
		}
		
		StringBuilder word = new StringBuilder(str);
		StringBuilder curr_permutation = new StringBuilder(); //stores a permutation of string in str
		permutationlist = listStringPermutations(word, curr_permutation, permutationlist);
		return permutationlist;
	}
	
	/*This method builds all permutations of the StringBuilder parameter (word) by placing the characters of word in all possible positions
	 * within the String. It does this by recursively removing a character from word, and appending that character
	 * to curr_permutation. Once word is empty, it adds the curr_permutation to permutationlist. */
	private static ArrayList<String> listStringPermutations(StringBuilder word, StringBuilder curr_permutation, 
			ArrayList<String> permutationlist){
		
		if(word.length() == 0){//once a permutation of word has been found, add that permutation to permutationlist
			permutationlist.add(curr_permutation.toString());
			return permutationlist;
		}
		else{
			for(int i = 0; i < word.length(); i ++){
				StringBuilder modified_word = new StringBuilder(word); //copies word and modifies it so that next iterations will use the unchanged version of word
				modified_word.deleteCharAt(i); //remove the character at i from modified word
				curr_permutation.append(word.charAt(i)); //add the character at position i in word to the end of curr_permutation
				permutationlist = (listStringPermutations(modified_word, curr_permutation, permutationlist));
				curr_permutation.deleteCharAt(curr_permutation.length() - 1); //revert curr_permutation to its previous state so next iterations can use its unmodified version
			}
			return permutationlist;
		}
	}
}
