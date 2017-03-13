# Use [this](https://github.com/NOVA-Uncommon-Coders/SpringBasicsFR) repo url to get started.

Let's start writing some Spring apps! But first, enjoy this gif of a drunk guy trying to use an ATM:

![screenshot](http://giant.gfycat.com/WatchfulAlarmedHorseshoecrab.gif)

Gets me every time. Now, on to our assignment.

## Description

Make a web application that allows you write and delete short messages. When you click "Submit", it will refresh and show a list of messages you wrote. If you're feeling *déjà vu*, it's because this is the same assignment we did two weeks ago, but this time we're doing it with Spring.

## Requirements
* Create `home.html` in the templates directory
  * It should display a login form like the first screenshot
* Create a controller class next to the main application class
* In your controller, create a route for `/`
  * It should take the model and the request as arguments
  * It should read the username from the session and add it to the model
  * It should return the home template
* In your controller, create a route for `/login`
  * It should take the request and the username as arguments
  * It should save the username to the session
  * It should return a redirect to `/`
* In `home.html`, use Mustache tags to conditionally show the markup in the two screenshots below
  * If `username` doesn't exist, show the login form like the first screenshot
  * If `username` does exist, show the message submission form and message list like the second screenshot
* Create a `Message` class next to your other classes
  * It should have fields for `id` and `text`
* Create an `ArrayList<Message>` in your controller to store submitted messages
* In your controller, create a route for `/add-message`
  * It should take the message text as an argument
  * It should create a `Message` object and add it to the arraylist (for the id, do something like `messages.size() + 1`)
  * It should return a redirect to `/`
* In `home.html`, add a button or link called "Delete" next to each message
  * It will need to send the id as a parameter
* In your controller, create a route for `/delete-message`
  * It should take the message id as an argument
  * It should remove the message with the given id (do something like `messages.remove(id - 1)`)
  * It should return a redirect to `/`

![screenshot 1](https://github.com/oakes/java-assignments/raw/master/6.1-microblog-spring/screenshot1.png)
![screenshot 2](https://github.com/oakes/java-assignments/raw/master/6.1-microblog-spring/screenshot2.png)