package book2.webservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import javax.jws.WebService;

import book2.webservice.model.Book;
import book2.webservice.model.Reader;


@WebService(targetNamespace = "http://booklist.service.com/",
endpointInterface = "book2.webservice.service.Booklist",
portName = "BookListPort",
serviceName = "BookListService")
public class BookListImpl {
	 private static HashMap <Integer, Reader> readerMap = new HashMap<Integer,Reader>();
	 private static HashMap <String, Book> bookMap = new HashMap<String,Book>();
	 private static HashMap <Integer, ArrayList<Book> > bookListMap = new HashMap<Integer,ArrayList<Book> >();

	 private static int counterReader=0;
	 private static int counterBook=0;

	  
/********************Part related to bookList****************************/
		public boolean addBookToBookList(int id,String title) {
			//retrieve the book from bookMap
			Book bookToAdd=bookMap.get(title);
			
			//if this is the first time this reader adds a book to his booklist
			if(!bookListMap.containsKey(id)) {
				//We add the reader to the bookListMap with an empty ArrayList
				ArrayList<Book> alTmp=new ArrayList<Book>();
				bookListMap.put(id, alTmp);
			}
			//We add the chosen book to the bookListMap
			bookListMap.get(id).add(bookToAdd);
			return true;
		}
		
		
		public boolean deleteBookFromBookList(int id, String title) {
			Book bookToDel=bookMap.get(title);
			bookListMap.get(id).remove(bookToDel);
			return true;
		}
		
		
		public Book[] getBookList(int id) {
			
			//We create a temporary ArrayList to store the booklist, belonging to the reader identified by its id
			ArrayList<Book> alTmp=new ArrayList<Book>();
			alTmp=bookListMap.get(id);
			
			//we create an array, the size of tmpAl
			Book[] bookArray=new Book[alTmp.size()];

			for(int i=0;i<alTmp.size();i++) {
				bookArray[i]=alTmp.get(i);
			}
			return bookArray;
		}
		
		
		
/********************Part related to readers****************************/

	public int addReader(Reader reader) {
		 readerMap.put(reader.getId(), reader);
			if(readerMap.containsValue(reader)) {
				counterReader++;
				return reader.getId();
			}
			else {
				return -1;
			}
	 }

	public boolean deleteReader(int value) {
		//we check if the hashmap contains the key
		if(!readerMap.containsKey(value)) {
			return false;
		}
		else {
			readerMap.remove(value);
			counterReader--;
			return true;
		}
	}
	
	public Reader getReader(int value) {
		return readerMap.get(value);
	}
	
	
	public Reader[] getAllReader() {
		int i=0;
		//we create an array with the size of counter
		Reader[] readerArray=new Reader[counterReader];
		//we add each entry of the hashmap into the array
		for (HashMap.Entry<Integer,Reader> e : readerMap.entrySet()) {
			readerArray[i]=e.getValue();
			i++;
		}
		return readerArray;
	}
	
/********************Part related to books****************************/
	
	public boolean createBook(Book book) {
		bookMap.put(book.getTitle(), book);
		if(bookMap.containsValue(book)) {
			counterBook++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean deleteBook(String title) {
		//we check if the hashmap contains the key
		if(!bookMap.containsKey(title)) {
			return false;
		}
		else {
			bookMap.remove(title);
			counterBook--;
			return true;
		}
	}
	
	public Book getBook(String title) {
		return bookMap.get(title);
	}
	
	public Book[] getAllBook() {
		int i=0;
		//we create an array with the size of counter
		Book[] bookArray=new Book[counterBook];
		//we add each entry of the hashmap into the array
		for (HashMap.Entry<String,Book> e : bookMap.entrySet()) {
			bookArray[i]=e.getValue();
			i++;
		}
		return bookArray;
	}


}
