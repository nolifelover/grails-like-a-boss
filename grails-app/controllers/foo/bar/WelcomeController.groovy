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

}
