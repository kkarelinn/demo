Hello, I'm ANDRII KARELIN.

And this code is my test task for Yurii Luchiv.

To start the server you need:
the Simplest way(need Docker):
- downolad code on you PC
- start script file start_docker_script.bat.
That's all.

To check server start http://localhost:8888/api

The Postman collection for import file POSTMANcollection.

First of all, you need to receive jwt tocken. That`s way you need to visit page
http://localhost:8888/athenticate with GET request with json bode 
{
    "userName":"admin",
    "password":"admin"
}

You will receive response with jwt-token.

For other all operation you need to include in you request header (POST/GET) such parameter 
key="Authorization"
value="Bearer [token]"

API:

GET
1) /api/usersAge/{age} - receive user list older than [age]
2) /api/usersColor/{color} - receive list of user, which have at least one article with [color] from enum Color. You can put Color.RED, Color.GREEN, Color.BLUE, Color.BLACK
			for example: /api/usersColor/RED - all users, which have at least one article with RED color.
3) /api/uniqUsersWith3Art - receive list of username, which have more than 3 article.

POST
4) /api/saveUser - send post request with body in json for user, for example 
		{
        "name": "NewUser",
        "age": 50,
        "articles": [
            {
                "text": "test Article",
                "color": "GREEN"
            },
            {
                "text": "test Article 2",
                "color": "BLUE"
            }
            ]
	 	}
 
 5) /api/saveArticle - send post request with body in json article, for example 
 		 {
            "text": "NEW Article",
            "color": "GREEN",
            "user":{"id":2}
			}
