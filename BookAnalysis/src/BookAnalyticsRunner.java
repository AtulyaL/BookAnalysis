
public class BookAnalyticsRunner {

	public static void main(String[] args) {
		BookAnalyticsChild book = new BookAnalyticsChild("C:\\Users\\Lohani\\Desktop\\ApCSWorkspace\\BookAnalysis\\src\\TheRaven.txt", "C:\\Users\\Lohani\\Desktop\\ApCSWorkspace\\BookAnalysis\\src\\NewRaven.txt");
		//System.out.println(book.toString());
		String[] wordsToBeReplaced= {"raven", "more", "lenore"};
		String[] wordsToReplaceWith= {"crow", "less", "bob the builder"};
//		System.out.println(book.alphabetizeAllByChar());
//		System.out.println(book.alphabetizeAllByWord());
		book.replaceWordsAndWriteToFile(wordsToBeReplaced, wordsToReplaceWith);
		System.out.println(book.message);
	}

}
