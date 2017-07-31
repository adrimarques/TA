package pages

import geb.Page

/*
 Created by joao on 19/05/16.
*/
class StudentConsultPage extends Page {
    static url = "/TA/student/search"

    static at = {
        title ==~ /Search Student/
    }

    def fillStudentSearch(String name, String login){
        $("form").name = name
		$("form").login = login
    }

    def selectSearch(){
        $("input", name: "search").click()
    }

    def selectStudent(String name){
        $("td", name: name).click()
    }

    def boolean findSearchResult(){
        return $("td", fieldValue: "login").isDisplayed()
    }
}
