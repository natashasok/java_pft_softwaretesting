package ru.stqa.pft.rest;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Set;

public class TestBase {

  @BeforeClass
  public void init() {
    RestAssured.authentication = RestAssured.basic("288f44776e7bec4bf44fdfeb1e646490", "");
  }

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  private Set<Issue> getIssue(int issue_id)  {
    String json = RestAssured.given().pathParam("issue_id", issue_id).when().get("https://bugify.stqa.ru/api/issues/{issue_id}.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issue = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issue, new TypeToken<Set<Issue>>(){}.getType());
  }

  private boolean isIssueOpen(int issueId) {
   Set<Issue> allIssues = getIssue(issueId);
    Issue newIssue = allIssues.iterator().next();
    String resolution = newIssue.getState_name();
    System.out.println(resolution);
    if (resolution.equals("Open")){
      return true;
    }
    return false;
  }
}