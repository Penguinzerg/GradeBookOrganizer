import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class Login {
    private static final String USER_AGENT = "\"Mozilla/5.0 (Windows NT\" +\n" + "          \" 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2\"";
    private static final String USER_ID = "ocook1714";
    private static final String USER_PASSWORD = "seekpaleblood";
    public Connection.Response loginForm;

    public static void main(String[] args) throws IOException, InterruptedException {
        new Login();
    }

    public Login() throws IOException, InterruptedException {

        loginForm = Jsoup.connect("https://parent-portland.cascadetech.org/portland/PXP2_Login_Student.aspx?regenerateSessionId=True")
                .method(Connection.Method.GET)
                .userAgent(USER_AGENT)
                .execute(); //This gets the actual data from the website
        Document loginDoc = loginForm.parse(); // this is the document that contains response html


        //We need to get the values for the login form
        Element e = loginDoc.select("input[id=__VIEWSTATE]").first();
        String viewState = e.attr("value");

        e = loginDoc.select("input[id=__EVENTVALIDATION]").first();
        String eventValidation = e.attr("value");


        //We now have all the data needed to fill in the login form and login
        Document doc = Jsoup.connect("https://parent-portland.cascadetech.org/portland/PXP2_Login_Student.aspx?regenerateSessionId=True")
                .data("__VIEWSTATE", viewState)
                .data("__EVENTVALIDATION", eventValidation)
                .data("ctl00$MainContent$username", USER_ID)
                .data("ctl00$MainContent$password", USER_PASSWORD)
                .cookies(loginForm.cookies())
                .post(); //logs in

        String HomePageHtml = doc.toString();

        TimeUnit.SECONDS.sleep(1);
        ParseGradebookUrl StringParserForGradeBookUrl = new ParseGradebookUrl(HomePageHtml);
        String gradeBookUrl = StringParserForGradeBookUrl.createGradeBookUrl();
       Document GradebookPage = GradeBookParse.ConnectToGradesPage(loginForm, gradeBookUrl);
        ImportGradeBookData(GradebookPage);

    }
       public void ImportGradeBookData(Document doc){
            GradeBookOrganizer gradeBookOrganizer = new GradeBookOrganizer();
            CourseDataObject[] Coursearray = gradeBookOrganizer.FillCourseArray(doc);
         //  for (CourseDataObject courseDataObject :Coursearray
         //       ) {
          //     System.out.println(courseDataObject.courseName);
            //   System.out.println(courseDataObject.teacherName);
          //     System.out.println(courseDataObject.roomNumber);
           //    System.out.println(courseDataObject.gradeNumber);
          //     System.out.println(courseDataObject.gradeLetter);
          //     System.out.println(courseDataObject.periodNumber);
         //  }

     }
}
