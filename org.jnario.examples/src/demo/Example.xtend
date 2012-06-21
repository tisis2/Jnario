package demo

import static java.util.Collections.*

class Example {
	def static void main(String[] args) {
		println(newArrayList("red", "blue", "green").sort) 
	}
	
	@Property()
	(String) => void field
}   

class Database{
	def connect(String url){
	}
	
	def query(String sql){
	}
	
	def disconnect(){
	}
}

class Example2{
	
	val Database db
	
	new(Database db){
		this.db = db
	}
	
	def test(){
		newArrayList("red", "green").map[length].reverseView
	}
	
}