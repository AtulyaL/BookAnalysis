
public class BookAnalyticsRunner {

	public static void main(String[] args) {
		BookAnalyticsChild book = new BookAnalyticsChild(/*source*/, /*destination*/);
		//System.out.println(book.toString());
		String[] wordsToBeReplaced= {"raven", "more", "lenore"};
		String[] wordsToReplaceWith= {"crow", "less", "bob the builder"};
//		System.out.println(book.alphabetizeAllByChar());
//		System.out.println(book.alphabetizeAllByWord());
		book.replaceWordsAndWriteToFile(wordsToBeReplaced, wordsToReplaceWith);
		System.out.println(book.message);
	}

}
