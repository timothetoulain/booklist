package book2.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import book2.webservice.model.Book;
import book2.webservice.model.Reader;


@WebService(name = "Booklist",
targetNamespace = "http://booklist.service.com/")
public interface Booklist {

/********************Part related to readers****************************/
	@WebMethod(operationName = "addReader", action = "urn:AddReader")
	 @WebResult(name = "result")
	public int addReader(@WebParam(name = "reader")Reader reader);
	
	@WebMethod(operationName = "delReader", action = "urn:DelReader")
	 @WebResult(name = "result")
	public boolean deleteReader(@WebParam(name = "value") int value);
	
	@WebMethod(operationName = "getReader", action = "urn:GetReader")
	 @WebResult(name = "result")
	public Reader getReader(@WebParam(name = "value") int value);
	
	@WebMethod(operationName = "getAllReader", action = "urn:GetAllReader")
	 @WebResult(name = "result")
	public Reader[] getAllReader();
	
/********************Part related to books****************************/
	@WebMethod(operationName = "createBook", action = "urn:createBook")
	 @WebResult(name = "result")
	public boolean createBook(@WebParam(name = "book")Book book);
	
	@WebMethod(operationName = "delBook", action = "urn:DelBook")
	 @WebResult(name = "result")
	public boolean deleteBook(@WebParam(name = "title") String title);
	
	@WebMethod(operationName = "getBook", action = "urn:GetBook")
	 @WebResult(name = "result")
	public Book getBook(@WebParam(name = "value") String title);
	
	@WebMethod(operationName = "getAllBook", action = "urn:GetAllBook")
	 @WebResult(name = "result")
	public Book[] getAllBook();

	
	
	
	
	/********************Part related to bookList****************************/
	@WebMethod(operationName = "addBookToBookList", action = "urn:AddBookToBookList")
	 @WebResult(name = "result")
	public boolean addBookToBookList(@WebParam(name = "id")int id,@WebParam(name = "title")String title);
	
	@WebMethod(operationName = "deleteBookFromBookList", action = "urn:DeleteBookFromBookList")
	 @WebResult(name = "result")
	public boolean deleteBookFromBookList(@WebParam(name = "id") int id, @WebParam(name = "title") String title);
	
	@WebMethod(operationName = "getBookList", action = "urn:GetBookList")
	 @WebResult(name = "result")
	public Book[] getBookList(@WebParam(name = "id") int id);

}
