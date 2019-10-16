
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Search_tweet {
	
	String Consumer_Key = "2Xtd4ILUtinfACHehAvCNcbjW";
	String Consumer_Secret = "pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
	String Token = "839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
	String Token_Secret = "PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
	
	@Test
	public void gettweet() {
		
		RestAssured.baseURI="https://api.twitter.com/1.1/search";
	    Response res = given().auth().oauth(Consumer_Key,Consumer_Secret, Token, Token_Secret).
		queryParam("q", "#Qualitest")
		.when().get("/tweets.json").then().extract().response();
		
		String response = res.asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		//String id = js.get("id").toString();
		//System.out.println(id);
		//String text = js.get("text").toString();
		//System.out.println(text);
	}

}