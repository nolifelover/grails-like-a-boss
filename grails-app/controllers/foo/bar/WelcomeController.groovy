package foo.bar

class WelcomeController {

	def index() {
		render "Hello World"
	}

	def hello(){
		render "Hello Todsaporn"
	}

	def helloParams(){
		def name = params.name?: "Todsaporn"
	}

	def edit(){
		def name = "todsaporn"
		def items = []
		items << [id: 1, name: "foo"]
		items << [id: 2, name: "bar"]
		[name: name, items: items]
	}

	def list(){
		def productList = Product.list()
		[productList: productList]
	}

}
