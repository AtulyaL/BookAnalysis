import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class BookAnalyticsChild extends BookAnalytics {
	private Scanner s;
	private int newLines;
	public String message;
	public BookAnalyticsChild(String aTextFile, String outputFile) {
		super(aTextFile, outputFile);
		newLines=0;
		message="";
		while(scan.hasNext()) {
			message+=scan.nextLine()+'\n';
			newLines++;
		}
		
	}
	
	@Override
	public String mostFrequentWord() {
		if(message.equals("")){
			  return "";
			}
			String[]m=message.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
			int max=0;
			String most=" ";
			for(String word: m){
			  int counter=0;
			  for(int i=0;i<m.length;i++){
			    if(m[i].equals(word)){
			      counter++;
			    }
			    if(counter>max){
			      most= word;
			      max=counter;
			    }
			  }
			}
			return most;
	}

	@Override
	public String mostFrequentWordWithCapitalFirstLetter() {
			if(message.equals("")){
			  return "";
			}
			String[]x=message.replaceAll("[^a-zA-Z ]", "").split(" ");
			ArrayList<String>capitals=new ArrayList<String>();
			for(String word:x) {
				if(word != null && word.length() > 0)
					if((int)word.charAt(0)<97) {
						capitals.add(word);
					}
			}
			
			String []m = new String[capitals.size()];
		    m = capitals.toArray(m);
			int max=0;
			String most=" ";
			for(String word: m){
			  int counter=0;
			  for(int i=0;i<m.length;i++){
			    if(m[i].equals(word)){
			      counter++;
			    }
			    if(counter>max){
			      most= word;
			      max=counter;
			    }
			  }
			}
			return most;
	}

	@Override
	public char mostFrequentLetter() {
		 if(message.length()==1){
			    return message.charAt(0);
			  }
			String[]x=message.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
			String temp=" ";
			for(int i=0;i<x.length;i++){
			  temp+=x[i];
			}
			char[] m= temp.toCharArray();
			int max=0;
			char most=' ';
			for(char c: m){
			  int counter=0;
			  for(int i=0;i<m.length;i++){
			    if(m[i]==c){
			      counter++;
			    }
			    if(counter>max){
			      most= c;
			      max=counter;
			    }
			  }
			}
			return most;
	}

	@Override
	public int wordCount() {
		return message.split(" ").length;
	}

	@Override
	public int characterCount() {
		return message.toCharArray().length-newLines;
	}

	@Override
	public int vowelCount() {
		 char [] vowels={'a','e','i','o','u','y'};
		  int nums=0;
		  for(int x=0;x<vowels.length;x++){
		  for(int i=0;i<message.length();i++){
		  if(Character.toLowerCase((message.charAt(i)))==vowels[x]){
		    nums++;
		  }
		  }
		  }
		  return nums;
	}

	@Override
	public int consonantCount() {
		char [] consonants={'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
		  int nums=0;
		  for(int x=0;x<consonants.length;x++){
		  for(int i=0;i<message.length();i++){
		  if(Character.toLowerCase((message.charAt(i)))==consonants[x]){
		    nums++;
		  }
		  }
		  }
		  return nums;
	}

	@Override
	public double averageWordLength() {
		String[] words=message.split(" ");
		  int numberOfWords=0;
		  int numberOfChars=0;
		 for(String word:words){
		   numberOfWords++;
		     if(word.contains(".")||word.contains(",")||word.contains("?")||word.contains("!")||word.contains("\"")||word.contains("'")||word.contains("/")||word.contains("\\")){
		       numberOfChars--;
		     }
		     numberOfChars+=word.length();
		 } 
		 return numberOfChars/(double)numberOfWords;
	}

	@Override
	public int sentenceCount() {
		char[] punctuation= {'.','!','?',';'};
		int nums=0;
		  for(int x=0;x<punctuation.length;x++){
		  for(int i=0;i<message.length();i++){
		  if(((message.charAt(i)))==punctuation[x]&&(Character.isWhitespace(message.charAt(i+1))&&(!(message.substring(i-2,i).matches("Ms\\|Mr\\|Jr\\|Sr\\|Dr"))&&(!(message.substring(i-3,i).matches("Mrs")))))){
			  nums++;
		  }
		  }
		  }
		  return nums;
	}

	@Override
	public double averageWordsPerSentance() {
		return (double)this.wordCount()/this.sentenceCount();
	}

	@Override
	public int numberOfDifferentWords() {
		if(message.length()==0){
		    return 0;
		  }
		  ArrayList<String> unique=new ArrayList<String>();
		  String[] words=message.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
		  for(int i=0;i<words.length;i++){
		    if(!(unique.contains(words[i]))){
		      unique.add(words[i]);
		    }
		  }
		  return unique.size();
	}

	@Override
	public String alphabetizeAllByChar() {
		char[]chars=message.replaceAll(" ","").toCharArray();
		ArrayList<Character> alphabetizedChars = new ArrayList<Character>();
		for(int i=0;i<chars.length;i++) {
			alphabetizedChars.add(chars[i]);
		}
		 java.util.Collections.sort(alphabetizedChars);
		 String alphabetized=" ";
		 for(int i=0;i<alphabetizedChars.size();i++) {
			 alphabetized+=alphabetizedChars.get(i);
		 }
		 return alphabetized;
	}

	@Override
	public String alphabetizeAllByWord() {
		List<String> words=Arrays.asList(message.split(" "));
		 java.util.Collections.sort(words);
		 String alphabetized=" ";
		 for(int i=0;i<words.size();i++) {
			 alphabetized+=words.get(i)+" ";
		 }
		 return alphabetized;
	}

	@Override
	public String replaceWordAndPreserveCase(String aLine, String wordOne, String wordTwo) {
		String replacedSmall=aLine.replaceAll(wordOne,wordTwo);
		String capitalizedOne=Character.toUpperCase(wordOne.charAt(0))+wordOne.substring(1,wordOne.length());
		String capitalizedTwo=Character.toUpperCase(wordTwo.charAt(0))+wordTwo.substring(1,wordTwo.length());
		if(aLine.contains(capitalizedOne)){
		String ret=replacedSmall.replaceAll(capitalizedOne,capitalizedTwo);  
		return ret;
		}
		return replacedSmall;
	}

	@Override
	public String toString() {
		return "\t" + file.getName() +"\nMost Frequent Word : " + mostFrequentWord() +"\nMost Frequent Letter: " + mostFrequentLetter() +"\nMost Likely Subject: " + mostFrequentWordWithCapitalFirstLetter() +"\nWord Count: " + wordCount() +"\nCharacter Count: " + characterCount() +"\nVowel Count: " + vowelCount() +"\nConsonant Count: " + consonantCount() +"\nSentence Count: " + sentenceCount() +"\nAverage Word Length: " + averageWordLength() +"\nAverage Words Per Sentence: " + averageWordsPerSentance() +"\nNumber of Different Words Used: " + numberOfDifferentWords(); 
		
	}

	@Override
	public void replaceWordsAndWriteToFile(String[] wordsToBeReplaced, String[] wordsToReplaceWith) {
		try {
			 s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(s.hasNext()) {
			String line=s.nextLine();
			for(int i=0;i<wordsToBeReplaced.length;i++) {
				line = replaceWordAndPreserveCase(line, wordsToBeReplaced[i], wordsToReplaceWith[i]);	
			}
			write.println(line);
			write.flush();
			}
		
}

}
