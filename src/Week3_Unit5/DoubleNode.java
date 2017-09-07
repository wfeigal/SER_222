package Week3_Unit5;

public class DoubleNode<T> {
	private DoubleNode<T> prev;
	private DoubleNode<T> next;
	T element;
	
	//CONSTRUCTORS

	DoubleNode(){
		this.prev = null;
		this.next = null;
		element = null;				
	}
	DoubleNode(T elem){
		this.prev = null;
		this.next = null;
		this.element = elem;
	}
	//METHODS
	public DoubleNode<T> getPrev(){
		return this.prev;
	}
	public void setPrev(DoubleNode<T> node) {
		this.prev = node;
	}
	public DoubleNode<T> getNext(){
		return this.next;
	}
	public void setNext(DoubleNode<T> node) {
		this.next = node;
	}
	public T getElement() {
		return this.element;
	}
	public void setElement(T elem) {
		this.element = elem;
	}
}
