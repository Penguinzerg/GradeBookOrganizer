import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class GradeBookOrganizer {
    private String[][] gradeBookValue = new String[25][8];

    public GradeBookOrganizer() {

    }
    // Takes the required information on the Gradebook page and puts it into a 2D array

    //Creates an array of the Course data objects and returns it
    public CourseDataObject[] FillCourseArray(Document gradebookPage ){
        Document gradeBookPage = gradebookPage;
        System.out.println(gradeBookPage);
        CourseDataObject[] courseArray = new CourseDataObject[9];
        CourseDataObject courseOne = CreateCourseOne(gradeBookPage);
        courseArray[0] = courseOne;
        CourseDataObject courseTwo = CreateCourseTwo(gradeBookPage);
        courseArray[1] = courseTwo;
        CourseDataObject courseThree = CreateCourseThree(gradeBookPage);
        courseArray[2] = courseThree;
        CourseDataObject courseFour = CreateCourseFour(gradeBookPage);
        courseArray[3] = courseFour;
        CourseDataObject courseFive = CreateCourseFive(gradeBookPage);
        courseArray[4] = courseFive;
        CourseDataObject courseSix = CreateCourseSix(gradeBookPage);
        courseArray[5] = courseSix;
        CourseDataObject courseSeven = CreateCourseSeven(gradeBookPage);
        courseArray[6] = courseSeven;
        CourseDataObject courseEight = CreateCourseEight(gradeBookPage);
        courseArray[7] = courseEight;
        return courseArray;
}
   
    //Following methods organize the data taken from the Gradebook page and organize it into separate courses through the CourseDataObject and return them to FillCourseArray
    private CourseDataObject CreateCourseOne(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(1) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(1) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(1) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(2) > td:nth-child(4) > span.score").text();
        Course.gradeLetter = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(2) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "1";
      //  System.out.println(Course.courseName);
        //System.out.println(Course.teacherName);
      //  System.out.println(Course.roomNumber);
      //  System.out.println(Course.gradeNumber);
       // System.out.println(Course.gradeLetter);
     //   System.out.println(Course.periodNumber);
        return Course;
    }
    private CourseDataObject CreateCourseTwo(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(4) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(4) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(4) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(5) > td:nth-child(4) > span.score").text();
        Course.gradeLetter =  htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(5) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "2";
        return Course;
    }
    private CourseDataObject CreateCourseThree(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(7) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(7) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(7) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(8) > td:nth-child(4) > span.score").text();
        Course.gradeLetter = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(8) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "3";
        return Course;
    }
    private CourseDataObject CreateCourseFour(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(10) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(10) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(10) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(11) > td:nth-child(4) > span.score").text();
        Course.gradeLetter = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(11) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "4";
        return Course;
    }
    private CourseDataObject CreateCourseFive(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(13) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(13) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(13) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(14) > td:nth-child(4) > span.score").text();
        Course.gradeLetter = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(14) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "5";
        return Course;
    }
    private CourseDataObject CreateCourseSix(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(16) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(16) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(16) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(17) > td:nth-child(4) > span.score").text();
        Course.gradeLetter = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(17) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "6";
        return Course;
    }
    private CourseDataObject CreateCourseSeven(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(19) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(19) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(19) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(20) > td:nth-child(4) > span.score").text();
        Course.gradeLetter = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(20) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "7";
        return Course;
    }
    private CourseDataObject CreateCourseEight(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(22) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(22) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(22) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(23) > td:nth-child(4) > span.score").text();
        Course.gradeLetter = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(23) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "8";
        return Course;

    }
}






/*
 for (int i = 0; i < courseRows.size(); i += 1) {
            Element course = courseRows.get(i);
            Elements courseValue = course.select("td");
            for (int j = 0; j < 4  ; j++) {

                String  currentCourseValue = courseValue.text();
                System.out.println(currentCourseValue);
                gradeBookValue[i][j] = currentCourseValue;
            }
            gradeBookValue[i][6] = course.select("span.mark").text();
            gradeBookValue[i][7] = course.select("span.score").text();
        }


  for (int i = 0; i < CourseList.size(); i++) {
            Element value = CourseList.get(i);
            System.out.println("Element: " + value);
        }

        System.out.println(Course.courseName);






 */